package com.popovich.controller;

import com.popovich.model.Skill;
import com.popovich.service.SkillService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/skills")
public class SkillController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/pages/add_skill.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if(req.getParameter("showSkills") != null){
            req.setAttribute("skills", getAll());
            req.getRequestDispatcher("/WEB-INF/pages/all_skills.jsp").forward(req,resp);
        }
    }

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
