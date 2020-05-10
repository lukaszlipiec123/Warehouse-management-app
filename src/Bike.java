public class Bike extends Vehicle {
    private int amountOfDerailleurs;

    Bike(String name, double spc, int derailleurs){
        super(name, spc);
        amountOfDerailleurs = derailleurs;
    }

}
