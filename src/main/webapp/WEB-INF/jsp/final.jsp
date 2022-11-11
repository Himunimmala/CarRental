<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE HTML>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>Person List</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css"/>

  </style>
  </head>
  <body>
  <h1>
  SUCESSFULLY BOOKED
  </h1>
  <h2>
  YOUR REGISTRATION NUMBER :
          <c:forEach  items="${regnum}" var ="person">
            ${person.regnum}
          </c:forEach>

  </h2>
  <a href="Welcome"> logout</a>
  </body>

</html>