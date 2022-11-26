package AboutInterface.StrategyPatterns;

public class FilterAdapter implements Processor{
    private Filter filter;
    FilterAdapter(Filter filter){
        this.filter = filter;
    }

    @Override
    public String getProcessName() {
        return filter.getFilterName();
    }

    @Override
    public Waveform process(Object input) {
        return filter.process((Waveform) input);
    }
}

