package com.popovich.servlets;

import com.popovich.controller.SkillController;
import com.popovich.model.Skill;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SkillServlet extends HttpServlet {
    private SkillController skillController = new SkillController();


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/view/add_skill.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if(req.getParameter("showSkills") != null){
            req.setAttribute("skills", skillController.getAll());
            req.getRequestDispatcher("/WEB-INF/view/all_skills.jsp").forward(req,resp);
        }

    }


}
