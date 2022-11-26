
import java.util.Random;

public class Reader implements Runnable {

    private final static Random generator = new Random();
    private final Flight flight;


    public Reader(Flight flight) {
        this.flight = flight;
    }

    @Override
    public void run() {
        for (int count=0; count<this.flight.seatCount()*1.5; count++) {
            try {
                Thread.sleep(generator.nextInt(3000));
                displaySeats(this.flight.queryReservation());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("\n\n\t\tqueryReservation done!\n");
    }


    public static void displaySeats(Client[] arr) {
        System.out.printf("\n operation: %16s | seats: ", "queryReservation");
        for (int i=0;i<arr.length;i++) {
            System.out.printf("[%d|%s]", i, (arr[i] == null) ? "null": arr[i]);
        }
        System.out.printf("[%s|%s]", "seatNo", "clientNo");
    }
}
