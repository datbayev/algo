public class DecipherabilityEasy {
	
	public String check(String s, String t) {
		if (s.length() != t.length() + 1)
			return "Impossible";

		StringBuilder sb;
		for (int i = 0; i < s.length(); i++) {
			sb = new StringBuilder(s);
			String sub = sb.deleteCharAt(i).toString();
			if (sub.equals(t))
				return "Possible";
		}
		return "Impossible";
	}
}
