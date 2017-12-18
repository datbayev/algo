package leetcode;

// https://leetcode.com/problems/judge-route-circle/description/
// 657. Judge Route Circle

class JudgeRouteCircle {
    public boolean judgeCircle(String moves) {
        int x = 0, y = 0;
        
        for (char c : moves.toCharArray()) {
            switch (c) {
                case 'U': 
                    y++;
                    break;
                case 'R': 
                    x++;
                    break;
                case 'D':
                    y--;
                    break;
                case 'L':
                    x--;
                    break;
                default:
                    break;
            }
        }
        
        return x == 0 && y == 0;
    }
}
