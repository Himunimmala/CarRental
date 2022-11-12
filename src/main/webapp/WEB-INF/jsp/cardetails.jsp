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
button
{
border-radius: 8px;
  background-color: green;
  border: none;
  color: white;
  padding: 10px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  font-size: 16px;
  margin: 2px 2px;
  cursor: pointer;
}
  button:hover {
    background-color: #45a049;
  }


  </style>
  </head>
  <body>
  <div>
    <h1 style="text-align:center;">CAR DETAILS</h1>
     <p><button onclick="sortrevTable()">Sort price (low to high)  </button></p>
 <p><button onclick="sortTable()">Sort price(high to low) </button></p>



      <table id="customers" >
        <tr>
          <th> CAR NAME</th>
          <th>CAR RENT COST</th>
          <th> CAR SEATS</th>
          <th> ID </th>
          <th>BOOK </th>
        </tr>
        <c:forEach  items="${cardetails}" var ="person">
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

</div>
<script>
function sortTable() {
  var table, rows, switching, i, x, y, shouldSwitch;
  table = document.getElementById("customers");
  switching = true;
  /*Make a loop that will continue until
  no switching has been done:*/
  while (switching) {
    //start by saying: no switching is done:
    switching = false;
    rows = table.rows;
    /*Loop through all table rows (except the
    first, which contains table headers):*/
    for (i = 1; i < (rows.length - 1); i++) {
      //start by saying there should be no switching:
      shouldSwitch = false;
      /*Get the two elements you want to compare,
      one from current row and one from the next:*/
      x = rows[i].getElementsByTagName("TD")[1];
      y = rows[i + 1].getElementsByTagName("TD")[1];
      //check if the two rows should switch place:
      if (Number(x.innerHTML) < Number(y.innerHTML)) {
        //if so, mark as a switch and break the loop:
        shouldSwitch = true;
        break;
      }
    }
    if (shouldSwitch) {
      /*If a switch has been marked, make the switch
      and mark that a switch has been done:*/
      rows[i].parentNode.insertBefore(rows[i + 1], rows[i]);
      switching = true;
    }
  }
}
function sortrevTable() {
  var table, rows, switching, i, x, y, shouldSwitch;
  table = document.getElementById("customers");
  switching = true;
  /*Make a loop that will continue until
  no switching has been done:*/
  while (switching) {
    //start by saying: no switching is done:
    switching = false;
    rows = table.rows;
    /*Loop through all table rows (except the
    first, which contains table headers):*/
    for (i = 1; i < (rows.length - 1); i++) {
      //start by saying there should be no switching:
      shouldSwitch = false;
      /*Get the two elements you want to compare,
      one from current row and one from the next:*/
      x = rows[i].getElementsByTagName("TD")[1];
      y = rows[i + 1].getElementsByTagName("TD")[1];
      //check if the two rows should switch place:
      if (Number(x.innerHTML) > Number(y.innerHTML)) {
        //if so, mark as a switch and break the loop:
        shouldSwitch = true;
        break;
      }
    }
    if (shouldSwitch) {
      /*If a switch has been marked, make the switch
      and mark that a switch has been done:*/
      rows[i].parentNode.insertBefore(rows[i + 1], rows[i]);
      switching = true;
    }
  }
}
</script>

  </body>

</html>