public class Vehicle {
    private String name;
    private double space;

    Vehicle(double spc){
        this.space = spc;
    }

    Vehicle(double length, double width, double height ){
        this.space = length * width * height;
    }

    protected double getSpace(){ return this.space; }
}
