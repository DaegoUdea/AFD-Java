package co.edu.udea.practice1afd;

import co.edu.udea.AFDBuilder.*;
import co.edu.udea.GUIApplets.*;
import java.awt.*;
import java.io.*;
import java.util.logging.*;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

public class UserFrame extends javax.swing.JFrame {

    private CustomTable customTable = null;

    public UserFrame() {
        initComponents();
        symbolList.setModel(new DefaultListModel());
        DefaultListCellRenderer listRenderer = (DefaultListCellRenderer) symbolList.getCellRenderer();
        listRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        this.setPreferredSize(new Dimension(800, 600));
        ImageIcon icon = new ImageIcon(getClass().getResource("/co/edu/udea/IMG/logo.gif"));
        this.setIconImage(icon.getImage());
        pack();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        leftPanel = new javax.swing.JPanel();
        stateLabel = new javax.swing.JLabel();
        makeTableButton = new javax.swing.JButton();
        stateLength = new javax.swing.JSpinner();
        jScrollPane1 = new javax.swing.JScrollPane();
        symbolList = new javax.swing.JList();
        symbolChar = new javax.swing.JTextField();
        symbolLabel = new javax.swing.JLabel();
        addSymbolButton = new javax.swing.JButton();
        deleteSymbolsButton = new javax.swing.JButton();
        mainPanel = new javax.swing.JScrollPane();
        bottomPanel = new javax.swing.JPanel();
        makeProgram = new javax.swing.JButton();
        exitButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("AFDMaker");
        setLocationByPlatform(true);
        setMinimumSize(new java.awt.Dimension(300, 200));
        getContentPane().setLayout(new java.awt.GridBagLayout());

        leftPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        stateLabel.setText("Estados:");

        makeTableButton.setText("Crear");
        makeTableButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                makeTableButtonActionPerformed(evt);
            }
        });

        stateLength.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(2), Integer.valueOf(2), null, Integer.valueOf(1)));

        symbolList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        symbolList.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jScrollPane1.setViewportView(symbolList);

        symbolChar.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        symbolChar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                symbolCharActionPerformed(evt);
            }
        });
        symbolChar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                symbolCharKeyTyped(evt);
            }
        });

        symbolLabel.setText("Simbolo:");

        addSymbolButton.setText("Añadir");
        addSymbolButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addSymbolButtonActionPerformed(evt);
            }
        });

        deleteSymbolsButton.setText("Borrar");
        deleteSymbolsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteSymbolsButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout leftPanelLayout = new javax.swing.GroupLayout(leftPanel);
        leftPanel.setLayout(leftPanelLayout);
        leftPanelLayout.setHorizontalGroup(
            leftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(leftPanelLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(leftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(makeTableButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(leftPanelLayout.createSequentialGroup()
                        .addGroup(leftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(leftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(symbolLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
                                .addComponent(stateLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(addSymbolButton))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(leftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(stateLength)
                            .addComponent(symbolChar, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(deleteSymbolsButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        leftPanelLayout.setVerticalGroup(
            leftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(leftPanelLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(leftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(stateLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(stateLength, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(leftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(symbolChar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(symbolLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(leftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addSymbolButton)
                    .addComponent(deleteSymbolsButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 169, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(makeTableButton, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10))
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 10;
        gridBagConstraints.ipady = 10;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        getContentPane().add(leftPanel, gridBagConstraints);

        mainPanel.setViewportBorder(javax.swing.BorderFactory.createEtchedBorder());
        mainPanel.setMaximumSize(new java.awt.Dimension(400, 400));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 10;
        gridBagConstraints.ipady = 10;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        getContentPane().add(mainPanel, gridBagConstraints);

        bottomPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        makeProgram.setText("Generar");
        makeProgram.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                makeProgramActionPerformed(evt);
            }
        });
        bottomPanel.add(makeProgram);

        exitButton.setText("Salir");
        exitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitButtonActionPerformed(evt);
            }
        });
        bottomPanel.add(exitButton);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 10;
        gridBagConstraints.ipady = 10;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.PAGE_END;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        getContentPane().add(bottomPanel, gridBagConstraints);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void makeProgramActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_makeProgramActionPerformed
        if (customTable != null) {
            JFileChooser fileChooser = new JFileChooser();
            FileNameExtensionFilter filter = new FileNameExtensionFilter("Java File","java");
            fileChooser.setFileFilter(filter);
            File file;
            FileOutputStream out = null;

            if (fileChooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
                file = fileChooser.getSelectedFile();
                String fileName;
                try {
                    String filePath = file.getPath();
                    filePath = filePath.replaceAll(file.getName(), "");
                    fileName = getRightFileName(file.getName());
                    filePath = filePath + fileName + ".java";
                    
                    if (!file.exists()) {
                        file = new File(filePath);
                    }   
                    
                    int stateCount = customTable.getStateCount();
                    String[] symbols = customTable.getSymbols();
                    int[][] transitions = customTable.getTransitions();
                    int[] validStates = customTable.getValidStates();
                    String programCode;

                    AFDDirector director = new AFDDirector(new AFDBuilder());
                    director.setData(stateCount, symbols, transitions, validStates);
                    director.buildAFD(fileName);
                    programCode = director.getProgramCode();

                    out = new FileOutputStream(file);
                    out.write(programCode.getBytes());
                    out.flush();
                    out.close();

                } catch (FileNotFoundException ex) {
                    Logger.getLogger(UserFrame.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(UserFrame.class.getName()).log(Level.SEVERE, null, ex);
                } finally {
                    try {
                        if (out != null) {
                            out.close();
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Cree la tabla de datos de su automata para generar su programa.");
        }
    }//GEN-LAST:event_makeProgramActionPerformed

    private String getRightFileName(String fileName){
        String rightName = fileName.replaceAll("\\s", "");
        rightName = rightName.replaceAll(".java", "");
        rightName = rightName.replaceAll("[\\.]", "");
        rightName = rightName.replaceAll("[\\(]", "");
        rightName = rightName.replaceAll("[\\)]", "");
        rightName = rightName.substring(0, 1).toUpperCase() + rightName.substring(1);
        return rightName;
    }
    
    private void exitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitButtonActionPerformed
        System.exit(1);
    }//GEN-LAST:event_exitButtonActionPerformed

    private void makeTableButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_makeTableButtonActionPerformed
        int stateCount;
        int symbolCount;
        String[] symbols;
        DefaultListModel modelList = (DefaultListModel) symbolList.getModel();
        symbolCount = modelList.getSize();
        symbols = new String[symbolCount];
        for (int i = 0; i < symbolCount; i++) {
            symbols[i] = modelList.getElementAt(i).toString();
        }
        stateCount = (int) stateLength.getValue();
        if (stateCount >= 2 && symbolCount >= 2) {
            customTable = new CustomTable(stateCount, symbolCount);
            customTable.setSymbols(symbols);
            mainPanel.setViewportView(customTable);
            mainPanel.validate();
        } else {
            JOptionPane.showMessageDialog(rootPane, "La cantidad de estados y símbolos de entrada deben ser mayores o iguales a 2.");
        }
        pack();
    }//GEN-LAST:event_makeTableButtonActionPerformed

    private void addSymbolButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addSymbolButtonActionPerformed
        String symbol = symbolChar.getText();
        if (symbol.equalsIgnoreCase("") || symbol.length() > 1) {
            Toolkit.getDefaultToolkit().beep();
            return;
        }

        if (alreadyInList(symbol)) {
            JOptionPane.showMessageDialog(rootPane, "El símbolo ya existe.");
            return;
        }

        DefaultListModel listModel = (DefaultListModel) symbolList.getModel();
        listModel.add(listModel.getSize(), symbol);
        symbolChar.setText("");
        symbolChar.requestFocus();
    }//GEN-LAST:event_addSymbolButtonActionPerformed

    private void deleteSymbolsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteSymbolsButtonActionPerformed
        DefaultListModel modelList = (DefaultListModel) symbolList.getModel();
        int size = modelList.getSize();
        if (size > 0 && !symbolList.isSelectionEmpty()) {
            int selectedSymbol = symbolList.getSelectedIndex();
            modelList.remove(selectedSymbol);
            if (selectedSymbol == size - 1) {
                selectedSymbol--;
            }
            symbolList.setSelectedIndex(selectedSymbol);
            symbolList.ensureIndexIsVisible(selectedSymbol);
        }


    }//GEN-LAST:event_deleteSymbolsButtonActionPerformed

    private void symbolCharKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_symbolCharKeyTyped
        if (symbolChar.getText().length() >= 1) {
            symbolChar.setText("");
        }
    }//GEN-LAST:event_symbolCharKeyTyped

    private void symbolCharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_symbolCharActionPerformed
        addSymbolButtonActionPerformed(evt);
    }//GEN-LAST:event_symbolCharActionPerformed

    private boolean alreadyInList(String symbol) {
        DefaultListModel listModel = (DefaultListModel) symbolList.getModel();
        return listModel.contains(symbol);
    }

    public static void main(String args[]) {
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(UserFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UserFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UserFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UserFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UserFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addSymbolButton;
    private javax.swing.JPanel bottomPanel;
    private javax.swing.JButton deleteSymbolsButton;
    private javax.swing.JButton exitButton;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel leftPanel;
    private javax.swing.JScrollPane mainPanel;
    private javax.swing.JButton makeProgram;
    private javax.swing.JButton makeTableButton;
    private javax.swing.JLabel stateLabel;
    private javax.swing.JSpinner stateLength;
    private javax.swing.JTextField symbolChar;
    private javax.swing.JLabel symbolLabel;
    private javax.swing.JList symbolList;
    // End of variables declaration//GEN-END:variables
}
