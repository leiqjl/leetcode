package com.leiqjl;

import java.util.ArrayList;
import java.util.List;

/**
 * 3433. Count Mentions Per User - Medium
 */
public class CountMentionsPerUser {
    public int[] countMentions(int numberOfUsers, List<List<String>> events) {
        events.sort((a, b) -> {
            int timeA = Integer.parseInt(a.get(1));
            int timeB = Integer.parseInt(b.get(1));
            if (timeA != timeB) {
                return Integer.compare(timeA, timeB);
            }
            boolean aIsMessage = a.get(0).equals("MESSAGE");
            boolean bIsMessage = b.get(0).equals("MESSAGE");
            return Boolean.compare(aIsMessage, bIsMessage);
        });
        int[] count = new int[numberOfUsers];
        int[] lastOnlineTime = new int[numberOfUsers];
        for (List<String> event : events) {
            String type = event.get(0);
            int time = Integer.parseInt(event.get(1));

            if (type.equals("OFFLINE")) {
                lastOnlineTime[Integer.parseInt(event.get(2))] = time + 60;
            } else {
                String mentionsString = event.get(2);
                if (mentionsString.equals("ALL")) {
                    for (int i = 0; i < numberOfUsers; i++) {
                        count[i]++;
                    }
                } else if (mentionsString.equals("HERE")) {
                    for (int i = 0; i < numberOfUsers; i++) {
                        if (lastOnlineTime[i] <= time) {
                            count[i]++;
                        }
                    }
                } else {
                    String[] users = mentionsString.split(" ");
                    for (String user : users) {
                        int idx = Integer.parseInt(user.substring(2));
                        count[idx]++;
                    }
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        CountMentionsPerUser c = new CountMentionsPerUser();
        //Input: numberOfUsers = 2, events = [["MESSAGE","10","id1 id0"],["OFFLINE","11","0"],["MESSAGE","71","HERE"]]
        //
        //Output: [2,2]
        List<List<String>> lists = new ArrayList<>();
        lists.add(List.of("MESSAGE", "10", "id1 id0"));
        lists.add(List.of("OFFLINE", "11", "0"));
        lists.add(List.of("MESSAGE", "71", "HERE"));
        int[] count = c.countMentions(2, lists);

    }
}
