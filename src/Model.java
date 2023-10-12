
public class Model {
	Control c;
    int r0, r0Int;
    int r1, r1Int;
    int r2, r2Int;
    
    String[] split;
    int binN1 = 0;
    int binN2 = 0;
    int binN3 = 0;
    int binN4 = 0;
    int binN5 = 0;
    int binN6 = 0;
    int binN7 = 0;
    int binN8 = 0;
    
    String binResult;
    int n1, n2, n3, n4, n5, n6, n7, n8;
    String bin1 = "";
    String bin2 = "";
    String bin3 = "";
    String bin4 = "";
    String bin5 = "";
    String bin6 = "";
    String bin7 = "";
    String bin8 = "";
    
    public Model(Control fromC) {
        c = fromC;
    }
    
    public void armToBoth(String arm) {
        //Arm to binary
        c.error.setText("Error Feedback");
        c.bin.setText("");
        c.hex.setText("");

        arm = arm.replaceAll(" ", "");

        binResult = "1110000";
        try {
            if (arm.substring(0, 3).equalsIgnoreCase("AND"))
                binResult += "0000";
            else if (arm.substring(0, 3).equalsIgnoreCase("EOR"))
                binResult += "0001";
            else if (arm.substring(0, 3).equalsIgnoreCase("SUB"))
                binResult += "0010";
            else if (arm.substring(0, 3).equalsIgnoreCase("RSB"))
                binResult += "0011";
            else if (arm.substring(0, 3).equalsIgnoreCase("ADD"))
                binResult += "0100";
            else if (arm.substring(0, 3).equalsIgnoreCase("ADC"))
                binResult += "0101";
            else if (arm.substring(0, 3).equalsIgnoreCase("SBC"))
                binResult += "0110";
            else if (arm.substring(0, 3).equalsIgnoreCase("RSC"))
                binResult += "0111";
            else if (arm.substring(0, 3).equalsIgnoreCase("TST"))
                binResult += "1000";
            else if (arm.substring(0, 3).equalsIgnoreCase("TEQ"))
                binResult += "1001";
            else if (arm.substring(0, 3).equalsIgnoreCase("CMP"))
                binResult += "1010";
            else if (arm.substring(0, 3).equalsIgnoreCase("CMN"))
                binResult += "1011";
            else if (arm.substring(0, 3).equalsIgnoreCase("ORR"))
                binResult += "1100";
            else if (arm.substring(0, 3).equalsIgnoreCase("MOV"))
                binResult += "1101";
            else if (arm.substring(0, 3).equalsIgnoreCase("BIC"))
                binResult += "1110";
            else if (arm.substring(0, 3).equalsIgnoreCase("MVN"))
                binResult += "1111";
        } catch (Exception e) {
            c.error.setText("Invalid ARM Input");

        }

        binResult += "0";

        String r1 = "";
        String r0 = "";
        String r2 = "";
        try {
            split = arm.split(",");
            r1Int = Integer.parseInt(split[1].substring(1));
            r0Int = Integer.parseInt(split[0].substring(4));
            r2Int = Integer.parseInt(split[2].substring(1));
            if (r0Int > 15 || r0Int < 0) {
                c.error.setText("Invalid ARM Input");
            }
            if (r1Int > 15 || r1Int < 0) {
                c.error.setText("Invalid ARM Input");
            }
            if (r2Int > 15 || r2Int < 0) {
                c.error.setText("Invalid ARM Input");
            }
            for (int i = 0; i < 4; ++i) {
                r1 = (r1Int & 1) + r1;
                r0 = (r0Int & 1) + r0;
                r2 = (r2Int & 1) + r2;
                r1Int = (short) (r1Int >> 1);
                r2Int = (short) (r2Int >> 1);
                r0Int = (short) (r0Int >> 1);
            }
        } catch (Exception e) {
            c.error.setText("Invalid ARM Input");

        }

        binResult = binResult + r1 + r0 + "00000000" + r2;

        if (binResult.length() != 32) {
            c.error.setText("Invalid ARM Input");

        }

        //Binary to Hex

        //Binary to Integer
        	//Turns binary into integers 4 at a time
        try {
            n1 = Integer.parseInt(binResult.substring(0, 4), 2);
            n2 = Integer.parseInt(binResult.substring(4, 8), 2);
            n3 = Integer.parseInt(binResult.substring(8, 12), 2);
            n4 = Integer.parseInt(binResult.substring(12, 16), 2);
            n5 = Integer.parseInt(binResult.substring(16, 20), 2);
            n6 = Integer.parseInt(binResult.substring(20, 24), 2);
            n7 = Integer.parseInt(binResult.substring(24, 28), 2);
            n8 = Integer.parseInt(binResult.substring(28, 32), 2);
        } catch (Exception e) {
            c.error.setText("Invalid ARM Input");

        }

        //Integer to Hex
        String hex = "";
        hex = Integer.toHexString(n1) + Integer.toHexString(n2) + Integer.toHexString(n3)
                + Integer.toHexString(n4) + Integer.toHexString(n5) + Integer.toHexString(n6) 
                + Integer.toHexString(n7) + Integer.toHexString(n8);

        //Text Placement
        if (c.error.getText().equals("Error Feedback")) {
            c.bin.setText(binResult);
            c.hex.setText(hex.toUpperCase());
        }

    }

