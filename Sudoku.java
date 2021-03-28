package sudoku;

import java.awt.GridLayout;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.*;
import java.awt.*;
import static sudoku.Sudoku.ROWS;
import java.awt.Color;

/**
 *
 * @author Angelina 
 */

class Sudoku extends JFrame {

  JPanel[][] largePanel;
  static int ROWS = 3;
  static int COLS = 3;
  SudokuButton[][] Buttons = new SudokuButton[9][9]; 

  UserButton[][] userButtons = new UserButton[1][9];
  
  int User = 0;

  public static int[][] ans = {
      {2,3,7,8,4,1,5,6,9},
      {1,8,6,7,9,5,2,4,3},
      {5,9,4,3,2,6,7,1,8},
      {3,1,5,6,7,4,8,9,2},
      {4,6,9,5,8,2,1,3,7},
      {7,2,8,1,3,9,4,5,6},
      {6,4,2,9,1,8,3,7,5},
      {8,5,3,4,6,7,9,2,1},
      {9,7,1,2,5,3,6,8,4}
  };
  
  public Sudoku() {
      // Sends a title to the JFrame constructor
      super("Sudoku");

      Border blackline = BorderFactory.createLineBorder(Color.DARK_GRAY);
      this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      JPanel mainPanel = new JPanel();
      mainPanel.setBorder(BorderFactory.createMatteBorder(30, 200, 30, 200, Color.white));
      
      BoxLayout boxlayout = new BoxLayout(mainPanel, BoxLayout.Y_AXIS);

      mainPanel.setLayout(boxlayout);


      this.setVisible(true);
      
      JPanel gridPanel = new JPanel();
      gridPanel.setLayout(new GridLayout(ROWS ,COLS));
      largePanel = new JPanel[ROWS][COLS];
      for (int i = 0; i < ROWS; i++) {
          for (int j = 0; j < COLS; j++) {
              JPanel b = new JPanel();
              this.makeSubPanel(b, i, j);

              b.setBorder(blackline);
              largePanel[i][j] = b;
              gridPanel.add(b);
          }
      }

      mainPanel.add(gridPanel);

      JPanel userPanel = new JPanel();
      userPanel.setLayout(new GridLayout(1,9));
      for (int i = 0; i < 9; i++) {
        UserButton u = new UserButton(i+1, 90);
        u.addActionListener(new ClickHandler(this));

        userPanel.add(u);
        userButtons[0][i] = u;
      }

      JPanel blankPanel = new JPanel();
      blankPanel.setLayout(new GridLayout(1,1));
      blankPanel.setPreferredSize(new Dimension(100,30));
      blankPanel.setBackground(Color.white);
      
      

      mainPanel.add(blankPanel);

      mainPanel.add(userPanel);

      this.add(mainPanel);
      this.pack(); // Fits size to contents
  }

  private void makeSubPanel(JPanel subPanel,int iOffset,int jOffset){

    Border greyLine = BorderFactory.createLineBorder(Color.gray);
    subPanel.setLayout(new GridLayout(ROWS,COLS));
    //start
    for (int i = 0; i < ROWS; i++) {
      for (int j = 0; j < COLS; j++) {

        int iOff = iOffset * 3 + i;
        int jOff = jOffset * 3 + j;
        SudokuButton b = new SudokuButton(100, ans[iOff][jOff], given[iOff][jOff]);
        

        Buttons[iOff][jOff] = b;

        b.addActionListener(new ClickHandler(this));
        b.setBorder(greyLine);
        subPanel.add(b);
      }
    }
  }

  public int getUser() {
    return User;
  }

  public void setUser(int buttonValue) {
    this.User = buttonValue;
  }

  public boolean checkWon() {
    for (int i = 0; i < 9; i++) {
      for (int j = 0; j < 9; j++) {

        if (!Buttons[i][j].getText().equals(Integer.toString(Buttons[i][j].value))) {
          return false;
        }
      }
    } 
    return true;
  }

  /**
    * @param args the command line arguments
    */
  
  boolean test[][] = {
      {true,true,true,true,true,true,true,true,true},
      {true,true,true,true,true,true,true,true,true},
      {true,true,true,true,true,true,true,true,true},
      {true,true,true,true,true,true,true,true,true},
      {true,true,true,true,false,true,true,true,true},
      {true,true,true,true,true,true,true,true,true},
      {true,true,true,true,true,true,true,true,true},
      {true,true,true,true,true,true,true,true,true},
      {true,true,true,true,true,true,true,true,true},
  };
  
  boolean given[][] = {
      {false,false,true,false,true,false,false,true,true},
      {true,false,true,false,true,false,false,false,true},
      {false,true,true,false,true,true,false,true,false},
      {true,true,false,true,true,false,true,false,true},
      {true,false,false,false,false,false,true,true,true},
      {false,false,true,false,false,false,false,true,false},
      {true,false,true,false,true,true,true,true,false},
      {true,true,false,true,true,true,false,false,false},
      {true,false,false,true,true,false,true,false,true},
  };

  public static void main(String[] args) {
    Sudoku game = new Sudoku();
  }
}
