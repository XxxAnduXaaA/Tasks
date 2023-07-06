package core.task_8;

import java.util.Arrays;
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

        Set<String> uniqueWords = new HashSet<>(Arrays.asList(text.split(" ")));
        String result = String.join(" ", uniqueWords);

        System.out.println(result);

    }
}
