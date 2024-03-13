package in.pennant.emp.crud;

import java.awt.Button;
import java.awt.Choice;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Image;
import java.awt.Label;
import java.awt.TextField;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JScrollPane;
import javax.swing.JTable;

public class Emp_Interface_Ui {
	private static Frame mainframe = null;
	private static Image frameicon = null;
	private static Font mainfont = null;
	private static Font labelfont = null;
	private static Label mainlabel = null;
	private static Label empnolbl = null;
	private static Label namelbl = null;
	private static Label joblbl = null;
	private static Label sallbl = null;
	private static Label deptnolbl = null;
	private static Label hiredatelbl = null;
	private static TextField empnofld = null;
	private static TextField namefld = null;
	private static TextField jobfld = null;
	private static TextField salfld = null;
	private static Choice deptnochc = null;
	private static Button firstbtn = null;
	private static Button nextbtn = null;
	private static Button prevbtn = null;
	private static Button lastbtn = null;
	private static Button addbtn = null;
	private static Button editbtn = null;
	private static Button delbtn = null;
	private static Button savebtn = null;
	private static Button clearbtn = null;
	private static Button exitbtn = null;

	// private static
	public static void main(String[] args) {
		// creating a main frame for the app and setting the parameters
		mainframe = new Frame("EMP_CRUD_APP");
		mainframe.setSize(820, 800);
		mainframe.setLayout(null);
		mainframe.setVisible(true);
		mainframe.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we) {
				System.exit(0);
			}
		});

		// setting an icon for the app
		frameicon = Toolkit.getDefaultToolkit().getImage("C:\\Users\\hemanthraju.v\\Desktop\\icon.png");
		mainframe.setIconImage(frameicon);
		// creating a font variable and setting title of the app
		// font declaration for title
		mainfont = new Font("SansSerif", Font.BOLD, 30);
		// label declaration and setup the font to frame
		mainlabel = new Label("EMPLOYEE CRUD APP");
		mainlabel.setAlignment(Label.CENTER);
		mainlabel.setBounds(150, 0, 500, 100);
		mainlabel.setFont(mainfont);
		mainframe.add(mainlabel);

		// labels for the fields names

		labelfont = new Font("SansSerif", Font.BOLD, 15);
		empnolbl = new Label("EMP NO :: ");
		empnolbl.setBounds(20, 150, 180, 20);
		empnolbl.setFont(labelfont);
		mainframe.add(empnolbl);

		empnofld = new TextField();
		empnofld.setBounds(200, 150, 200, 20);
		mainframe.add(empnofld);

		namelbl = new Label("EMP NAME :: ");
		namelbl.setBounds(420, 150, 150, 20);
		namelbl.setFont(labelfont);
		mainframe.add(namelbl);

		namefld = new TextField();
		namefld.setBounds(600, 150, 200, 20);
		mainframe.add(namefld);

		joblbl = new Label("JOB ROLE :: ");
		joblbl.setBounds(20, 200, 150, 20);
		joblbl.setFont(labelfont);
		mainframe.add(joblbl);

		jobfld = new TextField();
		jobfld.setBounds(200, 200, 200, 20);
		mainframe.add(jobfld);

		sallbl = new Label("SALARY :: ");
		sallbl.setBounds(420, 200, 150, 20);
		sallbl.setFont(labelfont);
		mainframe.add(sallbl);

		salfld = new TextField();
		salfld.setBounds(600, 200, 200, 20);
		mainframe.add(salfld);

		deptnolbl = new Label("DEPARTMENT NO :: ");
		deptnolbl.setBounds(20, 250, 150, 20);
		deptnolbl.setFont(labelfont);

		deptnochc = new Choice();
		deptnochc.setBounds(200, 250, 200, 20);
		mainframe.add(deptnochc);

		mainframe.add(deptnolbl);
		hiredatelbl = new Label("HIRED DATE ::");
		hiredatelbl.setBounds(420, 250, 150, 20);
		hiredatelbl.setFont(labelfont);
		mainframe.add(hiredatelbl);

		DateTextField dtf = new DateTextField();
		dtf.setBounds(600, 250, 150, 20);
		mainframe.add(dtf);
		// Properties p = new Properties();
		// p.put("text.today", "Today");
		// p.put("text.month", "Month");
		// p.put("text.year", "Year");
		// UtilDateModel model = new UtilDateModel();
		// // model.setDate(20,04,2014);
		// JDatePanelImpl datePanel = new JDatePanelImpl(model, p);
		// JDatePickerImpl datePicker = new JDatePickerImpl(datePanel, new DateLabelFormatter());
		// datePanel.setBounds(600, 250, 150, 20);
		// mainframe.add(datePicker);
		// try {
		// UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		// } catch (Exception e) {
		// }
		// JFrame testFrame = new JFrame();
		// testFrame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		// testFrame.setSize(500, 500);
		// JPanel jPanel = new JPanel();
		// DatePicker picker = new JDatePicker();
		// picker.setTextEditable(true);
		// picker.setShowYearButtons(true);
		// jPanel.add((JComponent) picker);
		// JPanel DatePanel = new JPanel();
		// DatePanel.setLayout(new BorderLayout());
		// DatePanel.add(jPanel, BorderLayout.WEST);
		// BorderLayout fb = new BorderLayout();
		// testFrame.setLayout(fb);
		// testFrame.getContentPane().add(DatePanel, BorderLayout.WEST);
		// testFrame.setVisible(true);
		// buttons for iterating the records
		firstbtn = new Button("First");
		firstbtn.setBounds(50, 300, 100, 20);
		mainframe.add(firstbtn);

		nextbtn = new Button("Next");
		nextbtn.setBounds(250, 300, 100, 20);
		mainframe.add(nextbtn);

		prevbtn = new Button("Prev");
		prevbtn.setBounds(450, 300, 100, 20);
		mainframe.add(prevbtn);

		lastbtn = new Button("Last");
		lastbtn.setBounds(650, 300, 100, 20);
		mainframe.add(lastbtn);

		// buttons for crud
		addbtn = new Button("Add");
		addbtn.setBounds(50, 340, 100, 20);
		mainframe.add(addbtn);

		editbtn = new Button("Edit");
		editbtn.setBounds(250, 340, 100, 20);
		mainframe.add(editbtn);

		delbtn = new Button("Del");
		delbtn.setBounds(450, 340, 100, 20);
		mainframe.add(delbtn);

		savebtn = new Button("Save");
		savebtn.setBounds(650, 340, 100, 20);
		mainframe.add(savebtn);

		// buttons for clear screen and exit app
		clearbtn = new Button("Clear");
		clearbtn.setBounds(150, 380, 100, 20);
		mainframe.add(clearbtn);
		exitbtn = new Button("Exit");
		exitbtn.setBounds(550, 380, 100, 20);
		mainframe.add(exitbtn);
		String data[][] = {};
		String column[] = { "S.No", "Emp No", "Emp Name", "Job", "Salary", "Dept No", "Hire Date" };
		JTable jt = new JTable(data, column);

		JScrollPane sp = new JScrollPane(jt);
		sp.setBounds(20, 450, 780, 300);
		sp.setEnabled(true);
		mainframe.add(sp);
	}

}
