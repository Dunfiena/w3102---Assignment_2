package com.example.webassign2;

import java.io.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Objects;

import com.example.webassign2.Controller.*;
import com.example.webassign2.Model.*;
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
                } catch (SQLException | IOException | ServletException e) {
                    throw new RuntimeException(e);
                }
                break;
            case "/register":
                try {
                    register(req,resp);
                } catch (SQLException | ServletException | IOException e) {
                    throw new RuntimeException(e);
                }
                break;
            case "/addtoCart":
                try {
                    addtoCart(req,resp);
                } catch (SQLException | ServletException | IOException e) {
                    throw new RuntimeException(e);
                }
                break;
            case "/addAddress":
                try {
                    addAddress(req,resp);
                } catch (SQLException | IOException | ServletException e) {
                    throw new RuntimeException(e);
                }
                break;
            case "/leaveReview":
                try {
                    leaveReview(req, resp);
                } catch (SQLException | IOException e) {
                    throw new RuntimeException(e);
                }
                break;
            case "/addDescription":
                try {
                    addDescription(req,resp);
                } catch (IOException | ServletException | SQLException e) {
                    throw new RuntimeException(e);
                }
                break;

        }
    }



    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
        HttpSession sess = req.getSession();
    }

    private void addDescription(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException, SQLException {
        HttpSession sess = req.getSession();
        String color = req.getParameter("color");
        String type = req.getParameter("type");
        String material = req.getParameter("mat");
        int pattern = Integer.parseInt(req.getParameter("pat"));
        int print = Integer.parseInt(req.getParameter("print"));

        ArrayList<Descriptor> descriptors = new ArrayList<>();

        descriptorController dcon = new descriptorController();
        descriptors = dcon.select(color,type, material, pattern, print);


        sess.setAttribute("desTmp", descriptors);
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/displayPage.jsp");
        rd.include(req,resp);
        rd.forward(req,resp);
        resp.sendRedirect("displayPage.jsp");


    }

    private void leaveReview(HttpServletRequest req, HttpServletResponse resp) throws SQLException, IOException {
        HttpSession sess = req.getSession();
        User user = (User) sess.getAttribute("user");

        int itemId = Integer.parseInt(req.getParameter("itemID"));
        int rating = Integer.parseInt(req.getParameter("rating"));
        String review = req.getParameter("review");

        Review rev = new Review(1, user.getId(), itemId, rating, review);
        reviewController rcon = new reviewController();
        rcon.insert(rev);
        resp.sendRedirect("displayPage.jsp");

    }

    private void addAddress(HttpServletRequest req, HttpServletResponse resp) throws SQLException, ServletException, IOException {
        HttpSession sess = req.getSession();
        int streetNo = Integer.parseInt(req.getParameter("streetNo"));
        String streetName = req.getParameter("streetName");
        String city = req.getParameter("city");
        String province = req.getParameter("province");
        String postal = req.getParameter("postal");
        String building_type = req.getParameter("buildtype");
        Address address = new Address(1, streetNo, streetName, city, province, postal, building_type);

        User user = (User) sess.getAttribute("user");
        addressController acon = new addressController();

        address = acon.insert(address);
        userController ucon = new userController();
        ucon.update(address.getId(), user);

        sess.setAttribute("address", address);
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/checkout.jsp");
        rd.include(req,resp);
        rd.forward(req,resp);
        resp.sendRedirect("checkout.jsp");

    }

    private void addtoCart(HttpServletRequest req, HttpServletResponse resp) throws SQLException, ServletException, IOException {
        HttpSession sess = req.getSession();
        User user = (User) sess.getAttribute("user");
        int itemId = Integer.parseInt(req.getParameter("itemID"));
        int itemQuantity = Integer.parseInt(req.getParameter("itemQuantity"));

        cartController ccon = new cartController();
        Cart cart = new Cart(1,user.getId(), itemId, itemQuantity,1,0,0);
        ccon.insert(cart);

        RequestDispatcher rd = getServletContext().getRequestDispatcher("/displayPage.jsp");
        rd.include(req,resp);
        rd.forward(req,resp);
        resp.sendRedirect("displayPage.jsp");
    }

    private void register(HttpServletRequest req, HttpServletResponse resp) throws SQLException, ServletException, IOException {
        HttpSession sess = req.getSession();
        String firstName = req.getParameter("fname");
        String lastName = req.getParameter("lname");
        String phone = req.getParameter("phone");
        String email = req.getParameter("email");
        String password = req.getParameter("hashpass");

        userController uCon = new userController();
        User user = new User(1,firstName, lastName, phone, email, password, 1);
        uCon.insert(user);

        user = uCon.select(email, password);

        sess.setAttribute("user", user);
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/displayPage.jsp");
        rd.include(req, resp);
        rd.forward(req, resp);
        resp.sendRedirect("displayPage.jsp");
    }

    private void login(HttpServletRequest req, HttpServletResponse resp) throws SQLException, IOException, ServletException {
        HttpSession sess = req.getSession();
        String email = req.getParameter("email");
        String password =req.getParameter("hashpass");

        userController uCon = new userController();
        User user = uCon.select(email, password);

        sess.setAttribute("user", user);
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/displayPage.jsp");
        rd.include(req, resp);
        rd.forward(req, resp);
        resp.sendRedirect("displayPage.jsp");
    }
}