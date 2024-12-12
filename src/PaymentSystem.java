public class PaymentSystem {

    public static boolean processPayment(Appointment appointment, String cardNumber) {

        if (cardNumber == null || cardNumber.length() < 16) {
            System.out.println("Invalid card number!");
            return false;
        }

        appointment.markAsPaid();
        System.out.println("Payment processed successfully!");
        return true;
    }
}