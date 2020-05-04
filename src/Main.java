import java.time.LocalDate;
import java.time.Month;
import java.util.*;

public class Main {
    private static int control;
    private static Person activePerson;
    private static List<Person> Persons = new ArrayList<>();

    private static void setActivePerson(Person prn){
        activePerson = prn;
    }

    private static void showInstruction(){
        System.out.println("Witaj w programie do zarządzania magazynami!\n"
                +          "Żeby wydać polecenie, wybierz odpowiednią cyfrę i zatwierdź klawiszem Enter:\n"
                +          "0 - Wyświetl tę instrukcję\n"
                +          "1 - Wybierz, którą osobą jesteś\n"
                +          "2 - Wypisz swojde dane łącznie z wynajętymi pomieszczeniami\n"
                +          "3 - Wybierz wynajmowane przez siebie pomieszczenie\n"
                +          "4 - Wyświetl zawartość pomieszczenia\n"
                +          "5 - Włóż nowy pojazd lub przedmiot\n"
                +          "6 - Wyjmij pojazd lub przedmiot\n"
                +          "7 - Wyświetl wolne pomieszczenia\n"
                +          "8 - Wynajmij pomieszczenie (dostępne po wybraniu aktywnego pomieszczenia)\n"
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
            if (i % 2 == 0){
                magazine.addRoom(new Room(val));
            } else{
                magazine.addRoom(new Room(val/20, val/30, val/50));
            }
        }

        // Utwórz 5 osób
        Persons.add(new Person("Jan", "Kowalski", "Warszawa", 11111111111L, LocalDate.of(1997, Month.MARCH, 1)));
        Persons.add(new Person("Kaczor", "Donald", "Kaczogród", 13333333337L, LocalDate.of(1934, Month.SEPTEMBER, 16)));
        Persons.add(new Person("Komandor", "Shephard", "SSV Normandia", 75635912819L, LocalDate.of(2154, Month.APRIL, 11)));
        Persons.add(new Person("James", "Raynor", "Hyperion", 19876543215L, LocalDate.of(2470, Month.AUGUST, 20)));
        Persons.add(new Person("Geralt", "z Rivii", "Kaer Mohren", 91827364501L, LocalDate.of(1268, Month.JANUARY, 31)));


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
                        if (activePerson != null) System.out.println("Aktywna osoba to: " + activePerson.toString());
                        else System.out.println("Aktywna osoba nie jest wybrana!");
                        System.out.println("Wyjście do głównego ekranu sterowania");
                        break;
                    case 3:
                        System.out.println("PLACEHOLDER");
                        break;
                    case 4:
                        System.out.println("PLACEHOLDER");
                        break;
                    case 5:
                        System.out.println("PLACEHOLDER");
                        break;
                    case 6:
                        System.out.println("PLACEHOLDER");
                        break;
                    case 7:
                        System.out.println("PLACEHOLDER");
                        break;
                    case 8:
                        System.out.println("PLACEHOLDER");
                        break;
                    case 9:
                        System.out.println("PLACEHOLDER");
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
        System.out.println("Dziękujemy za skorzystanie z programu!");
        input.close();
    }
}
