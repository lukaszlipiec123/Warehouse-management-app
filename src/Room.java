import java.util.ArrayList;
import java.util.List;



public class Room {
    private static int countID = 1;
    private int ID;
    private String name;
    private final double space;
    private double spaceTaken = 0;
    private Person tenant;
    private boolean isReady;
    protected List<Item> items = new ArrayList<>();
    protected List<Vehicle> vehicles = new ArrayList<>();


    Room(String name, double spc){
        ID = countID;
        this.name = name;
        this.space = spc;
        countID++;
    }


    Room(String name, double length, double width, double height ){
        ID = countID;
        this.name = name;
        this.space = length * width * height;
        countID++;
    }


    protected void put (Item it) {
        try {
            if(spaceTaken > space){
                throw new TooManyThingsException();
                } else {
                items.add(it);
                System.out.println("Dodano przedmiot " + it.getName());
                calculateSpaceTaken();
                }
            } catch (TooManyThingsException e){
            System.out.println("Nie ma miejsca na umieszczenie tego przedmiotu! Przedmiot nie został umieszczony");
        }
    }


    protected void put (Vehicle vh) {
        try {
            if(spaceTaken > space){
                throw new TooManyThingsException();
            } else {
                vehicles.add(vh);
                System.out.println("Dodano pojazd " + vh.getName());
                calculateSpaceTaken();
            }
        } catch (TooManyThingsException e){
            System.out.println("Nie ma miejsca na umieszczenie tego pojazdu! Pojazd nie został umieszczony");
        }
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


    protected boolean pull(Item it){
        boolean removed = items.remove(it);
        if(removed){ System.out.println("Usunięto " + it.getName()); }
        calculateSpaceTaken();
        return removed;
    }

    protected boolean pull(Vehicle vh){
        boolean removed = items.remove(vh);
        if(removed){ System.out.println("Usunięto " + vh.getName()); }
        calculateSpaceTaken();
        return removed;
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

    protected String getId(){
        return Integer.toString(ID);
    }

    protected void listRented(){
        for(Item it : items){
            System.out.println(it);
        }
        for(Vehicle vh : vehicles){
            System.out.println(vh);
        }
    }

}
