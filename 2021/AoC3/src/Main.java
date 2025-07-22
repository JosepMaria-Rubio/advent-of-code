import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Main {

    private static final String path = "data/input.txt";
    private static final String test = "data/test.txt";

    private static ArrayList<String> s;

    public static void main(String[] args) {
        try {
            s = (ArrayList<String>) Files.readAllLines(Paths.get(test));
            p2();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void p1(){
        int one = 0;
        int zero = 0;
        StringBuilder gamma = new StringBuilder();
        StringBuilder epsilon = new StringBuilder();

        for(int i = 0; i < s.get(0).length(); i++){
            one = 0;
            zero = 0;
            for(String s1: s){
                if(s1.charAt(i) == '1'){
                    one++;
                }else {
                    zero++;
                }
            }
            if(one > zero){
                gamma.append('1');
                epsilon.append('0');
            }else {
                gamma.append('0');
                epsilon.append('1');
            }
        }
        int gamma1 = 0;
        for(int i = 0; i < gamma.length() ; i++){
            gamma1 += Math.pow(2,gamma.length()-1-i) * Integer.parseInt(String.valueOf(gamma.charAt(i)));
        }

        int epsilon1 = 0;
        for(int i = 0; i < epsilon.length() ; i++){
            epsilon1 += Math.pow(2,epsilon.length()-1-i) * Integer.parseInt(String.valueOf(epsilon.charAt(i)));
        }
        System.out.println(gamma1 * epsilon1);
    }

    public static void p2(){
        int one;
        int zero;
        ArrayList<String> o2 = (ArrayList<String>) s.clone();
        ArrayList<String> co2 = (ArrayList<String>) s.clone();

        for(int i = 0; i < s.get(0).length(); i++){
            one = 0;
            zero = 0;
            for(String s1: s){
                if(s1.charAt(i) == '1'){
                    one++;
                }else {
                    zero++;
                }
            }
            if(one >= zero){
                for(int j = 0; i < o2.size(); j++){
                    if(o2.get(j).charAt(i) == '0'){
                        o2.remove(j);
                    }
                }
                for (int j = 0; i < co2.size(); j++){
                    if(co2.get(j).charAt(i) == '1'){
                        co2.remove(j);
                    }
                }
            }else {
                for(int j = 0; i < o2.size(); j++){
                    if(o2.get(j).charAt(i) == '1'){
                        o2.remove(j);
                    }
                }
                for (int j = 0; i < co2.size(); j++){
                    if(co2.get(j).charAt(i) == '0'){
                        co2.remove(j);
                    }
                }
            }
        }
        System.out.println(o2);
        System.out.println(co2);
    }
}
