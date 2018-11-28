package com.popovich.servlets;

import com.popovich.model.Skill;
import com.popovich.service.SkillService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.List;

@WebServlet(urlPatterns = "/skills")
public class SkillServlet extends HttpServlet {
    private SkillService skillService = new SkillService();


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter writer = resp.getWriter();
        String title = "skills";
        String docType = "<!DOCTYPE html>";
        if(req.getParameter("showSkills") != null){
           showAllSkills(writer, title, docType);
        } else if(req.getParameter("addSkill") != null){
            addSkill(writer,title,docType);
        }else if(req.getParameter("add") != null){
            skillService.save(new Skill(req.getParameter("skillName")));
            req.getRequestDispatcher("/index.jsp").forward(req,resp);
        }else if(req.getParameter("deleteSkill") != null){
            deleteSkill(writer,title,docType);
        }else if(req.getParameter("delete") != null){
            System.out.println("delete");
            String name = req.getParameter("skillName");
            System.out.println(name);
            skillService.delete(new Skill(name));
            req.getRequestDispatcher("/index.jsp").forward(req,resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);

    }

    private void showAllSkills(PrintWriter writer, String title, String docType){
        List<Skill> skills = skillService.getAll();
        writer.println(docType + "<html><head><title>" + title + "</title></head><body>");
        writer.println("<h1>" +"All skills"+ "</h1>");
        writer.println("<table border=\"1\">");
        writer.println("<tr>");
        writer.println("<th>" + "ID" + "</th>");
        writer.println("<th>" + "SKILL" + "</th>");
        writer.println("</tr>");
        for(Skill skill: skills){
            writer.println("<tr>");
            writer.println("<th>" + skill.getId() + "</th>");
            writer.println("<th>" + skill.getSkillName() + "</th>");
            writer.println("</tr>");
        }
        writer.println("</table>");
        writer.println("<p><a href=\"../../index.jsp\">" + "Main menu" + "</a></p>");
        writer.println("</body></html>");
    }

    private void addSkill(PrintWriter writer, String title, String docType){
        writer.println(docType + "<html><head><title>" + title + "</title></head><body>");
        writer.println("<form name=\"addSkillToDatabase\" method=\"POST\" action=\"skills\">");
        writer.println("<p>");
        writer.println("Enter new skill in database: <input type=\"text\" name=\"skillName\"<br></p>");
        writer.println("<input type=\"submit\" name=\"add\" value=\"add new skill\"<br></p>");
        writer.println("<p><a href=\"../../index.jsp\">" + "Main menu" + "</a></p>");
        writer.println("</form></body></html>");
    }

    private void deleteSkill(PrintWriter writer, String title, String docType){
        writer.println(docType + "<html><head><title>" + title + "</title></head><body>");
        writer.println("<form name=\"deleteSkillName\" method=\"POST\" action=\"skills\">");
        writer.println("<p>");
        writer.println("Enter skill to delete from database: <input type=\"text\" name=\"skillName\"<br></p>");
        writer.println("<input type=\"submit\" name=\"delete\" value=\"delete skill\"<br></p>");
        writer.println("<p><a href=\"../../index.jsp\">" + "Main menu" + "</a></p>");
        writer.println("</form></body></html>");
    }


}
