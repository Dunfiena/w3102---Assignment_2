<%@ page import="com.example.webassign2.Model.User" %>
<%@ page import="com.example.webassign2.Controller.productController" %>
<%@ page import="com.example.webassign2.Controller.cartController" %>
<%@ page import="com.example.webassign2.Model.Product" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    User user = (User)request.getAttribute("user");
    productController pcon = new productController();
    cartController ccon = new cartController();
    ArrayList<Product> products = new ArrayList<>();

    products = pcon.select();


%>
<html>
<head>
    <title>Shop - Styles by John Arbuckle</title>
</head>
<body>
<div class="sidebar">

</div>

<div class="display_body">
    <div class="nav">
        <a href="displayPage.jsp"><img src="assets/clothes_icon.png" alt="items" width="5%"></a>
        <a href="checkout.jsp"><img src="assets/cart_icon.png" alt="cart" width="5%"></a>
    </div>

    <div class="card_Body">
        <div class="card">
            <div class="card_img">

            </div>
            <div class="card_blurb">
                Shirts by John Arbuckle are sexy
            </div>

        </div>
    </div>

</div>
</body>
</html>
