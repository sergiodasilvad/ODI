package ch.hearc.ig.odi.customeraccount.business;

public class Account {

    private Customer customer;
    private String number;
    private String name;
    private double balance = 0;
    private double rate = 0.001;

    public String getNumber() {
        return this.number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBalance() {
        return this.balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getRate() {
        return this.rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public Account() {
    }

    /**
     *
     * @param number
     * @param name
     * @param rate
     * @param customer
     */
    public Account(String number, String name, double rate, Customer customer) {
        this.number = number;
        this.name = name;
        this.rate = rate;
        this.customer = customer;
    }

    /**
     *
     * @param amount
     */
    public void credit(double amount) {
        if (amount > 0) {
            this.balance += amount;
        } else {
            throw new IllegalStateException("Amount must be higher than zero!");
        }
    }

    /**
     *
     * @param amount
     */
    public void debit(double amount) {
        if (amount > 0) {
            if (this.balance - amount >= 0) {
                this.balance -= amount;
            } else {
                throw new IllegalStateException("Impossible to debit ! You don't have more balance !");
            }
        } else {
            throw new IllegalStateException("Amount must be higher than zero!");
        }
    }

    /**
     *
     * @param amount
     * @param source
     * @param target
     */
    public static Account transfer(double amount, Account source, Account target) {
        if (source.getNumber().equals(target.getNumber())) {
            throw new IllegalStateException("Impossible to transfer money in same account !");
        } else {
            source.debit(amount);
            target.credit(amount);
        }
        // Je ne savais pas trop lequel retourné
        return target;
    }

}
