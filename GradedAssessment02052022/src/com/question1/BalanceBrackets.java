package com.question1;
//Jeyachithra Balaraman-Program for balancing brackets using Stack to print
//              whether the String entered id a Balanced brackes or Unbalanced String
import java.util.Scanner;

import java.util.Stack;

public class BalanceBrackets {
	static boolean checkBalance(String inputString) {
		Stack<Character> stack = new Stack<Character>();
		// If inputString has odd number of brackets it is unbalanced
		if (inputString.length() % 2 != 0) {
			return false;
		}
		//Checking each character in String for opening Brackets and pushing to stack
		for (int i = 0; i < inputString.length(); i++) {
			char character = inputString.charAt(i);
			if (character == '(' || character == '[' || character == '{') {
				stack.push(character);
				continue;
			}
			if (stack.isEmpty())
				return false;
			char c;
			switch (character) {
			case '}':
				c = stack.pop();
				if (c == '(' || c == '[')
					return false;
				break;
			case '(':
				c = stack.pop();
				if (c == '{' || c == '[')
					return false;
				break;
			case ']':
				c = stack.pop();
				if (c == '(' || c == '{')
					return false;
				break;
			}
		}
		return (stack.isEmpty());
	}
// Driver code
	public static void main(String args[]) {
		String inputString = "{[[{}]]}";
		Boolean flag;
		flag = checkBalance(inputString);
		System.out.println("Given String :"+inputString);
		if (flag)
			System.out.println("Is a balanced Brackets String");
		else
			System.out.println("Is an unbalanced String");
	}
}