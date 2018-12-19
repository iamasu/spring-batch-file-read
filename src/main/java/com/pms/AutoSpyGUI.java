package com.sanuthiracommodities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutoSpyGUI extends javax.swing.JFrame {

    private WebDriver driver;

    public AutoSpyGUI() {
        System.setProperty("webdriver.chrome.driver", "H:\\springboot-web-app-static-master\\sanuthiracommodities\\src\\main\\resources\\static\\chromedriver.exe");
        initComponents();
        xpathPanel.setVisible(false);
        noticeBoardPanel.setVisible(false);
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        xpathPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        yesButton = new javax.swing.JButton();
        noButton = new javax.swing.JButton();
        urlPanel = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        urlInputField = new javax.swing.JTextField();
        cancelButton = new javax.swing.JButton();
        submitButton = new javax.swing.JButton();
        noticeBoardPanel = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        noticeBoard = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("AutoSpy");
        setAlwaysOnTop(true);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel1.setText("Do you want store Xpath?");

        yesButton.setText("Yes");
        yesButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                yesButtonActionPerformed(evt);
            }
        });

        noButton.setText("Cancel");
        noButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                noButtonActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout xpathPanelLayout = new org.jdesktop.layout.GroupLayout(xpathPanel);
        xpathPanel.setLayout(xpathPanelLayout);
        xpathPanelLayout.setHorizontalGroup(
            xpathPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(xpathPanelLayout.createSequentialGroup()
                .add(42, 42, 42)
                .add(jLabel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 170, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(27, 27, 27)
                .add(yesButton)
                .add(29, 29, 29)
                .add(noButton)
                .addContainerGap(118, Short.MAX_VALUE))
        );
        xpathPanelLayout.setVerticalGroup(
            xpathPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(xpathPanelLayout.createSequentialGroup()
                .add(34, 34, 34)
                .add(xpathPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel1)
                    .add(yesButton)
                    .add(noButton))
                .addContainerGap(30, Short.MAX_VALUE))
        );

        jLabel7.setText("Please Enter URL");

        org.jdesktop.layout.GroupLayout urlPanelLayout = new org.jdesktop.layout.GroupLayout(urlPanel);
        urlPanel.setLayout(urlPanelLayout);
        urlPanelLayout.setHorizontalGroup(
            urlPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(urlPanelLayout.createSequentialGroup()
                .add(126, 126, 126)
                .add(jLabel7)
                .add(38, 38, 38)
                .add(urlInputField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 203, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        urlPanelLayout.setVerticalGroup(
            urlPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(urlPanelLayout.createSequentialGroup()
                .add(32, 32, 32)
                .add(urlPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel7)
                    .add(urlInputField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        org.jdesktop.layout.GroupLayout jPanel2Layout = new org.jdesktop.layout.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel2Layout.createSequentialGroup()
                .add(urlPanel, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .add(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .add(xpathPanel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel2Layout.createSequentialGroup()
                .add(urlPanel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(xpathPanel, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        cancelButton.setText("Cancel");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        submitButton.setText("OK");
        submitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitButtonActionPerformed(evt);
            }
        });

        noticeBoard.setColumns(20);
        noticeBoard.setRows(5);
        noticeBoard.setBorder(null);
        jScrollPane2.setViewportView(noticeBoard);

        org.jdesktop.layout.GroupLayout noticeBoardPanelLayout = new org.jdesktop.layout.GroupLayout(noticeBoardPanel);
        noticeBoardPanel.setLayout(noticeBoardPanelLayout);
        noticeBoardPanelLayout.setHorizontalGroup(
            noticeBoardPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jScrollPane2)
        );
        noticeBoardPanelLayout.setVerticalGroup(
            noticeBoardPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(noticeBoardPanelLayout.createSequentialGroup()
                .add(jScrollPane2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(0, 11, Short.MAX_VALUE))
        );

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .add(submitButton)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(cancelButton)
                .add(155, 155, 155))
            .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel2, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(noticeBoardPanel, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        layout.linkSize(new java.awt.Component[] {cancelButton, submitButton}, org.jdesktop.layout.GroupLayout.HORIZONTAL);

        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .add(noticeBoardPanel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(submitButton)
                    .add(cancelButton))
                .addContainerGap())
        );

        jPanel2.getAccessibleContext().setAccessibleName(" ");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void submitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitButtonActionPerformed
        // TODO add your handling code here:
        final String url = urlInputField.getText();
        cancelButton.setVisible(false);
        submitButton.setVisible(false);
        urlInputField.setEditable(false);
        urlPanel.setVisible(false);
        try {
            driver = new ChromeDriver();
            OpenBrowser.main(driver, xpathPanel, url);
        } catch (Exception e) {
            e.printStackTrace();
            cancelButton.setVisible(true);
            submitButton.setVisible(true);
            urlInputField.setEditable(true);
            noticeBoard.setText(e.getMessage());
        }
    }//GEN-LAST:event_submitButtonActionPerformed

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_cancelButtonActionPerformed

    private void yesButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_yesButtonActionPerformed
        // TODO add your handling code here:
        String pgaeSource = driver.getPageSource();
        noticeBoardPanel.setVisible(true);
        XpathCapture.xpath(noticeBoard, pgaeSource);
    }//GEN-LAST:event_yesButtonActionPerformed

    private void noButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_noButtonActionPerformed
        // TODO add your handling code here:
        driver.close();
        dispose();
    }//GEN-LAST:event_noButtonActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                AutoSpyGUI spyGUI = new AutoSpyGUI();
                spyGUI.setVisible(true);
                spyGUI.setLocationRelativeTo(null);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton noButton;
    private javax.swing.JTextArea noticeBoard;
    private javax.swing.JPanel noticeBoardPanel;
    private javax.swing.JButton submitButton;
    private javax.swing.JTextField urlInputField;
    private javax.swing.JPanel urlPanel;
    private javax.swing.JPanel xpathPanel;
    private javax.swing.JButton yesButton;
    // End of variables declaration//GEN-END:variables

}
