package main.medium;

import java.util.*;

public class DisplayTableOfFoodOrdersInARestaurant {
    public List<List<String>> displayTable(List<List<String>> orders) {
        LinkedList<List<String>> res = new LinkedList<>();

        //  餐桌号      餐品名  餐品数
        Map<String, Map<String, Integer>> tables = new HashMap<>();
        Set<String> foodItems = new TreeSet<>();

        for (List<String> order : orders)
        {
            String tableNumber = order.get(1);
            String foodItem = order.get(2);

            if (tables.get(tableNumber) == null)
                tables.put(tableNumber, new HashMap<>());

            Map<String, Integer> table = tables.get(tableNumber);
            table.put(foodItem, table.getOrDefault(foodItem, 0) + 1);

            if (!foodItems.contains(foodItem))
                foodItems.add(foodItem);
        }

        List<String> head = new ArrayList<>();
        head.add("Table");
        for (String foodItem : foodItems)
            head.add(foodItem);

        for (Map.Entry<String, Map<String, Integer>> entry : tables.entrySet())
        {
            List<String> row = new ArrayList<>();

            row.add(entry.getKey());
            Map<String, Integer> order = entry.getValue();

            for (int i = 1; i < head.size(); i++)
                row.add(String.valueOf(order.getOrDefault(head.get(i), 0)));

            res.add(row);
        }

        Collections.sort(res, Comparator.comparingInt(o -> Integer.valueOf(o.get(0))));
        res.offerFirst(head);

        return res;
    }
}
