

public class ExamScoreBand {
    static int countInBand(int[] scores, int low, int high) {
        int left = lowerBound(scores, low);
        int right = lowerBound(scores, high + 1);
        return right - left;
    }

    static int lowerBound(int[] a, int target) {
        int left = 0, right = a.length;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (a[mid] < target)
                left = mid + 1;
            else
                right = mid;
        }

        return left;
    }

    public static void main(String[] args) {
        int[] scores = {35, 42, 42, 50, 58, 58, 58, 63, 71, 88};

        System.out.println(countInBand(scores, 42, 58));
        System.out.println(countInBand(scores, 90, 100));
    }
}
