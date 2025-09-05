package org.example;

public class Hofstadter {
  // Your implementations of the sequence goes here.
  // Recall that you can calculate the nth term, G(n), using:
  // G(n) = n - G(G(n-1))
  // G(0) = 0

  // 0, 1, 1, 2, 3, 3, 4, 4, 5, 6, 6, 7, …
  //A naive recursive method that uses the recurrence relation described:
  // G(n)=n−G(G(n−1))
  // G(0)=0
  public Integer naiveGSequence(Integer index) {
    if (index == 0) {
      return 0;
    }
    return index - naiveGSequence(naiveGSequence(index - 1));
  }

  private java.util.HashMap<Integer, Integer> memo = new java.util.HashMap<>();
  //An improved recursive method that memoizes the output of the recurrence relation.
  public Integer memoizedGSequence(Integer index) {
    if (index == 0) {
      return 0;
    }
    if (memo.containsKey(index)) {
      return memo.get(index);
    }
    int result = index - memoizedGSequence(memoizedGSequence(index - 1));
    memo.put(index, result);
    return result;
  }
}
