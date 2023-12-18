package org.example;

/**
 * @author 曾文亮
 * @version 1.0.0
 * @email wenliang_zeng416@163.com
 * @date 2023年12月18日 21:34:03
 * @packageName org.example
 * @className ${NAME}
 * @describe TODO
 */
// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    /**
     * 将字符串表示的文件大小转换为字节数
     * @param argumentSize 字符串表示的文件大小，格式为：数字+单位
     * @return 字节数
     * @throws IllegalArgumentException 字符串格式不合法时抛出异常
     */
    public static Integer convertToBytes(String argumentSize) {
        Integer byteSize;
        String unit;
        String[] parts = argumentSize.replaceAll(" ","").split("(?i)(?<=\\D)(?=\\d)|(?<=\\d)(?=\\D)");

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
            unit = parts[1].toLowerCase();

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

    public static void main(String[] args) {
        // Press Opt+Enter with your caret at the highlighted text to see how
        // IntelliJ IDEA suggests fixing it.
        System.out.println(convertToBytes("22 mb"));
    }
}
