

package com.mycompany.finalpro;


import javax.swing.JFrame;

public class Main {
    public static void main(String[] args) {
        JFrame f = new JFrame();
        
        f.setTitle("Project");
        Controller T=new Controller();
        f.setContentPane(T);
        f.setSize(700,700);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        

    }
}