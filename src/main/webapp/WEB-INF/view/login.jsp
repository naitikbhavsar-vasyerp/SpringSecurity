<html>
<head>
  <style>
    * {
      padding: 0;
      margin: 0;
    }

    body {
      background-color: #f1faee;
      background-image: url("https://i.ibb.co/vcgsyKy/yuriy-kovalev-n-N1-HSDt-Kdlw-unsplash.jpg");
      background-repeat: no-repeat;
      background-size: cover;
      vertical-align: middle;
      display: flex;
      align-items: center;
      justify-content: center;
      margin: 0;
    }

    .container {
      background-color: white;
      padding: 10px;
      display: flex;
      flex-direction: column;
      justify-content: center;
      align-items: center;
      width: fit-content;
      padding: 100px;

      margin-top: 20px;
      border-radius: 20px;
      box-shadow: 4px 7px 5px 0px #1d3557;
    }

    form {
      padding: 30px;

    }

    form input {
      width: 500px;
      padding: 10px;
      margin-bottom: 15px;
      
    }

    form button {
      background-color: #3498db;
      color: #fff;
      margin-bottom: 20px;
      padding: 10px 15px;
      border: none;
      cursor: pointer;
      border-radius: 5px;
      width: 100%;
    }

    form button:hover {
      background-color: #267bb7;
    }

    form .error-message {
      color: #e74c3c;
      margin-top: -10px;
      margin-bottom: 15px;
    }

    form label {
      display: block;
      margin-bottom: 5px;
      font-family: 'Franklin Gothic Medium', 'Arial Narrow', Arial, sans-serif;

    }

    h2 {
      justify-content: center;
      display: flex;
    }

    .addbtn {
      background-color: #00171f;
      align-items: center;
      display: flex;
      justify-content: center;
      font-family: Verdana, Geneva, Tahoma, sans-serif;
      font-size: 15px;
      border: 2px solid #a8dadc;
      border-radius: 5px;
      padding: 15px 150px;
      width: 500px;
    }


    .addbtncntr :hover {
      box-shadow: 0 0 10px #1d3557;
      color: #a8dadc;
    }

    .addbtn p {
      color: white;
      font-family: 'Trebuchet MS', 'Lucida Sans Unicode', 'Lucida Grande', 'Lucida Sans', Arial, sans-serif;
      font-size: 18px;
    }

    .header {
      font-size: 40px;
      font-family: fantasy;
      font-style: italic;
      text-decoration: underline;
      color: #1d3557;

    }
    .radiobtn{
      display: flex;
      width: 500px;
      justify-content: center;
      margin-left: 50px;
    }
  </style>
</head>

<body>

  <div class="container">
    <p class="header">Login</p>
    <form action="/api/v1/login/login-user" method="post">
      <label for="userName">
        UserName
      </label>
      <input class="inputbar" type="text" id="userName" name="userName" required><br>
      <label for="password">
        Password
      </label>
      <input class="inputbar" type="password" id="password" name="password" required><br>
      <div>
        <button type="submit" class="btn">login</button>
    </form>
  </div>
		<div class="addbtncntr">
			<a href="/api/v1/register-page" style="text-decoration: none">
				<div class="addbtn">
					<p>SignUp</p>
				</div>
			</a>
		</div>
	</div>
</body>

</html>