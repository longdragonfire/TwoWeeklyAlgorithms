package org.crc.hw.code;

import java.util.Scanner;

/**
 * 002 【N进制减法】
 * 实现一个基于字符串的N机制的减法。
 * 需要对输入的两个字符串按照给定的N进制进行减法操作，输出正负符号和表示结果的字符串。
 * 输入描述:
 * 输入：三个参数。
 * 第一个参数是整数形式的进制N值，N值范围为大于等于2、小于等于35。
 * 第二个参数为被减数字符串；
 * 第三个参数为减数字符串。有效的字符包括09以及小写字母az，字符串有效字符个数最大为100个字符，另外还有结尾的\0。
 * 限制：
 * 输入的被减数和减数，除了单独的0以外，不能是以0开头的字符串。
 * 如果输入有异常或计算过程中有异常，此时应当输出-1表示错误。
 * 输出描述:
 * 输出：2个。
 * 其一为减法计算的结果，-1表示出错，0表示结果为整数，1表示结果为负数。
 * 其二为表示结果的字符串。
 * 示例1:
 * 输入
 * 2 11 1
 * 输出
 * 0 10
 * 说明
 * 按二进制计算 11 -1 ，计算正常，0表示符号为正数，结果为10
 * 示例2:
 * 输入
 * 8 07 1
 * 输出
 * -1
 * 说明
 * 按8进制，检查到减数不符合非0前导的要求，返回结果为-1，没有其他结果内容。
 */
public class ZT02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //输入条件
        System.out.println("输入：");
        String input = sc.nextLine();
        String[] s = input.split(" ");
        //进制
        int binary = Integer.parseInt(s[0]);
        //被减数
        String minuend = s[1];
        //减数
        String subtrahend = s[2];
        //减法计算的结果，-1表示出错，0表示结果为整数，1表示结果为负数。
        int symbol = 0;
        if(minuend.length() > 0 && minuend.startsWith("0") || subtrahend.length() > 0 && subtrahend.startsWith("0")){
            symbol = -1;
            System.out.println("输出：\r\n" +symbol);
        }else {
            //转换
            int minuend_int = Integer.parseInt(minuend, binary);
            int subtrahend_int = Integer.parseInt(subtrahend, binary);
            int result = minuend_int - subtrahend_int;
            String final_result = Integer.toString(result, binary);
            symbol = result >= 0 ? 0 : 1;
            System.out.println("输出：\r\n" + symbol + " " + final_result);
        }
    }
}
