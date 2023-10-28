package DataStructuresAndAlgorithm.DigitCal;

public class Solution {

    // 字符串的二进制相加
    public String addBinary(String a, String b) {
        // 遍历a与b的低位相加
        int aLength = a.length();
        int bLength = b.length();
        int sum;
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        int adigit;
        int bdigit;
        for (int i = 0; i < Math.max(aLength,bLength) + 1; i++) {

            if (aLength - 1 - i >= 0 && bLength - 1 - i >= 0) {
                adigit  = a.charAt(aLength - 1 - i) - '0';
                bdigit = b.charAt(bLength - 1 - i) - '0';
                sum = adigit + bdigit + carry;
                sb.append(sum % 2);
                carry = sum/2;
                continue;
            }

            if (aLength - 1 - i >= 0) {
                sum = a.charAt(aLength - 1 - i) - '0' + carry;
                sb.append(sum % 2);
                carry = sum/2;
                continue;
            }

            if (bLength - 1 - i >= 0) {
                sum = b.charAt(bLength - 1 - i) - '0' + carry;
                sb.append(sum % 2);
                carry = sum/2;
                continue;
            }
            if (carry != 0) {
                sb.append(carry);
            }
        }
        return sb.reverse().toString();
    }

    // 将一个二进制整数翻转
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        // 枚举n，翻转
        int result = 0;
        for (int i = 0; i < 32 && n != 0 ; i++) {
            result |= (n & 1) << (31-i);
            n >>>= 1;
        }
        return result;
    }

    // 交换两个数的值
    public void reverseTwoNumber(int a, int b) {
        a = a^b;
        b = a^b;
        a = a^b;
    }
}
