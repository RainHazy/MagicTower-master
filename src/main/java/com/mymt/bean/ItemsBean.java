package com.mymt.bean;


import java.io.Serializable;

/**
 * ItemsBean 类
 * <p>
 * 全局变量 记录游戏内的特殊道具是否已获取
 *
 * @author ZYY
 * @since 2018-7-14
 */
public class ItemsBean implements Serializable {

    public boolean isHasCross = false;       // 幸运十字架
    public boolean isHasForecast = false;    // 圣光徽 L
    public boolean isHasJump = false;        // 风之罗盘 J
    public boolean isHasHammer = false;      // 星光神榔

//    public static boolean isHasCross = true;        // 幸运十字架
//    public static boolean isHasForecast = true;     // 圣光徽 L
//    public static boolean isHasJump = true;         // 风之罗盘 J
//    public static boolean isHasHammer = true;       // 星光神榔


    public boolean isHasRedStick = false;    // 炎之灵杖
    public boolean isHasGreenStick = false;  // 心之灵杖
    public boolean isHasBlueStick = false;   // 冰之灵杖

}
