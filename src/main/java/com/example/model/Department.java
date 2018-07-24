package com.example.model;

import javax.persistence.*;
import java.util.Collection;
import java.util.Set;


@Entity
//@Table(name="Department")
public class Department {

    @Id
    //@GeneratedValue(strategy=GenerationType.IDENTITY)

    @GeneratedValue(strategy = GenerationType.AUTO)
    //@Column(name = "department_id")
    private  long id;

    private String name;

    //@OneToMany(mappedBy = "department")
    //private Collection<Major> majors;

    @OneToMany(mappedBy = "department", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    //private Collection<Major> majors;
    public Set<Major> majors;

    @OneToMany(mappedBy = "department")
    private Collection<Instructor> instructors;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Major> getMajors() {
        return majors;
    }

    public void setMajors(Set<Major> majors) {
        this.majors = majors;
    }

//    public Set<Major> getMajors() {
//        return majors;
//    }
//
//    public void setMajors(Set<Major> majors) {
//        this.majors = majors;
//    }
}
