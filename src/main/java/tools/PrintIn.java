package tools;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;

public class PrintIn {
    private String s;
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

    public void printIn() {
        this.setUserInput();
    }

    /**
     * 获取用户输入
     */
    public void setUserInput() {
        isError = false;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            System.out.print(Tips);
            s = br.readLine();
        } catch (IOException e) {
            isError = true;
            // 打印这行错误信息
            e.printStackTrace();
        }
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
     * 获取用户输入内容
     *
     * @return String 字符串
     */
    public String getUserInput() {
        return s;
    }
}
