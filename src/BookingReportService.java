import java.util.*;

public class BookingReportService {

    // Generate and display report
    public void generateReport(BookingHistory history) {

        System.out.println("Booking History Report");

        List<Reservation> reservations = history.getConfirmedReservations();

        for (Reservation r : reservations) {
            System.out.println("Guest: " + r.getGuestName() +
                    ", Room Type: " + r.getRoomType());
        }
    }
}