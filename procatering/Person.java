package procatering;

/**
 * Person include get and set method's for: <br> - DOB (Date of Birth), firstName, lastName, phoneNumber, email. <br>
 * - all of these are a object of the type String.<br><br>
 * The class constructor require (String, String, String, String) and are going to fill the variables (firstName,lastName,phoneNumber,email)
 *
 * @author TEAM 17
 */
public abstract class Person {
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;
    private int postalCode;

    /**
     * Person constructor except all parameters have been checked and is correct before trying to create an object of person.
     *
     * @param fn    String
     * @param ln    String
     * @param phone String
     * @param mail  String
     * @param pCode String postal code
     */
    public Person(String fn, String ln, String phone, String mail, int pCode) {
        firstName = fn;
        lastName = ln;
        phoneNumber = phone;
        email = mail;
        postalCode = pCode;
    }

    /**
     * Method returns the fist name of the Person.
     *
     * @return the firstName of the person.
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * lastName are of object type String
     *
     * @return the last name of the Person.
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Returns the phone number of the Person.
     *
     * @return the phone number of the person.
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * The persons email.
     *
     * @return the persons email.
     */
    public String getEmail() {
        return email;
    }

    /**
     * @return returns the postal code
     */
    public int getPostalCode() {
        return postalCode;
    }

    /**
     * Is to be used by the sub classes of this object.
     * The method checks whether the Persons first name and phone number is the same.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Person person = (Person) o;

        return firstName.toUpperCase().equals(person.firstName.toUpperCase()) && phoneNumber.equals(person.phoneNumber);

    }

    @Override
    public int hashCode() {
        int result = firstName.hashCode();
        result = 31 * result + phoneNumber.hashCode();
        return result;
    }

    /**
     * Returns a string representation of the object.
     *
     * @return class information: <br>DOB, firstName, lastName, phoneNumber, email
     */
    @Override
    public String toString() {
        return "Person{ firstName=" + firstName + ", lastName=" + lastName + ", phoneNumber=" + phoneNumber + ", email=" + email + '}';
    }
}