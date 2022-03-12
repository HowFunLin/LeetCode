package main.medium;

import java.util.*;

/**
 * 380. O(1) 时间插入、删除和获取随机元素
 */
@SuppressWarnings("unused")
public class RandomizedSet {
    private Map<Integer, Integer> elementToIndex;
    private List<Integer> list;
    private Random random = new Random();

    /**
     * 初始化 RandomizedSet 对象
     */
    public RandomizedSet() {
        elementToIndex = new HashMap<>();
        list = new ArrayList<>();
    }

    /**
     * 当元素 val 不存在时，向集合中插入该项
     *
     * @param val 元素
     * @return 插入是否成功
     */
    public boolean insert(int val) {
        if (elementToIndex.containsKey(val))
            return false;

        elementToIndex.put(val, list.size());
        list.add(val);

        return true;
    }

    /**
     * 当元素 val 存在时，从集合中移除该项
     *
     * @param val 元素
     * @return 删除是否成功
     */
    public boolean remove(int val) {
        if (!elementToIndex.containsKey(val))
            return false;

        // 将删除元素与 List 最后一个元素交换，无需更改大量索引位置
        int lastIndex = list.size() - 1;
        Integer lastElement = list.get(lastIndex);
        Integer index = elementToIndex.get(val);

        // 更新最后一个元素的索引为删除元素的索引
        elementToIndex.put(lastElement, index);
        list.set(index, lastElement);

        // 执行真正的删除逻辑
        elementToIndex.remove(val);
        list.remove(lastIndex);

        return true;
    }

    /**
     * 随机返回现有集合中的一项，每个元素应该有 相同的概率 被返回
     *
     * @return 现有集合中的一项
     */
    public int getRandom() {
        return list.get(random.nextInt(list.size()));
    }
}
