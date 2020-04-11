package com.shasu19p.solid_principles;

import java.security.cert.CertPathValidatorException.Reason;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import lombok.AllArgsConstructor;
import lombok.Data;

// a. high-level modules should not depend on low-level modules
// both should depend on abstraction

// b. Abstraction should not depend on details
// Details should depend on abstraction

enum Relation {
	PARENT, CHILD, SIBLING, SPOUSE
}

@Data
@AllArgsConstructor
class Person5 {
	private String name;
}

@AllArgsConstructor
@Data
class RelationshipContainer {
	private Person5 person1;
	private Relation relation;
	private Person5 person2;
}

@Data
class RelationHolder {
	private List<RelationshipContainer> container = new ArrayList<>();

	public void addParentChildRelation(Person5 parent, Person5 child) {
		container.add(new RelationshipContainer(parent, Relation.CHILD, child));
		container.add(new RelationshipContainer(child, Relation.PARENT, parent));
	}

	public void addSpouseRelation(Person5 husband, Person5 wife) {
		container.add(new RelationshipContainer(husband, Relation.SPOUSE, wife));
		container.add(new RelationshipContainer(wife, Relation.SPOUSE, husband));
	}
}

// high level module depending here on holder implementation
@Data
@AllArgsConstructor
class FilterResearch {
	private RelationHolder holder;

	public List<Person5> findAllChildrenOf(String name) {

		List<Person5> allChildren = holder.getContainer().stream().filter(

				// name of person 1 matched and relation is PARENT
				obj -> Objects.nonNull(name) && Objects.nonNull(obj)
						&& obj.getPerson1().getName().equalsIgnoreCase(name) && Relation.CHILD == obj.getRelation())

				.map(elem -> elem.getPerson2()).collect(Collectors.toList());

		return allChildren;
	}
}

// Getting high module dependency removal from low-level implementation

interface ResearchPopulator {

	public List<Person5> findAllChildrenOf(String name, RelationHolder holder);
}

class RelationHolderAdvance implements ResearchPopulator {

	@Override
	public List<Person5> findAllChildrenOf(String name, RelationHolder holder) {

		List<Person5> allChildren = holder.getContainer().stream().filter(

				// name of person 1 matched and relation is PARENT
				obj -> Objects.nonNull(name) && Objects.nonNull(obj)
						&& obj.getPerson1().getName().equalsIgnoreCase(name) && Relation.CHILD == obj.getRelation())

				.map(elem -> elem.getPerson2()).collect(Collectors.toList());

		return allChildren;

	}
}

public class DependencyInversionPrinciple_05 {

	public static void main(String[] args) {

		Person5 sunil = new Person5("Sunil");
		Person5 sarvagya = new Person5("Sarvagya");
		Person5 pari = new Person5("Pari");
		Person5 kanha = new Person5("Kanha");
		Person5 sunandni = new Person5("Sunandni");

		RelationHolder holder = new RelationHolder();

		// spouse
		holder.addSpouseRelation(sunil, sunandni);

		// children
		holder.addParentChildRelation(sunil, sarvagya);
		holder.addParentChildRelation(sunil, pari);
		holder.addParentChildRelation(sunil, kanha);

		// high-level model depends on low-level module
		System.out.println("======== old approach ========");
		new FilterResearch(holder).findAllChildrenOf("Sunil").forEach(System.out::println);

		// high-level model doesn't depend on low-level module
		System.out.println("======== new approach ========");
		new RelationHolderAdvance().findAllChildrenOf("Sunil", holder).forEach(System.out::println);
	}
}