public class Booking {
    private String guestName;
    private String id;
    private String bookingType;
    public Booking(String guestName,String id, String bookingType){
        this.guestName=guestName;
        this.id=id;
        this.bookingType=bookingType;
    }
    public void displayBookingDetails(){
        System.out.println("\n----Booking Details----\nGuest Name: "+guestName+"\nID Number: "+id+"\nBooking Type-"+bookingType);
    }
    public String getBookingDetailsAsString(){
        return "\n-----Booking Details-----\nGuest Name: "+guestName+"\nID Number: "+id+"\nBooking Type - "+bookingType;
    }
}
