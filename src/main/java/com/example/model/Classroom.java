package com.example.model;

import javax.persistence.*;
import java.util.Collection;
import java.util.Set;


@Entity
//@Table(name="ClassroomRepository")
public class Classroom {

    @Id
    //@GeneratedValue(strategy=GenerationType.IDENTITY)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  long id;

    private String buildingName;
    private int roomNumber;
    private int maxCapacity;


    //@OneToMany(mappedBy="classroom")
    //private Collection<Class> classes;

    @OneToMany (mappedBy = "classroom", cascade = CascadeType.ALL, fetch = FetchType.EAGER)//te
    //public Set<CourseClass> courseClassesr;
    public Set<Class> classes;
    //public Set<CourseClass>

//    @OneToMany(mappedBy="classroom", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//    private Collection<Class> classes;

    public Classroom() {
    }


    public String getBuildingName() {
        return buildingName;
    }

    public void setBuildingName(String buildingName) {
        this.buildingName = buildingName;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public int getMaxCapacity() {
        return maxCapacity;
    }

    public void setMaxCapacity(int maxCapacity) {
        this.maxCapacity = maxCapacity;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

//    public Collection<Class> getClasses() {
//        return classes;
//    }
//
//    public void setClasses(Collection<Class> classes) {
//        this.classes = classes;
//    }

    public Set<Class> getClasses() {
        return classes;
    }

    public void setClasses(Set<Class> classes) {
        this.classes = classes;
    }
}
