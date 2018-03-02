import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.nio.Buffer;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

/**
 * 1009. Product of Polynomials (25)
 * This time, you are supposed to find A*B where A and B are two polynomials.

 * Input Specification:

 * Each input file contains one test case. Each case occupies 2 lines, and each line
 * contains the information of a polynomial: K N1 aN1 N2 aN2 ... NK aNK, where K is
 * the number of nonzero terms in the polynomial, Ni and aNi (i=1, 2, ..., K) are the
 * exponents and coefficients, respectively. It is given that
 * 1 <= K <= 10, 0 <= NK < ... < N2 < N1 <=1000.

 * Output Specification:

 * For each test case you should output the product of A and B in one line, with the
 * same format as the input. Notice that there must be NO extra space at the end of
 * each line. Please be accurate up to 1 decimal place.

 * Sample Input
 * 2 1 2.4 0 3.2
 * 2 2 1.5 1 0.5
 * Sample Output
 * 3 3 3.6 2 6.0 1 1.6
 */

 class productofpolynomials{
    public static void main(String[] args) {
        String fileName = "productofpolynomials.txt";
        int SUB_STRING_LEN = 2;
        String line = "";
        String firstLine[],secondLine[];
        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1,Integer o2){
                return o2.compareTo(o1);
            }
        };
        Map<Integer,Float> sMap = new HashMap<Integer,Float>();
        try {
            BufferedReader in = new BufferedReader(new FileReader(fileName));
            line = in.readLine();
            if(line != null){
                firstLine = line.substring(SUB_STRING_LEN).split(" ");
                for (int i = 0; i < firstLine.length; i+=2) {
                    int key = Integer.parseInt(firstLine[i]);
                    float value = Float.parseFloat(firstLine[i+1]);
                    sMap.put(key,value);
                }
            }
            line = in.readLine();
            Map<Integer,Float> tMap = new TreeMap<Integer,Float>(comparator);
            if(line != null){
                secondLine = line.substring(SUB_STRING_LEN).split(" ");
                for (int curKey : sMap.keySet()) {
                    for (int i = 0; i < secondLine.length; i+=2){
                        int key = Integer.parseInt(secondLine[i]);
                        float value = Float.parseFloat(secondLine[i+1]);
                        int sumKey = curKey + key;
                        float sumValue = sMap.get(curKey) * value;
                        if (tMap.containsKey(sumKey)) {
                            tMap.put(sumKey, sumValue+tMap.get(sumKey));
                        }else{
                            //sMap.put(sumKey, sumValue);
                            tMap.put(sumKey, sumValue);
                        }
                        //tMap.put(sumKey, (tMap.containsKey(sumKey))?tMap.put(sumKey, sumValue+tMap.get(sumKey)):tMap.put(sumKey, sumValue));
                    }
                }
            }
            in.close();
            StringBuilder sb = new StringBuilder();
            sb.append(tMap.size());
            for (int key : tMap.keySet()){
                sb.append(" "+key+" "+String.format("%.1f", tMap.get(key)));
            }
            System.out.println(sb.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}