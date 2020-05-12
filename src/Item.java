public class Item {
    private String name;
    private double space;
    boolean isPacked;

    Item(String nm, double spc, boolean isPacked){
        this.isPacked = isPacked;
        this.name = nm;
        if (isPacked) this.space = spc / 2 ;
        else this.space = spc;
    }

    Item(String nm, double length, double width, double height, boolean isPacked ){
        this.isPacked = isPacked;
        this.space = length * width * height;
        this.name = nm;
        if (isPacked) this.space = (length * width * height) / 2 ;
        else this.space = length * width * height;
    }

    public String toString(){
        return this.name + " (" + space + ")";
    }

    protected double getSpace(){ return this.space; }

    protected String getName(){ return this.name; }

}
