package com.springdatajpa.practicespringdatajpa.Entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long employeeId;
    private String firstName;
    private String lastName;
    @ManyToMany(
        cascade = CascadeType.ALL
    )
    @JoinTable(
        name="employee_project",
         joinColumns=@JoinColumn(
            name="fk_employee_id"
         ),
         inverseJoinColumns=@JoinColumn(
            name="fk_project_id"
         )
    )
    private List<Project> project;

    public void addProject(Project projects){
        if(project==null)project=new ArrayList<>();
        project.add(projects);
    }
}
