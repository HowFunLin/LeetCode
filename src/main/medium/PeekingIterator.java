package main.medium;

import java.util.Iterator;

/**
 * 284. 窥探迭代器
 */
@SuppressWarnings("unused")
class PeekingIterator implements Iterator<Integer> {
    private Iterator<Integer> iterator;
    private Integer next; // 缓存下一个元素的值

    /**
     * Initialize any member here.
     *
     * @param iterator 原生迭代器
     */
    public PeekingIterator(Iterator<Integer> iterator) {
        this.iterator = iterator;
        next = iterator.next();
    }

    /**
     * Returns the next element in the iteration without advancing the iterator.
     *
     * @return 下一个元素
     */
    public Integer peek() {
        return next;
    }

    /**
     * hasNext() and next() should behave the same as in the Iterator interface.
     * Override them if needed.
     *
     * @return 下一个元素，并将指针移动到下个元素处
     */
    @Override
    public Integer next() {
        Integer next = this.next;
        this.next = iterator.hasNext() ? iterator.next() : null;
        return next;
    }

    /**
     * @return 如果存在下一个元素，返回 true ；否则，返回 false
     */
    @Override
    public boolean hasNext() {
        return next != null;
    }
}
