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

    /**
     * 设置空间和飞船的谁来
     */
    public void setContainerAndBoats() {
        // 获取用户输入的空间和船
        getContainerAndBoats();

        // 创建船和宇宙空间
        createContainer();
        createBoats();

        // 通报状态
        notifyState();
        gameIsDoing = true;
    }


    /**
     * 获取空间和飞船
     */
    private void getContainerAndBoats() {
        int space, boats;
        while (true) {
            space = getIntInput("请输入空间大小：");
            boats = getIntInput("请输入飞船数量：");

            if (space < boats) {
                MyTool.log("飞船数量应该大于宇宙空间");
            } else {
                break;
            }
        }
        NumberOfSpace = space;
        NumberOfBoats = boats;
    }


    /**
     * 开始游戏
     */
    public void playGame() {
        while (true) {
            // 获得用户输入
            String userInput = getPrintIn();

            // 验证用户输入是否合法
            Boolean isCorrect = isUserInputCorrect(userInput);

            // 不合法则继续输入
            if (!isCorrect) {
                continue;
            }

            // 命中目标
            int hit = MyTool.StringToInt(userInput);

            try {
                //　干掉那个船！抛错说明出问题了
                tryKillBoat(hit);
            } catch (Exception e) {
                continue;
            }

            // 此次命中信息
            String msg = reportAction(hit);

            // 判定游戏是否结束
            if (isGameover()) {
                MyTool.log("本次命中的坐标是：" + hit + "，" + msg + "，所有飞船都被摧毁，游戏结束！");
                break;
            } else {
                MyTool.log("本次命中的坐标是：" + hit + "，" + msg + "，本轮结束，游戏继续");
            }

            // 通报当前游戏状态
            notifyState();
        }
    }

    /**
     * 创建宇宙空间
     */
    private void createContainer() {
        container = MyTool.createIntArray(NumberOfSpace, EmptyNotFind);
    }

    /**
     * 创建飞船
     */
    private void createBoats() {
        // 随机生成第一个船的坐标
        int firstBoat = (int) (Math.random() * (NumberOfSpace - NumberOfBoats));

        for (int i = firstBoat; i < firstBoat + NumberOfBoats; i++) {
            container[i] = BoatNotFind;
        }
    }

    /**
     * 获取用户输入的值
     *
     * @param msg
     * @return
     */
    private int getIntInput(String msg) {
        PrintIn printAct = new PrintIn();

        // 设置提示文字
        printAct.setTips(msg);

        int number;

        // 要求输入 int 类型的值
        printAct.printInInt();

        // 报错则继续输入
        while (printAct.isInputError()) {
            MyTool.log("输入错误，请重新输入");
            // 要求输入 int 类型的值
            printAct.printInInt();
        }

        number = Integer.parseInt(printAct.getUserInput());
        return number;
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
        printAct.setTips("请输入你要击毁的飞船目标：");

        // 要求用户输入
        printAct.printIn();

        while (printAct.isInputError()) {
            MyTool.log("输入错误，请重新输入：");

            // 要求用户输入
            printAct.printIn();
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
     * @return true 正确的命中（未探索的空间 或者 未发现的飞船）
     */
    private boolean isCorrectPosition(int pos) {
        if (pos < 0 || pos >= container.length) {
            return false;
        }
        if (container[pos] == EmptyFind || container[pos] == BoatFind) {
            return false;
        }
        return true;
    }

    /**
     * 根据当前攻击目标返回信息
     *
     * @param pos
     * @return
     */
    private String reportAction(int pos) {
        if (pos < 0 || pos > container.length) {
            return "该位置超出范围";
        } else if (container[pos] == EmptyFind ) {
            return "该位置为空";
        } else if (container[pos] == BoatFind) {
            return "该位置为飞船，已探索";
        } else if (container[pos] == EmptyNotFind) {
            return "未命中";
        } else if (container[pos] == BoatNotFind) {
            return "命中啦！飞船被击毁";
        } else {
            return "未知错误108";
        }
    }


    /**
     * 完成一次攻击动作
     *
     * @param pos 理论上，这个只会是 未探索的空间 或者 未发现的飞船
     */
    private void tryKillBoat(int pos) throws Exception {
        if (container[pos] == BoatNotFind) {
            container[pos] = BoatFind;
        } else if (container[pos] == EmptyNotFind) {
            container[pos] = EmptyFind;
        } else {
            throw new Exception("错误的输入内容109");
        }
    }

    /**
     * 游戏是否结束
     *
     * @return true 结束
     */
    private boolean isGameover() {
        // 检查还有没有未命中船的下标
        int notFindBoatIndex = MyTool.indexOf(container, BoatNotFind);

        // < 0 说明无，游戏结束
        if (notFindBoatIndex < 0) {
            return true;
        } else {
            return false;
        }
    }

    private void notifyState() {
        String log = "";
        for (int i = 0; i < container.length; i++) {
            log += "【";
            if (container[i] == EmptyNotFind || container[i] == BoatNotFind) {
                log += i;
            } else if (container[i] == EmptyFind) {
                log += "空";
            } else if (container[i] == BoatFind) {
                log += "损毁的飞船";
            }
            log += "】 ";
        }
        MyTool.log("————————————————————");
        MyTool.log("雷达扫描结果如下");
        MyTool.log(log);
        MyTool.log("————————————————————");
    }
}
