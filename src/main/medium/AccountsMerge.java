package main.medium;

import java.util.*;

public class AccountsMerge {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String, Integer> emailToIndex = new HashMap<>();
        Map<String, String> emailToName = new HashMap<>();
        int emailsCount = 0;

        for (List<String> account : accounts) {
            String name = account.get(0);
            int size = account.size();

            for (int i = 1; i < size; i++) {
                String email = account.get(i);

                if (!emailToIndex.containsKey(email)) {
                    emailToIndex.put(email, emailsCount++);
                    emailToName.put(email, name);
                }
            }
        }

        UnionFind uf = new UnionFind(emailsCount);

        for (List<String> account : accounts) {
            String firstEmail = account.get(1);
            int firstIndex = emailToIndex.get(firstEmail);
            int size = account.size();

            for (int i = 2; i < size; i++) {
                String nextEmail = account.get(i);
                int nextIndex = emailToIndex.get(nextEmail);

                uf.union(firstIndex, nextIndex);
            }
        }

        Map<Integer, List<String>> indexToEmails = new HashMap<>();

        for (String email : emailToIndex.keySet()) {
            int index = uf.find(emailToIndex.get(email));
            List<String> account = indexToEmails.getOrDefault(index, new ArrayList<>());

            account.add(email);
            indexToEmails.put(index, account);
        }

        List<List<String>> merged = new ArrayList<>();

        for (List<String> emails : indexToEmails.values()) {
            Collections.sort(emails);
            String name = emailToName.get(emails.get(0));
            List<String> account = new ArrayList<>();
            account.add(name);
            account.addAll(emails);
            merged.add(account);
        }

        return merged;
    }

    private class UnionFind {
        int[] parent;

        UnionFind(int n) {
            parent = new int[n];

            for (int i = 0; i < n; i++)
                parent[i] = i;
        }

        void union(int index1, int index2) {
            parent[find(index2)] = find(index1);
        }

        int find(int index) {
            if (parent[index] != index)
                parent[index] = find(parent[index]);

            return parent[index];
        }
    }
}