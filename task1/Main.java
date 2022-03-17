package task1;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String strN;
        String strM;

        int n ;
        int m ;
        int step;

        boolean bool = true;

        List<int[]> list;
        int[] circularArray;
        int[] arrayStepM;

        strN = args[0];
        strM = args[1];

        step = 1;
        n = Integer.parseInt(strN);
        m = Integer.parseInt(strM);

        list = new ArrayList<>();
        circularArray = new int[n];

        for (int i = 0; i < n; i++) {
            circularArray[i] = i + 1;
        }

        while (bool) {
            arrayStepM = new int[m];
            for (int i = 0; i < m; i++) {
                arrayStepM[i] = step;
                if (i == m-1) {
                    break;
                } else {
                    step++;
                }
                if (step == n+1) {
                    step = 1;
                }
            }
            list.add(arrayStepM);
            if (arrayStepM[m - 1] == 1) {
                bool = false;
            }
        }
        for (int[] i : list) {
            System.out.print(i[0]);
        }
    }
}
