package com.ilp.store;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.*;

public class AppServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String id = req.getParameter("productId");

        // 🔄 Try to retrieve catalog
        List<Product> catalog = (List<Product>) getServletContext().getAttribute("catalog");

        // ✅ If catalog is null (not yet initialized), create it here
        if (catalog == null) {
            catalog = new ArrayList<>();
            catalog.add(new Product("P001", "Phone", 15000));
            catalog.add(new Product("P002", "Laptop", 55000));
            catalog.add(new Product("P003", "Watch", 4000));
            getServletContext().setAttribute("catalog", catalog);
        }

        // 🛒 Session-based cart
        HttpSession session = req.getSession();
        Cart cart = (Cart) session.getAttribute("cart");
        if (cart == null) {
            cart = new Cart();
        }

        // ➕ Add product
        for (Product p : catalog) {
            if (p.getId().equals(id)) {
                cart.addProduct(p);
                break;
            }
        }

        session.setAttribute("cart", cart);

        // 🔁 Redirect to cart.jsp
        resp.sendRedirect("cart.jsp");
    }
}

