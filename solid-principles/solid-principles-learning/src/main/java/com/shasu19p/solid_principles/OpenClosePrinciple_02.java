package com.shasu19p.solid_principles;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import lombok.AllArgsConstructor;
import lombok.Data;

// Open to extension but close for modification
/*

Suppose company is selling many products, of different size, color.
We have to filter the products as per need.
==================================================================================
subh0709sharma
https://www.udemy.com/course/design-patterns-java/learn/lecture/8109050#overview

 * */ 

enum Color {
	RED, GREEN, BLUE
}

enum Size {
	SMALL, MEDIUM, LARGE, HUZE
}

@AllArgsConstructor @Data // All args constructor and getter setters
class Product {
	private String name;
	private Size size;
	private Color color;
}

// This is okay but whenever there is need for any further modification in filter,
// we have to come and make the changes in code
// It means, we need to execute all test cases and do regression testing
// Instead, make this class more generic
class ProductFilter {
	
	public Stream<Product> filterByColor(
			List<Product> products, 
			Color color) {
		return products.stream().filter(p -> p.getColor() == color);
	}
	
	public Stream<Product> filterBySize(
			List<Product> products, 
			Size size) {
		return products.stream().filter(p -> p.getSize() == size);
	}
	
	public Stream<Product> filterByColorAndSize(
			List<Product> products, 
			Size size, Color color) {
		return products
					.stream()
					.filter(
						p -> p.getSize() == size && p.getColor()==color
					);
	}
}


// Making this open for extension and close for modification
// Existing Predicate will also work
// This is a Specification for API creation
interface CustomPredicateFilter<T> {
	boolean isSatisfied(T t);
}

interface Filter <T> {
	public Stream<T> filter(List<T> items, CustomPredicateFilter<T> predicate);
}

@AllArgsConstructor @Data
class SizeFilter implements CustomPredicateFilter<Product> {

	private Size size;
	
	@Override
	public boolean isSatisfied(Product product) {
		return this.size == product.getSize();
	}
}

@AllArgsConstructor @Data
class ColorFilter implements CustomPredicateFilter<Product> {
	
	private Color color;
	
	@Override
	public boolean isSatisfied(Product product) {
		return this.color == product.getColor();
	}
}

@AllArgsConstructor
@Data
class AndFilter<T> implements CustomPredicateFilter<T> {

	CustomPredicateFilter<T> first;
	CustomPredicateFilter<T> second;

	@Override
	public boolean isSatisfied(T t) {
		return first.isSatisfied(t) && second.isSatisfied(t);
	}
}

class BetterFilter implements Filter<Product> {
	
	@Override
	public Stream<Product> filter(List<Product> items, CustomPredicateFilter<Product> predicate) {
		return items.stream().filter(item -> predicate.isSatisfied(item));
	}
}



public class OpenClosePrinciple_02 {

	public static void main(String[] args) {
		Product p1 = new Product("Apple", Size.MEDIUM, Color.GREEN);
		Product p2 = new Product("House", Size.HUZE, Color.BLUE);
		Product p3 = new Product("Mobile", Size.MEDIUM, Color.GREEN);
		Product p4 = new Product("Screen", Size.LARGE, Color.GREEN);

		List<Product> products = Arrays.asList(p1, p2, p3, p4);

		ProductFilter pf = new ProductFilter();
		System.out.println("\n===== Green products (old)=========");
		pf.filterByColor(products, Color.GREEN).forEach(System.out::println);
		
		System.out.println("\n=========== Huze products (old)========");
		pf.filterBySize(products, Size.HUZE).forEach(System.out::println);
		
		System.out.println("\n=========== Medium Green products (old)========");
		pf.filterByColorAndSize(
				products, Size.MEDIUM, Color.GREEN)
			.forEach(System.out::println);
		
		System.out.println("======= Better filtering =========");
		BetterFilter bf = new BetterFilter();
		System.out.println("\n===== Green products (new)=========");
		bf.filter(products, new ColorFilter(Color.GREEN)).forEach(System.out::println);
		
		System.out.println("\n=========== Huze products (new)========");
		bf.filter(products, new SizeFilter(Size.HUZE)).forEach(System.out::println);
		
		System.out.println("\n=========== Medium Green products (new)========");
		bf.filter(products, 
				new AndFilter(new ColorFilter(Color.GREEN), new SizeFilter(Size.MEDIUM)))
		.forEach(System.out::println);
	}
}
