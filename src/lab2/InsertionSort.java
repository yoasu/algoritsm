package lab2;
import java.util.List;
public class InsertionSort implements Sorting<Integer> {
    @Override
    public void sort(List<Integer> nums) {


        for (int i = 1; i < nums.size(); i++) {
            int  s = nums.get(i);
            int j;

            for (j = i - 1; j >= 0; j--) {
                int left = nums.get(j);
                if (s < left) {
                    nums.set(j + 1, left);
                } else break;
            }
            nums.set(j + 1, s);
        }
    }
}