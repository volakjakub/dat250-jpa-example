package no.hvl.dat250.jpa.assignment2;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String street;
    private Integer number;
    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    @JoinTable(
            name = "address_person",
            joinColumns = @JoinColumn(name = "address_id"),
            inverseJoinColumns = @JoinColumn(name = "person_id"))
    private Set<Person> people = new HashSet<>();

    public Address(String street, Integer number) {
        this.street = street;
        this.number = number;
    }
    public Address() {}
    public String getStreet() {
        return this.street;
    }
    public Integer getNumber() {
        return this.number;
    }
    public Set<Person> getOwners() {
        return this.people;
    }
    public void addPerson(Person person) {
        this.people.add(person);
        person.getAddresses().add(this);
    }
}
