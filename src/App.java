import java.util.Arrays;

public class App {
    public static void main(String[] args) {
        // Create a new CustomerDatabase object
        CustomerDatabase database = new CustomerDatabase();

        // Create some customers
        Customer customer1 = new Customer("John Smith", 100, 50, Arrays.asList(1, 3, 5));
        Customer customer2 = new Customer("Jane Doe", 75, 0, Arrays.asList(2, 4, 6));

        // Add the customers to the database
        database.addCustomer(customer1);
        database.addCustomer(customer2);

        // Print the list of customers
        System.out.println("List of customers:");
        for (Customer customer : database.getCustomers()) {
            System.out.println(customer.getName());
        }

        // Print the total amount owed
        System.out.println("Total amount owed: $" + database.calculateTotalAmountOwed());

        // Print the total amount paid
        System.out.println("Total amount paid: $" + database.calculateTotalAmountPaid());

        // Print the total balance due
        System.out.println("Total balance due: $" + database.calculateTotalBalanceDue());

        // View customer details
        System.out.println("Customer details for John Smith:");
        database.viewCustomerDetails("John Smith");

        // Remove a customer
        database.removeCustomer(customer2);

        // Print the list of customers again
        System.out.println("List of customers after removing Jane Doe:");
        for (Customer customer : database.getCustomers()) {
            System.out.println(customer.getName());
        }
    }
}
