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
 * SQLExtractorUI.java
 *
 */





package org.wandora.application.tools.extractors.sql;

import java.awt.Component;

import javax.swing.JDialog;
import org.wandora.application.Wandora;
import org.wandora.application.WandoraTool;
import org.wandora.application.gui.UIBox;
import org.wandora.application.gui.simple.SimpleButton;
import org.wandora.application.gui.simple.SimpleField;
import org.wandora.application.gui.simple.SimpleLabel;
import org.wandora.application.gui.simple.SimpleScrollPane;
import org.wandora.application.gui.simple.SimpleTabbedPane;
import org.wandora.application.gui.simple.SimpleTextPane;

/**
 *
 * @author akivela
 */
public class SQLExtractorUI extends javax.swing.JPanel {

	private static final long serialVersionUID = 1L;

	private boolean accepted = false;
    private JDialog dialog = null;
    private Wandora wandora = null;



    /** Creates new form SQLExtractorUI */
    public SQLExtractorUI(Wandora w) {
        wandora = w;
        initComponents();
    }



    public boolean wasAccepted() {
        return accepted;
    }
    public void setAccepted(boolean b) {
        accepted = b;
    }

    public void open(Wandora w) {
        accepted = false;
        dialog = new JDialog(w, true);
        dialog.setSize(750,400);
        dialog.add(this);
        dialog.setTitle("SQL Extractor");
        UIBox.centerWindow(dialog, w);
        dialog.setVisible(true);
    }






    public String getQuery(WandoraTool parentTool) {
        Component component = tabbedPane.getSelectedComponent();

        // ***** GENERIC *****
        if(genericPanel.equals(component)) {
            return genericQueryTextPane.getText();
        }
        return null;
    }




    
    
    public String getURL() {
        Component component = tabbedPane.getSelectedComponent();

        // ***** GENERIC *****
        if(genericPanel.equals(component)) {
            String queryURL = genericURLTextField.getText();
            return queryURL;
        }
        return null;
    }

    

    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        tabbedPane = new SimpleTabbedPane();
        genericPanel = new javax.swing.JPanel();
        genericPanelInner = new javax.swing.JPanel();
        genericTitle = new SimpleLabel();
        genericURLLabel = new SimpleLabel();
        urlPanel = new javax.swing.JPanel();
        genericURLTextField = new SimpleField();
        genericQueryLabel = new SimpleLabel();
        genericQueryScrollPane = new SimpleScrollPane();
        genericQueryTextPane = new SimpleTextPane();
        genericButtonPanel = new javax.swing.JPanel();
        buttonPanel = new javax.swing.JPanel();
        buttonFillerPanel = new javax.swing.JPanel();
        okButton = new SimpleButton();
        cancelButton = new SimpleButton();

        setLayout(new java.awt.GridBagLayout());

        genericPanel.setLayout(new java.awt.GridBagLayout());

        genericPanelInner.setLayout(new java.awt.GridBagLayout());

        genericTitle.setText("<html>This extractor sends SQL queries to a given end point and transform the result set to a topic map. Fill in the end point URL and the query.</html>");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 8, 0);
        genericPanelInner.add(genericTitle, gridBagConstraints);

        genericURLLabel.setText("Connection URL");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHEAST;
        gridBagConstraints.insets = new java.awt.Insets(2, 8, 2, 0);
        genericPanelInner.add(genericURLLabel, gridBagConstraints);

        urlPanel.setLayout(new java.awt.BorderLayout(4, 0));

        genericURLTextField.setText("jdbc:mysql://localhost:3306/database;user=user;password=pass");
        urlPanel.add(genericURLTextField, java.awt.BorderLayout.CENTER);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 4, 2, 0);
        genericPanelInner.add(urlPanel, gridBagConstraints);

        genericQueryLabel.setText("SQL query");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHEAST;
        gridBagConstraints.insets = new java.awt.Insets(2, 8, 2, 0);
        genericPanelInner.add(genericQueryLabel, gridBagConstraints);

        genericQueryTextPane.setText("select * from ...");
        genericQueryScrollPane.setViewportView(genericQueryTextPane);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 4, 2, 0);
        genericPanelInner.add(genericQueryScrollPane, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(4, 4, 4, 4);
        genericPanel.add(genericPanelInner, gridBagConstraints);

        genericButtonPanel.setLayout(new java.awt.GridBagLayout());
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 4, 4, 4);
        genericPanel.add(genericButtonPanel, gridBagConstraints);

        tabbedPane.addTab("Generic", genericPanel);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        add(tabbedPane, gridBagConstraints);

        buttonPanel.setLayout(new java.awt.GridBagLayout());

        buttonFillerPanel.setPreferredSize(new java.awt.Dimension(415, 20));

        javax.swing.GroupLayout buttonFillerPanelLayout = new javax.swing.GroupLayout(buttonFillerPanel);
        buttonFillerPanel.setLayout(buttonFillerPanelLayout);
        buttonFillerPanelLayout.setHorizontalGroup(
            buttonFillerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 594, Short.MAX_VALUE)
        );
        buttonFillerPanelLayout.setVerticalGroup(
            buttonFillerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        buttonPanel.add(buttonFillerPanel, gridBagConstraints);

        okButton.setText("Extract");
        okButton.setMaximumSize(new java.awt.Dimension(70, 23));
        okButton.setMinimumSize(new java.awt.Dimension(70, 23));
        okButton.setPreferredSize(new java.awt.Dimension(70, 23));
        okButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                okButtonMouseReleased(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 3);
        buttonPanel.add(okButton, gridBagConstraints);

        cancelButton.setText("Close");
        cancelButton.setMaximumSize(new java.awt.Dimension(70, 23));
        cancelButton.setMinimumSize(new java.awt.Dimension(70, 23));
        cancelButton.setPreferredSize(new java.awt.Dimension(70, 23));
        cancelButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                cancelButtonMouseReleased(evt);
            }
        });
        buttonPanel.add(cancelButton, new java.awt.GridBagConstraints());

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(4, 4, 4, 4);
        add(buttonPanel, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents

    
    private void cancelButtonMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cancelButtonMouseReleased
        accepted = false;
        if(dialog != null) dialog.setVisible(false);
    }//GEN-LAST:event_cancelButtonMouseReleased

    private void okButtonMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_okButtonMouseReleased
        accepted = true;
        if(dialog != null) dialog.setVisible(false);
    }//GEN-LAST:event_okButtonMouseReleased




    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel buttonFillerPanel;
    private javax.swing.JPanel buttonPanel;
    private javax.swing.JButton cancelButton;
    private javax.swing.JPanel genericButtonPanel;
    private javax.swing.JPanel genericPanel;
    private javax.swing.JPanel genericPanelInner;
    private javax.swing.JLabel genericQueryLabel;
    private javax.swing.JScrollPane genericQueryScrollPane;
    private javax.swing.JTextPane genericQueryTextPane;
    private javax.swing.JLabel genericTitle;
    private javax.swing.JLabel genericURLLabel;
    private javax.swing.JTextField genericURLTextField;
    private javax.swing.JButton okButton;
    private javax.swing.JTabbedPane tabbedPane;
    private javax.swing.JPanel urlPanel;
    // End of variables declaration//GEN-END:variables

}
