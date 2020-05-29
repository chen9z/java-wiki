package alg.thk;

/**
 * 回溯算法
 */
public class RecallProblem {


    //八皇后问题
    int[] res=new int[8];
    public void cal8Queens(int row){
        if(row==8){
            printQueens(res);
            return;
        }
        for (int i = 0; i < 8; i++) {
            if (isSafe(row, i)) {
                res[row]=i;
                cal8Queens(row+1);
            }
        }
    }

    private boolean isSafe(int row, int colunm) {
        int leftUp=colunm-1,rightUp=colunm+1;
        for (int i = row-1; i>=0; i--) {
            //同一列
            if (res[i] == colunm) {
                return false;
            }

            if(leftUp>=0){
                if(res[i]==leftUp) return false;
            }

            if (rightUp < 8) {
                if(res[i]==rightUp) return false;
            }
            leftUp--;rightUp++;
        }
        return true;
    }

    private void printQueens(int[] res) {
        for (int i = 0; i <8; i++) {
            for (int j = 0; j < 8; j++) {
                if(res[i]==j){
                    System.out.print(1+" ");
                }else {
                    System.out.print(0+" ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }
    int MAX=Integer.MIN_VALUE;
    public void calBag(int w, int cw,int n, int[] items, int i) {
        if (cw == w || i == n) {
            MAX = Math.max(MAX, cw);
            return;
        }
        calBag(w,cw,n,items,i+1);
        if (cw + items[i] <= w) {
            calBag(w,cw+items[i],n,items,i+1);
        }
    }
}
