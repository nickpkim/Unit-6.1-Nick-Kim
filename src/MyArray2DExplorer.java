public class MyArray2DExplorer {
    public static void main(String[] args) {
        int array [][] = {  {4,1,8,5},
                {0,2,3,4},
                {6,6,2,2} };
        MyArray2DExplorer exp = new MyArray2DExplorer();

        System.out.println("Test evenRow: \n Row w/ odd, Expecting: false \n Actual: " + exp.evenRow(array,0));
        System.out.println("Test evenRow: \n Row w/o odd, Expecting: true \n Actual: " + exp.evenRow(array,2));

        System.out.println();

        System.out.println("Test oddColSum: \n Col w/ odd Sum, Expecting: true \n Actual: " + exp.oddColSum(array,1));
        System.out.println("Test oddColSum: \n Col w/ even, Expecting: false \n Actual: " + exp.oddColSum(array,0));

        System.out.println();


        System.out.print("Test minRow: \n Expecting: {0 2 3 4} \n Actual: {");
        int [] row = exp.minRowPractice(array);
        for(int i = 0; i < row.length; i++){
            System.out.print(row[i] + " ");
        }
        System.out.print("]");

        System.out.println();

        System.out.print("Test minRowAssignment: \n Expecting: 2 \n Actual: ");
        System.out.println(exp.minRowAssignment(array, 2));

        System.out.println();

        System.out.print("Test colMax: \n Expecting: {6 6 8 5} \n Actual: {");
        int [] colMaxs = exp.colMaxs(array);
        for(int i = 0; i < colMaxs.length; i++){
            System.out.print(colMaxs[i] + " ");
        }
        System.out.print("}");

        System.out.println();
        System.out.println();

        System.out.print("Test allRowSum: \n Expecting: {18 9 16} \n Actual: {");
        int [] sum = exp.allRowSums(array);
        for(int i = 0; i < sum.length; i++){
            System.out.print(sum[i] + " ");
        }
        System.out.print("}");

        System.out.println();
        System.out.println();

        System.out.print("Test averageCol: \n Expecting: {3.333333 3.0 4.333333 3.6666667} \n Actual: {");
        double [] avg = exp.averageCol(array);
        for(int i = 0; i < avg.length; i++){
            System.out.print(avg[i] + " ");
        }
        System.out.print("}");

        System.out.println();
        System.out.println();

        System.out.print("Test smallEven: \n Expecting: 0 \n Actual: ");
        System.out.println(exp.smallEven(array));

        System.out.println();
        System.out.println();

        System.out.print("Test biggestRow: \n Expecting: 0 \n Actual: ");
        System.out.println(exp.biggestRow(array));

        System.out.println();
    }
    //WRITE YOUR METHODS BELOW

    public boolean evenRow(int[][] mat, int row) {
        for (int i=0; i<mat[row].length; i++){
            if (mat[row][i]%2 != 0){
                return false;
            }
        }
        return true;
    }

    public boolean oddColSum(int[][] mat, int col){
        int sum = 0;
        for (int i=0; i<mat.length; i++){
            sum += mat[i][col];
        }
        return sum%2 != 0;
    }

    public int[] minRowPractice(int[][] mat) {
        int min = mat[0][0];
        int rowNum = 0;
        for (int i=0; i<mat.length; i++){
            for (int j=0; j<mat[0].length; j++){
                if (mat[i][j] < min){
                    min = mat[i][j];
                    rowNum = i;
                }
            }
        }
        return mat[rowNum];
    }

    public int minRowAssignment(int[][] mat, int row) {
        int min = mat[row][0];
        for (int i=1; i<mat[row].length; i++){
            if (mat[row][i] < min){
                min = mat[row][i];
            }
        }
        return min;
    }
    public int[] colMaxs(int[][] matrix){
        int[] arr = new int[matrix[0].length];
        for (int i=0; i<matrix[0].length; i++){
            int max = matrix[0][i];
            for (int j=0; j<matrix.length; j++){
                if (matrix[j][i] > max){
                    max = matrix[j][i];
                }
            }
            arr[i] = max;
        }
        return arr;
    }
    public int[] allRowSums(int[][] data){
        int[] arr = new int[data.length];
        for (int i=0; i<data.length; i++){
            int sum = 0;
            for (int j=0; j<data[0].length; j++){
                sum += data[i][j];
            }
            arr[i] = sum;
        }
        return arr;
    }
    public double[] averageCol(int[][] nums){
        double[] arr = new double[nums[0].length];
        for (int i=0; i<nums[0].length; i++){
            double avg = 0;
            for (int j=0; j<nums.length; j++){
                avg += nums[j][i];
            }
            avg = avg/nums.length;
            arr[i] = avg;
        }
        return arr;
    }
    public int smallEven(int[][] matrix){
        int min = 2147483646;
        for (int i=0; i<matrix.length; i++){
            for (int j=0; j<matrix[0].length; j++){
                if (matrix[i][j] < min && matrix[i][j]%2 == 0){
                    min = matrix[i][j];
                }
            }
        }
        return min;
    }
    public static int biggestRow(int[][] nums){
        int maxSum = 0;
        int rowIndex = 0;
        for (int i=0; i<nums.length; i++){
            int sum = 0;
            for (int j=0; j<nums[0].length; j++){
                sum += nums[i][j];
            }
            if (i == 0){
                maxSum = sum;
            } else {
                if (sum > maxSum){
                    maxSum = sum;
                    rowIndex = i;
                }
            }

        }
        return rowIndex;
    }
}








