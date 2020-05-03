import java.util.*;

public class Osoba {
    List<Pomieszczenie> rentedRooms = new ArrayList<>();
    private String imie;
    private String nazwisko;
    private String adresZamieszkania;
    private int PESEL;
    


    private void put(Pomieszczenie room, Object ob) {
        if (rentedRooms.contains(room)) {
            room.put(ob);
        } else {
            System.out.println("Nie możesz włożyć przedmiotu do pokoju, którego nie wynajmujesz!");
        }
    }

    private void pull(Pomieszczenie room, Object ob) {
        if (rentedRooms.contains(room)) {
            room.pull(ob);
        } else {
            System.out.println("Nie możesz wyjąć przedmiotu z pokoju, którego nie wynajmujesz!");
        }
    }
}
