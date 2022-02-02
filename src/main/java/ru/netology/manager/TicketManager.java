package ru.netology.manager;

import ru.netology.domain.AboutTicket;
import ru.netology.repository.TicketRepository;

import java.util.Arrays;

public class TicketManager {
    private TicketRepository repository;

    public TicketManager(TicketRepository repository) {
        this.repository = repository;
    }

    public void add(AboutTicket ticket) {
        repository.save(ticket);
    }

    public AboutTicket[] findAll(String from, String to) {
        AboutTicket[] result = new AboutTicket[0];
        for (AboutTicket ticket : repository.returnAll()) {
            if (ticket.getFrom().equals(from) && ticket.getTo().equals(to)) {
                AboutTicket[] tmp = new AboutTicket[result.length + 1];
                System.arraycopy(result, 0, tmp, 0, result.length);
                tmp[tmp.length - 1] = ticket;
                result = tmp;
            }
        }
        Arrays.sort(result);
        return result;
    }

//    public AboutTicket[] findAll(String from, String to) {
//        int tmp = 0;
//        for (AboutTicket ticket : repository.returnAll()) {
//            if (ticket.getFrom().equals(from) && ticket.getTo().equals(to)) {
//                tmp++;
//            }
//        }
//        AboutTicket[] result = new AboutTicket[tmp];
//
//        int i = 0;
//        for (AboutTicket ticket : repository.returnAll()) {
//            if (ticket.getFrom().equals(from) && ticket.getTo().equals(to)) {
//                result[i] = ticket;
//                i++;
//            }
//        }
//        Arrays.sort(result);
//        return result;
//    }


}






