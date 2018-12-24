package com.baizhi.controller;

import com.baizhi.entity.Admin;
import com.baizhi.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    AdminService as;

    @RequestMapping("getOne")
    public String getOne(Admin admin, String code, HttpSession session) {
        String c = (String) session.getAttribute("code");
        if (session.getAttribute("code").equals(code.toLowerCase())) {
            try {
                Admin admin1 = as.queryOne(admin);
                session.setAttribute("admin", admin1);
                return "redirect:/main/main.jsp";
            } catch (Exception e) {
                return "redirect:/login.jsp";
            }
        } else {
            return "redirect:/login.jsp";
        }
    }

    @RequestMapping("update")
    protected void update(Admin admin) {
        as.update(admin);
    }

    @RequestMapping("exit")
    protected void exit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(true);
        session.invalidate();
        response.sendRedirect(request.getContextPath() + "/login.jsp");
    }
}
