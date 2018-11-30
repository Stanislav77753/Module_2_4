package com.popovich.servlets;

import com.popovich.model.Account;
import com.popovich.model.Developer;
import com.popovich.model.Skill;
import com.popovich.service.AccountService;
import com.popovich.service.DeveloperService;
import com.popovich.service.SkillService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

@WebServlet(urlPatterns = "/developers")
public class DeveloperServlet extends HttpServlet {
    private DeveloperService developerService = new DeveloperService();
    private AccountService accountService = new AccountService();
    private SkillService skillService = new SkillService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter writer = resp.getWriter();
        String title = "developers";
        String docType = "<!DOCTYPE html>";
        if(req.getParameter("showDevelopers") != null){
            showAllDevelopers(writer,title,docType);
        } else if(req.getParameter("addDeveloper") != null){
            addDeveloper(writer,title,docType);
        }else if(req.getParameter("add") != null){
            Developer developer = new Developer(req.getParameter("firstName"), req.getParameter("lastName"),
                    req.getParameter("speciality"));
            Account account = new Account();
            List<Skill> skills = skillService.getAll();
            String[] skillNames = req.getParameterValues("developer_skill");
            for(String skillName : skillNames){
                for(Skill skill : skills){
                    if(skillName.equals(skill.getSkillName())){
                        Skill developerSkill = new Skill(skill.getSkillName());
                        developerSkill.setId(skill.getId());
                        developer.addSkill(developerSkill);
                    }
                }
            }
            account.setAccountData(req.getParameter("account"));
            developer.setAccount(account);
            developerService.save(developer);
            accountService.save(account);
            req.getRequestDispatcher("/index.jsp").forward(req,resp);
        }else if(req.getParameter("AddSkillToDeveloper") != null){
            Long id = new Long(req.getParameter("developer_id"));
            addSkill(writer,title,docType,id);

        }else if(req.getParameter("addSkills") != null){
            String[] skillNames = req.getParameterValues("developer_skill");
            List<Developer> developers = developerService.getAll();
            List<Skill> skills = skillService.getAll();
            for(Developer developer : developers){
                if(developer.getId().equals(new Long(req.getParameter("developer_id")))){
                    for(String skillName : skillNames){
                        for(Skill skill : skills){
                            if(skillName.equals(skill.getSkillName())){
                                developer.addSkill(skill);
                            }
                        }
                    }
                }
                developerService.update(developer);
                req.getRequestDispatcher("/index.jsp").forward(req,resp);
            }

        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }

    private void showAllDevelopers(PrintWriter writer, String title, String docType){
        List<Developer> developers = developerService.getAll();
        writer.println(docType + "<html><head><title>" + title + "</title></head><body>");
        writer.println("<h1>" +"All developers"+ "</h1>");
        writer.println("<table border=\"1\">");
        writer.println("<tr>");
        writer.println("<th>" + "ID" + "</th>");
        writer.println("<th>" + "First name" + "</th>");
        writer.println("<th>" + "Last name" + "</th>");
        writer.println("<th>" + "Speciality" + "</th>");
        writer.println("<th>" + "Skills" + "</th>");
        writer.println("<th>" + "Account" + "</th>");
        writer.println("<th>" + "-" + "</th>");
        writer.println("</tr>");
        for(Developer developer: developers){
            writer.println("<tr>");
            writer.println("<th>" + developer.getId() + "</th>");
            writer.println("<th>" + developer.getFirstName() + "</th>");
            writer.println("<th>" + developer.getLastName() + "</th>");
            writer.println("<th>" + developer.getSpeciality() + "</th>");
            if(!developer.getSkills().isEmpty() && developer.getSkills().size() > 0){
                writer.println("<th>" + getSkillForDeveloper(developer) + "</th>");
            }else{
                writer.println("<th>" + "-" + "</th>");
            }
            writer.println("<th>" + developer.getAccount().getAccountData() + "</th>");
            writer.println("<th><form action=\"developers\" method=\"GET\">");
            writer.println("<input type=\"submit\"  name=\"AddSkillToDeveloper\" value=\"Add skill\">");
            writer.println("<input  type=\"hidden\" name=\"developer_id\" value=\"" + developer.getId() +"\"></form></th>");
            writer.println("</tr>");
        }
        writer.println("</table>");
        writer.println("<p><a href=\"../../index.jsp\">" + "Main menu" + "</a></p>");
        writer.println("</body></html>");
    }

    private void addDeveloper(PrintWriter writer, String title, String docType){
        List<Skill> skills = skillService.getAll();
        writer.println(docType + "<html><head><title>" + title + "</title></head><body>");
        writer.println("<form name=\"addDeveloperToDatabase\" method=\"POST\" action=\"developers\">");
        writer.println("<p>");
        writer.println("Enter first name : <input type=\"text\" name=\"firstName\"<br></p>");
        writer.println("Enter last name : <input type=\"text\" name=\"lastName\"<br></p>");
        writer.println("Enter speciality name : <input type=\"text\" name=\"speciality\"<br></p>");
        writer.println("Enter account : <input type=\"text\" name=\"account\"<br></p>");
        writer.println("Select skills from list: <select multiple name=\"developer_skill\" size=\"3\" " +
                "form'\"addDeveloperToDatabase\">");
        writer.println("<option disabled>" + "Select skill" +"</option>");
        for(Skill skill :skills){
            writer.println("<option>" + skill.getSkillName() +"</option>");
        }
        writer.println("</select></p>");
        writer.println("<p><input type=\"submit\" name=\"add\" value=\"add new developer\"<br></p>");
        writer.println("<p><a href=\"../../index.jsp\">" + "Main menu" + "</a></p>");
        writer.println("</form></body></html>");
    }

    private String getSkillForDeveloper(Developer developer){
        StringBuilder sb = new StringBuilder();
        Iterator iterator = developer.getSkills().iterator();
        while(iterator.hasNext()){
            Skill skill = (Skill)iterator.next();
            sb.append(skill.getSkillName() + ",");
        }
        return sb.substring(0,sb.length()-1);
    }
    private void addSkill(PrintWriter writer, String title, String docType, Long id){
        List<Skill> skills = skillService.getAll();
        writer.println(docType + "<html><head><title>" + title + "</title></head><body>");
        writer.println("<form name=\"addSkillToDeveloper\" method=\"POST\" action=\"developers\">");
        writer.println("Select skills from list: <select multiple name=\"developer_skill\" size=\"3\" " +
                "form'\"addDeveloperToDatabase\">");
        writer.println("<option disabled>" + "Select skill" +"</option>");
        for(Skill skill :skills){
            writer.println("<option>" + skill.getSkillName() +"</option>");
        }
        writer.println("</select></p>");
        writer.println("<input type=\"hidden\" name=\"developer_id\" value=\"" + id +"\"></th>");
        writer.println("<p><input type=\"submit\" name=\"addSkills\" value=\"add skills to developers\"<br></p>");
        writer.println("<p><a href=\"../../index.jsp\">" + "Main menu" + "</a></p>");
        writer.println("</form></body></html>");
    }
}
