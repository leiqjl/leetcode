package com.leiqjl;

import java.util.Arrays;

/**
 * 2491. Divide Players Into Teams of Equal Skill - Medium
 * You are given a positive integer array skill of even length n where skill[i] denotes the skill of the ith player. Divide the players into n / 2 teams of size 2 such that the total skill of each team is equal.
 * <p>
 * The chemistry of a team is equal to the product of the skills of the players on that team.
 * <p>
 * Return the sum of the chemistry of all the teams, or return -1 if there is no way to divide the players into teams such that the total skill of each team is equal.
 */
public class DividePlayersIntoTeamsOfEqualSkill {
    public long dividePlayers(int[] skill) {
        int n = skill.length;
        int[] freq = new int[2001];
        int sum = 0;
        for (int i = 0; i < n; i++) {
            freq[skill[i]]++;
            sum += skill[i];
        }
        if (sum % (n / 2) != 0) {
            return -1;
        }
        int avg = sum / (n / 2);
        long res = 0;
        for (int curSkill : skill) {
            if (freq[curSkill] == 0) {
                continue;
            }
            int anotherSkill = avg - curSkill;
            if (freq[anotherSkill] == 0) {
                return -1;
            }
            freq[curSkill]--;
            freq[anotherSkill]--;
            res += (long) curSkill * anotherSkill;
        }

        return res;
    }

    public long dividePlayers1(int[] skill) {
        int n = skill.length;
        Arrays.sort(skill);
        int avg = skill[0] + skill[n - 1];
        long res = (long) skill[0] * skill[n - 1];
        int l = 1, r = n - 2;
        while (l < r) {
            if (skill[l] + skill[r] != avg) {
                return -1;
            }
            res += (long) skill[l] * skill[r];
            l++;
            r--;
        }
        return res;
    }

    public static void main(String[] args) {
        DividePlayersIntoTeamsOfEqualSkill d = new DividePlayersIntoTeamsOfEqualSkill();
        //Input: skill = [3,2,5,1,3,4]
        //Output: 22
        //Explanation: The best we can do is to group the players into [3,1], [2,3], [5,4].
        // The sum of the teams is: 3 + 1 + 2 + 3 + 5+ 4 = 22.
        assert d.dividePlayers(new int[]{3, 2, 5, 1, 3, 4}) == 22;
        //Input: skill = [3,4]
        //Output: 12
        assert d.dividePlayers(new int[]{3, 4}) == 12;
        //Input: skill = [1,1,2,3]
        //Output: -1
        assert d.dividePlayers(new int[]{1, 1, 2, 3}) == -1;
        assert d.dividePlayers(new int[]{10, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000}) == -1;
    }
}
