package q72412;

import java.util.*;

class Solution {

    private static String EMPTY_CONDITION = "-";
    private static Set<String> languages = new HashSet<>(Arrays.asList("cpp", "java", "python"));
    private static Set<String> jobs = new HashSet<>(Arrays.asList("backend", "frontend"));
    private static Set<String> careers = new HashSet<>(Arrays.asList("junior", "senior"));
    private static Set<String> soulFoods = new HashSet<>(Arrays.asList("chicken", "pizza"));

    public int[] solution(String[] info, String[] query) {
        int[] answer = new int[query.length];
        List<Candidate> candidates = initCandidate(info);

        for (int i = 0; i < query.length; i++) {
            answer[i] = solve(candidates, query[i]);
        }

        return answer;
    }

    private int solve(List<Candidate> candidates, String query) {

        int answer = 0;
        StringTokenizer st = new StringTokenizer(query, " ");
        String languageCondition = st.nextToken();
        st.nextToken();
        String jobCondition = st.nextToken();
        st.nextToken();
        String careerCondition = st.nextToken();
        st.nextToken();
        String soulFoodCondition = st.nextToken();
        int scoreCondition = Integer.parseInt(st.nextToken());

        for (Candidate candidate : candidates) {

            if (candidate.score < scoreCondition) {
                break;
            }

            if (!(EMPTY_CONDITION.equals(languageCondition) || languageCondition.equals(candidate.language))) {
                continue;
            }

            if (!(EMPTY_CONDITION.equals(jobCondition) || jobCondition.equals(candidate.job))) {
                continue;
            }

            if (!(EMPTY_CONDITION.equals(careerCondition) || careerCondition.equals(candidate.career))) {
                continue;
            }

            if (!(EMPTY_CONDITION.equals(soulFoodCondition) || soulFoodCondition.equals(candidate.soulFood))) {
                continue;
            }

            answer++;
        }

        return answer;
    }

    private List<Candidate> initCandidate(String[] info) {

        List<Candidate> candidates = new ArrayList<>();

        for (int i = 0; i < info.length; i++) {
            StringTokenizer st = new StringTokenizer(info[i], " ");
            String language = st.nextToken();
            String job = st.nextToken();
            String career = st.nextToken();
            String soulFood = st.nextToken();
            int score = Integer.parseInt(st.nextToken());
            candidates.add(new Candidate(language, job, career, soulFood, score));
        }
        Collections.sort(candidates);
        return candidates;
    }

    class Candidate implements Comparable<Candidate> {
        private String language;
        private String job;
        private String career;
        private String soulFood;
        private int score;

        public Candidate(String language, String job, String career, String soulFood, int score) {
            this.language = language;
            this.job = job;
            this.career = career;
            this.soulFood = soulFood;
            this.score = score;
        }

        @Override
        public int compareTo(Candidate o) {
            return o.score - this.score;
        }
    }


    public static void main(String[] args) {
        String[] info = {"java backend junior pizza 150", "python frontend senior chicken 210", "python frontend senior chicken 150", "cpp backend senior pizza 260", "java backend junior chicken 80", "python backend senior chicken 50"};
        String[] query = {"java and backend and junior and pizza 100", "python and frontend and senior and chicken 200", "cpp and - and senior and pizza 250", "- and backend and senior and - 150", "- and - and - and chicken 100", "- and - and - and - 150"};
        Solution solution = new Solution();

        solution.solution(info, query);
    }
}