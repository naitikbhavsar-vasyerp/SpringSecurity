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
  </style>
</head>

<body>

  <div class="container">
  <div class="addbtncntr">
   <p>Welcome to Admin dashboard</p>
    <form action="/api/v1/user/dashboard" method="post">
          <input type="hidden" id="token" name="token" value="${token}"><br>
          <input type="hidden" id="userName" name="userName" value="${user.userName}"><br>
          <input type="hidden" id="password" name="password" value="${user.password}"><br>
          <input type="hidden" id="role" name="role" value="${role}"><br>
          <div>
            <button type="submit" class="btn">User Dashboard</button>
        </form>
             <a href="/logout" style="text-decoration: none">
               <div class="addbtn">
                 <p>Logout</p>
               </div>
            </a>
  </div>
  </div>
</body>

</html>