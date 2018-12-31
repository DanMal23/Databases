
package db_tables;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

public class OperSysDB extends javax.swing.JFrame {

	Connection con;
	Statement stmt;
	PreparedStatement pstmt;

	public OperSysDB() {
		this.setTitle("MySQL tables");
		this.setLocation(200, 140);
		initComponents();
		createConnection();
	}

	void createConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb?autoReconnect=true&useSSL=false",
					"root", "root");

		} catch (SQLException | ClassNotFoundException ex) {
		}
	}

	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed" desc="Generated
	// Code">//GEN-BEGIN:initComponents
	private void initComponents() {

		osInput = new javax.swing.JTextField();
		yearInput = new javax.swing.JTextField();
		addToTableButton1 = new javax.swing.JButton();
		clearButton = new javax.swing.JButton();
		updateBtn1 = new javax.swing.JButton();
		jLabel1 = new javax.swing.JLabel();
		jLabel2 = new javax.swing.JLabel();
		jScrollPane1 = new javax.swing.JScrollPane();
		table1 = new javax.swing.JTable();
		jScrollPane2 = new javax.swing.JScrollPane();
		table2 = new javax.swing.JTable();
		addToTableButton2 = new javax.swing.JButton();
		updateBtn2 = new javax.swing.JButton();
		removeButton1 = new javax.swing.JButton();
		removeButton2 = new javax.swing.JButton();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

		addToTableButton1.setBackground(new java.awt.Color(238, 232, 170));
		addToTableButton1.setText("Add to table 1");
		addToTableButton1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				addToTableButton1ActionPerformed(evt);
			}
		});

		clearButton.setBackground(new java.awt.Color(255, 255, 255));
		clearButton.setText("Clear text fields");
		clearButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				clearButtonActionPerformed(evt);
			}
		});

		updateBtn1.setBackground(new java.awt.Color(238, 232, 170));
		updateBtn1.setText("Update 1");
		updateBtn1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				updateBtn1ActionPerformed(evt);
			}
		});

		jLabel1.setText("operating system");

		jLabel2.setText("year of release");

		table1.setModel(new javax.swing.table.DefaultTableModel(new Object[][] {

		}, new String[] { "operating system", "year" }));
		jScrollPane1.setViewportView(table1);

		table2.setModel(new javax.swing.table.DefaultTableModel(new Object[][] {

		}, new String[] { "linux distro", "year" }));
		jScrollPane2.setViewportView(table2);

		addToTableButton2.setBackground(new java.awt.Color(238, 232, 170));
		addToTableButton2.setText("Add to table 2");
		addToTableButton2.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				addToTableButton2ActionPerformed(evt);
			}
		});

		updateBtn2.setBackground(new java.awt.Color(238, 232, 170));
		updateBtn2.setText("Update 2");
		updateBtn2.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				updateBtn2ActionPerformed(evt);
			}
		});

		removeButton1.setText("Remove row");
		removeButton1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				removeButton1ActionPerformed(evt);
			}
		});

		removeButton2.setText("Remove row");
		removeButton2.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				removeButton2ActionPerformed(evt);
			}
		});

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout
				.createSequentialGroup().addGap(21, 21, 21)
				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
								.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
										.addGroup(layout.createSequentialGroup()
												.addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addGap(24, 24, 24))
										.addGroup(layout.createSequentialGroup()
												.addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
								.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
										.addComponent(osInput, javax.swing.GroupLayout.PREFERRED_SIZE, 146,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addComponent(yearInput, javax.swing.GroupLayout.PREFERRED_SIZE, 146,
												javax.swing.GroupLayout.PREFERRED_SIZE))
								.addGap(33, 33, 33).addComponent(clearButton).addGap(47, 47, 47))
						.addGroup(layout.createSequentialGroup().addGroup(layout
								.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 219,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGroup(layout.createSequentialGroup().addGap(3, 3, 3).addComponent(addToTableButton1)
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(updateBtn1)))
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
								.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
										.addGroup(layout.createSequentialGroup().addComponent(addToTableButton2)
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
												.addComponent(updateBtn2))
										.addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 219,
												javax.swing.GroupLayout.PREFERRED_SIZE))
								.addGap(0, 15, Short.MAX_VALUE))))
				.addGroup(layout.createSequentialGroup().addGap(79, 79, 79).addComponent(removeButton1)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
								javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(removeButton2).addGap(74, 74, 74)));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout
				.createSequentialGroup().addContainerGap()
				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout
						.createSequentialGroup()
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(osInput, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(jLabel1))
						.addGap(2, 2, 2)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(jLabel2).addComponent(yearInput, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
						.addComponent(clearButton, javax.swing.GroupLayout.Alignment.TRAILING,
								javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
				.addGap(18, 18, 18)
				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addComponent(updateBtn1, javax.swing.GroupLayout.Alignment.TRAILING,
								javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(updateBtn2, javax.swing.GroupLayout.PREFERRED_SIZE, 31,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(addToTableButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 31,
										javax.swing.GroupLayout.PREFERRED_SIZE))
						.addComponent(addToTableButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 31,
								javax.swing.GroupLayout.PREFERRED_SIZE))
				.addGap(18, 18, 18)
				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
						.addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 323, Short.MAX_VALUE)
						.addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
				.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
						.addComponent(removeButton1).addComponent(removeButton2))
				.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

		pack();
	}// </editor-fold>//GEN-END:initComponents

	private void addToTableButton1ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_addToTableButton1ActionPerformed
		try {
			String osname = osInput.getText();

			int year = Integer.parseInt(yearInput.getText());

			pstmt = con.prepareStatement("INSERT INTO OSDB VALUES(?, ?)");
			pstmt.setString(1, osname);
			pstmt.setInt(2, year);

			pstmt.execute();
			pstmt.close();
		} catch (SQLException ex) {
			Logger.getLogger(OperSysDB.class.getName()).log(Level.SEVERE, null, ex);
		}
	}// GEN-LAST:event_addToTableButton1ActionPerformed

	private void clearButtonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_clearButtonActionPerformed
		osInput.setText(null);
		yearInput.setText(null);
	}// GEN-LAST:event_clearButtonActionPerformed

	private void updateBtn1ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_updateBtn1ActionPerformed
		DefaultTableModel tm = (DefaultTableModel) table1.getModel();
		tm.setRowCount(0);
		try {
			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM OSDB");
			while (rs.next()) {
				String osname = rs.getString("osname");
				int year = rs.getInt("year");
				tm.addRow(new Object[] { osname, year });
			}
			stmt.close();
		} catch (SQLException e) {
		}

	}// GEN-LAST:event_updateBtn1ActionPerformed

	private void addToTableButton2ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_addToTableButton2ActionPerformed
		try {
			String linuxdistro = osInput.getText();
			int year = Integer.parseInt(yearInput.getText());
			pstmt = con.prepareStatement("INSERT INTO LDDB VALUES(?, ?)");
			pstmt.setString(1, linuxdistro);
			pstmt.setInt(2, year);

			pstmt.execute();
			pstmt.close();
		} catch (SQLException ex) {
			Logger.getLogger(OperSysDB.class.getName()).log(Level.SEVERE, null, ex);
		}
	}// GEN-LAST:event_addToTableButton2ActionPerformed

	private void updateBtn2ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_updateBtn2ActionPerformed
		DefaultTableModel tm = (DefaultTableModel) table2.getModel();
		tm.setRowCount(0);
		try {
			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM LDDB");
			while (rs.next()) {
				String linuxdistro = rs.getString("linuxdistro");
				int year = rs.getInt("year");
				tm.addRow(new Object[] { linuxdistro, year });
			}
			stmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}// GEN-LAST:event_updateBtn2ActionPerformed

	private void removeButton1ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_removeButton1ActionPerformed
		try {
			int row = table1.getSelectedRow();
			String osname = table1.getValueAt(row, 0).toString();
			String sqlcom = "DELETE FROM OSDB WHERE OSNAME = ?";
			pstmt = con.prepareStatement(sqlcom);
			pstmt.setString(1, osname);
			pstmt.executeUpdate();
			pstmt.close();

		} catch (SQLException ex) {
			Logger.getLogger(OperSysDB.class.getName()).log(Level.SEVERE, null, ex);
		}
		updateBtn1.doClick();
	}// GEN-LAST:event_removeButton1ActionPerformed

	private void removeButton2ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_removeButton2ActionPerformed
		try {
			int row = table2.getSelectedRow();
			String linuxdistro = table2.getValueAt(row, 0).toString();
			String sqlcom = "DELETE FROM LDDB WHERE LINUXDISTRO = ?";
			pstmt = con.prepareStatement(sqlcom);
			pstmt.setString(1, linuxdistro);
			pstmt.executeUpdate();
			pstmt.close();

		} catch (SQLException ex) {
			Logger.getLogger(OperSysDB.class.getName()).log(Level.SEVERE, null, ex);
		}
		updateBtn2.doClick();
	}// GEN-LAST:event_removeButton2ActionPerformed

	public static void main(String args[]) {

		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new OperSysDB().setVisible(true);
			}
		});
	}

	// Variables declaration - do not modify//GEN-BEGIN:variables
	private javax.swing.JButton addToTableButton1;
	private javax.swing.JButton addToTableButton2;
	private javax.swing.JButton clearButton;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JScrollPane jScrollPane2;
	private javax.swing.JTextField osInput;
	private javax.swing.JButton removeButton1;
	private javax.swing.JButton removeButton2;
	private javax.swing.JTable table1;
	private javax.swing.JTable table2;
	private javax.swing.JButton updateBtn1;
	private javax.swing.JButton updateBtn2;
	private javax.swing.JTextField yearInput;
	// End of variables declaration//GEN-END:variables
}
