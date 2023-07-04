package core.task_1;

import java.util.Scanner;

public class Factorial {

    static long factorial (long n){
        return factorialHelper(n,1);
    }

    static long factorialHelper(long n, long acc){
        if (n == 0){
            return acc;
        }

        else{
            return factorialHelper(n - 1,acc * n);
        }
    }
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        long num = scanner.nextLong();

        System.out.println(factorial(num));

    }
}
