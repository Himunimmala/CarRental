<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<style>
@import "compass/css3";

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

}
</style>
</head>
<body>

<div>
<form  method="post">

  <h1>SIGN IN</h1>
  <p>
  			<label for="Name" class="floatLabel">Email Id</label>
  			<input id="userId" name="userId" type="text">
  		</p>
		<p>
			<label for="password" class="floatLabel">Password</label>
			<input id="password" name="password" type="password">

		</p>

		<p>

			<input type="submit" value="Sign In" id="submit">
			<a href="register"> Create Account </a>
		</p>
	</form>
</div>
</body>
</html>
