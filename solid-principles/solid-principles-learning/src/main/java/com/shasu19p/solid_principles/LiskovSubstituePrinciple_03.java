package com.shasu19p.solid_principles;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// Design : Liskov
// Child class can be substitute by super class 
// and everything should work fine

/*
 Rectangle class has width and height and it can be different.
 Square class has width and height but both are equal.
 * */

@AllArgsConstructor
@NoArgsConstructor
@Data
class Rectangle {
	private int width;
	private int height;

	public int area() {
		return this.width * height;
	}
}

@NoArgsConstructor
class Square1 extends Rectangle {

	public Square1(int size) {
		super(size, size);
	}

	public void setHeight(int height) {
		super.setHeight(height);
		super.setWidth(height);
	}

	public void setWidth(int width) {
		super.setHeight(width);
		super.setWidth(width);
	}
}

public class LiskovSubstituePrinciple_03 {

	public static void useIt(Rectangle rect) {
		int width = rect.getWidth();
		rect.setWidth(10);
		System.out.println("Expected (" + (width * 10) + ") and got (" + rect.area() + ")");
	}

	public static void main(String[] args) {

		Rectangle r1 = new Rectangle(10, 10);
		useIt(r1); // Expected (100) and got (100)

		Rectangle s1 = new Square1(5);
		useIt(s1); // Expected (50) and got (100)

	}
}