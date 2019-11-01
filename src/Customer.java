

import java.text.SimpleDateFormat;
import java.util.Date;

public class Customer {

    private String CustomerId;
    private String name;
    private char Gender;
    private String Email;
    private String City;
    private Date DateBirth;
    private static int i;

    public Customer(String name, char Gender, Date DateBirth, String Email) {
        this.CustomerId = "00000" + (++i);
        this.name = name;
        this.Gender = Gender;
        this.Email = Email;
        this.DateBirth = DateBirth;
        this.City = City;
    }

    public String getCustomerId() {
        return CustomerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public char getGender() {
        return Gender;
    }

    public void setGender(char Gender) {
        this.Gender = Gender;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public Date getDateBirth() {
        return DateBirth;
    }

    public void setDateBirth(Date DateBirth) {
        this.DateBirth = DateBirth;
    }

    public String toString() {

        return "Number : " + this.CustomerId + " Name: " + this.name + ", Email: " + this.Email + ", BateOfBirth: " + new SimpleDateFormat("dd/MM/yyyy").format(DateBirth);

    }

}
