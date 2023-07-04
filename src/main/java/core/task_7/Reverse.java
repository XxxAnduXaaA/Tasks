package core.task_7;


//можно просто через Integer заревёрсить


public class Reverse {

    static int reverse(int n){

        String num = n + "";
        String temp[] = num.split("");
        String fin = "";

        for(int i = temp.length - 1; i >= 0; i-- ){
            fin += temp[i];
        }


        return Integer.parseInt(fin);

    }

    public static void main(String[] args) {
        System.out.println(reverse(100));
    }
}
