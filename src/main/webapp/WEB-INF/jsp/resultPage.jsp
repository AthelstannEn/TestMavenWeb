<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Results</title>
</head>
<body>
<h1>Result Page</h1>
<p>For quadratic equations: <span>${coefficientBean.leadingCoefficien}*x*x + ${coefficientBean.secondCoefficien}*x + ${coefficientBean.freeMember} = 0</span> results is:</p><br>
<ul>
<li>Variable x1 = ${coefficientBean.firstVariable}</li>
<li>Variable x2 = ${coefficientBean.secondVariable}</li>
</ul>
<a href="resolve.html">Back</a>
</body>
</html>