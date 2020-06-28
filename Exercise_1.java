package test;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;



class Solution_ {

    /*
     * Complete the 'minimumMoves' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY a
     *  2. INTEGER_ARRAY m
     */

    public static int minimumMoves(List<Integer> a, List<Integer> m) {
      
      int moves = 0;

        for (int i =0; i < a.size(); i++){
            int number = a.get(i);
            int target = m.get(i);

            while (number > 0) {
                int aInt = number %10;
                int mInt = target %10;
                int move = Math.abs(aInt - mInt);
                moves += move;
                number /= 10;
                target /= 10;
            }

        }
        return moves;
    }

}

public class Exercise_1 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int aCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> a = new ArrayList<>();

        for (int i = 0; i < aCount; i++) {
            int aItem = Integer.parseInt(bufferedReader.readLine().trim());
            a.add(aItem);
        }

        int mCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> m = new ArrayList<>();

        for (int i = 0; i < mCount; i++) {
            int mItem = Integer.parseInt(bufferedReader.readLine().trim());
            m.add(mItem);
        }

        int result = Solution_.minimumMoves(a, m);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
