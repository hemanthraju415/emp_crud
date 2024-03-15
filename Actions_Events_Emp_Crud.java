package in.pennant.emp.crud;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

class Counter {
	int counter;
}

public class Actions_Events_Emp_Crud {
	private static String column[] = { "S.No", "Emp No", "Emp Name", "Job", "Salary", "Dept No", "Hire Date" };
	protected static final ArrayList<Integer> SELECTED_COLUMNS = new ArrayList<>();
	protected static Counter deleted_counter = null;

	protected static void first_Action() {
		Actions_Events_Emp_Crud.SELECTED_COLUMNS.clear();
		try {
			Emp_Interface_Ui.result_set_scrollable.first();
			set_TextFields();
		} catch (SQLException e) {
		}
	}

	protected static void next_Action() {
		Actions_Events_Emp_Crud.SELECTED_COLUMNS.clear();
		try {
			Emp_Interface_Ui.result_set_scrollable.next();
			set_TextFields();
		} catch (SQLException e) {
		}

	}

	protected static void prev_Action() {
		Actions_Events_Emp_Crud.SELECTED_COLUMNS.clear();
		try {
			Emp_Interface_Ui.result_set_scrollable.previous();
			set_TextFields();
		} catch (SQLException e) {
		}
	}

	protected static void last_Action() {
		Actions_Events_Emp_Crud.SELECTED_COLUMNS.clear();
		try {
			Emp_Interface_Ui.result_set_scrollable.last();
			set_TextFields();
		} catch (SQLException e) {
		}
	}

