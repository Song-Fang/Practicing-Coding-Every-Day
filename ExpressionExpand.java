package com.algorimthms;

import java.util.Stack;

public class ExpressionExpand {
	public static void main(String[] args) {
		String s = "abc5[io]cd";
		ExpressionExpandSolution ees = new ExpressionExpandSolution();
		System.out.println(ees.expressExpand(s));
		
	}
}

class Element {
	int number;
	String str;

	public Element(int number) {
		this.number = number;
	}

	public Element(String str) {
		this.str = str;
	}
}

class ExpressionExpandSolution {
	public String expressExpand(String s) {
		Stack<Element> stack = new Stack<Element>();
		int number = 0;
		for (char c : s.toCharArray()) {
			if (Character.isDigit(c)) {
				number = number * 10 + c - '0';
			} else if (c == '[') {
				stack.push(new Element(number));
				number = 0;
			} else if (c == ']') {
				String newStr = popStack(stack);
				Element ele = stack.pop();
				for (int i = 0; i < ele.number; i++) {
					stack.push(new Element(newStr));
				}
			} else {
				stack.push(new Element(String.valueOf(c)));
			}
		}
		return popStack(stack);
	}

	private String popStack(Stack<Element> stack) {
		Stack<String> buffer = new Stack<String>();
		while (!stack.isEmpty() && stack.peek().str != null) {
			buffer.push(stack.pop().str);
		}

		StringBuilder sb = new StringBuilder();

		while (!buffer.isEmpty()) {
			sb.append(buffer.pop());
		}

		return sb.toString();
	}
}
