

import java.util.ArrayList;
import java.util.Date;

public class Booking {

    private String BookingID;
    private Customer customer;
    private ArrayList<Event> events;
    private double discount;
    private double finaltotalPrice;

    public Booking(Customer customer, ArrayList<Event> events) {
        this.BookingID = customer.getCustomerId() + (int) (Math.random() * 999);
        this.customer = customer;
        this.events = events;

    }

    public String getBookingID() {
        return BookingID;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public ArrayList<Event> getEvents() {
        return events;
    }

    public void setEvents(ArrayList<Event> events) {
        this.events = events;
    }

    public double getDiscount() {
        int age = new Date().getYear() - this.customer.getDateBirth().getYear();

        if (age <= 3) {

            discount = 100.0;
            return discount;

        } else if (age <= 15) {
            return discount = 50.0;

        }
        return 0;
    }

    public double getDiscount(Event event) {
        if (event instanceof Festival) {
            return getDiscount();
        }
        return 0;
    }

    public double getFinalPrice(Event event) {

        return event.getPrice() - (event.getPrice() * getDiscount(event)) / 100;
    }

    public double calculateFinalPrice() {

        for (int i = 0; i < events.size(); i++) {
            finaltotalPrice += getFinalPrice(events.get(i));
        }

        return finaltotalPrice;
    }

    public double getTotalPrice() {

        double total = 0;

        for (int i = 0; i < events.size(); i++) {
            total += events.get(i).getPrice();
        }

        return total;
    }

    public double getSavingAmount() {

        return getTotalPrice() - finaltotalPrice;
    }

    public int NumberOfDiscountEvent() {
        int count = 0;
        for (int i = 0; i < events.size(); i++) {
            if (getDiscount(events.get(i)) == 100.0 || getDiscount(events.get(i)) == 50.0) {
                count++;
            }
        }

        return count;
    }

    public String toString() {

        String INFO = "------------------------- Invoice Details -------------------------\r\n";
        INFO += "Booking #: " + this.BookingID + "\r\n"
                + "Customer #: " + this.customer.getCustomerId() + "\r\n"
                + "-------------------------------------------------------------------\r\n";
        INFO += String.format("%-22s %-12s %-12s %-12s \r\n", "Event", "Price", "Discount", "Final_price");

        for (int i = 0; i < events.size(); i++) {
            INFO += String.format("%-22s %-12.2f %.1f%-12s %-12.2f\r\n", events.get(i).getName(), events.get(i).getPrice(), getDiscount(events.get(i)),"%", getFinalPrice(events.get(i)));
        }
        INFO += "-------------------------------------------------------------------\r\n"
                + "Number of discount items: " + NumberOfDiscountEvent() + "\r\n"
                + "- Total Price: " + String.format("%.2f", getTotalPrice()) + "\r\n"
                + "- Final Price: " + String.format("%.2f", calculateFinalPrice()) + "\r\n"
                + "- Saving Amount: " + String.format("%.2f", getSavingAmount()) + "\r\n"
                + "-------------------------------------------------------------------\r\n";
        return INFO;
    }

}
