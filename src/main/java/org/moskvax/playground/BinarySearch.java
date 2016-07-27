package org.moskvax.playground;

import java.util.List;

public class BinarySearch {

  private static <E extends Comparable<E>> int binarySearch(List<E> list, E item, int minBound,
      int maxBound) {

    if (minBound <= maxBound) {
      int pivot = (minBound + maxBound) / 2;
      switch (item.compareTo(list.get(pivot))) {
        case -1:
          return binarySearch(list, item, minBound, pivot - 1);
        case 1:
          return binarySearch(list, item, pivot + 1, maxBound);
        case 0:
          return pivot;
      }
    }
    return -1;
  }

  public static <E extends Comparable<E>> int binarySearch(List<E> list, E item) {
    return binarySearch(list, item, 0, list.size() - 1);
  }
}

