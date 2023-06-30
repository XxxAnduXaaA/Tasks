package core.task_3;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Sorting {

    public static void main(String[] args) {

       String country;
       String region;
       String city;
       String street;
       String house;
       String apartment;


        try(BufferedReader bufferedReader = new BufferedReader(new FileReader("C:\\Users\\Администратор\\IdeaProjects\\FirstTask\\src\\main\\java\\core.task_3\\addresses.txt"))){
            String line;
            int counter = 0;



            while((line = bufferedReader.readLine()) != null){
                String words[] = line.split(" ");
                for(String word : words){
                    counter++;
                }
            }
            System.out.println("Слов в текстовом файле: " + counter);


        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
