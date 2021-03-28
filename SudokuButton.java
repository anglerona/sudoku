package sudoku;

import java.awt.Dimension;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;

/**
 *
 * @author Angelina
 */
class SudokuButton extends JButton{

  int value;
  boolean shown;
  int userInput; 
  
  //JButton(String text)
  public SudokuButton(int size, int value, boolean shown){
    super();
    this.value = value;
    this.shown = shown;
    this.setFont(new Font("Comic Sans", Font.PLAIN, 60));
    this.setBackground(Color.white);
    if (shown) this.setBackground(Color.LIGHT_GRAY);

    this.setShown(this.shown);

    Dimension d = new Dimension(70,70);
    this.setPreferredSize(d);
  }
  
  public void setUserInput(int input){
    this.setText(Integer.toString(input));
    userInput = input;
  }

  public final void setShown(boolean show){

    if(show){
      this.setText(Integer.toString(this.value));
    } else{
      this.setText("");
    }
  }
}


    

