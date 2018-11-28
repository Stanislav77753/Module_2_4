package com.popovich.service;

import com.popovich.model.Skill;
import com.popovich.repository.RepoImp.SkillRepoImp;

import java.util.List;

public class SkillService {
    private SkillRepoImp skillRepoImp = new SkillRepoImp();

    public void save(Skill skill){
        skillRepoImp.save(skill);
    }

    public List<Skill> getAll(){
        return skillRepoImp.getAll();
    }

    public void delete(Skill skill){
        List<Skill> skills = getAll();
        for(Skill skill_db: skills){
            if(skill_db.getSkillName().equals(skill.getSkillName())){
                skillRepoImp.delete(skill_db);
            }
        }
    }
}
