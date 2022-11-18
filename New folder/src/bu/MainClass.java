package bu;

import java.util.Stack;

public class MainClass {

	public static void main(String[] args) {
		String testTrue = "(3+2)*8";
		String testFalse = "(((3*2)+8)+5";
		
		System.out.println(BalancedEquation(testTrue));
		System.out.println(BalancedEquation(testFalse));
	}
	public static boolean BalancedEquation(String expression) {
		
		char[] exp = expression.toCharArray();
		Stack<Character> stack = new Stack();
		
		for(int i = 0; i<exp.length; i++) {
			if(exp[i] == '(') {
				stack.push('(');
			}
			if(exp[i] == ')') {
				if(stack.isEmpty()) {
					return false;
				}
				else stack.pop();
			}
		}
		
		if(stack.isEmpty())
			return true;
		else return false;
	}

}
