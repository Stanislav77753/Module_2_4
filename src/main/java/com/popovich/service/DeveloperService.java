package com.popovich.service;

import com.popovich.model.Developer;
import com.popovich.repository.RepoImp.DeveloperRepoImp;

import java.util.List;

public class DeveloperService {
    private DeveloperRepoImp developerRepoImp = new DeveloperRepoImp();

    public void save(Developer developer){
        developerRepoImp.save(developer);
    }

    public void update(Developer developer){
        developerRepoImp.update(developer);
    }

    public List<Developer> getAll(){
        return developerRepoImp.getAll();
    }

    public void delete(Developer developer){
        developerRepoImp.delete(developer);
    }
}
