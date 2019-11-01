
import java.io.*;
import java.text.*;
import java.util.*;



/*


ESMAEEI ENANI

*/
public class BuyTicket_Main {

//+++++++++++++++++++Start Method+++++++++++++++++++++++++++++++++++++++++++++++
    public static void main(String[] args) throws FileNotFoundException, ParseException {

        File File1 = new File("input(2).txt");

        if (!File1.exists()) {
            System.out.println("Sorry no File here");
            System.exit(0);
        }
        Scanner in = new Scanner(File1);
        PrintWriter out = new PrintWriter(new File("output.txt"));

        String Command[];
        //Array List for Event
        ArrayList<Event> events = new ArrayList<>();

        //Array list for Customer
        ArrayList<Customer> coustomer = new ArrayList<>();

        out.println("########################################################################################################\r\n"
                + "############################# Welcome to Entertainment Booking System ##################################\r\n"
                + "########################################################################################################\r\n");

        //Read Command from File
        while (in.hasNext()) {
            Command = in.nextLine().trim().split("--|,");
            //Adding Movies
            if (Command[0].equalsIgnoreCase("AddMovie")) {

                Movie M = new Movie(Command[1].trim(), new SimpleDateFormat("dd/MM/yyyy").parse(Command[2].trim()), new SimpleDateFormat("dd/MM/yyyy").parse(Command[3].trim()), Double.parseDouble(Command[4].trim()), Command[5], Command[6], Command[7].trim(), Command[8].trim(), Double.parseDouble(Command[9].trim()), Integer.parseInt(Command[10].trim()), Command[11].trim(), new Actor(Command[12].trim(), Command[13].trim().charAt(0), Integer.parseInt(Command[14].trim())));
                out.println("AddingMovie{" + M.toString() + "} was successfully completed");
                events.add(M);
                //Adding Festival
            } else if (Command[0].equalsIgnoreCase("AddFestival")) {
                Festival F = new Festival(Command[1].trim(), new SimpleDateFormat("dd/MM/yyyy").parse(Command[2].trim()), new SimpleDateFormat("dd/MM/yyyy").parse(Command[3].trim()), Double.parseDouble(Command[4].trim()), Command[5], Command[6], Command[7], Integer.parseInt(Command[8].trim()), Command[9].trim().split(" "), Command[10].trim().split(" "));
                events.add(F);
                out.println("AddingFestival{" + F.toString() + "} was successfully completed");
                //Adding Concert
            } else if (Command[0].equalsIgnoreCase("AddConcert")) {

                Concert C = new Concert(Command[1].trim(), new SimpleDateFormat("dd/MM/yyyy").parse(Command[2].trim()), new SimpleDateFormat("dd/MM/yyyy").parse(Command[3].trim()), Command[4].trim(), Command[5].trim(), Double.parseDouble(Command[6].trim()), Integer.parseInt(Command[7].trim()), Command[8].trim(), Command[9].trim());
                events.add(C);
                out.println("AddingConcert{" + C.toString() + "} was successfully completed");
                //Adding Customer
            } else if (Command[0].equalsIgnoreCase("AddCustomer")) {

                Customer C = new Customer(Command[1].trim(), Command[2].trim().charAt(0), new SimpleDateFormat("dd/MM/yyyy").parse(Command[3].trim()), Command[4].trim());
                coustomer.add(C);
                out.println("AddingCustomerCustomer " + C.toString() + "} was successfully completed");

                //Buy Ticket For Customer
            } else if (Command[0].equalsIgnoreCase("BuyTicket")) {

                BuyTicket(events, coustomer, Command, in, out);

                //Sort the Moive By the Required Way
            } else if (Command[0].equalsIgnoreCase("PrintSortMovies")) {

                SortedMovie(events, out);
                //Sort the Festival By the Required Way
            } else if (Command[0].equalsIgnoreCase("PrintSortFestivals")) {

                SortedFestival(events, out);

            }

        }
        out.close();
    }

