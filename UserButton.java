package sudoku;

import java.awt.Dimension;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;

/**
 *
 * @author Angelina
 */
class UserButton extends JButton{

  int value;
  
  public UserButton(int value, int size){
    super();

    this.value = value;
    this.setText(Integer.toString(this.value));
    this.setFont(new Font("Comic Sans", Font.PLAIN, 60));
    this.setBackground(Color.white);
    
    Dimension d = new Dimension(size,size);
    this.setPreferredSize(d);
  }
  
  public int getValue() {
    return value;
  }
}
    

