package com.desktop.tasks.ui.forms.meetings.controller;


import com.desktop.tasks.dao.entity.tasks.BusinessMeet;
import com.desktop.tasks.service.api.ITaskService;
import com.desktop.tasks.ui.forms.meetings.model.BusinessMeetTableModel;
import com.desktop.tasks.ui.forms.meetings.view.forms.AddBusinessMeetFrame;
import com.desktop.tasks.ui.forms.meetings.view.forms.BusinessMeetFormBtnPanel;
import com.desktop.tasks.ui.forms.meetings.view.forms.BusinessMeetFormPanel;
import com.desktop.tasks.ui.forms.meetings.view.tables.BusinessMeetTableBtnPanel;
import com.desktop.tasks.ui.forms.meetings.view.tables.BusinessMeetTableFrame;
import com.desktop.tasks.ui.forms.shared.controller.AbstractFrameController;
import com.desktop.tasks.util.notification.Notifications;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;

import javax.annotation.PostConstruct;
import javax.swing.*;
import javax.validation.ConstraintViolationException;
import java.util.List;


@Controller
public class BusinessMeetController extends AbstractFrameController {
    @Value("${app.nonRowSelected}")
    private String NON_ROW_SELECTED;

    private final BusinessMeetTableFrame tableFrame;
    private final AddBusinessMeetFrame addFrame;
    private final BusinessMeetTableModel tableModel;
    private final ITaskService<BusinessMeet> businessMeetService;

    public BusinessMeetController(BusinessMeetTableFrame tableFrame, AddBusinessMeetFrame addFrame,
                                  BusinessMeetTableModel tableModel,
                                  ITaskService<BusinessMeet> businessMeetService) {
        this.tableFrame = tableFrame;
        this.addFrame = addFrame;
        this.tableModel = tableModel;
        this.businessMeetService = businessMeetService;
    }

    @PostConstruct
    private void prepareListeners() {
        BusinessMeetTableBtnPanel tableBtnPanel = tableFrame.getTableBtnPanel();
        BusinessMeetFormBtnPanel formBtnPanel = addFrame.getFormBtnPanel();

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
        List<BusinessMeet> entities = businessMeetService.findAll();
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
        BusinessMeetFormPanel formPanel = addFrame.getFormPanel();
        BusinessMeet entity = formPanel.getEntityFromForm();
        try{
            businessMeetService.save(entity);
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
                BusinessMeet entity = tableModel.getEntityByRow(selectedRow);
                businessMeetService.remove(entity);
                tableModel.removeRow(selectedRow);
            }
        } catch (Exception e) {
            Notifications.showDeleteRowErrorMessage();
       }
    }

}
