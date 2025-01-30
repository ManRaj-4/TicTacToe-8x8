import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author manrajs
 */
public class MainFrame extends javax.swing.JFrame {

    int boardSize = 8;
    JButton[][] buttons = new JButton[boardSize][boardSize];
    String[] playerMarks = new String[3];
    int currentPlayer =0;
    boolean[] playerSet = {false,false,false};
    /**
     * Creates new form MainFrame
     */
    public MainFrame() {
        initComponents();

        buttons[0][0] = jButton1;
        buttons[0][1] = jButton2;
        buttons[0][2] = jButton3;
        buttons[0][3] = jButton4;
        buttons[0][4] = jButton5;
        buttons[0][5] = jButton6;
        buttons[0][6] = jButton7;
        buttons[0][7] = jButton8;

        buttons[1][0] = jButton9;
        buttons[1][1] = jButton10;
        buttons[1][2] = jButton11;
        buttons[1][3] = jButton12;
        buttons[1][4] = jButton13;
        buttons[1][5] = jButton14;
        buttons[1][6] = jButton15;
        buttons[1][7] = jButton16;

        buttons[2][0] = jButton17;
        buttons[2][1] = jButton18;
        buttons[2][2] = jButton19;
        buttons[2][3] = jButton20;
        buttons[2][4] = jButton21;
        buttons[2][5] = jButton22;
        buttons[2][6] = jButton23;
        buttons[2][7] = jButton24;

        buttons[3][0] = jButton25;
        buttons[3][1] = jButton26;
        buttons[3][2] = jButton27;
        buttons[3][3] = jButton28;
        buttons[3][4] = jButton29;
        buttons[3][5] = jButton30;
        buttons[3][6] = jButton31;
        buttons[3][7] = jButton32;

        buttons[4][0] = jButton33;
        buttons[4][1] = jButton34;
        buttons[4][2] = jButton35;
        buttons[4][3] = jButton36;
        buttons[4][4] = jButton37;
        buttons[4][5] = jButton38;
        buttons[4][6] = jButton39;
        buttons[4][7] = jButton40;

        buttons[5][0] = jButton41;
        buttons[5][1] = jButton42;
        buttons[5][2] = jButton43;
        buttons[5][3] = jButton44;
        buttons[5][4] = jButton45;
        buttons[5][5] = jButton46;
        buttons[5][6] = jButton47;
        buttons[5][7] = jButton48;

        buttons[6][0] = jButton49;
        buttons[6][1] = jButton50;
        buttons[6][2] = jButton51;
        buttons[6][3] = jButton52;
        buttons[6][4] = jButton53;
        buttons[6][5] = jButton54;
        buttons[6][6] = jButton55;
        buttons[6][7] = jButton56;

        buttons[7][0] = jButton57;
        buttons[7][1] = jButton58;
        buttons[7][2] = jButton59;
        buttons[7][3] = jButton60;
        buttons[7][4] = jButton61;
        buttons[7][5] = jButton62;
        buttons[7][6] = jButton63;
        buttons[7][7] = jButton64;

        for(int row =0;row<boardSize;row++){
            for(int col=0;col<boardSize;col++){
                buttons[row][col].addActionListener(new BoardButtonListener(row,col));
            }
        }
    }

    private class BoardButtonListener implements ActionListener{
        private int row,col;

        public BoardButtonListener(int row,int col){
            this.row = row;
            this.col = col;
        }

        @Override
        public void actionPerformed(ActionEvent e){
            if(!allPlayerSet()){
                JOptionPane.showMessageDialog(MainFrame.this, "All players must set their Mark first");
                return;
            }

            buttons[row][col].setText(playerMarks[currentPlayer]);

            if(checkWin(row,col,playerMarks[currentPlayer])){
                JOptionPane.showMessageDialog(MainFrame.this,"Player " +
                        (currentPlayer+1) + " Wins");
                resetGame();
                return;
            }

            currentPlayer = (currentPlayer+1)%3;
            playerTurn.setText("Player " + (currentPlayer+1) + " Turn");
            buttons[row][col].setEnabled(false);
        }
    }

