public class Item {
    private String name;
    private double space;
    boolean isPacked;

    Item(String nm, double spc){
        this.space = spc;
        this.name = nm;
    }

    Item(String nm, double length, double width, double height ){
        this.space = length * width * height;
        this.name = nm;
    }

    public String toString(){
        return this.name + " (" + space + ")";
    }

    protected double getSpace(){ return this.space; }

    protected String getName(){ return this.name; }
}
