import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        
//        int[][] arr  = new int[][]{
//                {15, -66, -18, 99},
//                {-80, -36, 90, -10},
//                {-59, -37, 82, -33},
//                {-15, 26, 61, -2}
//        };

//Expected Output:
//[[-80,-66,-59,-33],
//[99,-37,-36,-18],
//[61,90,82,-15],
//[26,15,-2,-10]]

//        int[][] arr = new int[][] {
//                {-100,-100},
//                {-100, -100}
//        };

//Expected Output:
//[[-100,-100],
//[-100,-100]]

        int[][] arr = new int[][]{
                {9, 4},
                {6, 8}
        };

//Expected Output:
//[[4,6],
//[9,8]]

        int[][] res = borderSort(arr);

        System.out.println("Done");

    }

    public static int[][] borderSort( int[][] arr ){

        int rowStart = 0;
        int rowEnd = arr.length-1;

        int colStart = 0;
        int colEnd = arr[0].length-1;

        List<Integer> list = new ArrayList<>();

        while(rowStart <= rowEnd && colStart <= colEnd) {

            //
            for(int i = colStart ; i <= colEnd ; i++) {

                list.add(arr[rowStart][i]);
            }

            int oldRowStart = rowStart;
            rowStart++;

            for(int i = rowStart ; i <= rowEnd ; i++) {

                list.add(arr[i][colEnd]);
            }

            int oldColEnd = colEnd;
            colEnd--;

            //this is put here for if statement.
            int oldRowEnd = -1;
            //if(rowEnd >= rowStart) {

                for (int i = colEnd; i >= colStart; i--) {

                    list.add(arr[rowEnd][i]);
                }

                oldRowEnd = rowEnd;
                rowEnd--;

            //}

            //this is put here for if statement.
            int oldColStart = -1;
            //if(colStart <= colEnd) {

                for (int i = rowEnd; i >= rowStart; i--) {

                    list.add(arr[i][colStart]);
                }

                oldColStart = colStart;
                colStart++;

            //}

            //sort and write back to matrix

            //not usr eif i need this if statement
            //if(oldColStart!=-1 && oldRowEnd!=-1) {


                Collections.sort(list);

                int index = 0;

                for (int i = oldColStart; i <= oldColEnd; i++) {

                    arr[oldRowStart][i] = list.get(index++);

                }

                oldRowStart++;

                for (int i = oldRowStart; i <= oldRowEnd; i++) {

                    arr[i][oldColEnd] = list.get(index++);

                }

                oldColEnd--;

                for (int i = oldColEnd; i >= oldColStart; i--) {

                    arr[oldRowEnd][i] = list.get(index++);

                }

                oldRowEnd--;

                for (int i = oldRowEnd; i >= oldRowStart; i--) {

                    arr[i][oldColStart] = list.get(index++);

                }

                oldColStart++;

                list.clear();
                // end of writing back to arr
            
            //}

        }

        return arr;


    }

}
