package tools;

import com.sun.istack.internal.NotNull;

public class MyTool {
    /**
     * 将字符串转为数字
     * 异常：
     * 最后结果过大过小时（范围在 -2147483648 ~ 2147483647），会抛出异常
     *
     * @param str 字符号串
     * @return 排除了非法字符的数字，支持负数
     * @throws Exception
     */

    public static int StringToInt(String str) throws Exception {
        StringBuffer buf = new StringBuffer();
        char[] ch = str.toCharArray();
        for (int i = 0; i < ch.length; i++) {
            if (ch[i] >= '0' && ch[i] <= '9') {
                buf.append(ch[i]);
            }
            // 这个是考虑到负号
            // 遇见负号时，只有 buf 为空（即让负号处于第一位）的时候，才会添加进去
            if (buf.length() == 0 && ch[i] == '-') {
                buf.append(ch[i]);
            }
        }
        // 范围在 -2147483648 ~ 2147483647
        // < 10位肯定正常，> 12 位肯定抛错
        String string = buf.toString();
        // 如果过大或小，都会抛出异常
        int result = Integer.parseInt(string);
        return result;
    }

    /**
     * 比较字符串和数字的大小
     *
     * @param str 需要是纯数字（允许第一位有负号）字符串，否则报错
     * @param num 普通数字
     * @return 0 相等，1 字符串大，-1 数字大
     * @throws Exception
     */
    public static byte compareStringWithInt(String str, int num) throws Exception {
        int s = Integer.parseInt(str);
        if (s == num) {
            return 0;
        } else if (s > num) {
            return 1;
        } else {
            return -1;
        }
    }
}
