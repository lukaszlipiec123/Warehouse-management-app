import java.util.ArrayList;
import java.util.List;

public class Room {
    private static int ID = 0;
    private double space;
    private Person tenant;
    private boolean isReady;
    private List<Object> items = new ArrayList<>();

    Room(double spc){
        this.space = spc;
        ID++;
    }

    Room(double length, double width, double height ){
        this.space = length * width * height;
        ID++;
    }
    //throws TooManyThingsException
    protected void put (Object ob){
//        double zajmowanaPrzestrzen;
//        for (Object obj : items){
//            zajmowanaPrzestrzen += obj.space;
//        }
//        try {
//            if ( zajmowanaPrzestrzen + ob.space > space) throw new TooManyThingsException;
//        } catch (TooManyThingsException){
//            System.out.println("Placeholder")
//        }
        // Klauzula finally?
        items.add(ob);
    }

    protected void pull(Object ob){
        items.remove(ob);
    }
}
