package com.popovich.controller;

import com.popovich.model.Skill;
import com.popovich.service.SkillService;

import java.util.List;

public class SkillController {
    private SkillService skillService = new SkillService();

    public void save(Skill skill){
        skillService.save(skill);
    }

    public List<Skill> getAll(){
        return skillService.getAll();
    }

    public void delete(Skill skill){
        skillService.delete(skill);
    }
}
