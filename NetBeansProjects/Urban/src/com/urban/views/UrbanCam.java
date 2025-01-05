/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.urban.views;

import com.urban.controller.ValidationUtil;
import com.urban.controller.SelectionSort;
import com.urban.controller.InsertionSort;
import com.urban.controller.MergeSort;
import com.urban.model.Camera;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.LinkedList;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.Timer;

/**
 *
 * @author rushavSthapit LMU_ID: 23048581
 */
public class UrbanCam extends javax.swing.JFrame {

    private List<Camera> camList;
    private java.awt.CardLayout cardLayout;
    private final SelectionSort selectionSort;

    /**
     * Constructor to initialize the UrbanCam form. Sets up the layout,
     * initializes the data, and starts the progress bar simulation.
     */
    public UrbanCam() {
        initComponents();
        initializeLayout(); // Set up CardLayout and add screens
        initializeData(); // Initialize data structures like camera list
        startProgress(); // Show loading screen and initiate progress    
        dummyData(); // Populate data with dummy values (not implemented here)
        //sortBox(); // Commented out sorting method (might be used later)

        selectionSort = new SelectionSort(); // Initialize the SelectionSort object for sorting functionality
    }

    /**
     * Initializes the layout of the application using a CardLayout. Adds
     * different panels (loadingScreen, loginScreen, and mainScreen) to the
     * layout.
     */
    private void initializeLayout() {
        cardLayout = new java.awt.CardLayout();
        getContentPane().setLayout(cardLayout); // Set CardLayout as the layout manager

        // Add panels to the content pane with unique identifiers
        getContentPane().add(loadingScreen, "loadingScreen"); // Loading screen panel
        getContentPane().add(loginScreen, "loginScreen"); // Login screen panel
        getContentPane().add(mainScreen, "mainScreen"); // Main screen panel

        // Start with the loading screen
        cardLayout.show(getContentPane(), "loadingScreen");
    }

    /**
     * Initializes the data structures used by the application, such as the
     * camera list.
     */
    private void initializeData() {
        camList = new LinkedList(); // Initialize the camera list as a LinkedList
    }

    /**
     * Starts a progress bar simulation by using a SwingWorker. This simulates a
     * loading process by updating the progress bar periodically.
     */
    private void startProgress() {
        javax.swing.SwingWorker<Void, Integer> worker = new javax.swing.SwingWorker<>() {
            @Override
            protected Void doInBackground() throws Exception {
                // Simulate a progress by updating the progress bar every 20 milliseconds
                for (int i = 0; i <= 100; i++) {
                    Thread.sleep(20); // Simulate delay
                    publish(i); // Publish progress value to process method
                }
                return null;
            }

            @Override
            protected void process(java.util.List<Integer> chunks) {
                // Update the progress bar based on the published progress value
                int progress = chunks.get(chunks.size() - 1);
                loadBar.setValue(progress); // Set progress on the loading bar
            }

            @Override
            protected void done() {
                // When the progress is complete, switch to the login screen
                loadScreen("loginScreen");
            }
        };
        startChangingText(progLabel, new String[]{"Khichik!...", "Say Cheese!...", "Smile!..."}, 600); // Start changing text for loading label
        worker.execute(); // Execute the SwingWorker to simulate progress
    }

    /**
     * Loads a specified screen by switching the CardLayout.
     *
     * @param screenName the name of the screen to be shown (e.g.,
     * "loginScreen")
     */
    private void loadScreen(String screenName) {
        cardLayout.show(getContentPane(), screenName); // Show the specified screen
    }

    /**
     * Changes the text of a JLabel in a cyclic manner with a delay.
     *
     * @param label the JLabel whose text will be changed
     * @param texts the array of text strings to be cycled through
     * @param delayMs the delay between text changes in milliseconds
     */
    public static void startChangingText(JLabel label, String[] texts, int delayMs) {
        Timer timer = new Timer(delayMs, new ActionListener() {
            private int index = 0;

            @Override
            public void actionPerformed(ActionEvent e) {
                label.setText(texts[index]); // Update label text to the current text
                index = (index + 1) % texts.length; // Move to the next text in the array
            }
        });
        timer.start(); // Start the timer to begin text changes
    }

