package main.medium;

import java.util.*;

public class ThroneInheritance {
//    private HashMap<String, String> sonToFather = new HashMap<>();
//    private HashMap<String, LinkedList<String>> fatherToSons = new HashMap<>();
//    private List<String> death = new ArrayList<>();
//    private String kingName;
//
//    public ThroneInheritance(String kingName) {
//        this.kingName = kingName;
//        sonToFather.put(kingName, null);
//        fatherToSons.put(kingName, new LinkedList<>());
//    }
//
//    public void birth(String parentName, String childName) {
//        sonToFather.put(childName, parentName);
//        fatherToSons.get(parentName).offerLast(childName);
//        fatherToSons.put(childName, new LinkedList<>());
//    }
//
//    public void death(String name) {
////        fatherToSons.get(sonToFather.get(name)).remove(name);
////        sonToFather.remove(name);
//        death.add(name);
//    }
//
//    public List<String> getInheritanceOrder() {
//        List<String> res = new ArrayList<>();
//        Set<String> curOrder = new HashSet<>();
//
//        for (String name : sonToFather.keySet())
//        {
//            if (successor(name, curOrder) != null)
//                res.add(successor(name, curOrder));
//        }
//
//        for (String name : death)
//            res.remove(name);
//
//        return res;
//    }
//
//    private String successor(String name, Set<String> curOrder) {
//        LinkedList<String> sons = fatherToSons.get(name);
//
//        if (sons.size() == 0) {
//            if (name == kingName)
//                return null;
//            else
//                successor(sonToFather.get(name), curOrder);
//        }
//
//        return sons.pollFirst();
//    }

    private Map<String, List<String>> edges;
    private Set<String> dead;
    private String king;

    public ThroneInheritance(String kingName) {
        edges = new HashMap<>();
        dead = new HashSet<>();
        king = kingName;
    }

    public void birth(String parentName, String childName) {
        List<String> children = edges.getOrDefault(parentName, new ArrayList<>());
        children.add(childName);
        edges.put(parentName, children);
    }

    public void death(String name) {
        dead.add(name);
    }

    public List<String> getInheritanceOrder() {
        List<String> ans = new ArrayList<>();
        preorder(ans, king);
        return ans;
    }

    private void preorder(List<String> ans, String name) {
        if (!dead.contains(name)) {
            ans.add(name);
        }
        List<String> children = edges.getOrDefault(name, new ArrayList<>());
        for (String childName : children) {
            preorder(ans, childName);
        }
    }
}
