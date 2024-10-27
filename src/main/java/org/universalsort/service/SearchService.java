package org.universalsort.service;

import java.util.List;

public class SearchService {
    public static <T extends Comparable<T>> T binarySearch(List<T> sortList, T element) {
        int left = 0;
        int right = sortList.size() - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            T obj = sortList.get(mid);
            int result = obj.compareTo(element);
            if (result == 0) {
                return obj;
            } else if (result > 0) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return null;
    }
}
