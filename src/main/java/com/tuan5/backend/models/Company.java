package com.tuan5.backend.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "company")
@Getter
@Setter
@ToString
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = {"comId"})
public class Company {
    @Id
    @Column(name = "com_Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long comId;
    @Column(length = 2000)
    private String about;
    @Column(name = "comp_name",length = 255)
    private String companyName;
    @Column(length = 255)
    private String email;
    @Column(length = 255)
    private String phone;
    @Column(name = "web_url", length = 255)
    private String webUrl;

    @OneToOne
    @JoinColumn(name = "address")
    private Address address;

    public Company(String about, String companyName, String email, String phone, String webUrl, Address address) {
        this.about = about;
        this.companyName = companyName;
        this.email = email;
        this.phone = phone;
        this.webUrl = webUrl;
        this.address = address;
    }
}
