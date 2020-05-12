import java.time.LocalDate;
import java.time.Month;
import java.util.*;

public class Main {
    private static int control;
    private static Person activePerson;
    private static List<Person> Persons = new ArrayList<>();
    private static List<Item> Items = new ArrayList<>();
    private static List<Vehicle> Vehicles = new ArrayList<>();
    private static Room activeRoom;

    private static void setActivePerson(Person prn){
        activePerson = prn;
    }

    private static void showInstruction(){
        System.out.println("Witaj w programie do zarządzania magazynami!\n"
                +          "Żeby wydać polecenie, wybierz odpowiednią cyfrę i zatwierdź klawiszem Enter:\n"
                +          "0 - Wyświetl tę instrukcję\n"
                +          "1 - Wybierz, którą osobą jesteś\n"
                +          "2 - Wypisz swojde dane łącznie z wynajętymi pomieszczeniami\n"
                +          "3 - Wybierz wynajmowane przez siebie pomieszczenie jako aktywne\n"
                +          "4 - Wyświetl zawartość pomieszczenia\n"
                +          "5 - Włóż nowy pojazd lub przedmiot\n"
                +          "6 - Wyjmij pojazd lub przedmiot\n"
                +          "7 - Wyświetl wolne pomieszczenia\n"
                +          "8 - Wynajmij pomieszczenie\n"
                +          "9 - Zapisz aktualny stan magazynu do pliku\n"
                +          "10 - Zamknij program\n"
        );
    }

