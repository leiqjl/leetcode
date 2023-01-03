package com.leiqjl;

/**
 * 944. Delete Columns to Make Sorted - Easy
 */
public class DeleteColumnsToMakeSorted {
    public int minDeletionSize(String[] strs) {
        int count = 0;
        for (int i = 0; i < strs[0].length(); i++) {
            for (int j = 1; j < strs.length; j++) {
                if (strs[j-1].charAt(i) > strs[j].charAt(i)) {
                    count++;
                    break;
                }
            }
        }
        return count;
    }


    public static void main(String[] args) {
        DeleteColumnsToMakeSorted d = new DeleteColumnsToMakeSorted();
        assert d.minDeletionSize(new String[]{"cba", "daf", "ghi"}) == 1;
        assert d.minDeletionSize(new String[]{"a", "b"}) == 0;
        assert d.minDeletionSize(new String[]{"zyx", "wvu", "tsr"}) == 3;
    }
}
