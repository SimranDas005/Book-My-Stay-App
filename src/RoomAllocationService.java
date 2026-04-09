public class RoomAllocationService {

    public void allocateRoom(Reservation reservation, RoomInventory inventory) {

        String roomType = reservation.getRoomType();
        int available = inventory.getAvailableRooms(roomType);

        if (available > 0) {
            String roomId = roomType + "-" + available;

            // Decrease inventory
            inventory.updateAvailability(roomType, available - 1);

            System.out.println("Booking confirmed for Guest: "
                    + reservation.getGuestName()
                    + ", Room ID: " + roomId);
        } else {
            System.out.println("No rooms available for " + reservation.getGuestName());
        }
    }
}