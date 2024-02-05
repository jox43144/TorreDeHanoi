/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package vista;

import javax.swing.JOptionPane;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import modelo.NodoCola;
import modelo.NodoPila;
import modelo.Registros;
import modelo.Torres;

/**
 *
 * @author zaqui
 */
public class Principal extends javax.swing.JFrame {

    /**
     * Creates new form AcercaDe
     */
    int contMovimientos = 0;
    Torres PilatorreA;
    Torres PilatorreB;
    Torres PilatorreC;
    DefaultTableModel modeloTorreA, modeloTorreB, modeloTorreC;
    int objetivo;
    double MinimoMovimientos = 0;
    boolean stop = false;
    Registros cola = new Registros();

    public Principal() {

        initComponents();

        getContentPane().setBackground(Color.PINK);
        txtMinimo.setEditable(false);
        txtRealizados.setEditable(false);
//configura las tablas y le pone 7 filas
        modeloTorreA = (DefaultTableModel) TorreA.getModel();
        modeloTorreA.setRowCount(7);

        modeloTorreB = (DefaultTableModel) TorreB.getModel();
        modeloTorreB.setRowCount(7);

        modeloTorreC = (DefaultTableModel) TorreC.getModel();
        modeloTorreC.setRowCount(7);
//este código personaliza la apariencia de las celdas en la columna 0 de las tablas
        DefaultTableCellRenderer renderA = new DefaultTableCellRenderer();
        renderA.setHorizontalAlignment(SwingConstants.CENTER);
        renderA.setVerticalAlignment(SwingConstants.BOTTOM);
        TorreA.getColumnModel().getColumn(0).setCellRenderer(renderA);

        DefaultTableCellRenderer renderB = new DefaultTableCellRenderer();
        renderB.setHorizontalAlignment(SwingConstants.CENTER);
        TorreB.getColumnModel().getColumn(0).setCellRenderer(renderB);

        DefaultTableCellRenderer renderC = new DefaultTableCellRenderer();
        renderC.setHorizontalAlignment(SwingConstants.CENTER);
        TorreC.getColumnModel().getColumn(0).setCellRenderer(renderC);
        iniciar();
    }

    private void Limpiar() {
        contMovimientos = 0;
        MinimoMovimientos = 0;
//        spCantidad.setValue(String.valueOf(objetivo));
    }

    private void CantMovimientos() {
        contMovimientos++;
        txtRealizados.setText(String.valueOf(contMovimientos));
    }

