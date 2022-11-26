
import java.util.concurrent.locks.*;


class SynchronizedFlight implements Flight {




    private ReadWriteLock accessLock = new ReentrantReadWriteLock();
    private final Lock readLock = accessLock.readLock();
    private final Lock writeLock = accessLock.writeLock();
    private final Client[] seats;

    SynchronizedFlight() {
        this(10);
    }

    SynchronizedFlight(int seatsCount) {
        this.seats = new Client[seatsCount];
    }

    @Override
    public Client[] queryReservation() throws InterruptedException {
        readLock.lock();
        Client[] s;
        try {
            s = this.seats;
        } finally {
            readLock.unlock();
        }
        return s;
    }

    @Override
    public void cancelReservation(int seatNo) throws InterruptedException {
        writeLock.lock();

        try {
            seats[seatNo] = null;
        } finally {
            writeLock.unlock();
        }
    }

    @Override
    public void makeReservation(Client client, int seatNo) throws InterruptedException {
        writeLock.lock();

        try {
            if (seats[seatNo]==null)
                seats[seatNo] = client;
        else System.out.println("\nYou can't choose it. You must choose another seat");

        } finally {
            writeLock.unlock();
        }
    }


   @Override
    public int seatCount() {
        return this.seats.length;
    }
}
