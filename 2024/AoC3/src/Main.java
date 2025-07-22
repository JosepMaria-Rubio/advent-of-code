import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static final String regex = "mul\\((\\d{1,3}),(\\d{1,3})\\)";
    public static final String regexDo = "do\\(\\)";
    public static final String regexDont = "don't\\(\\)";
    private static final String test = "data/test.txt";
    private static final String input = "data/input.txt";

    public static void partOne(List<String> list){
        int result = 0;
        for(String line : list) {
            result += parseString(line);
            findDo(line);
            findDont(line);
        }
        System.out.println(result);
    }

    public static int parseString(String line){
        int result = 0;
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(line);
        while (matcher.find()) {
            String num1 = matcher.group(1);
            String num2 = matcher.group(2);
            result += Integer.parseInt(num1) * Integer.parseInt(num2);
        }
        return result;
    }

    public static void partTwo(List<String> list){
        int result = 0;
        for(String fullline : list) {
            System.out.println("Linea. ");
            List<String> lines = separateLine(fullline,findDo(fullline),findDont(fullline));
            for (String line: lines){
                result += parseString(line);
            }
        }
        System.out.println(result);
    }



    public static ArrayList<Integer> findDo(String line){
        ArrayList<Integer> foundDo = new ArrayList<>();
        Pattern pattern = Pattern.compile(regexDo);
        Matcher matcher = pattern.matcher(line);
        while (matcher.find()) {
            String match = matcher.group();
            foundDo.add(line.indexOf(match, line.indexOf(match)+foundDo.size()) + 4);
        }
        System.out.println("Do: " + foundDo.size());
        return foundDo;
    }
    public static ArrayList<Integer> findDont(String line){
        ArrayList<Integer> foundDont = new ArrayList<>();
        Pattern pattern = Pattern.compile(regexDont);
        Matcher matcher = pattern.matcher(line);
        while (matcher.find()) {
            String match = matcher.group();
            foundDont.add(line.indexOf(match, line.indexOf(match) + foundDont.size()));
        }
        System.out.println("Dont: " + foundDont.size());
        return foundDont;
    }

    public static List<String> separateLine(String line,List<Integer> findDo, List<Integer> findDont){
        List<String> okList = new ArrayList<>();
        if(findDont.isEmpty()){
            okList.add(line);
            return okList;
        }
        okList.add(line.substring(0,findDont.get(0)));
        for(int i = 0; i < findDo.size(); i++){
            for(int j = 0;j < findDont.size(); j++){
                if(findDo.get(i) > findDont.get(j)){
                    if(findDont.size() > j + 1 && findDo.get(i) < findDont.get(j + 1)){
                        okList.add(line.substring(findDo.get(i),findDont.get(j+1)));
                    }
                    else{
                        okList.add(line.substring(findDo.get(i)));
                    }
                }
            }
        }
        return okList;
    }

    public static void main(String[] args) {
        try {
            List<String> list = Files.readAllLines(Paths.get(test));
            System.out.println("Input size: " + list.size());
            //  9815106
            // 25260824
            //463127640
            //535955216
            //partOne(list);
            partTwo(list);
        } catch (
                IOException e) {
            throw new RuntimeException(e);
        }
    }

}
