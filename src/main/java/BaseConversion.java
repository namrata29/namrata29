/**
 * conversion base to binary
 */
public class BaseConversion {

    //decimal to binary
    public void decimalToBinary(){
        int number = 99;

        StringBuilder sb = new StringBuilder();
        int result = 0;

        while(number!=0){
            result = number % 2;
            number = number / 2;
            sb.append(result);
        }
        System.out.println( sb.reverse());
     }


    //binary to decimal

    public  void binaryTodecimal(){
        int binary = 10101;

        int result = 0;
        int base = 1;
        while(binary!=0){
            int val = binary % 10;
            if(val != 0)
                result = result + base * val;
            binary = binary / 10;
            base = base*2;
        }
        System.out.println(result);

    }

    public static void main(String[] args) {
        BaseConversion baseConversion = new BaseConversion();
        baseConversion.decimalToBinary();
        baseConversion.binaryTodecimal();
    }

}
