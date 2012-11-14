<%-- 
    Document   : index
    Created on : 8 nov. 2012, 10:22:43
    Author     : adminl
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html xmlns:h="http://java.sun.com/jsf/html" xmlns:f="http://java.sun.com/jsf/core">
    <head>
        <meta http-equiv="Content-Type" content="text/html; UTF-8">
        <title>Fortissimo</title>
	<s:head/>
    </head>
    <body>
        <h1>Bienvenue sur le site de la SNCF</h1>
        <s:form action="searchFonction">
            <h1>Click below to find the next departure for a selected station</h1>

            <input type="submit" value="Seacrh a departure"  />

        </s:form>

        <s:form action="uploadFonction">

            <input type="submit" value="Upload some information"  />

        </s:form>



    </body>
</html>
