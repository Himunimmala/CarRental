<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE HTML>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>Person List</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css"/>

  <style>
  table, th, td {
    border: 1px solid black;
  }
  table.center {
    margin-left: auto;
    margin-right: auto;
  }
  </style>
  </head>
  <body>
  <form method="post">
  <input type="number" value="id" name="id" placeholder="Enter reservation id">
  </input>
  <div>
  </div>
  <div>
  </div>
  <input type="submit" value="SUBMIT">
  </input>
  </form>

  </body>

</html>