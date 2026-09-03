package SystemDesign.designPatterns;

interface Payment{
    void pay();
}

class UPIPayment implements Payment{
    @Override
    public void pay(){
        System.out.println("Payment using UPI");
    }
}

class CardPayment implements Payment{
    @Override
    public void pay(){
        System.out.println("Payment using Card");
    }
}

class PaymentFactory{
    public static Payment getPayment(String paymentType){
        if (paymentType.equalsIgnoreCase("UPI")) {
            return new UPIPayment();

        } else if (paymentType.equalsIgnoreCase("CARD")) {
            return new CardPayment();

        } else {
            throw new IllegalArgumentException(
                    "Invalid payment type: " + paymentType
            );
        }
    }
}
public class FactoryPattern {
    static void main() {
        String paymentType = "UPI";

        Payment payment =
                PaymentFactory.getPayment(paymentType);

        payment.pay();
    }
}
