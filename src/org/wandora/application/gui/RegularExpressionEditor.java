/*
 * WANDORA
 * Knowledge Extraction, Management, and Publishing Application
 * http://wandora.org
 * 
 * Copyright (C) 2004-2016 Wandora Team
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *
 * 
 * RegularExpressionEditor.java
 *
 * Created on 2. joulukuuta 2004, 11:49
 */

package org.wandora.application.gui;



import org.wandora.application.*;
import java.awt.*;
import java.io.*;
import java.util.*;
import java.util.regex.*;
import java.awt.event.*;
import javax.swing.*;
import org.wandora.utils.*;
import org.wandora.application.gui.simple.SimpleFileChooser;
import org.wandora.application.gui.simple.SimpleButton;
import org.wandora.application.gui.simple.SimpleCheckBox;
import org.wandora.application.gui.simple.SimpleComboBox;
import org.wandora.application.gui.simple.SimpleLabel;
import org.wandora.application.gui.simple.SimpleTextPane;


/**
 *
 * @author  akivela
 */


public class RegularExpressionEditor extends javax.swing.JDialog implements ActionListener {

	
	private static final long serialVersionUID = 1L;

	
	public static final String OPTIONS_PREFIX = "regexp.";
    
    public static final String DEFAULT_PATTERN_NAME = "User expression";
    
    public static Color TEST_ERROR = new Color(255,220,220);
    public static Color TEST_MATCH = new Color(220,255,220);
    public static Color TEST_MISMATCH = new Color(240,220,220);
     
    private Wandora wandora;
    private HashMap<String,EasyReplaceExpression> patterns;
    public boolean approve;
    private EasyReplaceExpression originalPattern;
    
    private static RegularExpressionEditor editor = null;
    private static RegularExpressionEditor matchEditor = null;
    
    
    public RegularExpressionEditor() {
        this(null);
    }
    
    /** Creates new form RegularExpressionEditor */
    public RegularExpressionEditor(Wandora w) {
        super(w, true);
        this.wandora = w;
        patterns = new LinkedHashMap<>();
        if(wandora != null) {
            parsePatternOptions(wandora.options);
            //setIconImage(admin.getIconImage());
        }
        originalPattern = null;
        initGui();
        refresh();
    }
    
    
    
    
    // -------------------------------------------------------------------------
    // RegularExpressionEditor should be used as singleton!
    // Instead of creating new instances of RegularExpressionEditor you should
    // get RegularExpressionEditor instance with next!
    // -------------------------------------------------------------------------
    
    public static RegularExpressionEditor getReplaceExpressionEditor(Wandora w) {
        if(editor == null) {
            editor = new RegularExpressionEditor(w);
        }
        return editor;
    }
    public static RegularExpressionEditor getMatchExpressionEditor(Wandora w) {
        if(matchEditor == null) {
            matchEditor = new RegularExpressionEditor(w);
            matchEditor.replacementLabel.setVisible(false);
            matchEditor.replacementScrollPane.setVisible(false);
            matchEditor.setTitle("Regular expressions matcher");
        }
        return matchEditor;
    }
    
    
    
    
    public void initGui() {
        initComponents();
        nameComboBox.setEditable(false);
        initPatternsComboBox();
    }
    
    
    public void initPatternsComboBox() {
        ((SimpleComboBox) nameComboBox).setOptions(patterns.keySet()); 
    }

    

    @Override
    public void setVisible(boolean v) {
        if(v == true) {
            refresh();
            approve = false;
        }
        super.setVisible(v);
    }
    
    public void refresh() {
        if(wandora != null) {
            wandora.centerWindow(this);
        }
    }
    
    
    
