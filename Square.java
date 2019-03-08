import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Square extends Board{
    ImageIcon white = new ImageIcon("empty.png");
    ImageIcon black = new ImageIcon("empty2.png");
    JButton square = new JButton();

    void squareMethod(int x, int y, int z, String colour){
        if (colour == "white"){  
            square.setIcon(white);
        }
        else if (colour == "black"){
            square.setIcon(black);
        }
        square.setBounds(x, y, z, z);
        square.setRolloverEnabled(false);
        boardPane.add(square, new Integer(1));
    }

    int[] getLocation(){
        int[] squareLocation = new int[2];
        squareLocation[0] = square.getLocation().x;
        squareLocation[1] = square.getLocation().y;
        x_pos = squareLocation[0];
        y_pos = squareLocation[1];
        System.out.println(x_pos + " " +  y_pos);
        return squareLocation;
    }

    void addSquare(int x, int y, int sizeLength, String colour){
        Square squareClass = new Square();
        squareClass.squareMethod(x, y, sizeLength, colour);
    }

}