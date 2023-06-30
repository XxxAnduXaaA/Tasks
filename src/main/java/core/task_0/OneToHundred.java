package core.task_0;

public class OneToHundred {




    public static void main(String[] args) {



        for(int i = 0; i < 101; i++){

            String text = "";

            text += i % 3 == 0 ? "Fizz" : "";

            text += i % 5 == 0 ? "Buzz" : "";

            if(text.isEmpty()){
                text = i + "";
            }

            System.out.println(text);
        }
    }
}
