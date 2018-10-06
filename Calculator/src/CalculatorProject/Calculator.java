//JANE SMYTH
//C00208290
package CalculatorProject;


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;



public class Calculator extends JFrame implements ActionListener
{

	JFrame frame = new JFrame();
	//initiate Text Field 
	private JTextField textBox = new JTextField(20);
	//initiate string of buttons display values
	private String[] buttonDisplay= 	{"AC","\u232B","MRC","","M+", "M-","MC","+","7","8","9","-","4","5","6","x","1","2","3","÷",".","0","\u00B1","="};
	//initiate button panel
	private JPanel buttonPanel = new JPanel();
	//initiate text panel
	private JPanel textPanel = new JPanel();
	
	private Color beige = Color.decode("#c7b187");
	private Color darkBeige=Color.decode("#B5A17B");
	private Color rosePink = Color.decode("#8F515C");
	private Color lightBlue=Color.decode("#75B9BE");
	private Color darkBlue=Color.decode("#6BA9AD");
	private Color darkPink = Color.decode("#824A54");

	Calculator(String title)
	{
		super("Calculator");
				//Create Frame
			
			setSize(300, 410);//sets size of frame
			setLocation(500, 190);//sets frame location on screen
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//closes calc when x button clicked
			
			//Text Panel

			textPanel.setLayout(new BoxLayout(textPanel, BoxLayout.PAGE_AXIS));//set layout of text panel
			Font font1 = new Font("SansSerif", Font.BOLD, 24); 
			textPanel.add(textBox); 
			textBox.setEditable(false);
			textBox.setPreferredSize(new Dimension(300, 80));//text box dimensions
			textBox.setFont(font1);
			add("North", textPanel);//adding text panel to the top of the frame
			
			
			//Button Panel
			add("Center", buttonPanel);//adding button panel to the center of the frame 
			buttonPanel.setLayout(new GridLayout(6, 4, 1, 1)); //set grid layout, 6 rows by 4 columns with 1 
			//space between vertical and horizontal
		
	
			for(int i=0; i<buttonDisplay.length; i++)
			{
				JButton thisButton =new JButton(buttonDisplay[i]);
				thisButton.addActionListener(this);
				thisButton.setOpaque(true);
				thisButton.setBorderPainted(false);
				
				
				if (buttonDisplay[i] == "AC" || buttonDisplay[i] =="\u232B" || buttonDisplay[i] =="MC" || buttonDisplay[i]  =="M+" || 
						buttonDisplay[i] == "M-" || buttonDisplay[i]=="MRC")
				{
					thisButton.setBackground(rosePink);
					thisButton.addMouseListener(mouseListenOther);//changes color based on hovering
				}
			
				
				else if (buttonDisplay[i] =="+" || buttonDisplay[i] =="-" || buttonDisplay[i] =="x"|| 
						buttonDisplay[i] == "="  || buttonDisplay[i] =="÷" )
				{
					thisButton.setBackground(lightBlue);
					thisButton.addMouseListener(mouseListenOpertor);
				}
				
				else if(buttonDisplay[i] =="")
				{
					thisButton.setBackground(lightBlue);
					thisButton.setEnabled(false);
				}
				else
				{
					thisButton.setBackground(beige);
					thisButton.addMouseListener(mouseListenDigits);
				}
				buttonPanel.add(thisButton);
			}
			
			
			setVisible(true);//makes frame visible
		
	}
	
	public void actionPerformed(ActionEvent event)
	{
		 
		String source = event.getActionCommand();
		textBox.setText(Calculations.inputVal(source));
	}		
	
	MouseListener mouseListenOther = new MouseAdapter()
	{
		
		
	    public void mouseEntered(MouseEvent evt)
	    {            
	        Component c = evt.getComponent();
	        c.setBackground(darkPink);
	    }                                      

	   public void mouseExited(MouseEvent evt)
	    {                                      
	        Component c = evt.getComponent();
	        c.setBackground(rosePink);
	    } 
	    
	};
	
	MouseListener mouseListenDigits = new MouseAdapter()
	{
	
		public void mouseEntered(MouseEvent evt)
	    {            
	        Component c = evt.getComponent();
	        c.setBackground(darkBeige);
	    }                                      

	    public void mouseExited(MouseEvent evt)
	    {                                      
	        Component c = evt.getComponent();
	        c.setBackground(beige);
	    } 
	    
	};
	
	MouseListener mouseListenOpertor = new MouseAdapter()
	{
	  public void mouseEntered(MouseEvent evt)
	    {            
	        Component c = evt.getComponent();
	        c.setBackground(darkBlue);
	    }                                      

	    public void mouseExited(MouseEvent evt)
	    {                                      
	        Component c = evt.getComponent();
	        c.setBackground(lightBlue);
	    } 
	    
	};
	
	public static void main(String[] args) 
	{
		new Calculator("Calculator");

	}

}



