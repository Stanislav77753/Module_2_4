package com.popovich.model;
import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "developers")
public class Developer extends BaseEntity {

    private String firstName;
    private String lastName;
    private String speciality;
    private Set<Skill> skills = new HashSet<>();
    private Account account;

    public Developer(){
        super();
    }

    public Developer(String firstName, String lastName, String speciality){
        this.firstName = firstName;
        this.lastName = lastName;
        this.speciality = speciality;
    }

    public Developer(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Column(name = "first_name")
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Column(name = "last_name")
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Column(name = "speciality")
    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "developer_skills", joinColumns = @JoinColumn(name = "developer_id"),
            inverseJoinColumns = @JoinColumn(name = "skill_id"))
    public Set<Skill> getSkills() {
        return skills;
    }

    public void setSkills(Set<Skill> skills) {
        this.skills = skills;
    }

    public void addSkill(Skill skill){
        this.skills.add(skill);
    }

    @OneToOne
    @PrimaryKeyJoinColumn
    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}
