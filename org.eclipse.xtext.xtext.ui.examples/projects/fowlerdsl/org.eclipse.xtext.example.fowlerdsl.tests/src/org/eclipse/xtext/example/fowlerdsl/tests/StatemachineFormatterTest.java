/**
 * Copyright (c) 2019, 2021 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.example.fowlerdsl.tests;

import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.testing.formatter.FormatterTestHelper;
import org.eclipse.xtext.testing.formatter.FormatterTestRequest;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.google.inject.Inject;

/**
 * @author miklossy - Initial contribution and API
 */
@RunWith(XtextRunner.class)
@InjectWith(StatemachineInjectorProvider.class)
public class StatemachineFormatterTest {
	@Inject
	private FormatterTestHelper formatterTestHelper;
	
	private static final String NL = System.lineSeparator();

	@Test
	public void events() {
		formatterTestHelper.assertFormatted((FormatterTestRequest it) -> {
			it.setToBeFormatted(
					"events doorClosed D1CL drawerOpened D2OP lightOn L1ON doorOpened D1OP panelClosed PNCL end" + NL);
			it.setExpectation(
					"events" + NL +
					"	doorClosed   D1CL" + NL +
					"	drawerOpened D2OP" + NL +
					"	lightOn      L1ON" + NL +
					"	doorOpened   D1OP" + NL +
					"	panelClosed  PNCL" + NL +
					"end" + NL);
		});
	}

	@Test
	public void commands() {
		formatterTestHelper.assertFormatted((FormatterTestRequest it) -> {
			it.setToBeFormatted("commands unlockPanel PNUL lockPanel NLK lockDoor D1LK unlockDoor D1UL end" + NL);
			it.setExpectation(
					"commands" + NL +
					"	unlockPanel PNUL" + NL +
					"	lockPanel   NLK" + NL +
					"	lockDoor    D1LK" + NL +
					"	unlockDoor  D1UL" + NL +
					"end" + NL);
		});
	}

	@Test
	public void states() {
		formatterTestHelper.assertFormatted((FormatterTestRequest it) -> {
			it.setToBeFormatted(
					"state idle end state active end state waitingForLight end" + NL +
					"state waitingForDrawer end state unlockedPanel end" + NL);
			it.setExpectation(
					"state idle" + NL +
					"end" + NL +
					NL +
					"state active" + NL +
					"end" + NL +
					NL +
					"state waitingForLight" + NL +
					"end" + NL +
					NL +
					"state waitingForDrawer" + NL +
					"end" + NL +
					NL +
					"state unlockedPanel" + NL +
					"end" + NL);
		});
	}

	@Test
	public void resetEvent() {
		formatterTestHelper.assertFormatted((FormatterTestRequest it) -> {
			it.setToBeFormatted(
					"events doorClosed D1CL drawerOpened D2OP lightOn L1ON doorOpened D1OP panelClosed PNCL end" + NL +
					"resetEvents doorOpened end" + NL);
			it.setExpectation(
					"events" + NL +
					"	doorClosed   D1CL" + NL +
					"	drawerOpened D2OP" + NL +
					"	lightOn      L1ON" + NL +
					"	doorOpened   D1OP" + NL +
					"	panelClosed  PNCL" + NL +
					"end" + NL +
					NL +
					"resetEvents" + NL +
					"	doorOpened" + NL +
					"end" + NL);
		});
	}

	@Test
	public void resetEvents() {
		formatterTestHelper.assertFormatted((FormatterTestRequest it) -> {
			it.setToBeFormatted(
					"events doorClosed D1CL drawerOpened D2OP lightOn L1ON doorOpened D1OP panelClosed PNCL end" + NL +
					"resetEvents doorClosed doorOpened end" + NL);
			it.setExpectation(
					"events" + NL +
					"	doorClosed   D1CL" + NL +
					"	drawerOpened D2OP" + NL +
					"	lightOn      L1ON" + NL +
					"	doorOpened   D1OP" + NL +
					"	panelClosed  PNCL" + NL +
					"end" + NL +
					NL +
					"resetEvents" + NL +
					"	doorClosed" + NL +
					"	doorOpened" + NL +
					"end" + NL);
		});
	}

