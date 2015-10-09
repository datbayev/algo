import java.util.*;
import java.math.*;
import static java.lang.Math.*;

public class LightSwitchingPuzzle {
    public byte[] flip(byte[] currentState) {
        byte[] result = new byte[currentState.length];
        for (int i = 0; i < currentState.length; i++)
            result[i] = (byte) (1 - currentState[i]);

        return result;
    }

	public int minFlips(String str) {
        int n = str.length();
        byte[] state = new byte[n];
        for (int i = 0; i < n; i++)
            if (str.charAt(i) == 'Y')
                state[i] = 1;
        int ind = 0;
		return 0;
	}

    public void solve() {
        String state = "YNYNYNYNYNYNYN";
    }

    public static void main(String[] args) {
        new LightSwitchingPuzzle().solve();
    }
}
