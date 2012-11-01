<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <s:head/>
        <link rel="stylesheet" href="../styles/styles.css" type="text/css" />
    </head>
    <body>
        <h1>Display all products </h1>
        <div class="blue">
            <s:form action="category">
                <s:select  list="categories" name="currentCategory" 
			   listKey="id" listValue="name" 
			   onchange="this.form.submit()"/>
            </s:form>
        </div>


        <div class="blue">
            <ul>

                <s:iterator value="products">
                    <li><s:property value="name"/> - 
                        <s:property value="description"/> -
                        <s:property value="%{getText('format.number',{'price'})}"/>
                        
                        <s:url id="url" action="addToCart">
                            <s:param name="productId" value="id"/>
                            <s:param name="selectedCat" value="selectedCat"/>
                        </s:url>
                        <s:a href="%{url}">add to cart</s:a><br/>

                    </li>

                </s:iterator>

            </ul>

        </div>

        <div class="blue">
             
        </div>


        <div class="blue">
            <s:a action="welcome">Home</s:a> | 
	    <s:a action="viewCart">Proceed to checkout</s:a> | 
            <s:property value="#session['cart'].items.size"/> products for a 
	    total of <s:property value="#session['cart'].total"/>
        </div>













    </body>
</html>