	@Test
	public void events_commands() {
		formatterTestHelper.assertFormatted((FormatterTestRequest it) -> {
			it.setToBeFormatted(
					"events doorClosed D1CL drawerOpened D2OP lightOn L1ON doorOpened D1OP panelClosed PNCL end" + NL +
					"commands unlockPanel PNUL lockPanel NLK lockDoor D1LK unlockDoor D1UL end" + NL);
			it.setExpectation(
					"events" + NL +
					"	doorClosed   D1CL" + NL +
					"	drawerOpened D2OP" + NL +
					"	lightOn      L1ON" + NL +
					"	doorOpened   D1OP" + NL +
					"	panelClosed  PNCL" + NL +
					"end" + NL +
					NL +
					"commands" + NL +
					"	unlockPanel PNUL" + NL +
					"	lockPanel   NLK" + NL +
					"	lockDoor    D1LK" + NL +
					"	unlockDoor  D1UL" + NL +
					"end" + NL);
		});
	}

	@Test
	public void events_state() {
		formatterTestHelper.assertFormatted((FormatterTestRequest it) -> {
			it.setToBeFormatted(
					"events doorClosed D1CL drawerOpened D2OP lightOn L1ON doorOpened D1OP panelClosed PNCL end" + NL +
					"state idle end" + NL);
			it.setExpectation(
					"events" + NL +
					"	doorClosed   D1CL" + NL +
					"	drawerOpened D2OP" + NL +
					"	lightOn      L1ON" + NL +
					"	doorOpened   D1OP" + NL +
					"	panelClosed  PNCL" + NL +
					"end" + NL +
					NL +
					"state idle" + NL +
					"end" + NL);
		});
	}

	@Test
	public void events_resetEvents_commands() {
		formatterTestHelper.assertFormatted((FormatterTestRequest it) -> {
			it.setToBeFormatted(
					"events doorClosed D1CL drawerOpened D2OP lightOn L1ON doorOpened D1OP panelClosed PNCL end" + NL +
					"resetEvents doorOpened end" + NL +
					"commands unlockPanel PNUL lockPanel NLK lockDoor D1LK unlockDoor D1UL end" + NL);
			it.setExpectation(
					"events" + NL +
					"	doorClosed   D1CL" + NL +
					"	drawerOpened D2OP" + NL +
					"	lightOn      L1ON" + NL +
					"	doorOpened   D1OP" + NL +
					"	panelClosed  PNCL" + NL +
					"end" + NL +
					NL +
					"resetEvents" + NL +
					"	doorOpened" + NL +
					"end" + NL +
					NL +
					"commands" + NL +
					"	unlockPanel PNUL" + NL +
					"	lockPanel   NLK" + NL +
					"	lockDoor    D1LK" + NL +
					"	unlockDoor  D1UL" + NL +
					"end" + NL);
		});
	}

	@Test
	public void events_resetEvents_state() {
		formatterTestHelper.assertFormatted((FormatterTestRequest it) -> {
			it.setToBeFormatted(
					"events doorClosed D1CL drawerOpened D2OP lightOn L1ON doorOpened D1OP panelClosed PNCL end" + NL +
					"resetEvents doorOpened end state idle doorClosed => active end" + NL);
			it.setExpectation(
					"events" + NL +
					"	doorClosed   D1CL" + NL +
					"	drawerOpened D2OP" + NL +
					"	lightOn      L1ON" + NL +
					"	doorOpened   D1OP" + NL +
					"	panelClosed  PNCL" + NL +
					"end" + NL +
					NL +
					"resetEvents" + NL +
					"	doorOpened" + NL +
					"end" + NL +
					NL +
					"state idle" + NL +
					"	doorClosed => active" + NL +
					"end" + NL);
		});
	}

