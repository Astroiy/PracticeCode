package LearnStream;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.function.Function;

public class SplitQuestion {
    public static void main(String[] args) throws IOException {
        String contents = Files.readString(Paths.get("src\\LearnStream\\alice30.txt"), StandardCharsets.UTF_8);

        String[] split = contents.split("\\PL+");
        for(int i=0;i<20;i++){
            System.out.println(split[i]);
        }
    }
}
