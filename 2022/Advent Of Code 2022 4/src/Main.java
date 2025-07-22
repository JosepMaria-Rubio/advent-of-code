import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    private static final String path = "data/input.txt";
    private static final String test = "data/test.txt";

    private static boolean checkRange(int start1, int end1, int start2, int end2){
        return (start1 <= start2 && end1 >= start2) && (start1 <= end2 && end1 >= end2) || (start2 <= end1 && end2 >= end1) && (start2 <= start1 && end2 >= start1);
    }

    public static void partOne(List<String> list){
        int vore = 0;
        for (String line: list) {
            String[] assignments = line.split(",");
            String[] assignment1 =  assignments[0].split("-");
            String[] assignment2 =  assignments[1].split("-");
            if(checkRange(Integer.parseInt(assignment1[0]),Integer.parseInt(assignment1[1]),Integer.parseInt(assignment2[0]),Integer.parseInt(assignment2[1]))){
                vore++;
                System.out.println(assignments[0] + " " +  assignments[1] );
            }
        }
        System.out.println(vore);
    }

    public static boolean checkOverlap(int start1, int end1, int start2, int end2){
        return start1 <= end2 && end1 >= start2;
    }

    public static void partTwo(List<String> list){
        int overlap = 0;
        for (String line: list) {
            String[] assignments = line.split(",");
            String[] assignment1 =  assignments[0].split("-");
            String[] assignment2 =  assignments[1].split("-");
            if(checkOverlap(Integer.parseInt(assignment1[0]),Integer.parseInt(assignment1[1]),Integer.parseInt(assignment2[0]),Integer.parseInt(assignment2[1]))){
                overlap++;
                System.out.println(assignments[0] + " " +  assignments[1] );
            }
        }
        System.out.println(overlap);
    }

    public static void main(String[] args) {
        try {
            List<String> list = Files.readAllLines(Paths.get(path));
            partOne(list);
            //partTwo(list);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}