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

.addbtncntr{
  margin-bottom: 10px;
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

  </style>
</head>

<body>

  <div class="container">
  <div class="addbtncntr">
   <p>Welcome to User dashboard</p>
     <a href="/api/v1/admin/dashboard" style="text-decoration: none">
       <div class="addbtn">
         <p>Admin Dashboard</p>
       </div>
    </a>
         <a href="/logout" style="text-decoration: none">
           <div class="addbtn">
             <p>Logout</p>
           </div>
        </a>
  </div>
  </div>
</body>

</html>