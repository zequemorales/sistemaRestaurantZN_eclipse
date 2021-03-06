package paqueteven;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

class MyButton extends JButton { 

    private Color hoverBackgroundColor; 
    private Color pressedBackgroundColor; 


	public MyButton(Integer numeroMesa) {
		
		 super(numeroMesa.toString()); 
	     super.setContentAreaFilled(false); 
	  
	     
	}

	@Override 
    protected void paintComponent(Graphics g) { 
     if (getModel().isPressed()) { 
      g.setColor(pressedBackgroundColor); 
     } else if (getModel().isRollover()) { 
      g.setColor(hoverBackgroundColor); 
     } else { 
      g.setColor(getBackground()); 
     } 
     g.fillRect(0, 0, getWidth(), getHeight()); 
     super.paintComponent(g); 
    } 

    @Override 
    public void setContentAreaFilled(boolean b) { 
    } 

    public Color getHoverBackgroundColor() { 
     return hoverBackgroundColor; 
    } 

    public void setHoverBackgroundColor(Color hoverBackgroundColor) { 
     this.hoverBackgroundColor = hoverBackgroundColor; 
    } 

    public Color getPressedBackgroundColor() { 
     return pressedBackgroundColor; 
    } 

    public void setPressedBackgroundColor(Color pressedBackgroundColor) { 
     this.pressedBackgroundColor = pressedBackgroundColor; 
    } 
   
}