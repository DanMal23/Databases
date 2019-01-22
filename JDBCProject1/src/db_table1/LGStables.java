package db_table1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

public class LGStables extends javax.swing.JFrame {

	private static final long serialVersionUID = -7709890963057595458L;

	Connection connection;
	Statement statement;
	PreparedStatement preparedStmt;

	public LGStables() {
		this.setTitle("SQL table");
		this.setLocation(200, 140);
		initComponents();
		createConnection();
	}

	void createConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb?autoReconnect=true&useSSL=false",
					"root", "root");

		} catch (SQLException | ClassNotFoundException ex) {
		}
	}

	// <editor-fold defaultstate="collapsed" desc="Generated
	// Code">//GEN-BEGIN:initComponents
	private void initComponents() {

		nameInput = new javax.swing.JTextField();
		insertDataButton = new javax.swing.JButton();
		progrlangInput = new javax.swing.JTextField();
		jLabel1 = new javax.swing.JLabel();
		jLabel2 = new javax.swing.JLabel();
		yearInput = new javax.swing.JTextField();
		jLabel3 = new javax.swing.JLabel();
		clearButton = new javax.swing.JButton();
		jScrollPane1 = new javax.swing.JScrollPane();
		table = new javax.swing.JTable();
		refreshButton = new javax.swing.JButton();
		editDev = new javax.swing.JTextField();
		editLang = new javax.swing.JTextField();
		editYear = new javax.swing.JTextField();
		editButton = new javax.swing.JButton();
		updateButton = new javax.swing.JButton();
		deleteButton = new javax.swing.JButton();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setBackground(new java.awt.Color(231, 243, 235));

		insertDataButton.setBackground(new java.awt.Color(176, 224, 230));
		insertDataButton.setText("Insert data");
		insertDataButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				insertDataButtonActionPerformed(evt);
			}
		});

		jLabel1.setText("developer/researcher");

		jLabel2.setText("programming language");

		jLabel3.setText("year of release");

		clearButton.setBackground(new java.awt.Color(255, 255, 255));
		clearButton.setText("Clear text fields");
		clearButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				clearButtonActionPerformed(evt);
			}
		});

		table.setModel(new javax.swing.table.DefaultTableModel(new Object[][] {

		}, new String[] { "name", "language", "year" }));
		jScrollPane1.setViewportView(table);

		refreshButton.setBackground(new java.awt.Color(176, 224, 230));
		refreshButton.setText("Refresh table");
		refreshButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				refreshButtonActionPerformed(evt);
			}
		});

		editButton.setBackground(new java.awt.Color(224, 255, 255));
		editButton.setText("Edit table row");
		editButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				editButtonActionPerformed(evt);
			}
		});

		updateButton.setBackground(new java.awt.Color(224, 255, 255));
		updateButton.setText("Update year");
		updateButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				updateButtonActionPerformed(evt);
			}
		});

		deleteButton.setBackground(new java.awt.Color(255, 228, 181));
		deleteButton.setText("Delete row");
		deleteButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				deleteButtonActionPerformed(evt);
			}
		});

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout
				.createSequentialGroup().addContainerGap()
				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING).addGroup(layout
						.createSequentialGroup().addGap(0, 0, Short.MAX_VALUE)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(
								javax.swing.GroupLayout.Alignment.TRAILING,
								layout.createSequentialGroup().addGroup(layout
										.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
										.addGroup(layout.createSequentialGroup().addGroup(layout
												.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
												.addGroup(layout.createSequentialGroup()
														.addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE,
																136, javax.swing.GroupLayout.PREFERRED_SIZE)
														.addPreferredGap(
																javax.swing.LayoutStyle.ComponentPlacement.RELATED))
												.addGroup(layout.createSequentialGroup()
														.addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
														.addGap(46, 46, 46)))
												.addGroup(layout
														.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING,
																false)
														.addComponent(progrlangInput,
																javax.swing.GroupLayout.DEFAULT_SIZE, 117,
																Short.MAX_VALUE)
														.addComponent(yearInput)))
										.addGroup(layout.createSequentialGroup().addComponent(insertDataButton)
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
												.addComponent(refreshButton))
										.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout
												.createSequentialGroup()
												.addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 126,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
												.addComponent(nameInput, javax.swing.GroupLayout.PREFERRED_SIZE, 120,
														javax.swing.GroupLayout.PREFERRED_SIZE)))
										.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
												.addGroup(layout.createSequentialGroup().addGap(26, 26, 26)
														.addGroup(layout
																.createParallelGroup(
																		javax.swing.GroupLayout.Alignment.LEADING,
																		false)
																.addComponent(editButton,
																		javax.swing.GroupLayout.DEFAULT_SIZE,
																		javax.swing.GroupLayout.DEFAULT_SIZE,
																		Short.MAX_VALUE)
																.addComponent(deleteButton,
																		javax.swing.GroupLayout.DEFAULT_SIZE,
																		javax.swing.GroupLayout.DEFAULT_SIZE,
																		Short.MAX_VALUE)))
												.addGroup(layout.createSequentialGroup().addGap(18, 18, 18)
														.addComponent(clearButton))))
								.addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING,
										javax.swing.GroupLayout.PREFERRED_SIZE, 399,
										javax.swing.GroupLayout.PREFERRED_SIZE)))
						.addGroup(layout.createSequentialGroup()
								.addComponent(editDev, javax.swing.GroupLayout.PREFERRED_SIZE, 89,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(editLang, javax.swing.GroupLayout.PREFERRED_SIZE, 88,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(editYear, javax.swing.GroupLayout.PREFERRED_SIZE, 51,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGap(37, 37, 37).addComponent(updateButton).addGap(0, 0, Short.MAX_VALUE)))
				.addGap(22, 22, 22)));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addContainerGap()
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
								.addGroup(layout.createSequentialGroup()
										.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
												.addComponent(nameInput, javax.swing.GroupLayout.PREFERRED_SIZE, 22,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addComponent(jLabel1))
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
												.addComponent(jLabel2).addComponent(progrlangInput,
														javax.swing.GroupLayout.PREFERRED_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
												.addComponent(yearInput, javax.swing.GroupLayout.PREFERRED_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addComponent(jLabel3)))
								.addGroup(layout.createSequentialGroup().addComponent(clearButton)
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
												javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(deleteButton)))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(insertDataButton).addComponent(refreshButton).addComponent(editButton))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 301,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(18, 18, 18)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(editDev, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(editLang, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(editYear, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(updateButton))
						.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

		pack();
	}// </editor-fold>//GEN-END:initComponents

	private void insertDataButtonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_insertDataButtonActionPerformed

		try {
			String name = nameInput.getText();
			String progrlang = progrlangInput.getText();
			int year = Integer.parseInt(yearInput.getText());
			// Statement stmt = con.createStatement();
			preparedStmt = connection.prepareStatement("INSERT INTO LGS VALUES(?, ?, ?)");
			preparedStmt.setString(1, name);
			preparedStmt.setString(2, progrlang);
			preparedStmt.setInt(3, year);

			// String dbop = "INSERT INTO DEVELOPERS VALUES('"+name+"')"; //database
			// operation:
			// pstmt.execute(dbop);
			preparedStmt.execute();
			System.out.println("Insertion successfully completed.");
			preparedStmt.close();
		} catch (SQLException ex) {
			Logger.getLogger(LGStables.class.getName()).log(Level.SEVERE, null, ex);
		}

	}// GEN-LAST:event_insertDataButtonActionPerformed

	private void clearButtonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_clearButtonActionPerformed
		nameInput.setText("");
		progrlangInput.setText(null);
		yearInput.setText(null);
	}// GEN-LAST:event_clearButtonActionPerformed

	private void refreshButtonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_refreshButtonActionPerformed
		DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
		tableModel.setRowCount(0); // clears the table

		try {
			statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("SELECT * FROM LGS"); // accessing data
			while (rs.next()) {
				String name = rs.getString("name");
				String progrlang = rs.getString("progrlang");
				int year = rs.getInt("year");
				// System.out.println(progrlang+", developed by "+name+"in: "+year);

				tableModel.addRow(new Object[] { name, progrlang, year });
			}
			statement.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}// GEN-LAST:event_refreshButtonActionPerformed

	private void editButtonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_editButtonActionPerformed
		DefaultTableModel dtm = (DefaultTableModel) table.getModel();
		int row = table.getSelectedRow();
		String name = (String) dtm.getValueAt(row, 0);
		String progrlang = (String) dtm.getValueAt(row, 1);
		String year = (dtm.getValueAt(row, 2).toString());
		editDev.setText(name);
		editLang.setText(progrlang);
		editYear.setText(year);
	}// GEN-LAST:event_editButtonActionPerformed

	private void updateButtonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_updateButtonActionPerformed
		try {
			preparedStmt = connection.prepareStatement("UPDATE LGS SET YEAR = ? WHERE NAME = ? ");
			preparedStmt.setInt(1, Integer.parseInt(editYear.getText()));
			preparedStmt.setString(2, editDev.getText());
			preparedStmt.executeUpdate();
			preparedStmt.close();
			refreshButton.doClick();

		} catch (SQLException ex) {
			Logger.getLogger(LGStables.class.getName()).log(Level.SEVERE, null, ex);
		}
	}// GEN-LAST:event_updateButtonActionPerformed

	private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_deleteButtonActionPerformed
		try {
			int row = table.getSelectedRow();
			String name = table.getValueAt(row, 0).toString(); // row, column
			String sqlcommand = "DELETE FROM LGS WHERE NAME = ?";
			preparedStmt = connection.prepareStatement(sqlcommand);
			preparedStmt.setString(1, name);
			preparedStmt.executeUpdate();
			preparedStmt.close();

		} catch (SQLException ex) {
			Logger.getLogger(LGStables.class.getName()).log(Level.SEVERE, null, ex);
		}
		refreshButton.doClick();
	}// GEN-LAST:event_deleteButtonActionPerformed

	public static void main(String args[]) {

		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new LGStables().setVisible(true);
			}
		});
	}

	// Variables declaration - do not modify//GEN-BEGIN:variables
	private javax.swing.JButton clearButton;
	private javax.swing.JButton deleteButton;
	private javax.swing.JButton editButton;
	private javax.swing.JTextField editDev;
	private javax.swing.JTextField editLang;
	private javax.swing.JTextField editYear;
	private javax.swing.JButton insertDataButton;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JTextField nameInput;
	private javax.swing.JTextField progrlangInput;
	private javax.swing.JButton refreshButton;
	private javax.swing.JTable table;
	private javax.swing.JButton updateButton;
	private javax.swing.JTextField yearInput;
	// End of variables declaration//GEN-END:variables
}