    /**
     * Clears the input fields and resets the error labels to their default
     * state. This can be used when clearing the form for new input.
     */
    public void setClear() {
        // Reset each field and error label to their default state
        errorOrNormalField(idField, "ID", idError, "", Color.black, rootPaneCheckingEnabled);
        errorOrNormalField(nameField, "Name", nameError, "", Color.black, rootPaneCheckingEnabled);
        errorOrNormalField(priceField, "Price", priceError, "", Color.black, rootPaneCheckingEnabled);
        errorOrNormalField(stockField, "Stock", stockError, "", Color.black, rootPaneCheckingEnabled);
        errorOrNormalField(storageField, "Storage", storageError, "", Color.black, rootPaneCheckingEnabled);
        errorOrNormalField(resolutionField, "Resolution", resolutionError, "", Color.black, rootPaneCheckingEnabled);
        errorOrNormalField(dateField, "Date", dateError, "", Color.black, rootPaneCheckingEnabled);
        errorOrNormalField(storageField, "Storage", storageError, "", Color.black, rootPaneCheckingEnabled);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainScreen = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        tabbedPane = new javax.swing.JTabbedPane();
        adminPnl = new javax.swing.JPanel();
        idField = new javax.swing.JTextField();
        nameField = new javax.swing.JTextField();
        priceField = new javax.swing.JTextField();
        stockField = new javax.swing.JTextField();
        resolutionField = new javax.swing.JTextField();
        storageField = new javax.swing.JTextField();
        flashBox = new javax.swing.JComboBox<>();
        idError = new javax.swing.JLabel();
        nameError = new javax.swing.JLabel();
        priceError = new javax.swing.JLabel();
        stockError = new javax.swing.JLabel();
        resolutionError = new javax.swing.JLabel();
        dateError = new javax.swing.JLabel();
        storageError = new javax.swing.JLabel();
        dateError2 = new javax.swing.JLabel();
        addBtn = new javax.swing.JButton();
        updateBtn = new javax.swing.JButton();
        deleteBtn = new javax.swing.JButton();
        dateField = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        viewTableBtn = new javax.swing.JButton();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        tablePnl = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        camTable = new javax.swing.JTable();
        sortComboBox = new javax.swing.JComboBox<>();
        insertionSortComboBox = new javax.swing.JComboBox<>();
        mergeSortComboBox = new javax.swing.JComboBox<>();
        jLabel20 = new javax.swing.JLabel();
        homePnl = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        loginScreen = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        usernameLbl = new javax.swing.JLabel();
        passLbl = new javax.swing.JLabel();
        userField = new javax.swing.JTextField();
        passField = new javax.swing.JPasswordField();
        loginBtn = new javax.swing.JButton();
        jLabel19 = new javax.swing.JLabel();
        loginError = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        loadingScreen = new javax.swing.JPanel();
        loadBar = new javax.swing.JProgressBar();
        progLabel = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();

        mainScreen.setForeground(new java.awt.Color(242, 242, 242));

        jPanel3.setMaximumSize(new java.awt.Dimension(1920, 1080));
        jPanel3.setMinimumSize(new java.awt.Dimension(1920, 1080));
        jPanel3.setPreferredSize(new java.awt.Dimension(1920, 1080));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 2173, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1193, Short.MAX_VALUE)
        );

        adminPnl.setBackground(new java.awt.Color(0, 0, 0));

        idField.setBackground(new java.awt.Color(241, 229, 217));
        idField.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "ID", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP));

        nameField.setBackground(new java.awt.Color(241, 229, 217));
        nameField.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Name", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP));

        priceField.setBackground(new java.awt.Color(241, 229, 217));
        priceField.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Price", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP));
        priceField.setCaretColor(new java.awt.Color(242, 242, 242));

        stockField.setBackground(new java.awt.Color(241, 229, 217));
        stockField.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Stock", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP));

        resolutionField.setBackground(new java.awt.Color(241, 229, 217));
        resolutionField.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Resolution", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP));

        storageField.setBackground(new java.awt.Color(241, 229, 217));
        storageField.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Storage", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP));

        flashBox.setBackground(new java.awt.Color(241, 229, 217));
        flashBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Yes", "No" }));
        flashBox.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Flash", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP));

        idError.setForeground(new java.awt.Color(255, 0, 51));

        nameError.setForeground(new java.awt.Color(204, 0, 0));

        priceError.setForeground(new java.awt.Color(204, 0, 0));

        stockError.setForeground(new java.awt.Color(204, 0, 0));

        resolutionError.setForeground(new java.awt.Color(204, 0, 0));

        storageError.setForeground(new java.awt.Color(255, 0, 0));

        addBtn.setBackground(new java.awt.Color(0, 0, 0));
        addBtn.setForeground(new java.awt.Color(242, 242, 242));
        addBtn.setText("Add");
        addBtn.setBorder(null);
        addBtn.setBorderPainted(false);
        addBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addBtnActionPerformed(evt);
            }
        });

        updateBtn.setBackground(new java.awt.Color(0, 0, 0));
        updateBtn.setForeground(new java.awt.Color(242, 242, 242));
        updateBtn.setText("Update");
        updateBtn.setBorderPainted(false);
        updateBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateBtnActionPerformed(evt);
            }
        });

        deleteBtn.setBackground(new java.awt.Color(0, 0, 0));
        deleteBtn.setForeground(new java.awt.Color(242, 242, 242));
        deleteBtn.setText("Delete");
        deleteBtn.setBorderPainted(false);
        deleteBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteBtnActionPerformed(evt);
            }
        });

        dateField.setBackground(new java.awt.Color(241, 229, 217));
        dateField.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Date", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP));

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/urban/resources/Screenshot 2024-12-19 at 3.51.01 PM.png"))); // NOI18N

        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/urban/resources/Screenshot 2024-12-19 at 3.52.01 PM.png"))); // NOI18N

        viewTableBtn.setBackground(new java.awt.Color(0, 0, 0));
        viewTableBtn.setForeground(new java.awt.Color(242, 242, 242));
        viewTableBtn.setText("View Table");
        viewTableBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewTableBtnActionPerformed(evt);
            }
        });

        jLabel21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/urban/resources/thousandWords copy.png"))); // NOI18N

        jLabel22.setBackground(new java.awt.Color(241, 229, 217));
        jLabel22.setFont(new java.awt.Font("Hiragino Maru Gothic ProN", 1, 36)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(242, 242, 242));
        jLabel22.setText("A Picture is Worth a Thousand Words");

        javax.swing.GroupLayout adminPnlLayout = new javax.swing.GroupLayout(adminPnl);
        adminPnl.setLayout(adminPnlLayout);
        adminPnlLayout.setHorizontalGroup(
            adminPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(adminPnlLayout.createSequentialGroup()
                .addGroup(adminPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addComponent(jLabel17)
                    .addGroup(adminPnlLayout.createSequentialGroup()
                        .addGap(414, 414, 414)
                        .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 686, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(adminPnlLayout.createSequentialGroup()
                        .addGroup(adminPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(adminPnlLayout.createSequentialGroup()
                                .addGroup(adminPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(adminPnlLayout.createSequentialGroup()
                                        .addGap(346, 346, 346)
                                        .addGroup(adminPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(idField, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(storageField, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(93, 93, 93)
                                        .addGroup(adminPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(resolutionField, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(nameField, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(adminPnlLayout.createSequentialGroup()
                                                .addGap(6, 6, 6)
                                                .addComponent(nameError, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addGroup(adminPnlLayout.createSequentialGroup()
                                        .addGap(332, 332, 332)
                                        .addGroup(adminPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(adminPnlLayout.createSequentialGroup()
                                                .addComponent(storageError, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(48, 48, 48)
                                                .addComponent(resolutionError, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(idError, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(65, 65, 65)
                                .addGroup(adminPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(priceField, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(adminPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(dateField, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(dateError, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(priceError, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(adminPnlLayout.createSequentialGroup()
                                .addGap(535, 535, 535)
                                .addComponent(jLabel21)))
                        .addGap(24, 24, 24)
                        .addGroup(adminPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(adminPnlLayout.createSequentialGroup()
                                .addGap(112, 112, 112)
                                .addComponent(viewTableBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(adminPnlLayout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addGroup(adminPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(flashBox, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(stockField, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(stockError, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, adminPnlLayout.createSequentialGroup()
                                .addComponent(dateError2, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(75, 75, 75))))
                    .addGroup(adminPnlLayout.createSequentialGroup()
                        .addGap(460, 460, 460)
                        .addComponent(addBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(140, 140, 140)
                        .addComponent(updateBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(143, 143, 143)
                        .addComponent(deleteBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(681, Short.MAX_VALUE))
        );
        adminPnlLayout.setVerticalGroup(
            adminPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(adminPnlLayout.createSequentialGroup()
                .addGroup(adminPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(adminPnlLayout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addGap(65, 65, 65)
                        .addComponent(jLabel22)
                        .addGap(232, 232, 232)
                        .addComponent(viewTableBtn)
                        .addGap(89, 89, 89))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, adminPnlLayout.createSequentialGroup()
                        .addComponent(jLabel21)
                        .addGap(62, 62, 62)))
                .addGroup(adminPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(adminPnlLayout.createSequentialGroup()
                        .addGroup(adminPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(priceField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(adminPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(nameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(idField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(stockField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(adminPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(adminPnlLayout.createSequentialGroup()
                                .addGap(7, 7, 7)
                                .addComponent(idError, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(adminPnlLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(adminPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(stockError, javax.swing.GroupLayout.DEFAULT_SIZE, 17, Short.MAX_VALUE)
                                    .addComponent(priceError, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                    .addComponent(nameError, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(adminPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(adminPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(storageField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(resolutionField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(adminPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(dateField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(flashBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(29, 29, 29)
                .addGroup(adminPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(resolutionError, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dateError, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dateError2, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(storageError, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(60, 60, 60)
                .addGroup(adminPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(updateBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(deleteBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(656, 656, 656)
                .addComponent(jLabel17)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tabbedPane.addTab("Admin Control", adminPnl);

        tablePnl.setBackground(new java.awt.Color(0, 0, 0));

        camTable.setBackground(new java.awt.Color(241, 229, 217));
        camTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Name", "Price", "Stock", "MegaPixel", "Date", "Storage", "Flash"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(camTable);
        if (camTable.getColumnModel().getColumnCount() > 0) {
            camTable.getColumnModel().getColumn(0).setResizable(false);
            camTable.getColumnModel().getColumn(1).setResizable(false);
            camTable.getColumnModel().getColumn(2).setResizable(false);
            camTable.getColumnModel().getColumn(3).setResizable(false);
        }

        sortComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sort ID By", "Ascending", "Descending" }));
        sortComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sortComboBoxActionPerformed(evt);
            }
        });

        insertionSortComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sort Name By", "Alphabetical", "Reverse Alphabetical" }));
        insertionSortComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                insertionSortComboBoxActionPerformed(evt);
            }
        });

        mergeSortComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sort Stock By", "Least In Stock", "Most In Stock" }));
        mergeSortComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mergeSortComboBoxActionPerformed(evt);
            }
        });

        jLabel20.setFont(new java.awt.Font("Helvetica Neue", 1, 36)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(242, 242, 242));
        jLabel20.setText("Sorting");

        javax.swing.GroupLayout tablePnlLayout = new javax.swing.GroupLayout(tablePnl);
        tablePnl.setLayout(tablePnlLayout);
        tablePnlLayout.setHorizontalGroup(
            tablePnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tablePnlLayout.createSequentialGroup()
                .addGroup(tablePnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(tablePnlLayout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addGroup(tablePnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(insertionSortComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(sortComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(mergeSortComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(tablePnlLayout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addComponent(jLabel20)))
                .addGap(45, 45, 45)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(824, Short.MAX_VALUE))
        );
        tablePnlLayout.setVerticalGroup(
            tablePnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tablePnlLayout.createSequentialGroup()
                .addGap(109, 109, 109)
                .addGroup(tablePnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(tablePnlLayout.createSequentialGroup()
                        .addComponent(jLabel20)
                        .addGap(49, 49, 49)
                        .addComponent(sortComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(39, 39, 39)
                        .addComponent(insertionSortComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)
                        .addComponent(mergeSortComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(806, Short.MAX_VALUE))
        );

        tabbedPane.addTab("Dashboard", tablePnl);

        homePnl.setBackground(new java.awt.Color(0, 0, 0));

        jPanel2.setBackground(new java.awt.Color(0, 0, 0));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setBackground(new java.awt.Color(0, 0, 0));
        jLabel3.setFont(new java.awt.Font("SignPainter", 0, 82)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(242, 242, 242));
        jLabel3.setText("Urban");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 10, -1, -1));

        jLabel5.setFont(new java.awt.Font("Helvetica Neue", 0, 48)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(242, 242, 242));
        jLabel5.setText("Say Cheese");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, -1, -1));

        jLabel8.setFont(new java.awt.Font("Helvetica Neue", 0, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(242, 242, 242));
        jLabel8.setText("For the best quality,");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, -1, -1));

        jLabel11.setFont(new java.awt.Font("Helvetica Neue", 0, 24)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(242, 242, 242));
        jLabel11.setText("at the best price.");
        jPanel2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, -1, -1));

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/urban/resources/camBg.jpg"))); // NOI18N
        jPanel2.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, 1650, 400));

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/urban/resources/canon-2.png"))); // NOI18N

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/urban/resources/Logo-Insta360-2.png"))); // NOI18N

        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/urban/resources/images-2.png"))); // NOI18N

        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/urban/resources/dji-logo-2.png"))); // NOI18N

        javax.swing.GroupLayout homePnlLayout = new javax.swing.GroupLayout(homePnl);
        homePnl.setLayout(homePnlLayout);
        homePnlLayout.setHorizontalGroup(
            homePnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(homePnlLayout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 1464, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 709, Short.MAX_VALUE))
            .addGroup(homePnlLayout.createSequentialGroup()
                .addGap(128, 128, 128)
                .addComponent(jLabel13)
                .addGap(189, 189, 189)
                .addComponent(jLabel14)
                .addGap(174, 174, 174)
                .addComponent(jLabel15)
                .addGap(200, 200, 200)
                .addComponent(jLabel16)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        homePnlLayout.setVerticalGroup(
            homePnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(homePnlLayout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 513, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(homePnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(homePnlLayout.createSequentialGroup()
                        .addGap(100, 100, 100)
                        .addGroup(homePnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(homePnlLayout.createSequentialGroup()
                                .addGap(32, 32, 32)
                                .addGroup(homePnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel16)
                                    .addComponent(jLabel15)))))
                    .addGroup(homePnlLayout.createSequentialGroup()
                        .addGap(118, 118, 118)
                        .addComponent(jLabel14)))
                .addContainerGap(480, Short.MAX_VALUE))
        );

        tabbedPane.addTab("Our Story", homePnl);

        javax.swing.GroupLayout mainScreenLayout = new javax.swing.GroupLayout(mainScreen);
        mainScreen.setLayout(mainScreenLayout);
        mainScreenLayout.setHorizontalGroup(
            mainScreenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tabbedPane)
            .addGroup(mainScreenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(mainScreenLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 2173, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        mainScreenLayout.setVerticalGroup(
            mainScreenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tabbedPane, javax.swing.GroupLayout.PREFERRED_SIZE, 1256, Short.MAX_VALUE)
            .addGroup(mainScreenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(mainScreenLayout.createSequentialGroup()
                    .addGap(0, 31, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 1193, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 32, Short.MAX_VALUE)))
        );

        loginScreen.setBackground(new java.awt.Color(251, 238, 213));
        loginScreen.setForeground(new java.awt.Color(242, 242, 242));
        loginScreen.setMaximumSize(new java.awt.Dimension(1920, 1080));
        loginScreen.setMinimumSize(new java.awt.Dimension(1920, 1080));
        loginScreen.setPreferredSize(new java.awt.Dimension(1920, 1080));

        jPanel5.setBackground(new java.awt.Color(251, 238, 213));

        jPanel1.setBackground(new java.awt.Color(251, 238, 213));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1724, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 900, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(452, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(121, 121, 121)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(140, Short.MAX_VALUE))
        );

        jLabel4.setBackground(new java.awt.Color(0, 0, 0));
        jLabel4.setForeground(new java.awt.Color(242, 242, 242));
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/urban/resources/Picture1.png"))); // NOI18N

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/urban/resources/reel_copy-removebg-preview.png"))); // NOI18N

        jPanel4.setBackground(new java.awt.Color(0, 0, 0));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        usernameLbl.setBackground(new java.awt.Color(0, 0, 0));
        usernameLbl.setForeground(new java.awt.Color(242, 242, 242));
        usernameLbl.setText("Username:");
        jPanel4.add(usernameLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 420, -1, -1));

        passLbl.setBackground(new java.awt.Color(0, 0, 0));
        passLbl.setForeground(new java.awt.Color(242, 242, 242));
        passLbl.setText("Password:");
        jPanel4.add(passLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 480, -1, -1));

        userField.setText("Rushav");
        jPanel4.add(userField, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 420, 220, -1));

        passField.setText("admin");
        jPanel4.add(passField, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 480, 220, -1));

        loginBtn.setText("Login");
        loginBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginBtnActionPerformed(evt);
            }
        });
        jPanel4.add(loginBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 540, -1, -1));

        jLabel19.setFont(new java.awt.Font("Chalkduster", 1, 60)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(242, 242, 242));
        jLabel19.setText("Log In");
        jPanel4.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 250, 260, 100));

        loginError.setBackground(new java.awt.Color(0, 0, 0));
        loginError.setForeground(new java.awt.Color(255, 0, 0));
        jPanel4.add(loginError, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 390, 270, 20));

        jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/urban/resources/bottom copy.png"))); // NOI18N
        jPanel4.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 680, 310, 70));

        javax.swing.GroupLayout loginScreenLayout = new javax.swing.GroupLayout(loginScreen);
        loginScreen.setLayout(loginScreenLayout);
        loginScreenLayout.setHorizontalGroup(
            loginScreenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(loginScreenLayout.createSequentialGroup()
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(58, 58, 58)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 652, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 605, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        loginScreenLayout.setVerticalGroup(
            loginScreenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(loginScreenLayout.createSequentialGroup()
                .addGroup(loginScreenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 1018, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 986, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(loginScreenLayout.createSequentialGroup()
                .addGap(110, 110, 110)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 635, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setSize(new java.awt.Dimension(1920, 1080));

        loadingScreen.setBackground(new java.awt.Color(0, 0, 0));
        loadingScreen.setForeground(new java.awt.Color(255, 255, 255));
        loadingScreen.setMaximumSize(new java.awt.Dimension(1920, 1080));
        loadingScreen.setMinimumSize(new java.awt.Dimension(1920, 1080));
        loadingScreen.setPreferredSize(new java.awt.Dimension(1920, 1080));

        progLabel.setBackground(new java.awt.Color(102, 102, 102));
        progLabel.setForeground(new java.awt.Color(242, 242, 242));
        progLabel.setText("Loading...");

        jLabel2.setBackground(new java.awt.Color(102, 102, 102));
        jLabel2.setFont(new java.awt.Font("Helvetica Neue", 0, 48)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(242, 242, 242));
        jLabel2.setText("Welcom To Urban");

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/urban/resources/camgif.gif"))); // NOI18N

        jLabel1.setBackground(new java.awt.Color(0, 0, 0));
        jLabel1.setForeground(new java.awt.Color(242, 242, 242));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/urban/resources/stargif.gif"))); // NOI18N

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/urban/resources/stargif.gif"))); // NOI18N

        javax.swing.GroupLayout loadingScreenLayout = new javax.swing.GroupLayout(loadingScreen);
        loadingScreen.setLayout(loadingScreenLayout);
        loadingScreenLayout.setHorizontalGroup(
            loadingScreenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(loadingScreenLayout.createSequentialGroup()
                .addGroup(loadingScreenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(loadingScreenLayout.createSequentialGroup()
                        .addGap(451, 451, 451)
                        .addGroup(loadingScreenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(progLabel)
                            .addComponent(loadBar, javax.swing.GroupLayout.PREFERRED_SIZE, 550, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(loadingScreenLayout.createSequentialGroup()
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(92, 92, 92)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 411, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(68, 68, 68)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 401, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(loadingScreenLayout.createSequentialGroup()
                        .addGap(529, 529, 529)
                        .addComponent(jLabel2)))
                .addContainerGap(691, Short.MAX_VALUE))
        );
        loadingScreenLayout.setVerticalGroup(
            loadingScreenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(loadingScreenLayout.createSequentialGroup()
                .addGroup(loadingScreenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(loadingScreenLayout.createSequentialGroup()
                        .addGap(119, 119, 119)
                        .addGroup(loadingScreenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 338, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 387, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(loadingScreenLayout.createSequentialGroup()
                        .addGap(131, 131, 131)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 342, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(78, 78, 78)
                .addComponent(jLabel2)
                .addGap(45, 45, 45)
                .addComponent(loadBar, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(progLabel)
                .addContainerGap(374, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(loadingScreen, javax.swing.GroupLayout.PREFERRED_SIZE, 2053, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 6, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(loadingScreen, javax.swing.GroupLayout.PREFERRED_SIZE, 1102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 6, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void loginBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginBtnActionPerformed
        // TODO add your handling code here:
        // Get the username and password input
        String username = userField.getText();
        String password = new String(passField.getPassword());

        // Check if username or password is empty
        if (username.isEmpty() || password.isEmpty()) {
            loginError.setText("Please enter your username and password.");
        } // Check if username and password are incorrect
        else if (!username.equals("Rushav") || !password.equals("admin")) {
            loginError.setText("Username and password mismatch.");
        } // If credentials are correct, proceed to load the main screen
        else {
            loginError.setText(""); // Clear any previous error messages
            loadScreen("mainScreen"); // Load the main screen
        }
    }//GEN-LAST:event_loginBtnActionPerformed

    /**
     * Loads the camera list into the table for display. Clears the current
     * table data and populates it with updated camera details.
     *
     * @param camList the list of Camera objects to be loaded into the table
     */
    private void loadListToTable(List<Camera> camList) {
        // Get the table model of the camTable
        DefaultTableModel model = (DefaultTableModel) camTable.getModel();

        model.setRowCount(0); // Clear any existing rows in the table

        // Loop through each camera in the list and add it to the table
        camList.forEach(camera -> model.addRow(new Object[]{
            camera.getId(), // Camera ID
            camera.getName(), // Camera Name
            camera.getPrice(), // Camera Price
            camera.getStock(), // Camera Stock
            camera.getResolution(),// Camera Resolution
            camera.getDate(), // Camera Release Date
            camera.getStorage(), // Camera Storage
            camera.getFlash() // Camera Flash Availability
        }));
    }

    /**
     * Populates the camera list with dummy data for testing purposes. This
     * method adds a few predefined Camera objects to the camera list.
     */
    private void dummyData() {
        // Adding dummy Camera data to camList
        camList.add(new Camera(130020, "Canon", 50000, 20, 10, "01-04-2024", 128, "Yes"));
        camList.add(new Camera(130001, "DJI", 70000, 15, 12, "08-06-2022", 64, "No"));
        camList.add(new Camera(130069, "SONY", 30000, 50, 50, "27-11-2024", 256, "Yes"));
        camList.add(new Camera(130031, "InstaX", 100000, 10, 20, "10-06-2024", 512, "No"));

        // Load the updated camera list to the table
        loadListToTable(camList);
    }

    /**
     * Clears all the input fields in the camera form. This resets the form to
     * its initial empty state.
     */
    private void clearCameraForm() {
        // Clear text from all input fields in the camera form
        idField.setText("");         // Clear ID field
        nameField.setText("");       // Clear Name field
        priceField.setText("");      // Clear Price field
        stockField.setText("");      // Clear Stock field
        resolutionField.setText(""); // Clear Resolution field
        dateField.setText("");       // Clear Date field
        storageField.setText("");    // Clear Storage field
    }

    /**
     * Sets error or normal state for a given text field. Changes the border
     * color based on error state and displays an error message if necessary.
     *
     * @param textField the JTextField to be updated
     * @param fieldName the name of the field to display in the title of the
     * border
     * @param errorLbl the JLabel to display error messages
     * @param errorMsg the error message to display
     * @param color the color of the border
     * @param isError boolean to indicate if the field is in error state
     */
    private void errorOrNormalField(JTextField textField, String fieldName, JLabel errorLbl, String errorMsg, Color color, boolean isError) {
        // Set a titled border with the specified color and field name
        textField.setBorder(
                javax.swing.BorderFactory.createTitledBorder(
                        javax.swing.BorderFactory.createLineBorder(color, 2), fieldName, javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,
                        javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12), color));

        // If there is an error, show the error message and set the error label visible
        if (isError) {
            errorLbl.setText(errorMsg); // Set the error message on the label
            errorLbl.setVisible(true);   // Make the error label visible
        } else {
            // Hide the error label if there's no error
            errorLbl.setVisible(false);
        }
    }

    /**
     * Handles the action when the 'Add' button is clicked. Validates inputs,
     * creates a Camera object, adds it to the list, and updates the table.
     */
    private void addBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addBtnActionPerformed
        // Get input values from the fields
        String idText = idField.getText().trim();
        String name = nameField.getText().trim();
        String price = priceField.getText().trim();
        String stock = stockField.getText().trim();
        String resolution = resolutionField.getText().trim();
        String date = dateField.getText().trim();
        String storage = storageField.getText().trim();
        String flash = flashBox.getSelectedItem().toString(); // Get the selected flash option

        setClear(); // Reset any existing error messages

        try {
            // Validate each input field
            if (!ValidationUtil.isIdInRange(idText)) {
                errorOrNormalField(idField, "Id", idError, "Id Not In range", Color.red, rootPaneCheckingEnabled);
                return;
            } else if (!ValidationUtil.isIdStartCorrect(idText)) {
                errorOrNormalField(idField, "Id", idError, "Id Must Start with 13", Color.red, rootPaneCheckingEnabled);
                return;
            } else if (!ValidationUtil.isnum(idText)) {
                errorOrNormalField(idField, "Id", idError, "Id Must be a number", Color.red, rootPaneCheckingEnabled);
                return;
            } else if (ValidationUtil.IsEmpty(idText)) {
                errorOrNormalField(idField, "Id", idError, "Please Enter ID", Color.red, rootPaneCheckingEnabled);
                return;
            }

            // Validate Name
            if (!ValidationUtil.isNameValid(name)) {
                errorOrNormalField(nameField, "Name", nameError, "Enter Valid Name", Color.red, rootPaneCheckingEnabled);
                return;
            } else if (ValidationUtil.IsEmpty(name)) {
                errorOrNormalField(nameField, "Name", nameError, "Please Enter Name", Color.red, rootPaneCheckingEnabled);
                return;
            }

            // Validate Price
            if (!ValidationUtil.isPriceValid(price)) {
                errorOrNormalField(priceField, "Price", priceError, "Enter Valid Price", Color.red, rootPaneCheckingEnabled);
                return;
            } else if (!ValidationUtil.isnum(price)) {
                errorOrNormalField(priceField, "Price", priceError, "Price Must be a number", Color.red, rootPaneCheckingEnabled);
                return;
            } else if (ValidationUtil.IsEmpty(price)) {
                errorOrNormalField(priceField, "Price", priceError, "Please enter a price", Color.red, rootPaneCheckingEnabled);
                return;
            }

            // Validate Stock
            if (!ValidationUtil.isnum(stock)) {
                errorOrNormalField(stockField, "Stock", stockError, "Stock Must be a number", Color.red, rootPaneCheckingEnabled);
                return;
            }

            // Validate Resolution
            if (!ValidationUtil.isnum(resolution)) {
                errorOrNormalField(resolutionField, "Resolution", resolutionError, "Megapixels Must be a number", Color.red, rootPaneCheckingEnabled);
                return;
            } else if (!ValidationUtil.isResolutionInRange(resolution)) {
                errorOrNormalField(resolutionField, "Resolution", resolutionError, "Megapixels out of range", Color.red, rootPaneCheckingEnabled);
                return;
            }

            // Validate Storage
            if (!ValidationUtil.isnum(storage)) {
                errorOrNormalField(storageField, "Storage", storageError, "Storage Must be a number", Color.red, rootPaneCheckingEnabled);
                return;
            }

            // Create a new Camera object
            Camera cam = new Camera(Integer.parseInt(idText), name, Integer.parseInt(price), Integer.parseInt(stock), Integer.parseInt(resolution), date, Integer.parseInt(storage), flash);
            System.out.println("Camera Added: " + cam.getName() + "\n"
                    + "Id: " + cam.getId() + "\n"
                    + "Price: " + cam.getPrice() + "\n"
                    + "In Stock: " + cam.getStock() + "\n"
                    + "Resolution: " + cam.getResolution());

            // Add the camera to the list and update the table
            camList.add(cam);
            loadListToTable(camList);

            setClear(); // Clear any previous error messages
            clearCameraForm(); // Reset the form fields
        } catch (NumberFormatException e) {
            System.out.println("Invalid number format: " + e.getMessage());
        }
    }//GEN-LAST:event_addBtnActionPerformed

    /**
     * Handles the action when the 'Update' button is clicked. Validates inputs,
     * finds the Camera by ID, updates its properties, and refreshes the table.
     */
    private void updateBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateBtnActionPerformed
        String idText = idField.getText().trim();
        String name = nameField.getText().trim();
        String price = priceField.getText().trim();
        String stock = stockField.getText().trim();
        String resolution = resolutionField.getText().trim();
        String date = dateField.getText().trim();
        String storage = storageField.getText().trim();

        setClear();

        try {
            // Validate inputs for updates (same as add validation)
            if (!ValidationUtil.isIdInRange(idText)) {
                errorOrNormalField(idField, "Id", idError, "Id Not In range", Color.red, rootPaneCheckingEnabled);
                return;
            } else if (!ValidationUtil.isIdStartCorrect(idText)) {
                errorOrNormalField(idField, "Id", idError, "Id Must Start with 13", Color.red, rootPaneCheckingEnabled);
                return;
            }

            // Validate other fields similarly
            if (!ValidationUtil.isNameValid(name)) {
                errorOrNormalField(nameField, "Name", nameError, "Enter Valid Name", Color.red, rootPaneCheckingEnabled);
                return;
            }

            if (!ValidationUtil.isPriceValid(price)) {
                errorOrNormalField(priceField, "Price", priceError, "Enter Valid Price", Color.red, rootPaneCheckingEnabled);
                return;
            }

            if (!ValidationUtil.isnum(storage)) {
                errorOrNormalField(storageField, "Storage", storageError, "Storage Must be a number", Color.red, rootPaneCheckingEnabled);
                return;
            }

            // Find the existing camera by ID
            Camera exists = null;
            for (Camera urb : camList) {
                if (urb.getId() == Integer.parseInt(idText)) {
                    exists = urb;
                    break;
                }
            }

            if (exists == null) {
                JOptionPane.showMessageDialog(null, "No Item In List", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Update the properties of the found camera
            exists.setId(Integer.parseInt(idText));
            exists.setName(name);
            exists.setPrice(Integer.parseInt(price));
            exists.setStock(Integer.parseInt(stock));
            exists.setResolution(Integer.parseInt(resolution));
            exists.setDate(date);

            // Refresh the table
            loadListToTable(camList);
            JOptionPane.showMessageDialog(null, "Updated", "Update Complete", JOptionPane.INFORMATION_MESSAGE);

            setClear();
            clearCameraForm();
        } catch (NumberFormatException e) {
            System.out.println("Invalid format: " + e.getMessage());
        }

    }//GEN-LAST:event_updateBtnActionPerformed

    /**
     * Handles the action when the 'Delete' button is clicked. Validates the ID,
     * finds the Camera in the list, removes it, and updates the table.
     */
    private void deleteBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteBtnActionPerformed
        String idText = idField.getText().trim();

        // Check if the ID field is empty
        if (idText.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please Enter An ID", "No ID", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Find the camera to delete by ID
        Camera exists = null;
        for (Camera urb : camList) {
            if (urb.getId() == Integer.parseInt(idText)) {
                exists = urb;
                break;
            }
        }

        // If camera is not found, show error
        if (exists == null) {
            JOptionPane.showMessageDialog(null, "Please Enter A Valid ID", "Invalid ID", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Remove the camera from the list
        camList.remove(exists);
        JOptionPane.showMessageDialog(null, "Item Removed", "Deletion Complete", JOptionPane.INFORMATION_MESSAGE);

        // Update the table
        loadListToTable(camList);

        // Clear the form
        clearCameraForm();
    }//GEN-LAST:event_deleteBtnActionPerformed

    /**
     * Handles the action when the 'View Table' button is clicked. Switches to
     * the second tab that displays the camera table.
     */
    private void viewTableBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewTableBtnActionPerformed
        // TODO add your handling code here:
        tabbedPane.setSelectedIndex(1); //Switch to second tab.
    }//GEN-LAST:event_viewTableBtnActionPerformed

    /**
     * Handles the sorting action when the 'Sort' combo box is changed. Sorts
     * the list based on ID in ascending or descending order.
     */
    private void sortComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sortComboBoxActionPerformed
        int value = sortComboBox.getSelectedIndex();

        if (value == 1) {
            List<Camera> sortedList = selectionSort.sortById(camList, false); // Sort in descending order
            loadListToTable(sortedList);
        } else if (value == 2) {
            List<Camera> sortedList = selectionSort.sortById(camList, true); // Sort in ascending order
            loadListToTable(sortedList);
        }
    }//GEN-LAST:event_sortComboBoxActionPerformed

    /**
     * Handles the action when the 'Insertion Sort' combo box is changed. Sorts
     * the camera list alphabetically or in reverse alphabetical order.
     */
    private void insertionSortComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_insertionSortComboBoxActionPerformed
        // TODO add your handling code here:
        int order = insertionSortComboBox.getSelectedIndex();

        // Creating an instance of InsertionSort class
        InsertionSort insertionSort = new InsertionSort();

        // Sorted list to hold the result
        List<Camera> sortedList;

        // Check the sorting order and sort accordingly
        if (order == 1) { // Alphabetically
            sortedList = insertionSort.sortAlphabetically(camList);
            loadListToTable(sortedList);
        } else if (order == 2) { // Reverse Alphabetically
            sortedList = insertionSort.sortReverseAlphabetically(camList);
            loadListToTable(sortedList);
        }
    }//GEN-LAST:event_insertionSortComboBoxActionPerformed

    /**
     * Handles the action when the 'Merge Sort' combo box is changed. Sorts the
     * camera list based on stock in ascending or descending order.
     */
    private void mergeSortComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mergeSortComboBoxActionPerformed
        // TODO add your handling code here:
        int order = mergeSortComboBox.getSelectedIndex();

        // Creating an instance of InsertionSort class
        MergeSort mergeSort = new MergeSort();

        // Sorted list to hold the result
        List<Camera> sortedList;

        // Check the sorting order and sort accordingly
        if (order == 1) { // Most in stock
            sortedList = mergeSort.sortByStockAscending(camList);
            loadListToTable(sortedList);
        } else if (order == 2) { // Least amount in stock
            sortedList = mergeSort.sortByStockDescending(camList);
            loadListToTable(sortedList);
        }
    }//GEN-LAST:event_mergeSortComboBoxActionPerformed

    /**
     * Main method to run the UrbanCam application.
     *
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(UrbanCam.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UrbanCam.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UrbanCam.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UrbanCam.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new UrbanCam().setVisible(true);
            }
        });

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addBtn;
    private javax.swing.JPanel adminPnl;
    private javax.swing.JTable camTable;
    private javax.swing.JLabel dateError;
    private javax.swing.JLabel dateError2;
    private javax.swing.JTextField dateField;
    private javax.swing.JButton deleteBtn;
    private javax.swing.JComboBox<String> flashBox;
    private javax.swing.JPanel homePnl;
    private javax.swing.JLabel idError;
    private javax.swing.JTextField idField;
    private javax.swing.JComboBox<String> insertionSortComboBox;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JProgressBar loadBar;
    private javax.swing.JPanel loadingScreen;
    private javax.swing.JButton loginBtn;
    private javax.swing.JLabel loginError;
    private javax.swing.JPanel loginScreen;
    private javax.swing.JPanel mainScreen;
    private javax.swing.JComboBox<String> mergeSortComboBox;
    private javax.swing.JLabel nameError;
    private javax.swing.JTextField nameField;
    private javax.swing.JPasswordField passField;
    private javax.swing.JLabel passLbl;
    private javax.swing.JLabel priceError;
    private javax.swing.JTextField priceField;
    private javax.swing.JLabel progLabel;
    private javax.swing.JLabel resolutionError;
    private javax.swing.JTextField resolutionField;
    private javax.swing.JComboBox<String> sortComboBox;
    private javax.swing.JLabel stockError;
    private javax.swing.JTextField stockField;
    private javax.swing.JLabel storageError;
    private javax.swing.JTextField storageField;
    private javax.swing.JTabbedPane tabbedPane;
    private javax.swing.JPanel tablePnl;
    private javax.swing.JButton updateBtn;
    private javax.swing.JTextField userField;
    private javax.swing.JLabel usernameLbl;
    private javax.swing.JButton viewTableBtn;
    // End of variables declaration//GEN-END:variables
}
