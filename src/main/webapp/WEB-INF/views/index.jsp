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
<h1>Add Player</h1>
<form action="addPlayer" method="post">
   <table style="with: 50%" border="2">
    <tr>
     <td>Player Id</td>
     <td><input type="text" name="playerid" /></td>
    </tr>
    <tr>
     <td>Player Name</td>
     <td><input type="text" name="playername" /></td>
	</tr>
	<tr>
     <td>Country</td>
     <td><input type="text" name="country" /></td>
	</tr>
	<tr>
     <td>Sports</td>
     <td><input type="text" name="sports" /></td>
	</tr>
	<tr>
	 <td colspan="2" align="center"><input type="submit" value="Add Player" /></td>
	</tr>
	
   </table>
   
   
</form>

<br><br>
   <table style="with: 50%" border="2">
   
   <tr>
	 <td>Player Id</td>
     <td>Player Name</td>
     <td>Country</td>
     <td>Sports</td>
    
    </tr>
   <c:forEach items="${playerlist}" var="player">
   
   
    <tr>
     <td>${player.playerid}</td>
     <td>${player.playername}</td>
     <td>${player.country}</td>
     <td>${player.sports}</td> 
     <td><a href="getPlayer/${player.playerid}"><button>Get Info</button></a></td>
     <td><a href="deletePlayer?playerid=${player.playerid}"><button>Delete</button></a></td>
     
    </tr>

	</c:forEach>
   </table>
   