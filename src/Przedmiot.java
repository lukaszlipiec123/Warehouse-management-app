public class Przedmiot {
    private String name;
    private double space;
    boolean isPacked;

    Przedmiot(double spc){
        this.space = spc;
    }

    Przedmiot( double length, double width, double height ){
        this.space = length * width * height;
    }
}
