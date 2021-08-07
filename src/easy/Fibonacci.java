package easy;

@SuppressWarnings("unused")
public class Fibonacci {
    public int fibonacci(int n)
    {
        int first = 0, second = 1;

        for (int i = 2; i <= n; i++)
        {
            int temp = second;
            second += first;
            first = temp;
        }

        return n == 0 ? first : second;
    }
}
