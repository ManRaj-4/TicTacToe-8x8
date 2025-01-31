import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author manraj
 */
public class MainFrame extends javax.swing.JFrame {

    JButton[][] buttons = new JButton[8][8];    // 2-d array for storing the buttons
    String[] playerMarks = new String[3];       // array for storing marks set by the players
    int playerCount =0;                         // for tracking the players' turn
    boolean[] playerSet = {false,false,false};  // for checking if all the players has set their marks
    /**
     * Creates new form MainFrame
     */
    public MainFrame() {
        initComponents();

        // first row of buttons
        buttons[0][0] = jButton1;
        buttons[0][1] = jButton2;
        buttons[0][2] = jButton3;
        buttons[0][3] = jButton4;
        buttons[0][4] = jButton5;
        buttons[0][5] = jButton6;
        buttons[0][6] = jButton7;
        buttons[0][7] = jButton8;

        // second row of buttons
        buttons[1][0] = jButton9;
        buttons[1][1] = jButton10;
        buttons[1][2] = jButton11;
        buttons[1][3] = jButton12;
        buttons[1][4] = jButton13;
        buttons[1][5] = jButton14;
        buttons[1][6] = jButton15;
        buttons[1][7] = jButton16;

        // third row of buttons
        buttons[2][0] = jButton17;
        buttons[2][1] = jButton18;
        buttons[2][2] = jButton19;
        buttons[2][3] = jButton20;
        buttons[2][4] = jButton21;
        buttons[2][5] = jButton22;
        buttons[2][6] = jButton23;
        buttons[2][7] = jButton24;

        // fourth row of buttons
        buttons[3][0] = jButton25;
        buttons[3][1] = jButton26;
        buttons[3][2] = jButton27;
        buttons[3][3] = jButton28;
        buttons[3][4] = jButton29;
        buttons[3][5] = jButton30;
        buttons[3][6] = jButton31;
        buttons[3][7] = jButton32;

        // fifth row of buttons
        buttons[4][0] = jButton33;
        buttons[4][1] = jButton34;
        buttons[4][2] = jButton35;
        buttons[4][3] = jButton36;
        buttons[4][4] = jButton37;
        buttons[4][5] = jButton38;
        buttons[4][6] = jButton39;
        buttons[4][7] = jButton40;

        // sixth row of buttons
        buttons[5][0] = jButton41;
        buttons[5][1] = jButton42;
        buttons[5][2] = jButton43;
        buttons[5][3] = jButton44;
        buttons[5][4] = jButton45;
        buttons[5][5] = jButton46;
        buttons[5][6] = jButton47;
        buttons[5][7] = jButton48;

        // seventh row of buttons
        buttons[6][0] = jButton49;
        buttons[6][1] = jButton50;
        buttons[6][2] = jButton51;
        buttons[6][3] = jButton52;
        buttons[6][4] = jButton53;
        buttons[6][5] = jButton54;
        buttons[6][6] = jButton55;
        buttons[6][7] = jButton56;

        // eighth row of buttons
        buttons[7][0] = jButton57;
        buttons[7][1] = jButton58;
        buttons[7][2] = jButton59;
        buttons[7][3] = jButton60;
        buttons[7][4] = jButton61;
        buttons[7][5] = jButton62;
        buttons[7][6] = jButton63;
        buttons[7][7] = jButton64;

        // for loop for adding action listener to all the button to know which button was clicked
        for(int row =0;row<8;row++){
            for(int col=0;col<8;col++){
                buttons[row][col].addActionListener(new BoardButtonListener(row,col));
            }
        }
    }

    // class for handling button clicks
    private class BoardButtonListener implements ActionListener{
        private int row,col;

        public BoardButtonListener(int row,int col){
            this.row = row;
            this.col = col;
        }

        @Override
        public void actionPerformed(ActionEvent e){
            // checking if all players have set their marks
            if(!allPlayerSet()){
                JOptionPane.showMessageDialog(MainFrame.this, "All players must set their Mark first");
                return;
            }

            // set the text inside the clicked to current players' Mark
            buttons[row][col].setText(playerMarks[playerCount]);

            // checking if anyone won the game
            if(checkWin(row,col,playerMarks[playerCount])){
                JOptionPane.showMessageDialog(MainFrame.this,"Player " +
                        (playerCount+1) + " Wins");
                resetGame();
                return;
            }

            playerCount = (playerCount+1)%3;     // switch to next players' turn
            buttons[row][col].setEnabled(false);    // disable the button after it is clicked
            statusLabel.setText("Player " + (playerCount+1) + " Turn");     // update the label to let know whose turn is it
        }
    }

    // to check the win conditions
    // parameters: row, col for checking the buttons,
    // String mark for checking which players' mark won
    boolean checkWin(int row,int col, String mark){
        return checkHorizontal(row,col,mark) ||
                checkVertical(row,col,mark)   ||
                checkDiagonalTopLeftToBottomRight(mark)||
                checkDiagonalTopRightToBottomLeft(mark);
    }