	protected static void clear_Action() {
		Emp_Interface_Ui.addbtn.setEnabled(true);
		Emp_Interface_Ui.delbtn.setEnabled(false);
		Emp_Interface_Ui.editbtn.setEnabled(false);
		Emp_Interface_Ui.empnofld.setEnabled(true);
		Emp_Interface_Ui.empnofld.setText(null);
		Emp_Interface_Ui.namefld.setText(null);
		Emp_Interface_Ui.jobfld.setText(null);
		Emp_Interface_Ui.salfld.setText(null);
		setFieldsTouchable();
		try {
			check_ResultSet_Status();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	protected static void edit_Action() {
		setFieldsTouchable();
	}

	protected static void delete_Action() {
		try {
			boolean deleted_multiple_rows = false;
			if (SELECTED_COLUMNS.size() > 0) {
				deleted_counter = new Counter();
				SELECTED_COLUMNS.forEach(t -> {
					try {
						Emp_Interface_Ui.result_set_scrollable.absolute(t + 1 - deleted_counter.counter);
						if (Emp_Interface_Ui.result_set_scrollable.isAfterLast())
							Emp_Interface_Ui.result_set_scrollable.absolute(t);
						Emp_Interface_Ui.result_set_scrollable.deleteRow();
						deleted_counter.counter++;
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				});
				deleted_multiple_rows = true;
			} else
				Emp_Interface_Ui.result_set_scrollable.deleteRow();
			if (deleted_multiple_rows) {
				SELECTED_COLUMNS.clear();

			}
			Emp_Interface_Ui.result_set_scrollable.refreshRow();
			if (Emp_Interface_Ui.result_set_scrollable.isAfterLast())
				prev_Action();
			else if (Emp_Interface_Ui.result_set_scrollable.isBeforeFirst())
				next_Action();
			check_ResultSet_Status();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null,
					"sorry BOSS no records left to delete please ensure you are deleting a proper record ",
					"ALERT!!!!!", JOptionPane.WARNING_MESSAGE);

		}
		set_Table_Data();
	}

	protected static void add_Action() {
		try {
			Emp_Interface_Ui.result_set_scrollable.moveToInsertRow();
			Emp_Interface_Ui.result_set_scrollable.updateInt("empno",
					Integer.parseInt(Emp_Interface_Ui.empnofld.getText()));
			set_fields();
			Emp_Interface_Ui.result_set_scrollable.insertRow();
			set_Table_Data();
			Emp_Interface_Ui.addbtn.setEnabled(false);
			clear_Action();
			check_ResultSet_Status();
		} catch (SQLException e) {
			if (e.getLocalizedMessage().startsWith("ERROR: duplicate key value violates unique constraint"))
				JOptionPane.showMessageDialog(null,
						"sorry BOSS a record with the same empno is already exists in data base", "ALERT!!!!!",
						JOptionPane.WARNING_MESSAGE);
		} catch (NumberFormatException e) {
			if (e.getMessage().startsWith("For input string:"))
				JOptionPane.showMessageDialog(null,
						"sorry BOSS i couldnt able to add the value into DATABASE please ensure empno(int EX:'123') or salary(double EX:'100.00') ",
						"ALERT!!!!!", JOptionPane.ERROR_MESSAGE);
		}
		clear_Action();

	}

	protected static void save_Action() {
		try {
			Emp_Interface_Ui.result_set_scrollable.moveToCurrentRow();
			set_fields();
			Emp_Interface_Ui.result_set_scrollable.updateRow();
			Emp_Interface_Ui.result_set_scrollable.refreshRow();
			set_Table_Data();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		Emp_Interface_Ui.editbtn.setEnabled(true);
		setFeildsNonTouchable();
	}

	private static void setFeildsNonTouchable() {
		Emp_Interface_Ui.empnofld.setEnabled(false);
		Emp_Interface_Ui.namefld.setEnabled(false);
		Emp_Interface_Ui.jobfld.setEnabled(false);
		Emp_Interface_Ui.salfld.setEnabled(false);
		Emp_Interface_Ui.deptnochc.setEnabled(false);
		Emp_Interface_Ui.hiredatefld.setEnabled(false);
	}

	private static void setFieldsTouchable() {
		Emp_Interface_Ui.namefld.setEnabled(true);
		Emp_Interface_Ui.jobfld.setEnabled(true);
		Emp_Interface_Ui.salfld.setEnabled(true);
		Emp_Interface_Ui.deptnochc.setEnabled(true);
		Emp_Interface_Ui.hiredatefld.setEnabled(true);
	}

	private static void check_ResultSet_Status() throws SQLException {

		if (Emp_Interface_Ui.result_set_scrollable.isFirst()) {
			Emp_Interface_Ui.firstbtn.setEnabled(false);
			Emp_Interface_Ui.prevbtn.setEnabled(false);
		} else {
			Emp_Interface_Ui.firstbtn.setEnabled(true);
			Emp_Interface_Ui.prevbtn.setEnabled(true);
		}
		if (Emp_Interface_Ui.result_set_scrollable.isLast()) {
			Emp_Interface_Ui.lastbtn.setEnabled(false);
			Emp_Interface_Ui.nextbtn.setEnabled(false);
		} else {
			Emp_Interface_Ui.lastbtn.setEnabled(true);
			Emp_Interface_Ui.nextbtn.setEnabled(true);
		}
		if (Emp_Interface_Ui.result_set_scrollable.isBeforeFirst()
				|| Emp_Interface_Ui.result_set_scrollable.isAfterLast()) {
			Emp_Interface_Ui.editbtn.setEnabled(false);
			Emp_Interface_Ui.delbtn.setEnabled(false);
			Emp_Interface_Ui.savebtn.setEnabled(false);
		} else {
			Emp_Interface_Ui.editbtn.setEnabled(true);
			Emp_Interface_Ui.delbtn.setEnabled(true);
			Emp_Interface_Ui.savebtn.setEnabled(true);
		}
	}

	protected static void set_Table_Data() {
		try {
			if (Emp_Interface_Ui.Table_Content.getRowCount() > 0) {
				Emp_Interface_Ui.Table_Content.setRowCount(0);
			}
			if (Emp_Interface_Ui.Table_Content.getColumnCount() == 0)
				for (String column_heading : column)
					Emp_Interface_Ui.Table_Content.addColumn(column_heading);
			Emp_Interface_Ui.result_set_scrollable.beforeFirst();
			int i = 0;
			while (Emp_Interface_Ui.result_set_scrollable.next()) {
				String row_Data[] = { "" + (++i) + "",
						String.valueOf(Emp_Interface_Ui.result_set_scrollable.getInt("empno")),
						Emp_Interface_Ui.result_set_scrollable.getString("ename"),
						Emp_Interface_Ui.result_set_scrollable.getString("job"),
						String.valueOf(Emp_Interface_Ui.result_set_scrollable.getDouble("sal")),
						String.valueOf(Emp_Interface_Ui.result_set_scrollable.getInt("deptno")),
						String.valueOf(Emp_Interface_Ui.result_set_scrollable.getDate("hiredate")) };
				Emp_Interface_Ui.Table_Content.addRow(row_Data);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private static void set_fields() {
		try {
			Emp_Interface_Ui.result_set_scrollable.updateString("ename", Emp_Interface_Ui.namefld.getText());
			Emp_Interface_Ui.result_set_scrollable.updateString("job", Emp_Interface_Ui.jobfld.getText());
			Emp_Interface_Ui.result_set_scrollable.updateDouble("sal",
					Double.parseDouble(Emp_Interface_Ui.salfld.getText()));
			Emp_Interface_Ui.result_set_scrollable.updateInt("deptno",
					Integer.parseInt(Emp_Interface_Ui.deptnochc.getSelectedItem()));
			Emp_Interface_Ui.result_set_scrollable.updateDate("hiredate",
					new Date(Emp_Interface_Ui.hiredatefld.getDate().getTime()));
		} catch (SQLException e) {

		}
	}

	protected static void set_TextFields() {
		setFeildsNonTouchable();
		try {
			Emp_Interface_Ui.empnofld.setText(String.valueOf(Emp_Interface_Ui.result_set_scrollable.getInt("empno")));
			Emp_Interface_Ui.namefld.setText(String.valueOf(Emp_Interface_Ui.result_set_scrollable.getString("ename")));
			Emp_Interface_Ui.jobfld.setText(String.valueOf(Emp_Interface_Ui.result_set_scrollable.getString("job")));
			Emp_Interface_Ui.salfld.setText(String.valueOf(Emp_Interface_Ui.result_set_scrollable.getDouble("sal")));
			Emp_Interface_Ui.deptnochc.select(String.valueOf(Emp_Interface_Ui.result_set_scrollable.getInt("deptno")));
			Emp_Interface_Ui.hiredatefld.setDate(Emp_Interface_Ui.result_set_scrollable.getDate("hiredate"));
			check_ResultSet_Status();
		} catch (SQLException e) {
		}
	}
}