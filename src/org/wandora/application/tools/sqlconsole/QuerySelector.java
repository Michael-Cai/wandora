/*
 * WANDORA
 * Knowledge Extraction, Management, and Publishing Application
 * http://wandora.org
 * 
 * Copyright (C) 2004-2014 Wandora Team
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
 * QuerySelector.java
 *
 * Created on 30. joulukuuta 2004, 10:45
 */

package org.wandora.application.tools.sqlconsole;

import java.util.*;
import javax.swing.*;
/**
 *
 * @author  olli
 */
public class QuerySelector extends javax.swing.JDialog {
    
    private Vector<String> queryNames;
    private Map<String,StoredQuery> storedQueries;
    private Map<String,StoredQuery> selection=null;;
    
    /** Creates new form QuerySelector */
    public QuerySelector(boolean modal,Map<String,StoredQuery> storedQueries,String message) {
        //super(parent, modal);
        this.storedQueries=storedQueries;
        queryNames=new Vector<String>(storedQueries.keySet());
        initComponents();
        this.setTitle(message);
        messageLabel.setText(message);
        queryList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        queryList.setSelectionInterval(0,storedQueries.size()-1);
        //this.setLocation(parent.getX()+parent.getWidth()/2-this.getWidth()/2,parent.getY()+parent.getHeight()/2-this.getHeight()/2);
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jScrollPane1 = new javax.swing.JScrollPane();
        queryList = new JList(queryNames);
        jPanel1 = new javax.swing.JPanel();
        selectButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();
        messageLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new java.awt.GridBagLayout());

        jScrollPane1.setViewportView(queryList);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(9, 9, 9, 9);
        getContentPane().add(jScrollPane1, gridBagConstraints);

        jPanel1.setLayout(new java.awt.GridBagLayout());

        selectButton.setText("Select");
        selectButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        jPanel1.add(selectButton, gridBagConstraints);

        cancelButton.setText("Cancel");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 0, 0);
        jPanel1.add(cancelButton, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 10, 10);
        getContentPane().add(jPanel1, gridBagConstraints);

        messageLabel.setText("jLabel1");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 0, 10);
        getContentPane().add(messageLabel, gridBagConstraints);

        setBounds(0, 0, 369, 370);
    }// </editor-fold>//GEN-END:initComponents

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        selection=null;
        this.setVisible(false);
    }//GEN-LAST:event_cancelButtonActionPerformed

    private void selectButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectButtonActionPerformed
        int[] selected=queryList.getSelectedIndices();
        selection=new TreeMap<String,StoredQuery>();
        for(int i=0;i<selected.length;i++){
            String q=queryNames.get(selected[i]);
            StoredQuery sq=storedQueries.get(q);
            selection.put(q,sq);
        }
        this.setVisible(false);
    }//GEN-LAST:event_selectButtonActionPerformed

    public Map<String,StoredQuery> getSelection(){
        return selection;
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelButton;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel messageLabel;
    private javax.swing.JList queryList;
    private javax.swing.JButton selectButton;
    // End of variables declaration//GEN-END:variables
    
}