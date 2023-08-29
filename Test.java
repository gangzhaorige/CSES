import java.util.Arrays;
import java.util.Scanner;

/**
 * test
 */
public class Test {

    public static double[] addPercentage(int[] nums, int percentage) {
        double percent = percentage / 100.0;
        double[] res = new double[nums.length];
        for(int i = 0; i < nums.length; i++) {
            int num = nums[i];
            res[i] = percent * num + num + 1;
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String allNums = sc.nextLine();
        String[] stringNums = allNums.split("\\s+");
        int[] intArray = new int[stringNums.length]; 
        for(int i = 0; i < stringNums.length; i++) {
            intArray[i] = Integer.parseInt(stringNums[i]);
        }
        double[] res = addPercentage(intArray, 150);
        for(int i = 0; i < res.length; i++) {
            System.out.println(intArray[i] + " = " + res[i]);
        }
        sc.close();
    }


}