    public static void main(String[] args) {
        Magazine magazine = new Magazine();
        Random r = new Random();

        // Utwórz 10 pomieszczeń
        for(int i = 1; i < 11; i++){
            int val = r.nextInt((5000 - 100) + 1) + 100;
            String name = "Pomieszczenie " + i;
            if (i % 2 == 0){
                magazine.addRoom(new Room(name, val));
            } else{
                magazine.addRoom(new Room(name, val/20, val/30, val/50));
            }
        }

        // Utwórz osoby
        Persons.add(new Person("Jan", "Kowalski", "Warszawa", 11111111111L, LocalDate.of(1997, Month.MARCH, 1)));
        Persons.add(new Person("Kaczor", "Donald", "Kaczogród", 13333333337L, LocalDate.of(1934, Month.SEPTEMBER, 16)));
        Persons.add(new Person("Komandor", "Shephard", "SSV Normandia", 75635912819L, LocalDate.of(2154, Month.APRIL, 11)));
        Persons.add(new Person("James", "Raynor", "Hyperion", 19876543215L, LocalDate.of(2470, Month.AUGUST, 20)));
        Persons.add(new Person("Geralt", "z Rivii", "Kaer Mohren", 91827364501L, LocalDate.of(1268, Month.JANUARY, 31)));


        // Utwórz przedmioty
        Items.add(new Item("Książka", 1.0, r.nextBoolean()));
        Items.add(new Item("Laptop", 2.25, r.nextBoolean()));
        Items.add(new Item("Fotel", 15.55, r.nextBoolean()));
        Items.add(new Item("Drabina", 14.3, r.nextBoolean()));
        Items.add(new Item("Szafa", 5.3, 2.5, 1.8, r.nextBoolean()));
        Items.add(new Item("Komoda", 4.1, 3.7, 1.5, r.nextBoolean()));
        Items.add(new Item("Biurko", 3.2, 1.5, 1.0, r.nextBoolean()));
        Items.add(new Item("Łóżko", 6.0, 3.0, 0.7, r.nextBoolean()));

        // Utwórz pojazdy
        Vehicles.add(new Car("Volvo s90", 1705.32, "Diesel"));
        Vehicles.add(new Car("Mazda 3", 1189.53, "Benzyna"));
        Vehicles.add(new Car("Toyota Corolla", 1330.21, "Hybryda"));
        Vehicles.add(new Bike("Indiana X-Enduro", 570.42, 6));
        Vehicles.add(new Bike("Vento TR 2.0", 623.56, 5));
        Vehicles.add(new Bike("Pulso 1.0", 401.13, 7));
        Vehicles.add(new Motorcycle("Suzuki RM-Z", 741.42, true));
        Vehicles.add(new Motorcycle("Honda Varadero", 778.45, true));
        Vehicles.add(new Motorcycle("Yamaha YZF", 919.10, false));

        showInstruction();

        Scanner input = new Scanner(System.in);

        // Główna pętla programu
        while (control != 10){
            try {
                control = input.nextInt();
                switch (control) {
                    case 0:
                        showInstruction();
                        break;
                    case 1:
                        int i = 1;
                        System.out.println("Dostępne osoby:");
                        for(Person p : Persons){
                            System.out.println(i + " - " + p.toString());
                            i++;
                        }
                        try {
                            int person = input.nextInt();
                            switch (person) {
                                case 1:
                                    setActivePerson(Persons.get(0));
                                    System.out.println("Ustawiono osobę " + Persons.get(0).toString() + " jaką aktywną");
                                    System.out.println("Wyjście do głównego ekranu sterowania");
                                    break;
                                case 2:
                                    setActivePerson(Persons.get(1));
                                    System.out.println("Ustawiono osobę " + Persons.get(1).toString() + " jaką aktywną");
                                    System.out.println("Wyjście do głównego ekranu sterowania");
                                    break;
                                case 3:
                                    setActivePerson(Persons.get(2));
                                    System.out.println("Ustawiono osobę " + Persons.get(2).toString() + " jaką aktywną");
                                    System.out.println("Wyjście do głównego ekranu sterowania");
                                    break;
                                case 4:
                                    setActivePerson(Persons.get(3));
                                    System.out.println("Ustawiono osobę " + Persons.get(3).toString() + " jaką aktywną");
                                    System.out.println("Wyjście do głównego ekranu sterowania");
                                    break;
                                case 5:
                                    setActivePerson(Persons.get(4));
                                    System.out.println("Ustawiono osobę " + Persons.get(4).toString() + " jaką aktywną");
                                    System.out.println("Wyjście do głównego ekranu sterowania");
                                    break;
                                default:
                                    System.out.println("Wprowadzono nieprawidłową wartość! Nie wybrano aktywnej osoby");
                                    System.out.println("Wyjście do głównego ekranu sterowania");
                                    break;
                            }
                        } catch(InputMismatchException e){
                            System.out.println("Wprowadzono nieprawidłową wartość! Nie wybrano aktywnej osoby");
                            System.out.println("Wyjście do głównego ekranu sterowania");
                        }
                        break;
                    case 2:
                        if (activePerson != null) {
                            System.out.println("Aktywna osoba to: " + activePerson.toString());
                            System.out.println("Adres zamieszkania to: " + activePerson.getAddress());
                            System.out.println("Numer PESEL to: " + activePerson.getPESEL());
                            System.out.println("Data urodzenia: " + activePerson.getDateOfBirth());
                            System.out.println("Data pierwszego wynajęcia pomieszczenia: " + activePerson.getFirstRentDate());
                            System.out.println("Lista wynajętych pomieszczeń: ");
                            for(Room room : magazine.rooms){
                                if(room.getTenant() == activePerson) System.out.println(room.toString());
                            }
                        } else {
                            System.out.println("Aktywna osoba nie jest wybrana!");
                        }
                        System.out.println("Wyjście do głównego ekranu sterowania");
                        break;
                    case 3:
                        System.out.println("Wybierz aktywne pomieszczenie, na którym będą wykonywane działania");
                        if (activePerson != null) {
                            try {
                                int roomId = input.nextInt();
                                boolean changeMade = false;
                                for(Room rm : magazine.rooms){
                                    if(Integer.parseInt(rm.getId()) == roomId && rm.getTenant() == activePerson){
                                        activeRoom = rm;
                                        System.out.println("Ustawiono " + rm + " jako aktywne");
                                        changeMade = true;
                                        break;
                                    }
                                }
                                if(roomId > 0 && roomId < 11 && changeMade == false) System.out.println("Nie wynajmujesz tego pokoju!");
                                else if(changeMade == false)System.out.println("Podano liczbę spoza zakresu!");
                            } catch (InputMismatchException e) {
                                System.out.println("Wprowadzono nieprawidłową wartość! Nie wybrano aktywnej osoby");
                            }
                        } else {
                            System.out.println("Aktywna osoba nie jest wybrana!");
                        }
                        System.out.println("Wyjście do głównego ekranu sterowania");
                        break;
                    case 4:
                        if(activeRoom == null) System.out.println("Nie wybrano aktywnego pomieszczenia!");
                        else {
                            System.out.println("Przedmioty w " + activeRoom );
                            activeRoom.listRented();
                        }
                        System.out.println("Wyjście do głównego ekranu sterowania");
                        break;
                    case 5:
                        if (activeRoom != null) {
                            System.out.println("Lista dostępnych przedmiotów i pojazdów (w nawiasach podana jest zajmowana przestrzeń wyrażona w metrach sześciennych):");
                            for (Item it : Items) {
                                System.out.println(it);
                            }
                            for (Vehicle vh : Vehicles) {
                                System.out.println(vh);
                            }
                            System.out.println("Wpisz nazwę przedmiotu (bez podanej w nawiasach zajmowanej przestrzeni wyrażonej w metrach sześciennych)");
                            input.nextLine(); // Przekazanie znaku nowej lini do skanera w celu uniknięcia pominięcia odczytu użytkownika
                            String item = input.nextLine();
                            boolean changeMade = false;
                            for (Item it : Items) {
                                if (it.getName().equals(item)){
                                    activeRoom.put(it);
                                    changeMade = true;
                                    break;
                                }
                            }
                            if (!changeMade) {
                                for (Vehicle vh : Vehicles) {
                                    if (vh.getName().equals(item)) {
                                        activeRoom.put(vh);
                                        changeMade = true;
                                        break;
                                    }
                                }
                            }
                            if (!changeMade) System.out.println("Nie ma takiego przedmiotu/pojazdu!");
                        } else {
                            System.out.println("Nie wybrano aktywnego pomieszczenia!");
                        }
                        System.out.println("Wyjście do głównego ekranu sterowania");
                        break;
                    case 6:
                        if(activeRoom != null){
                            System.out.println("Podaj przedmiot do usunięcia");
                            input.nextLine(); //Przekazanie znaku nowej lini do skanera w celu uniknięcia pominięcia odczytu użytkownika
                            String item = input.nextLine();
                            boolean changeMade = false;
                            for (Item it : Items) {
                                if (it.getName().equals(item)){
                                    changeMade = activeRoom.pull(it);
                                    break;
                                }
                            }
                            if (!changeMade) {
                                for (Vehicle vh : Vehicles) {
                                    if (vh.getName().equals(item)) {
                                        changeMade = activeRoom.pull(vh);
                                        break;
                                    }
                                }
                            }
                            if (!changeMade) System.out.println("Nie ma takiego przedmiotu/pojazdu!");
                        } else {
                            System.out.println("Nie wybrano aktywnego pomieszczenia!");
                        }
                        System.out.println("Wyjście do głównego ekranu sterowania");
                        break;
                    case 7:
                        for(Room room : magazine.rooms){
                            if(room.getTenant() == null){
                                System.out.println(room);
                            }
                        }
                        System.out.println("Wyjście do głównego ekranu sterowania");
                        break;
                    case 8:
                        if (activePerson != null) {
                            System.out.println("Podaj numer wolnego pomieszczenia");
                            try {
                                int j = input.nextInt();
                                try {
                                    if (magazine.rooms.get(j - 1).getTenant() == null && magazine.rooms.get(j - 1).getStatus()) {
                                        magazine.rooms.get(j - 1).setTenant(activePerson);
                                        if(activePerson.getFirstRentDate() == null) activePerson.setFirstRentDate(LocalDate.now());
                                        System.out.println("Wynajęto pomieszczenie " + j);
                                    } else {
                                        if (magazine.rooms.get(j - 1).getTenant() == null) {
                                            System.out.println("Pokój nie jest wolny! Sprawdź listę dostepnych pomieszczeń za pomocą komeny '7' ");
                                        } else {
                                            System.out.println("Pokój jest w stanie remontu! Czy chcesz skończyć remont? TAK/NIE\n");
                                            String answer = input.nextLine();
                                            if (answer.equals("TAK")){
                                                magazine.rooms.get(j - 1).setTenant(activePerson);
                                                magazine.rooms.get(j - 1).setActive();
                                                if(activePerson.getFirstRentDate() == null) activePerson.setFirstRentDate(LocalDate.now());
                                                System.out.println("Zakończono remont i wynajęto pomieszczenie " + j);
                                            }
                                            else if (answer.equals("NIE")) {
                                                System.out.println("Nie zakończono remontu i nie wynajęto pomieszczenia");
                                            }
                                            else {
                                                System.out.println("Podano błędną odpowiedź! Nie zakończono remontu i nie wynajęto pomieszczenia");
                                            }
                                        }
                                    }
                                } catch (IndexOutOfBoundsException e) {
                                    System.out.println("Pokój nie istnieje! Sprawdź listę dostepnych pomieszczeń za pomocą komeny '7'");
                                }
                            } catch (InputMismatchException e) {
                                System.out.println("Wprowadzono nieprawidłową wartość! Nie wynajęto pomieszczenia");
                                input.next();
                            }
                        } else {
                            System.out.println("Nie wybrano aktywnej osoby! Nie wynajęto pomieszczenia");
                        }
                        System.out.println("Wyjście do głównego ekranu sterowania");
                        break;
                    case 9:
                        magazine.saveFile();
                        System.out.println("Wyjście do głównego ekranu sterowania");
                        break;
                    case 10:
                        break;
                    default:
                        System.out.println("Wprowadzono nieprawidłową wartość! Podaj poprawne polecenie.");
                        break;
                }
            } catch(InputMismatchException e) {
                System.out.println("Wprowadzono nieprawidłową wartość! Podaj poprawne polecenie.");
                input.next();
            }
        }
        System.out.println(activeRoom);
        System.out.println("Dziękujemy za skorzystanie z programu!");
        input.close();
    }
}
