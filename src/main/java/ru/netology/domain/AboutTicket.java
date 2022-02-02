package ru.netology.domain;




public class AboutTicket implements Comparable<AboutTicket> {

    private int id;
    private int price;
    private String from;
    private String to;
    private int timeToFly;

    public AboutTicket(int id, int price, String from, String to, int timeToFly) {
        this.id = id;
        this.price = price;
        this.from = from;
        this.to = to;
        this.timeToFly = timeToFly;
    }
    public int getId() {
        return id;
    }

    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }

    @Override
    public int compareTo(AboutTicket o) {
        return this.price - o.price;
    }

//    @Override
//    public int compareTo(AboutTicket o) {
//        int result = 0;
//        if (this.price < o.price) {
//            result = -1;
//        }
//        if (this.price > o.price) {
//            result = 1;
//        }
//        if (this.price == o.price) {
//            result = 0;
//        }
//        return result;
//    }

}


