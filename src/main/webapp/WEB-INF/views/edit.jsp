<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Form</title>
</head>
<body>

<form method="put" action="../saveemp">

ENo: <input type="text" name = "id" value= "${command.getId()}"/><br/>
EName: <input type="text" name="name" value="${command.getName()}"/><br/>
<input type="submit" value="Update">

</form>

</body>
</html>