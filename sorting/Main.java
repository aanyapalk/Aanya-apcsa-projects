package sorting;

import java.util.Random;

public class Main {
    public static void main(String[] args)
    {
        // Task:
        // 1. Implement missing sorting algorithms.
        //    - InsertionSort.java
        //    - SelectionSort.java
        //
        //  2. Add a method to class Main to generate a random array.
        //  3. Provide random input to test suite and ensure your implementations
        //     of InsertionSort and Selection sort continue to work.
        //  4. Increase the loop count for TestSuite to get better performance results.

        int[] testInput = randomArray(800);

        // Increase the loop count to get better results once it works.
        // TestSuite.run(testInput, 10000);
        TestSuite.run(testInput, 10000);
    }
        /**
     * Generates a random integer array of the specified length.
     * Values range from 0 to 99.
     *
     * @param length Length of the array
     * @return Random integer array
     */
    public static int[] randomArray(int length) {
        Random rand = new Random(); // replaced placeholder**
        int[] a = new int[length]; // replaced hard-coded array**

        for (int i = 0; i < length; i++) { // replaced placeholder**
            a[i] = rand.nextInt(100); // random numbers 0-99**
        }

        return a;
    }
}
