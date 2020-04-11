package com.shasu19p;

public class Demo {

	public static void main(String[] args) {

		HtmlBuilder htmlBuilder = new HtmlBuilder("ul");
		htmlBuilder.addChild("ui", "Hello");
		htmlBuilder.addChild("ui", "World");

		HtmlElement element = htmlBuilder.build();
		System.out.println(element.toString());
	}
}