package com.shasu19p.solid_principles;

// Interface Segregation Principle
// YAGNI : You are not going to need it thought in mind.

// Consider one interface is given with Document.

interface Document1 {}

interface Machine1 {
	void print(Document1 doc);
	void fax(Document1 doc);
	void email(Document1 doc);
	void scan(Document1 doc);
}

// Now if we give this to some client Machine interface
// and if client does not support for scan, email and fax,
// then also client need to provide some implementation
class Client1 implements Machine1 {
	
	@Override
	public void print(Document1 doc) {
		System.out.println("Machine is printing");
	}
	
	@Override
	public void fax(Document1 doc) {
		// throw new Exception("Fax is not supported"); 
		// this creates problem for client
		// That is one provided interface and it can't be modified
	}
	
	@Override
	public void email(Document1 doc) {
		
		// consider this return some object
		// client 1 can't handle this request 
		// but interface still need object to return
	}
	
	@Override
	public void scan(Document1 doc) {
		// so let's solve by making smaller interfaces and client will implement as per need
	}
}


public class InterfaceSegregationPrinciple_04_1 {

	public static void main(String[] args) {

	}
}