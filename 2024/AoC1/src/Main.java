import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class Main {
    private static final String test = "data/test.txt";
    private static final String input = "data/input.txt";

    public static void partOne(ArrayList<Integer> leftList, ArrayList<Integer> rightList){
        int distance = 0;
        for(int i = 0; i < leftList.size(); i++){
            distance += Math.abs(leftList.get(i) - rightList.get(i));
        }
        System.out.println(distance);
    }

    public static void partTwo(ArrayList<Integer> leftList, ArrayList<Integer> rightList){
        int[] appearances = new int[leftList.size()];
        for (int i = 0; i < appearances.length; i++){
            for (Integer integer : rightList) {
                if (Objects.equals(leftList.get(i), integer)) {
                    appearances[i]++;
                }
            }
        }
        int result = 0;
        for (int i = 0; i < appearances.length; i++) {
            result += appearances[i] * leftList.get(i);
        }
        System.out.println(result);
    }

    public static void main(String[] args) {
        try {
            ArrayList<Integer> leftList = new ArrayList<>();
            ArrayList<Integer> rightList = new ArrayList<>();
            List<String> list = Files.readAllLines(Paths.get(input));
            for (String line: list) {

                String[] lines = line.split("\\s+");
                leftList.add(Integer.parseInt(lines[0]));
                rightList.add(Integer.parseInt(lines[1]));
            }
            Collections.sort(leftList);
            Collections.sort(rightList);
            partOne(leftList,rightList);
            partTwo(leftList,rightList);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
