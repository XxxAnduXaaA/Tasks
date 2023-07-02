package core.task_1;

public class Factorial {

    static long fact(long n){

        if(n == 0){
            return 1;
        }

       long result = 1;

        while (n > 0){
            result *= n;
            n--;
        }

        return result;
    }
    public static void main(String[] args) {

        System.out.println(fact(20));

    }
}
