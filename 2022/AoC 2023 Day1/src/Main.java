import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;



public class Main {

    private static final String path = "data/input.txt";
    private static final String test = "data/test.txt";
    private static final String test2 = "data/test2.txt";

    private static void changeEnum(String num){
        switch (num){
            case "one":
                num = "1";
                break;
            case "two":
                num = "2";
                break;
            case "three":
                num = "3";
                break;
            case "four":
                num = "4";
                break;
            case "five":
                num = "5";
                break;
            case "six":
                num = "6";
                break;
            case "seven":
                num = "7";
                break;
            case "eight":
                num = "8";
                break;
            case "nine":
                num = "9";
                break;
        }
    }

    public static void main(String[] args) {
        // Press Alt+Enter with your caret at the highlighted text to see how
        // IntelliJ IDEA suggests fixing it.
        try {
            List<String> list = Files.readAllLines(Paths.get(test2));
            String start, end = new String();
            int calibration = 0;
            for (String line: list ) {
                start = "a";
                for(int i = 0; i < line.length(); i++) {
                    if(Character.isDigit(line.charAt(i))) {
                        if(start.equals("a")) {
                            start = String.valueOf(line.charAt(i));
                        }
                        end = String.valueOf(line.charAt(i));
                    }
                }
                calibration+= Integer.parseInt(start+end);
            }

            System.out.println(calibration);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}