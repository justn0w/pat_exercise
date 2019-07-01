import java.util.*;
import java.math.BigInteger;

public class Cal {
    private BigInteger number;
    private ArrayList<Integer> list = new ArrayList<Integer>();
    private Map<Integer, String> dict = new HashMap<Integer, String>();
    private String[] han = {"ling", "yi", "er", "san", "si", "wu", "liu", "qi", "ba", "jiu"};
    public Cal(BigInteger number){
        this.number = number;
    }

    public int getadd(){
        BigInteger sum=BigInteger.ZERO;
        while(this.number != BigInteger.ZERO){
            sum = sum.add(this.number.mod(BigInteger.TEN));//大数相加
            number = number.divide(BigInteger.TEN);
        }
        return sum.intValue();
    }

    public Map<Integer, String> getDict(){
        int i = 0;
        for (String s : han) {
            dict.put(i, s);
            i++;
        }

        return dict;
    }

    public void getItem(){
        int sum = this.getadd();
        int temp;
        while(sum!=0){
            temp = sum % 10;
            this.list.add(temp);
            sum = sum / 10;
        }
    }

    public String result(){
        String result = "";
        Collections.reverse(this.list);
        int i=0;

        for (int n : list) {
            i++;
            if(list.size()==i) {
                result += dict.get(n);
            } else {
                result += dict.get(n) + " ";
            }

        }
        return result;
    }
}