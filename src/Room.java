import java.util.ArrayList;
import java.util.List;



public class Room {
    private static int ID = 0;
    private String name;
    private final double space;
    private double spaceTaken = 0;
    private Person tenant;
    private boolean isReady;
    private List<Item> items = new ArrayList<>();
    private List<Vehicle> vehicles = new ArrayList<>();


    Room(String name, double spc){
        this.name = name;
        this.space = spc;
        ID++;
    }


    Room(String name, double length, double width, double height ){
        this.name = name;
        this.space = length * width * height;
        ID++;
    }


    protected void put (Item it) {
        if (spaceTaken > space) {
            try {
                if(spaceTaken > space){
                    throw new TooManyThingsException("Placeholder");
                    } else{
                    items.add(it);
                }
                } catch (TooManyThingsException e){
                System.out.println("Nie ma miejsca na umieszczenie tego przedmiotu! Przedmiot nie został umieszczony");
            }
        }
        calculateSpaceTaken();
    }


    protected void put (Vehicle vh) {
        if (spaceTaken > space) {
            try {
                if(spaceTaken > space){
                    throw new TooManyThingsException("Placeholder");
                } else {
                    vehicles.add(vh);
                }
            } catch (TooManyThingsException e){
                System.out.println("Nie ma miejsca na umieszczenie tego przedmiotu! Przedmiot nie został umieszczony");
            }
        }
        calculateSpaceTaken();
    }


    private void calculateSpaceTaken(){
        double spaceTaken = 0.0;
        for (Item item : items) {
            spaceTaken += item.getSpace();
        }
        for (Vehicle vehicle : vehicles) {
            spaceTaken += vehicle.getSpace();
        }
        this.spaceTaken = spaceTaken;
    }


    protected void pull(Item it){
        items.remove(it);
        calculateSpaceTaken();
    }

    protected void pull(Vehicle vh){
        items.remove(vh);
        calculateSpaceTaken();
    }

    protected void setTenant(Person p){
        this.tenant = p;
    }

    protected Person getTenant(){
        return this.tenant;
    }

    public String toString() {
        return this.name;
    }


}
