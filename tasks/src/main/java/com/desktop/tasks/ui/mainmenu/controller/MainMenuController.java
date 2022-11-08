package com.desktop.tasks.ui.mainmenu.controller;


import com.desktop.tasks.ui.forms.birthdays.controller.BirthdayController;
import com.desktop.tasks.ui.forms.flights.controller.FlightController;
import com.desktop.tasks.ui.forms.meetings.controller.BusinessMeetController;
import com.desktop.tasks.ui.forms.shared.controller.AbstractFrameController;
import com.desktop.tasks.ui.mainmenu.view.MainMenuFrame;
import org.springframework.stereotype.Controller;

@Controller
public class MainMenuController extends AbstractFrameController {

    private final MainMenuFrame mainMenuFrame;
    private final FlightController flightController;
    private final BirthdayController birthdayController;
    private final BusinessMeetController businessMeetController;

    public MainMenuController(MainMenuFrame mainMenuFrame, FlightController flightController, BirthdayController birthdayController, BusinessMeetController businessMeetController) {
        this.mainMenuFrame = mainMenuFrame;
        this.flightController = flightController;
        this.birthdayController = birthdayController;
        this.businessMeetController = businessMeetController;
    }

    public void prepareAndOpenFrame() {
        registerAction(mainMenuFrame.getFlightsBtn(), (e) -> openFlightsWindow());
        registerAction(mainMenuFrame.getBirthdaysBtn(), (e) -> openBirthdaysWindow());
        registerAction(mainMenuFrame.getMeetBtn(), (e) -> openBusinessMeetingsWindow());

        mainMenuFrame.setVisible(true);
    }

    private void openFlightsWindow() {
        flightController.prepareAndOpenFrame();
    }

    private void openBirthdaysWindow() {
        birthdayController.prepareAndOpenFrame();
    }

    private void openBusinessMeetingsWindow() {
        businessMeetController.prepareAndOpenFrame();
    }

}
