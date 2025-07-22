import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;



public class Main {
    private static final String path = "data/input2.txt";
    private static final String ROCK_OPP = "A";
    private static final String PAPER_OPP = "B";
    private static final String SCISSORS_OPP = "C";
    private static final String ROCK_USER = "X";
    private static final String PAPER_USER = "Y";
    private static final String SCISSORS_USER = "Z";

    private static final String LOSE = "X";
    private static final String DRAW = "Y";
    private static final String WIN = "Z";

    private static void partOne(){
        try {
            List<String> list = Files.readAllLines(Paths.get(path));
            int points = 0;
            for (String line: list) {
                String[] lines = line.split(" ");
                switch (lines[0]){
                    case ROCK_OPP:
                        switch (lines[1]){
                            case ROCK_USER:
                                points += 3 + 1;
                                break;
                            case PAPER_USER:
                                points += 6 + 2;
                                break;
                            case SCISSORS_USER:
                                points += 0 + 3;
                                break;
                        }
                        break;
                    case PAPER_OPP:
                        switch (lines[1]){
                            case ROCK_USER:
                                points+= 0 + 1;
                                break;
                            case PAPER_USER:
                                points+= 3 + 2;
                                break;
                            case SCISSORS_USER:
                                points+=6 + 3;
                                break;
                        }
                        break;
                    case SCISSORS_OPP:
                        switch (lines[1]){
                            case ROCK_USER:
                                points+=6 + 1;
                                break;
                            case PAPER_USER:
                                points+=0 + 2;
                                break;
                            case SCISSORS_USER:
                                points+=3 + 3;
                                break;
                        }
                        break;
                }
            }
            System.out.println(points);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void partTwo(){
        try {
            List<String> list = Files.readAllLines(Paths.get(path));
            int points = 0;
            for (String line: list) {
                String[] lines = line.split(" ");
                switch (lines[0]){
                    case ROCK_OPP:
                        switch (lines[1]){
                            case WIN:
                                points += 6 + 2;
                                break;
                            case DRAW:
                                points += 3 + 1;
                                break;
                            case LOSE:
                                points += 0 + 3;
                                break;
                        }
                        break;
                    case PAPER_OPP:
                        switch (lines[1]){
                            case WIN:
                                points += 6 + 3;
                                break;
                            case DRAW:
                                points += 3 + 2;
                                break;
                            case LOSE:
                                points += 0 + 1;
                                break;
                        }
                        break;
                    case SCISSORS_OPP:
                        switch (lines[1]){
                            case WIN:
                                points += 6 + 1;
                                break;
                            case DRAW:
                                points += 3 + 3;
                                break;
                            case LOSE:
                                points += 0 + 2;
                                break;
                        }
                        break;
                }
            }
            System.out.println(points);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        partOne();
        //partTwo();
    }
}