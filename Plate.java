import java.util.LinkedList;
import java.util.Queue;

public class Plate {
    private final Queue<String> bites;
    private final int MAX_SIZE;

    public Plate(int maxSize) {
        this.bites = new LinkedList<>();
        this.MAX_SIZE = maxSize;
    }

    // Metodo per aggiungere un boccone
    public synchronized void addBite(String bite) throws InterruptedException {
        while (bites.size() == MAX_SIZE) {
            wait(); // Aspetta finché il piatto è pieno
        }
        bites.add(bite);
        System.out.println("Papà ha aggiunto: " + bite + ". Bocconi nel piatto: " + bites.size());
        notifyAll(); // Notifica che c'è un boccone disponibile
    }

    // Metodo per rimuovere un boccone
    public synchronized String removeBite() throws InterruptedException {
        while (bites.isEmpty()) {
            wait(); // Aspetta finché il piatto è vuoto
        }
        String bite = bites.poll();
        System.out.println("Bambino ha mangiato: " + bite + ". Bocconi rimasti nel piatto: " + bites.size());
        notifyAll(); // Notifica che c'è spazio disponibile
        return bite;
    }
}
