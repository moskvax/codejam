package org.moskvax.gcj.R1C_2009.A_AllYourBase;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

import static java.lang.Integer.valueOf;

public class Main {

  private static String solve(String tc) {
    String[] tcDigits = tc.split("");
    HashSet<String> digitSet = new HashSet<>();
    HashMap<String, Integer> digitMap = new HashMap<>();
    Collections.addAll(digitSet, tc.split(""));

    digitMap.put(tcDigits[0], 1);
    int nextMin = 0;
    int base = Math.max(digitSet.size(), 2);
    BigInteger res = BigInteger.valueOf(base).pow(tcDigits.length - 1);

    for (int i = 1; i < tcDigits.length; i++) {
      if (!digitMap.containsKey(tcDigits[i])) {
        digitMap.put(tcDigits[i], nextMin++);
        if (nextMin == 1) {
          nextMin++;
        }
      }
      res = res.add(BigInteger.valueOf(base).pow(tcDigits.length - 1 - i)
          .multiply(BigInteger.valueOf(digitMap.get(tcDigits[i]))));

    }

    return res.toString();
  }

  public static void main(String[] args) throws IOException {
    Scanner in = new Scanner(new BufferedReader(new FileReader(args[0])));
    PrintWriter out = new PrintWriter(args[0].substring(0, args[0].lastIndexOf('.')) + ".out");
    int t = valueOf(in.nextLine());
    for (int i = 1; i <= t; i++) {
      String tc = in.nextLine();
      out.println("Case #" + i + ": " + solve(tc));
      out.flush();
    }
  }
}
