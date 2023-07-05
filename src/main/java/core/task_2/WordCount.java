package core.task_2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class WordCount {
    public static void main(String[] args) {

        Map<String,Integer> map = new HashMap<>();

        try(BufferedReader bufferedReader = new BufferedReader(new FileReader("C:\\Users\\AndromedA\\IdeaProjects\\Tasks\\src\\main\\java\\core\\task_2\\text.txt"))){
            String line;

            while((line = bufferedReader.readLine()) != null){
                String words[] = line.split(" ");
                for(String word : words){
                      map.put(word,map.getOrDefault(word, 0) + 1);

                }
            }


        }  catch (IOException e) {
            throw new RuntimeException(e);
        }

        List<Map.Entry<String,Integer>> sortedList = new ArrayList<>(map.entrySet());
        sortedList.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));

        for(Map.Entry<String,Integer> entry : sortedList){

            System.out.println("Слово " + entry.getKey() + " встречается " + entry.getValue() + " раз");
        }


    }
}
