import java.io.*;
import java.io.FileWriter;
import java.io.IOException;
class SportFacilities {
    private String facilityName;
    private String date;
    private int durationF;
    private String facilityTime;

    public SportFacilities(String facilityName, String date, int durationF, String facilityTime) {
        this.facilityName = facilityName;
        this.date=date;
        this.durationF=durationF;
        this.facilityTime=facilityTime;
    }

    public void bookFacility(String guestName, String id) {
        Booking booking = new Booking(guestName,id, "Sport Facility: " +facilityName+"\nDate: "+date+"\nUse Duration: "+durationF+"\nTime: "+facilityTime);
        booking.displayBookingDetails();
        writeBookingDetailsToFile(booking);
    }
    private void writeBookingDetailsToFile(Booking booking) {
        try (FileWriter writer = new FileWriter("booking_facilities.txt", true)) {
            writer.write(booking.getBookingDetailsAsString());
            writer.write("\n\n");
            System.out.println("Booking details written to file.");
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file.");
            e.printStackTrace();
        }
    }
}