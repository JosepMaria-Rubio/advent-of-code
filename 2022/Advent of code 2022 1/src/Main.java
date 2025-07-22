import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Main {
    private static final String path = "data/input.txt";


    public static void main(String[] args) {
        // Press Alt+Enter with your caret at the highlighted text to see how
        // IntelliJ IDEA suggests fixing it.
        try {
            List<String> list = Files.readAllLines(Paths.get(path));
            int calories = 0;
            ArrayList<Integer> maxcalories = new ArrayList<>();
            for (String line:list) {
                if (!Objects.equals(line, "")) {
                    //System.out.println(line);
                    calories += Integer.parseInt(line);

                } else {
                    Collections.sort(maxcalories);
                    if(maxcalories.size() < 3){
                        maxcalories.add(calories);
                    }else{
                        if(calories > maxcalories.get(0)){
                            maxcalories.add(calories);
                            maxcalories.remove(0);
                        }
                    }
                    calories = 0;
                }
            }
            calories = 0;
            for (int cal:maxcalories) {
                calories += cal;
            }
            System.out.println(calories);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}