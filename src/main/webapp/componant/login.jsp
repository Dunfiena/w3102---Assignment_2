<div class="form-popup" id="myloginForm">
    <form class="form-container" method="post" action="login">
        <h1>Login</h1>
        <label><b>email</b>
            <input type="text" placeholder="Enter user name" name="userName" required>
        </label>

        <label><b>Password</b>
            <input type="password" placeholder="Enter Password" name="hashpass" required>
        </label>
        <button type="submit" class="btn">Login</button>
        <button type="button" class="btn cancel" onclick="toggleLoginForm()">Close</button>
    </form>
</div>