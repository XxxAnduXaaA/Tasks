package core.task_5;

public class brackets {
    public static void generateParentheses(int n) {
        generate("", n, n);
    }

    private static void generate(String current, int leftParentheses, int rightParentheses) {
        if (leftParentheses == 0 && rightParentheses == 0) {
            System.out.println(current);
            return;
        }

        if (leftParentheses > 0) {
            generate(current + "(", leftParentheses - 1, rightParentheses);
        }

        if (rightParentheses > leftParentheses) {
            generate(current + ")", leftParentheses, rightParentheses - 1);
        }
    }

    public static void main(String[] args) {
        int n = 3;
        generateParentheses(n);
    }
}

