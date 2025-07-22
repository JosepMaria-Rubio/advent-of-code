import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    private static final String path = "data/input.txt";
    private static final String test = "data/test.txt";

    private static int searchOne (String a, String b){
        for(int i = 0; i < a.length(); i++){
            for(int j = 0; j < b.length(); j++){
                if(a.charAt(i) == b.charAt(j)){
                    if(a.charAt(i) >= 'A' && a.charAt(i) <= 'Z'){
                        return a.charAt(i) - 'A' + 26 + 1;
                    }else {
                        return a.charAt(i) - 'a' + 1;
                    }
                }
            }
        }
        return 0;
    }

    private static void partOne(){
        try {
            List<String> list = Files.readAllLines(Paths.get(test));
            int points = 0;
            for (String line: list) {
                String comp1 = line.substring(0,line.length()/2);
                String comp2 = line.substring(line.length()/2);
                points += searchOne(comp1,comp2);
            }

            System.out.println(points);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static int searchTwo(List<String> group){
        for(int i = 0; i < group.get(0).length(); i++){
            for(int j = 0; j < group.get(1).length(); j++){
                for(int t = 0; t < group.get(2).length(); t++){
                    if(group.get(0).charAt(i) == group.get(1).charAt(j) && group.get(1).charAt(j) == group.get(2).charAt(t)){
                        if(group.get(0).charAt(i) >= 'A' && group.get(0).charAt(i) <= 'Z'){
                            //System.out.println(group.get(0).charAt(i));
                            return group.get(0).charAt(i) - 'A' + 26 + 1;
                        }else {
                            //System.out.println(group.get(0).charAt(i));
                            return group.get(0).charAt(i) - 'a' + 1;
                        }
                    }
                }
            }
        }
        return 0;
    }

    private static void partTwo(){
        try {
            List<String> list = Files.readAllLines(Paths.get(path));
            int points = 0;
            List<String> group = new ArrayList<>();
            int i = 0;
            for (String line: list) {
                if(i < 3){
                    group.add(line);
                    i++;
                }
                if(i == 3){
                    points += searchTwo(group);
                    group.clear();
                    i = 0;
                }
            }

            System.out.println(points);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        partOne();
    }
}