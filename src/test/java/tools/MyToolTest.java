package tools;

import org.junit.Rule;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import org.junit.rules.ExpectedException;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

/**
 * MyTool Tester.
 *
 * @author Wang Dong
 * @version 1.0
 * @since 08/22/2018
 */
public class MyToolTest {
    // 先声明ExpectedException异常
    @Rule
    public ExpectedException thrown = ExpectedException.none();

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
    public void testStringToInt() {
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

        int t6 = MyTool.StringToInt("a1234");
        assertEquals(t6, 1234);
    }

    /**
     * 测试当数字过大时 >=2147483648，是否会抛出异常，抛出异常则正常
     *
     * @throws Exception
     */
    @Test(expected = Exception.class)
    public void testStringToInt_TooLarge() {
        MyTool.StringToInt("2147483648");
    }


    /**
     * 测试当数字过小时 <=-2147483649，是否会抛出异常，抛出异常则正常
     */
    @Test
    public void testStringToInt_TooSmall() {
        // 需要先声明ExpectedException异常
        thrown.expect(Exception.class);
        MyTool.StringToInt("-2147483649");
    }

    /**
     * 空字符串，抛出异常
     * 不过这个单测意义在哪？
     */
    @Test
    public void testStringToInt_EmptyChar() {
        // 需要先声明ExpectedException异常
        thrown.expect(Exception.class);
        MyTool.StringToInt("");
    }


    /**
     * 纯数字型转字符串
     */
    @Test
    public void testStringToIntOnlyNumber() {
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
     * 太大
     */
    @Test
    public void testStringToIntOnlyNumber_TooLarge() {
        thrown.expect(Exception.class);
        MyTool.StringToInt("2147483648");
    }

    /**
     * 太小
     */
    @Test
    public void testStringToIntOnlyNumber_TooSmall() {
        thrown.expect(Exception.class);
        MyTool.StringToInt("-2147483649");
    }

    /**
     * 字符串包含非数字类型
     */
    @Test
    public void testStringToIntOnlyNumber_ErrorChar() throws Exception {
        thrown.expect(Exception.class);
        MyTool.StringToInt("a");
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

    /**
     * Method: log(@NotNull int[] foo)
     */
    @Test
    public void testLogFoo() throws Exception {
        //TODO: Test goes here...
    }

    /**
     * Method: copyIntList(int[] foo)
     */
    @Test
    public void testCopyIntList() throws Exception {
        //TODO: Test goes here...
    }

    /**
     * Method: createIntArray(int arrayLength, int defaultValue)
     */
    @Test
    public void testCreateIntArray() throws Exception {
        //TODO: Test goes here...
    }

    /**
     * Method: indexOf(int[] array, int value)
     */
    @Test
    public void testIndexOf() throws Exception {
        //TODO: Test goes here...
    }

} 
