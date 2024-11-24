package com.mymt.data;

import com.mymt.MTGame;
import com.mymt.bean.PlayerBean;

import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.Serializable;
import java.util.HashMap;

/**
 * @Author: zzf
 * @Date: 2024/11/23 16:31
 * @Description:
 */
public class MTGameData implements Serializable {
    private static final long serialVersionUID = 1L;

    // 保存MTGame中的静态变量
//    public HashMap<Integer, BufferedImage> imgSource;
    public static JFrame gameFrame;
    public static JPanel gamePanel;
    public PlayerBean playerBean_1;
    public int gameMin;
    public double gameSec;
    public boolean inConversation;
    public boolean talked;
    public int currentFloor;
    public int maxFloor;
    public short[][][] LvMap;

    // 从当前静态状态创建MTGameState实例
    public static MTGameData captureState() {
        MTGameData state = new MTGameData();
//        state.imgSource = new HashMap<>(MTGame.imgSource); // 复制图像源
        state.gameFrame = MTGame.gameFrame;
        state.gamePanel = MTGame.gamePanel;
        state.playerBean_1 = MTGame.playerBean_1;          // 保存玩家属性
        state.gameMin = MTGame.gameMin;
        state.gameSec = MTGame.gameSec;
        state.inConversation = MTGame.inConversation;
        state.talked = MTGame.talked;
        state.currentFloor = MTGame.currentFloor;
        state.maxFloor = MTGame.maxFloor;
        state.LvMap = MapData.LvMap;
        return state;
    }

    // 将MTGameState实例应用到静态状态
    public void applyState() {
//        MTGame.imgSource = this.imgSource;
        MTGame.gameFrame = this.gameFrame;
        MTGame.gamePanel = this.gamePanel;
        MTGame.playerBean_1 = this.playerBean_1;
        MTGame.gameMin = this.gameMin;
        MTGame.gameSec = this.gameSec;
        MTGame.inConversation = this.inConversation;
        MTGame.talked = this.talked;
        MTGame.currentFloor = this.currentFloor;
        MTGame.maxFloor = this.maxFloor;
        MapData.LvMap = this.LvMap;
    }
}
