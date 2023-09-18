import java.io.FileWriter;
import java.io.IOException;
import java.util.PriorityQueue;

public class Automat {
    private PriorityQueue<Toy> listOfToys = new PriorityQueue<>();

    public Automat() {

    }

    public void addInList(Toy toy){
        for (int i = 0; i < toy.getCount(); i++) {
            listOfToys.add(toy);
        }
    }

    public Toy giveOutAToy(){
        Toy toy =listOfToys.poll();
        try(FileWriter writer = new FileWriter("Toys.txt", true))
        {
            writer.write(toy+"\n");
            writer.flush();

        }
        catch(IOException e){
            System.out.println(e.getMessage());
        }

        if (toy != null) {
            toy.setCount(toy.getCount()-1);
        }


        return toy;
    }

    public void viewQueue(){
        for (Toy toy :
                listOfToys) {
            System.out.println(toy);
        }
    }
}