    // checking horizontal win -
    boolean checkHorizontal(int row, int col, String mark){
        for(int i=0;i<=8-4;i++){
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

    // checking vertical win |
    boolean checkVertical(int row, int col, String mark){
        for(int i=0;i<=8-4;i++){
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

    //checking top left to bottom right (\)
    boolean checkDiagonalTopLeftToBottomRight(String mark){
        for(int i=0;i<=8-4;i++){
            for(int j=0;j<=8-4;j++){
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

    // checking top right to bottom left (/)
    boolean checkDiagonalTopRightToBottomLeft(String mark){
        for(int i=0;i<=8-4;i++){
            for(int j=3;j<8;j++){
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


    // for starting the game when start button has been clicked
    void startGame(){

        // getting the mark set by the players
        playerMarks[0]= mark1.getText().trim();
        playerMarks[1]= mark2.getText().trim();
        playerMarks[2]= mark3.getText().trim();
        for(int i=0;i<3;i++){
            String tempMark=playerMarks[i]; // temporarily storing the mark to check either if it is empty or has more than one character
            if(tempMark.isBlank()||tempMark.length()!=1){
                JOptionPane.showMessageDialog(this, "Player " + (i + 1) + " must enter a single character as their mark.");
                return;
            }

            // checking if players has set same mark
            for (int j = 0; j < i; j++) {
                if (tempMark.equals(playerMarks[j])) {
                    JOptionPane.showMessageDialog(this, "Player " + (i + 1) + " cannot use the same mark as Player " + (j + 1) + ".");
                    return;
                }
            }

            // if everything is alright, then store the marks and set the playerSet bool value to true
            playerMarks[i] = tempMark;
            playerSet[i]=true;
        }

        statusLabel.setText("Player 1 Turn");
        NewGamebtn.setText("Reset Board");

    }

    // to reset the game board
    void resetGame(){
        for(int row=0;row<8;row++){
            for(int col=0;col<8;col++){
                buttons[row][col].setText("");  // clear the button text
                buttons[row][col].setEnabled(true); // re-enable the buttons
            }
        }
        playerCount = 0;     // reset player turn to player 1
        statusLabel.setText("Player 1 Turn");

    }

    // to see if all the players have set the marks
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

        MainPanel = new javax.swing.JPanel();
        LabelPanel = new javax.swing.JPanel();
        player1label = new javax.swing.JLabel();
        player2Label = new javax.swing.JLabel();
        player3Label = new javax.swing.JLabel();
        mark1 = new javax.swing.JTextField();
        mark2 = new javax.swing.JTextField();
        mark3 = new javax.swing.JTextField();
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
        NewGamePanel = new javax.swing.JPanel();
        NewGamebtn = new javax.swing.JButton();
        statusPanel = new javax.swing.JPanel();
        statusLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("TicTacToe");
        setPreferredSize(new java.awt.Dimension(540, 800));

        MainPanel.setLayout(new java.awt.BorderLayout());

        LabelPanel.setBackground(new java.awt.Color(204, 204, 204));
        LabelPanel.setForeground(new java.awt.Color(204, 204, 204));
        LabelPanel.setLayout(new java.awt.GridLayout(2, 3));

        player1label.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        player1label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        player1label.setText("Player 1:");
        LabelPanel.add(player1label);

        player2Label.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        player2Label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        player2Label.setText("Player 2:");
        LabelPanel.add(player2Label);

        player3Label.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        player3Label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        player3Label.setText("Player 3:");
        LabelPanel.add(player3Label);
        LabelPanel.add(mark1);
        LabelPanel.add(mark2);
        LabelPanel.add(mark3);

        MainPanel.add(LabelPanel, java.awt.BorderLayout.PAGE_START);

        buttonPanel.setMinimumSize(new java.awt.Dimension(400, 400));
        buttonPanel.setLayout(new java.awt.GridLayout(8, 8));

        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        buttonPanel.add(jButton1);

        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        buttonPanel.add(jButton2);

        jButton3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        buttonPanel.add(jButton3);

        jButton4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        buttonPanel.add(jButton4);

        jButton5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        buttonPanel.add(jButton5);

        jButton6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        buttonPanel.add(jButton6);

        jButton7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        buttonPanel.add(jButton7);

        jButton8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        buttonPanel.add(jButton8);

        jButton9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        buttonPanel.add(jButton9);

        jButton10.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        buttonPanel.add(jButton10);

        jButton11.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        buttonPanel.add(jButton11);

        jButton12.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        buttonPanel.add(jButton12);

        jButton13.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        buttonPanel.add(jButton13);

        jButton14.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        buttonPanel.add(jButton14);

        jButton15.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        buttonPanel.add(jButton15);

        jButton16.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        buttonPanel.add(jButton16);

        jButton17.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        buttonPanel.add(jButton17);

        jButton18.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        buttonPanel.add(jButton18);

        jButton19.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        buttonPanel.add(jButton19);

        jButton20.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        buttonPanel.add(jButton20);

        jButton21.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        buttonPanel.add(jButton21);

        jButton22.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        buttonPanel.add(jButton22);

        jButton23.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        buttonPanel.add(jButton23);

        jButton24.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        buttonPanel.add(jButton24);

        jButton25.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        buttonPanel.add(jButton25);

        jButton26.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        buttonPanel.add(jButton26);

        jButton27.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        buttonPanel.add(jButton27);

        jButton28.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        buttonPanel.add(jButton28);

        jButton29.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        buttonPanel.add(jButton29);

        jButton30.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        buttonPanel.add(jButton30);

        jButton31.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        buttonPanel.add(jButton31);

        jButton32.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        buttonPanel.add(jButton32);

        jButton33.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        buttonPanel.add(jButton33);

        jButton34.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        buttonPanel.add(jButton34);

        jButton35.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        buttonPanel.add(jButton35);

        jButton36.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        buttonPanel.add(jButton36);

        jButton37.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        buttonPanel.add(jButton37);

        jButton38.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        buttonPanel.add(jButton38);

        jButton39.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        buttonPanel.add(jButton39);

        jButton40.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        buttonPanel.add(jButton40);

        jButton41.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        buttonPanel.add(jButton41);

        jButton42.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        buttonPanel.add(jButton42);

        jButton43.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        buttonPanel.add(jButton43);

        jButton44.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        buttonPanel.add(jButton44);

        jButton45.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        buttonPanel.add(jButton45);

        jButton46.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        buttonPanel.add(jButton46);

        jButton47.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        buttonPanel.add(jButton47);

        jButton48.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        buttonPanel.add(jButton48);

        jButton49.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        buttonPanel.add(jButton49);

        jButton50.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        buttonPanel.add(jButton50);

        jButton51.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        buttonPanel.add(jButton51);

        jButton52.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        buttonPanel.add(jButton52);

        jButton53.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        buttonPanel.add(jButton53);

        jButton54.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        buttonPanel.add(jButton54);

        jButton55.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        buttonPanel.add(jButton55);

        jButton56.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        buttonPanel.add(jButton56);

        jButton57.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        buttonPanel.add(jButton57);

        jButton58.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        buttonPanel.add(jButton58);

        jButton59.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        buttonPanel.add(jButton59);

        jButton60.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        buttonPanel.add(jButton60);

        jButton61.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        buttonPanel.add(jButton61);

        jButton62.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        buttonPanel.add(jButton62);

        jButton63.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        buttonPanel.add(jButton63);

        jButton64.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        buttonPanel.add(jButton64);

        MainPanel.add(buttonPanel, java.awt.BorderLayout.CENTER);

        NewGamePanel.setLayout(new java.awt.BorderLayout());

        NewGamebtn.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        NewGamebtn.setText("Set Mark and Start Game");
        NewGamebtn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        NewGamebtn.setPreferredSize(new java.awt.Dimension(81, 40));
        NewGamebtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NewGamebtnActionPerformed(evt);
            }
        });
        NewGamePanel.add(NewGamebtn, java.awt.BorderLayout.CENTER);

        MainPanel.add(NewGamePanel, java.awt.BorderLayout.PAGE_END);

        getContentPane().add(MainPanel, java.awt.BorderLayout.CENTER);

        statusPanel.setBackground(new java.awt.Color(204, 204, 204));
        statusPanel.setPreferredSize(new java.awt.Dimension(600, 30));
        statusPanel.setLayout(new java.awt.BorderLayout());

        statusLabel.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        statusLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        statusLabel.setText("Set Mark And Then Start Game");
        statusPanel.add(statusLabel, java.awt.BorderLayout.CENTER);

        getContentPane().add(statusPanel, java.awt.BorderLayout.PAGE_START);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {

    }

    private void NewGamebtnActionPerformed(java.awt.event.ActionEvent evt) {
        startGame();        // start the game
        resetGame();        // reset the game board
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
    private javax.swing.JPanel LabelPanel;
    private javax.swing.JPanel MainPanel;
    private javax.swing.JPanel NewGamePanel;
    private javax.swing.JButton NewGamebtn;
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
    private javax.swing.JTextField mark1;
    private javax.swing.JTextField mark2;
    private javax.swing.JTextField mark3;
    private javax.swing.JLabel player1label;
    private javax.swing.JLabel player2Label;
    private javax.swing.JLabel player3Label;
    private javax.swing.JLabel statusLabel;
    private javax.swing.JPanel statusPanel;
    // End of variables declaration                   
}