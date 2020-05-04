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

    protected void put(Room room, Item it) {
        if (rentedRooms.contains(room)) {
            room.put(it);
        } else {
            System.out.println("Nie możesz włożyć przedmiotu do pokoju, którego nie wynajmujesz!");
        }
    }

    protected void put(Room room, Vehicle vh) {
        if (rentedRooms.contains(room)) {
            room.put(vh);
        } else {
            System.out.println("Nie możesz włożyć przedmiotu do pokoju, którego nie wynajmujesz!");
        }
    }

    protected void pull(Room room, Item it) {
        if (rentedRooms.contains(room)) {
            room.pull(it);
        } else {
            System.out.println("Nie możesz wyjąć przedmiotu z pokoju, którego nie wynajmujesz!");
        }
    }

    protected void pull(Room room, Vehicle vh) {
        if (rentedRooms.contains(room)) {
            room.pull(vh);
        } else {
            System.out.println("Nie możesz wyjąć przedmiotu z pokoju, którego nie wynajmujesz!");
        }
    }

    protected LocalDate getFirstRentDate() throws NeverRentException{
        try {
            if (firstRent == null)
                throw new NeverRentException("Ta osoba nie wynajęła jeszcze żadnego pomieszczenia");
        } catch(NeverRentException e){
            System.out.println("Placeholder");
        }
        return firstRent;
    }

    public String toString(){
        return name + " " + surname;
    }
}