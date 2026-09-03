package Oops.exception;

import java.util.Objects;

public class Main {
    static void main() {
        PaymentService paymentService = new PaymentServiceImpl();
        try{
            paymentService.pay(-100);
        }catch (InvalidPaymentsException e){
            e.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
