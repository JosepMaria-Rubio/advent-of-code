public class Crate {
    private String name;
    private int pos;
    public Crate(char name, int pos){
        this.name = String.valueOf(name);
        this.pos = pos;
    }
    public String getName() {
        return name;
    }

    public int getPos() {
        return pos;
    }

    public void setPos(int pos) {
        this.pos = pos;
    }

    @Override
    public String toString() {
        return name;
    }
}
