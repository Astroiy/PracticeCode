package LearnMaps;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Scanner;

public class MapAndMerge {
    public static void main(String[] args) {
        System.out.println("Enter text url: ");
        Scanner in = new Scanner(System.in);
        String url = in.nextLine();
        HashMap<String,Integer> counts = new HashMap<>();
        try(var readFile = new Scanner(Path.of(url),StandardCharsets.UTF_8)){
            while(readFile.hasNext()){
                String s = readFile.next().toLowerCase().replaceAll("[,.?!:”“_]","");
                counts.merge(s,1,Integer::sum);
            }
        }catch (IOException e){
            e.printStackTrace();
        }
        counts.forEach((k,v)-> System.out.println("words: "+k+" counts: "+v));
    }
}
