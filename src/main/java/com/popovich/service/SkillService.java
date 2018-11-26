package com.popovich.service;

import com.popovich.model.Skill;
import com.popovich.repository.SkillRepoImp;

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
        skillRepoImp.delete(skill);
    }
}
