<%@ page import="com.example.webassign2.Controller.cartController" %>
<%@ page import="com.example.webassign2.Model.User" %>
<%@ page import="java.sql.SQLException" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.example.webassign2.Model.Cart" %>
<%@ page import="com.example.webassign2.Model.Product" %>
<%@ page import="com.example.webassign2.Controller.productController" %>
<%@ page import="com.example.webassign2.Controller.addressController" %>
<%@ page import="com.example.webassign2.Model.Address" %>
<%@ page import="java.util.Objects" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page session="true" %>
<%
    User user = (User)session.getAttribute("user");
    Address address = null;
    ArrayList<Cart> carts = new ArrayList<>();
    ArrayList<Product> products = new ArrayList<>();

    cartController ccon = new cartController();
    productController pcon = new productController();
    addressController acon = new addressController();
    if  (user !=null) {
        try {
            carts = ccon.select(user.getId());
            for (Cart cart : carts) {
                products.addAll(pcon.select(cart.getItem_id()));
            }
            address = acon.select(user.getAddress_id());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
%>
<html>
<head>
    <link rel="stylesheet" href="CSS/checkoutCSS.css">
    <link rel="stylesheet" href="CSS/modalCSS.css">
    <script src="scripts.js"></script>

    <title>Shop - Styles by John Arbuckle</title>
</head>
<body>
<div class="checkout_body">
    <div class="left">
        <div class="Title">Account Shipping Information</div>
        <div class="login"><button onclick="displayLogin()">Login</button></div>
        <div class="Account_details">
            <% if(user != null && address != null){ %>
                First Name: <%=user.getFirstname()%>
                <br>Last Name: <%=user.getLastname()%>
                <br>Phone: <%=user.getPhone()%>
                <br>Email: <%=user.getEmail()%>

                Street Number: <%=address.getStreet_num()%>
                &nbsp; &nbsp; Street Name: <%=address.getStreet_name()%>
                <br>City:<%=address.getCity()%>
                &nbsp; &nbsp; Province: <%=address.getProvince()%>
                <br>Postal Code: <%=address.getPostal()%>

            <%}else if (user != null){%>
                First Name:
                <br>Last Name:
                <br>Phone:
                <br>Email:

            <form class="regAddress" method="post" action="addAddress">
                 <label>
                     Street Number:
                    <input type="number" name="streetNo">
                </label>
                <br>
                <label>
                    Street Name:
                    <input type="text" name="streetName">
                </label>
                <br>
                <label>
                    City:
                    <input type="text" name="city">
                </label>
                <br>
                <label>
                    Province:
                    <input type="text" name="province">

                </label>
                <br>
                <label>
                Postal Code:
                    <input type="text" name="postal">
                </label>

                <button type="submit">Submit</button>
                <button type="reset">Clear</button>
            </form>
            <%}else{%>
            <h2 style="color: red; font-size: 2vw">Please log in</h2>
            First Name:
            <br>Last Name:
            <br>Phone:
            <br>Email:

            Street Number:
            &nbsp; &nbsp; Street Name:
            <br>City:
            &nbsp; &nbsp; Province:
            <br>Postal Code:

                <%}%>


        </div>

    </div>

    <div class="right">
        <div class="nav">
        <a href="displayPage.jsp"><img src="assets/clothes_icon.png" alt="items" width="25%"></a>
        <a href="checkout.jsp"><img src="assets/cart_icon.png" alt="cart" width="25%"></a>
        </div>

        <div class="cart">
            <%
                if (!products.isEmpty()){
                    for (int i = 0; i<products.size();i++ ) {
            %>
            <div class="cartItem">
                <table>
                    <tr>
                        <th>Item Name</th>
                        <td><%=products.get(i).getProduct_name()%></td>
                    </tr>
                    <tr>
                        <th>Item Quantity</th>
                        <td><%=carts.get(i).getItem_quantity()%></td>
                    </tr>
                    <% double price = carts.get(i).getItem_quantity() * products.get(i).getPrice(); %>
                    <tr>
                        <th>Price</th>
                        <td><%=price%></td>
                    </tr>
                </table>
            </div>
            <%}
                }else{ %>
            <div class="empty_text">
                    You have no items in the cart.
                    Please visit the store and buy some stuff.
                <br>
                <a href="displayPage.jsp">To the store</a>
            </div>
            <%}%>
        </div>

    </div>
</div>

<div class="modal_body" id="loginModalID" style="display: none">
    <jsp:include page="componant/login.jsp"></jsp:include>
</div>

<div class="modal_body" id="regModalID" style="display: none">
    <jsp:include page="componant/register.jsp"></jsp:include>
</div>



</body>
</html>
