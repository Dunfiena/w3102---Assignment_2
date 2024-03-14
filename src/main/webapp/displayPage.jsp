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
    ArrayList<Descriptor> descriptors = (ArrayList<Descriptor>) session.getAttribute("desTmp");
    User user = (User)session.getAttribute("user");
    descriptorController dcon = new descriptorController();
    productController pcon = new productController();
    cartController ccon = new cartController();
    reviewController rcon = new reviewController();
    ArrayList<Product> productstmp = new ArrayList<>();
    ArrayList<Product> products = new ArrayList<>();
    ArrayList<Review> reviews = new ArrayList<>();
    boolean login = false;

    try {
        productstmp = pcon.select();
        if (productstmp != null && descriptors !=null) {
            for (Product product : productstmp) {
                for (Descriptor des : descriptors) {
                    if (product.getDescriptor_id() == des.getId()) {
                        products.add(product);
                    }
                }
            }
            for (Product prod : products) {
                reviews.addAll(rcon.select(prod.getId()));
            }
        }else{
            products = productstmp;
            for (Product prod : products) {
                reviews.addAll(rcon.select(prod.getId()));
            }
        }
    } catch (SQLException e) {
        throw new RuntimeException(e);
    }

    if (user != null) {
        login = true;
    }
%>

<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="CSS/displayPage.css">
    <link rel="stylesheet" href="CSS/modalCSS.css">
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
                <form name="add_cart" action="addtoCart" onsubmit="return checklogin2(<%=login%>,
                    <%=product.getQuantity()%>, 'quantity<%=product.getId()%>')" method="get">
                    Name: <%=product.getProduct_name()%> <br>
                    Description: <%=product.getDescription()%> <br>
                    Price: <%=product.getPrice()%>$<br>
                    <label>             Quantity:
                        <input type="number" name="itemQuantity" value="" min="0" id="quantity<%=product.getId()%>" placeholder="">
                    </label>
                    <input type="hidden" name="itemID" value="<%=product.getId()%>">
                    <button type="submit">Add to Cart</button>
                </form>
            </div>
        </div>

        <div class="modal_right">
            <button class="quit_button" onclick="itemModel('itemModal<%=product.getId()%>')">X</button>
            <div class="modal_review">
                <hr>
                <%for (Review rev : reviews) {
                    if (rev.getItem_id() == product.getId()){%>
                    Rating: <%=rev.getRating()%><br>
                    Review: <%=rev.getReview_text()%><br><hr>
                <%}}%>
            </div>
            <hr><hr>

            <div class="modal_leave_review">
                <form name="review" method="get" onsubmit="return checklogin1(<%=login%>)" action="leaveReview">
                    <label>Leave a Review:<br>
                        <input type="text" name="review" placeholder="Leave us with your thoughts =)" style="width: 100%; height: 40%;">
                    </label>

                    <label> Rating:
                        <input type="number" max="10" min="0" name="rating">
                    </label>
                    <label> Rating:
                        <input type="hidden" value="<%=product.getId()%>" name="itemID">
                    </label>
                    <button type="submit" >Submit Review</button>
                </form>
            </div>
        </div>
    </div>
</div>
<%}%>

<div class="sidebar">
    <div class="sidebar_title">Style choice with John</div>
    <div class="sidebar_menu">
        <form name="description" method="get" action="addDescription">
            <div class="menu_option"></div>
            <div class="menu_option_title">Color</div>
            <div class="menu_option_body">
                <input type="radio" name="color" value="2" checked>None<br>
                <input type="radio" name="color" value="Blue">Blue<br>
                <input type="radio" name="color" value="Brown">Brown<br>
                <input type="radio" name="color" value="Blue-Brown">Blue-Brown<br>
            </div>

            <div class="menu_option_title">Type</div>
            <div class="menu_option_body">
                <input type="radio" name="type" value="2" checked>None<br>
                <input type="radio" name="type" value="Shirt">Shirt<br>
                <input type="radio" name="type" value="Pants">Pants<br>
            </div>

            <div class="menu_option_title">Material</div>
            <div class="menu_option_body">
                <input type="radio" name="mat" value="2" checked>None<br>
                <input type="radio" name="mat" value="Cotton">Cotton<br>
                <input type="radio" name="mat" value="Poly/Cotton">Poly/Cotton<br>
                <input type="radio" name="mat" value="Jean">Jean<br>
            </div>

            <div class="menu_option_title">Pattern</div>
            <div class="menu_option_body">
                <input type="radio" name="pat" value="2" checked>None<br>
                <input type="radio" name="pat" value="1">Yes<br>
                <input type="radio" name="pat" value="0">No<br>
            </div>

            <div class="menu_option_title">Print</div>
            <div class="menu_option_body">
                <input type="radio" name="print" value="2" checked>None<br>
                <input type="radio" name="print" value="1">Yes<br>
                <input type="radio" name="print" value="0">No<br>
            </div>
            <button type="submit">Submit</button>
        </form>
    </div>
</div>

<div class="display_body">
    <div class="topbar">
        <div class="title">Styles by John Arbuckle</div>
        <div class="nav">
            <a href="displayPage.jsp"><img src="assets/clothes_icon.png" alt="items" width="25%"></a>
            <a href="checkout.jsp"><img src="assets/cart_icon.png" alt="cart" width="25%"></a>
            <button style="width: 33%; height: 100%; padding-top:15%; font-size: 2vw; background: skyblue; color: chocolate" onclick="displayLogin()">Login</button>
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
