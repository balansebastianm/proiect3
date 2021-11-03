package App.loginPackage;

import java.awt.event.ActionEvent;

public class CancelButton extends Button{
    CancelButton (String text) {
        super(text);
        this.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
            System.exit(0);
    }
}
