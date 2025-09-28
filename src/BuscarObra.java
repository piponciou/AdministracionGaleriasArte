
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;


public class BuscarObra extends javax.swing.JFrame {

    private Galeria galery;
    private Artista artistaSeleccionado;
    private ArrayList<Artista> artistas;
    
    public BuscarObra(Galeria galery) {
        initComponents();
        this.galery = galery;
        this.artistas = galery.getArrayListArtista();
        
        /*LOGICA PARA MOSTRAR TODAS LAS OBRAS*/
        int tamaño = 0;
        for(int c = 0; c<artistas.size();c++){
            Artista pp = artistas.get(c);
            ArrayList<Obra> obras = pp.getObras().getObras();
            for(int i = 0; i<obras.size();i++){
                if(obras.get(i) != null)
                    tamaño++;
            }
        }
        String nombreObras[] = new String[tamaño];
        /*rellenamos el vector*/
        for(int q = 0; q<artistas.size();q++){
            Artista pp = artistas.get(q);
            ArrayList<Obra> obras = pp.getObras().getObras();
            for(int x = 0; x<obras.size(); x++){
                if(obras.get(x)!=null){
                    nombreObras[x] = obras.get(x).getTitle();
                }
                    
            }
        }
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(nombreObras));
        
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
        jLabel1.setText("BUSCAR OBRA ");

        jTable1.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Nombre", "Autor", "Costo", "Año", "Estado"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true
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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 574, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(224, 224, 224)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 359, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        String titleSeleccionado = jComboBox1.getSelectedItem().toString();
        
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0);
        for(int i = 0; i<artistas.size();i++){
            Artista pp = artistas.get(i);
            ArrayList<Obra> obrasArtista = pp.getObras().getObras();
            for(int j = 0; j<obrasArtista.size() ; j++){
                Obra oo = obrasArtista.get(j);
                if(oo.getTitle().equals(titleSeleccionado)){
                    Object[] fila = new Object[]{
                    oo.getTitle(),
                    oo.getAutor().getNombre(),
                    oo.getCost(),
                    oo.getYear(),
                    oo.getStatus(),
                    };        
                    model.addRow(fila);
                }
            }
        }
    }//GEN-LAST:event_jComboBox1ActionPerformed



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
