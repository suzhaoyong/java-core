package Chapter03;

import java.util.Arrays;

public class ArrayExample {
    public static void main(String args[]) {

        System.out.println("---- Home start ----");
        //TODO 初始化数组并输出
        //int类型数组 默认值为0
        int[] a = new int[10];
        for (int i = 0; i < a.length; i ++) {
            a[i] = i;
        }
        for (int i = 0; i < a.length; i ++) {
            if (i == a.length - 1) {
                System.out.print(a[i]);
                continue;
            }
            System.out.print(a[i] + ",");
        }
        System.out.println();
        //TODO String数组
        //String类型数组 默认值为null
        String[] names = new String[10];
        for (int i = 0; i < names.length; i ++) {
            names[i] = "";
        }
        //TODO foreach 示例
        for (String name: names) {
            System.out.print(name + ",");
        }
        System.out.println();
        //TODO Arrays.toString() 方法
        //Arrays.toString()
        System.out.print(Arrays.toString(a));
        System.out.println();
        //TODO 数组初始化以及匿名数组
        String[] size = {"M", "S", "L", "XL"};
        System.out.println(Arrays.toString(size));
        System.out.println(Arrays.toString(new String[] {"M", "S", "L"}));

        //TODO 数组拷贝
        /*
            copySize 和 size 变量都引用同一个数组
         */
        String[] copySize = size;
        System.out.println(Arrays.toString(copySize));
        /*
            copyValueSize 和 size 变量引用不同的数组
            copyValueSize 扩容了 size 多余的元素会被赋值默认值
         */
        String[] copyValueSize = Arrays.copyOf(size, size.length * 2);
        System.out.println(Arrays.toString(copyValueSize));
        //TODO 数组排序
        /*
            Arrays.sort();
         */
        lotteryDrawing();

        //TODO 多维数组
        int[][] point = {
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };
//        point = new int[3][3];

        for (int[] row: point) {
            for(int col: row) {
                System.out.print(col + " ");
            }
            System.out.println();
        }
        /*
            快速打印多维数组 Arrays.deepToString()
         */

        System.out.println(Arrays.deepToString(point));

        lotteryArray();


    }
    public static void lotteryDrawing() {
        int[] ball = new int[49];
        int[] result = new int[6];
        for(int i = 0; i < ball.length; i ++) {
//            ball[i] = (int) Math.floor(Math.random() * 6);
            ball[i] = i + 1;
        }
        for(int i = 0; i < result.length; i ++) {
             int curPos = (int) Math.floor(Math.random() * 49);
            result[i] = ball[curPos];
            ball[curPos] = ball[6 - i];
        }
        Arrays.sort(result);
        for (int r: result) {
            System.out.print(r + " ");
        }
        System.out.println();
    }
    public static void lotteryArray() {
        final int MAX_ROW = 6;
        final int MAX_COL = 6;
        int[][] tree = new int[MAX_ROW][];
        for(int i = 0; i < tree.length; i ++) {
            tree[i] = new int[i + 1];
            for (int j = 0; j <= i; j ++) {
                if (j == 0 || j == i) {
                    tree[i][j] = 1;
                } else {
                    tree[i][j] = tree[i-1][j-1] + tree[i-1][j];
                }
            }
        }
        for(int[] row: tree) {
            for(int col: row) {
                System.out.print(col + " ");
            }
            System.out.println();
        }
    }
}
