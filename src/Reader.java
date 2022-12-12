
import java.io.PrintWriter;
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
        FileManager FManger = new FileManager();
         final String DisplayFileName = "Display.txt";
        System.out.printf( "\n operation: queryReservation | seats: " );
        FManger.Write(  "\n operation: queryReservation | seats: " , DisplayFileName , true);
        for (int i=0;i<arr.length;i++) {
            System.out.printf("[%d|%s]", i, (arr[i] == null) ? "null": arr[i]);
            String a;
            if (arr[i] == null)  a ="null"; else a =  arr[i].toString();
            String ss =  "["  +   i  +   "|"   + a+ "]";
            FManger.Write(  ss , DisplayFileName , true);
        }
        System.out.printf("[ seatNo | clientNo ]");

        FManger.Write("[ seatNo | clientNo ]", DisplayFileName , true);
    }
}
