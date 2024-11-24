package com.mymt.data;


import com.alibaba.fastjson.JSON;

import java.io.Serializable;

import static com.mymt.util.SaveUtil.*;
/**
 * @author ：zzf
 * @description：地图数据
 * @date ：2024/11/26 16:02
 */
public class MapData implements Serializable {

    public static short[][][] LvMap;
    public static int[][] initPos = {
            {5, 9},     // 0
            {5, 9},     // 1
            {0, 1},     // 2
            {1, 10},    // 3
            {10, 9},    // 4
            {1, 10},    // 5
            {9, 9},     // 6
            {5, 10},    // 7
            {0, 1},     // 8
            {6, 3},     // 9
            {4, 6},     // 10
            {1, 10},    // 11
            {9, 10},    // 12
            {1, 10},    // 13
            {5, 9},     // 14
            {3, 0},     // 15
            {5, 0},     // 16
            {5, 8},     // 17
            {1, 10},    // 18
            {9, 10},    // 19
            {5, 4},     // 20
            {5, 5},     // 21
            {5, 1},
            {9, 5}
    };
    public static int[][] finPos = {
            {5, 1},     // 0
            {1, 0},     // 1
            {0, 9},     // 2
            {10, 9},    // 3
            {0, 9},     // 4
            {9, 9},     // 5
            {5, 10},    // 6
            {1, 0},     // 7
            {7, 4},     // 8
            {6, 7},     // 9
            {0, 9},     // 10
            {9, 10},    // 11
            {1, 10},    // 12
            {4, 10},    // 13
            {5, 0},     // 14
            {7, 0},     // 15
            {5, 7},     // 16
            {1, 10},    // 17
            {9, 10},    // 18
            {5, 4},     // 19
            {5, 8},     // 20
            {5, 2},      // 21
            {1, 5},
            {}
    };

    static {
        LvMap = JSON.parseObject(load("LvMap"),short[][][].class);
    }

}
