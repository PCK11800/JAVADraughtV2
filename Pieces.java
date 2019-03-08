import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Pieces extends Board{
    int x_pos, y_pos;
    ImageIcon red = new ImageIcon("red.png");
    ImageIcon white = new ImageIcon("white.png");
    JButton placeHolder = new JButton();
    ImageIcon yellow = new ImageIcon("selected.png");
    JButton cancelButton = new JButton("Cancel!");
    int clickCount = 0;


    void addPiece(int x, int y, int z, String colour){
        JButton piece = new JButton();
        piece.setRolloverEnabled(false);
        if (colour == "red"){
            piece.setIcon(red);
        }
        else if (colour == "white"){
            piece.setIcon(white);
        }
        piece.setBounds(x, y, z, z);
        boardPane.add(piece, new Integer(3));
        piece.addMouseListener(new MouseListener(){
            public void mousePressed(MouseEvent me){}
            public void mouseReleased(MouseEvent me){}
            public void mouseEntered(MouseEvent me){}
            public void mouseExited(MouseEvent me){}
            public void mouseClicked(MouseEvent me){
                if(me.getButton() == MouseEvent.BUTTON1){
                    if (me.getClickCount() == 1){
                        confirmDeletelabel.setText("Are you sure you want to move this piece? Double Left Click again to proceed.");
                        deleteConfirm.add(cancelButton);
                        cancelButton.addActionListener(new ActionListener(){
                            public void actionPerformed(ActionEvent e){
                                piece.setBorderPainted(false);
                                confirmDeletelabel.setText("");
                                deleteConfirm.remove(cancelButton);
                                deleteConfirm.repaint();
                                piece.setRolloverEnabled(true);
                            }
                         });
                    }
                    if(me.getClickCount() == 2){
                    x_pos = piece.getLocation().x;
                    y_pos = piece.getLocation().y;
                    boardPane.remove(piece);
                    boardPane.add(placeHolder, new Integer(3));
                    if (colour == "red"){
                        placeHolder.setIcon(red);
                    }
                    else if (colour == "white"){
                        placeHolder.setIcon(white);
                    }
                    placeHolder.setBounds(x_pos, y_pos, z, z);
                    confirmDeletelabel.setText("");
                    pieceAction(x, y, z, colour);
                    deleteConfirm.remove(cancelButton);
                    deleteConfirm.repaint();
                    boardPane.remove(piece);
                    boardPane.repaint();
                    }
                }
                if(me.getButton() == MouseEvent.BUTTON3){
                    if(me.getClickCount() == 1){
                        confirmDeletelabel.setText("You sure you want to delete this? Double Right Click again to proceed.");
                        piece.setBorder(BorderFactory.createLineBorder(Color.red, 2));
                        cancelButton.setBounds(10, (640 + 20), 50, 20);
                        deleteConfirm.add(cancelButton);
                        cancelButton.addActionListener(new ActionListener(){
                           public void actionPerformed(ActionEvent e){
                               piece.setBorderPainted(false);
                               confirmDeletelabel.setText("");
                               deleteConfirm.remove(cancelButton);
                               deleteConfirm.repaint();
                               boardPane.repaint();
                               boardPane.remove(piece);
                               Pieces piece = new Pieces();
                               piece.addPiece(x, y, z, colour);
                           }
                        });
                    }  
                    else if(me.getClickCount() == 2){
                        confirmDeletelabel.setText("");
                        deleteConfirm.remove(cancelButton);
                        deleteConfirm.repaint();
                        boardPane.remove(piece);
                        boardPane.repaint();
                    }
                }
            }
        });    
    }

    void pieceAction(int x, int y, int z, String colour){
        JButton selected1 = new JButton(yellow);
        JButton selected2 = new JButton(yellow);
        boardPane.add(selected1, new Integer(2));
        boardPane.add(selected2, new Integer(2));
        if (colour == "red"){
            selected1.setBounds((x+z), (y+z), z, z);
            selected2.setBounds((x-z), (y+z), z, z);
        }
        else if (colour == "white"){
            selected1.setBounds((x+z), (y-z), z, z);
            selected2.setBounds((x-z), (y-z), z, z);
        }

        selected1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                int xS_pos = selected1.getLocation().x;
                int yS_pos = selected1.getLocation().y;
                boardPane.repaint();
                Pieces piece = new Pieces();
                piece.addPiece(xS_pos, yS_pos, z, colour);
                x_pos = xS_pos;
                y_pos = yS_pos;
                boardPane.remove(selected1);
                boardPane.remove(selected2);
                boardPane.remove(placeHolder);
            }
        });

        selected2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                int xS_pos = selected2.getLocation().x;
                int yS_pos = selected2.getLocation().y;
                boardPane.repaint();
                Pieces piece = new Pieces();
                piece.addPiece(xS_pos, yS_pos, z, colour);
                x_pos = xS_pos;
                y_pos = yS_pos;
                boardPane.remove(selected1);
                boardPane.remove(selected2);
                boardPane.remove(placeHolder);
            }
        });
    }

    void iniWhite(int sizeLength){
        Pieces piece = new Pieces();
        piece.addPiece(80, 400, sizeLength, "white");
        piece.addPiece(240, 400, sizeLength, "white");
        piece.addPiece(400, 400, sizeLength, "white");
        piece.addPiece(560, 400, sizeLength, "white");

        piece.addPiece(0, 480, sizeLength, "white");
        piece.addPiece(160, 480, sizeLength, "white");
        piece.addPiece(320, 480, sizeLength, "white");
        piece.addPiece(480, 480, sizeLength, "white");

        piece.addPiece(80, 560, sizeLength, "white");
        piece.addPiece(240, 560, sizeLength, "white");
        piece.addPiece(400, 560, sizeLength, "white");
        piece.addPiece(560, 560, sizeLength, "white");
    }

    void iniRed(int sizeLength){
        Pieces piece = new Pieces();
        piece.addPiece(0, 0, sizeLength, "red");
        piece.addPiece(160, 0, sizeLength, "red");
        piece.addPiece(320, 0, sizeLength, "red");
        piece.addPiece(480, 0, sizeLength, "red");

        piece.addPiece(80, 80, sizeLength, "red");
        piece.addPiece(240, 80, sizeLength, "red");
        piece.addPiece(400, 80, sizeLength, "red");
        piece.addPiece(560, 80, sizeLength, "red");

        piece.addPiece(0, 160, sizeLength, "red");
        piece.addPiece(160, 160, sizeLength, "red");
        piece.addPiece(320, 160, sizeLength, "red");
        piece.addPiece(480, 160, sizeLength, "red");
    }

}