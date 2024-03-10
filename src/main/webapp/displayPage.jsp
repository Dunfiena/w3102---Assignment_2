<%@ page import="com.example.webassign2.Model.User" %>
<%@ page import="com.example.webassign2.Controller.productController" %>
<%@ page import="com.example.webassign2.Controller.cartController" %>
<%@ page import="com.example.webassign2.Model.Product" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.sql.SQLException" %>
<%@ page import="com.example.webassign2.Controller.descriptorController" %>
<%@ page import="com.example.webassign2.Model.Descriptor" %>
<%@ page import="com.example.webassign2.Controller.reviewController" %>
<%@ page import="com.example.webassign2.Model.Review" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    User user = (User)session.getAttribute("user");
    productController pcon = new productController();
    cartController ccon = new cartController();
    reviewController rcon = new reviewController();
    ArrayList<Product> products = new ArrayList<>();
    ArrayList<Review> reviews = new ArrayList<>();
    try {
        products = pcon.select();
        if (products != null){
            for (Product prod: products) {
                reviews = rcon.select(Math.toIntExact(prod.getId()));

            }
        }
    } catch (SQLException e) {
        throw new RuntimeException(e);
    }
%>

<%! public void select_att(String color, String type, String material, int pattern, int print) throws SQLException {
    productController pcon = new productController();
    ArrayList<Product> products = new ArrayList<>();
    ArrayList<Descriptor> descriptors = new ArrayList<>();
    descriptorController dcon = new descriptorController();
    descriptors = dcon.select(color, type, material, pattern, print);
    products = pcon.select();
} %>
<html>
<head>
    <link rel="stylesheet" href="CSS/displayPage.css">
    <link rel="stylesheet" href="CSS/modalCSS.css">
    <link rel="stylesheet" href="CSS/starRatingCSS.css">
    <script src="scripts.js"></script>

    <title>Shop - Styles by John Arbuckle</title>
</head>

<body>
<%for (Product product: products){%>
<div class="modal_body_item" id="itemModal<%=product.getId()%>" style="display: none">
    <div class="modal_body_control">
        <div class="modal_left">
            <div class="modal_image" style="background-image: url('<%=product.getImageURL()%>')">
                <!--This is a place for image.  Not a mistake -->
            </div>
            <br>
            <div class="modal_text">
                <form name="add_cart" action="addtoCart" method="post">
                    Name: <%=product.getProduct_name()%> <br>
                    Description: <%=product.getDescription()%> <br>
                    Price: <%=product.getPrice()%>$<br>
                    <label>             Quantity:
                        <input type="number" name="quantity">
                    </label>
                    <input type="hidden" name="productID" value="<%=product.getId()%>">
                    <button type="submit">Add to Cart</button>
                </form>
            </div>
        </div>

        <div class="modal_right">
            <button class="quit_button" onclick="itemModel('itemModal<%=product.getId()%>')">X</button>
            <div class="modal_review">
                <%for (Review rev : reviews ) {
                    if (rev.getItem_id() == product.getId()){%>
                    Rating: <%=rev.getRating()%>
                    Review: <%=rev.getReview_text()%>
                <%}}%>
            </div>

            <div class="modal_leave_review">
                <form name="review" method="post" action="leaveReview">
                    <label>Leave a Review:
                        <input type="text" name="review" placeholder="Leave us with your thoughts =)">
                    </label>

                    <label> Rating:
                        <jsp:include page="componant/starRating.jsp"></jsp:include>
                    </label>
                </form>

            </div>
        </div>
    </div>
</div>
<%}%>

<div class="sidebar">
    <div class="sidebar_title">Style choice with John</div>
    <div class="sidebar_menu">
        <div class="menu_option"></div>
        <div class="menu_option_title">Color</div>
        <div class="menu_option_body">
            <input type="radio" name="color" onclick="<% try {select_att("blue", "*", "*", 0, 0);} catch (SQLException e) {throw new RuntimeException(e);}%>">Blue<br>
            <input type="radio" name="color" onclick="<% try {select_att("brown", "*", "*", 0, 0);} catch (SQLException e) {throw new RuntimeException(e);}%>">Brown<br>
            <input type="radio" name="color" onclick="<% try {select_att("blue-brown", "*", "*", 0, 0);} catch (SQLException e) {throw new RuntimeException(e);}%>">Blue-Brown<br>
        </div>

        <div class="menu_option_title">Type</div>
        <div class="menu_option_body">
            <input type="radio" name="type" onclick="<% try {select_att("*", "*", "*", 0, 0);} catch (SQLException e) {throw new RuntimeException(e);}%>">Shirt<br>
            <input type="radio" name="type" onclick="<% try {select_att("*", "*", "*", 0, 0);} catch (SQLException e) {throw new RuntimeException(e);}%>">Pants<br>
        </div>

        <div class="menu_option_title">Material</div>
        <div class="menu_option_body">
            <input type="radio" name="mat" onclick="<% try {select_att("blue", "*", "*", 0, 0);} catch (SQLException e) {throw new RuntimeException(e);}%>">Cotton<br>
            <input type="radio" name="mat" onclick="<% try {select_att("brown", "*", "*", 0, 0);} catch (SQLException e) {throw new RuntimeException(e);}%>">Poly/Cotton<br>
            <input type="radio" name="mat" onclick="<% try {select_att("blue-brown", "*", "*", 0, 0);} catch (SQLException e) {throw new RuntimeException(e);}%>">Jean<br>
        </div>

        <div class="menu_option_title">Pattern</div>
        <div class="menu_option_body">
            <input type="radio"  name="pat" onclick="<% try {select_att("blue", "*", "*", 0, 0);} catch (SQLException e) {throw new RuntimeException(e);}%>">Yes<br>
            <input type="radio" name="pat" onclick="<% try {select_att("brown", "*", "*", 0, 0);} catch (SQLException e) {throw new RuntimeException(e);}%>">No<br>
        </div>

        <div class="menu_option_title">Print</div>
        <div class="menu_option_body">
            <input type="radio" name="print" onclick="<% try {select_att("blue", "*", "*", 0, 0);} catch (SQLException e) {throw new RuntimeException(e);}%>">Yes<br>
            <input type="radio" name="print" onclick="<% try {select_att("brown", "*", "*", 0, 0);} catch (SQLException e) {throw new RuntimeException(e);}%>">No<br>
        </div>

    </div>
</div>

<div class="display_body">
    <div class="topbar">
        <div class="title">Styles by John Arbuckle</div>
        <div class="nav">
            <a href="displayPage.jsp"><img src="assets/clothes_icon.png" alt="items" width="40%"></a>
            <a href="checkout.jsp"><img src="assets/cart_icon.png" alt="cart" width="40%"></a>
        </div>
    </div>
    <div class="card_Body">
        <%for (Product product: products){%>
        <button class="card" onclick="itemModel('itemModal<%=product.getId()%>')">
            <div class="card_img" style="background-image: url(<%=product.getImageURL()%>);">
                <div class="card_blurb">
                    Name: <%=product.getProduct_name()%> <br>
                    Description: <%=product.getDescription()%> <br>
                    Price: <%=product.getPrice()%>
                </div>
            </div>
        </button>
        <%}%>
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
