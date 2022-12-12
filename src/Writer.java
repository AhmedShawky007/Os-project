
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Writer implements Runnable {

    private final static Random generator = new Random();
    private final Flight flight;
    private ArrayList<Integer> list;

    public Writer(Flight flight) {
        this.flight = flight;


        list = new ArrayList<>();
        for (int i=0; i<this.flight.seatCount(); i++) {
            list.add(i);
        }
        Collections.shuffle(list);
    }

    @Override
    public void run() {
        for (int count=0; count<this.flight.seatCount(); count++) {
            try {
                //makeReservation
                Thread.sleep(generator.nextInt(3000));
                Client newClient = new Client();
                displayState("makeReservation", list.get(count));
                this.flight.makeReservation(newClient, list.get(count));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        for (int i=0;i<this.flight.seatCount()/2;i++) {
            try {
                Thread.sleep(generator.nextInt(3000));
                displayState("cancelReservation", list.get(i));
                this.flight.cancelReservation(list.get(i));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("\n\n\t\tcancelReservation and makeReservation done!\n");
    }


    private void displayState(String operation, int seatNo) {
        System.out.printf("\n operation: %16s | seatNo: %d ", operation, seatNo);
        FileManager FManger = new FileManager();
        final String DisplayFileName = "Display.txt";
        FManger.Write(  "\n operation:"+ operation + "|" + "seatNo:"  + seatNo  , DisplayFileName , true);
    }
}
