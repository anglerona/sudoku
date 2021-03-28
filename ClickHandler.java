package sudoku;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static javax.swing.JOptionPane.showMessageDialog;

/**
 *
 * @author Angelina
 */

class ClickHandler implements ActionListener{
  
  Sudoku game;
  
  public ClickHandler(Sudoku game){
    
    this.game = game;
  }

  @Override
  public void actionPerformed(ActionEvent e) {

    SudokuButton button; 
    Object source = e.getSource(); //number that player clicked

    if(source instanceof SudokuButton) { //if what was clicked is a SudokuButton

        button = (SudokuButton) source; //interpret what was clicked as a SudokuButton
        if(!this.game.checkWon() && !button.shown) {
        button.setUserInput(game.User);
        }
        if (this.game.checkWon()) {
          showMessageDialog(null, "You're done (._.)");
        }
    }
    if(source instanceof UserButton) {
      UserButton uButton = (UserButton) source;
      game.setUser(uButton.value);
    }
  }
}

    