    public void binaryToBoth(String binary) {
        //Binary Arm
        c.error.setText("Error Feedback");
        c.arm.setText("");
        c.hex.setText("");
        binary = binary.replaceAll(" ", "");
        if (binary.length() != 32) {
            c.error.setText("Invalid Binary Input");
        }

        String arm = "";
        try {
            if (binary.substring(7, 11).equals("0000"))
                arm += "AND ";
            else if (binary.substring(7, 11).equals("0001"))
                arm += "EOR ";
            else if (binary.substring(7, 11).equals("0010"))
                arm += "SUB ";
            else if (binary.substring(7, 11).equals("0011"))
                arm += "RSB ";
            else if (binary.substring(7, 11).equals("0100"))
                arm += "ADD ";
            else if (binary.substring(7, 11).equals("0101"))
                arm += "ADC ";
            else if (binary.substring(7, 11).equals("0110"))
                arm += "SBC ";
            else if (binary.substring(7, 11).equals("0111"))
                arm += "RSC ";
            else if (binary.substring(7, 11).equals("1000"))
                arm += "TST ";
            else if (binary.substring(7, 11).equals("1001"))
                arm += "TEQ ";
            else if (binary.substring(7, 11).equals("1010"))
                arm += "CMP ";
            else if (binary.substring(7, 11).equals("1011"))
                arm += "CMN ";
            else if (binary.substring(7, 11).equals("1100"))
                arm += "ORR ";
            else if (binary.substring(7, 11).equals("1101"))
                arm += "MOV ";
            else if (binary.substring(7, 11).equals("1110"))
                arm += "BIC ";
            else if (binary.substring(7, 11).equals("1111"))
                arm += "MVN ";
        } catch (Exception e) {
            c.error.setText("Invalid Binary Input");
        }

        try {
            r0 = Integer.parseInt(binary.substring(16, 20), 2);
            r1 = Integer.parseInt(binary.substring(12, 16), 2);
            r2 = Integer.parseInt(binary.substring(28, 32), 2);
        } catch (Exception e) {
            System.out.println("Invalid Binary Input");
        }
        arm = arm + "r" + r0 + "," + "r" + r1 + "," + "r" + r2;

        //Binary to Hex
        //Binary to Integer
        	//Similar 4 by 4 Binary to Integer process
        try {
            n1 = Integer.parseInt(binary.substring(0, 4), 2);
            n2 = Integer.parseInt(binary.substring(4, 8), 2);
            n3 = Integer.parseInt(binary.substring(8, 12), 2);
            n4 = Integer.parseInt(binary.substring(12, 16), 2);
            n5 = Integer.parseInt(binary.substring(16, 20), 2);
            n6 = Integer.parseInt(binary.substring(20, 24), 2);
            n7 = Integer.parseInt(binary.substring(24, 28), 2);
            n8 = Integer.parseInt(binary.substring(28, 32), 2);
        } catch (Exception e) {
            c.error.setText("Invalid Binary Input");
        }

        //Integer to Hex
        String hex = "";
        hex = Integer.toHexString(n1) + Integer.toHexString(n2) + Integer.toHexString(n3)
                + Integer.toHexString(n4) + Integer.toHexString(n5) + Integer.toHexString(n6) 
                + Integer.toHexString(n7) + Integer.toHexString(n8);
        if (c.error.getText().equals("Error Feedback")) {
            c.arm.setText(arm);
            c.hex.setText(hex.toUpperCase());

        }

    }

