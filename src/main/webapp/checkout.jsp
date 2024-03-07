<%@ page import="com.example.webassign2.Controller.cartController" %>
<%@ page import="com.example.webassign2.Model.User" %>
<%@ page import="java.sql.SQLException" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.example.webassign2.Model.Cart" %>
<%@ page import="com.example.webassign2.Model.Product" %>
<%@ page import="com.example.webassign2.Controller.productController" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    User user = (User)request.getAttribute("user");
    ArrayList<Cart> carts = new ArrayList<>();
    ArrayList<Product> products = new ArrayList<>();
    cartController ccon = new cartController();
    productController pcon = new productController();
    try {
        carts = ccon.select(user.getId());
        for (Cart cart : carts) {
            products = pcon.select(cart.getItem_id());
        }
    } catch (SQLException e) {
        throw new RuntimeException(e);
    }
%>
<html>
<head>
    <link rel="stylesheet" href="CSS/checkoutCSS.css">
    <title>Shop - Styles by John Arbuckle</title>
</head>
<body>
<div class="checkout_body">
    <div class="left">
        <div class="Title">Account Shipping Information</div>
        <div class="login"><button>Login</button></div>
        <div class="Account_details">
            First Name: <%=user.getFirstname()%>
            <br>Last Name: <%=user.getLastname()%>
            <br>Phone: <%=user.getPhone()%>
            <br>Email: <%=user.getEmail()%>

            Street Number:
            &nbsp; &nbsp; Street Name:
            <br>City:
            &nbsp; &nbsp; Province:
            <br>Postal Code:

            First Name:
            <br>Last Name:
            <br>Phone:
            <br>Email:

            Street Number:
            &nbsp; &nbsp; Street Name:
            <br>City:
            &nbsp; &nbsp; Province:
            <br>Postal Code:


        </div>

    </div>

    <div class="right">
        <div class="nav">
        <a href="displayPage.jsp"><img src="assets/clothes_icon.png" alt="items" width="25%"></a>
        <a href="checkout.jsp"><img src="assets/cart_icon.png" alt="cart" width="25%"></a>
        </div>

        <div class="cart">
            <div class="cartItem">
                <table>
                    <tr>
                        <th>Item Name</th>
                        <td></td>
                    </tr>
                    <tr>
                        <th>Item Quantity</th>
                        <td></td>
                    </tr>
                    <tr>
                        <th>Price</th>
                        <td></td>
                    </tr>

                </table>
            </div>
        </div>

    </div>



</div>
</body>
</html>
