package org.example.utils;

/**
 * @author 曾文亮
 * @version 1.0.0
 * @email wenliang_zeng416@163.com
 * @date 2023年12月21日 21:58:50
 * @packageName org.example.utils
 * @className ArgumentUtil
 * @describe 与参数相关的工具类
 */
public class ArgumentUtil {
    private ArgumentUtil(){

    }
    public static Integer convertToBytes(String argumentSize) {
        int byteSize;
        String[] parts = argumentSize.replace(" ","").split("(?i)(?<=\\D)(?=\\d)|(?<=\\d)(?=\\D)");

        if (parts.length == 1) {
            // 只有数字，没有单位，默认单位为Byte
            try {
                byteSize = Integer.parseInt(parts[0]);
                return byteSize;
            } catch (IllegalArgumentException e) {
                throw new IllegalArgumentException("Invalid argument " + parts[0]);
            }
        } else if (parts.length == 2) {
            byteSize = Integer.parseInt(parts[0]);
            String unit = parts[1].toLowerCase();

            switch (unit) {
                case "b":
                case "byte":
                    return byteSize;
                case "k":
                case "kb":
                    return byteSize * 1024;
                case "m":
                case "mb":
                    return byteSize * 1024 * 1024;
                case "g":
                case "gb":
                    return byteSize * 1024 * 1024 * 1024;
                default:
                    throw new IllegalArgumentException("Invalid unit: " + unit);
            }
        } else {
            throw new IllegalArgumentException("Invalid file size format: " + argumentSize);
        }
    }

}
