import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    static private int control;

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
                        System.out.println("PLACEHOLDER");
                        break;
                    case 2:
                        System.out.println("PLACEHOLDER");
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
