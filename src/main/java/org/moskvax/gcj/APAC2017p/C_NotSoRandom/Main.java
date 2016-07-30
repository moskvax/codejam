package org.moskvax.gcj.APAC2017p.C_NotSoRandom;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Stream;

public class Main {

  private static double solve(int... tc) {
    final int n = tc[0];
    final int x = tc[1];
    final int k = tc[2];
    final double a = tc[3] / 100D;
    final double b = tc[4] / 100D;
    final double c = tc[5] / 100D;
    double y = 0.0;

    Map<Integer, Double> pv = new HashMap<>();
    pv.put(x & k, a);
    pv.put(x | k, pv.getOrDefault(x | k, 0d) + b);
    pv.put(x ^ k, pv.getOrDefault(x ^ k, 0d) + c);

    for (int i = 1; i < n; i++) {
      Map<Integer, Double> nextPv = new HashMap<>();
      for (Map.Entry<Integer, Double> p : pv.entrySet()) {
        nextPv.put(p.getKey() & k, nextPv.getOrDefault(p.getKey() & k, 0d) + p.getValue() * a);
        nextPv.put(p.getKey() | k, nextPv.getOrDefault(p.getKey() | k, 0d) + p.getValue() * b);
        nextPv.put(p.getKey() ^ k, nextPv.getOrDefault(p.getKey() ^ k, 0d) + p.getValue() * c);
      }
      pv = nextPv;
    }

    for (Map.Entry<Integer, Double> p : pv.entrySet()) {
      y += p.getKey() * p.getValue();
    }

    return y;
  }

  public static void main(String[] args) throws FileNotFoundException {
    Scanner in = new Scanner(new BufferedReader(new FileReader(args[0])));
    PrintWriter out = new PrintWriter(args[0].substring(0, args[0].lastIndexOf('.')) + ".out");
    int t = Integer.valueOf(in.nextLine());
    for (int i = 1; i <= t; ++i) {
      int[] tc = Stream.of(in.nextLine().split(" ")).mapToInt(Integer::valueOf).toArray();
      out.println("Case #" + i + ": " + solve(tc));
      out.flush();
    }
  }
}
