package fileio;
import java.io.Console;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class ByteStreamFileIo {
    public static void main(String[] args){
        try{
            String userName = null;
            String password = null;

            Console console = System.console();
            if(console == null){
                System.err.println("No console");
                return;
            }
            System.out.println("Enter user name:");
            userName = console.readLine();

            System.out.println("Enter password:");
            char[] cPassword = console.readPassword();

            password = String.valueOf(cPassword);

            registerUser(userName, password);
        }catch (IOException e){
            System.err.println("File Io Error -" + e.getMessage());
        }
    }

static void registerUser(String userName, String password) throws IOException{
    try (PrintWriter pw = new PrintWriter(new FileWriter("login.txt", true))){
        pw.println(userName + "-"+ password);
        pw.flush();
    }
}
}