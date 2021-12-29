<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="Model.WeatherBean"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>the Weather</title>
<style type="text/css">
	body {
	 background-image: url("weather2.jpg");
 	 background-color: #black;
 	 background-size: cover;
     position: relative;
	 }
	 h1{
	 font-size: 60px
	 }
	 
    </style>
</head>
<body>




	
	
<%
WeatherBean WBean = (WeatherBean) request.getAttribute("WBean");
out.print("Country: " + WBean.getCountryStr() + "<br>" + "City - " + WBean.getCityStr());
out.print("<br>");
out.print("Last updated: " + WBean.getLastUpdated());
out.print("<br>");
out.print("Weather Celcius: "+ Math.round((WBean.getWeatherDescription()  - 273.15)));
out.print("<br>");
out.print("Clouds:  "+ WBean.getCloudsStr());	
			
	
%>
<br>
<form method="get" action="index.jsp">
<button type="submit">Another search</button>
</form>
		

	 
	 




</body>

</html>