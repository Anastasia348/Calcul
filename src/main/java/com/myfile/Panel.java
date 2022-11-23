package com.myfile;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Panel extends JPanel implements ActionListener {

    private JButton numbers[] = new JButton[10];
    private Font font = new Font("SanSerif", Font.BOLD, 16);
    private JTextField output = new JTextField();
    private JButton clear = new JButton("AC");
    private JButton plus = new JButton("+");
    private JButton minus = new JButton("-");
    private JButton multiply = new JButton("*");
    private JButton devide = new JButton("/");
    private JButton equall = new JButton("=");
    int oper = 0, result = 0, firstNumber = 0, secondNumber = 0;



    public Panel(){
        setLayout(null);
        setFocusable(true);
        grabFocus();

        numbers[0] = new JButton("0");
        numbers[0].setBounds(75, 70 , 50, 50);
        numbers[0].setFont(font);
        add(numbers[0]);

        for(int x = 0; x < 3; x++){
            for(int y = 0; y < 3; y++){
                numbers[y * 3 + x + 1] = new JButton((y * 3 + x + 1) + "");
                numbers[y * 3 + x + 1].setBounds(x * (50 + 10) + 15, y * (50 + 10) + 130, 50, 50);
                numbers[y * 3 + x + 1].setFont(font);
                add(numbers[y * 3 + x + 1]);
            }
        }

        output.setBounds(10, 10, 250, 50);
        output.setEditable(false);
        output.setFont(font);
        add(output);

        clear.setBounds(15, 70, 50, 50);
        add(clear);
        clear.addActionListener(this);


        equall.setBounds(135, 70, 50, 50);
        equall.setFont(font);
        add(equall);
        equall.addActionListener(this);

        plus.setBounds(195, 70, 60, 50);
        plus.setFont(font);
        add(plus);
        plus.addActionListener(this);

        minus.setBounds(195, 130, 60, 50);
        minus.setActionCommand("-");
        minus.setFont(font);
        add(minus);
        minus.addActionListener(this);

        multiply.setBounds(195, 190, 60, 50);
        multiply.setFont(font);
        add(multiply);
        multiply.addActionListener(this);

        devide.setBounds(195, 250, 60, 50);
        devide.setFont(font);
        add(devide);
        devide.addActionListener(this);

        ActionListener l = (ActionEvent event) -> {
            JButton c = (JButton)event.getSource();

            output.setText(output.getText() + c.getText());
        };

        for(JButton c : numbers){
            c.addActionListener(l);
        }

        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                char symbol = e.getKeyChar();

                if(!Character.isDigit(symbol))
                    return;
                output.setText(output.getText() + symbol);
            }
        });



        class KeyDispatcher implements KeyEventDispatcher {
            public boolean dispatchKeyEvent(KeyEvent e) {

                return true;
            }
        };
    };

    @Override
    public void actionPerformed(ActionEvent q) {
        if (q.getSource() == plus) {
            firstNumber = Integer.parseInt(output.getText());
            output.setText(null);
            oper = 1;
        }
        if (q.getSource() == minus) {
            firstNumber = Integer.parseInt(output.getText());
            output.setText(null);
            oper = 2;
        }
        if (q.getSource() == multiply) {
            firstNumber = Integer.parseInt(output.getText());
            output.setText(null);
            oper = 3;
        }
        if (q.getSource() == devide) {
            firstNumber = Integer.parseInt(output.getText());
            output.setText(null);
            oper = 4;
        }
        if (q.getSource() == clear) {
            output.setText(null);
        }
        if (q.getSource() == equall) {
            secondNumber = Integer.parseInt(output.getText());
            switch (oper){
                case 1:
                    result = firstNumber + secondNumber;
                    break;
                case 2:
                    result = firstNumber - secondNumber;
                    break;
                case 3:
                    result = firstNumber * secondNumber;
                    break;
                case 4:
                    result = firstNumber / secondNumber;
                    break;
                default:
                    result = 0;
            }
            output.setText("" + result);


        }


    }

};
