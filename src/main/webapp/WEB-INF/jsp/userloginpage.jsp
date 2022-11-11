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
form {

  padding: 4em 4em 2em;
  max-width: 400px;

  box-shadow: 0 0 1em #222;

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
  input {
    display: block;
    box-sizing: border-box;
    width: 100%;
    outline: none;
    margin:0;
  }
  input[type="text"],
  input[type="password"] {
    background: #fff;
    border: 1px solid #dbdbdb;
    font-size: 1.6em;
    padding: .8em .5em;
    border-radius: 2px;
  }
  input[type="text"]:focus,
  input[type="password"]:focus {
    background: #fff
  }
  span {
    display:block;
    background: #F9A5A5;
    padding: 2px 5px;
    color: #666;
  }
  input[type="submit"] {
    background: $button;
    box-shadow: 0 3px 0 0 darken($button, 10%);
    border-radius: 2px;
    border: none;
    color: #fff;
    cursor: pointer;
    display: block;
    font-size: 2em;
    line-height: 1.6em;
    margin: 2em 0 0;
    outline: none;
    padding: .8em 0;
    text-shadow: 0 1px #68B25B;
  }
  input[type="submit"]:hover {
    background: rgba(148,175,101,1);
    text-shadow:0 1px 3px darken($button, 30%);
  }
  input[type="submit"]:hover {

  }
  label{
    position: absolute;
    left: 8px;
    top: 9px;
    color: #999;
    font-size: 16px;
    display: inline-block;
    padding: 4px 10px;
    font-weight: 400;
    background-color: color;
    @include transition(color .3s, top .3s, background-color .8s);
    &.floatLabel{
      top: -11px;
      background-color: black;
      font-size: 14px;
    }
	}
h1 {
  font-weight:normal;
}

</style>
</head>
<body>


<div class="bg"></div>
<div class="content">
  <header>


    <form  method="post" >

    <a href="History">History</a>
       <h1>Hello </h1>


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
  </header>
</div>


</body>
</html>
