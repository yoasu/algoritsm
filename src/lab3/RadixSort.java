package lab3;
import lab2.Sorting;
import java.math.BigInteger;
import java.util.List;

public class RadixSort implements Sorting<BigInteger> {
    @Override
    public void sort(List<BigInteger> nums) {
        if (nums.size() < 2) {
            return;
        }

        int maxLength = 0;

        for (BigInteger num : nums) {
            maxLength = Math.max(maxLength, num.toString().length());
        }

        for (int pos = 0; pos < maxLength; pos++) {
            int[] count = new int[10];

            for (BigInteger num : nums) {
                String s = num.toString();
                int index = s.length() - pos - 1;
                int digit;

                if (index >= 0) {
                    digit = s.charAt(index) - '0';
                } else {
                    digit = 0;
                }
                count[digit]++;
            }

            for (int i = 1; i < 10; i++) {
                count[i] += count[i - 1];
            }

            BigInteger[] result = new BigInteger[nums.size()];

            for (int i = nums.size() - 1; i >= 0; i--) {
                String s = nums.get(i).toString();
                int index = s.length() - pos - 1;
                int digit;

                if (index >= 0) {
                    digit = s.charAt(index) - '0';
                } else {
                    digit = 0;
                }

                result[--count[digit]] = nums.get(i);
            }

            for (int i = 0; i < nums.size(); i++) {
                nums.set(i, result[i]);
            }
        }
    }
}
