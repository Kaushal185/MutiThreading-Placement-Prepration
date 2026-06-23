package SystemDesign.lldPractice.atmMachine;

public class Card {
    String cardNumber;
    String pin;
    Account account;

    public Card(String cardNumber, String pin, Account account) {
        this.cardNumber = cardNumber;
        this.pin = pin;
        this.account = account;
    }
}
