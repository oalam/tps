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
        
        
        <s:url id="url" action="category"/>
        <s:a href="%{url}">list product from category</s:a>
    </body>
</html>
