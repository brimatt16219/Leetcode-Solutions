class Solution {
    public int numDifferentIntegers(String word) {

        HashMap<String, Integer> map = new HashMap<String, Integer>();
        
        String[] str = word.split("[a-z]+");

        if (str.length == 1) return 1;
        int iter = 0;

        //print(str);

        for (int i = 0; i < str.length; i++) {
            if (str[i].equals("")) continue;
            //System.out.println(Integer.parseInt(str[i]));
            //str[i] = str[i].substring(str[i].indexOf("[1-9]"));
            str[i] = str[i].replaceAll("^0+(?!$)", "");

            
            if (map.containsKey(str[i])) continue;
            else {
                map.put(str[i], iter);
                iter ++;
            }


        }
        
        return map.size();
    }

    void print(String[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}