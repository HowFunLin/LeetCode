package main.easy;

import struct.Employee;

import java.util.HashMap;
import java.util.List;

@SuppressWarnings("unused")
public class EmployeeImportance {
    private HashMap<Integer, Employee> map = new HashMap<>();

    public int getImportance(List<Employee> employees, int id) {
        for (Employee employee : employees)
            map.put(employee.id, employee);

        return dfs(id);
    }

    private int dfs(int id) {
        Employee employee = map.get(id);
        List<Integer> subordinates = employee.subordinates;
        int total = employee.importance;

        for (Integer subordinate : subordinates)
            total += dfs(subordinate);

        return total;
    }
}
