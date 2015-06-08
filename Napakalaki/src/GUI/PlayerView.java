/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Model.Napakalaki;
import Model.Player;
import Model.Treasure;
import java.awt.Component;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author xehartnort
 */
public class PlayerView extends javax.swing.JPanel {
    
    private Napakalaki napakalakiModel;
    
    Player playerModel;
    
    /**
     * Creates new form PlayerView
     */
    public PlayerView() {
        initComponents();
    }
    
    public void setPlayer (Player p) {
        playerModel = p;
        name.setText(playerModel.getName());
        dead.setText("Death? "+Boolean.toString(playerModel.isDead()));
        level.setText("Lv. "+Integer.toString(playerModel.getLevel()));
        combatLevel.setText("Combat Lv. "+Integer.toString(playerModel.getCombatLevel()));
        // A continuación se actualizan sus tesoros
        this.fillTreasurePanel (visibleTreasures, playerModel.getVisibleTreasures());
        this.fillTreasurePanel (hiddenTreasures, playerModel.getHiddenTreasures());
        this.repaint();
        this.revalidate();
    }
    
    public void setNapakalaki(Napakalaki n)
    {
        this.napakalakiModel = n;
    }
    
    public ArrayList<Treasure> getSelectedTreasures(JPanel aPanel) 
    {
        // Se recorren los tesoros que contiene el panel,
        // almacenando en un vector aquellos que están seleccionados.
        // Finalmente se devuelve dicho vector.
        TreasureView tv;
        ArrayList<Treasure> output = new ArrayList();
        for (Component c : aPanel.getComponents()) 
        {
            tv = (TreasureView) c;
            if (tv.isSelected())
                output.add(tv.getTreasure());
        }
        return output;
    }
    
    public void fillTreasurePanel (JPanel aPanel, ArrayList<Treasure> aList) {
        // Se elimina la información antigua
        aPanel.removeAll();
        // Se recorre la lista de tesoros construyendo y añadiendo sus vistas
        // al panel
        for (Treasure t : aList) {
            TreasureView aTreasureView = new TreasureView();
            aTreasureView.setTreasure (t);
            aTreasureView.setVisible (true);
            aPanel.add (aTreasureView);
        }
        // Se fuerza la actualización visual del panel
        aPanel.repaint();
        aPanel.revalidate();
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        hiddenTreasures = new javax.swing.JPanel();
        visibleTreasures = new javax.swing.JPanel();
        name = new javax.swing.JLabel();
        level = new javax.swing.JLabel();
        dead = new javax.swing.JLabel();
        combatLevel = new javax.swing.JLabel();
        buyLevels = new javax.swing.JButton();
        makeVisible = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Player", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP));

        hiddenTreasures.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        visibleTreasures.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout visibleTreasuresLayout = new javax.swing.GroupLayout(visibleTreasures);
        visibleTreasures.setLayout(visibleTreasuresLayout);
        visibleTreasuresLayout.setHorizontalGroup(
            visibleTreasuresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        visibleTreasuresLayout.setVerticalGroup(
            visibleTreasuresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 142, Short.MAX_VALUE)
        );

        name.setText("name");

        level.setText("level");

        dead.setText("dead");

        combatLevel.setText("combatLevel");

        buyLevels.setText("Buy Levels");
        buyLevels.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buyLevelsActionPerformed(evt);
            }
        });

        makeVisible.setText("Make Visible");
        makeVisible.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                makeVisibleActionPerformed(evt);
            }
        });

        jButton3.setText("Discard Treasures");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton3)
                    .addComponent(makeVisible)
                    .addComponent(buyLevels)
                    .addComponent(dead)
                    .addComponent(combatLevel)
                    .addComponent(level)
                    .addComponent(name))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(hiddenTreasures, javax.swing.GroupLayout.DEFAULT_SIZE, 375, Short.MAX_VALUE)
                    .addComponent(visibleTreasures, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(name)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(level)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(combatLevel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dead))
                    .addComponent(hiddenTreasures, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(visibleTreasures, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(buyLevels)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(makeVisible)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton3)))
                .addGap(13, 13, 13))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void makeVisibleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_makeVisibleActionPerformed
        ArrayList<Treasure> selHidden = getSelectedTreasures(hiddenTreasures);
        for (Treasure t : selHidden)
        {
            if(!napakalakiModel.getCurrentPlayer().makeTreasureVisible(t))
                JOptionPane.showMessageDialog(null,"No se puede hacer visible a "+t.getName());
        }
        this.setPlayer(napakalakiModel.getCurrentPlayer());
        this.visibleTreasures.repaint();
    }//GEN-LAST:event_makeVisibleActionPerformed

    private void buyLevelsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buyLevelsActionPerformed
        ArrayList<Treasure> selHidden = getSelectedTreasures(hiddenTreasures);
        ArrayList<Treasure> selVisible = getSelectedTreasures(visibleTreasures);
        napakalakiModel.buyLevels(selVisible, selHidden);
        setPlayer(napakalakiModel.getCurrentPlayer());
    }//GEN-LAST:event_buyLevelsActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        ArrayList<Treasure> selHidden = getSelectedTreasures(hiddenTreasures);
        ArrayList<Treasure> selVisible = getSelectedTreasures(visibleTreasures);
        for (Treasure t : selHidden)
            napakalakiModel.discardHiddenTreasure(t);
        for (Treasure t : selVisible)
            napakalakiModel.discardVisibleTreasure(t);
        setPlayer(napakalakiModel.getCurrentPlayer());
    }//GEN-LAST:event_jButton3ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buyLevels;
    private javax.swing.JLabel combatLevel;
    private javax.swing.JLabel dead;
    private javax.swing.JPanel hiddenTreasures;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel level;
    private javax.swing.JButton makeVisible;
    private javax.swing.JLabel name;
    private javax.swing.JPanel visibleTreasures;
    // End of variables declaration//GEN-END:variables
}
