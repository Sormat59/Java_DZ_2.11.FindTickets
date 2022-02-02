package ru.netology.repository;

import ru.netology.domain.AboutTicket;

public class TicketRepository {
    private AboutTicket[] tickets = new AboutTicket[0];

    public void save(AboutTicket ticket) {
        int length = tickets.length + 1;
        AboutTicket[] tmp = new AboutTicket[length];
        System.arraycopy(tickets, 0, tmp, 0, tickets.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = ticket;
        tickets = tmp;
    }

    public AboutTicket[] returnAll() {
        return tickets;
    }

    public void remoteById(int id) {
        int length = tickets.length - 1;
        AboutTicket[] tmp = new AboutTicket[length];
        int index = 0;
        for (AboutTicket ticket : tickets) {
            if (ticket.getId() != id) {
                tmp[index] = ticket;
                index++;
            }
        }
        tickets = tmp;
    }

}
