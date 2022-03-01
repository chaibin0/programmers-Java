package q72411;

import java.util.*;
import java.util.stream.Collectors;

class Solution {

    private Map<String, Integer> countOfMenuSet;
    private Map<Integer, Integer> coursesToMenuMaxSize;
    private List<Integer> courses;
    private int maxCourseSize;

    public String[] solution(String[] orders, int[] course) {

        this.maxCourseSize = course[course.length - 1];
        this.courses = Arrays.stream(course)
                .boxed()
                .collect(Collectors.toList());
        this.countOfMenuSet = new TreeMap<>();
        this.coursesToMenuMaxSize = new HashMap<>();

        List<String> answerList = solve(orders);
        Collections.sort(answerList);

        String[] answer = new String[answerList.size()];
        for (int i = 0; i < answerList.size(); i++) {
            answer[i] = answerList.get(i);
        }
        return answer;
    }

    public List<String> solve(String[] orders) {

        List<String> answer = new ArrayList<>();

        for (int c : this.courses) {
            coursesToMenuMaxSize.put(c, 0);
        }

        for (String order : orders) {
            dfs(order, "", 0, true);
        }

        Set<String> keySet = this.countOfMenuSet.keySet();
        for (int c : courses) {

            int menuMaxSize = coursesToMenuMaxSize.get(c);
            if (menuMaxSize == 1) {
                continue;
            }
            for (String key : keySet) {
                if (key.length() == c && countOfMenuSet.get(key) == menuMaxSize) {
                    answer.add(key);
                }
            }
        }

        return answer;
    }

    public void dfs(String order, String current, int index, boolean isSkip) {

        if (maxCourseSize < current.length()) {
            return;
        }

        if (!isSkip && courses.contains(current.length())) {

            int size;
            char[] valueArray = current.toCharArray();
            Arrays.sort(valueArray);

            StringBuilder sb = new StringBuilder();
            sb.append(valueArray);

            String value = sb.toString();
            if (!countOfMenuSet.containsKey(value)) {
                size = 1;
                countOfMenuSet.put(value, 1);
            } else {
                size = countOfMenuSet.get(value) + 1;
                countOfMenuSet.put(value, countOfMenuSet.get(value) + 1);
            }

            coursesToMenuMaxSize.put(current.length(), Math.max(coursesToMenuMaxSize.get(current.length()), size));
        }

        if (index >= order.length()) {
            return;
        }

        dfs(order, current + order.charAt(index), index + 1, false);
        dfs(order, current, index + 1, true);
    }

    public static void main(String[] args) {
        String[] orders = {"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"};
        int[] courses = {2, 3, 4};

        String[] answer = new Solution().solution(orders, courses);
        Arrays.stream(answer).forEach(System.out::println);
    }
}