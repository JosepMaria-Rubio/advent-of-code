import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Main {
    private static final String path = "data/input.txt";
    private static final String test = "data/test.txt";

    private static List<String> s;


    public static void main(String[] args) {
        try {
            s = Files.readAllLines(Paths.get(path));
            p2();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void p1(){
        int depth = 0;
        int horizontal = 0;

        for(String s1: s){
            String s2[] = s1.split(" ");
            switch (s2[0]){
                case "forward" -> horizontal += Integer.parseInt(s2[1]);
                case "down" -> depth += Integer.parseInt(s2[1]);
                case "up" -> depth -= Integer.parseInt(s2[1]);
            }
        }

        System.out.println(depth * horizontal);

    }


    public static void p2(){
        int depth = 0;
        int horizontal = 0;
        int aim = 0;

        for(String s1: s){
            String s2[] = s1.split(" ");
            switch (s2[0]){
                case "forward" -> {
                    horizontal += Integer.parseInt(s2[1]);
                    depth += Integer.parseInt(s2[1]) * aim;
                }
                case "down" -> aim += Integer.parseInt(s2[1]);
                case "up" -> aim -= Integer.parseInt(s2[1]);
            }
        }

        System.out.println(depth * horizontal);
    }
}
