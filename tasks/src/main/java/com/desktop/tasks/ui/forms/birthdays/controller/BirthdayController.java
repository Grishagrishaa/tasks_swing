package com.desktop.tasks.ui.forms.birthdays.controller;


import com.desktop.tasks.dao.entity.tasks.Birthday;
import com.desktop.tasks.dao.entity.tasks.Flight;
import com.desktop.tasks.service.api.ITaskService;
import com.desktop.tasks.ui.forms.birthdays.model.BirthdayTableModel;
import com.desktop.tasks.ui.forms.birthdays.view.forms.AddBirthdayFrame;
import com.desktop.tasks.ui.forms.birthdays.view.forms.BirthdayFormBtnPanel;
import com.desktop.tasks.ui.forms.birthdays.view.forms.BirthdayFormPanel;
import com.desktop.tasks.ui.forms.birthdays.view.tables.BirthdayTableBtnPanel;
import com.desktop.tasks.ui.forms.birthdays.view.tables.BirthdayTableFrame;
import com.desktop.tasks.ui.forms.shared.controller.AbstractFrameController;
import com.desktop.tasks.util.notification.Notifications;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;

import javax.annotation.PostConstruct;
import javax.swing.*;
import javax.validation.ConstraintViolationException;
import java.util.List;


@Controller
public class BirthdayController extends AbstractFrameController {
    @Value("${app.nonRowSelected}")
    private String NON_ROW_SELECTED;

    private final BirthdayTableFrame tableFrame;
    private final AddBirthdayFrame addFrame;
    private final BirthdayTableModel tableModel;
    private final ITaskService<Birthday> birthdayService;

    public BirthdayController(BirthdayTableFrame tableFrame, AddBirthdayFrame addFrame,
                              BirthdayTableModel tableModel,
                              ITaskService<Birthday> birthdayService) {
        this.tableFrame = tableFrame;
        this.addFrame = addFrame;
        this.tableModel = tableModel;
        this.birthdayService = birthdayService;
    }

    @PostConstruct
    private void prepareListeners() {
        BirthdayTableBtnPanel tableBtnPanel = tableFrame.getTableBtnPanel();
        BirthdayFormBtnPanel formBtnPanel = addFrame.getFormBtnPanel();

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
        List<Birthday> entities = birthdayService.findAll();
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
        BirthdayFormPanel formPanel = addFrame.getFormPanel();
        Birthday entity = formPanel.getEntityFromForm();
        try{
            birthdayService.save(entity);
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
                Birthday entity = tableModel.getEntityByRow(selectedRow);
                birthdayService.remove(entity);
                tableModel.removeRow(selectedRow);
            }
        } catch (Exception e) {
            Notifications.showDeleteRowErrorMessage();
       }
    }

}
