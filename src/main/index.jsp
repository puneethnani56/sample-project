<%@ page import="java.util.*,com.ilp.store.Product" %>
<% List<Product> catalog = (List<Product>) application.getAttribute("catalog"); %>
<h1>Welcome to ILP Store</h1>
<table border="1">
<tr><th>ID</th><th>Name</th><th>Price</th><th>Action</th></tr>
<% for (Product p : catalog) { %>
<tr>
  <td><%= p.getId() %></td>
  <td><%= p.getName() %></td>
  <td>₹<%= p.getPrice() %></td>
  <td>
    <form action="add" method="post">
      <input type="hidden" name="productId" value="<%= p.getId() %>"/>
      <input type="submit" value="Add to Cart"/>
    </form>
  </td>
</tr>
<% } %>
</table>
