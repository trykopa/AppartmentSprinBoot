package ua.kiev.prog.TestApp.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
public class App {
    @Id
    @GeneratedValue
    private Long id;

    private String adr;

    @OneToMany(mappedBy="app", cascade= CascadeType.ALL)
    private List<People> people = new ArrayList<People>();

    public App(){}

    public App(String adr){
        this.adr = adr;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAdr() {
        return adr;
    }

    public void setAdr(String adr) {
        this.adr = adr;
    }

    public List<People> getPeople() {
        return people;
    }

    public void setPeople(List<People> people) {
        this.people = people;
    }
}
