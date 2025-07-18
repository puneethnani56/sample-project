package com.ilp.store;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.util.*;

public class ProductServlet extends HttpServlet {
    private List<Product> catalog;

    public void init() {
        catalog = new ArrayList<>();
        catalog.add(new Product("P001", "Phone", 15000));
        catalog.add(new Product("P002", "Laptop", 55000));
        catalog.add(new Product("P003", "Watch", 4000));
        getServletContext().setAttribute("catalog", catalog);
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("index.jsp").forward(req, resp);
    }
}
