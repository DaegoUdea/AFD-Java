package co.edu.udea.GUIApplets;

import java.awt.*;
import java.util.LinkedList;
import javax.swing.*;

public class CustomTable extends JPanel{

    private JTextField[][] dataTable;
    private JCheckBox[] rowValidation;

    //Constructor
    public CustomTable(int rows, int cols) {       
        setLayout(new GridBagLayout());           
        makeTable(rows+1, cols+1);
        setSize(this.getPreferredSize());
    }
    
    //Función que escribe en la primer fila de la tabla los nombres de los
    // símbolos de entrada del autómata.
    public void setSymbols(String[] symbols){
        for (int i = 1; i < symbols.length + 1; i++){
            dataTable[0][i].setText(symbols[i-1]);
        }
    }
    
    // Función que crea los componentes graficos de la tabla 
    // con sus respectivas dimensiones.
    private void makeTable(int rows, int cols){
        dataTable = new JTextField[rows][cols];
        rowValidation = new JCheckBox[rows - 1];
        GridBagConstraints constraint = new GridBagConstraints();
        
        for (int i = 0; i < rows; i++){
            for (int j = 0; j < cols; j++){
                dataTable[i][j] = new JTextField();
                dataTable[i][j].setHorizontalAlignment(SwingConstants.CENTER);
                dataTable[i][j].setPreferredSize(new Dimension(30,25));
                dataTable[i][j].setMaximumSize(new Dimension(30,25));
                //dataTable[i][j].setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
                
                if(j == 0 || i == 0){
                    if(i == 0 && j ==0){
                        dataTable[i][j].setVisible(false);                  
                    }
                    //dataTable[i][j].setEnabled(false);
                    dataTable[i][j].setFocusable(false);
                    dataTable[i][j].setEditable(false);
                    dataTable[i][j].setText(i-1+"");
                    dataTable[i][j].setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
                    dataTable[i][j].setBackground(Color.GRAY);
                }
                
                if(i == 0){
                    dataTable[i][j].setText(j-1+"");
                    dataTable[i][j].setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
                    dataTable[i][j].setBackground(Color.LIGHT_GRAY);
                }
                
                if(j == cols - 1 && i != 0) {
                    rowValidation[i-1] = new JCheckBox();
                    constraint.gridx = j + 1;
                    constraint.gridy = i;
                    this.add(rowValidation[i-1], constraint);
                }
                constraint.gridx = j;
                constraint.gridy = i;
                this.add(dataTable[i][j],constraint);
            }
        }        
    }

    // Función que retorna un arreglo con los símbolos de entrada del autómata.
    public String[] getSymbols(){
        String[] symbols = new String[dataTable[0].length - 1];
        for (int i = 1; i < dataTable[0].length; i++){
            symbols[i-1] = dataTable[0][i].getText();
        }
        return symbols;
    }
    
    // Función que retorna la cantidad de estados del autómata.
    public int getStateCount(){
        return dataTable.length - 1;
    }
    
    // Función que retorna una matriz con las transiciones del autómata
    // ingresadas por el usuario.
    public int[][] getTransitions(){
        int[][] transitions = new int[dataTable.length-1][dataTable[0].length-1];
        int maxState = getStateCount();
        for (int i = 1; i< dataTable.length;i++){
            for (int j = 1; j < dataTable[i].length; j++){  
                try {
                    transitions[i-1][j-1] = Integer.parseInt(dataTable[i][j].getText());      
                    if(transitions[i-1][j-1] >= maxState || transitions[i-1][j-1] < 0){
                        transitions[i-1][j-1] = -1;
                    }
                } catch (Exception NumberFormatException) {
                    transitions[i-1][j-1] = -1;
                }
            }
        }
        return transitions;
    }
    
    // Función que retorna un arreglo con los estados de aceptación
    // ingresados por el usuario.
    public int[] getValidStates(){
        LinkedList queue = new LinkedList();
        int validStates[];
        for (int i = 0; i < rowValidation.length; i++){ 
            if(rowValidation[i].isSelected()){
                queue.add(i);
            }
        }
        
        int queueSize = queue.size();
        validStates = new int[queueSize];
        for (int i = 0; i < queueSize;i++){
            validStates[i] = (int)queue.pollFirst();
        }
        return validStates;
    }
}
