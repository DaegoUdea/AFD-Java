package co.edu.udea.AFDBuilder;

public class AFDDirector {
    private AbstractAFDBuilder builder;
    private int maxState;
    private String[] symbols;
    private int[][] transitions;
    private int[] validStates;
    
    public AFDDirector(AbstractAFDBuilder builder) {
        this.builder = builder;
    }

    public void buildAFD(String className) {
        if (builder instanceof AFDBuilder) {
            startAFDBuilder(className);
        }
    }
    
    public void setData(int maxState, String[] symbols, int[][] transitions, int[] validStates){
        this.maxState = maxState;
        this.symbols = symbols;
        this.transitions = transitions;
        this.validStates = validStates;
    }
    
    private void startAFDBuilder(String className){
            AFDBuilder concreteBuilder = (AFDBuilder)builder;            
            concreteBuilder.beginClass(className);
            
            for(int i = 0; i < maxState; i++){
                concreteBuilder.addCase(i, transitions[i], symbols);
            }            
            concreteBuilder.endCases();
            concreteBuilder.makeValidation(validStates);
            builder = concreteBuilder;
    }
    
    public String getProgramCode(){
        return builder.getCode();
    }
}
