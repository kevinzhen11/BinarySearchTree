package binarysearch;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;

public class BSTDemo extends JFrame{
	BinarySearchTree bst = new BinarySearchTree();
	int mode = 0;

	public BSTDemo(){
		// --- create initial frame
		JFrame my_frame = new JFrame("Binary Search Tree Program");
		my_frame.setPreferredSize(new Dimension(500,500));
		my_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JRadioButton in_fix = new JRadioButton("In-fix"); // add the mode buttons
	    JRadioButton pre_fix = new JRadioButton("Pre-fix");
	    JRadioButton post_fix = new JRadioButton("Post-fix");
	    
	    in_fix.setFont(new Font("Serif", Font.PLAIN, 18)); // and set their fonts
	    pre_fix.setFont(new Font("Serif", Font.PLAIN, 18));
	    post_fix.setFont(new Font("Serif", Font.PLAIN, 18));
	    
	    ButtonGroup buttons = new ButtonGroup(); // pack them into a buttonGroup
	    buttons.add(in_fix);
	    buttons.add(pre_fix);
	    buttons.add(post_fix);
	    in_fix.setSelected(true); // set default mode
		
		JButton add_b = new JButton("Add Node"); // add the main buttons
		JButton del_b = new JButton("Delete Node");
		JButton disp_b = new JButton("Display Contents");
		JButton draw_b = new JButton("Draw Tree");
		JButton destr_b = new JButton("Delete Tree");
		JButton exit_b = new JButton("Exit");
		
		add_b.setFont(new Font("Serif", Font.PLAIN, 18)); // and set their fonts
		del_b.setFont(new Font("Serif", Font.PLAIN, 18));
		disp_b.setFont(new Font("Serif", Font.PLAIN, 18));
		draw_b.setFont(new Font("Serif", Font.PLAIN, 18));
		destr_b.setFont(new Font("Serif", Font.PLAIN, 18));
		exit_b.setFont(new Font("Serif", Font.PLAIN, 18));
		
		JPanel button_panel = new JPanel(new GridLayout(3,3, 5, 5)); // create jPanel
		
		in_fix.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){ mode = 0; }
		} );
		
		pre_fix.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){ mode = 1; }
		} );
		
		post_fix.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){ mode = 2; }
		} );
		
		add_b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				boolean isValid = false;
				while(!isValid){
					String str = JOptionPane.showInputDialog("Enter node data to be inserted: ");
					if(str.length() <= 6){
						isValid = true;
						bst.insert(str);
						JOptionPane.showMessageDialog(button_panel, "\nNew Data Added: " + str);
						System.out.println(bst.print(mode));
					}
					if(!isValid){
						JOptionPane.showMessageDialog(button_panel, "\nData must be less than 6 characters.");
					}
				}
			}
		} );
		
		del_b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				String str = JOptionPane.showInputDialog("Enter node data to be deleted: ");
				JOptionPane.showMessageDialog(button_panel, "\nNode Data " + str + " cleared.");
				System.out.println(bst.print(mode));
			}
		} );
			
		disp_b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				System.out.println(bst.print(mode));
				JFrame mini = new JFrame("Display Current Tree");
				mini.setPreferredSize(new Dimension(500,500));
				JPanel m_panel = new JPanel();
				m_panel.setPreferredSize(new Dimension(500,500));
				JTextArea area = new JTextArea(bst.print(mode));
				area.setFont(new Font("Serif", Font.PLAIN, 20));
				
				JScrollPane scroll = new JScrollPane(area);
				scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
				
				JScrollBar bar = scroll.getVerticalScrollBar();
				bar.setPreferredSize(new Dimension(20, 0));
				
				area.setEditable(false);
				m_panel.add(scroll, BorderLayout.CENTER);
				mini.add(m_panel, BorderLayout.CENTER);
				mini.pack();
				mini.setVisible(true);
			}
		} );
		
		draw_b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				// TODO: display tree in jScrollPane
				JFrame mini = new JFrame("Tree Drawing");
				mini.setPreferredSize(new Dimension(500,500));
				JPanel m_panel = new JPanel(new GridLayout(3,3, 5, 5));
				m_panel.setPreferredSize(new Dimension(500,500));
				
				
				mini.pack();
				mini.setVisible(true);
			}
		} );
		
		destr_b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				// TODO: display tree in jScrollPane
				String[] choices = {"Yes", "No"};
				Object ans = JOptionPane.showInputDialog(null, 
						"Are you sure you wish to destory the tree?", "Selection", JOptionPane.DEFAULT_OPTION, null, 
						choices, "No");
				if(ans.toString().equals("Yes")){
					bst.destroy();
					JOptionPane.showMessageDialog(button_panel, "\nThe given tree was destroyed.");
				}
				else { JOptionPane.showMessageDialog(button_panel, "\nUser has canceled destroy operation."); }
			}
		} );
		
		exit_b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				System.exit(0);
			}
		} );
		
		button_panel.add(in_fix);
		button_panel.add(pre_fix);
		button_panel.add(post_fix);
		button_panel.add(add_b);
		button_panel.add(del_b);
		button_panel.add(disp_b);
		button_panel.add(draw_b);
		button_panel.add(destr_b);
		button_panel.add(exit_b);
		
		my_frame.add(button_panel); // add the jPanel to the jFrame
		
		// ----- set JFrame to visible -----
		my_frame.pack();
		my_frame.setLocationRelativeTo(null);
		my_frame.setVisible(true);
		
	}
		
	public static void main(String[] args) {
		BSTDemo bst = new BSTDemo();
	}

}