    boolean checkWin(int row,int col, String mark){
        return checkHorizontal(row,col,mark) ||
                checkVertical(row,col,mark)   ||
                checkDiagonalTopLeftToBottomRight(mark)||
                checkDiagonalTopRightToBottomLeft(mark);
    }

    boolean checkHorizontal(int row, int col, String mark){
        for(int i=0;i<=boardSize-4;i++){
            if(buttons[row][i].getText().equals(mark)&&
                    buttons[row][i+1].getText().equals(mark)&&
                    buttons[row][i+2].getText().equals(mark)&&
                    buttons[row][i+3].getText().equals(mark))
            {
                return true;
            }
        }
        return false;
    }

    boolean checkVertical(int row, int col, String mark){
        for(int i=0;i<=boardSize-4;i++){
            if(buttons[i][col].getText().equals(mark)&&
                    buttons[i+1][col].getText().equals(mark)&&
                    buttons[i+2][col].getText().equals(mark)&&
                    buttons[i+3][col].getText().equals(mark))
            {
                return true;
            }
        }
        return false;
    }

    boolean checkDiagonalTopLeftToBottomRight(String mark){
        for(int i=0;i<=boardSize-4;i++){
            for(int j=0;j<=boardSize-4;j++){
                if(buttons[i][j].getText().equals(mark) &&
                        buttons[i+1][j+1].getText().equals(mark) &&
                        buttons[i+2][j+2].getText().equals(mark) &&
                        buttons[i+3][j+3].getText().equals(mark)
                )
                    return true;
            }
        }

        return false;
    }

    boolean checkDiagonalTopRightToBottomLeft(String mark){
        for(int i=0;i<=boardSize-4;i++){
            for(int j=3;j<boardSize;j++){
                if(buttons[i][j].getText().equals(mark) &&
                        buttons[i+1][j-1].getText().equals(mark) &&
                        buttons[i+2][j-2].getText().equals(mark) &&
                        buttons[i+3][j-3].getText().equals(mark)){
                    return true;
                }
            }
        }
        return false;
    }



    void startGame(){

        playerMarks[0]= mark1.getText().trim();
        playerMarks[1]= mark2.getText().trim();
        playerMarks[2]= mark3.getText().trim();
        for(int i=0;i<3;i++){
            String tempMark=playerMarks[i];
            if(tempMark.isBlank()||tempMark.length()!=1){
                JOptionPane.showMessageDialog(this, "Player " + (i + 1) + " must enter a single character as their mark.");
                return;
            }

            for (int j = 0; j < i; j++) {
                if (tempMark.equals(playerMarks[j])) {
                    JOptionPane.showMessageDialog(this, "Player " + (i + 1) + " cannot use the same mark as Player " + (j + 1) + ".");
                    return;
                }
            }

            playerMarks[i] = tempMark;
            playerSet[i]=true;
        }

        playerTurn.setText("Player 1 Turn");
        NewGame.setText("Reset Board");


    }

    void resetGame(){
        for(int row=0;row<boardSize;row++){
            for(int col=0;col<boardSize;col++){
                buttons[row][col].setText("");
                buttons[row][col].setEnabled(true);
            }
        }
        currentPlayer = 0;

    }

