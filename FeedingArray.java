/**
 * Name         : Yap Kai Herng
 * Matric. No   : A0199729A
 * 
 * This is an implementation of that does not use a stack. It passes time complexity as it is O(n).
 * The idea is a sliding window. An array of size (number of fish in pond + num hungry fish + 1) is created
 * That allows for the case that all hungry fish cannot eat any other fish. 
 * 
 * The existing fish are added into the array at index = numHungryFish. 
 * When a hungry fish is added, it consumes the smaller fish, adding to itself.
 * When a fish is consumed, the "start" moves forwards, so effectively, the eaten fish are not considered 
 * part of the array anymore. 
 * Once a fish cannot consume the next fish, it will be placed at the "start" of the array and the process
 * begins again from the new "start" of the array. 
 * 
 * This is the sliding window implementation. 
*/



import java.util.*;

public class Feeding {
    private void run() {
        Scanner sc = new Scanner(System.in);
        int numFish = sc.nextInt();
        int numHungry = sc.nextInt();
        long[] fishes = new long[numFish + numHungry + 1];
        int start = numHungry;
        int curr = start;
        int end = numFish + numHungry;
        //populate the fishes at the start
        for (int n = 0; n < numFish; n++) {
            fishes[curr] = sc.nextInt();
            curr++;
        }

        //time for hungry fishes
        for (int x = 0; x < numHungry; x++) {
            long hungry = sc.nextInt();
            long currSmallest = fishes[start];
            while (hungry > currSmallest && start < end) {
                hungry += currSmallest;
                start++;
                currSmallest = fishes[start];
            }
            start--;
            fishes[start] = hungry;
        }
        System.out.print(fishes[start]);
        start++;
       while(start <  end) {
            System.out.print(" " + fishes[start]);
            start++;
        }
        System.out.println();
    }

    public static void main(String args[]) {
        Feeding feeding = new Feeding();
        feeding.run();
    }
}
