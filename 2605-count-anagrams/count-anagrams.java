import java.util.*;

public class Solution {
    static final int MOD = 1000000007;
    static long[] fact;

    public int countAnagrams(String s) {
        int n = s.length();
        precomputeFactorials(n);

        String[] words = s.split(" ");
        long result = 1;

        for (String word : words) {
            int len = word.length();

            // count frequency
            int[] freq = new int[26];
            for (char c : word.toCharArray()) {
                freq[c - 'a']++;
            }

            // calculate permutations
            long ways = fact[len];
            for (int f : freq) {
                if (f > 0) {
                    ways = (ways * modInverse(fact[f])) % MOD;
                }
            }

            result = (result * ways) % MOD;
        }

        return (int) result;
    }

    // Precompute factorials
    private void precomputeFactorials(int n) {
        fact = new long[n + 1];
        fact[0] = 1;
        for (int i = 1; i <= n; i++) {
            fact[i] = (fact[i - 1] * i) % MOD;
        }
    }

    // Modular inverse using Fermat's Little Theorem
    private long modInverse(long x) {
        return power(x, MOD - 2);
    }

    // Fast exponentiation
    private long power(long base, int exp) {
        long result = 1;
        base %= MOD;

        while (exp > 0) {
            if ((exp & 1) == 1) {
                result = (result * base) % MOD;
            }
            base = (base * base) % MOD;
            exp >>= 1;
        }

        return result;
    }
}