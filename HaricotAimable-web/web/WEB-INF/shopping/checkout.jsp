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



            <s:form action="checkout" validate="true">

                <s:textfield name="customer.name" label="Name"/>
                <s:textarea name="customer.address" label="Address"/>
                <s:textfield name="customer.ccNumber" label="Credit card"/>
                <s:textfield name="customer.cityRegion" label="City region"/>
                <s:textfield name="customer.email" label="Email"/>
                <s:textfield name="customer.phone" label="Phone"/>

                <s:submit value="Purchase"/>
            </s:form>   
        </div>

        <div class="blue">
            <s:a action="clearCart">Cancel</s:a> | 
            <s:a action="category">Continue shopping</s:a>
        </div>
    </body>
</html>
