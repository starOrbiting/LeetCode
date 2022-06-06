package NEU.Week04;

public class math_ExcelNumber_171 {
    public int titleToNumber(String columnTitle) {
        int sum = 0;
        for (int i = 0; i < columnTitle.length(); i++) {
            sum *= 26;
            sum += number(columnTitle.charAt(i));
        }
        return sum;

    }
    public int number(char ch){
        return ch - 'A' + 1;
    }
}
