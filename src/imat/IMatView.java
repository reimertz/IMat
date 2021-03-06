/*
 * IMatView.java
 */

package imat;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jdesktop.application.Action;
import org.jdesktop.application.SingleFrameApplication;
import org.jdesktop.application.FrameView;
import javax.swing.JDialog;
import javax.swing.JFrame;
import se.chalmers.ait.dat215.project.IMatDataHandler;

/**
 * The application's main frame.
 */
public class IMatView extends FrameView {

    private IMatDataHandler dataHandler;

    public IMatView(SingleFrameApplication app) {
        super(app);

        initComponents();

        dataHandler = IMatDataHandler.getInstance();
    }

    @Action
    public void showAboutBox() {
        if (aboutBox == null) {
            JFrame mainFrame = IMatApp.getApplication().getMainFrame();
            aboutBox = new IMatAboutBox(mainFrame);
            aboutBox.setLocationRelativeTo(mainFrame);
        }
        IMatApp.getApplication().show(aboutBox);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainPanel = new javax.swing.JPanel();
        menuBar = new javax.swing.JMenuBar();
        javax.swing.JMenu fileMenu = new javax.swing.JMenu();
        javax.swing.JMenuItem exitMenuItem = new javax.swing.JMenuItem();
        javax.swing.JMenu helpMenu = new javax.swing.JMenu();
        javax.swing.JMenuItem aboutMenuItem = new javax.swing.JMenuItem();
        productMenuItem = new javax.swing.JMenuItem();
        javaDocMenuItem = new javax.swing.JMenuItem();

        mainPanel.setName("mainPanel"); // NOI18N

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 279, Short.MAX_VALUE)
        );

        menuBar.setName("menuBar"); // NOI18N

        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(imat.IMatApp.class).getContext().getResourceMap(IMatView.class);
        fileMenu.setText(resourceMap.getString("fileMenu.text")); // NOI18N
        fileMenu.setName("fileMenu"); // NOI18N

        javax.swing.ActionMap actionMap = org.jdesktop.application.Application.getInstance(imat.IMatApp.class).getContext().getActionMap(IMatView.class, this);
        exitMenuItem.setAction(actionMap.get("quit")); // NOI18N
        exitMenuItem.setName("exitMenuItem"); // NOI18N
        fileMenu.add(exitMenuItem);

        menuBar.add(fileMenu);

        helpMenu.setText(resourceMap.getString("helpMenu.text")); // NOI18N
        helpMenu.setName("helpMenu"); // NOI18N

        aboutMenuItem.setAction(actionMap.get("showAboutBox")); // NOI18N
        aboutMenuItem.setName("aboutMenuItem"); // NOI18N
        helpMenu.add(aboutMenuItem);

        productMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_R, java.awt.event.InputEvent.CTRL_MASK));
        productMenuItem.setText(resourceMap.getString("productMenuItem.text")); // NOI18N
        productMenuItem.setName("productMenuItem"); // NOI18N
        productMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                productMenuItemActionPerformed(evt);
            }
        });
        helpMenu.add(productMenuItem);

        javaDocMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_J, java.awt.event.InputEvent.CTRL_MASK));
        javaDocMenuItem.setText(resourceMap.getString("javaDocMenuItem.text")); // NOI18N
        javaDocMenuItem.setName("javaDocMenuItem"); // NOI18N
        javaDocMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                javaDocMenuItemActionPerformed(evt);
            }
        });
        helpMenu.add(javaDocMenuItem);

        menuBar.add(helpMenu);

        setComponent(mainPanel);
        setMenuBar(menuBar);
    }// </editor-fold>//GEN-END:initComponents

    private void productMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_productMenuItemActionPerformed
        try {
            Process p = Runtime.getRuntime().exec("java -jar producteditor.jar");
        } catch (IOException ex) {
            Logger.getLogger(IMatView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_productMenuItemActionPerformed

    private void javaDocMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_javaDocMenuItemActionPerformed
        try {
            Desktop.getDesktop().browse(new URI("http://www.cse.chalmers.se/research/group/idc/ituniv/courses/11/dkgg/p/backend/javadoc/"));
        } catch (URISyntaxException ex) {
            Logger.getLogger(IMatView.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(IMatView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_javaDocMenuItemActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem javaDocMenuItem;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenuItem productMenuItem;
    // End of variables declaration//GEN-END:variables

    private JDialog aboutBox;
}
