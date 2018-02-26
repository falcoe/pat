import java.util.ArrayList;


class aplusbformat{
    public static void main(String[] args) {
        System.out.println(format(666,-99999999));
    }
    public static String format(int a, int b){
        int c = 0;
        c = a + b;
        //
        int count = 0;
        char[] sb = Integer.toString(c).toCharArray();
        StringBuilder re = new StringBuilder();
        for (int i = sb.length-1; i >= 0; i--) {
            re.append(sb[i]);
            count++;
            if(count%3 == 0 && i!=1){
                re.append(",");
                
                count = 0;
            }
        }
        re.reverse();
        /*
        String result = Integer.toString(c);
        a = result.length()/3;
        b = result.length()%3;
        StringBuilder sBuilder = new StringBuilder();
        for(int i=0; i<b; i++){
            sBuilder.append(result.charAt(i));
        }
        
        for(int i=0; i< a; i++){
            if(sBuilder.length()!=0){
                sBuilder.append(',');
            }
            for (int j=0; j<3; j++) {
                int position = (i-0)*3+b+j;
                sBuilder.append(result.charAt(position));
            }
        }
        return sBuilder.toString();
        */

        return re.toString();
    }
}