package co.edu.udea.AFDBuilder;

public class AFDBuilder implements AbstractAFDBuilder {

    private String code;

    public void beginClass(String className) {

        code = "import java.awt.*;\n"
                + "import java.awt.event.*;\n"
                + "import javax.swing.*;\n"
                + "\n"
                + "public class "+ className +" extends JFrame {\n"
                + "    \n"
                + "    private JTextArea textArea;\n"
                + "    private JButton validateButton;\n"
                + "    private JLabel validationLabel;\n"
                + "    \n"
                + "    public "+ className +"(){\n"
                + "        this.setLayout(new GridBagLayout());\n"
                + "        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);\n"
                + "        this.setSize(new Dimension(400,200));\n"
                + "        textArea = new JTextArea();\n"
                + "        validateButton = new JButton(\"Validar\");\n"
                + "        validationLabel = new JLabel(\"Inserte su secuencia.\");\n"
                + "        GridBagConstraints constraints = new GridBagConstraints();\n"
                + "        \n"
                + "        constraints.fill = GridBagConstraints.BOTH;\n"
                + "        constraints.insets = new Insets(10,10,10,10);\n"
                + "        constraints.gridwidth = 2;\n"
                + "        constraints.weightx = 1;\n"
                + "        constraints.weighty = 1;\n"
                + "        constraints.gridx = 0;\n"
                + "        constraints.gridy = 0;\n"
                + "        this.add(textArea, constraints);\n"
                + "        \n"
                + "        constraints.fill = GridBagConstraints.BOTH;\n"
                + "        constraints.gridwidth = 1;\n"
                + "        constraints.weightx = 0.2;\n"
                + "        constraints.weighty = 0.01;\n"
                + "        constraints.gridx = 0;\n"
                + "        constraints.gridy = 1;\n"
                + "        \n"
                + "        this.add(validateButton, constraints);        \n"
                + "        \n"
                + "        validationLabel.setHorizontalAlignment((int) CENTER_ALIGNMENT);\n"
                + "        constraints.fill = GridBagConstraints.BOTH;\n"
                + "        constraints.weightx = 1;\n"
                + "        constraints.weighty = 0.01;\n"
                + "        constraints.gridx = 1;\n"
                + "        constraints.gridy = 1;\n"
                + "        \n"
                + "        this.add(validationLabel, constraints);\n"
                + "        \n"
                + "        validateButton.addActionListener(new ActionListener() {\n"
                + "\n"
                + "            @Override\n"
                + "            public void actionPerformed(ActionEvent e) {\n"
                + "                validateString();\n"
                + "            }\n"
                + "        });\n"
                + "    }\n"
                + "    \n"
                + "    public void validateString(){\n"
                + "        String stringValue = textArea.getText();\n"
                + "        AFD stateMachine = new AFD();\n"
                + "        stateMachine.checkSequence(stringValue);\n"
                + "        if(stateMachine.isValid()){\n"
                + "            validationLabel.setText(\"Secuencia valida\");\n"
                + "            validationLabel.setForeground(Color.GREEN);\n"
                + "        } else {\n"
                + "            validationLabel.setText(\"Secuencia invalida\");\n"
                + "            validationLabel.setForeground(Color.RED);\n"
                + "        }\n"
                + "    }\n"
                + "    \n"
                + "    public static void main(String[] args){\n"
                + "        "+className+" gui = new "+className+"();\n"
                + "        gui.setVisible(true);\n"
                + "    }    \n";

        code =  code + "\t public class AFD {\n" 
                +"\t\t private int currentState = 0;\n" 
                +"\t\t public void checkSequence(String sequence) {\n" 
                +"\t\t\t int i = 0;\n" 
                +"\t\t\t while (i < sequence.length()) {\n" 
                +"\t\t\t\t switch (currentState) {\n";
    }

    public void addCase(int state, int[] transitions, String[] symbols) {
        code = code + "\t\t\t\t\t case " + state + ": \n"
                + "\t\t\t\t\t\t switch(sequence.charAt(i)){ \n";
        int j = 0;
        while (j < symbols.length) {
            code = code + "\t\t\t\t\t\t\t case '" + symbols[j] + "': \n"
                    + "\t\t\t\t\t\t\t\t currentState = " + transitions[j] + "; \n"
                    + "\t\t\t\t\t\t\t\t break; \n";
            j++;
        }
        code = code +"\t\t\t\t\t\t default:\n"
                +"\t\t\t\t\t\t\t currentState = -1;\n"
                + "\t\t\t\t\t\t\t break;\n"
                +"\t\t\t\t\t\t } \n"
                + "\t\t\t\t\t\t break; \n";
    }

    public void endCases() {
        code = code + "\t\t\t\t\t default: \n"
                + "\t\t\t\t\t\t currentState = -1; \n"
                + "\t\t\t\t\t\t break; \n"
                + "\t\t\t\t } \n"
                + "\t\t\t\t i++; \n"
                + "\t\t\t } \n"
                + "\t\t } \n";
    }

    public void makeValidation(int[] validStates) {
        code = code + "\t\t public boolean isValid(){ \n";
        for (int i = 0; i < validStates.length; i++) {
            code = code + "\t\t\t if(" + validStates[i] + " == currentState){ \n"
                    + "\t\t\t\t return true; \n"
                    + "\t\t\t } \n";
        }
        code = code + "\t\t\t return false; \n"
                + "\t\t } \n";
    }

    public String getCode() {
        code = code + "\t}\n"
                + "}";
        return code;
    }    
}
