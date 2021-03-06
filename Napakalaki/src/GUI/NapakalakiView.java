/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Model.CombatResult;
import Model.Napakalaki;
import javax.swing.JOptionPane;
        
/**
 *
 * @author xehartnort
 */
public class NapakalakiView extends javax.swing.JFrame {

    private Napakalaki napakalakiModel;
    /**
     * Creates new form NapakalakiView
     */
    public NapakalakiView() {
        initComponents();
        monster.setVisible(false);
        monster.setEnabled(false);
    }
    
    public void setNapakalaki(Napakalaki model){
        this.napakalakiModel=model;
        this.player.setNapakalaki(model);
        this.player.setPlayer(napakalakiModel.getCurrentPlayer());
        this.combat.setEnabled(false);
        this.nextTurn.setEnabled(false);
        this.player.setBotones(true, true, false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        meetMonster = new javax.swing.JButton();
        nextTurn = new javax.swing.JButton();
        combat = new javax.swing.JButton();
        exit = new javax.swing.JButton();
        monster = new GUI.MonsterView();
        player = new GUI.PlayerView();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        meetMonster.setText("Meet the monster");
        meetMonster.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                meetMonsterActionPerformed(evt);
            }
        });

        nextTurn.setText("Next turn");
        nextTurn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextTurnActionPerformed(evt);
            }
        });

        combat.setText("Combat");
        combat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combatActionPerformed(evt);
            }
        });

        exit.setText("Exit");
        exit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                exitMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(meetMonster, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(nextTurn, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(combat, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(player, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(monster, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(exit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(player, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(monster, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(meetMonster)
                    .addComponent(nextTurn)
                    .addComponent(combat)
                    .addComponent(exit))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void exitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitMouseClicked
        System.exit(0);
    }//GEN-LAST:event_exitMouseClicked

    private void meetMonsterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_meetMonsterActionPerformed
        this.player.setBotones(false, false, false);
        combat.setEnabled(true);
        meetMonster.setEnabled(false);
        monster.setMonster(this.napakalakiModel.getCurrentMonster());
        monster.setEnabled(true);
        monster.setVisible(true);
    }//GEN-LAST:event_meetMonsterActionPerformed

    private void combatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combatActionPerformed
        CombatResult c=null;
        if (monster.isVisible())
            c = this.napakalakiModel.combat();
        switch (c)
        {
            case WINANDWINGAME:
                JOptionPane.showMessageDialog(null,"¡¡¡ H A S   G A N A D O   L A   P A R T I D A !!!");
                System.exit(0);
                break;
            case WIN:
                JOptionPane.showMessageDialog(null,"Ganaste el combate");
                break;
            case LOSE:
                JOptionPane.showMessageDialog(null,"Has perdido el combate, te toca cumplir el mal rollo");
                break;
            case LOSEANDESCAPE:
                JOptionPane.showMessageDialog(null,"Perdiste el combate pero has logrado escapar");
                break;
            case LOSEANDDIE:
                JOptionPane.showMessageDialog(null,"Perdiste el combate y además estás muerto"); 
                break;
            case LOSEANDCONVERT:
                JOptionPane.showMessageDialog(null,"Perdiste el combate pero te conviertes en sectario");
                break;
        }
        this.player.setBotones(false, true, true);
        this.player.setPlayer(napakalakiModel.getCurrentPlayer());
        this.nextTurn.setEnabled(true);
        this.combat.setEnabled(false);
    }//GEN-LAST:event_combatActionPerformed

    private void nextTurnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextTurnActionPerformed
        boolean sePuede = napakalakiModel.nextTurn();
        if(!sePuede)
            JOptionPane.showMessageDialog(null,"Imposible pasar de turno, revisa condiciones");
        else
        {
            this.player.setPlayer(napakalakiModel.getCurrentPlayer());
            this.monster.setVisible(false);
            this.nextTurn.setEnabled(false);
            this.combat.setEnabled(false);
            this.meetMonster.setEnabled(true);
            this.player.setBotones(true, true, false); 
        }
    }//GEN-LAST:event_nextTurnActionPerformed

    /**
     * @param args the command line arguments
     */
    public void showView() {
        this.setVisible(true);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton combat;
    private javax.swing.JButton exit;
    private javax.swing.JButton meetMonster;
    private GUI.MonsterView monster;
    private javax.swing.JButton nextTurn;
    private GUI.PlayerView player;
    // End of variables declaration//GEN-END:variables
}
