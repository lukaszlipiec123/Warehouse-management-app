public class Motorcycle extends Vehicle {
    private boolean hasApproval;

    Motorcycle(String name, double spc, boolean approval){
        super(name, spc);
        hasApproval = approval;
    }

}
