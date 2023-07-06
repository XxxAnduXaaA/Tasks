package core.task_9;

import java.util.HashMap;
import java.util.Map;

public class CharCount {
    public static void main(String[] args) {

        String text = "AAAABBBCCXYZDDDDEEEFFFAAAAAABBBBBBBBBBBBBBBBBBBBBBBBBBBB";

        Map<Character, Integer> map = new HashMap<>();

        for(char c : text.toCharArray()){
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        text = null;
        text = "";

        for (Map.Entry<Character, Integer> entry: map.entrySet()){
            text += entry.getKey();
            if(entry.getValue() != 1) {
                text += entry.getValue();
            }
        }

        System.out.println(text);

    }
}
