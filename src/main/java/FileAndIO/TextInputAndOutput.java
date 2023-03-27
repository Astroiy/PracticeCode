package FileAndIO;

import java.io.*;
import java.net.URI;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Stream;

public class TextInputAndOutput {

    private static class keyStrokeInput{
        public static void main(String[] args) throws IOException {
            while(true){
                InputStreamReader reader = new InputStreamReader(System.in);
                int read = reader.read();
                System.out.println(read);
            }
        }
    }

    private static class tryReadBin{
        public static void main(String[] args) throws IOException {
            FileInputStream inputStream = new FileInputStream(System.getProperty("user.dir") + "/IOPractice/binaryData.bin");
            InputStreamReader reader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
            System.out.println((char)reader.read());
        }
    }

    private static class tryOutputStreamWriter{
        public static void main(String[] args) {
            try(OutputStreamWriter writer = new OutputStreamWriter(
                    new FileOutputStream(System.getProperty("user.dir")+"/IOPractice/binaryData.bin"),
                    StandardCharsets.UTF_8
            )){
                writer.write("name");
                writer.write(System.getProperty("line.separator"));
                writer.write("你是一只猪");
                writer.flush();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private static class tryPrintWriter{
        public static void main(String[] args) throws IOException {
            try(PrintWriter writer = new PrintWriter(
                    System.getProperty("user.dir") + "/IOPractice/printwriter.text",
                    StandardCharsets.UTF_8)){
                String name = "TinyChou";
                Integer age = 21;
                List<Float> grades = Arrays.asList(91f,94.5f,88.5f,61f);
                writer.print(name);
                writer.print(" ");
                PrintWriter printWriter = new PrintWriter(writer, true);
                printWriter.println(age);
                printWriter.print(grades);
                boolean checkError = printWriter.checkError();
                System.out.println(checkError);
            }
        }
    }

    private static class readTextInput{
        public static void main(String[] args) throws IOException {
            Path path = Paths.get(System.getProperty("user.dir") + "/itcast/user.txt");
            byte[] allBytes = Files.readAllBytes(path);
            String result = new String(allBytes);
            System.out.println(result);
        }
    }

    private static class readTextInput1{
        public static void main(String[] args) throws IOException {
            Path path = Paths.get(System.getProperty("user.dir") + "/itcast/user.txt");
            List<String> strings = Files.readAllLines(path, StandardCharsets.UTF_8);
            System.out.println(strings);

            //惰性处理文件行
            Stream<String> lines = Files.lines(path, StandardCharsets.UTF_8);
            lines.forEach(System.out::println);
        }
    }

    private static class readTextToken{
        public static void main(String[] args) throws IOException {
            Path path = Paths.get(System.getProperty("user.dir") + "/itcast/user.txt");
            Scanner in = new Scanner(path, StandardCharsets.UTF_8);
            in.useDelimiter("\\PL+");

        }
    }

    private static class readKeyStrokeByDifferentDelimiter{
        public static void main(String[] args) {
            Scanner in = new Scanner(System.in);
            //使用自定义分隔符从控制台读取内容
            in.useDelimiter("\\PL+");
            Stream<String> tokens = in.tokens();
            System.out.println(tokens);
        }
    }

    private static class learnCharsetEncoding{
        public static void main(String[] args) {
            Charset charset = Charset.defaultCharset();
            System.out.println(charset);
            SortedMap<String, Charset> stringCharsetSortedMap = Charset.availableCharsets();
            System.out.println(stringCharsetSortedMap);
        }
    }
}
