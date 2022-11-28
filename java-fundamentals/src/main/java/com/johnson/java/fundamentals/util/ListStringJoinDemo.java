package com.johnson.java.fundamentals.util;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 将 List<String> 转换为使用某个符号连接的字符串 Demo.
 * <p>
 * 在日常开发工作中，经常会遇到需要将 List<String> 转换为使用某个符号连接的字符串。
 * 如将 List<String> 转换为按英文逗号（,）分隔的字符串：
 * <code>
 *     List<String> weekList = Arrays.asList(
 *                 "Monday",
 *                 "Tuesday",
 *                 "Wednesday",
 *                 "Thursday",
 *                 "Friday",
 *                 "Saturday",
 *                 "Sunday"
 *         );
 * // 将 weekList 输出转换为按英文逗号（,）分隔的字符串：
 * // Monday,Tuesday,Wednesday,Thursday,Friday,Saturday,Sunday
 * </code>
 * <p>
 * 最容易想到的拼接方式，是通过 for 循环来实现。
 * 不过，如果你使用 Java 8 或以上的版本进行开发，实现该功能将变得非常简单，有以下两种方法：
 * - 使用 String.join
 * - 采用流的方式（stream()）
 *
 * @author johnson lin
 * @date 2020/6/29 21:40
 */
public class ListStringJoinDemo {
    public static void main(String[] args) {
        List<String> weekList = Arrays.asList(
                "Monday",
                "Tuesday",
                "Wednesday",
                "Thursday",
                "Friday",
                "Saturday",
                "Sunday"
        );

        String result = "";

        // 使用 String.join
        result = String.join(",", weekList);
        System.out.println(result);

        // 使用流的方式 stream()
        result = weekList.stream().collect(Collectors.joining(","));
        System.out.println(result);

        // 使用流的方式 stream()，先将元素转为大写，再连接成字符串：
        result = weekList.stream().map(String::toUpperCase).collect(Collectors.joining(","));
        System.out.println(result);
    }
}
/*
此代码示例执行结果如下：

Monday,Tuesday,Wednesday,Thursday,Friday,Saturday,Sunday
Monday,Tuesday,Wednesday,Thursday,Friday,Saturday,Sunday
MONDAY,TUESDAY,WEDNESDAY,THURSDAY,FRIDAY,SATURDAY,SUNDAY
*/