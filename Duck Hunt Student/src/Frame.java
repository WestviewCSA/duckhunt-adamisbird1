import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
//import jdk.internal.org.jline.utils.Timeout;
public class Frame extends JPanel implements ActionListener, MouseListener, KeyListener {
	int roundTimer;
	Font bigFont = new Font("Serif", Font.BOLD, 30);
	Ghost ghost = new Ghost();//duck
	Pink pink = new Pink();//dog
	Black black = new Black();
	Background background = new Background();
	int score;
	long time;
	int boundX = 1;
	int boundY = 1;
	int on;

	public void init() {//should initilize everthing
		roundTimer = 10;
		score= 0;
		time = 1000;
		ghost.setWidthHeight(100, 100);
		ghost.setVx(5);
		ghost.setVy(5);
		ghost.setX((int)(Math.random() * 900) + 0);
		ghost.setY((int)(Math.random() * 600) + 0);
			
			}
	public void reset(){
		
	}
	
	public void paint(Graphics g) {
		super.paintComponent(g);	
		ghost.setVx(8*boundX);
		ghost.setVy(8*boundY);
		time += 20;
		if(time%1000 == 0) {
			roundTimer -= 1;
			if (roundTimer == 0) {
				// what do i do after a new round?
			}
		
		}
		//painting
		if(roundTimer >= 0) {
		g.setFont(bigFont);
		pink.paint(g);
		background.paint(g);
		ghost.paint(g);
		pink.paint(g);
		g.drawString("Round Timer " + roundTimer,0,50);//paint background and need to scale it
		g.drawString("Score " + score,0,100);
		on = 0;}
		if(roundTimer <= 0) {
			g.setFont(bigFont);
			black.paint(g);
			String end = "Your score was " + score + " Hit Space To Play Again";
			g.drawString(end,200,300);
			on = 1;}
// add method for space to reset the score aand gametime back to 0
		
		
	
		//ghost bouncing around
		if (ghost.getX() <= 0) {
			boundX = boundX *-1;
			}
		if (ghost.getX() >= 900) {
			boundX = boundX *-1;
		}	
		if (ghost.getY() <= 0) {
			boundY = boundY *-1;
		}	
		if (ghost.getY() >= 650) {
			boundY = boundY *-1;
		}	
		
	}
	
	public static void main(String[] arg) {
		Frame f = new Frame();
		f.init();
	}
	
	public Frame() {
		JFrame f = new JFrame("Duck Hunt");
		f.setSize(new Dimension(1000, 800));
		f.setBackground(Color.blue);
		f.add(this);
		f.setResizable(false);
		f.setLayout(new GridLayout(1,2));
		f.addMouseListener(this);
		f.addKeyListener(this);
		Timer t = new Timer(16, this);
		t.start();
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}
	
	
	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mousePressed(MouseEvent mouse) {
		// TODO Auto-generated method stub
	Rectangle rMouse = new Rectangle(mouse.getX(), mouse.getY(), 50, 50);
	Rectangle rMain = new Rectangle(
			ghost.getX(), ghost.getY(),
			ghost.getWidth(), ghost.getHeight()
			);
	//collision
	if(rMouse.intersects(rMain)) {
		
		
		ghost.setX((int)(Math.random() * 900) + 0);
		ghost.setY((int)(Math.random() * 600) + 0);
			boundX = boundX * -1;
			boundY = boundY * -1;
			score += 1;
//successful click//dog needs to move in the same -x pos
pink.setX(ghost.getX());// may need to center
pink.setY(700);
	}
	}
	//score
	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		repaint();
	}
	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
				if (arg0.getKeyCode()==32 && on == 1) {
					score = 0;
					roundTimer = 15;
					
				};
	}
	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}


