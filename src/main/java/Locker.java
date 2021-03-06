import java.util.HashMap;

public class Locker {
    private int capacity = Integer.MAX_VALUE;
    private HashMap<Ticket,Bag> grids = new HashMap<Ticket, Bag>();

    public Locker() {
    }

    public Locker(int capacity) {
        this.capacity = capacity;
    }

    public Bag getBag(Ticket ticket) {
        if(grids.containsKey(ticket)) {
            this.capacity += 1;
            return grids.remove(ticket);
        } else {
            throw new InvalidTicket("Invalid ticket!");
        }
    }

    public Ticket storeBag(Bag bag) {
        if(capacity == 0) {
            throw new LockerFullException("Locker is full!");
        }
        Ticket ticket = new Ticket();
        grids.put(ticket,bag);
        this.capacity -= 1;
        return ticket;
    }
}
