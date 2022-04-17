package zalando;

import java.util.LinkedList;
import java.util.List;

public class Test {

    public int solution(int[] A) {
        // write your code in Java SE 8
        if (A == null)
            throw new NullPointerException();

        // create list of pairs with equal sum
        List<Pair> pairs = new LinkedList<>();
        for (int i = 0; i < A.length; i++) {
            int left = A[i];
            int sumLeft = SumOfDigits(left);
            for (int j = 0; j < A.length; j++) {
                if (i == j) {
                    continue;
                }
                int right = A[j];
                int sumRight = SumOfDigits(right);
                if (sumLeft == sumRight) {
                    Pair p = new Pair(left, right);
                    pairs.add(p);
                }
            }
        }

        if (pairs.size() == 0) {
            return -1;
        }

        int maxSum = 0;
        for (Pair pair : pairs) {
            int curSum = pair.l + pair.r;
            if (curSum > maxSum) {
                maxSum = curSum;
            }
        }
        return maxSum;
    }

    private int SumOfDigits(int num) {
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num = num / 10;
        }
        return sum;
    }

    public class Pair {
        int l;
        int r;

        public Pair(int l, int r) {
            this.l = l;
            this.r = r;
        }
    }

    public static void main(String[] args) {

        Test t = new Test();
        int[] tst = {51,32,43};

        System.out.println(t.solution(tst));
    }
}
