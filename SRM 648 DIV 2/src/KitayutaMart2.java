import java.util.*;
import java.math.*;
import static java.lang.Math.*;

public class KitayutaMart2 {

	public int numBought(int K, int T) {
		int x = T / K + 1;
		int total = 0;
		while (x > 1) {
			total++;
			x /= 2;
		}
		return total;
	}
}