    @Override
    public Container getParent() {
        return wandora;
    }
    
    
    
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        matchCheckBox = new SimpleCheckBox();
        caseSensitivityCheckBox = new SimpleCheckBox();
        jPanel4 = new javax.swing.JPanel();
        nameLabel = new SimpleLabel();
        nameComboBox = new SimpleComboBox();
        patternLabel = new SimpleLabel();
        regexScrollPane = new javax.swing.JScrollPane();
        regexPane = new SimpleTextPane();
        replacementLabel = new SimpleLabel();
        replacementScrollPane = new javax.swing.JScrollPane();
        replacementPane = new SimpleTextPane();
        buttonPanel = new javax.swing.JPanel();
        applyButton = new SimpleButton();
        cancelButton = new SimpleButton();
        testPanel = new javax.swing.JPanel();
        testStringLabel = new SimpleLabel();
        testStringScrollPane = new javax.swing.JScrollPane();
        testStringPane = new SimpleTextPane();
        testButtonPanel = new javax.swing.JPanel();
        javax.swing.JButton testButton = new SimpleButton();
        testResultLabel = new SimpleLabel();
        testResultScrollPane = new javax.swing.JScrollPane();
        testResultPane = new SimpleTextPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        fileMenu = new javax.swing.JMenu();
        newMenuItem = new javax.swing.JMenuItem();
        storeExpressionMenuItem = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JSeparator();
        loadMenuItem = new javax.swing.JMenuItem();
        saveMenuItem = new javax.swing.JMenuItem();
        deleteMenuItem = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JSeparator();
        cancelMenuItem = new javax.swing.JMenuItem();

