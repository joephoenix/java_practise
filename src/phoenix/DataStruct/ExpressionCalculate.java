package phoenix.DataStruct;

import phoenix.DataStruct.Stack.Stack;

public class ExpressionCalculate {

	Stack<Character> operation = new Stack<Character>();
	Stack<Double> values = new Stack<Double>();

	public Double calculate(Character[] expression) {
		for (Character o : expression) {
			if (o.equals('(')) {

			} else if (o.equals('+')) {
				operation.push(o);
			} else if (o.equals('*')) {
				operation.push(o);
			} else if (o.equals(')')) {
				Character op = operation.pop();
				if (op.equals('+')) {
					values.push(values.pop() + values.pop());
				} else if (op.equals('*')) {
					values.push(values.pop() * values.pop());
				}
			} else {
				values.push(Double.parseDouble(o.toString()));
			}
		}
		return values.pop();
	}

	public static void main(String[] args) {
		char[] question = "((3+4)*5+5*6+(1+3)*(2+5))".toCharArray();
		Character[] express = new Character[question.length];
		int index = 0;
		for (char c : question) {
			express[index] = c;
			index++;
		}
		System.out.println(new ExpressionCalculate().calculate(express)
				.toString());
	}
}
