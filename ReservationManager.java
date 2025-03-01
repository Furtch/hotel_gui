import java.util.ArrayList;

public class ReservationManager {
    private ArrayList<HotelReservation> reservations;

    public ReservationManager() {
        reservations = new ArrayList<>();
    }

    public void addReservation(HotelReservation reservation) {
        reservations.add(reservation);
    }

    public void showAllReservations() {
        if (reservations.isEmpty()) {
            System.out.println("No reservations made yet.");
        } else {
            for (HotelReservation res : reservations) {
                System.out.println(res.getReservationDetails());
            }
        }
    }
}