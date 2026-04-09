public class ConcurrentBookingProcessor implements Runnable {

    private BookingRequestQueue bookingQueue;
    private RoomInventory inventory;
    private RoomAllocationService allocationService;

    public ConcurrentBookingProcessor(
            BookingRequestQueue bookingQueue,
            RoomInventory inventory,
            RoomAllocationService allocationService) {

        this.bookingQueue = bookingQueue;
        this.inventory = inventory;
        this.allocationService = allocationService;
    }

    @Override
    public void run() {

        while (true) {
            Reservation reservation;

            // 🔒 Critical Section 1: Fetch from queue
            synchronized (bookingQueue) {
                reservation = bookingQueue.getNextRequest();

                // Stop thread if no more requests
                if (reservation == null) {
                    break;
                }
            }

            // 🔒 Critical Section 2: Allocate room (mutates inventory)
            synchronized (inventory) {
                allocationService.allocateRoom(reservation, inventory);
            }
        }
    }
}