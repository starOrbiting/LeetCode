package NEU.Week05;

public class dp_UniqueBtree_96 {
    public int numTrees(int n) {
        /*
         * 思路：dp
         * （1）G[0]、G[1]、、G[n]：长度为n的排列数
         * （2）G[i]=F(0,i)+F(1,i)+F(2,i)+++F(i,i)：以i为根、长度为n的排列数
         * （3）F(j,i)=G[j-1]*G[i-j]
         */
        int[] G = new int[n + 1];
        G[0] = 1;
        G[1] = 1;
        // G(n) 的值依赖于 G(0)~G(n-1)
        for (int i = 2; i <= n; i++) {
            //（2）G[i]=F(0,i)+F(1,i)+F(2,i)+++F(i,i)
            for (int j = 1; j <= i; j++) {
                //（3）F(j,i)=G[j-1]*G[i-j]
                G[i] += G[j - 1] * G[i - j];
            }
        }
        return G[n];
    }
}
