package CollectionsLearn.Sets;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.util.*;

public class SetTest {
    public static void main(String[] args) {
        Scanner in0 = new Scanner(System.in);
        System.out.println("Enter url: ");
        String url = in0.nextLine();
        var words = new HashSet<String>();
        long totalTime = 0;
        try(var in = new Scanner(Path.of(url),StandardCharsets.UTF_8))
        {
            while(in.hasNext()){
                String word = in.next();
                long callTime = System.currentTimeMillis();
                words.add(word);
                callTime = System.currentTimeMillis()-callTime;
                totalTime+=callTime;
            }
        }catch(IOException e){
            e.printStackTrace();
        }

        Iterator<String> iTer = words.iterator();
        for(int i=0; i<20 && iTer.hasNext();i++){
            System.out.println(iTer.next());
        }
        System.out.println("...");
        System.out.println(words.size()+" distinct words. "+totalTime+" milliseconds");

    }

}
