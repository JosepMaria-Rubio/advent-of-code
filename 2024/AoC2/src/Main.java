import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    private static final String test = "data/test.txt";
    private static final String input = "data/input.txt";

    public static void partOne(List<String> list){
        int safe = 0;
        for (String line: list) {
            String[] levels = line.split(" ");
            ArrayList<Integer> levelList = new ArrayList<>();
            for (String level: levels) {
                levelList.add(Integer.parseInt(level));
            }
            boolean ok = true;
            if(checkSafety(levelList)){
                safe++;
            }
            //System.out.println(Arrays.toString(levels));
        }
        System.out.println("Part 1: " + safe);
    }

    public static void partTwo(List<String> list){
        int safe = 0;
        for (String line: list) {
            String[] levels = line.split(" ");
            ArrayList<Integer> levelList = new ArrayList<>();
            for (String level: levels) {
                levelList.add(Integer.parseInt(level));
            }
            if(checkSafety(levelList)){
                safe++;
            }else{
                for(int i = 0; i < levelList.size(); i++){
                    ArrayList<Integer> copy = (ArrayList<Integer>) levelList.clone();
                    copy.remove(i);
                    if(checkSafety(copy)){
                        safe++;
                        break;
                    };
                }
            }

        }
        System.out.println("Part 2: " + safe);
    }

    public static boolean checkSafety(ArrayList<Integer> levels){
        boolean asc = isAscending(levels.get(0),levels.get(1));
        for(int i = 0; i < levels.size()-1; i++){
            if (asc != isAscending(levels.get(i), levels.get(i+1)) || !isSafeRange(levels.get(i), levels.get(i+1))) {
                return false;
            }
        }
        return true;
    }

    public static boolean isAscending(int n1, int n2){
        return n1>n2;
    }
    public static boolean isSafeRange(int n1, int n2){
        return 0 < Math.abs(n1-n2) && Math.abs(n1-n2) < 4;
    }

    public static void main(String[] args) {
        try {
            List<String> list = Files.readAllLines(Paths.get(input));
            System.out.println("Input size: " + list.size());
            partOne(list);
            partTwo(list);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
