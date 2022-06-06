package NEU.Week04;

public class math_IntToRoman_12 {
    public static void main(String[] args) {
        int x = 3;
        System.out.println(intToRoman(x));
    }
    public static String intToRoman(int num) {
        // 分情况考虑
        String s = "";
        while (num / 1000 >= 1){
            s += "M";
            num -= 1000;
        }
        while (num != 0){
            if (num >= 900){
                s += "CM";
                num -= 900;
            }
            else if (num >= 500){
                s += "D";
                num -= 500;
            }
            else if (num >= 400){
                s += "CD";
                num -= 400;
            }
            else if (num >= 100){
                s += "C";
                num -= 100;
            }
            else if (num >= 90){
                s += "XC";
                num -= 90;
            }
            else if (num >= 50){
                s += "L";
                num -= 50;
            }
            else if (num >= 40){
                s += "XL";
                num -= 40;
            }
            else if (num >= 10){
                s += "X";
                num -= 10;
            }
            else if (num == 9){
                s += "IX";
                num -= 9;
            }
            else if (num >= 5){
                s += "V";
                num -= 5;
            }
            else if (num == 4){
                s += "IV";
                num -= 4;
            }
            else if (num >= 1){
                s += "I";
                num -= 1;
            }
        }
        return s;
 
        int[] values = new int[]{1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String[] str = new String[]{"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        String s = "";
        while (num != 0){
            for (int i = 0; i < values.length; i++) {
                while (num >= values[i]){
                    s += str[i];
                    num -= values[i];
                }
            }
        }
        return s;
    }

}
