public class TheKingsArmyDiv2 {
    public int getNumber(String[] state) {
        boolean atLeastOneHappy = false;

        for (int i = 0; i < state.length; i++) {
            String s = state[i];

            for (int j = 0; j < s.length(); j++) {
                if (s.charAt(j) == 'H') {
                    atLeastOneHappy = true;
                    if (j < s.length() - 1 && s.charAt(j+1) == 'H') {
                        return 0;
                    } else if (j > 0 && s.charAt(j-1) == 'H') {
                        return 0;
                    } else if (i > 0 && state[i-1].charAt(j) == 'H') {
                        return 0;
                    } else if (i < state.length - 1 && state[i+1].charAt(j) == 'H') {
                        return 0;
                    }
                }
            }
        }

        return atLeastOneHappy ? 1 : 2;
    }
}
