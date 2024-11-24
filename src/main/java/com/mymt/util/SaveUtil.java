package com.mymt.util;

import com.mymt.MTGame;
import com.mymt.MTMain;
import com.mymt.data.MTGameData;

import java.io.*;
import java.util.*;

/**
 * @author ：zzf
 * @description：基础数据和存档工具类
 * @date ：2024/11/22 10:52
 */
public class SaveUtil {

    static String basePath = "data/base/baseData.properties";
    static String savePath = "data/save/save1";
    static Properties properties = new Properties();

    /**
     * 保存 key 和 data 到配置文件
     *
     * @param key  要保存的键
     * @param data 要保存的值
     */
    public static void save(String key, String data) {
        File configFile = new File(basePath);
        List<String> lines = new ArrayList<>();
        boolean keyExists = false;

        // 读取现有配置文件
        if (configFile.exists()) {
            try (BufferedReader reader = new BufferedReader(new FileReader(configFile))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    line = line.trim();
                    // 如果是注释或空行，直接保留
                    if (line.startsWith("#") || line.isEmpty()) {
                        lines.add(line);
                    } else {
                        // 如果是键值对，检查是否需要更新
                        String[] keyValue = line.split("=", 2);
                        if (keyValue.length == 2 && keyValue[0].trim().equals(key)) {
                            // 更新键值对
                            lines.add(key + "=" + data);
                            keyExists = true;
                        } else {
                            lines.add(line);
                        }
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        // 如果键不存在，添加到文件末尾
        if (!keyExists) {
            lines.add(key + "=" + data);
        }

        // 写入更新后的内容到配置文件
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(configFile))) {
            for (String line : lines) {
                writer.write(line);
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    // 从配置文件中读取
    public static String load(String key)  {

        try (FileInputStream fis = new FileInputStream(basePath)) {
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
