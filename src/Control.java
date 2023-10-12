
import java.awt.event.*;

/*
 * Fall 2023 COSC 20203
 * Author: Oscar Arenas
 * Lab 2
 */

public class Control extends View implements ActionListener {
	Model m;

    public static void main(String args[]) {
        new Control();
    }

    public Control() {
        m = new Model(this);
        buttSet();
    }
    
    public void buttSet() {
        encode.addActionListener(this);
        decodeBin.addActionListener(this);
        decodeHex.addActionListener(this);
    }
    
    public void actionPerformed(ActionEvent e) {
        String whichWidget = e.getActionCommand();
        System.out.println("Performing " + whichWidget + " ");

        if (whichWidget.equals("Encode"))
            m.armToBoth(arm.getText());
        if (whichWidget.equals("Decode Binary"))
            m.binaryToBoth(bin.getText());
        if (whichWidget.equals("Decode Hex"))
            m.hexToBoth(hex.getText());

    }

}
