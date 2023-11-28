package org.example.presentations;

import javax.swing.*;

public class WarningDialog {
    static public int warningDialog(String message) {
        int confirm;
        Object[] options = { "Confirm", "Cancel" };
        int answer = JOptionPane.showOptionDialog(null, message, "Alert",
                JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE,
                null, options, options[0]);
        switch (answer) {
            case 0:
                confirm = 0;
                break;
            case 1:
            default:
                confirm = 1;
                break;
        }
        return confirm;
    }
}