    public static void BuyTicket(ArrayList<Event> events, ArrayList<Customer> coustomer, String[] Command, Scanner in, PrintWriter out) throws ParseException {

        Event e = null;
        //Evet List For Customer
        ArrayList<Event> event = new ArrayList<>();

        Booking B = null;

        //while the Customer is not Finish from Buying Ticket
        while (!Command[0].equals("For")) {

            //to Find the Event By Name
            for (int i = 0; i < events.size(); i++) {
                if (events.get(i).getName().equals(Command[1])) {
                    e = events.get(i);
                    break;
                }
            }

            //if the Event is Found it
            if (e != null) {

                Date Coming = new SimpleDateFormat("dd/MM/yyyy").parse(Command[2].trim());

                Date Ending = e.getEDate();

                Date Starting = e.getSDate();
                //check the Date
                if ((Coming.before(Ending) || Coming.equals(Ending)) && (Coming.after(Starting)) || Coming.equals(Starting)) {

                    event.add(e);
                    e.setAvailableTickets(e.getAvailableTickets() - 1);

                    out.println("The requested event " + Command[1] + " is available in the selected date");

                    out.println("Ticket is successfully added to the ShoppingCart: Cart Size -> " + event.size());

                } else {
                    out.println("The requested event " + Command[1] + " is not available in the selected date");

                    out.println("Ticket not successfully added to the ShoppingCart: Cart Size -> " + event.size());

                }

            } else {

                out.println(" The event " + Command[1] + " is not found. \r\n");
            }

            Command = in.nextLine().trim().split("--|,");
        }
        Customer C = null;

        for (int i = 0; i < coustomer.size(); i++) {
            if (coustomer.get(i).getName().equals(Command[1])) {
                C = coustomer.get(i);
                break;
            }
        }
        //if the Customer is Founded and his cart is not Empty   
        if (C != null && event.size() > 0) {
            out.println("**Buying Ticket for " + Command[1] + " was successfully completed\r\n");
            B = new Booking(C, event);

            out.println(B.toString() + "\r\n");
        } else {
            out.println("The customer " + Command[1] + " is not found");

            out.println("**Buying Ticket for was not successfully completed\r\n");
        }

    }

//++++++++++++++++++++++Print the sorted Movie++++++++++++++++++++++++++++++++++
    public static void SortedMovie(ArrayList<Event> events, PrintWriter out) {
        Collections.sort(events);
        Movie M = null;
        out.println("----------------------------------------- Movie Sorted By Rating ------------------------------------------");
        out.printf("%-25s %-20s %-20s %-15s %-15s\r\n", "Movie name", "Dates", "Actor", "Ratings", "Available Tickets");
        out.println("---------------------------------------------------------------------------------------------------------");
        for (int i = 0; i < events.size(); i++) {
            if (events.get(i) instanceof Movie) {
                M = (Movie) events.get(i);
                String SEdate = new SimpleDateFormat("dd/MM/yy").format(M.getSDate()) + "-" + new SimpleDateFormat("dd/MM/yy").format(M.getEDate());
                out.printf("%-25s %-20s %-22s %-20.1f %-18d\r\n", M.getName(), SEdate, M.getActor().getName(), M.getRating(), M.getAvailableTickets());
            }
        }
        out.println("---------------------------------------------------------------------------------------------------------");
        out.println();
        out.println();
    }

//+++++++++++++++++++++Print the Sortd Festival+++++++++++++++++++++++++++++++++    
    public static void SortedFestival(ArrayList<Event> events, PrintWriter out) {

        Collections.sort(events);
        Festival F = null;
        out.println("----------------------------------------- Festival Sorted By Starting Date ------------------------------------------");
        out.printf("%-25s %-20s %-28s %-15s %-15s\r\n", "Festival Name", "Dates", "FoodVenues", "Activities", "Available Tickets");
        out.println("---------------------------------------------------------------------------------------------------------");

        for (int i = 0; i < events.size(); i++) {

            if (events.get(i) instanceof Festival) {
                F = (Festival) events.get(i);

                String SEdate = new SimpleDateFormat("dd/MM/yy").format(F.getSDate()) + "-" + new SimpleDateFormat("dd/MM/yy").format(F.getEDate());

                out.printf("%-25s %-20s %-28s %-20s %-18d\r\n", F.getName(), SEdate, Arrays.toString(F.getFoodVenues()), Arrays.toString(F.getActivity()), F.getAvailableTickets());

            }

        }
        out.println("---------------------------------------------------------------------------------------------------------");
        out.println();
        out.println();
    }

}
