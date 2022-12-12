

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    public static void main(String[] args) {


        ExecutorService application = Executors.newCachedThreadPool();

        Flight flight = new SynchronizedFlight(15);
        application.execute(new Writer(flight));
        application.execute(new Writer(flight));
        application.execute(new Writer(flight));
        application.execute(new Writer(flight));

        application.execute(new Reader(flight));
        application.execute(new Reader(flight));
        application.execute(new Reader(flight));
        application.execute(new Reader(flight));





        application.shutdown();
    }
}
