package org.moskvax.playground.gcj.APAC2017p.B_RobotRockBand;

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

    HashMap<Integer, Integer> numberCountTotals = new HashMap<>();

    for (Integer robotNumber : robotNumberLists.get(0)) {
      numberCountTotals.put(robotNumber, numberCountTotals.getOrDefault(robotNumber, 0) + 1);
    }

    for (List<Integer> robotNumbers : robotNumberLists.subList(1, 4)) {
      HashMap<Integer, Integer> numberCountUpdate = new HashMap<>();
      HashMap<Integer, Integer> numberCountNewTotals = new HashMap<>();
      for (Integer robotNumber : robotNumbers) {
        numberCountUpdate.put(robotNumber, numberCountUpdate.getOrDefault(robotNumber, 0) + 1);
      }
      for (Map.Entry<Integer, Integer> oldCount : numberCountTotals.entrySet()) {
        for (Map.Entry<Integer, Integer> newCount : numberCountUpdate.entrySet()) {
          numberCountNewTotals.put(oldCount.getKey() ^ newCount.getKey(),
              oldCount.getValue() * newCount.getValue());
        }
      }
      numberCountTotals = new HashMap<>();
      numberCountTotals.putAll(numberCountNewTotals);
    }

    return numberCountTotals.get(k);
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