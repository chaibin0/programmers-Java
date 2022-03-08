package q72412;

import java.util.*;

public class Solution2 {

    private static final Set<String> languages = new HashSet<>(Arrays.asList("cpp", "java", "python"));
    private static final Set<String> jobs = new HashSet<>(Arrays.asList("backend", "frontend"));
    private static final Set<String> careers = new HashSet<>(Arrays.asList("junior", "senior"));
    private static final Set<String> soulFoods = new HashSet<>(Arrays.asList("chicken", "pizza"));

    Map<String, List<Integer>> candidateStatistic = new HashMap<>();

    public int[] solution(String[] info, String[] query) {
        int[] answer = new int[query.length];

        for (String i : info) {
            StringTokenizer st = new StringTokenizer(i, " ");
            String language = st.nextToken();
            String job = st.nextToken();
            String career = st.nextToken();
            String soulFood = st.nextToken();
            int score = Integer.parseInt(st.nextToken());

            StringJoiner sj = new StringJoiner("_");
            sj.add(language);
            sj.add(job);
            sj.add(career);
            sj.add(soulFood);
            String value = sj.toString();
            if (!candidateStatistic.containsKey(value)) {
                candidateStatistic.put(value, new ArrayList<>(Arrays.asList(score)));
            } else {
                candidateStatistic.get(value).add(score);
            }
        }

        for (Map.Entry<String, List<Integer>> entry : candidateStatistic.entrySet()) {
            Collections.sort(entry.getValue(), Collections.reverseOrder());
        }


        for (int index = 0; index < query.length; index++) {

            Set<String> first = new HashSet<>();
            Set<String> second = new HashSet<>();
            Set<String> third = new HashSet<>();
            Set<String> fourth = new HashSet<>();

            StringTokenizer st = new StringTokenizer(query[index], " ");
            String languageQuery = st.nextToken();
            st.nextToken();
            String jobQuery = st.nextToken();
            st.nextToken();
            String careerQuery = st.nextToken();
            st.nextToken();
            String soulFoodQuery = st.nextToken();
            int scoreQuery = Integer.parseInt(st.nextToken());

            if (languageQuery.equals("-")) {
                first = languages;
            } else {
                first.add(languageQuery);
            }

            if (jobQuery.equals("-")) {
                second = jobs;
            } else {
                second.add(jobQuery);
            }

            if (careerQuery.equals("-")) {
                third = careers;
            } else {
                third.add(careerQuery);
            }

            if (soulFoodQuery.equals("-")) {
                fourth = soulFoods;
            } else {
                fourth.add(soulFoodQuery);
            }
            int total = 0;
            for (String i : first) {
                for (String j : second) {
                    for (String k : third) {
                        for (String l : fourth) {
                            StringJoiner sj = new StringJoiner("_");
                            sj.add(i);
                            sj.add(j);
                            sj.add(k);
                            sj.add(l);
                            List<Integer> scores = candidateStatistic.get(sj.toString());
                            int result = getCount(scores, scoreQuery);
                            total+=result;
                        }
                    }
                }
            }
            answer[index] = total;
        }

        return answer;
    }

    private int getCount(List<Integer> scores, int scoreQuery) {

        if (Objects.isNull(scores) || scores.isEmpty()){
            return 0;
        }
        int answer = 0;
        for (int i : scores) {
            if (i < scoreQuery) {
                break;
            }

            answer++;
        }
        return answer;
    }


    public static void main(String[] args) {
        String[] info = {"java backend junior pizza 150", "python frontend senior chicken 210", "python frontend senior chicken 150", "cpp backend senior pizza 260", "java backend junior chicken 80", "python backend senior chicken 50"};
        String[] query = {"java and backend and junior and pizza 100", "python and frontend and senior and chicken 200", "cpp and - and senior and pizza 250", "- and backend and senior and - 150", "- and - and - and chicken 100", "- and - and - and - 150"};
        Solution2 solution = new Solution2();

        int[] result = solution.solution(info, query);

    }
}
