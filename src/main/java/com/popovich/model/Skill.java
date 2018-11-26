package com.popovich.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "skills")
public class Skill extends BaseEntity{
    private String skillName;
    private Set<Developer> developers = new HashSet<>();

    public Skill(){
        super();
    }

    public Skill(String skillName){
        super();
        this.skillName = skillName;
    }

    @Column(name = "skill_name",unique = true, nullable = false)
    public String getSkillName() {
        return skillName;
    }

    public void setSkillName(String skillName) {
        this.skillName = skillName;
    }

    @ManyToMany(mappedBy = "skills")
    public Set<Developer> getDevelopers() {
        return developers;
    }

    public void setDevelopers(Set<Developer> developers) {
        this.developers = developers;
    }

    /*public boolean equals(Object object) {
        if (object == null) {
            return false;
        }
        if (!this.getClass().equals(object.getClass())) {
            return false;
        }

        Skill object2 = (Skill) object;
        if ((this.id == object2.getId()) && (this.name == object2.getName())) {
            return true;
        }
        return false;
    }

    public int hasCode() {
        int code = 0;
        code = (id + name).hashCode();
        return code;
    }*/
}
