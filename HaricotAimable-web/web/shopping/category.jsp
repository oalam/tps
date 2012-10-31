<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Display all products for category id :
            <s:property value="selectedCat"/></h1>


        <s:url id="url" action="viewCart"/>
        <s:a href="%{url}">view cart</s:a><br/>

        <s:url id="url" action="welcome"/>
        <s:a href="%{url}">back to home</s:a>

 

        <s:form action="category">
            <s:select label="categories" list="categories" name="selectedCat" listKey="id" listValue="name" onchange="this.form.submit()"/>

        </s:form>
        
        <ul>

            <s:iterator value="products">
                <li><s:property value="name"/> - 
                    <s:property value="description"/> -
                    <s:property value="price"/>
                   
                    <s:url id="url" action="addToCart">
                        <s:param name="productId" value="id"/>
                        <s:param name="selectedCat" value="selectedCat"/>
                    </s:url>
                    <s:a href="%{url}">add to cart</s:a><br/>

                    </li>

            </s:iterator>

        </ul>


    </body>
</html>
