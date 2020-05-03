import java.util.*;
import java.time.LocalDate;

public class Osoba {
    List<Pomieszczenie> rentedRooms = new ArrayList<>();
    private String imie;
    private String nazwisko;
    private String adresZamieszkania;
    private int PESEL;
    private LocalDate dataUrodzenia;
    private LocalDate pierwszeWypożyczenie;


    protected void put(Pomieszczenie room, Object ob) {
        if (rentedRooms.contains(room)) {
            room.put(ob);
        } else {
            System.out.println("Nie możesz włożyć przedmiotu do pokoju, którego nie wynajmujesz!");
        }
    }

    protected void pull(Pomieszczenie room, Object ob) {
        if (rentedRooms.contains(room)) {
            room.pull(ob);
        } else {
            System.out.println("Nie możesz wyjąć przedmiotu z pokoju, którego nie wynajmujesz!");
        }
    }

    protected LocalDate getFirstRentDate() throws NeverRentException{
        try {
            if (pierwszeWypożyczenie == null)
                throw new NeverRentException("Ta osoba nie wynajęła jeszcze żadnego pomieszczenia");
        } catch(NeverRentException e){
            System.out.println("Placeholder");
        }
        return pierwszeWypożyczenie;
    }
}