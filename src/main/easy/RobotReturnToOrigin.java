package main.easy;

@SuppressWarnings("unused")
public class RobotReturnToOrigin {
    /**
     * 657. 机器人能否返回原点
     *
     * @param moves 移动顺序由字符串 moves 表示。字符 move[i] 表示其第 i 次移动。机器人的有效动作有 R（右），L（左），U（上）和 D（下）
     * @return 机器人在完成所有动作后是否返回原点
     */
    public boolean judgeCircle(String moves) {
        int vertical = 0, transverse = 0;

        for (int i = 0; i < moves.length(); i++) {
            char c = moves.charAt(i);

            if (c == 'U')
                vertical++;
            else if (c == 'D')
                vertical--;
            else if (c == 'R')
                transverse++;
            else
                transverse--;
        }

        return vertical == 0 && transverse == 0;
    }
}
