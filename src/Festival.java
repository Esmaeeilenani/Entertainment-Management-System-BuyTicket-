

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class Festival extends Event {

    private String[] FoodVenues;
    private String[] Activity;

    public Festival(String Name, Date SDate, Date EDate, double price, String City, String Address, String TargetedAudience, int AvailableTickets, String[] FoodVenues, String[] Activity) {
        super(Name, SDate, EDate, price, City, Address, TargetedAudience, AvailableTickets);

        this.FoodVenues = FoodVenues;
        this.Activity = Activity;

    }

    public String[] getFoodVenues() {
        return FoodVenues;
    }

    public void setFoodVenues(String[] FoodVenues) {
        this.FoodVenues = FoodVenues;
    }

    public String[] getActivity() {
        return Activity;
    }

    public void setActivity(String[] Activity) {
        this.Activity = Activity;
    }

    public String toString() {
        String Start = new SimpleDateFormat("dd/MM/yyyy").format(this.getSDate());
        String end = new SimpleDateFormat("dd/MM/yyyy").format(this.getEDate());

        return super.toString() + "FoodVenues: " + Arrays.toString(this.FoodVenues) + ", Activities: " + Arrays.toString(this.Activity);
    }

    @Override
    public int compareTo(Event t) {

        if (t instanceof Festival) {

            return (this.getSDate().before(t.getSDate())) ? -1 : 1;
        }

        return 0;
    }

}
