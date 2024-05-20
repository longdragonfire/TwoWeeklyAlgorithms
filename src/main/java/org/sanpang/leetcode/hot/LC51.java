package org.sanpang.leetcode.hot;

import java.util.ArrayList;
import java.util.List;

public class LC51 {
    /*https://leetcode.cn/problems/n-queens/description/?envType=study-plan-v2&envId=top-100-liked
    按照国际象棋的规则，皇后可以攻击与之处在同一行或同一列或同一斜线上的棋子。
    n 皇后问题 研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
    给你一个整数 n ，返回所有不同的 n 皇后问题 的解决方案。
    每一种解法包含一个不同的 n 皇后问题 的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。
    示例 1：
    输入：n = 4
    输出：[[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
    解释：如上图所示，4 皇后问题存在两个不同的解法。
    示例 2：
    输入：n = 1
    输出：[["Q"]]
    */
    static List<List<String>> result = new ArrayList<List<String>>();

    public static void main(String[] args) {
        int n = 1;
        System.out.println(solveNQueens(n).toString());
    }
    static public List<List<String>> solveNQueens(int n) {
        result.clear(); // 不清除的话力扣用例测试时会出错，或者将类变量转变成方法内的局部变量
        int[] seq = new int[n]; // 棋子放入的八个位置，row表示行（下标），colume表示列（值）

        solve(0, n, seq);
        return  result;
    }

    public static void solve(int row, int n, int[] seq) {
        if ( row == n ) {
            addSeq(n, seq);
            return;
        }

        for (int j = 0; j < n; j++) {
            //
            if ( valid(row, j, seq) ) {
                seq[row] = j;
                solve(row + 1, n, seq);
            }
        }

    }

    public static boolean valid(int row, int column, int[] seq) {
        boolean res = true;
        for (int i = 0; i < row; i++) {
            if ( seq[i] == column ) return res = false;
            int m = row - column;
            int n = row + column;
            if ( i - seq[i] == m || i + seq[i] == n ) return res = false;
        }
        return res;
    }

    public static void addSeq(int n, int[] seq) {
        ArrayList<String> lists = new ArrayList<String>();
        for (int row = 0; row < n; row++) {
            StringBuilder sb = new StringBuilder();
            for (int column = 0; column < n; column++) {
                if ( seq[row] == column ) {
                    sb.append("Q");
                } else {
                    sb.append(".");
                }
            }
            lists.add(sb.toString());
        }
        result.add(lists);
    }
}
