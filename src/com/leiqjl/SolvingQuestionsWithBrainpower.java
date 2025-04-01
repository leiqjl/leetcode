package com.leiqjl;

/**
 * 2140. Solving Questions With Brainpower - Medium
 * You are given a 0-indexed 2D integer array questions where questions[i] = [points_i, brainpower_i].
 * <p>
 * The array describes the questions of an exam, where you have to process the questions in order (i.e., starting from question 0) and make a decision whether to solve or skip each question.
 * Solving question i will earn you points_i points but you will be unable to solve each of the next brainpower_i questions. If you skip question i, you get to make the decision on the next question.
 * <p>
 * ·For example, given questions = [[3, 2], [4, 3], [4, 4], [2, 5]]:
 * ·If question 0 is solved, you will earn 3 points but you will be unable to solve questions 1 and 2.
 * ·If instead, question 0 is skipped and question 1 is solved, you will earn 4 points but you will be unable to solve questions 2 and 3.
 * Return the maximum points you can earn for the exam.
 */
public class SolvingQuestionsWithBrainpower {
    //Constraints:
    //
    //1 <= questions.length <= 10^5
    //questions[i].length == 2
    //1 <= pointsi, brainpoweri <= 10^5
    //dp bottom to top
    public long mostPoints(int[][] questions) {
        int n = questions.length;
        long[] dp = new long[n + 1];
        for (int i = n - 1; i >= 0; i--) {
            int points = questions[i][0];
            int brainpower = questions[i][1];
            long solved = points + dp[Math.min(i + brainpower + 1, n)];
            dp[i] = Math.max(solved, dp[i + 1]);
        }
        return dp[0];
    }

    public static void main(String[] args) {
        SolvingQuestionsWithBrainpower s = new SolvingQuestionsWithBrainpower();
        //Explanation: The maximum points can be earned by solving questions 0 and 3.
        //- Solve question 0: Earn 3 points, will be unable to solve the next 2 questions
        //- Unable to solve questions 1 and 2
        //- Solve question 3: Earn 2 points
        //Total points earned: 3 + 2 = 5. There is no other way to earn 5 or more points.
        assert s.mostPoints(new int[][]{{3, 2}, {4, 3}, {4, 4}, {2, 5}}) == 5;
        assert s.mostPoints(new int[][]{{1, 1}, {2, 2}, {3, 3}, {4, 4}, {5, 5}}) == 7;
    }
}
