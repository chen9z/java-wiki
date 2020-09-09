package wiki.alg.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 求二叉树的高度
 * Created by chen on 2020/8/31.
 */
public class TreeDepth {

    public int maxDepth(TreeNode root) {
        int max=0;
        dfs(root,0,max);
        return max;
    }

    public void dfs(TreeNode node,int i,int max){
        if(node==null){
            max=Math.max(i,max);
            System.out.println(max);
            return;
        }else{
            i++;
        }
        dfs(node.left,i,max);
        dfs(node.right,i,max);
    }


    public int[][] merge(int[][] intervals) {
        List<int[]> list = new ArrayList<>();
        if(intervals==null||intervals.length==0) return intervals;
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        int i=0;
        while (i < intervals.length) {
            int left = intervals[i][0];
            int right = intervals[i][1];
            i++;
            while (i< intervals.length && right >= intervals[i][0]) {
                right = Math.max(right, intervals[i][1]);
                i++;
            }

            list.add(new int[]{left, right});
        }
        return list.toArray(new int[0][]);
    }

    public int uniquePaths(int m, int n) {
        int[][] dp=new int[m][n];
        for (int i = 0; i < m; i++) {
            dp[i][0]=1;
        }
        for (int i = 0; i < n; i++) {
            dp[0][i]=0;
        }
        for(int i=0;i<m;i++){
            for(int j=0;i<n;j++){
                dp[i][j]=dp[i][j+1]+dp[i+1][j];
            }
        }
        return dp[m-1][n-1];
    }

    public boolean isValidBST(TreeNode root) {
        if(root==null) return true;
        if(root.left!=null&&root.right!=null&&root.left.val<root.right.val){
            return true;
        } else{
            return false;
        }
    }
}
