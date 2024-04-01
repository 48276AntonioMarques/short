package diff

import kotlin.math.max

// Original code: https://github.com/javalc6/stringdiff2/blob/main/StringDiff2.java
// Modified for console output using ANSI escape codes
private const val lcs_threshold = 10 // minimum threshold for longest common subsequence

fun markTextDiff2(original: String, modified: String): String {
    val lcs = longestCommonSubsequence(original, modified)
    val stringBuilder = StringBuilder()

    var cur1 = 0
    var cur2 = 0 // cursors
    for (k in 0 until lcs.length) {
        val common = lcs[k]
        val idx1 = original.indexOf(common, cur1)
        val idx2 = modified.indexOf(common, cur2)
        if (idx1 > cur1) {
            // DELETE COLOR
            stringBuilder.append("\u001B[38;5;32m${original.substring(cur1, idx1)}\u001B[0m")
        }
        if (idx2 > cur2) {
            // INSERT COLOR
            stringBuilder.append("\u001B[38;5;31m${modified.substring(cur2, idx2)}\u001B[0m")
        }
        stringBuilder.append(common)
        cur1 = idx1 + 1
        cur2 = idx2 + 1
    }
    if (cur1 < original.length) {
        // DELETE COLOR
        stringBuilder.append("\u001B[38;5;32m${original.substring(cur1)}\u001B[0m")
    }
    if (cur2 < modified.length) {
        // INSERT COLOR
        stringBuilder.append("\u001B[38;5;31m${modified.substring(cur2)}\u001B[0m")
    }

    return stringBuilder.toString()
}

/* This algorithm uses a quadratic amount of memory
public static String longestCommonSubsequence(String text1, String text2) {
//credit to: https://rosettacode.org/wiki/Longest_common_subsequence#Java
    int[][] lengths = new int[text1.length() + 1][text2.length() + 1];
    // row 0 and column 0 are initialized to 0 already
    for (int i = 0; i < text1.length(); i++)
        for (int j = 0; j < text2.length(); j++)
            if (text1.charAt(i) == text2.charAt(j))
                lengths[i+1][j+1] = lengths[i][j] + 1;
            else
                lengths[i+1][j+1] = Math.max(lengths[i+1][j], lengths[i][j+1]);

    // get the substring out from the matrix
    StringBuffer sb = new StringBuffer();
    for (int x = text1.length(), y = text2.length(); x != 0 && y != 0; ) {
        if (lengths[x][y] == lengths[x-1][y])
            x--;
        else if (lengths[x][y] == lengths[x][y-1])
            y--;
        else {
            x--;
            y--;
            assert text1.charAt(x) == text2.charAt(y);
            sb.append(text1.charAt(x));
        }
    }

    return sb.reverse().toString();
}
*/
// Hirschberg algorithm, code is imported from package org.apache.commons.text.similarity, licensed to the Apache Software Foundation (ASF)
// The Hirschberg algorithm uses a linear amount of memory
// reference: https://commons.apache.org/proper/commons-text/index.html
private fun longestCommonSubsequence(left: String, right: String): String {
    val m = left.length
    val n = right.length

    val out = StringBuilder()

    if (m == 1) { // Handle trivial cases, as per the paper
        if (right.contains(left)) {
            // left contains one and only one character
            out.append(left)
        }
    } else if (n > 0 && m > 1) {
        val mid = m / 2 // Find the middle point

        val leftFirstPart = left.substring(0, mid)
        val leftSecondPart = left.substring(mid, m)

        // Step 3 of the algorithm: two calls to Algorithm B
        val l1 = algorithmB(leftFirstPart, right)
        val l2 = algorithmB(reverse(leftSecondPart), reverse(right))

        // Find k, as per the Step 4 of the algorithm
        var k = 0
        var t = 0
        for (j in 0..n) {
            val s = l1[j] + l2[n - j]
            if (t < s) {
                t = s
                k = j
            }
        }

        // Step 5: solve simpler problems, recursively
        out.append(longestCommonSubsequence(leftFirstPart, right.substring(0, k)))
        out.append(longestCommonSubsequence(leftSecondPart, right.substring(k, n)))
    }

    return out.toString()
}

private fun reverse(s: String): String {
    return StringBuilder(s).reverse().toString()
}

private fun algorithmB(left: String, right: String): IntArray {
    val m = left.length
    val n = right.length

    // Creating an array for storing two rows of DP table
    val dpRows = Array(2) { IntArray(1 + n) }

    for (i in 1..m) {
        // K(0, j) <- K(1, j) [j = 0...n], as per the paper:
        // Since we have references in Java, we can swap references instead of literal copying.
        // We could also use a "binary index" using modulus operator, but directly swapping the
        // two rows helps readability and keeps the code consistent with the algorithm description
        // in the paper.
        val temp = dpRows[0]
        dpRows[0] = dpRows[1]
        dpRows[1] = temp

        for (j in 1..n) {
            if (left[i - 1] == right[j - 1]) {
                dpRows[1][j] = dpRows[0][j - 1] + 1
            } else {
                dpRows[1][j] =
                    max(dpRows[1][j - 1].toDouble(), dpRows[0][j].toDouble()).toInt()
            }
        }
    }

    // LL(j) <- K(1, j) [j=0...n], as per the paper:
    // We don't need literal copying of the array, we can just return the reference
    return dpRows[1]
}
