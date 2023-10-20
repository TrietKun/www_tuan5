package com.tuan5.backend.models;

import com.neovisionaries.i18n.CountryCode;
import com.tuan5.backend.enums.Country;
import jakarta.persistence.*;
import lombok.*;
import com.neovisionaries.i18n.CountryCode;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@Entity
@Table(name = "address")
@Getter
@Setter
@ToString
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of={"id"})
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(length = 20)
    private long id;
    @Column(length = 6)
    private CountryCode country;
    @Column(length = 7)
    private String zipcode;
    @Column(length = 20)
    private String number;
    @Column(length = 50)
    private String city;
    @Column(length = 150)
    private String street;

    public Address(CountryCode country, String zipcode, String city, String street, String number) {
        this.country = country;
        this.zipcode = zipcode;
        this.number = number;
        this.city = city;
        this.street = street;
    }

    public Address(String number, String street, String city, String zipcode, CountryCode countryCode) {
        this.number = number;
        this.street = street;
        this.city = city;
        this.zipcode = zipcode;
        this.country = countryCode;
    }

}
