<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><s:text name="confirmation.title"/></title>
	<s:head/>
        <link rel="stylesheet" href="../styles/styles.css" type="text/css" />
    </head>
    <body>
        <h1><s:text name="confirmation.title"/></h1>
	<div class="blue">
	    Thanks <s:property value="customer.name" /> for your order placed <s:property value="order.date" /> <br/>
	    Your products will be shipped to <em><s:property value="customer.address" /></em><br/>
	    Please note the order confirmation number <strong><s:property value="order.id" /></strong><br/>
	</div>
	
	<div class="blue">
            <s:a action="welcome">Home</s:a> | 
	    <strong>order total : <s:property value="order.amount"/></strong>
        </div>
    </body>
</html>
