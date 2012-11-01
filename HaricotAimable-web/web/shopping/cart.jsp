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
        <h1>Content of the shopping cart</h1>

	<s:set name="emptyCart" value="%{#session['cart'].items.size = 0}"/>
	<s:if test="%{!emptyCart}">



	    <div class="blue">

		<table border="0" >
		    <thead>
			<tr>
			    <th>Product</th>
			    <th>Description</th>
			    <th>Price</th>
			    <th>Quantity</th>
			    <th>Subtotal</th>
			    <th>Update</th>
			</tr>
		    </thead>
		    <tbody>
			<s:iterator value="#session['cart'].items">
			    <tr>
				<td><s:property value="product.name"/></td>
				<td><s:property value="product.description"/></td>
				<td><s:property value="product.price"/></td>


				<td><s:property value="quantity"/></td>

				<td><s:property value="%{product.price * quantity}"/></td>
				<td>
				    <s:form action="updateCart">
					<s:hidden name="productId" value="%{product.id}"/>
					<s:textfield name="quantity" value="%{quantity}" size="4"/>

				    </s:form>
				</td>

			    </tr>

			</s:iterator>

		    </tbody>
		</table>

	    </div>
	</s:if>
	<s:else>
	    <div class="blue">shopping cart is empty</div>
	</s:else>

        <div class="blue">
            <s:a action="welcome">Home</s:a> | 
            <s:a action="category">Continue shopping</s:a>
	    <s:if test="%{!emptyCart}"> | 
		<s:a action="checkout">Purchase</s:a> | 
		<strong>order total : <s:property value="#session['cart'].total"/></strong>
	    </s:if>
        </div>



    </body>
</html>
