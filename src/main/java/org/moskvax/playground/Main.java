package org.moskvax.playground;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

  public static void main(String[] args) throws IOException {

    List<Double> prices = new ArrayList<>();

    try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
      String line;
      while ((line = reader.readLine()) != null) {
        prices.add(Double.valueOf(line));
      }
    }
  System.out.println(findMaxDifference(prices));

  }

  public static Result findMaxDifference(List<Double> prices) {
    Result result = new Result();

    for (int i = 0; i < prices.size() - 1; i++) {
      Double difference = prices.get(i + 1) - prices.get(i);
      if (difference > result.maxDifference) {
        result.maxDifference = difference;
        result.maxDifferenceIndex = i;
      }
    }
    return result;
  }

  public static class Result {

    public int maxDifferenceIndex = 0;
    public Double maxDifference = 0d;

    @Override public String toString() {
      return "Result{" +
          "maxDifferenceIndex=" + maxDifferenceIndex +
          ", maxDifference=" + maxDifference +
          '}';
    }
  }

}