	@Test
	public void events_resetEvents_commands_state() {
		formatterTestHelper.assertFormatted((FormatterTestRequest it) -> {
			it.setToBeFormatted(
					"events doorClosed D1CL drawerOpened D2OP lightOn L1ON doorOpened D1OP panelClosed PNCL end" + NL +
					"resetEvents doorOpened end" + NL +
					"commands unlockPanel PNUL lockPanel NLK lockDoor D1LK unlockDoor D1UL end" + NL +
					"state idle actions {unlockDoor lockPanel} doorClosed => active end" + NL);
			it.setExpectation(
					"events" + NL +
					"	doorClosed   D1CL" + NL +
					"	drawerOpened D2OP" + NL +
					"	lightOn      L1ON" + NL +
					"	doorOpened   D1OP" + NL +
					"	panelClosed  PNCL" + NL +
					"end" + NL +
					NL +
					"resetEvents" + NL +
					"	doorOpened" + NL +
					"end" + NL +
					NL +
					"commands" + NL +
					"	unlockPanel PNUL" + NL +
					"	lockPanel   NLK" + NL +
					"	lockDoor    D1LK" + NL +
					"	unlockDoor  D1UL" + NL +
					"end" + NL +
					NL +
					"state idle" + NL +
					"	actions {unlockDoor lockPanel}" + NL +
					"	doorClosed => active" + NL +
					"end" + NL);
		});
	}

	@Test
	public void events_resetEvents_commands_states() {
		formatterTestHelper.assertFormatted((FormatterTestRequest it) -> {
			it.setToBeFormatted(
					"events doorClosed D1CL drawerOpened D2OP lightOn L1ON doorOpened D1OP panelClosed PNCL end" + NL +
					"resetEvents doorOpened end" + NL +
					"commands unlockPanel PNUL lockPanel NLK lockDoor D1LK unlockDoor D1UL end" + NL +
					"state idle actions {unlockDoor lockPanel} doorClosed => active end" + NL +
					"state active drawerOpened => waitingForLight lightOn => waitingForDrawer end" + NL +
					"state waitingForLight lightOn => unlockedPanel end" + NL +
					"state waitingForDrawer drawerOpened => unlockedPanel end" + NL +
					"state unlockedPanel actions {unlockPanel lockDoor} panelClosed => idle end" + NL);
			it.setExpectation(
					"events" + NL +
					"	doorClosed   D1CL" + NL +
					"	drawerOpened D2OP" + NL +
					"	lightOn      L1ON" + NL +
					"	doorOpened   D1OP" + NL +
					"	panelClosed  PNCL" + NL +
					"end" + NL +
					NL +
					"resetEvents" + NL +
					"	doorOpened" + NL +
					"end" + NL +
					NL +
					"commands" + NL +
					"	unlockPanel PNUL" + NL +
					"	lockPanel   NLK" + NL +
					"	lockDoor    D1LK" + NL +
					"	unlockDoor  D1UL" + NL +
					"end" + NL +
					NL +
					"state idle" + NL +
					"	actions {unlockDoor lockPanel}" + NL +
					"	doorClosed => active" + NL +
					"end" + NL +
					NL +
					"state active" + NL +
					"	drawerOpened => waitingForLight" + NL +
					"	lightOn      => waitingForDrawer" + NL +
					"end" + NL +
					NL +
					"state waitingForLight" + NL +
					"	lightOn => unlockedPanel" + NL +
					"end" + NL +
					NL +
					"state waitingForDrawer" + NL +
					"	drawerOpened => unlockedPanel" + NL +
					"end" + NL +
					NL +
					"state unlockedPanel" + NL +
					"	actions {unlockPanel lockDoor}" + NL +
					"	panelClosed => idle" + NL +
					"end" + NL);
		});
	}
}
