import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Main {
    private static final String path = "data/input.txt";
    private static final String test = "data/test.txt";

    public static void main(String[] args) {
        try {
            List<String> s = Files.readAllLines(Paths.get(path));
            int count = 0;
            int previous = Integer.MAX_VALUE;
            for(String s1: s){
                if(Integer.parseInt(s1) > previous){
                    count++;
                }
                previous = Integer.parseInt(s1);
            }

            System.out.println(count);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
