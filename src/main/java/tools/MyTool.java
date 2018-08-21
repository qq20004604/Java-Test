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

    public static int StringToInt(String str) {
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
     * 字符串转数字，只允许0-9和位于第一位的负号，否则抛错
     *
     * @param str 被转换的字符串
     * @return 转换后的结果
     * @throws Exception
     */
    public static int StringToIntOnlyNumber(String str) throws Exception {
        StringBuffer buf = new StringBuffer();
        char[] ch = str.toCharArray();
        for (int i = 0; i < ch.length; i++) {
            if (ch[i] >= '0' && ch[i] <= '9') {
                buf.append(ch[i]);
            } else if (buf.length() == 0 && ch[i] == '-') {
                // 这个是考虑到负号
                // 遇见负号时，只有 buf 为空（即让负号处于第一位）的时候，才会添加进去
                buf.append(ch[i]);
            } else {
                throw new Exception("must only have Number or Sign\"-\"");
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

    /**
     * 打印 数组 int[]
     *
     * @param foo 被打印的数组
     */
    public static void log(@NotNull int[] foo) {
        String bar = "[";
        for (int i = 0; i < foo.length; i++) {
            if (i == 0) {
                bar += foo[i];
            } else {
                bar += ", " + foo[i];
            }
        }
        bar += "]";
        System.out.println(bar);
    }

    /**
     * 打印 字符串 String
     *
     * @param foo 被打印的字符串
     */
    public static void log(String foo) {
        System.out.println(foo);
    }

    /**
     * 打印 数字 int
     *
     * @param foo 被打印的数字
     */
    public static void log(int foo) {
        System.out.println(foo);
    }

    /**
     * 数组拷贝
     *
     * @param foo 数组
     * @return 和原数组每个元素的值都相同的一个新数组
     */
    public static int[] copyIntList(int[] foo) {
        int[] bar = {};
        for (int i = 0; i < foo.length; i++) {
            bar[i] = foo[i];
        }
        return bar;
    }

    /**
     * 创建一个带默认值的int数组
     *
     * @param arrayLength  创建数组的长度
     * @param defaultValue 默认值
     * @return 返回符合要求的数组
     */
    public static int[] createIntArray(int arrayLength, int defaultValue) {
        int[] result = new int[arrayLength];
        for (int i = 0; i < arrayLength; i++) {
            result[i] = defaultValue;
        }
        return result;
    }
}
