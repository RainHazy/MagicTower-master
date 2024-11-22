package com.mymt.util;

import java.io.*;
import java.util.Properties;

/**
 * @author ：zzf
 * @description：配置文件工具类
 * @date ：2024/11/22 10:52
 */
public class SaveUtil {

    static String filePath = "src/main/resources/config";

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
        File file = new File(filePath+"/file1.properties");
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
        Properties properties = new Properties();
        File file = new File(filePath+"/file1.properties");

        try (FileInputStream fis = new FileInputStream(file)) {
            properties.load(fis);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        String data = properties.getProperty("LvMap");
        return data;
    }

    // 保存对象到文件
    public static void saveObject(Object obj) throws IOException {
        try (FileOutputStream fileOut = new FileOutputStream(filePath);
             ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
            out.writeObject(obj);
        }
    }

    // 从文件读取对象
    public static Object loadObject() throws IOException, ClassNotFoundException {
        try (FileInputStream fileIn = new FileInputStream(filePath);
             ObjectInputStream in = new ObjectInputStream(fileIn)) {
            return in.readObject();
        }
    }
}
