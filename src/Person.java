import java.util.*;
import java.time.LocalDate;

public class Person {
    List<Room> rentedRooms = new ArrayList<>();
    private String name;
    private String surname;
    private String address;
    private int PESEL;
    private LocalDate birthDate;
    private LocalDate firstRent;

    protected void put(Room room, Object ob) {
        if (rentedRooms.contains(room)) {
            room.put(ob);
        } else {
            System.out.println("Nie możesz włożyć przedmiotu do pokoju, którego nie wynajmujesz!");
        }
    }

    protected void pull(Room room, Object ob) {
        if (rentedRooms.contains(room)) {
            room.pull(ob);
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
}