import org.junit.Test;

import static org.junit.Assert.*;

public class LockerTest {
    @Test
    public void should_return_ticket_when_store_bag_given_locker_is_not_full() {
        Locker locker = new Locker(20);
        Bag bag = new Bag();
        Ticket ticket = locker.storeBag(bag);
        assertNotNull(ticket);
    }
}
