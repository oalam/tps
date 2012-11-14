<%-- 
    Document   : routeList
    Created on : 9 nov. 2012, 09:40:44
    Author     : adminl
--%>

<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Choose the correct route </h1>
        
         <s:form action="displayHeadSign">
                <s:select  list="routes" name="routeId" 
			   listKey="routeId" listValue="routeLongName" 
			   onchange="this.form.submit()"/>
            </s:form>
        
        
    </body>
</html>
