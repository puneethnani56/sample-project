package com.ilp.store;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.*;

public class ProductServlet extends HttpServlet {
    private List<Product> catalog;

    @Override
    public void init() throws ServletException {
        catalog = new ArrayList<>();
        catalog.add(new Product("P001", "Phone", 15000));
        catalog.add(new Product("P002", "Laptop", 55000));
        catalog.add(new Product("P003", "Watch", 4000));

        System.out.println("✅ ProductServlet initialized with " + catalog.size() + " products");
    }

    //@Override
    //protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // ✅ Set product list in request scope
      //  req.setAttribute("catalog", catalog);

        // ✅ Forward to JSP page
        //RequestDispatcher dispatcher = req.getRequestDispatcher("index.jsp");
        //dispatcher.forward(req, resp);
    //}

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	System.out.println("📦 ProductServlet.doGet() called");  // Add this line

    	req.setAttribute("catalog", catalog);
    	req.getRequestDispatcher("index.jsp").forward(req, resp);
    }
}

