package proyectoFinal;


import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;


public class ListadoExposiciones extends javax.swing.JFrame {

    private ArrayList<Exposicion> exposiciones;
    private Galeria galery;
    public ListadoExposiciones(Galeria galery) {
        initComponents();
        this.galery = galery;
        this.exposiciones = galery.getArrayListExposicion();
        /*LOGICA DE MOSTRAR LOS ARTISTAS EN LA LISTA*/
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0);
         
        for(int i = 0; i< exposiciones.size(); i++){
            Exposicion ee = exposiciones.get(i);
            ArrayList<Obra> oo = ee.getObrasExpuestas().getObras();
            /*se obtienen las obras concatenadas del artista en un String*/
            String obrasConcatenadas = "";
            for(int j = 0; j<oo.size(); j++){
                Obra actual = oo.get(j);
                obrasConcatenadas += actual.getTitle();
                if(j < oo.size()-1)
                    obrasConcatenadas +=", ";
            }
            
            
            Object[] fila = new Object[]{
                ee.getNombreExposicion(),
                ee.getFechaInicio(),
                ee.getFechaTermino(),
                ee.getLugar(),
                obrasConcatenadas
            };        
            model.addRow(fila);   
        }
       
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1035, 399));

        jLabel1.setFont(new java.awt.Font("Roboto Black", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Listado de Exposiciones");

        jTable1.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Nombre", "Inicio", "Termino", "lugar", "Obras"
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
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(396, 396, 396)
                .addComponent(jLabel1)
                .addContainerGap(445, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 359, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