        setTitle("Regular expression replacer");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                exitForm(evt);
            }
        });
        getContentPane().setLayout(new java.awt.GridBagLayout());

        jPanel1.setMinimumSize(new java.awt.Dimension(200, 300));
        jPanel1.setPreferredSize(new java.awt.Dimension(290, 490));
        jPanel1.setLayout(new java.awt.GridBagLayout());

        jPanel2.setMinimumSize(new java.awt.Dimension(100, 20));
        jPanel2.setPreferredSize(new java.awt.Dimension(100, 20));
        jPanel2.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT, 0, 0));

        matchCheckBox.setFont(org.wandora.application.gui.UIConstants.buttonLabelFont);
        matchCheckBox.setText("Full match");
        matchCheckBox.setToolTipText("If selected regular expression must fully match the string");
        matchCheckBox.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        jPanel2.add(matchCheckBox);

        caseSensitivityCheckBox.setFont(org.wandora.application.gui.UIConstants.buttonLabelFont);
        caseSensitivityCheckBox.setText("Case insensitivity");
        caseSensitivityCheckBox.setToolTipText("Case sensitive / Case insensitive");
        caseSensitivityCheckBox.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        jPanel2.add(caseSensitivityCheckBox);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        jPanel1.add(jPanel2, gridBagConstraints);

        jPanel4.setLayout(new java.awt.GridBagLayout());

        nameLabel.setText("Regular expression name");
        nameLabel.setMinimumSize(new java.awt.Dimension(100, 14));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(8, 0, 0, 0);
        jPanel4.add(nameLabel, gridBagConstraints);

        nameComboBox.setPreferredSize(new java.awt.Dimension(400, 20));
        nameComboBox.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        nameComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        jPanel4.add(nameComboBox, gridBagConstraints);

        patternLabel.setText("Regular expression");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 0, 0);
        jPanel4.add(patternLabel, gridBagConstraints);

        regexScrollPane.setPreferredSize(new java.awt.Dimension(400, 75));
        regexScrollPane.setViewportView(regexPane);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        jPanel4.add(regexScrollPane, gridBagConstraints);

        replacementLabel.setText("Replacement");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 0, 0);
        jPanel4.add(replacementLabel, gridBagConstraints);

        replacementScrollPane.setPreferredSize(new java.awt.Dimension(400, 75));
        replacementScrollPane.setViewportView(replacementPane);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        jPanel4.add(replacementScrollPane, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        jPanel1.add(jPanel4, gridBagConstraints);

        buttonPanel.setPreferredSize(new java.awt.Dimension(400, 33));
        buttonPanel.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT, 3, 4));

        applyButton.setFont(org.wandora.application.gui.UIConstants.buttonLabelFont);
        applyButton.setText("Apply");
        applyButton.setMargin(new java.awt.Insets(2, 2, 2, 2));
        applyButton.setMaximumSize(new java.awt.Dimension(70, 23));
        applyButton.setMinimumSize(new java.awt.Dimension(70, 23));
        applyButton.setPreferredSize(new java.awt.Dimension(70, 23));
        applyButton.addActionListener(this);
        buttonPanel.add(applyButton);

        cancelButton.setFont(org.wandora.application.gui.UIConstants.buttonLabelFont);
        cancelButton.setText("Cancel");
        cancelButton.setMargin(new java.awt.Insets(2, 2, 2, 2));
        cancelButton.setMaximumSize(new java.awt.Dimension(70, 23));
        cancelButton.setMinimumSize(new java.awt.Dimension(70, 23));
        cancelButton.setPreferredSize(new java.awt.Dimension(70, 23));
        cancelButton.addActionListener(this);
        buttonPanel.add(cancelButton);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        jPanel1.add(buttonPanel, gridBagConstraints);

        testPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        testPanel.setPreferredSize(new java.awt.Dimension(384, 190));
        testPanel.setLayout(new java.awt.GridBagLayout());

        testStringLabel.setFont(org.wandora.application.gui.UIConstants.buttonLabelFont);
        testStringLabel.setText("Test string");
        testStringLabel.setPreferredSize(new java.awt.Dimension(150, 14));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(2, 4, 0, 4);
        testPanel.add(testStringLabel, gridBagConstraints);

        testStringScrollPane.setPreferredSize(new java.awt.Dimension(380, 50));
        testStringScrollPane.setViewportView(testStringPane);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 4, 0, 4);
        testPanel.add(testStringScrollPane, gridBagConstraints);

        testButtonPanel.setPreferredSize(new java.awt.Dimension(150, 33));
        testButtonPanel.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 3, 3));

        testButton.setFont(org.wandora.application.gui.UIConstants.buttonLabelFont);
        testButton.setText("Test regular expression");
        testButton.setMargin(new java.awt.Insets(2, 4, 2, 4));
        testButton.setMaximumSize(new java.awt.Dimension(57, 21));
        testButton.setMinimumSize(new java.awt.Dimension(150, 20));
        testButton.setPreferredSize(new java.awt.Dimension(150, 20));
        testButton.addActionListener(this);
        testButtonPanel.add(testButton);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 4, 0, 4);
        testPanel.add(testButtonPanel, gridBagConstraints);

        testResultLabel.setFont(org.wandora.application.gui.UIConstants.buttonLabelFont);
        testResultLabel.setText("Test result");
        testResultLabel.setPreferredSize(new java.awt.Dimension(150, 14));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(2, 4, 0, 4);
        testPanel.add(testResultLabel, gridBagConstraints);

        testResultScrollPane.setPreferredSize(new java.awt.Dimension(380, 70));
        testResultScrollPane.setViewportView(testResultPane);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 4, 4, 4);
        testPanel.add(testResultScrollPane, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 10;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(15, 0, 0, 0);
        jPanel1.add(testPanel, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 15;
        gridBagConstraints.ipady = 15;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(2, 6, 5, 6);
        getContentPane().add(jPanel1, gridBagConstraints);

        fileMenu.setText("File");
        fileMenu.setFont(org.wandora.application.gui.UIConstants.menuFont);

        newMenuItem.setFont(org.wandora.application.gui.UIConstants.menuFont);
        newMenuItem.setText("New expression");
        newMenuItem.addActionListener(this);
        fileMenu.add(newMenuItem);

        storeExpressionMenuItem.setFont(org.wandora.application.gui.UIConstants.menuFont);
        storeExpressionMenuItem.setText("Store current expression...");
        storeExpressionMenuItem.addActionListener(this);
        fileMenu.add(storeExpressionMenuItem);
        fileMenu.add(jSeparator1);

        loadMenuItem.setFont(org.wandora.application.gui.UIConstants.menuFont);
        loadMenuItem.setText("Import expressions...");
        loadMenuItem.addActionListener(this);
        fileMenu.add(loadMenuItem);

        saveMenuItem.setFont(org.wandora.application.gui.UIConstants.menuFont);
        saveMenuItem.setText("Export expressions...");
        saveMenuItem.addActionListener(this);
        fileMenu.add(saveMenuItem);

        deleteMenuItem.setFont(org.wandora.application.gui.UIConstants.menuFont);
        deleteMenuItem.setText("Delete all expressions...");
        deleteMenuItem.addActionListener(this);
        fileMenu.add(deleteMenuItem);
        fileMenu.add(jSeparator2);

        cancelMenuItem.setFont(org.wandora.application.gui.UIConstants.menuFont);
        cancelMenuItem.setText("Close");
        cancelMenuItem.addActionListener(this);
        fileMenu.add(cancelMenuItem);

        jMenuBar1.add(fileMenu);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void comboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxActionPerformed
        selectPattern();
    }//GEN-LAST:event_comboBoxActionPerformed
    
    /** Exit the Application */
    private void exitForm(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_exitForm
        tryExit();
    }//GEN-LAST:event_exitForm
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        new RegularExpressionEditor().setVisible(true);
    }
    

    
    @Override
    public void actionPerformed(java.awt.event.ActionEvent actionEvent) {
        String c = actionEvent.getActionCommand();
        if(c == null) return;
        System.out.println("Regular expression editor action command: " +c);
        
        if("New expression".equalsIgnoreCase(c)) {
            this.regexPane.setText("");
            this.replacementPane.setText("");
            this.testStringPane.setText("");
            this.testResultPane.setText("");
            testResultPane.setBackground(new Color(255,255,255));
        }
        
        else if("Cancel".equalsIgnoreCase(c) || "Exit".equalsIgnoreCase(c) || "Close".equalsIgnoreCase(c)) {
            approve = false;
            tryExit();
        }
        else if("Apply".equalsIgnoreCase(c)) {
            approve = true;
            tryExit();
        }
        else if("Store current expression...".equalsIgnoreCase(c)) {
            savePattern();
        }
        else if(c.startsWith("Test")) {
            testPattern();
        }
        else if("Import expressions...".equalsIgnoreCase(c)) {
            importPatterns();
        }
        else if("Export expressions...".equalsIgnoreCase(c)) {
            exportPatterns();
        }
        else if("Delete all expressions...".equalsIgnoreCase(c)) {
            patterns = new LinkedHashMap<>();
            wandora.options.removeAll(OPTIONS_PREFIX);
            initPatternsComboBox();
        }
    }
    
    
    public void tryExit() {
        if(wandora != null) {
            this.savePatternsToOptions(wandora.options);
        }
        this.setVisible(false);
    }
    
    
    public void show(Object o, int column, EasyReplaceExpression pattern, boolean isAnd) {
        originalPattern = pattern;
        approve = false;
        if(pattern != null) {
            String name = pattern.getName();
            if(name == null) name = DEFAULT_PATTERN_NAME;
            if(patterns.isEmpty() || !patterns.containsKey(name)) {
                patterns.put(name, pattern);
                ((SimpleComboBox) nameComboBox).setOptions(patterns.keySet()); 
            }
            nameComboBox.setSelectedItem(name);
            caseSensitivityCheckBox.setSelected(!pattern.isCaseInsensitive());
            matchCheckBox.setSelected(!pattern.findInsteadMatch());
            regexPane.setText(pattern.getPatternString());
        }
        //andCheckBox.setSelected(isAnd);
        this.setVisible(false);
    }
    
    
   
    
    
    public boolean findInsteadMatch() {
        if(matchCheckBox.isSelected()) return false;
        else return true;
    }
    
    
    
    // --- THE REPLACER --------------------------------------------------------   
    
    public String replace(String target) {
        try {
            if(target != null && target.length() > 0) {
                //System.out.println("Replacing " + regexPane.getText() + " with " + replacementPane.getText());

                int flags = 0;
                if(caseSensitivityCheckBox.isSelected()) flags |= Pattern.CASE_INSENSITIVE;
                Pattern pattern = Pattern.compile(regexPane.getText(), flags);
                Matcher matcher = pattern.matcher(target);
                boolean match = false;
                if(!matchCheckBox.isSelected() == true) {
                    match = matcher.find();
                }
                else {
                    match = matcher.matches();
                }
                if(match) {
                    return matcher.replaceAll(replacementPane.getText());
                }
            }
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    
    public boolean matches(String target) {
        try {
            if(target != null && target.length() > 0) {
                //System.out.println("Replacing " + regexPane.getText() + " with " + replacementPane.getText());

                int flags = 0;
                if(caseSensitivityCheckBox.isSelected()) flags |= Pattern.CASE_INSENSITIVE;
                Pattern pattern = Pattern.compile(regexPane.getText(), flags);
                Matcher matcher = pattern.matcher(target);
                if(!matchCheckBox.isSelected() == true) {
                    return matcher.find();
                }
                else {
                    return matcher.matches();
                }
            }
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    
    
    
    // --- HANDLE PATTERNS -----------------------------------------------------
    
    
    
    
    public EasyReplaceExpression getCurrentPattern() {
        if(approve == true) {
            try { 
                Pattern p = Pattern.compile(regexPane.getText()); // TRYING
                String name = (String) nameComboBox.getSelectedItem();
                if(name == null) name = DEFAULT_PATTERN_NAME;
                return new EasyReplaceExpression((String) nameComboBox.getSelectedItem(), regexPane.getText(), replacementPane.getText(), !matchCheckBox.isSelected(), !caseSensitivityCheckBox.isSelected()); }
            catch (Exception e) { 
                testResultPane.setBackground(TEST_ERROR);
                testResultPane.setText("Syntax error in regular expression!\n\n" + e.toString());
                return null;
            }
        }
        else {
            return originalPattern;
        }
    }
    
    
    
   
    
    
    public void selectPattern() {
        try {
            if(nameComboBox.getSelectedItem() != null) {
                EasyReplaceExpression currentPattern = patterns.get(nameComboBox.getSelectedItem().toString());
                if(currentPattern != null) {
                    regexPane.setText(currentPattern.getPatternString());
                    replacementPane.setText(currentPattern.getReplacementString());
                    matchCheckBox.setSelected(!currentPattern.findInsteadMatch());
                    caseSensitivityCheckBox.setSelected(!currentPattern.isCaseInsensitive());
                }
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    
    
    public void savePattern() {
        String n = "New pattern";
        if(nameComboBox.getSelectedItem() != null) n =  nameComboBox.getSelectedItem().toString();
        String patternNameString=WandoraOptionPane.showInputDialog(this, "Enter name for the regular expression", n);

        String patternString = regexPane.getText();
        if(patternNameString != null && patternNameString.length() > 0) {
            if(patternString != null && patternString.length() > 0) {
                try {
                    Pattern p = Pattern.compile(regexPane.getText()); // TESTING!
                    EasyReplaceExpression kp = new EasyReplaceExpression(patternNameString, regexPane.getText(), replacementPane.getText(), !matchCheckBox.isSelected(), !caseSensitivityCheckBox.isSelected());
                    patterns.put(patternNameString, kp);
                    initPatternsComboBox();
                    nameComboBox.setSelectedItem(patternNameString);
                }
                catch (Exception e) {
                    testResultPane.setBackground(TEST_ERROR);
                    testResultPane.setText("Storing regular expression failed! Syntax error in regular expression!\n\n" + e.toString());
                }
            }
            else {
                if(patterns.get(patternString) != null) patterns.remove(patternString);
            }
        }
    }
    
    
    
    
    public void testPattern() {
        String patternString = regexPane.getText();
        String replacement = replacementPane.getText();
        String testString = testStringPane.getText();
        
        if(patternString != null && patternString.length() > 0) {
            if(testString != null && testString.length() > 0) {
                try {
                    int flags = 0;
                    if(caseSensitivityCheckBox.isSelected()) flags |= Pattern.CASE_INSENSITIVE;
                    Pattern pattern = Pattern.compile(patternString, flags);
                    Matcher matcher = pattern.matcher(testString);
                    boolean match = false;
                    if(!matchCheckBox.isSelected() == true) {
                        match = matcher.find();
                    }
                    else {
                        match = matcher.matches();
                    }
                    if(match) {
                        testResultPane.setBackground(TEST_MATCH);
                        testResultPane.setText(matcher.replaceAll(replacement));
                    }
                    else {
                        testResultPane.setBackground(TEST_MISMATCH);
                        testResultPane.setText("Tested string does not match regular expression!");
                    }
                }
                catch (PatternSyntaxException pse) {
                    testResultPane.setBackground(TEST_ERROR);
                    StringWriter sw = new StringWriter();
                    pse.printStackTrace(new PrintWriter(sw));
                    testResultPane.setBackground(TEST_ERROR);
                    testResultPane.setText("Syntax error in regular expression!\n\n" + sw.toString());
                }
                catch (Exception e) {
                    testResultPane.setBackground(TEST_ERROR);
                    StringWriter sw = new StringWriter();
                    e.printStackTrace(new PrintWriter(sw));
                    testResultPane.setText(sw.toString());
                }
            }
            else {
                testResultPane.setBackground(TEST_ERROR);
                testResultPane.setText("String to be tested is empty!");
            }
        }
        else {
            testResultPane.setBackground(TEST_ERROR);
            testResultPane.setText("Regular expression is empty!");
        }
    }

    
    
    
    // --- IMPORT PATTERNS -----------------------------------------------------
    
    
    public void importPatterns() {
        SimpleFileChooser chooser=UIConstants.getFileChooser();
        chooser.setDialogTitle("Loading regular expressions");
        chooser.setApproveButtonText("Load");
        chooser.setFileSelectionMode(SimpleFileChooser.FILES_ONLY);

        if(chooser.open(wandora) == SimpleFileChooser.APPROVE_OPTION) {
            importPatterns(chooser.getSelectedFile());
            initPatternsComboBox();
        }
    }
    
    
    
    public void importPatterns(File file) {
        patterns = new LinkedHashMap<>();
        mergePatterns(file);
    }
    
    
    
    public void mergePatterns(File file) {
        if(file != null) {
            try {
                String s = IObox.loadFile(file);
                parsePatterns(s);
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    
    
    public void importPatterns(String resourceName) {
        patterns = new LinkedHashMap<>();
        mergePatterns(resourceName);
    }
    
    
    public void mergePatterns(String resourceName) {
        if(resourceName != null) {
            try {
                String s = IObox.loadResource(resourceName);
                parsePatterns(s);
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    
    
    public void parsePatterns(String s) {
        if(s != null) {
            try {
                StringTokenizer lines = new StringTokenizer(s, "\n");
                while(lines.hasMoreTokens()) {
                    String line = lines.nextToken();
                    StringTokenizer parts = new StringTokenizer(line, "\t");
                    if(parts.countTokens()>4) {
                        String name = parts.nextToken();
                        String pattern = parts.nextToken();
                        String replacement = parts.nextToken();
                        String findInstead = parts.nextToken();
                        String caseSensitivity = parts.nextToken();
                        if(name != null && name.length() > 0 && pattern != null && pattern.length() > 0) {
                            patterns.put(name, new EasyReplaceExpression(name, pattern, replacement, "true".equalsIgnoreCase(findInstead), "true".equalsIgnoreCase(caseSensitivity)));
                        }
                    }
                    else {
                        System.out.println("Rejecting pattern!");
                    }
                }
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    
    
    
    
    public void parsePatternOptions(Options opts) {
        if(opts != null) {
            boolean noRejects = true;
            int i=0;
            try {
                while(noRejects) {
                    String name = opts.get(OPTIONS_PREFIX+"expression["+i+"].name");
                    String pattern = opts.get(OPTIONS_PREFIX+"expression["+i+"].pattern");
                    String replacement = opts.get(OPTIONS_PREFIX+"expression["+i+"].replacement");
                    String findInstead = opts.get(OPTIONS_PREFIX+"expression["+i+"].partialMatch");
                    String caseSensitivity = opts.get(OPTIONS_PREFIX+"expression["+i+"].caseSensitive");

                    if(name != null && name.length() > 0 && pattern != null && pattern.length() > 0) {
                        patterns.put(name, new EasyReplaceExpression(name, pattern, replacement, "true".equalsIgnoreCase(findInstead), "true".equalsIgnoreCase(caseSensitivity)));
                    }
                    else {
                        //System.out.println("Rejecting pattern!");
                        noRejects = false;
                    }
                    i++;
                }
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    
    public void savePatternsToOptions(Options opts) {
        if(opts != null) {
            int i = 0;
            for(String key : patterns.keySet()) {
                try {
                    EasyReplaceExpression kp = (EasyReplaceExpression) patterns.get(key);
                    opts.put(OPTIONS_PREFIX+"expression["+i+"].name", kp.getName());
                    opts.put(OPTIONS_PREFIX+"expression["+i+"].pattern", kp.getPatternString());
                    opts.put(OPTIONS_PREFIX+"expression["+i+"].replacement", kp.getReplacementString());
                    opts.put(OPTIONS_PREFIX+"expression["+i+"].partialMatch", kp.findInsteadMatch() ? "true" : "false");
                    opts.put(OPTIONS_PREFIX+"expression["+i+"].caseSensitive", kp.isCaseInsensitive() ? "true" : "false");
                    i++;
                }
                catch (Exception ex) {
                    System.out.println(ex);
                }
            }
        }
    }
    
    
    
    // --- EXPORT PATTERNS -----------------------------------------------------
   
    
    
    public void exportPatterns() {
        SimpleFileChooser chooser=UIConstants.getFileChooser();
        chooser.setDialogTitle("Saving regular expressions");
        chooser.setApproveButtonText("Save");
        chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);

        if(chooser.open(wandora, SimpleFileChooser.SAVE_DIALOG) == SimpleFileChooser.APPROVE_OPTION) {
            exportPatterns(chooser.getSelectedFile());
        }
    }
    
    
    
    public void exportPatterns(File file) {
        try {
            IObox.saveFile(file, patterns2String());
        }
        catch (Exception e) {
            System.out.println(e);
        }
    }
    
    
    
    public String patterns2String() {
        StringBuilder sb = new StringBuilder("");
        for(String key : patterns.keySet()) {
            try {
                EasyReplaceExpression kp = patterns.get(key);
                sb.append(key).append("\t").append(kp.getPatternString()).append("\t").append(kp.getReplacementString()).append("\t").append(kp.findInsteadMatch()).append("\t").append(kp.isCaseInsensitive());
                sb.append("\n");
            }
            catch (Exception ex) {
                System.out.println(ex);
            }
        }
        return sb.toString();
    }
    

    
    // -------------------------------------------------------------------------
    
    
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton applyButton;
    private javax.swing.JPanel buttonPanel;
    private javax.swing.JButton cancelButton;
    private javax.swing.JMenuItem cancelMenuItem;
    private javax.swing.JCheckBox caseSensitivityCheckBox;
    private javax.swing.JMenuItem deleteMenuItem;
    private javax.swing.JMenu fileMenu;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JMenuItem loadMenuItem;
    private javax.swing.JCheckBox matchCheckBox;
    private javax.swing.JComboBox nameComboBox;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JMenuItem newMenuItem;
    private javax.swing.JLabel patternLabel;
    private javax.swing.JTextPane regexPane;
    private javax.swing.JScrollPane regexScrollPane;
    private javax.swing.JLabel replacementLabel;
    private javax.swing.JTextPane replacementPane;
    private javax.swing.JScrollPane replacementScrollPane;
    private javax.swing.JMenuItem saveMenuItem;
    private javax.swing.JMenuItem storeExpressionMenuItem;
    private javax.swing.JPanel testButtonPanel;
    private javax.swing.JPanel testPanel;
    private javax.swing.JLabel testResultLabel;
    private javax.swing.JTextPane testResultPane;
    private javax.swing.JScrollPane testResultScrollPane;
    private javax.swing.JLabel testStringLabel;
    private javax.swing.JTextPane testStringPane;
    private javax.swing.JScrollPane testStringScrollPane;
    // End of variables declaration//GEN-END:variables
    
}
