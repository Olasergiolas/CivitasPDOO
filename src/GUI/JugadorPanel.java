/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import civitas.Jugador;
import civitas.JugadorEspeculador;
import civitas.TituloPropiedad;
import java.util.ArrayList;

/**
 *
 * @author sergio
 */
public class JugadorPanel extends javax.swing.JPanel {

    private Jugador jugador;
    private PropiedadPanel propiedad;
    
    /**
     * Creates new form JugadorPanel
     */
    public JugadorPanel() {
        initComponents();
    }
    
    void setJugador(Jugador jugador){
        
        this.jugador = jugador;
        nombreT.setText(jugador.getNombre());
        saldoT.setText(Float.toString(jugador.getSaldo()));
        encarceladoT.setText(Boolean.toString(jugador.isEncarcelado()));        
        especuladorT.setText(Boolean.toString(jugador.getClass() == JugadorEspeculador.class));
        repaint();
        rellenaPropiedades(jugador.getPropiedades());
    }
    
    private void rellenaPropiedades(ArrayList<TituloPropiedad> lista){
        propiedades.removeAll();
        
        for (TituloPropiedad t: lista){
            PropiedadPanel vistaPropiedad = new PropiedadPanel();
            vistaPropiedad.setPropiedad(t);
            propiedades.add(vistaPropiedad);
            vistaPropiedad.setVisible(true);
            repaint();
            revalidate();
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        nombreT = new javax.swing.JTextField();
        saldoT = new javax.swing.JTextField();
        encarceladoT = new javax.swing.JTextField();
        especuladorT = new javax.swing.JTextField();
        nombreL = new javax.swing.JLabel();
        saldoL = new javax.swing.JLabel();
        encarceladoL = new javax.swing.JLabel();
        especuladorL = new javax.swing.JLabel();
        propiedades = new javax.swing.JPanel();

        setEnabled(false);

        nombreT.setText("jTextField1");
        nombreT.setEnabled(false);
        nombreT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nombreTActionPerformed(evt);
            }
        });

        saldoT.setText("jTextField2");
        saldoT.setEnabled(false);

        encarceladoT.setText("jTextField3");
        encarceladoT.setEnabled(false);

        especuladorT.setText("jTextField4");
        especuladorT.setEnabled(false);

        nombreL.setText("Nombre:");

        saldoL.setText("Saldo:");

        encarceladoL.setText("Encarcelado:");

        especuladorL.setText("Especulador:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(encarceladoL)
                                    .addComponent(saldoL)
                                    .addComponent(nombreL))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(nombreT, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(saldoT, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(encarceladoT, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(especuladorL)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 575, Short.MAX_VALUE)
                                .addComponent(especuladorT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(propiedades, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(encarceladoL)
                    .addComponent(nombreT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(saldoT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nombreL))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(encarceladoT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(saldoL))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(especuladorT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(especuladorL))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(propiedades, javax.swing.GroupLayout.DEFAULT_SIZE, 248, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void nombreTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nombreTActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nombreTActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel encarceladoL;
    private javax.swing.JTextField encarceladoT;
    private javax.swing.JLabel especuladorL;
    private javax.swing.JTextField especuladorT;
    private javax.swing.JLabel nombreL;
    private javax.swing.JTextField nombreT;
    private javax.swing.JPanel propiedades;
    private javax.swing.JLabel saldoL;
    private javax.swing.JTextField saldoT;
    // End of variables declaration//GEN-END:variables
}
