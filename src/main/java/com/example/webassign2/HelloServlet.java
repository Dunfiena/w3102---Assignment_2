package com.example.webassign2;

import java.io.*;
import java.sql.SQLException;

import com.example.webassign2.Controller.userController;
import com.example.webassign2.Model.User;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;

public class HelloServlet extends HttpServlet {

    public void init() {

    }

    public void doGet(HttpServletRequest req, HttpServletResponse resp) {
        HttpSession mySession = req.getSession();
        String URL = req.getServletPath();
        switch (URL){
            case "/login":
                try {
                    login(req, resp);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                break;
            case "/Register":
                try {
                    register(req,resp);
                } catch (SQLException | ServletException | IOException e) {
                    throw new RuntimeException(e);
                }
                break;
            case "/addtoCart":
                addtoCart(req,resp);
                break;
            case "addAddress":
                addAddress(req,resp);
                break;

        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
        HttpSession mySession = req.getSession();
        String URL = req.getServletPath();
        switch (URL){
            case "/login":
                try {
                    login(req, resp);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                break;
            case "/Register":
                try {
                    register(req,resp);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                break;
            case "/addtoCart":
                addtoCart(req,resp);
                break;
            case "addAddress":
                addAddress(req,resp);
                break;

        }
    }

    private void addAddress(HttpServletRequest req, HttpServletResponse resp) {
    }

    private void addtoCart(HttpServletRequest req, HttpServletResponse resp) {

    }

    private void register(HttpServletRequest req, HttpServletResponse resp) throws SQLException, ServletException, IOException {
        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
        String phone = req.getParameter("phone");

        String email = req.getParameter("email");
        String password = req.getParameter("password");

        userController uCon = new userController();
        User user = new User(1L,firstName, lastName, phone, email, password, 1);
                uCon.insert(user);

        req.setAttribute("user", user);
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/displayPage.jsp");
        rd.include(req,resp);
        rd.forward(req,resp);
        resp.sendRedirect("displayPage.jsp");

    }

    private void login(HttpServletRequest req, HttpServletResponse resp) throws SQLException, IOException {
        HttpSession session = req.getSession();

        String email = (String) session.getAttribute("email");
        String password = (String) session.getAttribute("password");

        userController uCon = new userController();
        User user = uCon.select(email, password);

        session.setAttribute("user", user);
        resp.sendRedirect("checkout.jsp");
    }
}