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
 * ConfirmDialog.java
 *
 * Created on 6. kes�kuuta 2006, 11:40
 */

package org.wandora.application.gui;


import org.wandora.application.gui.simple.*;
import org.wandora.utils.swing.GuiTools;


/**
 *
 * @author  olli
 */
public class ConfirmDialog extends javax.swing.JDialog {
    
	private static final long serialVersionUID = 1L;
	
	private ConfirmResult result=ConfirmResult.cancel;
    
    /** Creates new form ConfirmDialog */
    private ConfirmDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }
    private ConfirmDialog(java.awt.Dialog parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        iconPanel = new javax.swing.JPanel();
        iconLabel = new javax.swing.JLabel();
        label = new SimpleLabel();
        jPanel1 = new javax.swing.JPanel();
        yesButton = new SimpleButton();
        yesToAllButton = new SimpleButton();
        noButton = new SimpleButton();
        noToAllButton = new SimpleButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new java.awt.GridBagLayout());

        iconPanel.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 0, 0));

        iconLabel.setMaximumSize(new java.awt.Dimension(60, 60));
        iconLabel.setMinimumSize(new java.awt.Dimension(60, 60));
        iconLabel.setPreferredSize(new java.awt.Dimension(60, 60));
        iconPanel.add(iconLabel);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        getContentPane().add(iconPanel, gridBagConstraints);

        label.setText("jLabel1");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 5, 10);
        getContentPane().add(label, gridBagConstraints);

        jPanel1.setLayout(new java.awt.GridBagLayout());

        yesButton.setText("Yes");
        yesButton.setMargin(new java.awt.Insets(2, 2, 2, 2));
        yesButton.setMaximumSize(new java.awt.Dimension(70, 23));
        yesButton.setMinimumSize(new java.awt.Dimension(70, 23));
        yesButton.setPreferredSize(new java.awt.Dimension(70, 23));
        yesButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                yesButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jPanel1.add(yesButton, gridBagConstraints);

        yesToAllButton.setText("Yes to all");
        yesToAllButton.setMargin(new java.awt.Insets(2, 2, 2, 2));
        yesToAllButton.setMaximumSize(new java.awt.Dimension(70, 23));
        yesToAllButton.setMinimumSize(new java.awt.Dimension(70, 23));
        yesToAllButton.setPreferredSize(new java.awt.Dimension(70, 23));
        yesToAllButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                yesToAllButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(3, 0, 3, 3);
        jPanel1.add(yesToAllButton, gridBagConstraints);

        noButton.setText("No");
        noButton.setMargin(new java.awt.Insets(2, 2, 2, 2));
        noButton.setMaximumSize(new java.awt.Dimension(70, 23));
        noButton.setMinimumSize(new java.awt.Dimension(70, 23));
        noButton.setPreferredSize(new java.awt.Dimension(70, 23));
        noButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                noButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(3, 0, 3, 3);
        jPanel1.add(noButton, gridBagConstraints);

        noToAllButton.setText("No to all");
        noToAllButton.setMargin(new java.awt.Insets(2, 2, 2, 2));
        noToAllButton.setMaximumSize(new java.awt.Dimension(70, 23));
        noToAllButton.setMinimumSize(new java.awt.Dimension(70, 23));
        noToAllButton.setPreferredSize(new java.awt.Dimension(70, 23));
        noToAllButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                noToAllButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(3, 0, 3, 3);
        jPanel1.add(noToAllButton, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(4, 4, 4, 4);
        getContentPane().add(jPanel1, gridBagConstraints);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void noToAllButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_noToAllButtonActionPerformed
        result=ConfirmResult.notoall;
        setVisible(false);
    }//GEN-LAST:event_noToAllButtonActionPerformed

    private void noButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_noButtonActionPerformed
        result=ConfirmResult.no;
        setVisible(false);        
    }//GEN-LAST:event_noButtonActionPerformed

    private void yesToAllButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_yesToAllButtonActionPerformed
        result=ConfirmResult.yestoall;
        setVisible(false);        
    }//GEN-LAST:event_yesToAllButtonActionPerformed

    private void yesButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_yesButtonActionPerformed
        result=ConfirmResult.yes;
        setVisible(false);        
    }//GEN-LAST:event_yesButtonActionPerformed
    
    private ConfirmResult getResult(){
        return result;
    }
    
    private static java.awt.Window getWindow(java.awt.Component parent){
        if (parent instanceof java.awt.Frame || parent instanceof java.awt.Dialog) return (java.awt.Window)parent;
        return getWindow(parent.getParent());
    }

    public static ConfirmResult showConfirmDialog(java.awt.Component parent,String title,String message,boolean simple){
        if(simple) return showConfirmDialog(parent,title,message,true,false,true,false);
        else return showConfirmDialog(parent,title,message,true,true,true,true);
    }
    public static ConfirmResult showConfirmDialog(java.awt.Component parent,String title,String message,boolean yes,boolean yesToAll,boolean no,boolean noToAll){
        ConfirmDialog cd=null;
        java.awt.Window w=getWindow(parent);
        if(w instanceof java.awt.Dialog) cd=new ConfirmDialog((java.awt.Dialog)w,true);
        else cd=new ConfirmDialog((java.awt.Frame)w,true);
        cd.setTitle(title);
        message=message.replace("\n","<br>");
        cd.label.setText("<html>"+message+"</html>");
        if(!yes) cd.yesButton.setVisible(false);
        if(!yesToAll) cd.yesToAllButton.setVisible(false);
        if(!no) cd.noButton.setVisible(false);
        if(!noToAll) cd.noToAllButton.setVisible(false);
        cd.iconLabel.setIcon(UIBox.getIcon("gui/icons/dialog/inform.gif"));
        cd.pack();
        GuiTools.centerWindow(cd,parent);
        cd.setVisible(true);
        return cd.getResult();
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel iconLabel;
    private javax.swing.JPanel iconPanel;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel label;
    private javax.swing.JButton noButton;
    private javax.swing.JButton noToAllButton;
    private javax.swing.JButton yesButton;
    private javax.swing.JButton yesToAllButton;
    // End of variables declaration//GEN-END:variables
    
}
