package com.netronic.model.location;

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
@Table(name = "locations")
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne(cascade = CascadeType.ALL)
    private Street street;
    private String city;
    private String country;
    private String postcode;
    @OneToOne(cascade = CascadeType.ALL)
    private Coordinates coordinates;
    @OneToOne(cascade = CascadeType.ALL)
    private Timezone timezone;
}
