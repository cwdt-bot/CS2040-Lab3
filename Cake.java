/**
 * Name         : Yap Kai Herng
 * Matric. No   : A0199729A
*/

import java.util.*;

public class Cake{
    private void run() {
        Scanner sc = new Scanner(System.in);
        int cols = sc.nextInt();
        long maxArea = 0;
        Stack<Integer> idx = new Stack<>();
        int[] heights = new int[cols+1];
        heights[cols] = 0;
        
        //populate the array
        for (int x = 0; x < cols; x++) {
            heights[x] = sc.nextInt();
        }
        //force a zero to trigger calculations
        int n = 0;
        while(n < cols + 1) {
            if (idx.isEmpty()) {
                idx.push(n);
                n++;
                continue;
            }
            int currTopIdx = idx.peek();
            if(heights[currTopIdx] <= heights[n]) {
                idx.push(n);
                n++;
            } else {
                idx.pop();
                int currHeight = heights[currTopIdx];
                long currArea;
                if (idx.isEmpty()) {
                    currArea = (long)currHeight * (long)n; 
                } else {
                    currArea = (long)currHeight * (n - idx.peek() -1);
                }
                maxArea = Math.max(currArea, maxArea);
            }
        }
        System.out.println(maxArea);
        sc.close();
    }

    public static void main(String args[]) {
        Cake cake = new Cake();
        cake.run();
    }
}
