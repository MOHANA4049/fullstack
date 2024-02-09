package com.jobapp.mona.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
// import jakarta.persistence.JoinColumn;
// import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Company {
    @Id
    @GeneratedValue(strategy=GenerationType.UUID)
    private String companyId;
    @Column(nullable=false)
    private String companyName;

    @Column(nullable=false)
    private String companyDescription;

    @Column(nullable=false)
    private String companyLocation;

    // @OneToMany
    // @JoinColumn(name="id")
    // private User user;
}

