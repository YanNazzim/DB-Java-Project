import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerDatabase {

    private List<Customer> customers;
    private String connectionString;

    public CustomerDatabase() {
        customers = new ArrayList<Customer>();
        connectionString = "jdbc:ucanaccess://E:/Object Oriented Programming/Week 3/Nazzim_Final_project/src/CustomerDB.accdb";
    }

    public void addCustomer(Customer customer) {
        customers.add(customer);

        try {
            Connection connection = DriverManager.getConnection(connectionString);
            PreparedStatement statement = connection.prepareStatement(
                    "INSERT INTO Customers (CustName, AmountOwed, AmountPaid, Bingos) VALUES (?, ?, ?, ?)");
            statement.setString(1, customer.getName());
            statement.setFloat(2, customer.getAmountOwed());
            statement.setFloat(3, customer.getAmountPaid());
            statement.setString(4, customer.getBingos().toString());
            statement.executeUpdate();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void removeCustomer(Customer customer) {
        customers.remove(customer);

        try {
            Connection connection = DriverManager.getConnection(connectionString);
            PreparedStatement statement = connection.prepareStatement("DELETE FROM Customers WHERE CustName=?");
            statement.setString(1, customer.getName());
            statement.executeUpdate();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Customer getCustomer(String name) {
        for (Customer customer : customers) {
            if (customer.getName().equals(name)) {
                return customer;
            }
        }

        return null;
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public float calculateTotalAmountOwed() {
        float total = 0;

        for (Customer customer : customers) {
            total += customer.getAmountOwed();
        }

        return total;
    }

    public float calculateTotalAmountPaid() {
        float total = 0;

        for (Customer customer : customers) {
            total += customer.getAmountPaid();
        }

        return total;
    }

    public float calculateTotalBalanceDue() {
        float total = 0;

        for (Customer customer : customers) {
            total += customer.calculateBalance();
        }

        return total;
    }

    public void viewCustomerDetails(String name) {
        Customer customer = getCustomer(name);

        if (customer != null) {
            System.out.println(customer.toString());
        } else {
            System.out.println("Customer not found.");
        }
    }
}
