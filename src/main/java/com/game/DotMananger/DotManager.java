package com.game.DotMananger;

import java.util.Arrays;

public class DotManager {
    // 整个列表
    private int[] container;
    // 船的数量
    private int NumberOfBoats;
    // 空间长度
    private int NumberOfSpace;

    // 空-未探索：1
    // 空-已探索：2
    // 船-未探索/未击中：3
    // 船-已击中：4
    private static final short EmptyNotFind = 1;
    private static final short EmptyFind = 2;
    private static final short BoatNotFind = 3;
    private static final short BoatFind = 4;

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
