import java.util.*;

public class BookingHistory {

    // List that stores confirmed reservations
    private List<Reservation> confirmedReservations;

    // Constructor
    public BookingHistory() {
        confirmedReservations = new ArrayList<>();
    }

    // Add a confirmed reservation
    public void addReservation(Reservation reservation) {
        confirmedReservations.add(reservation);
    }

    // Get all confirmed reservations
    public List<Reservation> getConfirmedReservations() {
        return confirmedReservations;
    }
}