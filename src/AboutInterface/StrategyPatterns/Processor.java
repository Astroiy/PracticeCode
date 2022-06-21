package AboutInterface.StrategyPatterns;

import java.util.Arrays;

public interface Processor{
    default String getProcessName(){
        return getClass().getSimpleName();
    }
    Object process(Object input);
}

interface StringProcessor extends Processor{
    @Override
    String process(Object input);
}

class Uppercase implements StringProcessor{

    @Override
    public String process(Object input) {
        return ((String)input).toUpperCase();
    }
}

class Lowercase implements StringProcessor{
    @Override
    public String process(Object input) {
        return ((String)input).toLowerCase();
    }
}

class Splitter implements StringProcessor{
    @Override
    public String process(Object input) {
        return Arrays.toString(((String)input).split(" "));
    }
}



