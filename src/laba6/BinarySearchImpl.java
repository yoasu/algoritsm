package laba6;

public class BinarySearchImpl implements BinarySearch {

    @Override
    public int findClosest(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;

        if (target <= arr[0]) {
            return arr[0];
        }
        if (target >= arr[arr.length - 1]) {
            return arr[arr.length - 1];
        }

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target) {
                return arr[mid];
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        if (Math.abs(arr[left] - target) < Math.abs(arr[right] - target)) {
            return arr[left];
        } else {
            return arr[right];
        }
    }
}