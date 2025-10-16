package com.leiqjl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 1233. Remove Sub-Folders from the Filesystem - Medium
 */
public class RemoveSubFoldersFromTheFilesystem {
    public List<String> removeSubfolders(String[] folder) {
        List<String> list = new ArrayList<>();
        Arrays.sort(folder);
        String prev = "";

        for (String f : folder) {
            if (!prev.isEmpty() && f.startsWith(prev) && f.charAt(prev.length()) == '/') {
                continue;
            }
            list.add(f);
            prev = f;
        }
        return list;
    }

}
