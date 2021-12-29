<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Index Page</title>
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
<header><%@ include file="header.jsp"%></header>

 <%	
	   try{
		  if(request.getSession().getAttribute("Accept-cookies") != null){
		   		if(request.getSession().getValue("Accept-cookies").equals("false")){
			    	out.print("");
			    	  Cookie[] list = request.getCookies();
			    	   if (list != null) {
			    	       for (int i = 0; i < list.length; i++) {
			    	            list[i].setMaxAge(0);
			    	        }
			    	    }
		    	 }
	    	 
		     } if(request.getSession().getValue("Accept-cookies").equals("true")){
	    		
	    			
	    			Cookie[] cookies = request.getCookies();
	    			if(cookies.length != 0){
	    				out.print("Previous search : ");
	    				Cities : 
	    				for(Cookie c : cookies){
	    					if(c.getName().equals("cityStr")){
	    						out.print(c.getValue());
	    					}
	    				}
	    				out.print(" ");
	    				Countries : for(Cookie c : cookies){
	    					 if(c.getName().equals("countryStr")){
	    						 out.print(c.getValue());
	    					 }
	    				}
	    			}		
	    			
	    		}
	     }catch(NullPointerException e){}
 %>


	<form action="<%=request.getContextPath()%>/WeatherServlet">
		<label>Search a Location</label>
		<p></p>
		<input type="text" name="city" autocomplete="off" placeholder="City" required/>
		<p></p>
		<input type="text" name="country" autocomplete="off" placeholder="Country" required/>
		<p></p>
		Accept cookies : <input type="checkbox" name="Accept-cookies">
		<p></p>
		<input type="submit" value="Search"/>
		<p></p>
		<div style="color:red">${errorMessage}</div>
	</form>
	
	




<footer><%@ include file="footer.jsp"%></footer>
	
</body>
</html>









