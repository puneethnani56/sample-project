<%@ page import="java.util.*,com.ilp.store.Product,com.ilp.store.Cart" %>
<% Cart cart = (Cart) session.getAttribute("cart"); %>
<h2>Your Cart</h2>
<% if (cart == null || cart.getItems().isEmpty()) { %>
<p>No items in cart.</p>
<% } else { %>
<ul>
  <% for (Product p : cart.getItems()) { %>
    <li><%= p.getName() %> - ₹<%= p.getPrice() %></li>
  <% } %>
</ul>
<p>Total: ₹<%= cart.getTotal() %></p>
<% } %>
<a href="/ILP_Store/">Back to Store</a>
