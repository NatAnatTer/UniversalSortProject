package org.universalsort.service;

import org.universalsort.data.Repository;
import org.universalsort.data.TypesOfData;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class SearchService {
    private final Repository repository;

    public SearchService(Repository repository) {
        this.repository = repository;
    }


    public  <T extends Comparable<T>> T binarySearch(T element, String field, String value, TypesOfData type) {
        List<T> sortList = new ArrayList<>(repository.getRepositoryByType(type));
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
