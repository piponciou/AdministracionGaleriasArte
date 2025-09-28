
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class EditarEstadoObra extends javax.swing.JFrame {
    private Galeria galery;
    private ArrayList<Artista> artistas;
    private String statusSeleccionado;
    private String tituloSeleccionado;
    private String rutSeleccionado;
    private Artista artistaSeleccionado;

    public EditarEstadoObra(Galeria galery) {
        initComponents();
        this.galery = galery;
        this.artistas = galery.getArrayListArtista();
        
        int tamaño = 0;
        for(int i = 0; i<artistas.size();i++){
            Artista pp = artistas.get(i);
            ArrayList<Obra> obras = pp.getObras().getObras();
            for(int j = 0; j<obras.size();j++){
                tamaño++;
            }
        }
        String titulosYArtistas[] = new String[tamaño];
        int indice = 0;
        for(int i = 0; i<artistas.size();i++){
            Artista pp = artistas.get(i);
            ArrayList<Obra> obras = pp.getObras().getObras();
            for(int j = 0; j<obras.size();j++){
                Obra oo = obras.get(j);
                titulosYArtistas[indice] = oo.getTitle() + ", " + oo.getAutor().getNombre() + ", " + oo.getAutor().getRut();
                indice++;    
            }
        }
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(titulosYArtistas));   
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Roboto Black", 1, 18)); // NOI18N
        jLabel1.setText("EDITAR ESTADO OBRA");

        jLabel2.setFont(new java.awt.Font("Roboto Black", 1, 18)); // NOI18N
        jLabel2.setText("Seleccione la obra:");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Roboto Black", 1, 18)); // NOI18N
        jLabel3.setText("Seleccione el nuevo estado:");

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "DISPONIBLE", "PRESTADO", "VENDIDO" }));
        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2ActionPerformed(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Roboto Black", 1, 18)); // NOI18N
        jButton1.setText("CONFIRMAR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
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
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 72, Short.MAX_VALUE)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jComboBox2, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(162, 162, 162))
            .addGroup(layout.createSequentialGroup()
                .addGap(122, 122, 122)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel1)
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1)
                .addContainerGap(8, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
    String seleccionado = (String) jComboBox1.getSelectedItem();
    if (seleccionado != null) {       
        String[] partes = seleccionado.split(", ");
        if (partes.length > 2) {
            tituloSeleccionado = partes[0].trim();
            rutSeleccionado = partes[2].trim();
            
            artistaSeleccionado = null; // Reiniciar antes de buscar
            
            for (Artista artista : artistas) {
                if (artista.getRut().equals(rutSeleccionado)) {
                    artistaSeleccionado = artista;
                    break;
                }
            }
        }
    }
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
        Object seleccionado1 = jComboBox1.getSelectedItem();
        Object seleccionado2 = jComboBox2.getSelectedItem();

        if (seleccionado1 == null || seleccionado2 == null ||
            seleccionado1.toString().trim().isEmpty() || seleccionado2.toString().trim().isEmpty()) {
            // Alguno no está seleccionado o está vacío
            JOptionPane.showMessageDialog(null ,"INGRESE LAS DOS CASILLAS PORFAVOR");
        } else {
            if(artistaSeleccionado == null){
                JOptionPane.showMessageDialog(null, "Debe seleccionar una obra válida.");
                return;
            }
            try {
                System.out.println("Rut desde artistaSeleccionado: '" + artistaSeleccionado.getRut() + "'");
                System.out.println("Rut esperado en galery: '" + rutSeleccionado + "'");
                galery.editarEstadoObraDeArtista(artistaSeleccionado.getRut(),tituloSeleccionado,statusSeleccionado);
            } catch (ArtistaNoEncontradoException ex) {
                JOptionPane.showMessageDialog(null ,"Artista NO encontrado");
                return;
            }
            JOptionPane.showMessageDialog(null ,"MODIFICADO CON EXITO");
            dispose();
        }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed
        statusSeleccionado = jComboBox2.getSelectedItem().toString();
    }//GEN-LAST:event_jComboBox2ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    // End of variables declaration//GEN-END:variables
}
