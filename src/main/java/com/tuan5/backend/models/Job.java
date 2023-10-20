package com.tuan5.backend.models;

import jakarta.persistence.*;
import lombok.*;

@Table(name = "job")
@Getter
@Setter
@ToString
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@EqualsAndHashCode(of = {"jobId"})
public class Job {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "job_id")
    private long jobId;
    @Column(name = "job_desc", length = 2000)
    private String jobDesc;
    @Column(name = "job_name", length = 255)
    private String jobName;

    @ManyToOne
    @JoinColumn(name = "company")
    private Company company;

    public Job(String jobDesc, String jobName, Company company) {
        this.jobDesc = jobDesc;
        this.jobName = jobName;
        this.company = company;
    }
}
