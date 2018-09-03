package tools;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PrintIn {
    private String str;
    private Boolean isError = false;
    // 输入提示文字：
    private String Tips = "请输入：";

    /**
     * 设置提示信息
     *
     * @param tips 提示信息
     */
    public void setTips(String tips) {
        Tips = tips;
    }

    /**
     * 普通输入，读入一行，正常的字符串
     */
    public void printIn() {
        this.setUserInput();
    }

    /**
     * 只允许输入0-9的字符串，第一位允许负号
     */
    public void printInInt() {
        this.setUserInputOnlyInt();
    }

    /**
     * 获取用户输入内容
     *
     * @return String 字符串
     */
    public String getUserInput() {
        return str;
    }

    /**
     * 上次输入是否正确
     *
     * @return true 正确
     */
    public Boolean isInputError() {
        return isError;
    }

    /**
     * 获取用户输入
     */
    private void setUserInput() {
        isError = false;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            System.out.print(Tips);
            str = br.readLine();
        } catch (IOException e) {
            isError = true;
            // 打印这行错误信息
            e.printStackTrace();
        }
    }

    /**
     * 获取用户输入，只允许输入0-9，第一位允许负号
     */
    private void setUserInputOnlyInt() {
        isError = false;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            System.out.print(Tips);
            String s = br.readLine();
            str = stringToIntOnlyNumber(s);
        } catch (Exception e) {
            isError = true;
            // 打印这行错误信息
//            e.printStackTrace();
        }
    }

    /**
     * 获取用户输入的子函数（将String转为Number）
     */
    private String stringToIntOnlyNumber(String s) throws Exception {
        int result = MyTool.StringToIntOnlyNumber(s);
        str = String.valueOf(result);
        return str;
    }
}
