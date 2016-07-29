package org.moskvax.gcj.APAC2017p.A_LazySpellingBee;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.HashSet;
import java.util.Scanner;

public class Main {

  private static final BigInteger M = BigInteger.valueOf(1000000007L);

  private static BigInteger solve(String tc) {

    HashSet<Character> neighbourSet = new HashSet<>();
    BigInteger combinations = BigInteger.ONE;

    for (int i = 0; i < tc.length(); i++) {
      neighbourSet.clear();
      neighbourSet.add(tc.charAt(Math.max(0, i - 1)));
      neighbourSet.add(tc.charAt(i));
      neighbourSet.add(tc.charAt(Math.min(i + 1, tc.length() - 1)));
      combinations = combinations.multiply(BigInteger.valueOf(neighbourSet.size()));
    }
    return combinations.mod(M);
  }

  public static void main(String[] args) throws IOException {
    Scanner in = new Scanner(new BufferedReader(new FileReader(args[0])));
    PrintWriter out = new PrintWriter(args[1]);
    int t = Integer.valueOf(in.nextLine());
    for (int i = 1; i <= t; ++i) {
      String tc = in.nextLine();
      out.println("Case #" + i + ": " + solve(tc));
      out.flush();
    }
  }
}
