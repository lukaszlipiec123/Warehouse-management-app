public class Item {
    private String name;
    private double space;
    boolean isPacked;

    Item(double spc){
        this.space = spc;
    }

    Item(double length, double width, double height ){
        this.space = length * width * height;
    }

    protected double getSpace(){ return this.space; }
}
