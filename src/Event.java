

import java.text.SimpleDateFormat;
import java.util.Date;

abstract class Event implements Comparable<Event> {

    private String Name;
    private Date SDate;
    private Date EDate;
    private double price;
    private String City;
    private String Address;
    private String TargetedAudience;
    private int AvailableTickets;

    public Event(String Name, Date SDate, Date EDate, double price, String City, String Address, String TargetedAudience, int AvailableTickets) {
        this.Name = Name;
        this.SDate = SDate;
        this.EDate = EDate;
        this.price = price;
        this.City = City;
        this.Address = Address;
        this.TargetedAudience = TargetedAudience;
        this.AvailableTickets = AvailableTickets;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public Date getSDate() {
        return SDate;
    }

    public void setSDate(Date SDate) {
        this.SDate = SDate;
    }

    public Date getEDate() {
        return EDate;
    }

    public void setEDate(Date EDate) {
        this.EDate = EDate;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String City) {
        this.City = City;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public String getTargetedAudience() {
        return TargetedAudience;
    }

    public void setTargetedAudience(String TargetedAudience) {
        this.TargetedAudience = TargetedAudience;
    }

    public int getAvailableTickets() {
        return AvailableTickets;
    }

    public void setAvailableTickets(int AvailableTickets) {
        this.AvailableTickets = AvailableTickets;
    }

    public String toString() {
        String Start = new SimpleDateFormat("dd/MM/yyyy").format(this.getSDate());
        String end = new SimpleDateFormat("dd/MM/yyyy").format(this.getEDate());
        return "Name: " + this.Name + ", Dates: " + Start + " - " + end + ", City: " + this.City + ", Address: " + this.getAddress() + ", Price: " + this.price + ", Target Audience: " + this.TargetedAudience + ", Tickets Available: " + this.AvailableTickets + ", ";
    }

}
