package NEU.Week04;

public class math_RomanInteger_13 {
    public static void main(String[] args) {
        String s = "MCMXCIV";
        System.out.println(romanToInt(s));
    }
    public static int romanToInt(String s) {
        // 遍历
        // [i]<[i+1],sum-=[i]
        // else: sum+=[i]
        int sum = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            if (priority(s.charAt(i)) < priority(s.charAt(i + 1))){
                sum -= priority(s.charAt(i));
            }
            else {
                sum += priority(s.charAt(i));
            }
        }
        sum += priority(s.charAt(s.length() - 1));
        return sum;

    }
    public static int priority(char ch){
        if (ch == 'I'){
            return 1;
        }
        else if (ch == 'V'){
            return 5;
        }
        if (ch == 'X'){
            return 10;
        }
        else if (ch == 'L'){
            return 50;
        }
        if (ch == 'C'){
            return 100;
        }
        else if (ch == 'D'){
            return 500;
        }
        else{
            return 1000;
        }

    }
}
