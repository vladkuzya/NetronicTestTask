package com.netronic.model;

import com.netronic.model.location.Location;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne(cascade = CascadeType.ALL)
    private Name name;
    @OneToOne(cascade = CascadeType.ALL)
    private Location location;
    private String email;
    @OneToOne(cascade = CascadeType.ALL)
    private Login login;
    @OneToOne(cascade = CascadeType.ALL)
    private Dob dob;
    @OneToOne(cascade = CascadeType.ALL)
    private Registered registered;
    private String phone;
    private String cell;
    @OneToOne(cascade = CascadeType.ALL)
    private Idd idd;
    @OneToOne(cascade = CascadeType.ALL)
    private Picture picture;
    private String nat;
}
