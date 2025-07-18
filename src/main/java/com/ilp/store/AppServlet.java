package com.ilp.store;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.util.*;

public class AppServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("productId");
        List<Product> catalog = (List<Product>) getServletContext().getAttribute("catalog");
        HttpSession session = req.getSession();
        Cart cart = (Cart) session.getAttribute("cart");
        if (cart == null) cart = new Cart();

        for (Product p : catalog) {
            if (p.getId().equals(id)) {
                cart.addProduct(p);
                break;
            }
        }
        session.setAttribute("cart", cart);
        resp.sendRedirect("cart.jsp");
    }
}
