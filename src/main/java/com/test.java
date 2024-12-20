package com;

import java.io.*;
import java.util.Arrays;
import static com.mymt.util.SaveUtil.*;

/**
 * @author ：zzf
 * @description：
 * @date ：2024/11/21 16:02
 */
public class test {

    public static void main(String[] args) throws IOException {
        short[][][] LvMap = new short[][][]{
                {   // 第  0 层
                        {1, 20, 20, 20, 20, 13, 20, 20, 20, 20, 1},
                        {1, 20, 20, 20, 20, 00, 20, 20, 20, 20, 1},
                        {1, 20, 20, 20, 20, 0, 20, 20, 20, 20, 1},
                        {1, 20, 20, 20, 20, 0, 20, 20, 20, 20, 1},
                        {1, 20, 20, 20, 20, 0, 20, 20, 20, 20, 1},
                        {1, 20, 20, 20, 20, 0, 20, 20, 20, 20, 1},
                        {1, 1, 20, 20, 20, 0, 20, 20, 20, 1, 1},
                        {1, 1, 1, 1, 1, 2, 1, 1, 1, 1, 1},
                        {19, 1, 19, 1, 0, 24, 0, 1, 19, 1, 19},
                        {19, 19, 19, 19, 19, 00, 19, 19, 19, 19, 19},
                        {19, 19, 19, 19, 19, 0, 19, 19, 19, 19, 19}
                },
                {   // 第 1 层
                        {13, 00, 6, 40, 41, 40, 0, 0, 0, 0, 0},
                        {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0},
                        {11, 0, 44, 2, 0, 1, 11, 6, 11, 1, 0},
                        {6, 44, 10, 1, 0, 1, 11, 6, 11, 1, 0},
                        {1, 2, 1, 1, 0, 1, 1, 1, 43, 1, 0},
                        {6, 45, 0, 1, 0, 2, 63, 40, 42, 1, 0},
                        {9, 0, 7, 1, 0, 1, 1, 1, 1, 1, 0},
                        {1, 2, 1, 1, 0, 0, 0, 0, 0, 0, 0},
                        {0, 45, 0, 1, 1, 4, 1, 1, 1, 2, 1},
                        {11, 12, 6, 1, 8, 00, 0, 1, 6, 46, 7},
                        {11, 34, 6, 1, 0, 14, 0, 1, 6, 6, 6}
                },
                {   // 第 2 层
                        {14, 1, 0, 55, 0, 1, 10, 9, 6, 8, 1},
                        {00, 1, 9, 1, 12, 1, 10, 9, 6, 7, 1},
                        {0, 1, 6, 1, 6, 1, 10, 9, 6, 54, 1},
                        {0, 1, 6, 1, 6, 1, 1, 1, 1, 2, 1},
                        {0, 1, 0, 1, 0, 0, 0, 2, 0, 0, 1},
                        {0, 1, 2, 1, 1, 2, 1, 1, 2, 1, 1},
                        {0, 5, 0, 0, 0, 0, 1, 0, 54, 0, 1},
                        {0, 1, 2, 1, 1, 3, 1, 115, 1, 115, 1},
                        {0, 1, 6, 1, 12, 11, 1, 0, 1, 0, 1},
                        {00, 1, 6, 1, 12, 11, 1, 0, 1, 0, 1},
                        {13, 1, 10, 1, 12, 11, 1, 26, 1, 27, 1}
                },
                {   // 第 3 层
                        {71, 41, 6, 1, 23, 22, 21, 1, 1, 1, 1},
                        {41, 6, 0, 1, 0, 0, 0, 1, 0, 42, 0},
                        {6, 44, 0, 1, 1, 2, 1, 1, 0, 1, 0},
                        {1, 2, 1, 1, 0, 44, 0, 1, 6, 1, 41},
                        {0, 0, 0, 1, 1, 1, 0, 1, 6, 1, 42},
                        {40, 1, 0, 42, 41, 42, 0, 1, 6, 1, 41},
                        {40, 1, 1, 1, 1, 1, 0, 0, 0, 1, 0},
                        {0, 0, 0, 0, 0, 1, 1, 2, 1, 1, 0},
                        {1, 1, 1, 1, 42, 1, 41, 0, 41, 1, 0},
                        {1, 0, 0, 0, 0, 1, 9, 42, 6, 1, 00},
                        {14, 00, 1, 1, 1, 1, 10, 12, 6, 1, 13}
                },
                {   // 第 4 层
                        {0, 43, 0, 1, 0, 25, 0, 1, 0, 43, 0},
                        {2, 1, 2, 1, 0, 0, 0, 1, 2, 1, 2},
                        {0, 1, 0, 1, 1, 115, 1, 1, 0, 1, 0},
                        {0, 1, 44, 1, 48, 49, 48, 1, 44, 1, 0},
                        {42, 1, 11, 1, 9, 48, 9, 1, 11, 1, 42},
                        {42, 1, 11, 1, 1, 4, 1, 1, 11, 1, 42},
                        {41, 1, 0, 1, 46, 47, 46, 1, 0, 1, 41},
                        {0, 1, 0, 1, 10, 46, 10, 1, 0, 1, 0},
                        {0, 1, 0, 1, 1, 3, 1, 1, 0, 1, 0},
                        {00, 1, 0, 1, 6, 0, 6, 1, 0, 1, 00},
                        {13, 1, 0, 43, 0, 0, 0, 43, 0, 1, 14}
                },
                {   // 第 5 层
                        {36, 1, 11, 1, 12, 63, 0, 0, 63, 6, 7},
                        {0, 1, 10, 1, 63, 0, 0, 0, 0, 63, 6},
                        {48, 1, 0, 1, 45, 0, 1, 1, 2, 1, 1},
                        {0, 2, 63, 1, 76, 45, 1, 0, 46, 45, 27},
                        {48, 1, 0, 1, 1, 1, 1, 0, 0, 0, 45},
                        {10, 1, 0, 0, 0, 42, 44, 0, 0, 0, 0},
                        {9, 1, 1, 43, 1, 1, 1, 1, 0, 0, 0},
                        {0, 26, 1, 43, 1, 0, 0, 0, 46, 47, 0},
                        {1, 1, 1, 42, 1, 2, 1, 3, 1, 2, 1},
                        {00, 0, 1, 0, 1, 42, 1, 9, 2, 00, 1},
                        {14, 0, 42, 0, 0, 0, 1, 6, 1, 13, 1}
                },
                {   // 第 6 层
                        {30, 56, 1, 9, 1, 6, 51, 39, 1, 12, 12},
                        {56, 6, 1, 10, 1, 0, 6, 51, 1, 65, 12},
                        {6, 49, 3, 0, 3, 49, 0, 6, 1, 0, 65},
                        {0, 0, 1, 47, 1, 0, 0, 0, 1, 52, 0},
                        {1, 1, 1, 4, 1, 1, 1, 1, 1, 2, 1},
                        {0, 0, 64, 0, 6, 6, 6, 0, 64, 0, 0},
                        {0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                        {0, 1, 48, 2, 48, 0, 0, 0, 0, 0, 1},
                        {0, 1, 2, 1, 2, 1, 1, 1, 1, 3, 1},
                        {0, 1, 48, 1, 0, 0, 1, 1, 0, 00, 1},
                        {0, 0, 0, 1, 13, 00, 2, 2, 0, 14, 1}
                },
                {   // 第 7 层
                        {13, 00, 0, 0, 0, 0, 0, 0, 1, 1, 1},
                        {1, 1, 0, 49, 1, 3, 1, 56, 0, 1, 1},
                        {1, 0, 49, 9, 1, 50, 1, 10, 56, 0, 1},
                        {0, 0, 1, 1, 1, 15, 1, 1, 1, 0, 0},
                        {0, 0, 3, 50, 115, 32, 15, 50, 3, 0, 0},
                        {0, 1, 1, 1, 1, 15, 1, 1, 1, 1, 0},
                        {0, 1, 11, 10, 1, 50, 1, 9, 11, 1, 0},
                        {0, 1, 6, 11, 1, 3, 1, 11, 6, 1, 0},
                        {0, 1, 1, 7, 7, 12, 7, 7, 1, 1, 0},
                        {0, 0, 1, 1, 1, 4, 1, 1, 1, 0, 0},
                        {1, 0, 0, 2, 14, 00, 0, 2, 0, 0, 1}
                },
                {   // 第 8 层
                        {14, 1, 0, 0, 0, 0, 1, 0, 6, 56, 0},
                        {00, 1, 0, 1, 1, 2, 1, 2, 1, 1, 0},
                        {0, 1, 0, 1, 0, 0, 3, 0, 0, 1, 10},
                        {0, 1, 0, 1, 60, 1, 1, 1, 48, 1, 43},
                        {48, 1, 0, 1, 11, 1, 13, 00, 0, 1, 43},
                        {49, 1, 9, 1, 11, 1, 1, 1, 1, 1, 0},
                        {48, 1, 43, 1, 0, 0, 0, 1, 0, 49, 0},
                        {0, 1, 43, 1, 1, 1, 47, 1, 2, 1, 1},
                        {0, 1, 0, 56, 0, 1, 56, 1, 0, 0, 0},
                        {0, 1, 1, 1, 2, 1, 0, 1, 1, 1, 0},
                        {0, 0, 60, 0, 0, 1, 0, 51, 50, 51, 0}
                },
                {   // 第 9 层
                        {35, 6, 0, 1, 1, 1, 0, 0, 0, 1, 0},
                        {6, 0, 66, 2, 0, 0, 0, 1, 0, 2, 56},
                        {1, 2, 1, 1, 0, 1, 1, 1, 0, 1, 6},
                        {0, 0, 0, 1, 0, 1, 00, 0, 0, 1, 6},
                        {0, 0, 0, 4, 0, 1, 14, 1, 0, 1, 11},
                        {1, 3, 1, 1, 0, 1, 1, 1, 0, 1, 1},
                        {9, 52, 10, 1, 60, 1, 13, 1, 0, 1, 11},
                        {1, 2, 1, 1, 0, 0, 00, 2, 0, 1, 6},
                        {56, 11, 56, 1, 1, 3, 1, 1, 0, 1, 6},
                        {7, 56, 11, 1, 65, 60, 65, 1, 0, 2, 56},
                        {73, 7, 56, 2, 12, 65, 12, 1, 0, 1, 0}
                },
                {   // 第 10 层
                        {0, 1, 1, 9, 66, 1, 66, 10, 1, 1, 0},
                        {0, 0, 1, 1, 2, 1, 2, 1, 1, 0, 52},
                        {0, 0, 0, 0, 0, 1, 0, 0, 0, 52, 12},
                        {0, 1, 0, 1, 1, 1, 1, 1, 0, 1, 1},
                        {48, 1, 0, 0, 6, 6, 6, 0, 0, 1, 6},
                        {49, 1, 0, 1, 1, 1, 1, 2, 1, 1, 6},
                        {48, 1, 0, 115, 00, 14, 1, 0, 2, 49, 0},
                        {0, 1, 1, 1, 1, 1, 1, 2, 1, 1, 0},
                        {0, 1, 11, 9, 10, 1, 0, 49, 0, 1, 6},
                        {00, 1, 11, 9, 10, 4, 60, 1, 60, 1, 6},
                        {13, 1, 11, 9, 10, 1, 7, 1, 7, 1, 11}
                },
                {   // 第 11 层
                        {11, 1, 6, 1, 7, 1, 8, 1, 12, 78, 12},
                        {11, 1, 6, 1, 7, 1, 8, 1, 68, 69, 68},
                        {11, 1, 6, 1, 7, 1, 8, 1, 0, 68, 0},
                        {2, 1, 2, 1, 2, 1, 2, 1, 1, 3, 1},
                        {0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                        {2, 1, 1, 3, 1, 1, 1, 3, 1, 1, 2},
                        {9, 1, 0, 68, 12, 67, 12, 68, 0, 1, 10},
                        {9, 1, 66, 1, 1, 1, 1, 1, 66, 1, 10},
                        {9, 1, 66, 1, 23, 22, 21, 1, 66, 1, 10},
                        {1, 1, 4, 1, 11, 0, 11, 1, 4, 1, 1},
                        {14, 00, 0, 0, 0, 0, 0, 0, 0, 00, 13}
                },
                {   // 第 12 层
                        {27, 9, 1, 0, 54, 55, 54, 0, 1, 12, 38},
                        {10, 0, 1, 0, 1, 2, 1, 0, 1, 0, 12},
                        {0, 0, 1, 0, 1, 55, 1, 0, 1, 0, 0},
                        {0, 67, 1, 0, 1, 6, 1, 0, 1, 58, 0},
                        {67, 61, 1, 0, 1, 6, 1, 0, 1, 57, 58},
                        {1, 3, 1, 0, 1, 11, 1, 0, 1, 3, 1},
                        {0, 0, 0, 0, 1, 11, 1, 0, 0, 0, 0},
                        {1, 1, 1, 0, 1, 1, 1, 0, 1, 1, 1},
                        {9, 67, 2, 68, 68, 69, 68, 68, 2, 67, 10},
                        {1, 1, 1, 1, 1, 3, 1, 1, 1, 1, 1},
                        {13, 00, 0, 0, 0, 0, 0, 0, 0, 00, 14}
                },
                {   // 第 13 层
                        {0, 67, 0, 0, 0, 0, 0, 1, 0, 61, 0},
                        {0, 1, 1, 1, 1, 1, 2, 1, 0, 1, 0},
                        {0, 1, 0, 0, 68, 0, 0, 1, 0, 1, 0},
                        {12, 1, 4, 1, 1, 1, 0, 1, 0, 1, 0},
                        {54, 1, 0, 0, 61, 1, 68, 1, 10, 1, 0},
                        {55, 1, 0, 62, 15, 1, 69, 1, 10, 1, 0},
                        {54, 1, 61, 115, 26, 1, 68, 1, 10, 1, 9},
                        {0, 1, 1, 1, 1, 1, 0, 1, 0, 1, 9},
                        {0, 54, 0, 1, 0, 0, 0, 61, 0, 1, 9},
                        {1, 1, 0, 1, 12, 1, 1, 1, 1, 1, 0},
                        {14, 00, 0, 3, 00, 13, 1, 31, 62, 2, 0}
                },
                {   // 第 14 层
                        {1, 0, 58, 36, 13, 00, 0, 0, 0, 0, 1},
                        {1, 0, 12, 1, 1, 1, 1, 1, 12, 0, 1},
                        {1, 0, 1, 1, 1, 1, 1, 1, 1, 0, 1},
                        {1, 0, 1, 1, 1, 33, 1, 1, 1, 0, 1},
                        {1, 0, 1, 1, 1, 115, 1, 1, 1, 0, 1},
                        {1, 0, 11, 1, 1, 61, 1, 1, 11, 0, 1},
                        {1, 0, 20, 20, 1, 62, 1, 20, 20, 0, 1},
                        {1, 0, 20, 20, 1, 61, 1, 20, 20, 0, 1},
                        {1, 0, 20, 20, 1, 3, 1, 20, 20, 0, 1},
                        {1, 68, 69, 68, 3, 00, 3, 68, 69, 68, 1},
                        {1, 1, 1, 1, 1, 14, 1, 1, 1, 1, 1}
                },
                {   // 第 15 层
                        {0, 0, 0, 00, 14, 20, 13, 00, 0, 0, 0},
                        {0, 20, 20, 20, 20, 20, 20, 20, 20, 20, 0},
                        {0, 20, 20, 1, 1, 1, 1, 1, 20, 20, 0},
                        {0, 20, 1, 1, 26, 1, 27, 1, 1, 20, 0},
                        {0, 20, 1, 1, 9, 1, 9, 1, 1, 20, 0},
                        {0, 20, 1, 1, 10, 1, 10, 1, 1, 20, 0},
                        {0, 20, 20, 1, 0, 1, 0, 1, 20, 20, 0},
                        {0, 20, 20, 1, 2, 1, 2, 1, 20, 20, 0},
                        {0, 20, 20, 20, 0, 0, 0, 20, 20, 20, 0},
                        {0, 20, 20, 20, 20, 4, 20, 20, 20, 20, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}
                },
                {   // 第 16 层
                        {20, 20, 20, 20, 20, 00, 14, 20, 20, 20, 20},
                        {20, 20, 20, 20, 20, 0, 20, 20, 20, 20, 20},
                        {20, 20, 20, 20, 20, 0, 20, 20, 20, 20, 20},
                        {20, 20, 20, 20, 1, 4, 1, 20, 20, 20, 20},
                        {20, 20, 20, 1, 26, 119, 1, 1, 20, 20, 20},
                        {20, 20, 20, 1, 1, 53, 1, 1, 20, 20, 20},
                        {20, 20, 20, 1, 1, 00, 1, 1, 20, 20, 20},
                        {20, 20, 20, 1, 1, 13, 1, 1, 20, 20, 20},
                        {20, 20, 20, 20, 1, 1, 1, 20, 20, 20, 20},
                        {20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20},
                        {20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20}
                },
                {   // 第 17 层
                        {20, 58, 62, 0, 0, 0, 0, 0, 0, 0, 58},
                        {20, 62, 20, 20, 20, 20, 20, 20, 20, 20, 0},
                        {20, 0, 20, 58, 0, 0, 0, 0, 0, 0, 58},
                        {20, 0, 20, 0, 20, 20, 20, 20, 20, 20, 20},
                        {20, 0, 20, 0, 20, 58, 0, 0, 0, 58, 20},
                        {20, 0, 20, 58, 0, 0, 20, 20, 20, 0, 20},
                        {20, 0, 20, 20, 20, 20, 20, 58, 0, 58, 20},
                        {20, 62, 20, 20, 20, 14, 20, 0, 20, 20, 20},
                        {20, 58, 62, 0, 70, 00, 20, 58, 0, 0, 58},
                        {20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 0},
                        {13, 00, 70, 0, 0, 0, 0, 0, 0, 0, 58}
                },
                {   // 第 18 层 （测试时 增加 楼梯）
                        {20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20},
                        {20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20},
                        {20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20},
                        {20, 20, 20, 20, 1, 1, 1, 20, 20, 20, 20},
                        {20, 20, 20, 1, 1, 28, 1, 1, 20, 20, 20},
                        {20, 20, 20, 1, 1, 115, 1, 1, 20, 20, 20},
                        {20, 20, 20, 1, 1, 4, 1, 1, 20, 20, 20},
                        {20, 20, 20, 20, 1, 4, 1, 20, 20, 20, 20},
                        {20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20},
                        {20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20},
                        {14, 00, 0, 0, 0, 0, 0, 0, 0, 00, /*0*/13}
                },
                {   // 第 19 层
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 20, 0, 20, 20, 20, 20, 20, 0, 20, 0},
                        {0, 20, 0, 20, 20, 20, 20, 20, 0, 20, 0},
                        {0, 20, 0, 20, 20, 13, 20, 20, 0, 20, 0},
                        {0, 20, 0, 20, 20, 00, 20, 20, 0, 20, 0},
                        {0, 20, 53, 20, 20, 0, 20, 20, 53, 20, 0},
                        {0, 20, 115, 20, 20, 59, 20, 20, 115, 20, 0},
                        {0, 20, 75, 20, 20, 129, 20, 20, 80, 20, 0},
                        {0, 20, 20, 20, 20, 0, 20, 20, 20, 20, 0},
                        {0, 20, 20, 20, 20, 0, 20, 20, 20, 20, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 00, 14}
                },
                {   // 第 20 层 （测试时 增加 楼梯）
                        {70, 10, 50, 11, 62, 8, 62, 11, 50, 10, 70},
                        {12, 20, 6, 20, 7, 20, 7, 20, 6, 20, 12},
                        {20, 9, 50, 0, 58, 0, 58, 0, 50, 9, 20},
                        {11, 20, 6, 20, 0, 14, 0, 20, 6, 20, 11},
                        {62, 7, 58, 0, 0, 00, 0, 0, 58, 7, 62},
                        {8, 20, 0, 20, 0, 20, 0, 20, 0, 20, 8},
                        {62, 7, 58, 0, 0, 00, 0, 0, 58, 7, 62},
                        {11, 20, 6, 20, 0, /*0*/13, 0, 20, 6, 20, 11},
                        {20, 9, 50, 0, 58, 0, 58, 0, 50, 9, 20},
                        {12, 20, 6, 20, 7, 20, 7, 20, 6, 20, 12},
                        {70, 10, 50, 11, 62, 8, 62, 11, 50, 10, 70}
                },
                {   // 第 21 层 （测试时 增加 楼梯）
                        {20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20},
                        {20, 20, 0, 0, 20, /*59*/13, 20, 0, 0, 20, 20},
                        {20, 0, 0, 20, 20, 57, 20, 20, 0, 0, 20},
                        {20, 0, 0, 0, 20, 57, 20, 0, 0, 0, 20},
                        {20, 20, 0, 0, 0, 0, 0, 0, 0, 20, 20},
                        {20, 20, 0, 0, 0, 00, 0, 0, 0, 20, 20},
                        {20, 20, 20, 0, 0, 20, 0, 0, 20, 20, 20},
                        {20, 20, 20, 20, 15, 14, 15, 20, 20, 20, 20},
                        {20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20},
                        {20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20},
                        {20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20}
                },
                {   // 第 22 层（测试时 增加 楼梯 301 302。 —— 301 从 22 到 24 层；302 从 22 到 25 层）
                        {20, 20, 20, 20, 20, 14, 20, 20, 20, 20, 20},
                        {20, 20, 20, 20, 20, 00, 20, 20, 20, 20, 20},
                        {20, 20, 20, 20, 0, 0, 24, 20, 20, 20, 20},
                        {15, 15, 15, 20, 20, 4, 20, 20, 15, 15, 15},
                        {10, 10, 15, 20, 20, 39, 20, 20, 15, 9, 9},
                        {13, 10, 58, 4, 39, 00, 39, 4, 58, 9, /*13*/302},
                        {10, 10, 15, 20, 20, 39, 20, 20, 15, 9, 9},
                        {15, 15, 15, 20, 20, 4, 20, 20, 15, 15, 15},
                        {20, 20, 20, 15, 15, 58, 15, 15, 20, 20, 20},
                        {20, 20, 20, 15, 12, 12, 12, 15, 20, 20, 20},
                        {20, 20, 20, 15, 12, /*13*/301, 12, 15, 20, 20, 20}
                },
                {   // 第 23 层（左）23
                        {58, 0, 0, 10, 10, 10, 0, 0, 20, 0, 12},
                        {0, 20, 20, 20, 20, 20, 20, 0, 3, 0, 20},
                        {10, 20, 20, 57, 58, 58, 58, 0, 20, 0, 20},
                        {10, 20, 20, 30, 20, 20, 20, 20, 20, 0, 20},
                        {0, 57, 20, 20, 20, 20, 20, 20, 39, 0, 20},
                        {20, 4, 59, 115, 202, 20, 20, 39, 3, 00, 14},
                        {0, 57, 20, 20, 20, 20, 20, 20, 39, 0, 20},
                        {10, 20, 20, 30, 20, 20, 20, 20, 20, 0, 20},
                        {10, 20, 20, 57, 58, 58, 58, 0, 20, 0, 20},
                        {0, 20, 20, 20, 20, 20, 20, 0, 3, 0, 20},
                        {58, 0, 0, 10, 10, 10, 0, 0, 20, 0, 12}
                },
                {
                        // 第 23 层（下）24 （测试时 楼梯 14 改为 楼梯 303。 —— 303 从 24 到 22 层）
                        // 5 改为 305。从 24 到 26 层
                        {12, 20, 20, 20, 20, /*14*/303, 20, 20, 20, 20, 12},
                        {0, 0, 0, 0, 0, 00, 0, 0, 0, 0, 0},
                        {20, 3, 20, 20, 36, 3, 36, 20, 20, 3, 20},
                        {0, 0, 0, 20, 20, 36, 20, 20, 0, 0, 0},
                        {0, 20, 58, 20, 20, 20, 20, 20, 58, 20, 0},
                        {0, 20, 58, 20, 20, 20, 20, 20, 58, 20, 0},
                        {11, 20, 58, 20, 20, /*5*/305, 20, 20, 58, 20, 11},
                        {11, 20, 57, 31, 20, 115, 20, 31, 57, 20, 11},
                        {11, 20, 20, 20, 20, 59, 20, 20, 20, 20, 11},
                        {0, 20, 20, 20, 57, 4, 57, 20, 20, 20, 0},
                        {58, 0, 12, 12, 0, 20, 0, 12, 12, 0, 58}
                },
                {   // 第 23 层（右）25 （测试时 楼梯 14 改为 楼梯 304。 —— 304 从 25 到 22 层）
                        {12, 0, 20, 0, 0, 0, 9, 9, 9, 0, 58},
                        {20, 0, 3, 0, 20, 20, 20, 20, 20, 20, 0},
                        {20, 0, 20, 0, 58, 58, 58, 57, 20, 20, 9},
                        {20, 0, 20, 20, 20, 20, 20, 30, 20, 20, 9},
                        {20, 0, 39, 20, 20, 20, 20, 20, 20, 57, 0},
                        {/*14*/304, 00, 3, 39, 20, 20, 203, 115, 59, 4, 20},
                        {20, 0, 39, 20, 20, 20, 20, 20, 20, 57, 0},
                        {20, 0, 20, 20, 20, 20, 20, 30, 20, 20, 9},
                        {20, 0, 20, 0, 58, 58, 58, 57, 20, 20, 9},
                        {20, 0, 3, 0, 20, 20, 20, 20, 20, 20, 0},
                        {12, 0, 20, 0, 0, 0, 9, 9, 9, 0, 58}
                },
//                {   // 地 下 层 26 魔龙
//                        {19, 19, 19, 15, 15, 15, 15, 15, 19, 19, 19},
//                        {19, 19, 19, 15, 181, 182, 183, 15, 19, 19, 19},
//                        {19, 19, 19, 15, 184, 185, 186, 15, 19, 19, 19},
//                        {19, 19, 19, 15, 187, 188, 189, 15, 19, 19, 19},
//                        {19, 19, 19, 15, 15, 0, 15, 15, 19, 19, 19},
//                        {19, 12, 12, 12, 12, 57, 12, 12, 12, 12, 19},
//                        {19, 19, 19, 19, 19, 58, 19, 19, 19, 19, 19},
//                        {19, 19, 19, 30, 58, 59, 58, 30, 19, 19, 19},
//                        {19, 19, 19, 19, 19, 58, 19, 19, 19, 19, 19},
//                        {19, 19, 19, 19, 12, 57, 12, 19, 19, 19, 19},
//                        {19, 19, 19, 19, 19, 00, 19, 19, 19, 19, 19}
//                }
                {   // 地 下 层 26 血影
                        {19, 19, 19, 15, 15, 15, 15, 15, 19, 19, 19},
                        {19, 19, 19, 15, 191, 192, 193, 15, 19, 19, 19},
                        {19, 19, 19, 15, 194, 195, 196, 15, 19, 19, 19},
                        {19, 19, 19, 15, 197, 198, 199, 15, 19, 19, 19},
                        {19, 19, 19, 15, 15, 0, 15, 15, 19, 19, 19},
                        {19, 12, 12, 12, 12, 57, 12, 12, 12, 12, 19},
                        {19, 19, 19, 19, 19, 58, 19, 19, 19, 19, 19},
                        {19, 19, 19, 30, 58, 59, 58, 30, 19, 19, 19},
                        {19, 19, 19, 19, 19, 58, 19, 19, 19, 19, 19},
                        {19, 19, 19, 19, 12, 57, 12, 19, 19, 19, 19},
                        {19, 19, 19, 19, 19, 00, 19, 19, 19, 19, 19}
                }
        };
//        for (int i = 0; i < LvMap.length; i++) {
//            for (int j = 0; j < LvMap[i].length; j++) {
//                for (int k = 0; k < LvMap[i][j].length; k++) {
//                    System.out.print(LvMap[i][j][k] + " ");
//                }
//            }
//        }
//        System.out.println(Arrays.deepToString(LvMap));
//        Properties prop = new Properties();
//        prop.load(new FileInputStream("src\\main\\resources\\config\\file1.properties"));
//        short[][][] appName = (short[][][]) prop.get("LvMap");
//        System.out.println(appName);
        save("LvMap",short3ToString(LvMap));
        System.out.println("Array has been saved to file1.properties.");

        // 从配置文件读取数组
        short[][][] newArray = stringToShort3(load("LvMap"));
        System.out.println(Arrays.deepToString(newArray));
        System.out.println(System.getProperty("user.dir"));
    }
}
