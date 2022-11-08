package com.desktop.tasks.ui.forms.flights.controller;


import com.desktop.tasks.dao.entity.tasks.Flight;
import com.desktop.tasks.service.api.ITaskService;
import com.desktop.tasks.ui.forms.flights.model.FlightTableModel;
import com.desktop.tasks.ui.forms.flights.view.forms.AddFlightFrame;
import com.desktop.tasks.ui.forms.flights.view.forms.FlightFormBtnPanel;
import com.desktop.tasks.ui.forms.flights.view.forms.FlightFormPanel;
import com.desktop.tasks.ui.forms.flights.view.tables.FlightTableBtnPanel;
import com.desktop.tasks.ui.forms.flights.view.tables.FlightTableFrame;
import com.desktop.tasks.ui.forms.shared.controller.AbstractFrameController;
import com.desktop.tasks.util.notification.Notifications;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;

import javax.annotation.PostConstruct;
import javax.swing.*;
import javax.validation.ConstraintViolationException;
import java.util.List;


@Controller
public class FlightController extends AbstractFrameController {
    @Value("${app.nonRowSelected}")
    private String NON_ROW_SELECTED;

    private final FlightTableFrame tableFrame;
    private final AddFlightFrame addFrame;
    private final FlightTableModel tableModel;
    private final ITaskService<Flight> flightService;

    public FlightController(FlightTableFrame tableFrame, AddFlightFrame addFrame, FlightTableModel tableModel, ITaskService<Flight> flightService) {
        this.tableFrame = tableFrame;
        this.addFrame = addFrame;
        this.tableModel = tableModel;
        this.flightService = flightService;
    }

    @PostConstruct
    private void prepareListeners() {
        FlightTableBtnPanel tableBtnPanel = tableFrame.getTableBtnPanel();
        FlightFormBtnPanel formBtnPanel = addFrame.getFormBtnPanel();

        registerAction(tableBtnPanel.getAddBtn(), (e) -> showAddModal());
        registerAction(tableBtnPanel.getRemoveBtn(), (e) -> removeEntity());
        registerAction(formBtnPanel.getSaveBtn(), (e) -> saveEntity());
        registerAction(formBtnPanel.getCancelBtn(), (e) -> closeModalWindow());
    }

    @Override
    public void prepareAndOpenFrame() {
        loadEntities();
        showTableFrame();
    }

    private void loadEntities() {
        List<Flight> entities = flightService.findAll();
        tableModel.clear();
        tableModel.addEntities(entities);
    }

    private void showTableFrame() {
        tableFrame.setVisible(true);
    }

    private void showAddModal() {
        addFrame.setVisible(true);
    }

    private void saveEntity() {
        FlightFormPanel formPanel = addFrame.getFormPanel();
        Flight entity = formPanel.getEntityFromForm();
        try{
            flightService.save(entity);
            tableModel.addEntity(entity);
            closeModalWindow();
        }catch (ConstraintViolationException e){
            Notifications.showFormValidationAlert("Incorrect input data");
        }

    }

    private void closeModalWindow() {
        addFrame.getFormPanel().clearForm();
        addFrame.dispose();
    }

    private void removeEntity() {
        try {
            JTable clientTable = tableFrame.getTablePanel().getTable();
            int selectedRow = clientTable.getSelectedRow();
            if (selectedRow < 0) {
                JOptionPane.showMessageDialog(null,
                        NON_ROW_SELECTED,
                        "Alert",
                        JOptionPane.ERROR_MESSAGE);
            } else {
                Flight entity = tableModel.getEntityByRow(selectedRow);
                flightService.remove(entity);
                tableModel.removeRow(selectedRow);
            }
        } catch (Exception e) {
            Notifications.showDeleteRowErrorMessage();
       }
    }

}
