package AboutException.ErrorExample;

import java.util.ArrayList;

public class OutOfMemoryError {
    private class Student{
        private byte[] arr = new byte[1024*1024];
    }

    public static void main(String[] args) {
        ArrayList<Student> list = new ArrayList<>();
        while(true){
            try {
                list.add(new OutOfMemoryError().new Student());

            }catch(Error error){
                error.printStackTrace();
                break;
            }
        }
        int[] another = new int[1024*1024];
    }
}

