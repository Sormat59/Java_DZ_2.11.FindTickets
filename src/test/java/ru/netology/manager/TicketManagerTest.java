package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.AboutTicket;
import ru.netology.repository.TicketRepository;

import static org.junit.jupiter.api.Assertions.*;

class TicketManagerTest {
    TicketRepository repository = new TicketRepository();
    TicketManager manager = new TicketManager(repository);

    AboutTicket t1 = new AboutTicket(1, 200, "dme", "ego", 180);
    AboutTicket t2 = new AboutTicket(2, 100, "dme", "ego", 180);
    AboutTicket t3 = new AboutTicket(3, 150, "pee", "dme", 120);
    AboutTicket t4 = new AboutTicket(4, 250, "pee", "aer", 190);
    AboutTicket t5 = new AboutTicket(5, 300, "pee", "aer", 190);

    @BeforeEach
    public void setUp() {
        manager.add(t1);
        manager.add(t2);
        manager.add(t3);
        manager.add(t4);
        manager.add(t5);
    }

    @Test
    public void shouldRemoveByIdAndFindAirports() {
        repository.remoteById(5);
        AboutTicket[] actual = manager.findAll("pee", "aer");
        AboutTicket[] expected = new AboutTicket[]{t4};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemoveByIdFromArray() {
        repository.remoteById(5);
        AboutTicket[] actual = repository.returnAll();
        AboutTicket[] expected = new AboutTicket[]{t1,t2,t3,t4};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindByAirportsMoreOne() {
        AboutTicket[] actual = manager.findAll("dme", "ego");
        AboutTicket[] expected = new AboutTicket[]{t2,t1};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindByAirportsOneSetUp() {
        AboutTicket[] actual = manager.findAll("pee", "dme");
        AboutTicket[] expected = new AboutTicket[]{t3};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindByExistsAirports() {
        AboutTicket[] actual = manager.findAll("dme", "aer");
        AboutTicket[] expected = new AboutTicket[]{};
        assertArrayEquals(expected, actual);
    }
}