package App.loginPackage;
import javax.swing.*;
import java.awt.event.ActionListener;
public abstract class Button extends JButton implements ActionListener {

    public Button (String text) {
        this.setFocusable(false);
        this.setText(text);
    }
}
