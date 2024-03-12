    <form class="form-container" method="get" action="register">
        <h1>Register</h1>
        <a onclick="displayLogin2()" style="font-size: 1.5vw; color: #f1f1f1">Back to login?</a><br>
        <label><b>First name</b>
            <input type="text" placeholder="Enter first name" name="fname" required>
        </label>
        <br>

        <label><b>Last Name</b>
            <input type="text" placeholder="Enter last name" name="lname" required>
        </label>
        <br>

        <label><b>Phone</b>
            <input type="text" placeholder="Enter phone number" name="phone" required>
        </label>
        <br>

        <label><b>Email</b>
            <input type="email" placeholder="Enter email" name="email" required>
        </label>
        <br>
        <label><b>Password</b>
            <input type="password" placeholder="Enter Password" name="hashpass" required>
        </label>
        <button type="submit" class="btn">Register</button>
        <button type="button" class="btn cancel" onclick="displayregOff()">Close</button>
    </form>
</div>