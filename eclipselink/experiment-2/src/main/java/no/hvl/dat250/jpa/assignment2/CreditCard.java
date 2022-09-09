package no.hvl.dat250.jpa.assignment2;

import javax.persistence.*;

@Entity
public class CreditCard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer number;
    private Integer limit;
    private Integer balance;
    @OneToOne
    @JoinColumn(name = "pincode_id")
    private Pincode pincode;
    @ManyToOne
    @JoinColumn(name = "bank_id")
    private Bank bank;
    @ManyToOne
    @JoinColumn(name = "person_id")
    private Person person;

    public CreditCard(Integer number, Integer limit, Integer balance, Pincode pincode, Bank bank, Person person) {
        this.number = number;
        this.limit = limit;
        this.balance = balance;
        this.pincode = pincode;
        this.bank = bank;
        this.person = person;
    }
    public CreditCard() {}
    public int getNumber() {
        return this.number;
    }
    public String getBalance() {
        return this.balance.toString();
    }
    public String getLimit() {
        return this.limit.toString();
    }
    public Pincode getPincode() {
        return this.pincode;
    }
    public Bank getOwningBank() {
        return this.bank;
    }
}
