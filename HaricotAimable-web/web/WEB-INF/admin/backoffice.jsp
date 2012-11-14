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
        <h1>List of orders</h1>
        <div class="blue">
            <ul>
                <s:iterator value="orders">
                    <li><s:property value="dateCreated"/> - 
                        <s:property value="amount"/> - 
                        <s:property value="confirmationNumber"/> </li>
                    </s:iterator>
            </ul>
        </div>
    </body>
</html>
