import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Board{
    static JFrame mainFrame = new JFrame("Draught");
    static JLayeredPane boardPane = new JLayeredPane();
    static Board draught = new Board();
    static Square square = new Square();
    static Pieces piece = new Pieces();
    static JPanel deleteConfirm = new JPanel();
    static JLabel confirmDeletelabel = new JLabel();
    int x_pos, y_pos;


    void frameSetup(int frameWidth, int frameHeight){
        mainFrame.setVisible(true);
        mainFrame.setSize(frameWidth, frameHeight);
        mainFrame.setLayout(null);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.add(boardPane);
        mainFrame.add(deleteConfirm);
    }

    void boardSetup(int boardSize){
        boardPane.setBounds(0, 0, boardSize, boardSize);
        boardPane.setOpaque(false);
        deleteConfirm.setBounds(10, boardSize, boardSize, 100);
        deleteConfirm.setOpaque(false);
        deleteConfirm.add(confirmDeletelabel);
    }

    void createBoard(int sizeLength){
        int x = 0;
        int y = 8;
        int xcoord = 0;
        int ycoord = 0;
        int[] squareArray = new int[64];
        
        for(int i = 0; i < 64; i++){
            squareArray[i] = i;
        }

        for(int j = 0; j < 8; j++){
            for(int i = x; i < y; i++){
                if (squareArray[i] % 2 == 0){
                    square.addSquare(xcoord, ycoord, sizeLength, "white");
                    xcoord = xcoord + sizeLength;
                }
                else{
                    square.addSquare(xcoord, ycoord, sizeLength, "black");
                    xcoord = xcoord + sizeLength;
                }
            }
            x++;
            y++;
            ycoord = ycoord + sizeLength;
            xcoord = 0;
        }
    }

    public static void main(String[] args){
        draught.frameSetup(655, 690);
        draught.boardSetup(640);
        draught.createBoard(80);
        piece.iniRed(80);
        piece.iniWhite(80);
    }
}