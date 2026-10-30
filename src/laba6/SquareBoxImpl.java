package laba6;

public class SquareBoxImpl implements SquareBox {

    @Override
    public long findMinBoxSize(long n, long w, long h) {
        long low = 1;

        long high = Math.max(w, h) * n;
        long ans = high;

        while (low <= high) {
            long mid = low + (high - low) / 2;


            long cols = mid / w;
            long rows = mid / h;


            boolean fits;
            if (cols > 0 && n / cols > rows) {
                fits = false;
            }


            if (cols > 0 && rows >= (n + cols - 1) / cols) {
                fits = true;
            } else {
                fits = false;
            }

            if (fits) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return ans;
    }
}