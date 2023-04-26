import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import calculator.calcLanguages;

// *** CREDIT FOR GUIDANCE GOES TO 'Bro Code': https://www.youtube.com/watch?v=dfhmTyRTCSQ ***

public class Calculatorproject1 implements ActionListener{

    JFrame      frame;
    JTextField  textfield;
    JPanel      panel;
    JButton[]       numberButtons = new JButton[10];
    JButton[]       functionButtons = new JButton[12];
    JButton         addButton, subButton, mulButton, divButton;
    JButton         decButton, equButton, delButton, clrButton, negButton;
    
    // Language options
    JButton         engButton, finButton, sweButton;
    // Reverts delButton and clrButton to English
    String defaultDelText = "DEL";
    String defaultClrText = "Clear";
    
    
    // Optional country flags
    ImageIcon engFlag = new ImageIcon("src/flags/EngFlag-button.png");
    ImageIcon finFlag = new ImageIcon("src/flags/FinFlag-button.png");
    ImageIcon sweFlag = new ImageIcon("src/flags/SweFlag-button.png");
    
    
    // = Default Font
    Font defFont = new Font("Roboto", Font.BOLD, 32);
    Font altFont = new Font("Roboto", Font.BOLD, 23);
    Font altFon2t = new Font("Helvetica", Font.PLAIN, 22);
    
    double num1=0,num2=0,result=0;
    char operator;
    
    Calculatorproject1(){
        frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(395, 575);
        frame.setLayout (null);
        frame.setResizable(false);
        
        textfield = new JTextField();
        textfield.setBounds(40, 80, 300, 50);
        textfield.setFont(defFont);
        Color veryLightGray = new Color(220, 220, 220);
        textfield.setBackground(veryLightGray);
        // textfield.setFont(secFont);
        textfield.setEditable(false);
        
                 
        addButton = new JButton("+");
        subButton = new JButton("-");
        mulButton = new JButton("*");
        divButton = new JButton("/");
        decButton = new JButton(",");
        equButton = new JButton("=");
        delButton = new JButton(defaultDelText);
        clrButton = new JButton(defaultClrText);
        negButton = new JButton("-/+");
        
        
        // engButton = new JButton("ENG");
        engButton = new JButton(engFlag);
        // finButton = new JButton("FIN");
        finButton = new JButton(finFlag);
        // sweButton = new JButton("SWE");
        sweButton = new JButton(sweFlag);
        

        functionButtons[0] = addButton;
        functionButtons[1] = subButton;
        functionButtons[2] = mulButton;
        functionButtons[3] = divButton;
        functionButtons[4] = decButton;
        functionButtons[5] = equButton;
        functionButtons[6] = delButton;
        functionButtons[7] = clrButton;
        functionButtons[8] = negButton;
        functionButtons[9] = engButton;
        functionButtons[10] = finButton;
        functionButtons[11] = sweButton;
        
        
        
        
        for(int i=0;i<12;i++) {
            functionButtons[i].addActionListener(this);
            functionButtons[i].setFont(defFont);
            functionButtons[i].setFocusable(false);
        }
        
        for(int i=0;i<10;i++) {
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].addActionListener(this);
            numberButtons[i].setFont(defFont);
            numberButtons[i].setFocusable(false);
        }
        
        
        
        
        negButton.setBounds(40, 465, 80, 50);
        delButton.setBounds(120, 465, 90, 50);
        clrButton.setBounds(210, 465, 130, 50);
        
        engButton.setBounds(40, 25, 45, 31);
        finButton.setBounds(87, 25, 45, 31);
        sweButton.setBounds(134, 25, 45, 31);
        
        
        
        
        // Numbers Array
        panel = new JPanel();
        panel.setBounds(40,145, 300, 300);
        panel.setLayout(new GridLayout(4, 4, 10, 10));
        panel.setBackground(Color.LIGHT_GRAY);
        
        
        // 4 x 4 PANEL
        panel.add(numberButtons[1]);
        panel.add(numberButtons[2]);
        panel.add(numberButtons[3]);
        panel.add(addButton);
        panel.add(numberButtons[4]);
        panel.add(numberButtons[5]);
        panel.add(numberButtons[6]);
        panel.add(subButton);
        panel.add(numberButtons[7]);
        panel.add(numberButtons[8]);
        panel.add(numberButtons[9]);
        panel.add(mulButton);
        panel.add(decButton);
        panel.add(numberButtons[0]);
        panel.add(equButton);
        panel.add(divButton);
        
        
        // ALL FRAME BUTTONS
        frame.add(panel);
        frame.add(negButton);
        frame.add(delButton);
        frame.add(clrButton);
        
