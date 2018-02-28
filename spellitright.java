/**
 * 
 * 1005. Spell It Right (20)
 * Given a non-negative integer N, your task is to compute the sum of all the digits
 * of N, and output every digit of the sum in English.

 * Input Specification:
 * Each input file contains one test case. Each case occupies one line which contains
 * an N (<= 10100).

 * Output Specification:
 * For each test case, output in one line the digits of the sum in English words. There must be one space between two consecutive words, but no extra space at the end of a line.

 * Sample Input: 12345
 * Sample Output: one five
 */

import java.util.HashMap;

class spellitright{
    public static void main(String[] args) {
        //Calculate sum
        int given = 123456;
        int given_copy = given;
        int result = 0;
        while(given_copy/10 != 0){
            result += given_copy%10;
            given_copy = given_copy/10;
        }
        result += given_copy;

        //Prepare dictionary
        HashMap<Integer,String> translateMap = new HashMap<Integer,String>();
        translateMap.put(1,"one");
        translateMap.put(2,"two");
        translateMap.put(3,"three");
        translateMap.put(4,"four");
        translateMap.put(5,"five");
        translateMap.put(6,"six");
        translateMap.put(7,"seven");
        translateMap.put(8,"eight");
        translateMap.put(9,"nine");

        //Translate int to string
        int[] words = new int[String.valueOf(given).length()];
        int counter = 0;
        while(result/10 != 0){
            words[counter] = result%10;
            result = result/10;
            counter++;
        }
        words[counter] = result%10;
        for (int i = words.length-1; i >=0; i--) {
            if (words[i]>0) {
                System.out.print(translateMap.get(words[i]));
            }
            if(i==0){
                break;
            }
            if (words[i]>0){
                System.out.print(" ");
            }
        }
        System.out.println();
    }
}