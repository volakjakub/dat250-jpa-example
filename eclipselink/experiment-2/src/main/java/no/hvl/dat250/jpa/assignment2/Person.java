package no.hvl.dat250.jpa.assignment2;

import org.eclipse.persistence.jpa.jpql.parser.CollectionExpression;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @OneToMany(mappedBy = "person")
    private final Collection<CreditCard> creditCards = new ArrayList<>();
    @ManyToMany(fetch=FetchType.LAZY, mappedBy = "people")
    private final Collection<Address> addresses = new ArrayList<>();

    public Person(String name) {
        this.name = name;
    }
    public Person() {}
    public String getName() {
        return this.name;
    }
    public Collection<Address> getAddresses() {
        return this.addresses;
    }
    public Collection<CreditCard> getCreditCards() {
        return this.creditCards;
    }
}
