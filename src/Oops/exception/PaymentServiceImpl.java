package Oops.exception;

public class PaymentServiceImpl implements PaymentService{
    @Override
    public boolean pay(int amount) throws InvalidPaymentsException{
        if(amount <= 0){
            throw new InvalidPaymentsException("Payment amount must be greater than zero");
        }
        return true;
    }
}
