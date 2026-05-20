class Solution {

    HashMap<Integer, String> ones = new HashMap<>();
    HashMap<Integer, String> tens = new HashMap<>();


    public String numberToWords(int num) {
        if (num == 0) {
            return "Zero";
        }

        ones.put(1, "One");
        ones.put(2, "Two");
        ones.put(3, "Three");
        ones.put(4, "Four");
        ones.put(5, "Five");
        ones.put(6, "Six");
        ones.put(7, "Seven");
        ones.put(8, "Eight");
        ones.put(9, "Nine");
        ones.put(10, "Ten");
        ones.put(11, "Eleven");
        ones.put(12, "Twelve");
        ones.put(13, "Thirteen");
        ones.put(14, "Fourteen");
        ones.put(15, "Fifteen");
        ones.put(16, "Sixteen");
        ones.put(17, "Seventeen");
        ones.put(18, "Eighteen");
        ones.put(19, "Nineteen");

        tens.put(20, "Twenty");
        tens.put(30, "Thirty");
        tens.put(40, "Forty");
        tens.put(50, "Fifty");
        tens.put(60, "Sixty");
        tens.put(70, "Seventy");
        tens.put(80, "Eighty");
        tens.put(90, "Ninety");

        String[] postfix = {"", " Thousand", " Million", " Billion"};
        int i = 0;
        List<String> res = new ArrayList<>();
        while (num > 0) {
            int digits = num % 1000;

            String s = getString(digits);
            if (s.length() > 0) {
                res.add(s + postfix[i]);
            }
            num = num / 1000;
            i++;
        }
        Collections.reverse(res);
        return String.join(" ", res);
    }

    public String getString(int n) {
        List<String> res = new ArrayList<>();
        int hundred = n / 100;
        if (hundred > 0) {
            res.add(ones.get(hundred) + " Hundred");
        }
        int last2 = n % 100;
        if (last2 >= 20) {
            int ten = last2 / 10;
            int one = last2 % 10;
            res.add(tens.get(ten * 10));
            if (one > 0) {
                res.add(ones.get(one));
            }
        }
        else if (last2 > 0) {
            res.add(ones.get(last2));
        }
        return String.join(" ", res);
    }
}