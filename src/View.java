
import java.awt.*;
import javax.swing.*;

public class View extends JFrame {

	public Color ourple = new Color(0x4D1979);
	Font defFont = new Font("Serif", Font.PLAIN, 20);
	Font butFont = new Font("SansSerif", Font.PLAIN, 20);
    ImageIcon cat = new ImageIcon("sadgato.png");
    JFrame frame = new JFrame("ARM encoding and decoding");
    JPanel panel = new JPanel();

    JButton encode = new JButton("Encode");
    JButton decodeBin = new JButton("Binary Decode");
    JButton decodeHex = new JButton("Hex Decode");

    JLabel l1 = new JLabel("To ARM", SwingConstants.CENTER);
    JLabel l2 = new JLabel("Binary Input", SwingConstants.CENTER);
    JLabel l3 = new JLabel("Hex Input", SwingConstants.CENTER);
    JLabel empty = new JLabel();

    JTextField arm = new JTextField(); 
    JTextField bin = new JTextField(); 
    JTextField hex = new JTextField(); 

    JTextField error = new JTextField("Error Feedback");
	
	public static void main(String[] args) {
		new View();
	}
	
	View() {
		frame.setLayout(new BorderLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(650, 400);
        frame.getContentPane().setBackground(ourple);

        //Images
        ImageIcon cat = new ImageIcon("sadgato.png");
        Image image = cat.getImage();
        Image newImage = image.getScaledInstance(150, 60, java.awt.Image.SCALE_SMOOTH);
        cat = new ImageIcon(newImage);
      
        //Buttons
        encode.setFont(butFont);
        encode.setForeground(ourple);

        decodeBin.setFont(butFont);
        decodeBin.setForeground(ourple);

        decodeHex.setFont(butFont);
        decodeHex.setForeground(ourple);

        // textField
        arm.setFont(defFont);
        hex.setFont(defFont);
        bin.setFont(defFont);
        error.setFont(defFont);
        error.setForeground(Color.BLACK);
        
        //Labels
        l1.setFont(defFont);
        l1.setForeground(Color.WHITE);
        l2.setFont(defFont);
        l2.setForeground(Color.WHITE);
        l3.setFont(defFont);
        l3.setForeground(Color.WHITE);
        
        //Panel organization
        empty.setVisible(false);
        
        frame.add(new JLabel(cat), BorderLayout.NORTH);
        frame.add(error, BorderLayout.SOUTH);
        frame.add(panel);
        
        panel.setBackground(null);
        panel.setLayout(new GridLayout(5, 2));
        panel.add(arm);
        panel.add(encode);
        panel.add(l1);
        panel.add(empty);
        panel.add(l2);
        panel.add(l3);
        panel.add(bin);
        panel.add(hex);
        panel.add(decodeBin);
        panel.add(decodeHex);

        frame.setVisible(true);
	}

}
