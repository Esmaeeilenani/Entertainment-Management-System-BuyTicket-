

public class Actor {

    private String Name;
    private char gender;
    private int BirthYear;

    public Actor(String Name, char gender, int BirthYear) {
        this.Name = Name;
        this.gender = gender;
        this.BirthYear = BirthYear;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public int getBirthYear() {
        return BirthYear;
    }

    public void setBirthYear(int BirthYear) {
        this.BirthYear = BirthYear;
    }

    public String toString() {

        return "Actor Name: " + this.Name + ", Actor Gender: " + this.gender + ", Actor BirthYear: " + this.BirthYear;
    }

}
