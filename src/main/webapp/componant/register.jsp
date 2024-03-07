<div class="form-popup" id="myRegForm">
    <form class="form-container" method="post" action="register">
        <h1>Register</h1>

        <label><b>First Name</b>
            <input type="text" placeholder="Enter First name" name="firstname" required>
        </label>
        <label><b>Last Name</b>
            <input type="text" placeholder="Enter Last name" name="lastname" required>
        </label>
        <label><b>Phone</b>
            <input type="text" placeholder="Enter Phone number" name="phone" required>
        </label>
        <label><b>Email</b>
            <input type="text" placeholder="Enter email" name="email" required>
        </label>
        <label><b>Password</b>
            <input type="password" placeholder="Enter Password" name="password" required>
        </label>
        <button type="submit" class="btn">Register</button>
        <button type="button" class="btn cancel" onclick="toggleRegForm()">Close</button>
    </form>
</div>