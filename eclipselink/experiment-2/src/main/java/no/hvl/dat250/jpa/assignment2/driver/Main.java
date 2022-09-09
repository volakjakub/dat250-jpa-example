package no.hvl.dat250.jpa.assignment2.driver;

import no.hvl.dat250.jpa.assignment2.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Main {
    public static final String PERSISTENCE_UNIT_NAME = "experiment2";

    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        EntityManager em = factory.createEntityManager();
        EntityTransaction ex = em.getTransaction();

        ex.begin();
        Bank bank = new Bank("Pengebank");
        em.persist(bank);

        Pincode pincode = new Pincode("123", 1);
        em.persist(pincode);

        Person person = new Person("Max Mustermann");
        em.persist(person);

        Address address = new Address("Inndalsveien", 28);
        address.addPerson(person);
        em.persist(address);

        CreditCard cc1 = new CreditCard(12345, -10000,-5000);
        cc1.setBank(bank);
        cc1.setPincode(pincode);
        cc1.setPerson(person);
        CreditCard cc2 = new CreditCard(123, 2000,1);
        cc2.setBank(bank);
        cc2.setPincode(pincode);
        cc2.setPerson(person);
        em.persist(cc1);
        em.persist(cc2);

        em.flush();
        ex.commit();
        em.close();
        factory.close();
    }
}
