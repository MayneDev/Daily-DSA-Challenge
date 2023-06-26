package src.com.daily.dsa.challenge.leetcode;

import java.util.*;

public class CourseScheduleII {

    int courseNum = 0;
    Set<Integer> completed = new HashSet<>();

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        //Prep Map
        Map<Integer, List<Integer>> preqMap = new HashMap<>();
        for (int i = 0; i < prerequisites.length; i++) {
            List<Integer> preqs = new ArrayList<>();

            int key = prerequisites[i][0];
            int val = prerequisites[i][1];

            if (preqMap.containsKey(key)) {
                preqs = preqMap.get(key);
            }
            preqs.add(val);
            preqMap.put(key, preqs);
        }

        int[] order = new int[numCourses];
        for (int x = 0; x < numCourses; x++) {
            if (!canComplete(x, preqMap, new HashSet<>(), order)) {
                return new int[]{};
            }
            if (!completed.contains(x)) {
                order[courseNum] = x;
                courseNum++;
            }
            completed.add(x);
        }
        return order;
    }

    private boolean canComplete(int course, Map<Integer, List<Integer>> preqMap, HashSet<Integer> visited, int[] order) {
        if (!preqMap.containsKey(course) || preqMap.get(course).size() == 0) {
            return true;
        }

        if (visited.contains(course)) {
            return false;
        }

        visited.add(course);

        for (int x : preqMap.get(course)) {
            if (!canComplete(x, preqMap, visited, order)) {
                return false;
            }

            if (!completed.contains(x)) {
                order[courseNum] = x;
                courseNum++;
            }
            completed.add(x);


        }
        visited.remove(course);
        preqMap.put(course, new ArrayList<>());
        return true;
    }
}

