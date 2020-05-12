import java.util.*;
import java.time.LocalDate;

public class Person {
    List<Room> rentedRooms = new ArrayList<>();
    private String name;
    private String surname;
    private String address;
    private long PESEL;
    private LocalDate birthDate;
    private LocalDate firstRent;

    Person(String name, String surname, String address, long PESEL, LocalDate birthDate){
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.PESEL = PESEL;
        this.birthDate = birthDate;
    }

    public String toString(){
        return name + " " + surname;
    }

    protected String getAddress() {
        return address;
    }

    protected long getPESEL(){
        return PESEL;
    }

    protected LocalDate getDateOfBirth(){
        return birthDate;
    }

    protected String getFirstRentDateString(){
        try {
            if (firstRent == null) throw new NeverRentException();
        } catch(NeverRentException e){
            return ("Ta osoba nie wynajęła jeszcze żadnego pomieszczenia");
        }
        return firstRent.toString();
    }

    protected LocalDate getFirstRentDateDate(){
        try {
            if (firstRent == null) throw new NeverRentException();
        } catch(NeverRentException e){
        }
        return firstRent;
    }

    protected void setFirstRentDate(LocalDate ob){
        firstRent = ob;
    }

}