<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Display all products for selected category</h1>
        <s:form action="addToCart">
            <s:submit value="add product to shopping cart"/>
        </s:form>

        <s:url id="url" action="viewCart"/>
        <s:a href="%{url}">view cart</s:a><br/>
        
        <s:url id="url" action="welcome"/>
        <s:a href="%{url}">back to home</s:a>
    </body>
</html>
