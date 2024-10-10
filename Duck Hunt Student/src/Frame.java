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

public class Frame extends JPanel implements ActionListener, MouseListener, KeyListener {
	int roundTimer = 15;
	Font bigFont = new Font("Serif", Font.BOLD, 30);
	Ghost ghost = new Ghost();//duck
	Pink pink = new Pink();//dog
	Background background = new Background();
	int score;
	long time;
	public void init() {
roundTimer = 15;
score= 0;
time = 30;
ghost.setWidthHeight(100, 100);
ghost.setVx(2);
ghost.setVy(2);
pink.setXY(100, 100);
	
	}
	public void reset(){
		
	}
	
	public void paint(Graphics g) {
		super.paintComponent(g);
		time += 20;
		if(time%1000 == 0) {
			roundTimer -= 1;
			if (roundTimer == 0) {
				// what do i do ater a new round?
			}
			
		}
		g.setFont(bigFont);
		pink.paint(g);
		background.paint(g);
		ghost.paint(g);
		ghost.setWidthHeight(100, 100);
		ghost.setVx(5);
		ghost.setVy(5);
		pink.paint(g);
		g.drawString("Round Timer " + roundTimer,0,50);//paint background and need to scale it
		g.drawString("Score " + score,0,100);
		//ghost bouncing around
		if (ghost.getX() == 0) {
			ghost.setVx(-2);
		}
		if (ghost.getX() == -20) {
			ghost.setVx(5);
		}	
		if (ghost.getX() == 1000) {
			ghost.setVx(-5);
		}	
		if (ghost.getY() == 800) {
			ghost.setVy(-5);
		}	
	}
	
	
	public static void main(String[] arg) {
		Frame f = new Frame();
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

score += 1;

//successful click//dog needs to move in the same -x pos
pink.setX(ghost.getX());// may need to center
pink.setY(300);
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
		System.out.println(arg0.getKeyCode());
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



