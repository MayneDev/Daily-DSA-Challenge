package src.com.daily.dsa.challenge.leetcode;

import java.util.*;

public class CourseSchedule {

    public boolean canFinish(int numCourses, int[][] prerequisites) {

        //Check if there is a link from 0 -> n

        //Create adjacency map
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 0; i < prerequisites.length; i++) {
            int key = prerequisites[i][0];
            int val = prerequisites[i][1];

            List<Integer> neighbours = new ArrayList<>();

            if (graph.containsKey(key)) {
                neighbours = graph.get(key);
            }
            neighbours.add(val);
            graph.put(key, neighbours);
        }

        for (int x = 0; x <= numCourses - 1; x++) {
            if (!traverse(graph, new HashSet<>(), x)) {
                return false;
            }
        }
        return true;
    }

    private boolean traverse(Map<Integer, List<Integer>> graph, Set<Integer> visited, int key) {
        if (visited.contains(key)) {
            return false;
        }

        if (!graph.containsKey(key) || graph.get(key).size() == 0) {
            return true;
        }

        visited.add(key);
        for (int x : graph.get(key)) {
            if (!traverse(graph, visited, x)) {
                return false;
            }
        }

        visited.remove(key);
        graph.put(key, new ArrayList<>());

        return true;
    }
}
