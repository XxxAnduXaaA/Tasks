package core.task_3;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Sorting {

    public static void main(String[] args) {

        List <String> country = new ArrayList<>(); //1
        List <String> region = new ArrayList<>(); //3
        List <String> city = new ArrayList<>(); //5
        List <String> street = new ArrayList<>(); //7
        List <String> house = new ArrayList<>(); //9
        List <String> apartment = new ArrayList<>(); //11


        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("C:\\Users\\Администратор\\IdeaProjects\\FirstTask\\src\\main\\java\\core\\task_3\\addresses.txt"))) {
            String line;
            int counter = 0;
            Map<String, String> map = new HashMap<>();


            while ((line = bufferedReader.readLine()) != null) {
                if(!line.equals("")){
                    String words[] = line.replaceAll(",", ":").split(":");
                    country.add(words[1]);
                    region.add(words[3]);
                    city.add(words[5]);
                    street.add(words[7]);
                    house.add(words[9]);
                    apartment.add(words[11]);
                }

            }

            for (String word : apartment){
                System.out.println(word);
            }

            System.out.println("\n \n"); 

            Arrays.sort(new List[]{apartment});

            for (String word : apartment){
                System.out.println(word);
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
