package easy;

public class LatestTimeByReplacingHiddenDigits {
    public String maximumTime(String time) {
        char[] time_char = time.toCharArray();
        char h_ten = time_char[0];
        char h_one = time_char[1];

        if (h_one == '?' && h_ten == '?')
        {
            time_char[0] = '2';
            time_char[1] = '3';
        }
        else if (h_ten == '?' && h_one - 51 > 0)
            h_ten = time_char[0] = '1';
        else if (h_ten == '?' && h_one - 51 <= 0)
            h_ten = time_char[0] = '2';

        if ((h_ten == '1' || h_ten == '0') && h_one == '?')
            time_char[1] = '9';
        else if (h_ten == '2' && h_one == '?')
            time_char[1] = '3';

        if (time_char[3] == '?')
            time_char[3] = '5';

        if (time_char[4] == '?')
            time_char[4] = '9';

        return new String(time_char);
    }
}
