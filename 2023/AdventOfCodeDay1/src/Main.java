import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    public static String test = "data/test.txt";
    public static String input = "data/input.txt";

    public static final String ONE = "one";
    public static final String TWO = "two";

    private static void partOne(List<String> list){
        int sum = 0;

        for (String line: list) {
            String start = "";
            String end = "";
            for (int i = 0; i < line.length(); i++) {
                if (Character.isDigit(line.charAt(i))) {
                    if (start.isBlank()) {
                        start = String.valueOf(line.charAt(i));
                    }
                    end = String.valueOf(line.charAt(i));
                }
            }
            System.out.println(start+end);
            sum += Integer.parseInt(start+end);
        }

        System.out.println(sum);
    }

    private static void isNumber(){
        Map<String,Integer> map = fillMap();
        for (int i = 0; i < map.size(); i++) {

        }
    }

    private static Map<String,Integer> fillMap(){
        Map<String,Integer> map = new HashMap<>();
        map.put("one",1);
        map.put("two",2);
        map.put("three",3);
        map.put("four",4);
        map.put("five",5);
        map.put("six",6);
        map.put("seven",7);
        map.put("eight",8);
        map.put("nine",9);
        return map;
    }
    private static void partTwo(List<String> list){
        int sum = 0;

        for (String line: list) {
            String start = "";
            String end = "";
            for (int i = 0; i < line.length(); i++) {
                if (Character.isDigit(line.charAt(i))) {
                    if (start.isBlank()) {
                        start = String.valueOf(line.charAt(i));
                    }
                    end = String.valueOf(line.charAt(i));
                }
            }
            System.out.println(start+end);
            sum += Integer.parseInt(start+end);
        }

        System.out.println(sum);
    }


    public static void main(String[] args) {
        isNumber();
        try {
            List<String> list = Files.readAllLines(Paths.get(input));
            //partOne(list);


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
