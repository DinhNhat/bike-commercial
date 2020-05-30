package com.nhatdinhnguyen.bicycleproject.db.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "staffs")
public class Staff {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "staff_id")
    private Integer id;

    @Embedded
    @AttributeOverrides(value = {
            @AttributeOverride(name = "firstName", column = @Column(name = "first_name")),
            @AttributeOverride(name = "lastName", column = @Column(name = "last_name")),
            @AttributeOverride(name = "email", column = @Column(name = "email")),
            @AttributeOverride(name = "phone", column = @Column(name = "phone")),
    })
    private Person person;

    @Override
    public String toString() {
        return "Staff{" +
                "id=" + id +
                ", person=" + person +
                ", active=" + active +
                ", manager=" + manager +
                '}';
    }

    @Column(name = "active", length = 1)
    private Integer active;

    @ManyToOne
    @JoinColumn(name = "manager_id", nullable = true)
    private Staff manager;

    @OneToMany(mappedBy = "manager",
            fetch = FetchType.EAGER,
            cascade = CascadeType.ALL)
    private List<Staff> staffs = new ArrayList<>();

    public Staff() {}

    public Staff(Person person, Integer active) {
        this.person = person;
        this.active = active;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Integer getActive() {
        return active;
    }

    public void setActive(Integer active) {
        this.active = active;
    }
}
