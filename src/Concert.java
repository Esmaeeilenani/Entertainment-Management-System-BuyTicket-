

import java.util.Date;

public class Concert extends Event {

    private String performers;

    public Concert(String Name, Date SDate, Date EDate, String City, String Address, double price, int AvailableTickets, String TargetedAudience,  String performers) {
        super(Name, SDate, EDate, price, City, Address, TargetedAudience, AvailableTickets);
        this.performers = performers;

    }

    public String getPerformers() {
        return performers;
    }

    public void setPerformers(String performers) {
        this.performers = performers;
    }

    public String toString() {

        return super.toString() + " Performers: " + this.performers;
    }

    @Override
    public int compareTo(Event t) {

        return 0;
    }

}
