<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%! int day = 3; %>
<!DOCTYPE HTML>
<html>
  <head>
    <meta charset="UTF-8" />

    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css"/>
  <style>
 #customers {
   font-family: Arial, Helvetica, sans-serif;
   border-collapse: collapse;
   width: 100%;
 }
 div{

   padding: 4em 4em 2em;
   max-width: 800px;
   margin: 20px auto 0;

   border-radius: 2px;
   }

 #customers td, #customers th {
   border: 1px solid #ddd;
   padding: 8px;
 }

 #customers tr:nth-child(even){background-color: #f2f2f2;}

 #customers tr:hover {background-color: #ddd;}

 #customers th {
   padding-top: 12px;
   padding-bottom: 12px;
   text-align: center;
   background-color: #04AA6D;
   color: white;
 }
 #customers td
 {
   text-align: center;
 }
  </style>
  </head>
  <body>
  <div>
    <h1 style="text-align:center;">CAR DETAILS</h1>

      <table id="customers" >
        <tr>
          <th> CAR NAME</th>
          <th>CAR RENT COST</th>
          <th> CAR SEATS</th>
          <th>PICK UP DATE</th>
          <th>DROP OFF DATE</th>


        </tr>
        <c:forEach  items="${regnum}" var ="person">
        <tr>
          <td>${person.carname}</td>
          <td>${person.cost}</td>
          <td>${person.seats}</td>
          <td>${person.pdate}</td>
          <td>${person.ddate}</td>
        </tr>
        </c:forEach>
      </table>
      <a href="login"> back</a>
</div>

  </body>

</html>