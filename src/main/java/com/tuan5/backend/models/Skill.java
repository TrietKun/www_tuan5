package com.tuan5.backend.models;

import com.tuan5.backend.enums.SkillType;
import jakarta.persistence.*;
import lombok.*;
@Table(name = "experience")
@Getter
@Setter
@ToString
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@EqualsAndHashCode(of = {"id"})
public class Skill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "skill_id", length = 20)
    private long id;
    @Column(name = "skill_desc", length = 300)
    private String skillDesc;
    @Column(name = "skill_type", length = 4)
    private SkillType skillType;

    public Skill(String skillDesc, SkillType skillType) {
        this.skillDesc = skillDesc;
        this.skillType = skillType;
    }
}
