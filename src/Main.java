import java.util.*;

public class Main {

    public static void main(String[] args) {

        System.out.println("Booking Validation");

        Scanner scanner = new Scanner(System.in);

        RoomInventory inventory = new RoomInventory();
        ReservationValidator validator = new ReservationValidator();
        BookingRequestQueue bookingQueue = new BookingRequestQueue();

        try {
            // Input
            System.out.print("Enter guest name: ");
            String guestName = scanner.nextLine();

            System.out.print("Enter room type (Single/Double/Suite): ");
            String roomType = scanner.nextLine();

            // Validation
            validator.validate(guestName, roomType, inventory);

            // If valid → proceed
            bookingQueue.addRequest(guestName, roomType);

            System.out.println("Booking request accepted!");

        } catch (InvalidBookingException e) {

            // Graceful failure handling
            System.out.println("Booking failed: " + e.getMessage());

        } finally {
            scanner.close();
        }
    }
}