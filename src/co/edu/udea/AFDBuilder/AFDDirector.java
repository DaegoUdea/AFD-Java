package co.edu.udea.AFDBuilder;

public class AFDDirector {
    private AbstractAFDBuilder builder;
    private int maxState;
    private String[] symbols;
    private int[][] transitions;
    private int[] validStates;
    
    //Constructor
    public AFDDirector(AbstractAFDBuilder builder) {
        this.builder = builder;
    }

    //Función que detecta el tipo de instancia con la cual se creará el autómata. 
    public void buildAFD(String className) {
        if (builder instanceof AFDBuilder) {
            startAFDBuilder(className);
        }
    }
    
    //Función con la cual se obtienen los datos necesarios para la creación del autómata.
    public void setData(int maxState, String[] symbols, int[][] transitions, int[] validStates){
        this.maxState = maxState;
        this.symbols = symbols;
        this.transitions = transitions;
        this.validStates = validStates;
    }
    
    //Función que crea el autómata mediante la instancia de la clase AFDBuilder.
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
    
    //Función que retorna el código del programa.
    public String getProgramCode(){
        return builder.getCode();
    }
}
