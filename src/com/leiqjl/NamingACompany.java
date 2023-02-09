package com.leiqjl;

import java.util.HashSet;

/**
 * 2306. Naming a Company - Hard
 */
public class NamingACompany {
    public long distinctNames(String[] ideas) {
        HashSet<String>[] group = new HashSet[26];
        for (int i = 0; i < 26; i++) {
            group[i] = new HashSet<>();
        }
        for (String idea : ideas) {
            group[idea.charAt(0) - 'a'].add(idea.substring(1));
        }
        long result = 0;
        for (int i = 0; i < 25; i++) {
            if (group[i].size() == 0) {
                continue;
            }
            for (int j = i + 1; j < 26; j++) {
                if (group[j].size() == 0) {
                    continue;
                }
                long c1 = 0, c2 = 0;
                for (String str : group[i]) {
                    if (!group[j].contains(str)) {
                        c1++;
                    }
                }
                for (String str : group[j]) {
                    if (!group[i].contains(str)) {
                        c2++;
                    }
                }
                result += c1 * c2 * 2;
            }
        }
        return result;
    }
}