        frame.add(engButton);
        frame.add(finButton);
        frame.add(sweButton);
        
        frame.add(textfield);
        frame.setVisible(true);
    
    
    }
    
    
    
    
    
    public static void main(String[] args) {
        // System.out.println("Hello World!");
        Calculatorproject1 calc = new Calculatorproject1();
    }
    
    public void actionPerformed(ActionEvent e) {
        for(int i=0;i<10;i++) {
            if(e.getSource() == numberButtons[i]) {
                textfield.setText(textfield.getText().concat(String.valueOf(i)));
            }
        }
        
        
        if (e.getSource() == addButton) {
            num1 = Double.parseDouble(textfield.getText());
            operator = '+';
            textfield.setText("");
        }
        if (e.getSource() == subButton) {
            num1 = Double.parseDouble(textfield.getText());
            operator = '-';
            textfield.setText("");
        }
        if (e.getSource() == mulButton) {
            num1 = Double.parseDouble(textfield.getText());
            operator = '*';
            textfield.setText("");
        }
        if (e.getSource() == decButton) {
            textfield.setText(textfield.getText().concat("."));
        }
        if (e.getSource() == equButton) {
            num2 = Double.parseDouble(textfield.getText());
            
            switch(operator) {
                case'+':
                    result=num1+num2;
                    break;
                case'-':
                    result=num1-num2;
                    break;
                case'*':
                    result=num1*num2;
                    break;
                case'/':
                    result=num1/num2;
                    break;
            }
            textfield.setText(String.valueOf(result));
            num1=result;
        }
        if (e.getSource() == divButton) {
            num1 = Double.parseDouble(textfield.getText());
            operator = '/';
            textfield.setText("");
        }
        if (e.getSource() == clrButton) {
            textfield.setText("");
        }
        if (e.getSource() == delButton) {
            String string = textfield.getText();
            textfield.setText("");
            for(int i=0;i<string.length()-1;i++) {
                textfield.setText(textfield.getText()+string.charAt(i));
            }
        }
        if (e.getSource() == negButton) {
            double temp = Double.parseDouble(textfield.getText());
            temp*=-1;
            textfield.setText(String.valueOf(temp));
        }
        
        
        // Language Settings
        if (e.getSource() == engButton) {
            negButton.setFont(defFont);
            delButton.setText(defaultDelText);
            delButton.setFont(defFont);
            clrButton.setText(defaultClrText);
            clrButton.setFont(defFont);
            // Default Values
            negButton.setBounds(40, 465, 80, 50);
            delButton.setBounds(120, 465, 90, 50);
            clrButton.setBounds(210, 465, 130, 50);
        }
        if (e.getSource() == finButton) {
            negButton.setFont(altFont);
            delButton.setText(calcLanguages.suomi1);
            delButton.setFont(altFont);
            clrButton.setText(calcLanguages.suomi2);
            clrButton.setFont(altFont);
            
            negButton.setBounds(40, 465, 70, 50);
            delButton.setBounds(110, 465, 100, 50);
            clrButton.setBounds(210, 465, 130, 50);
        }
        if (e.getSource() == sweButton) {
            negButton.setFont(altFont);
            delButton.setText(calcLanguages.svenska1);
            delButton.setFont(altFont);
            clrButton.setText(calcLanguages.svenska2);
            clrButton.setFont(altFont);
            
            negButton.setBounds(40, 465, 70, 50);
            delButton.setBounds(110, 465, 110, 50);
            clrButton.setBounds(220, 465, 120, 50);
        }
    }
}
