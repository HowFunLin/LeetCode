package easy;

@SuppressWarnings("unused")
public class MoreThanHalfNum {
    public int moreThanHalfNum(int [] array) {
        int most = -1;
        int votes = 0;

        for (int num : array)
        {
            if (most == -1)
            {
                most = num;
                votes++;
            }
            else {
                if (most == num)
                    votes++;
                else
                    votes--;
            }

            if (votes == 0)
                most = -1;
        }

        return most;
    }
}
