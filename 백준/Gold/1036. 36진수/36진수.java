import java.math.BigInteger;
import java.util.*;
import java.io.*;
import java.util.List;

public class Main {
    static int N,K;
    static BigInteger max;
    static String[] arr;
    static String dchar = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ",str="";
    static Map<Character,BigInteger> dic = new HashMap<Character,BigInteger>();
    static BigInteger thirtysix = new BigInteger("36");
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr= new String[N];
        for (int n=0;n<N;n++){
            arr[n] = br.readLine();
        }
        K = Integer.parseInt(br.readLine());
        //K가 0과 같거나 더 작은 경우에는 입력으로 받은 N개의 수를 모두 더하고 36진수로 바로 변경하도록 작성
        if (K>0){
            // 각 알파벳을 Z로 바꿨을 때 총 합에 얼마나 영향을 끼치는지 확인
            check(arr);
            // 영향을 끼치는 크기순으로 내림차순 정렬하기
            List<Map.Entry<Character,BigInteger>> list = new LinkedList<>(dic.entrySet());
            Collections.sort(list, new Comparator<Map.Entry<Character, BigInteger>>() {
                @Override
                public int compare(Map.Entry<Character, BigInteger> o1, Map.Entry<Character, BigInteger> o2) {
                    return o2.getValue().compareTo(o1.getValue());
                }
            });
            // 영향을 많이 끼치는 알파벳 K개를 str로 받아오기
            int idx =0;
            for (Map.Entry<Character,BigInteger> entry:list){
                if (idx>=K){
                    break;
                } else{
                    Character c = entry.getKey();
                    str+=c;
                    idx++;
                }
            }
        }
        // 모든 수를 더하고 max로 받기
        max = sum(arr);
        
        // 10진수를 36진수로 변경하기
        String answer = change36(max);
        // 36진수값을 역으로 받아왔기 때문에 뒤에서부터 출력
        for (int i=answer.length()-1; i>=0;i--){
            System.out.print(answer.charAt(i));
        }
    }

    // 각 알파벳을 Z로 바꿨을 때 총 합에 얼마나 영향을 끼치는지 확인하는 check 함수
    public static void check(String[] arr){
        BigInteger bnum = new BigInteger("0");
        for(int n=0;n<N;n++){
            for(int j=0;j<arr[n].length();j++){
                BigInteger pow = thirtysix.pow(arr[n].length()-j-1);
                bnum = BigInteger.valueOf(35);
                bnum = bnum.multiply(pow);
                BigInteger original = pow.multiply(BigInteger.valueOf(dchar.indexOf(arr[n].charAt(j))));
                bnum = bnum.subtract(original);
                Character c = arr[n].charAt(j);
                if (!dic.containsKey(c)){
                    dic.put(c,bnum);
                } else{
                    dic.replace(c,dic.get(c).add(bnum));
                }
            }
        }
    }
    
    //모든 수를 10진수로 더하는 함수
    public static BigInteger sum(String[] arr){
        BigInteger result=new BigInteger("0");
        for(int i=0;i<N;i++){
            for(int j=0;j<arr[i].length();j++){
                String c = Character.toString(arr[i].charAt(j));
                // 영향을 많이끼치는 K개 알파벳에 포함되어 있으면 값을 Z(35)로 계산하기
                if (str.contains(c)){
                    BigInteger pow = thirtysix.pow(arr[i].length()-j-1);
                    BigInteger num = pow.multiply(BigInteger.valueOf(35));
                    result=result.add(num);
                }else{
                    BigInteger pow = thirtysix.pow(arr[i].length()-j-1);
                    BigInteger num = pow.multiply(BigInteger.valueOf(dchar.indexOf(c)));
                    result=result.add(num);
                }
            }
        }
        return result;
    }
    
    //10진수를 36진수로 변환하는 함수
    public static String change36(BigInteger num){
        String result= "";
        BigInteger zero = new BigInteger("0");
        // num이 0일 경우 0을 출력할 수 있도록 설정
        if (num.equals(BigInteger.valueOf(0))){
            result +="0";
        }else{
            while (num.compareTo(zero) !=0){
                // remainder == %
                result+= dchar.charAt(num.remainder(thirtysix).intValue());
                num = num.divide(thirtysix);
            }
        }
        return result;
    }
}
