<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<% response.setCharacterEncoding("UTF-8"); %>
<%@ page import="java.util.*,com.ilp.store.Product,com.ilp.store.Cart" %>
<%@ page session="true" %>

<%
    Cart cart = (Cart) session.getAttribute("cart");
%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Your Cart</title>
</head>
<body>

<h2>Your Cart</h2>

<% if (cart == null || cart.getItems() == null || cart.getItems().isEmpty()) { %>
    <p>No items in cart.</p>
<% } else { %>
    <ul>
        <% for (Product p : cart.getItems()) { %>
            <li><%= p.getName() %> - &#8377;<%= p.getPrice() %></li>
        <% } %>
    </ul>
    <p><strong>Total: &#8377;<%= cart.getTotal() %></strong></p>
<% } %>

<br>
<a href="<%= request.getContextPath() %>/">Back to Store</a>

</body>
</html>

