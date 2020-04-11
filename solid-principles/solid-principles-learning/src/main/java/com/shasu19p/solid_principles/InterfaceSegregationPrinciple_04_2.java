package com.shasu19p.solid_principles;

// Interface Segregation Principle
// YAGNI : You are not going to need it thought in mind.

// Consider one interface is given with Document.

class Document2 {
}

interface BasicMachine {
}

interface PrinterMachine2 extends BasicMachine {
	void print(Document2 doc);
}

interface ScanningMachine2 {
	void scan();
}

interface EmailService {
	void email(Document2 d);
}

interface AdvanceMachine extends PrinterMachine2, ScanningMachine2, EmailService {
}

// Now if we give this to some client Machine interface
// and if client does not support for scan, email and fax,
// then also client need to provide some implementation
class Client2 implements PrinterMachine2 {

	@Override
	public void print(Document2 doc) {
		System.out.println("Client2 can handle printing document job");
	}
}

// photo copy machine client
class Client3 implements PrinterMachine2, ScanningMachine2 {

	@Override
	public void scan() {
		System.out.println("Scanning allowed");
	}

	@Override
	public void print(Document2 doc) {
		System.out.println("Printing document");
	}
}

class Client4 implements AdvanceMachine {

	@Override
	public void print(Document2 doc) {
		System.out.println("client4 supports printing document");
	}

	@Override
	public void scan() {
		System.out.println("client4 supports scanning document");
	}

	@Override
	public void email(Document2 d) {
		System.out.println("client4 supports emiling document");
	}
}

public class InterfaceSegregationPrinciple_04_2 {

	private static void executeCommands(BasicMachine machine, Document2 doc) {
		if (machine instanceof PrinterMachine2) {
			((PrinterMachine2) machine).print(doc);
		}

		if (machine instanceof ScanningMachine2) {
			((ScanningMachine2) machine).scan();
		}

		if (machine instanceof AdvanceMachine) {
			((AdvanceMachine) machine).print(doc);
			((AdvanceMachine) machine).scan();
			((AdvanceMachine) machine).email(doc);
		}
	}

	public static void main(String[] args) {

		System.out.println("\n======= Client 2 machine ========");
		executeCommands(new Client2(), null);

		System.out.println("\n======= Client 3 machine ========");
		executeCommands(new Client3(), null);

		System.out.println("\n======= Client 4 machine ========");
		executeCommands(new Client4(), null);
	}
}