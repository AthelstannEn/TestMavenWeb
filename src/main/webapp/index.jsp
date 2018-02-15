
<!DOCTYPE html>
<html>
<title>TestMaven</title>
<head></head>
<body>
	

	<%response.sendRedirect("resolve.html");
		String result = "Woking";
		int a = 0;
		int b = 0;
		int c = 0;
		double x1 = 0.0;
		double x2 = 0.0;
		double d = 0.0;
		try {
			if (request.getParameter("a") != null)
				a = (int) Integer.parseInt(request.getParameter("a"));
			if (request.getParameter("b") != null)
				b = (int) Integer.parseInt(request.getParameter("b"));
			if (request.getParameter("c") != null)
				c = (int) Integer.parseInt(request.getParameter("c"));
			d = Math.pow(b ,2 ) - 4 * a * c;
			if (d < 0)
				x1 = d;
			x1 = (-b + Math.sqrt(Math.pow(b ,2 )  - 4 * a * c)) / 2 * a;
			x2 = (-b - Math.sqrt(Math.pow(b ,2 ) - 4 * a * c)) / 2 * a;
		} catch (Exception e) {
			result = e.getMessage();
			e.printStackTrace();
		}
		if (result.equals("Woking")) {
	%>
	<span>Value d= <%=d%></span>
	<span>Value x1= <%=x1%></span>
	<br>
	<span>Value x2= <%=x2%></span>
	<br>
	<a href="<%=request.getRequestURI()%>">BACK</a>
	<%
		} else {
	%>
	<span>Exception <%=result%></span>
	<%
		}
	%>
</body>
</html>