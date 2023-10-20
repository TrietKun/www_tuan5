package com.tuan5.backend.models;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "candidate")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode(of = {"id"})
public class Candidate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(length = 20)
    private long id;
    private LocalDate dob;
    @Column(length = 255)
    private String email;
    @Column(name = "full_name", length = 255)
    private String fullName;
    @Column(length = 15)
    private String phone;

    @OneToOne
    @JoinColumn(name = "id")
    private Address address;

    public Candidate(LocalDate dob, String email, String fullName, String phone, Address address) {
        this.dob = dob;
        this.email = email;
        this.fullName = fullName;
        this.phone = phone;
        this.address = address;
    }

    public Candidate(String name, LocalDate dob, Address address, String phone, String email) {
        this.dob = dob;
        this.email = email;
        this.fullName = name;
        this.phone = phone;
        this.address = address;
    }
}
