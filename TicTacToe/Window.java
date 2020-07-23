package TicTacToe;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import ArtificialIntelligence.*;

public class Window extends JFrame {

    public static final int WIDTH = 600;
    public static final int HEIGHT = 600;
    public static  int flag;

    public Board board;
    public Panel panel;
    public BufferedImage imageBackground, imageX, imageO;

    public enum Mode {Player, AI}
    public Mode mode;

   
    public Point[] cells;

    public static final int DISTANCE = 100;

    
    public Window () {
        this(Mode.AI);
    }

    
    public Window (Mode mode) {
        this.mode = mode;
        board = new Board();
        loadCells();
        panel = createPanel();
        setWindowProperties();
        loadImages();
    }

  
    public void loadCells () {
        cells = new Point[9];

        cells[0] = new Point(109, 109);
        cells[1] = new Point(299, 109);
        cells[2] = new Point(489, 109);
        cells[3] = new Point(109, 299);
        cells[4] = new Point(299, 299);
        cells[5] = new Point(489, 299);
        cells[6] = new Point(109, 489);
        cells[7] = new Point(299, 489);
        cells[8] = new Point(489, 489);
    }

   
    public void setWindowProperties () {
        setResizable(false);
        pack();
        setTitle("TIC TAC TOE");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    
    public Panel createPanel () {
        Panel panel = new Panel();
        Container cp = getContentPane();
        cp.add(panel);
        panel.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        panel.addMouseListener(new MyMouseAdapter());
        return panel;
    }

    
    public void loadImages () {
        imageBackground = getImage("background");
        imageX = getImage("x");
        imageO = getImage("o");
    }

    
    public static BufferedImage getImage (String path) {

        BufferedImage image;

        try {
            path = ".." + File.separator + "Assets" + File.separator + path + ".png";
            image = ImageIO.read(Window.class.getResource(path));
        } catch (IOException ex) {
            throw new RuntimeException("Image could not be loaded.");
        }

        return image;
    }

    
    public class Panel extends JPanel {

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            paintTicTacToe((Graphics2D) g);
        }

       
        public void paintTicTacToe (Graphics2D g) {
            setProperties(g);
            paintBoard(g);
            paintWinner(g);
        }

        
        public void setProperties (Graphics2D g) {
            g.setRenderingHint(RenderingHints.KEY_INTERPOLATION,
                    RenderingHints.VALUE_INTERPOLATION_BILINEAR);
            g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                    RenderingHints.VALUE_ANTIALIAS_ON);
            g.drawImage(imageBackground, 0, 0, null);

            
            g.drawString("", 0, 0);
        }

       
        public void paintBoard (Graphics2D g) {
            Board.State[][] boardArray = board.toArray();

            int offset = 20;

            for (int y = 0; y < 3; y++) {
                for (int x = 0; x < 3; x++) {
                    if (boardArray[y][x] == Board.State.X) {
                        g.drawImage(imageX, offset + 190 * x, offset + 190 * y, null);
                    } else if (boardArray[y][x] == Board.State.O) {
                        g.drawImage(imageO, offset + 190 * x, offset + 190 * y, null);
                    }
                }
            }
        }

        
        public void paintWinner (Graphics2D g) {
            if (board.isGameOver()) {
                g.setColor(new Color(255, 255, 255));
                g.setFont(new Font("TimesRoman", Font.PLAIN, 50));

                String s;

                if (board.getWinner() == Board.State.Blank) {
                    s = "Draw";
                } else {
                    s = board.getWinner() + " Wins!";
                }

                g.drawString(s, 300 - getFontMetrics(g.getFont()).stringWidth(s)/2, 315);

            }
        }
    }

    public class MyMouseAdapter extends MouseAdapter {
        @Override
        public void mousePressed(MouseEvent e) {
            super.mouseClicked(e);

            if (board.isGameOver()) {
                board.reset();
                panel.repaint();
            } else {
                playMove(e);
            }

        }

        
        public void playMove (MouseEvent e) {
            int move = getMove(e.getPoint());

            if (!board.isGameOver() && move != -1) {
                boolean validMove = board.move(move);
                if (mode == Mode.AI && validMove && !board.isGameOver()&&  flag==1) {
                	
                    Algorithms.random(board);
                }
                if (mode == Mode.AI && validMove && !board.isGameOver()&&  flag==2) {
                	
                    Algorithms.miniMax(board);
                }
                if (mode == Mode.AI && validMove && !board.isGameOver()&&  flag==3) {
                	
                    Algorithms.alphaBetaAdvanced(board);
                }
                panel.repaint();
            }
        }

        
        public int getMove (Point point) {
            for (int i = 0; i < cells.length; i++) {
                if (distance(cells[i], point) <= DISTANCE) {
                    return i;
                }
            }
            return -1;
        }

        
        public double distance (Point p1, Point p2) {
            double xDiff = p1.getX() - p2.getX();
            double yDiff = p1.getY() - p2.getY();

            double xDiffSquared = xDiff*xDiff;
            double yDiffSquared = yDiff*yDiff;

            return Math.sqrt(xDiffSquared+yDiffSquared);
        }
    }

    public static void main(String[] args) {

    	new indexPage();
    }

}
