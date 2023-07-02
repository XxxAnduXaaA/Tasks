package core.task_8;

import java.util.HashSet;
import java.util.Set;

public class Undublicate {

    public static void main(String[] args) {

        String text = "one two three four" +
                " five six seven eight one two " +
                "three four five six seven eight " +
                "one two three four five six seven " +
                "eight one two three four five six " +
                "seven eight one two three four five" +
                " six seven eight ";

        String temp[] = text.split(" ");
        text = null;
        text = "";

        Set<String> set = new HashSet<>();

        for (String word : temp){
           set.add(word);

        }

        for (String word : set){

            text += word + " ";
        }

        System.out.println(text);

    }
}
