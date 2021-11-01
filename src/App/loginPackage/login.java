package App.loginPackage;

import App.Meniu.Meniu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Objects;
import java.util.Scanner;

public class login {
    private JPanel panel;
    private JLabel user_label, password_label, message;
    private JTextField userName_text;
    private JPasswordField password_text;
    private JButton submit, cancel;
    private JFrame frame;

    public void logare(){
        frame = new JFrame();
        //username
        user_label = new JLabel();
        user_label.setText("Username:");
        userName_text = new JTextField();

        //password
        password_label = new JLabel();
        password_label.setText("Password");
        password_text = new JPasswordField();

        //validare
        submit = new JButton("Submit");
        cancel = new JButton("Cancel");

        panel = new JPanel(new GridLayout(4,2));
        panel.add(user_label);
        panel.add(userName_text);

        panel.add(password_label);
        panel.add(password_text);

        message = new JLabel();
        panel.add(submit);
        panel.add(cancel);
        panel.add(message);


        //listeners
        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FileReader inputFile = null;
                try {
                    inputFile = new FileReader("C:\\Users\\hades\\IdeaProjects\\proiect3s\\src\\App\\loginPackage\\userdata.txt");
                } catch (FileNotFoundException ex) {
                    ex.printStackTrace();
                }
                Scanner in = new Scanner(inputFile);
                String userNameInput = userName_text.getText();
                String passwordInput = String.valueOf(password_text.getPassword());
                boolean login = false;

                while (in.hasNextLine())
                {
                    String s = in.nextLine();
                    String[] sArray = s.split(",");

                    if (Objects.equals(userNameInput, sArray[0]) && passwordInput.equals(sArray[1]))
                    {
                        JOptionPane.showMessageDialog(null,
                                "Login Successful", "Success",
                                JOptionPane.INFORMATION_MESSAGE);
                        login = true;

                        frame.dispose();
                        Meniu main = new Meniu();
                        main.runMeniu();

                        break;
                    }
                }
                if(!login)
                {
                    JOptionPane.showMessageDialog(null,
                            "Invalid Username / Password Combo", "Error",
                            JOptionPane.ERROR_MESSAGE);
                }

                in.close();

            }
        });

        cancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        frame.add(panel, BorderLayout.CENTER);
        frame.setTitle("Log in");
        frame.setSize(300,100);
        frame.setVisible(true);
    }

    public static void main(String[] args){
         login l = new login();
         l.logare();
    }
}
