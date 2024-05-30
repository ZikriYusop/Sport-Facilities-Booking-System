import java.io.*;
import java.io.FileWriter;
import java.io.IOException;
class SportEquipment {
    private String equipmentName;
    private int durationE;
    private int amount;

    public SportEquipment(String equipmentName, int durationE, int amount) {
        this.equipmentName=equipmentName;
        this.durationE=durationE;
        this.amount=amount;
    }
    public int calcAmount(){
        int price=0;
        price=amount*6;
        return price;
    }
    public void bookEquipment(String guestName, String id) {
        Booking booking = new Booking(guestName,id, "Sport Equipment: " +equipmentName+"\nTime Duration: "+durationE+" Hours\nAmount: "+amount);
        booking.displayBookingDetails();
        writeBookingDetailsToFile(booking);
    }
    private void writeBookingDetailsToFile(Booking booking) {
        try (FileWriter writer = new FileWriter("booking_equipment.txt", true)) {
            writer.write(booking.getBookingDetailsAsString());
            writer.write("\n\n");
            System.out.println("Booking details written to file.");
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file.");
            e.printStackTrace();
        }
    }
}