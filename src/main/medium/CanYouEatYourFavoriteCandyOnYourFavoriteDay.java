package main.medium;

public class CanYouEatYourFavoriteCandyOnYourFavoriteDay {
    // queries[i] = [favoriteType_i, favoriteDay_i, dailyCap_i]
    public boolean[] canEat(int[] candiesCount, int[][] queries) {
        int n  = candiesCount.length;
        long[] sum = new long[n + 1];
        for (int i = 0; i < n; i++)
            sum[i + 1] = sum[i] + candiesCount[i];

        boolean[] answer = new boolean[queries.length];
        for (int i = 0; i < queries.length; i++)
        {
            int[] query = queries[i];
            int favoriteType = query[0], favoriteDay = query[1], dailyCap = query[2];

//            long minEat = favoriteDay + 1; // 最少吃的糖果
//            long maxEat = (long) (favoriteDay + 1) * dailyCap; //最多吃的糖果
//            long mustEat = favoriteType == 0 ? 1 : sum[favoriteType - 1] + 1; // 吃到favoriteType种糖果必须吃的糖果数
//            long validEat = sum[favoriteType]; // 包括favoriteType种糖果在内的前favoriteType种糖果总和（超出则无效）
//
//            answer[i] = !(minEat > validEat|| maxEat < mustEat);
            long minEat = favoriteDay + 1;
            long maxEat = minEat * dailyCap;

            if (maxEat > sum[favoriteType] && minEat <= sum[favoriteType + 1])
                answer[i] = true;
        }

        return answer;
    }
}
