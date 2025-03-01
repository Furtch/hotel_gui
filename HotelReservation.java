public class HotelReservation {
    private String guestName;
    private String roomType;
    private int nights;
    private double roomPrice;
    private double extras;

    public HotelReservation(String guestName, String roomType, int nights, double roomPrice, double extras) {
        this.guestName = guestName;
        this.roomType = roomType;
        this.nights = nights;
        this.roomPrice = roomPrice;
        this.extras = extras;
    }

    public double calculateTotalCost() {
        return (roomPrice * nights) + (extras * nights);
    }

    public String getReservationDetails() {
        return "Guest: " + guestName + "\nRoom Type: " + roomType + "\nNights: " + nights + "\nTotal Cost: $" + calculateTotalCost();
    }
}