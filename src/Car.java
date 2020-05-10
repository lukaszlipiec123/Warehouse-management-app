public class Car extends Vehicle {
    private String fuelType;

    Car(String nm, double spc, String fuelType){
        super(nm, spc);
        this.fuelType = fuelType;
    }

}
