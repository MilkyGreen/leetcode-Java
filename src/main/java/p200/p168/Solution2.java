package p200.p168;

public class Solution2 {
    public String convertToTitle(int columnNumber) {
        StringBuilder sb = new StringBuilder();

        while (columnNumber > 0) {
            columnNumber--;
            int mod = (columnNumber % 26);
            sb.insert(0, (char)('A' + mod));
            columnNumber = columnNumber / 26;
            
        }
        return sb.toString();
    }
}
