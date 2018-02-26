/*
    1002. A+B for Polynomials (25)

This time, you are supposed to find A+B where A and B are two polynomials.
Input:
    Each input file contains one test case. Each case occupies 2 
    lines, and each line contains the information of a polynomial:
     K N1 aN1 N2 aN2 ... NK aNK, where K is the number of nonzero 
     terms in the polynomial, Ni and aNi (i=1, 2, ..., K) are the
      exponents and coefficients, respectively. It is given that
       1 <= K <= 10，0 <= NK < ... < N2 < N1 <=1000.

Output:
For each test case you should output the sum of A and B in one line,
 with the same format as the input. Notice that there must be NO 
 extra space at the end of each line. Please be accurate to 1 decimal place.

Sample Input
2 1 2.4 0 3.2
2 2 1.5 1 0.5
Sample Output
3 2 1.5 1 2.9 0 3.2
*/
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import com.sun.javafx.collections.MappingChange;
class aplusbpolynomials{
    public static void main(String[] args) {
        String filename = "aplusbpolynomials.txt";
        int SUB_STRING_LEN = 2;
        String line = "";
        Comparator<Integer> keyComparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1,Integer o2){
                return o2.compareTo(o1);
                //return o1.compareTo(o2);
            }
        };   
        Map<Integer,Float> sMap = new TreeMap<Integer,Float>(keyComparator);
        try {
            BufferedReader in = new BufferedReader(new FileReader(filename));
            line = in.readLine();
            while(line != null){
                String s[] = line.substring(SUB_STRING_LEN).split(" ");
                for (int i = 0; i < s.length; i+=2) {
                    int key = Integer.parseInt(s[i]);
                    float value = Float.parseFloat(s[i+1]);
                    if(sMap.containsKey(key)){
                        value += sMap.get(key);
                    }
                    sMap.put(key,value);
                }
                line = in.readLine();
            }
            in.close();
        StringBuilder sb = new StringBuilder();
        sb.append(sMap.size());
        for (int key : sMap.keySet()) {
            sb.append(" "+key+" "+sMap.get(key));
        }
        System.out.println(sb.toString());
        //throw new IOException("Bad file path");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}