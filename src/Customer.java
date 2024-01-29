import java.util.List;

public class Customer {

    private String custName;
    private float amountOwed;
    private float amountPaid;
    private List<Integer> bingos;

    public Customer(String custName, float amountOwed, float amountPaid, List<Integer> bingos) {
        this.custName = custName;
        this.amountOwed = amountOwed;
        this.amountPaid = amountPaid;
        this.bingos = bingos;
    }

    public String getName() {
        return custName;
    }

    public void setName(String name) {
        this.custName = name;
    }

    public float getAmountOwed() {
        return amountOwed;
    }

    public void setAmountOwed(float amountOwed) {
        this.amountOwed = amountOwed;
    }

    public float getAmountPaid() {
        return amountPaid;
    }

    public void setAmountPaid(float amountPaid) {
        this.amountPaid = amountPaid;
    }

    public List<Integer> getBingos() {
        return bingos;
    }

    public void setBingos(List<Integer> bingos) {
        this.bingos = bingos;
    }

    public float calculateBalance() {
        // Abstraction is used here to hide the details of the balance calculation
        return amountOwed - amountPaid;
    }

    @Override
    public String toString() {
        return String.format("Name: %s\nAmount Owed: $%.2f\nAmount Paid: $%.2f\nBingos: %s",
                custName, amountOwed, amountPaid, bingos);
    }
}
