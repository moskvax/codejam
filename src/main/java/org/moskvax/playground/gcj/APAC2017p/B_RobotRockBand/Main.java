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

    List<Map<Integer, Integer>> numberValueList = new ArrayList<>();
    long combinations = 0;

    for (List<Integer> robotNumbers : robotNumberLists) {
      HashMap<Integer, Integer> numberCount = new HashMap<>();
      for (Integer robotNumber : robotNumbers) {
        numberCount.put(robotNumber, numberCount.getOrDefault(robotNumber, 0) + 1);
      }
      numberValueList.add(numberCount);
    }

    for (Map.Entry<Integer, Integer> w : numberValueList.get(0).entrySet()) {
      for (Map.Entry<Integer, Integer> x : numberValueList.get(1).entrySet()) {
        for (Map.Entry<Integer, Integer> y : numberValueList.get(2).entrySet()) {
          for (Map.Entry<Integer, Integer> z : numberValueList.get(3).entrySet()) {
            if ((w.getKey() ^ x.getKey() ^ y.getKey() ^ z.getKey()) == k) {
              combinations += w.getValue() * x.getValue() * y.getValue() * z.getValue();
            }
          }
        }
      }
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