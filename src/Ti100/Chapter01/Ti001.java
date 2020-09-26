package Ti100.Chapter01;
public class Ti001 {
    /**
     * @// TODO: 2020/9/26 打印金字图案
     */
    public static void main(String[] args) {
        print();
    }
    static void print() {
        String[][] star = {
                {"★"},
                {"★","★"},
                {"★","★", "★"},
                {"★","★", "★", "★"},
                {"★","★", "★", "★", "★"}
        };
        for (int i = 0; i < star.length; i++) {
            for(int k = star.length - i - 1 ; k > 0; k --) {
                System.out.print(" ");
            }
            for (int j = 0; j < star[i].length; j++) {
                System.out.print(star[i][j]);
            }
            System.out.println();
        }
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < star.length/2 + (star.length % 2); j++) {
                System.out.print(" ");
            }
            System.out.println("|");
        }
    }
}