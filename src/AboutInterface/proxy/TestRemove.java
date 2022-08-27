package AboutInterface.proxy;

import java.util.List;

public class TestRemove {
    public static void main(String[] args) {
        ProxyArrayList<String> upperLetters = new ProxyArrayList<>(List.of("A","B","C","B","A","B","C","A"));

        upperLetters.remove("A");
        System.out.println(upperLetters);

    }
}
