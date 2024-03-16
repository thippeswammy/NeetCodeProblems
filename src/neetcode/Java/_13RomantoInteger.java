package neetcode.Java;

import java.util.HashMap;

public class _13RomantoInteger {
    public static int romanToInt1(String s) {
        String[] val = {"I", "IV", "V", "IX", "X",
                "XL", "L", "XC", "C", "CD", "D", "CM", "M",
        };
        int[] key = {1, 4, 5, 9, 10, 40,
                50, 90, 100, 400, 500, 900, 1000
        };
        int pos = 0;
        int len = s.length();
        int num = 0;
        for (int i = key.length - 1; i >= 0 && pos < len; ) {
            if (pos + 1 < len && (s.charAt(pos) + "" + s.charAt(pos + 1) + "").equals(val[i])) {
                pos += 2;
                num = num + key[i];
                continue;
            }
            if ((s.charAt(pos) + "").equals(val[i])) {
                pos++;
                num = num + key[i];
                continue;
            }
            i--;
        }
        return num;
    }

    public int romanToInt2(String s) {
        HashMap<Character, Integer> h1 = new HashMap<>();
        h1.put('I', 1);
        h1.put('V', 5);
        h1.put('X', 10);
        h1.put('L', 50);
        h1.put('C', 100);
        h1.put('D', 500);
        h1.put('M', 1000);
        char[] alpha = s.toCharArray();
        int num = 0;
        int pt = 0;
        while (pt + 1 <= alpha.length) {
            if (pt == alpha.length - 1 || h1.get(alpha[pt]) >= h1.get(alpha[pt + 1])) {
                num = num + h1.get(alpha[pt]);
                pt = pt + 1;
            } else {
                num = num + h1.get(alpha[pt + 1]) - h1.get(alpha[pt]);
                pt = pt + 2;
            }
        }
        return num;
    }
        public static int romanToInt (String s){
            String[] val = {"I", "IV", "V", "IX", "X",
                    "XL", "L", "XC", "C", "CD", "D", "CM", "M",
            };
            int[] key = {1, 4, 5, 9, 10, 40,
                    50, 90, 100, 400, 500, 900, 1000
            };
            HashMap<String, Integer> h1 = new HashMap();
            h1.put("I", 1);
            h1.put("IV", 4);
            h1.put("V", 5);
            h1.put("IX", 9);
            h1.put("X", 10);
            h1.put("XL", 40);
            h1.put("L", 50);
            h1.put("XC", 90);
            h1.put("C", 100);
            h1.put("CD", 400);
            h1.put("D", 500);
            h1.put("CM", 900);
            h1.put("M", 1000);
            char[] ss = s.toCharArray();
            int pos = 0;
            int len = s.length();
            int num = 0;
            for (int i = key.length - 1; i >= 0 && pos < len; ) {
                if (pos + 1 < len && (ss[pos] + "" + ss[pos + 1]).equals(val[i])) {
                    pos += 2;
                    num = num + key[i];
                    continue;
                }
                if ((ss[pos] + "").equals(val[i])) {
                    pos++;
                    num = num + key[i];
                    continue;
                }
                i--;
            }
            return num;
        }

        public static void main (String[]args){
            int res = romanToInt("MCMXCIV");
            System.out.println(res);
        }
    }
