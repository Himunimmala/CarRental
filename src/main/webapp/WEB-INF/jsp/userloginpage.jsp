<!DOCTYPE html>
<html>
<head>
<style>
.bg {
  background-image:url(/img/car.png);
  background-repeat:no-repeat;
  background-size:cover;
  bottom:0;
  filter:contrast(.7) brightness(.7);
  left:0;
  position:fixed;
  right:0;
  top:0;
}

.content {
  align-items:center;
  bottom:0;
  color:white;
  display:flex;
  flex-wrap:wrap;
  font-family:sans-serif;
  justify-content:center;
  left:0;
  padding:20vw;
  position:fixed;
  right:0;
  text-align:center;
  top:0;
}
$button: rgba(148,186,101,0.7);

body {
  background: #384047;
  font-family: sans-serif;
  font-size: 10px
}
div{
  background: #fff;
  padding: 4em 4em 2em;
  max-width: 400px;
  margin: 50px auto 0;
  box-shadow: 0 0 1em #222;
  border-radius: 2px;
  }
  h2 {
    margin:0 0 50px 0;
    padding:10px;
    text-align:center;
    font-size:30px;
    color:darken(#e5e5e5, 50%);
    border-bottom:solid 1px #e5e5e5;
  }
  p {
    margin: 0 0 3em 0;
    position: relative;
  }
  input, select {
    width: 100%;
    padding: 10px 20px;
    margin: 8px 0;
    display: inline-block;
    border: 1px solid #ccc;
    border-radius: 4px;
    box-sizing: border-box;
  }

  input[type=submit] {
    width: 100%;
    background-color: #4CAF50;
    color: white;
    padding: 14px 20px;
    margin: 8px 0;
    border: none;
    border-radius: 4px;
    cursor: pointer;
  }

  input[type=submit]:hover {
    background-color: #45a049;
  }

h1
{
text-align:center;
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

}

</style>
</head>
<body>


<div>
    <form  method="post" >


       <h1>Car Rentals</h1>
    		<p>
    			<label for="pdate" class="floatLabel">Pickup date</label>
    			<input id="pdate" name="pdate" type="date">

    		</p>
    		<p>
                			<label for="ddate" class="floatLabel">dropoff date</label>
                			<input id="ddate" name="ddate" type="date">
                		</p>
            <p>

                			<label for="model" class="floatLabel">Model</label>
                			<input id="model" name="model" type="text">

            </p>
    		&nbsp;&nbsp;


			<input type="submit" value="Search" id="submit">

    		</p>
    	</form>
    <button><a href="History">History</a></button>
</div>


</body>
</html>
