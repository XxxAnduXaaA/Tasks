package core.task_12;

public class WordsReverse {
    public static void main(String[] args) {

        String text = "I want to become a Java Ninja!";

        String temp = "";

        char a[] = text.toCharArray();



        for(int i = a.length - 1; i >= 0; i--){
            temp += a[i];
        }

        String b[] = temp.split(" ");
        text = "";

        for (int i = b.length - 1; i >= 0; i--){
            text += b[i] + " ";
        }

        System.out.println(text);

    }
}
