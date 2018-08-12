package tools;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

/**
 * MyTool Tester.
 *
 * @author Wang Dong
 * @version 1.0
 * @since 08/12/2018
 */
public class MyToolTest {

    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: StringToInt(String str)
     */
    @Test
    public void testStringToInt() throws Exception {
        int t1 = MyTool.StringToInt("2147483647");
        assertEquals(t1, 2147483647);

        int t2 = MyTool.StringToInt("-2147483648");
        assertEquals(t2, -2147483648);

        int t3 = MyTool.StringToInt("-0");
        assertEquals(t3, 0);

        int t4 = MyTool.StringToInt("0");
        assertEquals(t4, 0);

        int t5 = MyTool.StringToInt("0123");
        assertEquals(t5, 123);
    }

    /**
     * Method: isStringLargerthanInt(String str, int num)
     */
    @Test
    public void testCompareStringWithInt() throws Exception {
        byte b1 = MyTool.compareStringWithInt("123", 123);
        assertEquals(b1, 0);

        byte b2 = MyTool.compareStringWithInt("-123", 123);
        assertEquals(b2, -1);

        byte b3 = MyTool.compareStringWithInt("123", -123);
        assertEquals(b3, 1);

        byte b4 = MyTool.compareStringWithInt("0123", 123);
        assertEquals(b4, 0);

        byte b5 = MyTool.compareStringWithInt("-010123", -10123);
        assertEquals(b5, 0);
    }
} 
