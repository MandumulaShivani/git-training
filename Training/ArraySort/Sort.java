package ArraySort;
import java.util.Arrays;
public class Sort{
public static void main(String[] args){
    int[] arrayNumbers; 
    arrayNumbers = new int [6];
    arrayNumbers [0] = 10;
    arrayNumbers [1] = 36;
    arrayNumbers [2]= 14;
    arrayNumbers [3] = 27;
    arrayNumbers [4] = 43;
    arrayNumbers [5] = 18;
    Arrays.sort (arrayNumbers);
    int i;
    for (i=0; i <arrayNumbers.length; i++) { 
        System.out.println("numbers:" + arrayNumbers [i]);
    }
}
}