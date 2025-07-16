package com.ilp.store;

import org.junit.Test;
import static org.junit.Assert.*;

public class AppTest {

    @Test
    public void testWelcomeMessage() {
        App app = new App();
        assertEquals("Welcome to ILP Store", app.getWelcomeMessage());
    }
}
