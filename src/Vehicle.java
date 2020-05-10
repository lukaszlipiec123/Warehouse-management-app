public class Vehicle {
    private String name;
    private double space;

    Vehicle(String nm, double spc){
        this.name = nm;
        this.space = spc;
    }

    protected double getSpace(){ return this.space; }

    public String toString(){
        return this.name + " (" + space + ")";
    }

    protected String getName(){ return this.name; }
}
