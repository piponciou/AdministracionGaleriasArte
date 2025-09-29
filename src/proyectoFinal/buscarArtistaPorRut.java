package proyectoFinal;


import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;


public class buscarArtistaPorRut extends javax.swing.JFrame {
    
    private Galeria galery;
    private ArrayList<Artista> artistas;
    private Artista artistaSeleccionado;
    
    public buscarArtistaPorRut(Galeria galery) {
        initComponents();
        this.galery = galery;
        artistas = galery.getArrayListArtista();
        int tamaño = 0;
        
        for(int i = 0; i<artistas.size();i++){
            if(artistas.get(i) != null)
                tamaño ++;
        }
        String nombRutArtistas[] = new String[tamaño];
        for(int j = 0; j<artistas.size();j++){
            Artista pp = artistas.get(j);
            nombRutArtistas[j] = pp.getNombre() + ", " + pp.getRut();
        }
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(nombRutArtistas));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jComboBox1.setFont(new java.awt.Font("Roboto Black", 1, 14)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "DISPONIBLE", "PRESTADO", "VENDIDO" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Roboto Black", 1, 18)); // NOI18N
        jLabel1.setText("BUSCAR ARTISTA");

        jTable1.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Nombre", "RUT", "Edad", "Obras"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 752, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(296, 296, 296)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 359, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
       int indice = jComboBox1.getSelectedIndex();
       artistaSeleccionado = artistas.get(indice);
       ArrayList<Obra> obrasArtista = artistaSeleccionado.getObras().getObras();
        
       DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
       model.setRowCount(0);
       
       String nombreObrasArtista = "";
       for(int i = 0 ; i<obrasArtista.size();i++){
           Obra oo = obrasArtista.get(i);
           nombreObrasArtista += oo.getTitle() + ", ";
       }
       Object[] fila = new Object[]{           
            artistaSeleccionado.getNombre(),
            artistaSeleccionado.getRut(),
            artistaSeleccionado.getEdad(),
            nombreObrasArtista
            };        
            model.addRow(fila); 
       
    }//GEN-LAST:event_jComboBox1ActionPerformed

   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
