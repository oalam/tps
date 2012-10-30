<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Haricot aimable</title>
    </head>
    <body>
        <h1>Bienvenue sur la boutique en ligne du Haricot!</h1>

        <s:form action="category">
            <s:select list="categories" name="selectedCat" listKey="id" listValue="name"/>
            <s:submit value="list products"/>
        </s:form>
    
    </body>
</html>
