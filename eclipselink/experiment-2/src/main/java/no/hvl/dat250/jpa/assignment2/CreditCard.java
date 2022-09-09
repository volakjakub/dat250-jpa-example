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
    @JoinColumn(name = "person_id", insertable = false, updatable = false)
    private Person person;

    public CreditCard(Integer number, Integer limit, Integer balance) {
        this.number = number;
        this.limit = limit;
        this.balance = balance;
    }
    public CreditCard() {}
    public int getNumber() {
        return this.number;
    }
    public Integer getBalance() {
        return this.balance;
    }
    public Integer getLimit() {
        return this.limit;
    }
    public Pincode getPincode() {
        return this.pincode;
    }
    public Bank getOwningBank() {
        return this.bank;
    }
    public void setPincode(Pincode pincode) {
        this.pincode = pincode;
    }
    public void setBank(Bank bank) {
        this.bank = bank;
    }
    public void setPerson(Person person) {
        this.person = person;
        person.getCreditCards().add(this);
    }
}
