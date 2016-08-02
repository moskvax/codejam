package org.moskvax.gcj.APAC2017p.D_SumsOfSums;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

public class Main {

  private static String solve(int[] tc, List<List<Integer>> qs) {
    List<Integer> sortedSums = new ArrayList<>();
    for (int i = 0; i < tc.length; i++) {
      for (int j = 0; j < tc.length - i; j++) {

      }
    }
    return "";
  }

  public static void main(String[] args) throws FileNotFoundException {
    Scanner in = new Scanner(new BufferedReader(new FileReader(args[0])));
    PrintWriter out = new PrintWriter(args[0].substring(0, args[0].lastIndexOf('.')) + ".out");
    int t = Integer.valueOf(in.nextLine());
    for (int i = 1; i <= t; ++i) {
      int q = Integer.valueOf(in.nextLine().split(" ")[1]);
      int[] tc = Stream.of(in.nextLine().split(" ")).mapToInt(Integer::valueOf).toArray();

      List<List<Integer>> qs = new ArrayList<>();
      for (int j = 0; j < q; j++) {
        List<Integer> qj = new ArrayList<>();
        qj.add(in.nextInt());
        qj.add(in.nextInt());
        qs.add(qj);
      }
      out.printf("Case #%d:\n%s", i, solve(tc, qs));
      out.flush();
    }
  }
}
