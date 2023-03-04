package com.springdatajpa.practicespringdatajpa.Repository;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.springdatajpa.practicespringdatajpa.Entity.Employee;
import com.springdatajpa.practicespringdatajpa.Entity.Project;

import jakarta.transaction.Transactional;

@SpringBootTest
public class EmployeeRepoTest {
    @Autowired
    private EmployeeRepository empRepo;
    @Test
    @DisplayName("Save Employee With Project")
    public void saveEmployee(){
        Employee employee=Employee.builder().firstName("Zubair")
        .lastName("basha").build();
        Project project=Project.builder().title("GPTC TRS APPLICATION")
        .build();
        Project project2=Project.builder().title("Tech publications")
        .build();
        employee.addProject(project);
        employee.addProject(project2);
        empRepo.save(employee);
    }
    @Test
    @DisplayName("Print Employee with project")
    @Transactional
    public void getEmployeeWithProject(){
        List<Employee> employee=empRepo.findAll();
        for(Employee emp:employee){
            System.out.println("Name of the Employee:"+emp.getFirstName()+
            "  "+emp.getLastName());
            for(Project project:emp.getProject()){
              System.out.println("Project detail: "+project.getTitle());
            }
        }

        
    }
}
