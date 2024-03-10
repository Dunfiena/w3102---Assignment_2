<form class="form-container" method="get" action="login">
    <h1>Login</h1>
    <a onclick="displayReg()" style="font-size: 1.5vw; color: #f1f1f1">Need to register?</a><br>
    <label><b>Email</b>
        <input type="email" placeholder="Enter email" name="email" required>
    </label>
    <br>
    <label><b>Password</b>
        <input type="password" placeholder="Enter Password" name="hashpass" required>
    </label>
    <button type="submit" class="btn">Login</button>
    <button type="button" class="btn cancel" onclick="displayLogin()">Close</button>
</form>