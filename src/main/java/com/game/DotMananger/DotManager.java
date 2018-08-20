package com.game.DotMananger;

import tools.MyTool;
import tools.PrintIn;

import java.util.Arrays;

public class DotManager {
    // 整个列表
    private int[] container;
    // 船的数量
    private int NumberOfBoats;
    // 空间长度
    private int NumberOfSpace;
    // 游戏状态
    private boolean gameIsDoing = false;

    // 空-未探索：1
    // 空-已探索：2
    // 船-未探索/未击中：3
    // 船-已击中：4
    private static final short EmptyNotFind = 1;
    private static final short EmptyFind = 2;
    private static final short BoatNotFind = 3;
    private static final short BoatFind = 4;

    /**
     * 构造函数
     */
    public DotManager() {

    }

    public void start() {
        while (true) {
            // 获得用户输入
            String userInput = getPrintIn();

            // 验证用户输入是否合法
            Boolean isCorrect = isUserInputCorrect(userInput);
        }
    }


    /**
     * 获取用户输入
     *
     * @return 用户输入内容
     */
    private String getPrintIn() {
        // 要求用户输入攻击目标
        PrintIn printAct = new PrintIn();

        // 设置提示文字
        printAct.setTips("请输入你要击毁的飞船目标");


        while (printAct.isInputError()) {
            MyTool.log("输入错误，请重新输入");

            // 要求用户输入
            printAct.setUserInput();
        }

        String result = printAct.getUserInput();
        return result;
    }

    /**
     * 输入是否合法
     *
     * @param userInput 用户输入内容
     * @return true 合法
     */
    private boolean isUserInputCorrect(String userInput) {
        int hit;
        // 验证输入是否有效
        try {
            hit = MyTool.StringToInt(userInput);
        } catch (Exception e) {
            MyTool.log("输入非法，请重新输入");
            return false;
        }

        // 验证输入内容是否在范围之内
        if (!isCorrectPosition(hit)) {
            // 不在范围之内，则提示
            MyTool.log("本次命中的坐标是：" + hit + "，" + reportAction(hit) + "，请重试");
            return false;
        }
        return true;
    }

    /**
     * 当前位置是否正确
     *
     * @param pos 此次命中位置
     * @return true 正确的命中
     */
    private boolean isCorrectPosition(int pos) {
        if (pos < 0 || pos > container.length) {
            return false;
        }
        if (container[pos] == EmptyFind || container[pos] == BoatFind) {
            return false;
        }
        return true;
    }

    private String reportAction(int pos) {
        if (pos < 0 || pos > container.length) {
            return "超出范围";
        } else if (container[pos] == EmptyFind || container[pos] == BoatFind) {
            return "该位置已探索";
        } else if (container[pos] == EmptyNotFind) {
            return "未命中";
        } else if (container[pos] == BoatNotFind) {
            return "命中啦！飞船被击毁";
        } else {
            return "未知错误108";
        }
    }

    /**
     * 重置游戏，创造游戏空间
     *
     * @param boats 船的数量
     * @param space 空间数量
     */
    public boolean resetGame(int boats, int space) {
        // 如果船大于空间数量
        if (boats >= space) {
            return false;
        }
        return true;
    }
}
