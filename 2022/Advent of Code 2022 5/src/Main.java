import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {

    private static final String path = "data/input.txt";
    private static final String test = "data/test.txt";


    private static String separateList(List<String> list){
        for(String line: list){
            if(line.equals("")){
                return line;
            }
        }
        return null;
    }

    private static CrateStack[] parseCrane(List<String> crane){
        ArrayList<Crate> cstack = new ArrayList();
        int num_stacks = 0;
        for (String crates: crane) {
            for(int i = 0; i < crates.length(); i++){
                if(crates.charAt(i) >= 'A' && crates.charAt(i) <= 'Z'){
                    Crate c = new Crate(crates.charAt(i), i/4);
                    cstack.add(c);
                }
                if(crates.charAt(i) >= '1' && crates.charAt(i) <= '9'){
                    num_stacks++;
                }
            }
        }
        CrateStack[]  crateStacks = new CrateStack[num_stacks];
        for(int i = 0; i < num_stacks; i++){
            crateStacks[i] =new CrateStack();
        }
        for(Crate crate: cstack){
            crateStacks[crate.getPos()].add(crate);
        }
        for(int i = 0; i < num_stacks; i++){
            crateStacks[i].reverse();
        }
        return crateStacks;
    }

    private static void parseMove(CrateStack[] crateStacks, List<String> move){
        for (String line: move) {
            String[] lines = line.split(" ");
            moveOne(Integer.parseInt(lines[1]), Integer.parseInt(lines[3])-1, Integer.parseInt(lines[5])-1, crateStacks );
            //moveTwo(Integer.parseInt(lines[1]), Integer.parseInt(lines[3])-1, Integer.parseInt(lines[5])-1, crateStacks );
        }
    }

    private static void moveOne(int num, int o, int d, CrateStack[] crateStacks){
        for(int i = 0; i < num; i++){
            crateStacks[d].push(crateStacks[o].pop(), d);
        }
    }

    private static void moveTwo(int num, int o, int d, CrateStack[] crateStacks){
        CrateStack aux = new CrateStack();
        for(int i = 0; i < num; i++){
            aux.push(crateStacks[o].pop(), d);
        }
        aux.reverse();
        for (Crate c: aux.getCstack()) {
            crateStacks[d].push(c,d);
        }
    }

    private static void showCrane(CrateStack[] crateStacks){
        int stacksize = 0;
        for(int i = 0; i < crateStacks.length; i++){
            if(crateStacks[i].size() > stacksize){
                stacksize = crateStacks[i].size();
            }
        }

        for (int i = 0; i < stacksize; i++){
            for(int j = 0; j < crateStacks.length; j++){
                if(crateStacks[j].size() >= stacksize - i ){
                    System.out.print("[" + crateStacks[j].pop().getName() + "]");
                }else {
                    System.out.print("   ");
                }
            }
            System.out.println();
        }
    }

    private static void initalizeClone(CrateStack[] crateStacks){
        for(int i = 0; i < crateStacks.length; i++){
            crateStacks[i] = new CrateStack();
        }
    }

    private static void makeClone(CrateStack[] original, CrateStack[] clone){
        for(int i = 0; i < clone.length; i++){
            for(Crate crate: original[i].getCstack()){
                clone[i].add(new Crate(crate.getName().charAt(0), crate.getPos()));
            }
        }
    }

    public static void main(String[] args) {
        try {
            List<String> list = Files.readAllLines(Paths.get(path));
            int a = list.indexOf(separateList(list));
            List<String> crane = list.subList(0,a);
            List<String> move = list.subList(a+1, list.size());
            CrateStack[] crateStack = parseCrane(crane);
            CrateStack[] clone = new CrateStack[crateStack.length];
            initalizeClone(clone);
            makeClone(crateStack,clone);
            showCrane(clone);
            System.out.println();
            parseMove(crateStack, move);
            initalizeClone(clone);
            makeClone(crateStack,clone);
            showCrane(clone);



            for (int i = 0; i < crateStack.length; i++) {
                System.out.print(crateStack[i].pop().toString());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}