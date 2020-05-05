import java.util.*;
import java.io.*;


public class Magazine {
    protected List<Room> rooms = new ArrayList<>();
    // Funkcjonalność zapewniająca zapisywanie od pliku w posortowany sposób
    public void saveFile(){
        try {
            String str = "Hello";
            BufferedWriter writer = new BufferedWriter(new FileWriter("/home/woocash/IdeaProjects/Java/Warehouse management/src/stan.txt"));
            writer.write(str);
            writer.close();
        } catch (IOException e){
            System.out.println("Błąd!");
        }
    }

    protected void addRoom(Room r){
        rooms.add(r);
    }


}
