package org.axazeano;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * Created by vladimir on 16.06.16.
 */
public class ARGBColorTest {
    private ARGBColor color;

    @BeforeClass
    public void beforeClass() {
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
        color.setAlpha(50);
        assertEquals(color.getAlpha(), 50);

        color.setAlpha(300);
        assertEquals(color.getAlpha(), 99);

    }
}