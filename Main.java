public class Main {
    public static void main(String[] args) {
        Plate plate = new Plate(10); // Il piatto può contenere al massimo 10 bocconi

        Producer producer = new Producer(plate);
        Consumer consumer = new Consumer(plate);

        producer.start();
        consumer.start();
    }
}

