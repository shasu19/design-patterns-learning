package com.shasu19p;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

import lombok.Data;

@Data
public class HtmlElement {

	private String name, text;
	private List<HtmlElement> children;

	public HtmlElement() {
		children = new ArrayList<>();
	}

	public HtmlElement(String name, String text) {
		this.name = name;
		this.text = text;
		children = new ArrayList<>();
	}

	private final int indentSize = 2;
	private final String newLine = System.lineSeparator();

	private String toStringHelperImpl(int indent) {

		StringBuilder builder = new StringBuilder();
		String i = String.join("", Collections.nCopies((indentSize * indent), " "));
		builder.append(String.format("%s<%s>%s", i, name, newLine));

		if (Objects.nonNull(text) && !text.isEmpty()) {
			builder.append(String.join("", Collections.nCopies((indentSize * (indent + 1)), " "))).append(text)
					.append(newLine);
		}

		for (HtmlElement elem : children)
			builder.append(elem.toStringHelperImpl(indent + 1));

		builder.append(String.format("%s</%s>%s", i, name, newLine));

		return builder.toString();
	}

	@Override
	public String toString() {
		return toStringHelperImpl(0);
	}
}