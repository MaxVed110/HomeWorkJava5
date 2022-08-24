import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TwoArrays {
    public static void main(String[] args) {
        int[] arr1 = new int[]{1, 2, 5, 7, 4, 4, 1};
        int[] arr2 = new int[]{1, 3, 5, 7, 8, 4, 1};
        int[] res = collies(arr1, arr2);
        for (int item : res) {
            System.out.print(item + " ");
        }
    }

    public static int[] collies(int[] nums1, int[] nums2) {
        Map<Integer, Integer> numbersMap = new HashMap<>();
        List<Integer> buf = new ArrayList<>();
        for (int item : nums1) {
            numbersMap.putIfAbsent(item, 0);
            numbersMap.put(item, numbersMap.get(item) + 1);
        }
        for (int number : nums2) {
            if (numbersMap.containsKey(number) && numbersMap.get(number) > 0) {
                buf.add(number);
                numbersMap.put(number, numbersMap.get(number) - 1);
            }
        }
        int[] result = new int[buf.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = buf.get(i);
        }
        return result;
    }
}
