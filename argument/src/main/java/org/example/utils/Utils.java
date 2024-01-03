package org.example.utils;

public class Utils {

    /**
     * 将字符串表示的文件大小转换为字节数
     * @param argumentSize 字符串表示的文件大小，格式为：数字+单位
     * @return 字节数
     * @throws IllegalArgumentException 字符串格式不合法时抛出异常
     */
    public static Integer convertToBytes(String argumentSize) {
        int byteSize;
        String[] parts = argumentSize.replace(" ", "").split("(?i)(?<=\\D)(?=\\d)|(?<=\\d)(?=\\D)");

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
                    return multiplyWithOverflowCheck(byteSize);
                case "k":
                case "kb":
                    return multiplyWithOverflowCheck(byteSize, 1024);
                case "m":
                case "mb":
                    return multiplyWithOverflowCheck(byteSize, 1024, 1024);
                case "g":
                case "gb":
                    return multiplyWithOverflowCheck(byteSize, 1024, 1024, 1024);
                default:
                    throw new IllegalArgumentException("Invalid unit: " + unit);
            }
        } else {
            throw new IllegalArgumentException("Invalid file size format: " + argumentSize);
        }
    }

    /**
     * 判断是否发生整数溢出
     *
     * @param numbers
     * @return
     */
    public static int multiplyWithOverflowCheck(int... numbers) {
        int result = 1;
        for (int number : numbers) {
            if (number > 0 && Integer.MAX_VALUE / number < result) {
                throw new IllegalArgumentException("Integer overflow");
            }
            if (number < 0 && Integer.MIN_VALUE / number > result) {
                throw new IllegalArgumentException("Integer overflow");
            }
            result *= number;
        }
        return result;
    }

}
