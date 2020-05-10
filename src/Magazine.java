import java.util.*;
import java.io.*;


public class Magazine {
    protected List<Room> rooms = new ArrayList<>();
    // Funkcjonalność zapewniająca zapisywanie od pliku w posortowany sposób
    public void saveFile(Room activeRoom){
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("/home/woocash/IdeaProjects/Java/Warehouse management/src/stan.txt"));
            for(Item it : activeRoom.items){
                writer.write(it.toString());
            }
            for(Vehicle vh : activeRoom.vehicles){
                writer.write(vh.toString());
            }
            writer.close();
        } catch (IOException e){
            System.out.println("Błąd!");
        }
    }

    protected void addRoom(Room r){
        rooms.add(r);
    }


}
