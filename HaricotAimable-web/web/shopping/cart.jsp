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
        <h1>Content of the shopping cart</h1>





        <table border="0">
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



        <div class="blue">
            <strong>order total : <s:property value="#session['cart'].total"/></strong> |
            <s:a action="category">continue shopping</s:a> | 
            <s:a action="checkout">proceed to checkout</s:a>
        </div>



    </body>
</html>
