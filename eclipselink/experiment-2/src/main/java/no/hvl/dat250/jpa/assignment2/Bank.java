package no.hvl.dat250.jpa.assignment2;

import javax.persistence.*;
import java.util.*;

@Entity
public class Bank {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @OneToMany
    @JoinColumn(name = "bank_id")
    private final Set<CreditCard> ownedCards = new HashSet<>();

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
