/**
 * Name         : Yap Kai Herng
 * Matric. No   : A0199729A
*/

import java.util.*;

public class Feeding {
    //pre-cond: number of fish and hungry fish <= 10^5, 1 <= size of fish <= 10^9, 
    //fish initially in pond are sorted ascendingly. 
    //post-cond: size of the fishes left in the pond printed to console 
    private void run() {
        Scanner sc = new Scanner(System.in);
        int numFish = sc.nextInt();
        int numHungry = sc.nextInt();
        Stack<Long> temp = new Stack<>();
        
        //populate a temporary stack 
        for(int n = 0; n < numFish; n++) {
            temp.push(sc.nextLong());
        }

        /* put all the fish in the temp stack into a new one
        this reverses the order, meaning the smallest fish is 
        on top */
        Stack<Long> fishes = new Stack<>();
        while(!temp.isEmpty()) {
            fishes.push(temp.pop());
        }

        /* Hungry Fish 'eating' another fish is represented by 
        popping the fish on top of the stack (guaranteed to be smallest)
        When no more fish can be eaten, the hungry fish is the smallest and 
        is put on the top of the stack
        */
        for(int x = 0; x < numHungry; x++) {
            long curr = sc.nextLong();
            while(!fishes.isEmpty()) {
                if (curr > fishes.peek()) {
                    curr += fishes.pop();
                } else { break; }
            }
            fishes.push(curr);
        }

        //print all the fishes in the stack
        while(!fishes.isEmpty()) {
            System.out.print(fishes.pop());
            if (!fishes.isEmpty()) {
                System.out.print(" ");
            }
        }
        System.out.println();
        sc.close();
    }

    public static void main(String args[]) {
        Feeding feeding = new Feeding();
        feeding.run();
    }
}
