import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.Assert.*;

public class LockerTest {
    @Test
    public void should_return_ticket_when_store_bag_given_locker_is_not_full() {
        Locker locker = new Locker(20);
        Bag bag = new Bag();
        Ticket ticket = locker.storeBag(bag);
        assertNotNull(ticket);
    }

    @Test
    public void should_show_error_message_when_store_bag_given_locker_is_full() {
        Locker locker = new Locker(0);
        Bag bag = new Bag();
        LockerFullException exception = assertThrows(LockerFullException.class,
                ()->locker.storeBag(bag), "Locker is full!"
        );
        assertEquals(exception.getMessage(),"Locker is full!");
    }

    @Test
    public void should_return_bag_when_get_bag_given_valid_ticket() {
        Locker locker = new Locker();
        Bag bag = new Bag();
        Ticket ticket = locker.storeBag(bag);
        Bag expected = locker.getBag(ticket);
        assertNotNull(expected);
    }

    @Test
    public void should_show_invalid_ticket_message_when_get_bag_given_duplicated_ticket() {
        Locker locker = new Locker();
        Bag bag = new Bag();
        Ticket ticket = locker.storeBag(bag);
        Bag first = locker.getBag(ticket);
        InvalidTicket exception = assertThrows(InvalidTicket.class,
                ()->locker.getBag(ticket), "Invalid ticket!"
        );
        assertEquals(exception.getMessage(),"Invalid ticket!");
    }
}
