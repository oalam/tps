<%-- 
    Document   : search
    Created on : 8 nov. 2012, 10:26:23
    Author     : adminl
--%>

<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>JSP Page</title>
        <s:head/>
    </head>
    <body>
        <h1>search page</h1>

        <h1>Enter the stop_name of the departure selection</h1>

        <s:form action="search">

            <s:textfield name="stop_name" label="Stop_name"/></br>
            <input type="submit" value="Find" />
        </s:form>

        <s:form action="displayRoute">
            <input type="submit" value="Display all routes" />
        </s:form>

    </body>
</html>
