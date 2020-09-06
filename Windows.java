/**
 * Name         : Yap Kai Herng
 * Matric. No   : A0199729A
*/

import java.util.*;

public class Windows {
    private void run() {
        Scanner sc = new Scanner(System.in);
        int length = sc.nextInt();
        int windLen = sc.nextInt();
        int[] numbers = new int[length];
        for (int n = 0; n < length; n++) {
            numbers[n] = sc.nextInt();
        }
        int endPoint = windLen - 1;
        int startPoint = 0;
        int distance;
        while (endPoint < length) {
            while (startPoint <= endPoint) {
                if (numbers[startPoint] % 2 != 0) {
                    System.out.print((startPoint+1));
                    break;
                } else if (startPoint == endPoint) {
                    System.out.print("-1");
                    startPoint++;
                    break;
                } else startPoint++ ;
            }
            endPoint++;
            if (endPoint != length) System.out.print(" ");
            if (endPoint - startPoint > windLen -1) startPoint++;
        }
        System.out.println();
    }

    public static void main(String args[]) {
        Windows windows = new Windows();
        windows.run();
    }
}
