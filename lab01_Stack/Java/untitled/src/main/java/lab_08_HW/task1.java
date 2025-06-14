package lab_08_HW;

import java.util.Arrays;

public class task1 {


    public static void main(String[] args) {
        int[] nums = { -1, 2, 1, -4 };
        int t = 1;
        int[] result = findClosestThree(nums, t);
        System.out.println(Arrays.toString(result));
    }
    public static int[] findClosestThree(int[] nums, int t) {
        Arrays.sort(nums); // Сортировка массива
        int n = nums.length;
        int[] result = new int[3];
        int closestSum = Integer.MAX_VALUE;

        for (int i = 0; i < n - 2; i++) {
            int left = i + 1;
            int right = n - 1;

            while (left < right) {
                int currentSum = nums[i] + nums[left] + nums[right];
                if (Math.abs(currentSum - t) < Math.abs(closestSum - t)) {
                    closestSum = currentSum;
                    result[0] = nums[i];
                    result[1] = nums[left];
                    result[2] = nums[right];
                }

                if (currentSum < t) {
                    left++;
                } else if (currentSum > t) {
                    right--;
                } else {
                    // Если сумма точно равна t, возвращаем результат
                    return result;
                }
            }
        }
        return result;
    }

}
