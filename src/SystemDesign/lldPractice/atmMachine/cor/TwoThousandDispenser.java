package SystemDesign.lldPractice.atmMachine.cor;
/*
public class TwoThousandDispenser implements CashDispenser{
    private CashDispenser next;

    @Override
    public void setNextDispenser(CashDispenser next) {
        this.next = next;
    }

    @Override
    public boolean canDispense(ATM atm, int amount) {
        int count = atm.getTwoThousandCount();
        int notes = Math.min(count,amount/2000);
        int remainder = amount - notes*2000;
        return remainder == 0 || (next != null && next.canDispense(atm,remainder));
    }

    @Override
    public void dispense(ATM atm, int amount) {
        int count = atm.getTwoThousandCount();
        int notes = Math.min(count,amount/2000);
    }


}

 */
