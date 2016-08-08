package org.moskvax.gcj.APAC2017p.D_SumsOfSums;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

  private static void solve(int[] ns, int n, int[][] qs, int q, PrintWriter out) {
    List<Long> sums = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      for (int j = i; j < n; j++) {
        long sum = 0;
        for (int k = i; k <= j; k++) {
          sum += ns[k];
        }
        sums.add(sum);
      }
    }
    sums.sort(null);
    for (int i = 0; i < q; i++) {
      long res = 0;
      for (int j = qs[i][0] - 1; j < qs[i][1]; j++) {
        res += sums.get(j);
      }
      out.println(res);
    }
  }

  public static void main(String[] args) throws FileNotFoundException {
    Scanner in = new Scanner(new BufferedReader(new FileReader(args[0])));
    PrintWriter out = new PrintWriter(args[0].substring(0, args[0].lastIndexOf('.')) + ".out");
    int t = in.nextInt();
    for (int i = 1; i <= t; ++i) {
      int n = in.nextInt();
      int q = in.nextInt();
      int[] ns = new int[n];
      for (int j = 0; j < n; j++) {
        ns[j] = in.nextInt();
      }
      int[][] qs = new int[q][2];
      for (int j = 0; j < q; j++) {
        qs[j] = new int[] { in.nextInt(), in.nextInt() };
      }
      out.printf("Case #%d:\n", i);
      solve(ns, n, qs, q, out);
      out.flush();
    }
  }
}
