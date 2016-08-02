package org.moskvax.gcj.R2_2012.A_SwingingWild;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;
import java.util.NavigableSet;
import java.util.Scanner;
import java.util.TreeMap;

public class Main {

  private static String solve(TreeMap<Integer, Integer> vines, int d) {
    TreeMap<Integer, Integer> trialVines = new TreeMap<>();
    trialVines.put(vines.firstKey(), vines.firstKey());

    while (!trialVines.isEmpty()) {
      Map.Entry<Integer, Integer> currentVine = trialVines.pollLastEntry();
      int currentPosition = currentVine.getKey();
      int currentHeight = currentVine.getValue();

      if (currentPosition + currentHeight >= d) {
        return "YES";
      }

      NavigableSet<Integer> reachablePositions =
          vines.subMap(currentPosition, false, currentPosition + currentHeight, true)
              .descendingKeySet();

      for (Integer reachablePosition : reachablePositions) {
        int reachableHeight =
            Math.min(vines.get(reachablePosition), reachablePosition - currentPosition);
        trialVines.put(reachablePosition, reachableHeight);
      }
    }
    return "NO";
  }

  public static void main(String[] args) throws IOException {
    Scanner in = new Scanner(new BufferedReader(new FileReader(args[0])));
    PrintWriter out = new PrintWriter(args[0].substring(0, args[0].lastIndexOf('.')) + ".out");
    int t = in.nextInt();
    for (int i = 1; i <= t; ++i) {
      int n = in.nextInt();
      TreeMap<Integer, Integer> vines = new TreeMap<>();
      for (int j = 0; j < n; j++) {
        vines.put(in.nextInt(), in.nextInt());
      }
      int d = in.nextInt();
      out.println("Case #" + i + ": " + solve(vines, d));
      out.flush();
    }
  }
}
