/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.pikachu.view;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.net.URL;
import javax.swing.ImageIcon;

/**
 * The HelpView class illustrates for help window of game
 *
 * @author Khanh
 */
public class HelpView extends javax.swing.JFrame implements IHelpView {

	private static final String PATH_BACKGROUND = "game/pikachu/icon/background.png";

	/**
	 * Creates new form HelpView
	 */
	public HelpView() {
		initComponents();
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed" desc="Generated
	// <editor-fold defaultstate="collapsed" desc="Generated
	// <editor-fold defaultstate="collapsed" desc="Generated
	// Code">//GEN-BEGIN:initComponents
	private void initComponents() {

		jPanel1 = new javax.swing.JPanel() {
			@Override
			public void paintComponent(Graphics g) {
				Graphics2D g2d = (Graphics2D) g;
				g2d.drawImage(getImage(PATH_BACKGROUND), 0, 0, this.getWidth(), this.getHeight(), null);
				g2d.setFont(new Font("Arial", Font.BOLD, 15));
				String helpString = "Connect pairs the same picture,";
				String helpStr = "so that no more than 3 straight lines crease segments.";
				g2d.drawString(helpString, 20, 20);
				g2d.drawString(helpStr, 20, 50);
			}
		};
		btnBack = new javax.swing.JButton();

		btnBack.setText("Back");

		javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
		jPanel1.setLayout(jPanel1Layout);
		jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
						.addContainerGap(268, Short.MAX_VALUE).addComponent(btnBack,
								javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(266, 266, 266)));
		jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
						.addContainerGap(296, Short.MAX_VALUE).addComponent(btnBack,
								javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addContainerGap()));

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(
				jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(
				jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));

		pack();
	}// </editor-fold>//GEN-END:initComponents

	// Variables declaration - do not modify//GEN-BEGIN:variables
	private javax.swing.JButton btnBack;
	private javax.swing.JPanel jPanel1;
	// End of variables declaration//GEN-END:variables

	/*
	 * (non-Javadoc)
	 * 
	 * @see game.pikachu.view.IHelpView#hideWindow(boolean)
	 */
	@Override
	public void hideWindow(boolean b) {
		setVisible(!b);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see game.pikachu.view.IHelpView#btnBackActionListener(java.awt.event.
	 * ActionListener)
	 */
	@Override
	public void btnBackActionListener(ActionListener listener) {
		btnBack.addActionListener(listener);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * game.pikachu.view.IHelpView#windowListener(java.awt.event.WindowAdapter)
	 */
	@Override
	public void windowListener(WindowAdapter listener) {
		this.addWindowListener(listener);
	}

	/**
	 * Get Image from path of image
	 *
	 * @param url
	 *            path of image
	 * @return an Image object
	 */
	private Image getImage(String url) {
		ImageIcon icon;
		URL imgURL = getClass().getClassLoader().getResource(url);
		if (imgURL != null) {
			icon = new ImageIcon(imgURL);
			return icon.getImage();
		} else {
			System.err.println("Couldn't find file: " + url);
		}
		return null;
	}

}