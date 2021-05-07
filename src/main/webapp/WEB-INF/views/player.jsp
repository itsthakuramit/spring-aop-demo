<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page isELIgnored ="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>MyPlayer</title>
</head>
<body>
<h1>Player Info</h1>

<br><br>
   <table style="with: 50%" border="2">
   
   <tr>
	 <td>Player Id</td>
     <td>Player Name</td>
     <td>Country</td>
     <td>Sports</td>
    
    </tr>
    <tr>
     <td>${playerid}</td>
     <td>${playername}</td>
     <td>${country}</td>
     <td>${sports}</td> 
     
    </tr>

     <a href="/newplayerapp"> Click here to go to index page</a></td>

   </table>
   