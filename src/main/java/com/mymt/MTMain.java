package com.mymt;

import com.mymt.bean.ItemsBean;
import com.mymt.util.SaveUtil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.Serializable;

import static com.mymt.MTGame.*;
import static com.mymt.util.BattleUtil.battleLPane;
import static com.mymt.util.ForecastUtil.displayForecast;
import static com.mymt.util.ForecastUtil.forecastLPane;
import static com.mymt.util.JumpUtil.displayJump;
import static com.mymt.util.JumpUtil.jumpLPane;
import static com.mymt.util.MsgUtil.msgLPane;
import static java.awt.event.KeyEvent.*;
import static com.mymt.util.SaveUtil.*;

/**
 * @Author: zzf
 * @Date: 2024/11/23 11:26
 * @Description:
 */
public class MTMain implements Serializable {
    int status = 0;
    public int start() {
        gamePanel = new MTGame();
        gamePanel.setPreferredSize(new Dimension(GAME_PIX_72 * 18, GAME_PIX_72 * 13));

        gamePanel.add(forecastLPane);
        gamePanel.add(jumpLPane);
        gamePanel.add(battleLPane);
        gamePanel.add(msgLPane);
        gamePanel.add(timeLabel);
        gamePanel.add(speedLabel);
        gameFrame.addKeyListener(new KeyListener() {

            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
                if (!MTGame.inConversation)
                    switch (e.getKeyCode()) {

                        case VK_DOWN:   // 键盘 ↓
                            if ( playerBean_1.getPosY() + 1 < 11 && playerBean_1.getPosY() + 1 >= 0) {
                                playerBean_1.setToward(1);
                                interaction(playerBean_1.getPosX(), playerBean_1.getPosY() + 1);
                                gameFrame.repaint();
                            }
                            break;
                        case VK_RIGHT:  // 键盘 →
                            if (playerBean_1.getPosX() + 1 < 11 && playerBean_1.getPosX() + 1 >= 0) {
                                playerBean_1.setToward(2);
                                interaction(playerBean_1.getPosX() + 1, playerBean_1.getPosY());
                                gameFrame.repaint();
                            }
                            break;
                        case VK_UP:     // 键盘 ↑
                            if (playerBean_1.getPosY() - 1 < 11 && playerBean_1.getPosY() - 1 >= 0) {
                                playerBean_1.setToward(3);
                                interaction(playerBean_1.getPosX(), playerBean_1.getPosY() - 1);
                                gameFrame.repaint();
                            }
                            break;
                        case VK_LEFT:   // 键盘 ←
                            if (playerBean_1.getPosX() - 1 < 11 && playerBean_1.getPosX() - 1 >= 0) {
                                playerBean_1.setToward(0);
                                interaction(playerBean_1.getPosX() - 1, playerBean_1.getPosY());
                                gameFrame.repaint();
                            }
                            break;
                        case VK_J:      // 键盘 J
                            if (MTGame.itemsBean.isHasJump) {
                                inConversation = true;
                                displayJump();
                            }
                            break;
                        case VK_L:      // 键盘 L
                            if (MTGame.itemsBean.isHasForecast) {
                                displayForecast();
                            }
                            break;
                        case VK_F1:      // 键盘 F1，保存
                            status = 1;
                            SaveUtil.saveGame(MTMain.this);
                            break;
                        case VK_F2:      // 键盘 F2，加载
                            // 重新启动游戏
                            gameFrame.dispose(); // 关闭当前窗口
                            MTMain loadedGame = SaveUtil.loadGame();
                            loadedGame.start();
                            break;
                        case VK_Z:      // 键盘 Z，战斗减速
                            if (speed_level>0) {
                                --speed_level;
                                save("speed_level",speed_level+"");
                                speedLabel.setText(" 战斗速度：*" + (speed_level+1) );
                            }
                            break;
                        case VK_C:      // 键盘 C，战斗加速
                            if (speed_level<2) {
                                ++speed_level;
                                save("speed_level",speed_level+"");
                                speedLabel.setText(" 战斗速度：*" + (speed_level+1) );
                            }
                            break;
                    }
                else if (e.getKeyCode() == e.VK_L)//bug
                {
                    inConversation = false;
                    forecastLPane.removeAll();
                    forecastLPane.setVisible(false);
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
            }
        });

        gameFrame.setContentPane(gamePanel);
        gameFrame.setResizable(false);
        gameFrame.pack();
        gameFrame.setLocationRelativeTo(null);
        gameFrame.setVisible(true);
        gameFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        return status;
    }

}
