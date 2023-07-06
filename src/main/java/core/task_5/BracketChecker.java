package core.task_5;

import java.util.Stack;

public class BracketChecker {
    public static boolean checkBrackets(String expression) {
        Stack<Character> stack = new Stack<>();
        char[] brackets = expression.toCharArray();

        for (char bracket : brackets) {
            if (bracket == '(') {
                stack.push(bracket);
            } else if (bracket == ')') {
                if (stack.isEmpty() || stack.pop() != '(') {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String[] expressions = {"( ( () ) )", "( ()() )", "( () )()", "()( () )", "()()()", "((())"};

        for (String expr : expressions) {
            if (checkBrackets(expr)) {
                System.out.println("Выражение '" + expr + "' содержит правильные скобки.");
            } else {
                System.out.println("Выражение '" + expr + "' содержит неправильные скобки.");
            }
        }
    }
}
