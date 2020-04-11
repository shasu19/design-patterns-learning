package com.shasu19p;

public class HtmlBuilder {

	private String rootName;
	private HtmlElement rootElement = new HtmlElement();

	public HtmlBuilder(String rootName) {

		this.rootName = rootName;
		rootElement.setName(rootName);
	}

	public void addChild(String elemName, String text) {
		rootElement.getChildren().add(new HtmlElement(elemName, text));
	}

	public void clear() {
		rootElement = new HtmlElement(rootName, null);
	}

	public HtmlElement build() {
		return rootElement;
	}
 }