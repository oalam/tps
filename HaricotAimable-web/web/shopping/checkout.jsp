<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>JSP Page</title>
        <s:head/>
        <link rel="stylesheet" href="../styles/styles.css" type="text/css" />
    </head>
    <body>
        <h1>Checkout</h1>

        <div class="blue">



            <s:form action="purchase" >

                <s:textfield name="user"



                <s:submit value="purchase"/>
            </s:form>   
        </div>

        <div class="blue">
            <s:a action="welcome">Home</s:a> | 
            <s:a action="category">continue shopping</s:a>
        </div>
    </body>
</html>
