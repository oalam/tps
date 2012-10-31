<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Content of the shopping cart</h1>
        
        <s:form action="checkout">
            
            
            <s:submit value="proceed to checkout"/>
        </s:form>
        
        current product : <s:property value="#session['product'].name"/><br/>
        order total : <s:property value="#session['cart'].total"/>
        
    </body>
</html>
