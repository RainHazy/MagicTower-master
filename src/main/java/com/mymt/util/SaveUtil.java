package com.mymt.util;

import com.mymt.MTGame;
import com.mymt.MTMain;
import com.mymt.data.MTGameData;

import java.io.*;
import java.util.Properties;

/**
 * @author ：zzf
 * @description：基础数据和存档工具类
 * @date ：2024/11/22 10:52
 */
public class SaveUtil {

    static String basePath = "data/base";
    static String savePath = "data/save/save1";
    static Properties properties = new Properties();
    static File baseFile = new File(basePath+"/file1.properties");

    //将三维数组转成字符串
    public static String short3ToString(short[][][] array) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < array.length; i++) {
            sb.append("{");
            for (int j = 0; j < array[i].length; j++) {
                sb.append("{");
                for (int k = 0; k < array[i][j].length; k++) {
                    sb.append(array[i][j][k]);
                    if (k < array[i][j].length - 1) {
                        sb.append(",");
                    }
                }
                sb.append("}");
                if (j < array[i].length - 1) {
                    sb.append(",");
                }
            }
            sb.append("}");
            if (i < array.length - 1) {
                sb.append(",");
            }
        }
        return sb.toString();
    }

    // 将字符串转换回 short[][][]
    public static short[][][] stringToShort3(String data) {
        // 解析字符串，去掉外层的括号，分解成 short[][][] 数组
        data = data.replaceAll("[{}]", ""); // 去掉所有大括号
        String[] levels = data.split("\\],\\["); // 按 "]," 分隔每一层

        short[][][] result = new short[levels.length][][];

        for (int i = 0; i < levels.length; i++) {
            String[] rows = levels[i].split("],\\[");
            result[i] = new short[rows.length][];

            for (int j = 0; j < rows.length; j++) {
                String[] values = rows[j].split(",");
                result[i][j] = new short[values.length];

                for (int k = 0; k < values.length; k++) {
                    result[i][j][k] = Short.parseShort(values[k].trim());
                }
            }
        }
        return result;
    }

    // 保存 到配置文件
    public static void save(String key, String data) throws IOException {
        Properties properties = new Properties();

        // 设置 LvMap 参数
        properties.setProperty(key, data);

        // 保存到文件 src/main/resources/config/file1.properties
        File file = new File(baseFile+"/baseData.properties");
        if (!file.exists()) {
            file.getParentFile().mkdirs(); // 创建目录
            file.createNewFile(); // 创建文件
        }

        try (FileOutputStream fos = new FileOutputStream(file)) {
            properties.store(fos, "Saved short[][][] array to properties file");
        }
    }

    // 从配置文件中读取
    public static String load(String key)  {

        try (FileInputStream fis = new FileInputStream(baseFile)) {
            properties.load(fis);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        String data = properties.getProperty(key);
        return data;
    }

    // 保存游戏状态到文件
    public static void saveGame(MTMain mtMain) {
        try (FileOutputStream fileOut = new FileOutputStream(savePath);
             ObjectOutputStream out = new ObjectOutputStream(fileOut)) {

            // 保存MTGame的静态状态
            MTGameData gameState = MTGameData.captureState();
            out.writeObject(gameState);

            // 保存MTMain实例
            out.writeObject(mtMain);
            System.out.println("游戏已保存！");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    // 从文件加载游戏状态
    public static MTMain loadGame()  {
        try (FileInputStream fileIn = new FileInputStream(savePath);
             ObjectInputStream in = new ObjectInputStream(fileIn)) {

            // 加载并应用MTGame的静态状态
            MTGameData gameState = (MTGameData) in.readObject();
            gameState.applyState();

            // 加载MTMain实例
            MTMain loadedGame = (MTMain) in.readObject();
            System.out.println("游戏已加载！");
            return loadedGame;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    public static void save(MTMain mtMain) {
        saveGame(mtMain);
    }

    public static MTMain load() {
        return loadGame();
    }
}
