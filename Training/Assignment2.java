public class Assignment2 {
    public static void main(String args[]){
    int a=10; int b=20; int c=30;
    {
        System.out.println("The three numbers :" +a+" ,"+b+" ,"+c);
        System.out.println("Largest Number:");
        if (a>b && a>c)
        System.out.println(a);
        else if(b>a && b>c)
        System.out.println(b);
        else
        System.out.println(c);
    }
}
}