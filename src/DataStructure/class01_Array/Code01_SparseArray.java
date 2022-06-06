package DataStructure.class01_Array;

public class Code01_SparseArray {
    public static void printArray(int[][] arr){
        for (int[] row : arr
        ) {
            for (int data : row
            ) {
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        // 1. 原始棋盘
        int chessArr1[][] = new int[11][11];
        chessArr1[1][2] = 1;
        chessArr1[2][3] = 2;
        chessArr1[8][9] = 999;
        System.out.println("原数组如下-------------------");
        printArray(chessArr1);

        /* 2. 构建稀疏数组
            1) 遍历二维数组，获得非0数字个数 sum
            2) 构建稀疏数组 [sum+1][3]
            3) 遍历二维数组，非0数存到稀疏数组
            4) 输出稀疏数组
         */
        int sum = 0;
        for (int i = 0; i < chessArr1.length; i++) {
            for (int j = 0; j < chessArr1[i].length; j++) {
                if (chessArr1[i][j] != 0){
                    sum++;
                }
            }
        }

        int sparseArray[][] = new int[sum + 1][3];
        sparseArray[0][0] = chessArr1.length;
        sparseArray[0][1] = chessArr1[0].length;
        sparseArray[0][2] = sum;

        int count = 0;
        for (int i = 0; i < chessArr1.length; i++) {
            for (int j = 0; j < chessArr1[i].length; j++) {
                if (chessArr1[i][j] != 0){
                    count++;
                    sparseArray[count][0] = i;
                    sparseArray[count][1] = j;
                    sparseArray[count][2] = chessArr1[i][j];
                }
            }
        }

        System.out.println("稀疏数组如下---------------------");
        printArray(sparseArray);

        // 3. 稀疏数组恢复二维数组

        int chessArr2[][] = new int[sparseArray[0][0]][sparseArray[0][1]];
        for (int i = 1; i < sparseArray.length; i++) {
            chessArr2[sparseArray[i][0]][sparseArray[i][1]] = sparseArray[i][2];
        }
        System.out.println("恢复后数组如下-----------------");
        printArray(chessArr2);

    }
}
