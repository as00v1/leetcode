package com.qiaohx.others;

/**
 * 翻转算法
 */
public class Turn {


    public static void main(String[] args) {
        char[] chars = new char[]{'a','b','c','d','e','a','b','c','d','e',
                'a','b','c','d','e','a','b','c','d','e',
                'a','b','c','d','e','a','b','c','d','e',
                'a','b','c','d','e','a','b','c','d','e',
                'a','b','c','d','e','a','b','c','d','e',
                'a','b','c','d','e','a','b','c','d','e'};
//        char[] chars = new char[]{'a','b','c','d'};
        long start = System.currentTimeMillis();
//        chars = turnChars(chars,2);
        other(chars,2);
        long end = System.currentTimeMillis();
        System.out.println("耗时" + (end - start) + "ms");
//        chars = add(chars, 'e');
        outChars(chars);
    }

    private static char[] turnChars(char[] chars, int index){
        // 将chars分割成两部分
        char[] a = new char[0];
        char[] b = new char[0];
        for (int i = 0; i < chars.length; i++) {
            if (i < index)
                a = add(a, chars[i]);
            else
                b = add(b, chars[i]);
        }

        System.out.print("a = ");
        outChars(a);
        System.out.print("b = ");
        outChars(b);

        a = turn(a);
        b = turn(b);
        System.out.print("a = ");
        outChars(a);
        System.out.print("b = ");
        outChars(b);

        char[] res = new char[chars.length];
        System.arraycopy(a, 0, res, 0, a.length);
        System.out.print("res = ");
        outChars(res);
        System.arraycopy(b, 0, res, a.length, b.length);
        System.out.print("res = ");
        outChars(res);
        return turn(res);
    }

    /**
     * 数组新增
     * @param chars
     * @param c
     * @return
     */
    private static char[] add(char[] chars, char c){
        char[] copyChars = new char[chars.length + 1];
        System.arraycopy(chars, 0, copyChars, 0, chars.length);
        copyChars[copyChars.length-1] = c;
        return copyChars;
    }

    private static void outChars(char[] chars){
        for (char c: chars) {
            System.out.print(c);
        }
        System.out.println();
    }

    private static char[] turn(char[] chars){
        char[] turnChar = new char[chars.length];
        int index = 0;
        for (int i = chars.length-1; i >= 0; i--) {
            turnChar[index++] = chars[i];
        }
        return turnChar;
    }

    private static char[] other(char[] chars, int index){
        char[] tempChars = new char[index];
        System.arraycopy(chars, 0, tempChars, 0, index);
        outChars(tempChars);
        int in = 0;
        for (int i = index; i < chars.length; i++) {
            chars[in++] = chars[i];
        }
        outChars(chars);
        System.arraycopy(tempChars, 0, chars, chars.length - index, index);
        return chars;
    }
}
