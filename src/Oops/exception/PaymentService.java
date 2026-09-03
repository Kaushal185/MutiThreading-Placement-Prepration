package Oops.exception;

public interface PaymentService {
    boolean pay(int amount) throws InvalidPaymentsException;
}
