package org.moskvax.gcj.APAC2017p.B_RobotRockBand;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {

  private static long solve(int k, List<List<Integer>> robotNumberLists) {

    List<HashMap<Integer, Integer>> countMapList = new ArrayList<>();
    List<HashMap<Integer, Long>> combinedCountMapList = new ArrayList<>();
    long combinations = 0;

    for (int i = 0; i < 4; i++) {
      HashMap<Integer, Integer> countMap = new HashMap<>();
      for (Integer number : robotNumberLists.get(i)) {
        countMap.put(number, countMap.getOrDefault(number, 0) + 1);
      }
      countMapList.add(countMap);
    }

    for (int i = 0; i < 2; i++) {
      HashMap<Integer, Long> countMap = new HashMap<>();
      for (Map.Entry<Integer, Integer> count0 : countMapList.get(i).entrySet()) {
        for (Map.Entry<Integer, Integer> count1 : countMapList.get(i + 2).entrySet()) {
          int newKey = count0.getKey() ^ count1.getKey();
          countMap.put(newKey,
              countMap.getOrDefault(newKey, 0L) + (count0.getValue() * count1.getValue()));
        }
      }
      combinedCountMapList.add(countMap);
    }

    for (Map.Entry<Integer, Long> count0 : combinedCountMapList.get(0).entrySet()) {
      combinations +=
          combinedCountMapList.get(1).getOrDefault(count0.getKey() ^ k, 0L) * count0.getValue();
    }

    return combinations;
  }

  public static void main(String[] args) throws IOException {
    Scanner in = new Scanner(new BufferedReader(new FileReader(args[0])));
    PrintWriter out = new PrintWriter(args[0].substring(0, args[0].lastIndexOf('.')) + ".out");
    int t = Integer.valueOf(in.nextLine());
    for (int i = 1; i <= t; ++i) {
      List<List<Integer>> bandList = new ArrayList<>();
      int n = in.nextInt();
      int k = in.nextInt();
      for (int j = 0; j < 4; j++) {
        List<Integer> robotList = new ArrayList<>();
        for (int z = 0; z < n; z++) {
          robotList.add(in.nextInt());
        }
        bandList.add(robotList);
      }
      out.println("Case #" + i + ": " + solve(k, bandList));
      out.flush();
    }
  }
}