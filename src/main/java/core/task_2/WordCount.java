package core.task_2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordCount {
    public static void main(String[] args) {
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader("C:\\Users\\AndromedA\\IdeaProjects\\Tasks\\src\\main\\java\\core\\task_2\\text.txt"))){
            String line;
            int counter = 0;

            Map<String,Integer> map = new HashMap<>();

            while((line = bufferedReader.readLine()) != null){
                String words[] = line.split(" ");
                for(String word : words){
                    if(map.containsKey(word)){
                        map.put(word, map.get(word) + 1);
                    }
                    else{
                        map.put(word,1);
                    }
                }
            }


            for(Map.Entry<String,Integer> entry : map.entrySet()){
                System.out.println("Слово " + entry.getKey() + " встречается " + entry.getValue() + " раз");
            }


        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
