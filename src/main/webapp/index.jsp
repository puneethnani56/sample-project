<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<% response.setCharacterEncoding("UTF-8"); %>
<%@ page import="java.util.*,com.ilp.store.Product" %>

<%
    List<Product> catalog = (List<Product>) request.getAttribute("catalog");
%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>ILP Store</title>
</head>
<body>

<h1>Welcome to ILP Store</h1>

<% if (catalog != null && !catalog.isEmpty()) { %>
    <table border="1" cellpadding="8" cellspacing="0">
        <tr><th>ID</th><th>Name</th><th>Price</th><th>Action</th></tr>
        <% for (Product p : catalog) { %>
        <tr>
          <td><%= p.getId() %></td>
          <td><%= p.getName() %></td>
          <td>&#8377;<%= p.getPrice() %></td> <!-- Indian Rupee symbol -->
          <td>
            <form action="add" method="post">
              <input type="hidden" name="productId" value="<%= p.getId() %>"/>
              <input type="submit" value="Add to Cart"/>
            </form>
          </td>
        </tr>
        <% } %>
    </table>
<% } else { %>
    <p>No products available at the moment.</p>
<% } %>

</body>
</html>

