package AboutException;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class LearnException {
    public void testException(int i) throws InvalidInputException{
        if(i<0)
            throw new InvalidInputException("invalid negative integer input");
    }

    public static void main(String[] args) throws InvalidInputException{
        InvalidInputException message = new InvalidInputException("Having message");
        System.out.println(message.getMessage());
        var noMessage = new InvalidInputException();
        System.out.println(noMessage.getMessage());
    }
}
class InvalidInputException extends Exception{
    InvalidInputException(){}
    InvalidInputException(String message){
        super(message);
    }
}

class TestCatch{
    public static void main(String[] args) {
        int[] values = new int[3];
        try{
            int i = values[5];
        }catch(RuntimeException exception){
            /*System.out.println("Exception caught!");
            System.out.println(exception.getMessage());
            System.out.println(exception.getClass().getName());*/
            var out = new StringWriter();
            exception.printStackTrace(new PrintWriter(out));
            System.out.println(out);
        }
        try{
            String s = null;
            s.getBytes(StandardCharsets.UTF_8);
        }catch(Throwable exception){
            exception.printStackTrace();
        }
        try{
            Class cl = Class.forName("MEME");
        }catch(Throwable exception){
            exception.printStackTrace();
        }
    }
}

class TypicalException{
    public static void main(String[] args) {
        try{
            crunch(null);
        }catch(Throwable e){
            StackTraceElement[] arr = e.getStackTrace();
            for (int i = 0; i < arr.length; i++) {
                System.out.println(arr[i].getFileName());
                System.out.println(arr[i].getLineNumber());
                System.out.println(arr[i].getClassName());
                System.out.println(arr[i].getMethodName());
                System.out.println(arr[i]);
                System.out.println("============================");
            }
            StackWalker walker = StackWalker.getInstance();


        }
    }
    static void crunch(int[] a) {
        mash(a);
    }
    static void mash(int[] b) {
        System.out.println(b[0]);
    }
}