    private void iniciar() {
        try {
            PilatorreA = new Torres();
            PilatorreB = new Torres();
            PilatorreC = new Torres();
            objetivo = Integer.parseInt(spCantidad.getValue().toString());
            MinimoMovimientos = Math.pow(2, objetivo) - 1;
            txtRealizados.setText(String.valueOf(contMovimientos));
            txtMinimo.setText(String.valueOf(String.format("%.0f", MinimoMovimientos)));
            for (int x = objetivo; x >= 1; x--) {
                NodoPila nodo = new NodoPila();
                String Disco = "[";
                for (int i = x; i > 0; i--) {
                    Disco += "*";
                }
                Disco += "]";
                nodo.setdisco(Disco);
                PilatorreA.apilar(nodo);
            }
            IniciarA();
            IniciarB();
            IniciarC();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "A habido un error desconocido", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void IniciarA() {
        try {
            ((DefaultTableModel) TorreA.getModel()).setRowCount(0);
            modeloTorreA.setRowCount(7);
            NodoPila i;
            int filas = (7 - PilatorreA.getTamano());
            if (PilatorreA.getTamano() > 0) {
                for (i = PilatorreA.getInicio(); i.getSiguiente() != null; i = i.getSiguiente()) {
                    String[] vector = {i.getdisco()};
                    modeloTorreA.insertRow(filas, vector);
                    filas++;
                }
                if (i.getSiguiente() == null) {
                    String[] vector = {i.getdisco()};
                    modeloTorreA.insertRow(filas, vector);
                }
            }
            TorreA.setModel(modeloTorreA);
            modeloTorreA.setRowCount(7);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "A habido un error desconocido", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void IniciarB() {
        try {
            ((DefaultTableModel) TorreB.getModel()).setRowCount(0);
            modeloTorreB.setRowCount(7);
            NodoPila i;
            int filas = (7 - PilatorreB.getTamano());
            if (PilatorreB.getTamano() > 0) {
                for (i = PilatorreB.getInicio(); i.getSiguiente() != null; i = i.getSiguiente()) {
                    String[] vector = {i.getdisco()};
                    modeloTorreB.insertRow(filas, vector);
                    filas++;
                }
                if (i.getSiguiente() == null) {
                    String[] vector = {i.getdisco()};
                    modeloTorreB.insertRow(filas, vector);
                }
            }
            TorreB.setModel(modeloTorreB);
            modeloTorreB.setRowCount(7);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "A habido un error desconocido", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void IniciarC() {
        try {
            ((DefaultTableModel) TorreC.getModel()).setRowCount(0);
            modeloTorreC.setRowCount(7);
            NodoPila i;
            int filas = (7 - PilatorreC.getTamano());
            if (PilatorreC.getTamano() > 0) {
                for (i = PilatorreC.getInicio(); i.getSiguiente() != null; i = i.getSiguiente()) {
                    String[] vector = {i.getdisco()};
                    modeloTorreC.insertRow(filas, vector);
                    filas++;
                }
                if (i.getSiguiente() == null) {
                    String[] vector = {i.getdisco()};
                    modeloTorreC.insertRow(filas, vector);
                }
            }
            TorreC.setModel(modeloTorreC);
            modeloTorreC.setRowCount(7);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "A habido un error desconocido", "Error", JOptionPane.ERROR_MESSAGE);
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

        AaB = new javax.swing.JButton();
        AaC = new javax.swing.JButton();
        BaA = new javax.swing.JButton();
        BaC = new javax.swing.JButton();
        CaA = new javax.swing.JToggleButton();
        CaB = new javax.swing.JToggleButton();
        jLabel1 = new javax.swing.JLabel();
        spCantidad = new javax.swing.JSpinner();
        jLabel2 = new javax.swing.JLabel();
        txtMinimo = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtRealizados = new javax.swing.JTextField();
        btnReiniciar = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        TorreA = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        TorreB = new javax.swing.JTable();
        jScrollPane5 = new javax.swing.JScrollPane();
        TorreC = new javax.swing.JTable();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setUndecorated(true);

        AaB.setText("B");
        AaB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AaBActionPerformed(evt);
            }
        });

        AaC.setText("C");
        AaC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AaCActionPerformed(evt);
            }
        });

        BaA.setText("A");
        BaA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BaAActionPerformed(evt);
            }
        });

        BaC.setText("C");
        BaC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BaCActionPerformed(evt);
            }
        });

        CaA.setText("A");
        CaA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CaAActionPerformed(evt);
            }
        });

        CaB.setText("B");
        CaB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CaBActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Microsoft Tai Le", 3, 14)); // NOI18N
        jLabel1.setText("Cantidad de discos:");

        spCantidad.setFont(new java.awt.Font("Microsoft Tai Le", 3, 12)); // NOI18N
        spCantidad.setModel(new javax.swing.SpinnerNumberModel(3, 3, 7, 1));

        jLabel2.setFont(new java.awt.Font("Microsoft Tai Le", 3, 14)); // NOI18N
        jLabel2.setText("Minimo de movimientos:");

        jLabel3.setFont(new java.awt.Font("Microsoft Tai Le", 3, 14)); // NOI18N
        jLabel3.setText("Movimientos realizados:");

        btnReiniciar.setText("Reiniciar");
        btnReiniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReiniciarActionPerformed(evt);
            }
        });

        jButton1.setText("Registro");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        TorreA.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Torre A"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(TorreA);
        if (TorreA.getColumnModel().getColumnCount() > 0) {
            TorreA.getColumnModel().getColumn(0).setResizable(false);
        }

        TorreB.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Torre B"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane4.setViewportView(TorreB);
        if (TorreB.getColumnModel().getColumnCount() > 0) {
            TorreB.getColumnModel().getColumn(0).setResizable(false);
        }

        TorreC.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Torre C"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane5.setViewportView(TorreC);
        if (TorreC.getColumnModel().getColumnCount() > 0) {
            TorreC.getColumnModel().getColumn(0).setResizable(false);
        }

        jMenu1.setText("Archivo");

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jMenuItem1.setText("Salir");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Ayuda");

        jMenuItem2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jMenuItem2.setText("Acerca de");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem2);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(AaC, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 80, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(BaA, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(BaC, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 81, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(CaA, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(CaB, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(AaB, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(134, 134, 134)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(btnReiniciar)
                        .addComponent(jLabel3)))
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(spCantidad, javax.swing.GroupLayout.DEFAULT_SIZE, 81, Short.MAX_VALUE)
                        .addComponent(txtRealizados))
                    .addComponent(txtMinimo, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(141, 141, 141))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(13, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 144, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                .addGap(52, 52, 52)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(BaA)
                        .addComponent(BaC)
                        .addComponent(CaB)
                        .addComponent(CaA))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(AaB)
                        .addComponent(AaC)))
                .addGap(60, 60, 60)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(spCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMinimo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtRealizados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnReiniciar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
public void ganarB() {
        if (PilatorreB.getTamano() == objetivo && contMovimientos == MinimoMovimientos) {
            JOptionPane.showMessageDialog(this, "Felicidades, ganaste con el minimo de movimientos", "Ganaste", JOptionPane.INFORMATION_MESSAGE);
            insertarCola();
            Limpiar();
            iniciar();
        } else if (PilatorreB.getTamano() == objetivo && contMovimientos != MinimoMovimientos) {
            JOptionPane.showMessageDialog(this, "Felicidades, ganaste, intenta superar tu récord", "Ganaste", JOptionPane.INFORMATION_MESSAGE);
            insertarCola();
            Limpiar();
            iniciar();
        }

    }

    public void ganarC() {
        if (PilatorreC.getTamano() == objetivo && contMovimientos == MinimoMovimientos) {
            JOptionPane.showMessageDialog(this, "Felicidades, ganaste con el minimo de movimientos", "Ganaste", JOptionPane.INFORMATION_MESSAGE);
            insertarCola();
            Limpiar();
            iniciar();
        } else if (PilatorreC.getTamano() == objetivo && contMovimientos != MinimoMovimientos) {
            JOptionPane.showMessageDialog(this, "Felicidades, ganaste, intenta superar tu récord", "Ganaste", JOptionPane.INFORMATION_MESSAGE);
            insertarCola();
            Limpiar();
            iniciar();
        }

    }

    public void insertarCola() {
        try {
            String nombre;
            do {
                nombre = JOptionPane.showInputDialog(this, "Ingresa tu nombre", "Ganador", JOptionPane.INFORMATION_MESSAGE);
            } while (nombre == null || nombre.trim().isEmpty());

            if (!nombre.equals("")) {
                cola.insertar(nombre, Integer.parseInt(txtRealizados.getText()));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "A habido un error desconocido", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed

        if (JOptionPane.showConfirmDialog(this, "¿Quiere Salir?", "Confirmacion", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            System.exit(0);
        } else {

        }
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        AcercaDe ventana = new AcercaDe();
        ventana.setVisible(true);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void btnReiniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReiniciarActionPerformed
        try {
            if (PilatorreA.getTamano() != objetivo) {
                if (JOptionPane.showConfirmDialog(this, "¿Quiere reiniciar?", "Confirmacion", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                    Limpiar();
                    iniciar();
                }
            } else {
                Limpiar();
                iniciar();
            }

        } catch (Exception EX) {
            JOptionPane.showMessageDialog(this, "A habido un error desconocido", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnReiniciarActionPerformed

    private void AaBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AaBActionPerformed
        try {
            if (PilatorreA.getTamano() > 0) {
                NodoPila auxiliar = new NodoPila();
                auxiliar.setdisco(PilatorreA.cima());
                if (PilatorreB.getTamano() > 0) {

                    if (auxiliar.getdisco().compareTo(PilatorreB.cima()) < 0) {
                        JOptionPane.showMessageDialog(this, "Movimiento ilegal", "Error", JOptionPane.ERROR_MESSAGE);
                        CantMovimientos();
                        return;
                    }

                }
                PilatorreA.remover();
                PilatorreB.apilar(auxiliar);
                IniciarA();
                IniciarB();
                CantMovimientos();
                ganarB();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "A habido un error desconocido", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_AaBActionPerformed

    private void AaCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AaCActionPerformed
        try {
            if (PilatorreA.getTamano() > 0) {
                NodoPila auxiliar = new NodoPila();
                auxiliar.setdisco(PilatorreA.cima());
                if (PilatorreC.getTamano() > 0) {

                    if (auxiliar.getdisco().compareTo(PilatorreC.cima()) < 0) {
                        JOptionPane.showMessageDialog(this, "Movimiento ilegal", "Error", JOptionPane.ERROR_MESSAGE);
                        CantMovimientos();
                        return;
                    }

                }
                PilatorreA.remover();
                PilatorreC.apilar(auxiliar);
                IniciarA();
                IniciarC();
                CantMovimientos();
                ganarC();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "A habido un error desconocido", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_AaCActionPerformed

    private void BaAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BaAActionPerformed
        try {
            if (PilatorreB.getTamano() > 0) {
                NodoPila auxiliar = new NodoPila();
                auxiliar.setdisco(PilatorreB.cima());
                if (PilatorreA.getTamano() > 0) {

                    if (auxiliar.getdisco().compareTo(PilatorreA.cima()) < 0) {
                        JOptionPane.showMessageDialog(this, "Movimiento ilegal", "Error", JOptionPane.ERROR_MESSAGE);
                        CantMovimientos();
                        return;
                    }

                }
                PilatorreB.remover();
                PilatorreA.apilar(auxiliar);
                IniciarB();
                IniciarA();
                CantMovimientos();

            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "A habido un error desconocido", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_BaAActionPerformed

    private void BaCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BaCActionPerformed
        try {
            if (PilatorreB.getTamano() > 0) {
                NodoPila auxiliar = new NodoPila();
                auxiliar.setdisco(PilatorreB.cima());
                if (PilatorreC.getTamano() > 0) {

                    if (auxiliar.getdisco().compareTo(PilatorreC.cima()) < 0) {
                        JOptionPane.showMessageDialog(this, "Movimiento ilegal", "Error", JOptionPane.ERROR_MESSAGE);
                        CantMovimientos();
                        return;
                    }

                }
                PilatorreB.remover();
                PilatorreC.apilar(auxiliar);
                IniciarB();
                IniciarC();
                CantMovimientos();
                ganarC();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "A habido un error desconocido", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_BaCActionPerformed

    private void CaAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CaAActionPerformed
        try {
            if (PilatorreC.getTamano() > 0) {
                NodoPila auxiliar = new NodoPila();
                auxiliar.setdisco(PilatorreC.cima());
                if (PilatorreA.getTamano() > 0) {

                    if (auxiliar.getdisco().compareTo(PilatorreA.cima()) < 0) {
                        JOptionPane.showMessageDialog(this, "Movimiento ilegal", "Error", JOptionPane.ERROR_MESSAGE);
                        CantMovimientos();
                        return;
                    }

                }
                PilatorreC.remover();
                PilatorreA.apilar(auxiliar);
                IniciarC();
                IniciarA();
                CantMovimientos();

            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "A habido un error desconocido", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_CaAActionPerformed

    private void CaBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CaBActionPerformed
        try {
            if (PilatorreC.getTamano() > 0) {
                NodoPila auxiliar = new NodoPila();
                auxiliar.setdisco(PilatorreC.cima());
                if (PilatorreB.getTamano() > 0) {

                    if (auxiliar.getdisco().compareTo(PilatorreB.cima()) < 0) {
                        JOptionPane.showMessageDialog(this, "Movimiento ilegal", "Error", JOptionPane.ERROR_MESSAGE);
                        CantMovimientos();
                        return;
                    }

                }
                PilatorreC.remover();
                PilatorreB.apilar(auxiliar);
                IniciarC();
                IniciarB();
                CantMovimientos();
                ganarB();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "A habido un error desconocido", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_CaBActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
      try{
        cola.ordenarNombres();
        cola.ordenarPuntos();
        JOptionPane.showMessageDialog(this, cola.imprimir(), "Clasificacion", JOptionPane.INFORMATION_MESSAGE);
      }catch(Exception e){
             JOptionPane.showMessageDialog(this, "Aun no hay puntuaciones", "Error", JOptionPane.INFORMATION_MESSAGE);
      }
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton AaB;
    public javax.swing.JButton AaC;
    public javax.swing.JButton BaA;
    public javax.swing.JButton BaC;
    public javax.swing.JToggleButton CaA;
    public javax.swing.JToggleButton CaB;
    private javax.swing.JTable TorreA;
    private javax.swing.JTable TorreB;
    private javax.swing.JTable TorreC;
    public javax.swing.JButton btnReiniciar;
    public javax.swing.JButton jButton1;
    public javax.swing.JLabel jLabel1;
    public javax.swing.JLabel jLabel2;
    public javax.swing.JLabel jLabel3;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    public javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JScrollPane jScrollPane4;
    public javax.swing.JScrollPane jScrollPane5;
    public javax.swing.JSpinner spCantidad;
    public javax.swing.JTextField txtMinimo;
    public javax.swing.JTextField txtRealizados;
    // End of variables declaration//GEN-END:variables
}
