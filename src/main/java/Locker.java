import java.util.HashMap;

public class Locker {
    private int capacity = Integer.MAX_VALUE;
    private HashMap<Ticket,Bag> grids = new HashMap<Ticket, Bag>();

    public Locker(int capacity) {
        this.capacity = capacity;
    }

    public Ticket storeBag(Bag bag) {
        Ticket ticket = new Ticket();
        grids.put(ticket,bag);
        return ticket;
    }
}
