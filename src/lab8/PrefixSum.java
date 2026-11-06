package lab8;
import java.util.Scanner;

public class PrefixSum {
    public class Main {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);

            int n = sc.nextInt();

            long[] prefix = new long[n];


            for (int i = 0; i < n; i++) {
                int num = sc.nextInt();

                if (i == 0) {
                    prefix[i] = num;
                } else {
                    prefix[i] = prefix[i - 1] + num;
                }
            }


            while (sc.hasNextInt()) {
                int i = sc.nextInt();
                int j = sc.nextInt();

                long sum;

                if (i == 0) {
                    sum = prefix[j];
                } else {
                    sum = prefix[j] - prefix[i - 1];
                }

                System.out.println(sum);
            }
            sc.close();
        }
    }

}
