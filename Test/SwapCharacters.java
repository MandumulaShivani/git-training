public class SwapCharacters{
    public static void main(String[] args){
        String s = "rabbit";
        System.out.println(swap(s, 1, s.length()-3));
    }
    public static String swap(String s, int i, int j){
        char[] c = s.toCharArray();
        char temp = c[i];
        c[i] = c[j];
        c[j] = temp;
        return new String(c);
    }
}