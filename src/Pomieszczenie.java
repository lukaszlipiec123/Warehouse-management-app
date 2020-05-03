import java.util.ArrayList;
import java.util.List;

public class Pomieszczenie {
    private static int ID = 0;
    private double space;
    private Osoba tenant;
    private boolean isReady;
    private List<Object> items = new ArrayList<>();

    Pomieszczenie(double spc){
        this.space = spc;
        ID++;
    }

    Pomieszczenie( double length, double width, double height ){
        this.space = length * width * height;
        ID++;
    }

    protected void put(Object ob){
        items.add(ob);
    }

    protected void pull(Object ob){
        items.remove(ob);
    }
}
