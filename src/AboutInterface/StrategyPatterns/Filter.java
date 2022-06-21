package AboutInterface.StrategyPatterns;


public class Filter {
    public String getFilterName(){
        return getClass().getSimpleName();
    }
    public Waveform process(Waveform input){
        return input;
    }
}
class LowPass extends Filter{
    double cutoff;
    public LowPass(double cutoff){
        this.cutoff = cutoff;
    }

    @Override
    public Waveform process(Waveform input) {
        return input;
    }
}
class HighPass extends Filter{
    double cutoff;
    public HighPass(double cutoff) {
        this.cutoff = cutoff;
    }
    @Override
    public Waveform process(Waveform input) {
        return input;
    }
}
class BandPass extends Filter{
    double lowCutoff,highCutoff;
    public BandPass(double lowCut,double highCut){
        lowCutoff = lowCut;
        highCutoff = highCut;
    }
    @Override
    public Waveform process(Waveform input) {
        return input;
    }
}


