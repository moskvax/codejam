package org.moskvax.gcj.R2_2012.A_SwingingWild;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.TreeMap;

public class Main {

  private static String solve(TreeMap<Integer, Integer> vines, int d) {
    int height = vines.firstKey();
    int position = height;

    if (position + height >= d) {
      return "YES";
    }

    while (height > 0) {
      int nextHeight = vines.getOrDefault(height + position, -1);
      if (nextHeight > 0) {
        position += height;
        height = Math.min(height, nextHeight);
        if (position + height >= d) {
          return "YES";
        }
      } else {
        height--;
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
