<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%! int day = 3; %>
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
  td{
  text-align: center;
  }
  table.center {
    margin-left: auto;
    margin-right: auto;
  }
  .popup {
    position: relative;
    display: inline-block;
    cursor: pointer;
    -webkit-user-select: none;
    -moz-user-select: none;
    -ms-user-select: none;
    user-select: none;
  }

  /* The actual popup */
  .popup .popuptext {
    visibility: hidden;
    width: 160px;
    background-color: #555;
    color: #fff;
    text-align: center;
    border-radius: 6px;
    padding: 8px 0;
    position: absolute;
    z-index: 1;
    bottom: 125%;
    left: 50%;
    margin-left: -80px;
  }

  /* Popup arrow */
  .popup .popuptext::after {
    content: "";
    position: absolute;
    top: 100%;
    left: 50%;
    margin-left: -5px;
    border-width: 5px;
    border-style: solid;
    border-color: #555 transparent transparent transparent;
  }

  /* Toggle this class - hide and show the popup */
  .popup .show {
    visibility: visible;
    -webkit-animation: fadeIn 1s;
    animation: fadeIn 1s;
  }

  /* Add animation (fade in the popup) */
  @-webkit-keyframes fadeIn {
    from {opacity: 0;}
    to {opacity: 1;}
  }

  @keyframes fadeIn {
    from {opacity: 0;}
    to {opacity:1 ;}
  }
  </style>
  </head>
  <body>
    <h1>CAR DETAILS</h1>

      <table border="1">
        <tr>
          <th> CAR NAME</th>
          <th>CAR RENT COST</th>
          <th> CAR SEATS</th>
          <th> ID </th>
          <th>BOOK </th>
        </tr>
        <c:forEach  items="${personsList}" var ="person">
        <tr>

          <td>${person.carname}</td>
          <td>${person.cost}</td>
          <td>${person.seats}</td>

          <td>${person.id}</td>
          <td>
                <a href="last"> book</a>
           </td>
        </tr>
        </c:forEach>
      </table>


  </body>

</html>