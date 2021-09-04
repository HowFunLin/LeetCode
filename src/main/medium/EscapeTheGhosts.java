package main.medium;

@SuppressWarnings("unused")
public class EscapeTheGhosts {
    /**
     * <h3>789. 逃脱阻碍者</h3>
     * 从 [0, 0] 点开始出发，每一回合，你和阻碍者们可以同时向东，西，南，北四个方向移动，每次可以移动到距离原位置 1 个单位 的新位置。
     * 当然，也可以选择 不动 。所有动作 同时 发生。
     * 如果你可以在任何阻碍者抓住你 之前 到达目的地（阻碍者可以采取任意行动方式），则被视为逃脱成功。
     * 如果你和阻碍者同时到达了一个位置（包括目的地）都不算是逃脱成功。
     *
     * @param ghosts 地图上有一些阻碍者，以数组 ghosts 给出，第 i 个阻碍者从 ghosts[i] = [xi, yi] 出发
     * @param target 目的地 target
     * @return 只有在有可能成功逃脱时，返回 true ；否则，返回 false
     */
    public boolean escapeGhosts(int[][] ghosts, int[] target) {
        int manhattan = Math.abs(target[0]) + Math.abs(target[1]);

        // 阻碍者到终点的曼哈顿距离小于你到终点的曼哈顿距离，则无法逃脱
        // 可认为是阻碍者在终点等待你的到来，导致无法逃脱
        for (int[] ghost : ghosts)
            if (Math.abs(ghost[0] - target[0]) + Math.abs(ghost[1] - target[1]) <= manhattan)
                return false;

        return true;
    }
}
