package ServiceProvider;

import java.util.ArrayList;
import java.util.List;

public class ReservationSystem {
    private String firstName;
    private String lastName;
    private String email;
    private List<String> users = new ArrayList<>();

    public ReservationSystem() {
        // Default constructor
    }

    public ReservationSystem(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<String> getUsers() {
        return new ArrayList<>(users);
    }

    public void addUser(String email) {
        if (email != null && !email.trim().isEmpty() && !users.contains(email)) {
            users.add(email);
        }
    }

    public void addUser(String firstName, String lastName, String email) {
        if (email != null && !email.trim().isEmpty()) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.email = email;
            addUser(email);
        }
    }

    public boolean search(String email) {
        if (email == null || email.trim().isEmpty()) {
            return false;
        }
        boolean found = users.contains(email);
        if (found) {
            System.out.println("Reservation found for email: " + email);
        } else {
            System.out.println("No reservation found for email: " + email);
        }
        return found;
    }

    public boolean removeUser(String email) {
        if (email == null || email.trim().isEmpty()) {
            return false;
        }
        boolean removed = users.remove(email);
        if (removed) {
            System.out.println("Reservation removed for email: " + email);
            // If the removed email was the current user's email, clear the user data
            if (email.equals(this.email)) {
                this.firstName = null;
                this.lastName = null;
                this.email = null;
            }
        } else {
            System.out.println("No reservation found for email: " + email);
        }
        return removed;
    }

    public void clearAllUsers() {
        users.clear();
        System.out.println("All user reservations cleared.");
    }

    public int getUserCount() {
        return users.size();
    }

    public boolean hasReservation(String email) {
        return email != null && !email.trim().isEmpty() && users.contains(email);
    }

    @Override
    public String toString() {
        return "ReservationSystem{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", totalUsers=" + users.size() +
                '}';
    }
}