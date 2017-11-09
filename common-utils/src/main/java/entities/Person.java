package entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Calendar;

@Entity
public class Person implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private String name;
    @Temporal(TemporalType.DATE)
    private Calendar bornDate;
    @Transient
    private Integer age;

    public Person() {
    }

    public Person(String name, Calendar bornDate, Integer age) {
        this.name = name;
        this.bornDate = bornDate;
        this.age = age;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Calendar getBornDate() {
        return bornDate;
    }

    public void setBornDate(Calendar bornDate) {
        this.bornDate = bornDate;
        calculateAge();
    }

    public Integer getAge() {
        return age;
    }

    private void calculateAge() {
        Integer yearNow = Calendar.getInstance().YEAR;
        Integer yearBirth = getBornDate().YEAR;
        this.age = yearNow - yearBirth;
    }

}
