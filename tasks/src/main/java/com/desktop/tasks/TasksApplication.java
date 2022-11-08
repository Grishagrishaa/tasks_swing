package com.desktop.tasks;

import com.desktop.tasks.ui.mainmenu.controller.MainMenuController;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import javax.swing.*;

@SpringBootApplication
@EnableJpaAuditing
public class TasksApplication {

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(
                    null,
                    "There was an error while loading windows look an feel: " + e,
                    "Alert",
                    JOptionPane.ERROR_MESSAGE);
        }
        ConfigurableApplicationContext context = createApplicationContext(args);
        displayMainFrame(context);
    }

    private static ConfigurableApplicationContext createApplicationContext(String[] args) {
        return new SpringApplicationBuilder(TasksApplication.class)
                .headless(false)
                .run(args);
    }

    private static void displayMainFrame(ConfigurableApplicationContext context) {
        SwingUtilities.invokeLater(() -> {
            MainMenuController mainMenuController = context.getBean(MainMenuController.class);
            mainMenuController.prepareAndOpenFrame();
        });
    }

}
