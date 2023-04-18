package FileAndIO;

import java.io.*;

public class DataIO {

    private DataIO(){}
    public static void writeFixedString(String s, int size, DataOutput out) throws IOException {
        for (int i = 0; i < size; i++) {
            char ch = 0;
            if(i<s.length())
            {
                ch = s.charAt(i);
            }
            out.writeChar(ch);
        }
    }

    public static String readFixedString(int size,DataInput in) throws IOException {
        StringBuilder builder = new StringBuilder(size);
        boolean done = false;
        int i = 0;

        while(!done && i<size){
            char c = in.readChar();
            i++;
            if(c==0){
                done = true;
            }else{
                builder.append(c);
            }
        }
        in.skipBytes(2 * (size - i));
        return builder.toString();

    }
}

