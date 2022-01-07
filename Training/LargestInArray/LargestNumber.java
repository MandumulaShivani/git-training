package LargestInArray;

public class LargestNumber {
    public static void main(String args[]) {
        int array[] = { 66, 45, 88, 22, 2, 7 };
        int temp = array[0];
        for (int i = 0; i < array.length; i++) {
            if (array[i] > temp)
                temp = array[i];
        }
        System.out.println("Largest Number in the array is:" + temp);
    }
}