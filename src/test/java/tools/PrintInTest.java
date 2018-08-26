package tools;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.Match;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import org.mockito.Matchers;
import org.mockito.Mock;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.regex.Matcher;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

/**
 * PrintIn Tester.
 *
 * @author Wang Dong
 * @version 1.0
 * @since 08/24/2018
 */
public class PrintInTest {

    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: setTips(String tips)
     */
    @Test
    public void testSetTips() throws Exception {
        PrintIn mock = mock(PrintIn.class);
        String tips = "tips";
        // 调用方法赋值
        mock.setTips(tips);
        // 验证这个方法调用是否使用成功
        verify(mock, times(1)).setTips(tips);
    }

    /**
     * Method: printIn()
     */
    // Mock BufferedReader对象，配置其返回结果 spy.readLine() 的输出为 "abdefg"
    // 这样的话，就相当于代码里 str = br.readLine(); 这一行的值 str = "abdefg"
    @Test(timeout = 100)
//    @Test
//    @Ignore
    public void testPrintIn() throws Exception {
        String str = "fewfewf";


        PrintIn mock = mock(PrintIn.class);
//        PrintIn mock = new PrintIn();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader spy = spy(reader);
        doReturn(str).when(spy).readLine();

        // 调用方法赋值
        mock.printIn();
        // 验证这个方法调用是否使用成功
//        verify(mock).printIn();

        // 测试 输入的值 是否相等
        assertEquals(mock.getUserInput(), str);
    }

    /**
     * Method: printInInt()
     */
    @Test
    public void testPrintInInt() throws Exception {
        //TODO: Test goes here...
    }

    /**
     * Method: getUserInput()
     */
    @Test
    public void testGetUserInput() throws Exception {
        //TODO: Test goes here...
    }

    /**
     * Method: isInputError()
     */
    @Test
    public void testIsInputError() throws Exception {
        //TODO: Test goes here...
    }


    /**
     * Method: setUserInput()
     */
    @Test
    public void testSetUserInput() throws Exception {
//TODO: Test goes here... 
/* 
try { 
   Method method = PrintIn.getClass().getMethod("setUserInput"); 
   method.setAccessible(true); 
   method.invoke(<Object>, <Parameters>); 
} catch(NoSuchMethodException e) { 
} catch(IllegalAccessException e) { 
} catch(InvocationTargetException e) { 
} 
*/
    }

    /**
     * Method: setUserInputOnlyInt()
     */
    @Test
    public void testSetUserInputOnlyInt() throws Exception {
//TODO: Test goes here... 
/* 
try { 
   Method method = PrintIn.getClass().getMethod("setUserInputOnlyInt"); 
   method.setAccessible(true); 
   method.invoke(<Object>, <Parameters>); 
} catch(NoSuchMethodException e) { 
} catch(IllegalAccessException e) { 
} catch(InvocationTargetException e) { 
} 
*/
    }

} 
