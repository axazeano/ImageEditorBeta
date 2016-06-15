package org.axazeano;

import org.omg.CORBA.Object;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * Created by vladimir on 16.06.16.
 */
public class ARGBColorTest {
    private ARGBColor color;

    @BeforeMethod
    public void beforeEachMethod() {
        color = new ARGBColor(0);
    }


    @Test(priority = 1)
    public void testSetRed() throws Exception {
        color.setRed(100);
        assertEquals(color.getRed(), 100);

        color.setRed(300);
        assertEquals(color.getRed(), 255);

    }

    @Test(priority = 1)
    public void testSetGreen() throws Exception {
        color.setRed(100);
        assertEquals(color.getRed(), 100);

        color.setRed(300);
        assertEquals(color.getRed(), 255);
    }

    @Test(priority = 1)
    public void testSetBlue() throws Exception {
        color.setBlue(100);
        assertEquals(color.getBlue(), 100);

        color.setBlue(300);
        assertEquals(color.getBlue(), 255);

    }

    @Test(priority = 1)
    public void testSetAlpha() throws Exception {
        color.setRed(50);
        assertEquals(color.getRed(), 50);

        color.setRed(300);
        assertEquals(color.getRed(), 99);

    }
}