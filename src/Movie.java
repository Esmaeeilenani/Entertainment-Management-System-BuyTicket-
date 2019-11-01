


import java.util.Date;


public class Movie extends Event {

    private String Language;
    private double Rating;
    private String genre;
    private Actor Actor;

    public Movie(String Name, Date SDate, Date EDate, double price, String City, String Address, String Language, String TargetedAudience, double Rating, int AvailableTickets, String genre, Actor Actor) {
        super(Name, SDate, EDate, price, City, Address, TargetedAudience, AvailableTickets);

        this.Actor = Actor;
        this.Language = Language;
        this.Rating = Rating;
        this.genre = genre;

    }

    public String getLanguage() {
        return Language;
    }

    public void setLanguage(String Language) {
        this.Language = Language;
    }

    public double getRating() {
        return Rating;
    }

    public void setRating(double Rating) {
        this.Rating = Rating;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Actor getActor() {
        return Actor;
    }

    public void setActor(Actor Actor) {
        this.Actor = Actor;
    }

    public String toString() {

        return super.toString() + "Rating: " + this.Rating + ", Language: " + this.Language + ", Genre: " + this.genre + ", Actor: " + this.Actor.getName();
    }

    @Override
    public int compareTo(Event t) {

        if (t instanceof Movie) {

            return (this.Rating > ((Movie) t).getRating()) ? -1 : 1;
        }

        return 0;
    }

}
