import java.util.ArrayList;
import java.util.Collections;

public class CrateStack {

    private ArrayList<Crate> cstack;

    public CrateStack(){
        cstack = new ArrayList<>();
    }


    public void add(Crate c){
        cstack.add(c);
    }

    public ArrayList<Crate> getCstack() {
        return cstack;
    }

    public void reverse(){
        Collections.reverse(cstack);
    }

    public void push(Crate c, int d){
        c.setPos(d);
        cstack.add(c);
    }
    public Crate pop(){
        if(cstack.isEmpty()){
            return null;
        }
        return cstack.remove(cstack.size()-1);
    }

    public int size(){
        return cstack.size();
    }

}
