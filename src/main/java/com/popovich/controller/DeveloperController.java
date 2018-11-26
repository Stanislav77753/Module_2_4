package com.popovich.controller;

import com.popovich.model.Developer;
import com.popovich.service.DeveloperService;

import java.util.List;

public class DeveloperController {
    private DeveloperService developerService = new DeveloperService();

    public void save(Developer developer){
        developerService.save(developer);
    }

    public void update(Developer developer){
        developerService.update(developer);
    }

    public List<Developer> getAll(){
        return developerService.getAll();
    }

    public void delete(Developer developer){
        developerService.delete(developer);
    }
}
