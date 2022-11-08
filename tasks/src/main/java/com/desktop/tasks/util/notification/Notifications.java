package com.desktop.tasks.util.notification;


import javax.swing.*;

public class Notifications {

    public static void showFormValidationAlert(String message) {
        JOptionPane.showMessageDialog(null,
                message,
                "Information",
                JOptionPane.INFORMATION_MESSAGE);
    }

    public static void showDeleteRowErrorMessage() {
        JOptionPane.showMessageDialog(null,
                "DELETE_ROW_ERROR",
                "Alert",
                JOptionPane.ERROR_MESSAGE);
    }
}
