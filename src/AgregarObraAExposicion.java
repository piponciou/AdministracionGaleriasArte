
import java.util.ArrayList;
import javax.swing.JOptionPane;


public class AgregarObraAExposicion extends javax.swing.JFrame {

    private Galeria galery;
    private ArrayList<Artista> artistas;
    private Artista artistaSeleccionado;
    private ArrayList<Exposicion> exposiciones;
    private Exposicion exposicionSeleccionada;
    
    public AgregarObraAExposicion(Galeria galery) {
        initComponents();
       this.galery = galery;
       artistas = galery.getArrayListArtista();
       /* LOGICA PARA MOSTRAR LOS ARTISTAS COMO SELECCIONABLES EN LA VENTANA*/
       artistas = galery.getArrayListArtista();
       String nombresArtistas[] = new String[artistas.size()];
       for (int i = 0 ; i<artistas.size(); i++){
           nombresArtistas[i] = artistas.get(i).getNombre() + ", " + artistas.get(i).getRut();   
       }
       jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(nombresArtistas));
        /*----------------------------------------------------------------------*/
        
        /*LOGICA PARA MOSTRAR LAS EXPOSICIONES COMO SELECCIONABLES EN LA VENTANA*/
        exposiciones = galery.getArrayListExposicion();
        String nombresExposiciones[] = new String[exposiciones.size()];
        for(int j = 0; j<exposiciones.size(); j++){
            nombresExposiciones[j] = exposiciones.get(j).getNombreExposicion();
        }
        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(nombresExposiciones));
        /*-----------------------------------------------------------------------------*/
        
        /*LOGICA PARA MOSTRAR LAS OBRAS DE ARTISTA SELECCIONADO*/       
        int indice = jComboBox3.getSelectedIndex();
        artistaSeleccionado = artistas.get(indice);
        int tamaño = 0;
        for(int c = 0; c<artistas.size();c++){
            Artista pp = artistas.get(c);
            if(pp.getRut().equals(artistaSeleccionado.getRut())){
                ArrayList<Obra> obrasArtista = pp.getObras().getObras();
                for(int x = 0; x<obrasArtista.size(); x++){
                    tamaño ++;
                }
            }
        }
        String nombreObrasArtista[] = new String[tamaño];
        /*rellenamos el vector*/
        for(int q = 0; q<artistas.size();q++){
            Artista pp = artistas.get(q);
            if(pp.getRut().equals(artistaSeleccionado.getRut())){
                ArrayList<Obra> obrasArtista = pp.getObras().getObras();
                for(int w = 0; w<obrasArtista.size(); w++){
                    Obra obra = obrasArtista.get(w);
                    nombreObrasArtista[w] = obra.getTitle();
                }
            }
        }
        jComboBox4.setModel(new javax.swing.DefaultComboBoxModel<>(nombreObrasArtista));
    }
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jComboBox1 = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jComboBox3 = new javax.swing.JComboBox<>();
        jComboBox4 = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "DISPONIBLE", "VENDIDO", "PRESTADO" }));

        jButton1.setFont(new java.awt.Font("Roboto Black", 1, 24)); // NOI18N
        jButton1.setText("Agregar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Roboto Black", 1, 18)); // NOI18N
        jLabel7.setText("Seleccione la exposicion:");

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Roboto Black", 1, 24)); // NOI18N
        jLabel1.setText("Agregar Obra");

        jLabel2.setFont(new java.awt.Font("Roboto Black", 1, 18)); // NOI18N
        jLabel2.setText("Ingrese el titulo de la obra:");

        jLabel3.setFont(new java.awt.Font("Roboto Black", 1, 18)); // NOI18N
        jLabel3.setText("Ingrese el año de la obra:");

        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Roboto Black", 1, 18)); // NOI18N
        jLabel4.setText("Ingrese el valor de la obra:");

        jTextField3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField3ActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Roboto Black", 0, 18)); // NOI18N
        jLabel5.setText("Ingrese el estado de la obra:");

        jLabel6.setFont(new java.awt.Font("Roboto Black", 1, 18)); // NOI18N
        jLabel6.setText("Seleccione al artista:");

        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox3ActionPerformed(evt);
            }
        });

        jComboBox4.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel2))
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jTextField3, javax.swing.GroupLayout.DEFAULT_SIZE, 302, Short.MAX_VALUE)
                            .addComponent(jTextField2, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jComboBox2, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jComboBox3, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jComboBox4, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(225, 225, 225)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        if(jTextField1.getText().isEmpty() || jTextField2.getText().trim().isEmpty() || jTextField3.getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(null,"Porfavor Ingrese todas las casillas!");
            return;
        }
        String titulo = jTextField1.getText();
        String estado = jComboBox1.getSelectedItem().toString();
        int año = 0;
        double costo = 0;
        int indice = jComboBox3.getSelectedIndex();
        artistaSeleccionado = artistas.get(indice);

        try{
            String texto = jTextField2.getText().trim();
            año = Integer.parseInt(texto);
            texto = jTextField3.getText();
            costo = Double.parseDouble(texto);

        }catch(NumberFormatException e){

            JOptionPane.showMessageDialog(null,"el año o costo ingresado no es valida!");
        }
        if (artistaSeleccionado == null) {
            JOptionPane.showMessageDialog(null, "Por favor seleccione un artista.");
        }

        Obra oo = new Obra(titulo,artistaSeleccionado,año,costo,estado);

        galery.agregarObraAArtista(artistaSeleccionado, oo);

        JOptionPane.showMessageDialog(null,"Obra agregado al artista con exito!");

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed

    }//GEN-LAST:event_jComboBox2ActionPerformed

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void jTextField3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField3ActionPerformed

    private void jComboBox3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox3ActionPerformed
        /*LOGICA PARA MOSTRAR LAS OBRAS DE ARTISTA SELECCIONADO*/       
        int indice = jComboBox3.getSelectedIndex();
        artistaSeleccionado = artistas.get(indice);
        int tamaño = 0;
        for(int c = 0; c<artistas.size();c++){
            Artista pp = artistas.get(c);
            if(pp.getRut().equals(artistaSeleccionado.getRut())){
                ArrayList<Obra> obrasArtista = pp.getObras().getObras();
                for(int x = 0; x<obrasArtista.size(); x++){
                    tamaño ++;
                }
            }
        }
        String nombreObrasArtista[] = new String[tamaño];
        /*rellenamos el vector*/
        for(int q = 0; q<artistas.size();q++){
            Artista pp = artistas.get(q);
            if(pp.getRut().equals(artistaSeleccionado.getRut())){
                ArrayList<Obra> obrasArtista = pp.getObras().getObras();
                for(int w = 0; w<obrasArtista.size(); w++){
                    Obra obra = obrasArtista.get(w);
                    nombreObrasArtista[w] = obra.getTitle();
                }
            }
        }
        jComboBox4.setModel(new javax.swing.DefaultComboBoxModel<>(nombreObrasArtista));
    }//GEN-LAST:event_jComboBox3ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JComboBox<String> jComboBox4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    // End of variables declaration//GEN-END:variables
}