    boolean allPlayerSet(){
        for(int i=0;i<3;i++){
            if(playerSet[i]==false){
                return false;
            }
        }
        return true;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        NewGame = new javax.swing.JButton();
        mark1 = new javax.swing.JTextField();
        mark2 = new javax.swing.JTextField();
        mark3 = new javax.swing.JTextField();
        playerTurn = new javax.swing.JLabel();
        buttonPanel = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        jButton13 = new javax.swing.JButton();
        jButton14 = new javax.swing.JButton();
        jButton15 = new javax.swing.JButton();
        jButton16 = new javax.swing.JButton();
        jButton17 = new javax.swing.JButton();
        jButton18 = new javax.swing.JButton();
        jButton19 = new javax.swing.JButton();
        jButton20 = new javax.swing.JButton();
        jButton21 = new javax.swing.JButton();
        jButton22 = new javax.swing.JButton();
        jButton23 = new javax.swing.JButton();
        jButton24 = new javax.swing.JButton();
        jButton25 = new javax.swing.JButton();
        jButton26 = new javax.swing.JButton();
        jButton27 = new javax.swing.JButton();
        jButton28 = new javax.swing.JButton();
        jButton29 = new javax.swing.JButton();
        jButton30 = new javax.swing.JButton();
        jButton31 = new javax.swing.JButton();
        jButton32 = new javax.swing.JButton();
        jButton33 = new javax.swing.JButton();
        jButton34 = new javax.swing.JButton();
        jButton35 = new javax.swing.JButton();
        jButton36 = new javax.swing.JButton();
        jButton37 = new javax.swing.JButton();
        jButton38 = new javax.swing.JButton();
        jButton39 = new javax.swing.JButton();
        jButton40 = new javax.swing.JButton();
        jButton41 = new javax.swing.JButton();
        jButton42 = new javax.swing.JButton();
        jButton43 = new javax.swing.JButton();
        jButton44 = new javax.swing.JButton();
        jButton45 = new javax.swing.JButton();
        jButton46 = new javax.swing.JButton();
        jButton47 = new javax.swing.JButton();
        jButton48 = new javax.swing.JButton();
        jButton49 = new javax.swing.JButton();
        jButton50 = new javax.swing.JButton();
        jButton51 = new javax.swing.JButton();
        jButton52 = new javax.swing.JButton();
        jButton53 = new javax.swing.JButton();
        jButton54 = new javax.swing.JButton();
        jButton55 = new javax.swing.JButton();
        jButton56 = new javax.swing.JButton();
        jButton57 = new javax.swing.JButton();
        jButton58 = new javax.swing.JButton();
        jButton59 = new javax.swing.JButton();
        jButton60 = new javax.swing.JButton();
        jButton61 = new javax.swing.JButton();
        jButton62 = new javax.swing.JButton();
        jButton63 = new javax.swing.JButton();
        jButton64 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("TicTacToe");
        setPreferredSize(new java.awt.Dimension(540, 800));

        jPanel1.setLayout(new java.awt.BorderLayout());

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));
        jPanel2.setForeground(new java.awt.Color(204, 204, 204));

        jLabel1.setText("Player 1:");

        jLabel2.setText("Player 2:");

        jLabel3.setText("Player 3:");

        NewGame.setText("Set mark and Start Game");
        NewGame.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NewGameActionPerformed(evt);
            }
        });

        playerTurn.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        playerTurn.setText("Enter marks");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(mark1, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(52, 52, 52)
                                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(mark2, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(66, 66, 66)
                                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addGap(141, 141, 141)
                                                .addComponent(NewGame, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(mark3, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(playerTurn, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(31, Short.MAX_VALUE))
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel1, jLabel2, jLabel3});

        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel1)
                                        .addComponent(jLabel2)
                                        .addComponent(jLabel3)
                                        .addComponent(mark1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(mark2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(mark3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(NewGame, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(playerTurn))
                                .addContainerGap(12, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel2, java.awt.BorderLayout.PAGE_START);

        buttonPanel.setMinimumSize(new java.awt.Dimension(400, 400));
        buttonPanel.setLayout(new java.awt.GridLayout(8, 8));

        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        buttonPanel.add(jButton1);
        buttonPanel.add(jButton2);
        buttonPanel.add(jButton3);
        buttonPanel.add(jButton4);
        buttonPanel.add(jButton5);
        buttonPanel.add(jButton6);
        buttonPanel.add(jButton7);
        buttonPanel.add(jButton8);
        buttonPanel.add(jButton9);
        buttonPanel.add(jButton10);
        buttonPanel.add(jButton11);
        buttonPanel.add(jButton12);
        buttonPanel.add(jButton13);
        buttonPanel.add(jButton14);
        buttonPanel.add(jButton15);
        buttonPanel.add(jButton16);
        buttonPanel.add(jButton17);
        buttonPanel.add(jButton18);
        buttonPanel.add(jButton19);
        buttonPanel.add(jButton20);
        buttonPanel.add(jButton21);
        buttonPanel.add(jButton22);
        buttonPanel.add(jButton23);
        buttonPanel.add(jButton24);
        buttonPanel.add(jButton25);
        buttonPanel.add(jButton26);
        buttonPanel.add(jButton27);
        buttonPanel.add(jButton28);
        buttonPanel.add(jButton29);
        buttonPanel.add(jButton30);
        buttonPanel.add(jButton31);
        buttonPanel.add(jButton32);
        buttonPanel.add(jButton33);
        buttonPanel.add(jButton34);
        buttonPanel.add(jButton35);
        buttonPanel.add(jButton36);
        buttonPanel.add(jButton37);
        buttonPanel.add(jButton38);
        buttonPanel.add(jButton39);
        buttonPanel.add(jButton40);
        buttonPanel.add(jButton41);
        buttonPanel.add(jButton42);
        buttonPanel.add(jButton43);
        buttonPanel.add(jButton44);
        buttonPanel.add(jButton45);
        buttonPanel.add(jButton46);
        buttonPanel.add(jButton47);
        buttonPanel.add(jButton48);
        buttonPanel.add(jButton49);
        buttonPanel.add(jButton50);
        buttonPanel.add(jButton51);
        buttonPanel.add(jButton52);
        buttonPanel.add(jButton53);
        buttonPanel.add(jButton54);
        buttonPanel.add(jButton55);
        buttonPanel.add(jButton56);
        buttonPanel.add(jButton57);
        buttonPanel.add(jButton58);
        buttonPanel.add(jButton59);
        buttonPanel.add(jButton60);
        buttonPanel.add(jButton61);
        buttonPanel.add(jButton62);
        buttonPanel.add(jButton63);
        buttonPanel.add(jButton64);

        jPanel1.add(buttonPanel, java.awt.BorderLayout.CENTER);

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>                        

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO
    }

    private void NewGameActionPerformed(java.awt.event.ActionEvent evt) {
        startGame();
        resetGame();
    }

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
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>


        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JButton NewGame;
    private javax.swing.JPanel buttonPanel;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton16;
    private javax.swing.JButton jButton17;
    private javax.swing.JButton jButton18;
    private javax.swing.JButton jButton19;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton20;
    private javax.swing.JButton jButton21;
    private javax.swing.JButton jButton22;
    private javax.swing.JButton jButton23;
    private javax.swing.JButton jButton24;
    private javax.swing.JButton jButton25;
    private javax.swing.JButton jButton26;
    private javax.swing.JButton jButton27;
    private javax.swing.JButton jButton28;
    private javax.swing.JButton jButton29;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton30;
    private javax.swing.JButton jButton31;
    private javax.swing.JButton jButton32;
    private javax.swing.JButton jButton33;
    private javax.swing.JButton jButton34;
    private javax.swing.JButton jButton35;
    private javax.swing.JButton jButton36;
    private javax.swing.JButton jButton37;
    private javax.swing.JButton jButton38;
    private javax.swing.JButton jButton39;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton40;
    private javax.swing.JButton jButton41;
    private javax.swing.JButton jButton42;
    private javax.swing.JButton jButton43;
    private javax.swing.JButton jButton44;
    private javax.swing.JButton jButton45;
    private javax.swing.JButton jButton46;
    private javax.swing.JButton jButton47;
    private javax.swing.JButton jButton48;
    private javax.swing.JButton jButton49;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton50;
    private javax.swing.JButton jButton51;
    private javax.swing.JButton jButton52;
    private javax.swing.JButton jButton53;
    private javax.swing.JButton jButton54;
    private javax.swing.JButton jButton55;
    private javax.swing.JButton jButton56;
    private javax.swing.JButton jButton57;
    private javax.swing.JButton jButton58;
    private javax.swing.JButton jButton59;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton60;
    private javax.swing.JButton jButton61;
    private javax.swing.JButton jButton62;
    private javax.swing.JButton jButton63;
    private javax.swing.JButton jButton64;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField mark1;
    private javax.swing.JTextField mark2;
    private javax.swing.JTextField mark3;
    private javax.swing.JLabel playerTurn;
    // End of variables declaration                   
}