<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title> Equations</title>
</head>
<body>
	<h2> Equations</h2>
	<p>a*x*x + b*x + c = 0</p>
	<form:form method="post" commandName="coefficientBean"
		id="coefficientBeanForm" name="coefficientBeannForm"
		action="result.html">
		<label>Variable a:</label>
		<form:input path="leadingCoefficien" />
		<br>
		<label>Variable b:</label>
		<form:input path="secondCoefficien" />
		<br>
		<label>Variable c:</label>
		<form:input path="freeMember" />
		<br>
		<input type="submit" value="result">
	</form:form>
</body>
</html>