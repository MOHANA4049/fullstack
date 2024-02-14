package com.jobapp.mona.model;
// import java.util.List;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
public class JobList {
    @Id
    @GeneratedValue(strategy=GenerationType.UUID)
    private String jobId;
    @Column(nullable=false)
    private String jobTitle;
    @Column(nullable=false)
    private String jobDescription;
    @Column(nullable=false)
    private String jobLocation;
    @Column(nullable=false)
    private String Salary;
    @Column(nullable=false)
    private String DatePosted;
}
