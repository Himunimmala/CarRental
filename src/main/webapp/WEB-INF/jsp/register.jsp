<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">


<script>
function validate() {
  let x = document.forms["myForm"]["password"].value;
  let y = document.forms["myForm"]["Cpassword"].value;


  if (x != y) {
    alert("Passwords should be same");
    return false;
  }

}
</script>
<style>
@import "compass/css3";

$button: rgba(148,186,101,0.7);

body {

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

}

</style>
</head>
<body>



  <div >
    <h1 style"text-align:center">SIGN UP</h1>
<form  name="myForm" method="post" onsubmit="return validate();">

  <p>
  			<label for="Name" class="floatLabel">Full Name</label>
  			<input id="Name" name="Name" type="text" required>
  		</p>
		<p>
			<label for="Email" class="floatLabel">Email</label>
			<input id="Email" name="Email" type="text" required>
			<h1>{Msg}</h1>
		</p>

		<p>
			<label for="password" class="floatLabel">Password</label>
			<input id="password" name="password" type="password" required>

		</p>
		<p>
			<label for="Cpassword" class="floatLabel">Confirm Password</label>
			<input id="Cpassword" name="Cpassword" type="password" required>

		</p>

		<p>

			<input type="submit" value="Create My Account" id="submit">
			<a href="login"> Already have account?</a>
		</p>
	</form>
</div>

</body>
</html>
