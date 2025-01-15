public class Consumer extends Thread {
    private final Plate plate;

    public Consumer(Plate plate) {
        this.plate = plate;
    }

    @Override
    public void run() {
        try {
            while (true) {
                plate.removeBite();
                Thread.sleep(1500); // Simula il tempo di consumo
            }
        } catch (InterruptedException e) {
            System.out.println("Bambino ha finito di mangiare.");
        }
    }
}

