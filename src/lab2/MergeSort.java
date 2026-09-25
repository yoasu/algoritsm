package lab2;
import java.util.ArrayList;
import java.util.List;


public class MergeSort implements Sorting<Integer>{

        private void slice(List<Integer> nums, int start, int end) {
            // 0 и 1 элемент, то отсортирован
            if (start >= end) {
                return;
            }

            // середина
            int mid = start + (end - start) / 2;

            // сортируем левую
            slice(nums, start, mid);
            // сортируем правую
            slice(nums, mid + 1, end);

            // объяденяем
            merge(nums, start, mid, end);
        }

        private void merge(List<Integer> nums, int start, int middle, int end) {


            List<Integer> s = new ArrayList<>();

            int leftV = start;
            int rightV = middle + 1;

            while (leftV <= middle && rightV <= end) {

                // ищем меньший элемент
                if (nums.get(leftV) <= nums.get(rightV)) {
                    s.add(nums.get(leftV));
                    leftV++;
                } else {
                    s.add(nums.get(rightV));
                    rightV++;
                }
            }

            // левая часть
            while (leftV<= middle) {
                s.add(nums.get(leftV));
                leftV++;
            }

            // правая чачть
            while (rightV <= end) {
                s.add(nums.get(rightV));
                rightV++;
            }
            // список перезаписывается, теперь тут остортированые значения
            for (int i = 0; i < s.size(); i++) {
                nums.set(start + i, s.get(i));
            }
        }

        @Override
        public void sort(List<Integer> nums) {
            slice(nums, 0, nums.size() - 1);
        }


}