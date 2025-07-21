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
        list.add(folder[0]);
        for (int i = 1; i < folder.length; i++) {
            String last = list.get(list.size() - 1) + '/';
            if (folder[i].startsWith(last)) {
                continue;
            }
            list.add(folder[i]);
        }
        return list;
    }
}
