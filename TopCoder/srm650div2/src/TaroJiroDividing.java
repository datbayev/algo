import java.util.*;
import java.math.*;

import static java.lang.Math.*;

public class TaroJiroDividing {

    public int getNumber(int A, int B) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int res = 0;
        while (A % 2 != 1) {
            if (map.get(A) == null)
                map.put(A, 1);

            A /= 2;
        }
        map.put(A, 1);

        while (B % 2 != 1) {
            if (map.get(B) != null)
                res++;

            B /= 2;
        }
        if (map.get(B) != null)
            res++;

        return res;
    }

    public static void main(String[] args) {
        int res = new TaroJiroDividing().getNumber(7, 4);
        System.out.println(res);
    }
}
