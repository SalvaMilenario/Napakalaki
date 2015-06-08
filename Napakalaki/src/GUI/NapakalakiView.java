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
        monsterView1.setVisible(false);
        monsterView1.setEnabled(false);
    }
    
    public void setNapakalaki(Napakalaki model){
        this.napakalakiModel=model;
        this.playerView1.setNapakalaki(model);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        monsterView1 = new GUI.MonsterView();
        playerView1 = new GUI.PlayerView();
        meetMonster = new javax.swing.JButton();
        nextTurn = new javax.swing.JButton();
        combat = new javax.swing.JButton();
        exit = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(2000000000, 2147483647));

        meetMonster.setText("Meet the monster");
        meetMonster.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                meetMonsterActionPerformed(evt);
            }
        });

        nextTurn.setText("Next Turn");
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
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(playerView1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(monsterView1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(meetMonster, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(nextTurn, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(combat, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(380, 380, 380)
                        .addComponent(exit, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(playerView1, javax.swing.GroupLayout.PREFERRED_SIZE, 366, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(monsterView1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(meetMonster)
                    .addComponent(nextTurn)
                    .addComponent(combat)
                    .addComponent(exit)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void exitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitMouseClicked
        System.exit(0);
    }//GEN-LAST:event_exitMouseClicked

    private void meetMonsterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_meetMonsterActionPerformed
        monsterView1.setVisible(true);
        monsterView1.setEnabled(true);
    }//GEN-LAST:event_meetMonsterActionPerformed

    private void combatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combatActionPerformed
        CombatResult c=null;
        if (monsterView1.isVisible())
            c =this.napakalakiModel.combat();
        switch (c)
        {
            case WINANDWINGAME:
                JOptionPane.showMessageDialog(null,"¡¡¡ H A S   G A N A D O   L A   P A R T I D A !!!");
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
                JOptionPane.showMessageDialog(null,"Perdiste el combate pero te combiertes en sectario");
                break;
            default:
                JOptionPane.showMessageDialog(null,"No has visto al monstruo");
        }         
    }//GEN-LAST:event_combatActionPerformed

    private void nextTurnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextTurnActionPerformed
        boolean sePuede = napakalakiModel.nextTurn();
        if(!sePuede)
            JOptionPane.showMessageDialog(null,"Imposible pasar de turno, revisa condiciones");
        else
        {
            this.playerView1.setPlayer(napakalakiModel.getCurrentPlayer());
            this.monsterView1.setVisible(false);
        }
    }//GEN-LAST:event_nextTurnActionPerformed

    /**
     * @param args the command line arguments
     */
    public void showView() {
        this.setVisible(true);
        this.playerView1.setPlayer(napakalakiModel.getCurrentPlayer());
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton combat;
    private javax.swing.JButton exit;
    private javax.swing.JButton meetMonster;
    private GUI.MonsterView monsterView1;
    private javax.swing.JButton nextTurn;
    private GUI.PlayerView playerView1;
    // End of variables declaration//GEN-END:variables
}
