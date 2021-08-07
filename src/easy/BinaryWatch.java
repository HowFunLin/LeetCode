package easy;

import java.util.ArrayList;
import java.util.List;

public class BinaryWatch {
    public List<String> readBinaryWatch(int turnedOn) {
        List<String> res = new ArrayList<>();

        for (int i = 0; i < 12; i++)
        {
            String h = String.valueOf(i);

            for (int j = 0; j < 60; j++)
            {
                if (Integer.bitCount(i) + Integer.bitCount(j) == turnedOn)
                {
                    String m = String.valueOf(j);

                    if (j < 10)
                        m = "0" + m;

                    res.add(h + ":" + m);
                }
            }
        }

        return res;
    }
}
