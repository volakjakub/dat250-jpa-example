package no.hvl.dat250.jpa.assignment2;

import javax.persistence.*;

@Entity
public class Pincode {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String pincode;
    private Integer count;

    public Pincode(String pincode, Integer count) {
        this.pincode = pincode;
        this.count = count;
    }
    public Pincode() {}
    public Long getId() {
        return id;
    }
    public String getPincode() {
        return this.pincode;
    }
    public int getCount() {
        return this.count;
    }
}
