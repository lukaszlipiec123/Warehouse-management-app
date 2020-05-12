import java.util.*;
import java.io.*;


public class Magazine{
    protected List<Room> rooms = new ArrayList<>();
    // Funkcjonalność zapewniająca zapisywanie od pliku w posortowany sposób
    HashMap<String, Double> things = new HashMap<String, Double>();

    protected void saveFile(Room activeRoom){
        sortThings(activeRoom);
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("/home/woocash/IdeaProjects/Java/Warehouse management/src/stan.txt"));
            writer.write("NAZWA MAGAZYNU: " + activeRoom.getName()
                    + " WŁAŚCICIEL MAGAZYNU: " + activeRoom.getTenant()
                    + " ŁĄCZNA PRZESTRZEŃ " + activeRoom.getSpace()
                    + " PRZESTRZEŃ ZAJĘTA: " + activeRoom.getSpaceTaken()
                    + " DOSTĘPNA PRZESTRZEŃ " + (activeRoom.getSpace() - activeRoom.getSpaceTaken())
                    + " PRZEDMIOTY W MAGAZYNIE (WYRAŻONE W METRACH SZEŚCIENNYCH):\n"
            );
            for(Map.Entry<String, Double> entry : things.entrySet()){
                writer.write(entry.getKey() + " (" + entry.getValue() + ")\n");
            }
            writer.write("ŁĄCZNIE PRZEDMIOTÓW W MAGAZYNIE: " + things.size() + "\n");
            writer.close();
            System.out.println("Zapisano stan magazynu do pliku");
        } catch (IOException e){
            System.out.println("Błąd!");
        }
    }

    protected void sortThings(Room activeRoom){
        for(Item it : activeRoom.items){
            things.put(it.getName(), it.getSpace());
        }
        for(Vehicle vh : activeRoom.vehicles){
            things.put(vh.getName(), vh.getSpace());
        }
        things = sortByValue(things);
    }

    protected void addRoom(Room r){
        rooms.add(r);
    }


    private HashMap<String, Double> sortByValue(HashMap<String, Double> things){
        List<Map.Entry<String, Double> > list = new LinkedList<Map.Entry<String, Double> >(things.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<String, Double> >() {
            public int compare(Map.Entry<String, Double> o1, Map.Entry<String, Double> o2) {
                int outcome = (o1.getValue()).compareTo(o2.getValue());
                int value;
                if (outcome == 1) value = -1;
                else if (outcome == 0) value = 0;
                else value = 1;
                return value;
            }
        });
        HashMap<String, Double> temp = new LinkedHashMap<String, Double>();
        for (Map.Entry<String, Double> aa : list) {
            temp.put(aa.getKey(), aa.getValue());
        }
        return temp;
    }

}


