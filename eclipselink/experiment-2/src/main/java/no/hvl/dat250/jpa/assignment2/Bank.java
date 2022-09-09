package no.hvl.dat250.jpa.assignment2;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

@Entity
public class Bank {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @OneToMany(mappedBy = "bank")
    private Set<CreditCard> ownedCards;

    public Bank(String name) {
        this.name = name;
    }
    public Bank() {}
    public Long getId() {
        return id;
    }
    public String getName() {
        return this.name;
    }
    public Set<CreditCard> getOwnedCards() {
        return this.ownedCards;
    }
}
