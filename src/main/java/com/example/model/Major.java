package com.example.model;

import javax.persistence.*;
import java.util.Collection;


@Entity
@Table(name="Major")
public class Major {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private  long id;

    private String name;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "department_id")
    private Department department;

    @OneToMany(mappedBy="major")
    private Collection<Student> students;

    public Major() {
    }

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
}
