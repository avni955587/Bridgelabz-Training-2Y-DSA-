/**  input =     {1,  2,  3,  4,  5,  6},
                 {11, 12, 13, 14, 15, 16},
                 {21, 22, 23, 24, 25, 26},
                 {31, 32 ,33, 34, 35, 36},
                 {41, 42, 43, 44, 45, 46},
                 {51, 52, 53, 54, 55, 56},
 output = 1 2 3 4 5 6 16 26 36 46 56 55 54 53 52 51 41 31 21 11 12 13 14 15  25 35 45 44 43 42 32 22 23 24 34 33
 */

public class SpiralMatrixTraversal 
{
 public static void main(String[] args) {
    int[][] arr = 
                {
                 {1,  2,  3,  4,  5,  6},
                 {11, 12, 13, 14, 15, 16},
                 {21, 22, 23, 24, 25, 26},
                 {31, 32 ,33, 34, 35, 36},
                 {41, 42, 43, 44, 45, 46},
                 {51, 52, 53, 54, 55, 56},
                };
    int left =0;
    int top=0;
    int right = arr[0].length-1;
    int bottom = arr.length-1;
    while(right>=left && top<=bottom)
    {

        // top row 
        for(int i=left;i<=right;i++)
        {
            System.out.print(arr[top][i] +" ");
        }
        top++;

        // right column
        for(int i=top;i<=bottom;i++)
        {
            System.out.print(arr[i][right] +" ");
        }
        right--;

        // bottom row
        if (top <= bottom) 
        {
        for(int i=right;i>=left;i--)
        {
            System.out.print(arr[bottom][i]+" ");
        }
        }
        bottom--;

        //left column
        if (left <= right) 
        {
        for(int i=bottom;i>=top;i--)
        {
            System.out.print(arr[i][left]+" ");
        }
        }
        left++;
    }
 }   
}
