import java.util.LinkedList;
import java.util.Queue;

public class dontGetValunteered {
    public static void main(String[] args) {
        System.out.print( solution( 35,21));
    }

    public static int solution(int src, int dest) {
        Queue<Integer> q = new LinkedList<>();
        int row = 0, col =0;
        int destination_row =0, destination_col =0;

        int[][] table = new int[8][8];
        int SrcLocator = 0;
        //Look for source and destination
        for(int i=0; i<table.length; i++) {
            for(int j=0; j<table[i].length; j++) {
                if(SrcLocator == src) {
                    row = i;
                    col = j;
                }
                if(SrcLocator == dest) {
                    destination_row = i;
                    destination_col = j;
                }
                SrcLocator++;
            }
        }

        int originalRow = row, originalCol = col;
        if(src == dest) {
            return 0;
        }

        int[] doIni = {-2,-1,1,2,2,1,-1,-2};
        int[] doInj = {1,2,2,1,-1,-2,-2,-1};
        int counter =1;
        boolean isZero = true;

        while(isZero) {
            //table[col][row]+1;
            for (int i = 0; i < doIni.length; i++) {
                if (i == 0 && row + doIni[i] >= 0 && col + 1 <= 7) {
                    if (table[row + doIni[i]][col + doInj[i]] == 0) {
                        q.add(col + doInj[i]);
                        q.add(row + doIni[i]);
                        table[row + doIni[i]][col + doInj[i]] = table[row][col]+1;
                    }
                }
                if (i == 1 && row + doIni[i] >= 0 && col + doInj[i] <= 7) {
                    if (table[row + doIni[i]][col + doInj[i]] == 0) {
                        q.add(col + doInj[i]);
                        q.add(row + doIni[i]);
                        table[row + doIni[i]][col + doInj[i]] = table[row][col]+1;
                    }
                }
                if (i == 2 && row + doIni[i] <= 7 && col + doInj[i] <= 7) {
                    if (table[row + doIni[i]][col + doInj[i]] == 0) {
                        q.add(col + doInj[i]);
                        q.add(row + doIni[i]);
                        table[row + doIni[i]][col + doInj[i]] = table[row][col]+1;
                    }
                }
                if (i == 3 && row + doIni[i] <= 7 && col + doInj[i] <= 7) {
                    if (table[row + doIni[i]][col + doInj[i]] == 0) {
                        q.add(col + doInj[i]);
                        q.add(row + doIni[i]);
                        table[row + doIni[i]][col + doInj[i]] = table[row][col]+1;
                    }
                }
                if (i == 4 && row + doIni[i] <= 7 && col + doInj[i] >= 0) {
                    if (table[row + doIni[i]][col + doInj[i]] == 0) {
                        q.add(col + doInj[i]);
                        q.add(row + doIni[i]);
                        table[row + doIni[i]][col + doInj[i]] = table[row][col]+1;
                    }
                }
                if (i == 5 && row + doIni[i] <= 7 && col + doInj[i] >= 0) {
                    if (table[row + doIni[i]][col + doInj[i]] == 0) {
                        q.add(col + doInj[i]);
                        q.add(row + doIni[i]);
                        table[row + doIni[i]][col + doInj[i]] = table[row][col]+1;
                    }
                }
                if (i == 6 && row + doIni[i] >= 0 && col + doInj[i] >= 0) {
                    if (table[row + doIni[i]][col + doInj[i]] == 0) {
                        q.add(col + doInj[i]);
                        q.add(row + doIni[i]);
                        table[row + doIni[i]][col + doInj[i]] = table[row][col]+1;
                    }
                }
                if (i == 7 && row + doIni[i] >= 0 && col + doInj[i] >= 0) {
                    if (table[row + doIni[i]][col + doInj[i]] == 0) {
                        q.add(col + doInj[i]);
                        q.add(row + doIni[i]);
                        table[row + doIni[i]][col + doInj[i]] = table[row][col]+1;
                    }
                }
            }
            if(row == originalRow && col == originalCol)
            {
                table[originalRow][originalCol] = 999;
            }

            col= q.remove();
            row = q.remove();

            isZero = false;
            for (int i = 0; i < table.length; i++) {
                for (int j = 0; j < table[i].length; j++) {
                    if (table[i][j] == 0) {
                        isZero = true;
                    }
                }
            }
            counter++;
        }
       return table[destination_row][destination_col];
    }
}
