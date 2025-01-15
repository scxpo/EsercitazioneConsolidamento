public class Producer extends Thread {
    private final Plate plate;

    public Producer(Plate plate) {
        this.plate = plate;
    }

    @Override
    public void run() {
        int biteNumber = 1;
        try {
            while (true) {
                String bite = "Boccone " + biteNumber++;
                plate.addBite(bite);
                Thread.sleep(1000); // Simula il tempo di preparazione
            }
        } catch (InterruptedException e) {
            System.out.println("Papà ha finito di preparare i bocconi.");
        }
    }
}