    public void hexToBoth(String hexString) {
        //Hex to Binary
        c.error.setText("Error Feedback");
        c.bin.setText("");
        c.arm.setText("");
        bin1 = "";
        bin2 = "";
        bin3 = "";
        bin4 = "";
        bin5 = "";
        bin6 = "";
        bin7 = "";
        bin8 = "";
        binN1 = 0;
        binN2 = 0;
        binN3 = 0;
        binN4 = 0;
        binN5 = 0;
        binN6 = 0;
        binN7 = 0;
        binN8 = 0;
        hexString = hexString.replaceAll(" ", "");
        if (hexString.length() != 8) {
            c.error.setText("Invalid Hex Input");
        }
        
        //Hex to Integer
        try {
            binN1 = Integer.parseInt(hexString.substring(0, 1), 16);
            binN2 = Integer.parseInt(hexString.substring(1, 2), 16);
            binN3 = Integer.parseInt(hexString.substring(2, 3), 16);
            binN4 = Integer.parseInt(hexString.substring(3, 4), 16);
            binN5 = Integer.parseInt(hexString.substring(4, 5), 16);
            binN6 = Integer.parseInt(hexString.substring(5, 6), 16);
            binN7 = Integer.parseInt(hexString.substring(6, 7), 16);
            binN8 = Integer.parseInt(hexString.substring(7, 8), 16);

        } catch (Exception e) {
            c.error.setText("Invalid Hex Input");

        }
        //Integer to Binary
        try {
            for (int i = 0; i < 4; ++i) {
                bin1 = (binN1 & 1) + bin1;
                bin2 = (binN2 & 1) + bin2;
                bin3 = (binN3 & 1) + bin3;
                bin4 = (binN4 & 1) + bin4;
                bin5 = (binN5 & 1) + bin5;
                bin6 = (binN6 & 1) + bin6;
                bin7 = (binN7 & 1) + bin7;
                bin8 = (binN8 & 1) + bin8;

                binN1 = (short) (binN1 >> 1);
                binN2 = (short) (binN2 >> 1);
                binN3 = (short) (binN3 >> 1);
                binN4 = (short) (binN4 >> 1);
                binN5 = (short) (binN5 >> 1);
                binN6 = (short) (binN6 >> 1);
                binN7 = (short) (binN7 >> 1);
                binN8 = (short) (binN8 >> 1);

            }
        } catch (Exception e) {
            c.error.setText("Invalid Hex Input");
        }

        String binary = "";
        binary = bin1 + bin2 + bin3 + bin4 + bin5 + bin6 + bin7 + bin8;
        if (binary.length() != 32) {
            c.error.setText("Invalid Hex Input");
        }

        //Binary to ARM
        String arm = "";

        if (binary.substring(7, 11).equals("0000"))
            arm += "AND ";
        else if (binary.substring(7, 11).equals("0001"))
            arm += "EOR ";
        else if (binary.substring(7, 11).equals("0010"))
            arm += "SUB ";
        else if (binary.substring(7, 11).equals("0011"))
            arm += "RSB ";
        else if (binary.substring(7, 11).equals("0100"))
            arm += "ADD ";
        else if (binary.substring(7, 11).equals("0101"))
            arm += "ADC ";
        else if (binary.substring(7, 11).equals("0110"))
            arm += "SBC ";
        else if (binary.substring(7, 11).equals("0111"))
            arm += "RSC ";
        else if (binary.substring(7, 11).equals("1000"))
            arm += "TST ";
        else if (binary.substring(7, 11).equals("1001"))
            arm += "TEQ ";
        else if (binary.substring(7, 11).equals("1010"))
            arm += "CMP ";
        else if (binary.substring(7, 11).equals("1011"))
            arm += "CMN ";
        else if (binary.substring(7, 11).equals("1100"))
            arm += "ORR ";
        else if (binary.substring(7, 11).equals("1101"))
            arm += "MOV ";
        else if (binary.substring(7, 11).equals("1110"))
            arm += "BIC ";
        else if (binary.substring(7, 11).equals("1111"))
            arm += "MVN ";

        try {
            r0 = Integer.parseInt(binary.substring(16, 20), 2);
            r1 = Integer.parseInt(binary.substring(12, 16), 2);
            r2 = Integer.parseInt(binary.substring(28, 32), 2);
        } catch (Exception e) {
            c.error.setText("Invalid Hex Input");
        }
        arm = arm + "r" + r0 + "," + "r" + r1 + "," + "r" + r2;

        if (c.error.getText().equals("Error Feedback")) {
            c.arm.setText(arm);
            c.bin.setText(binary);

        }

    }


}
