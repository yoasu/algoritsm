package lab8;
import java.util.Scanner;

    public class SegmentTreeMin {

        static int[] tree;
        static int size;

        public static void build(int[] arr, int n) {
            size = 1;

            while (size < n) {
                size *= 2;
            }
            tree = new int[2 * size];

            for (int i = 0; i < 2 * size; i++) {
                tree[i] = Integer.MAX_VALUE;
            }


            for (int i = 0; i < n; i++) {
                tree[size + i] = arr[i];
            }

            for (int i = size - 1; i > 0; i--) {
                tree[i] = Math.min(tree[2 * i], tree[2 * i + 1]);
            }
        }
        public static int query(int left, int right) {
            left += size;
            right += size;
            int min = Integer.MAX_VALUE;

            while (left < right) {

                if (left % 2 == 1) {
                    min = Math.min(min, tree[left]);
                    left++;
                }

                if (right % 2 == 1) {
                    right--;
                    min = Math.min(min, tree[right]);
                }

                left /= 2;
                right /= 2;
            }

            return min;
        }


}
