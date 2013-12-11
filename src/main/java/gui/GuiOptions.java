package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.LayoutStyle;
import javax.swing.WindowConstants;

public class GuiOptions extends JFrame {

	private static final long serialVersionUID = 1L;

	private JButton btnCancel;
	private JButton btnSave;
	private JLabel labelBoardSize;
	private JLabel labelMines;
	private JLabel labelX;
	private JSpinner spinnerMines;
	private JSpinner spinnerXsize;
	private JSpinner spinnerYSize;

	private int xSize = 0;
	private int ySize = 0;
	private int mines = 0;

	public GuiOptions() {
		initComponents();
	}

	public GuiOptions(int sizeX, int sizeY, int mines) {
		initComponents();
		this.xSize = sizeX;
		this.ySize = sizeY;
		this.mines = mines;
		spinnerMines.setValue(mines);
		spinnerXsize.setValue(sizeX);
		spinnerYSize.setValue(sizeY);
	}

	private void initComponents() {

		labelBoardSize = new JLabel();
		spinnerXsize = new JSpinner();
		labelX = new JLabel();
		spinnerYSize = new JSpinner();
		labelMines = new JLabel();
		spinnerMines = new JSpinner();
		btnSave = new JButton();
		btnCancel = new JButton();

		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

		labelBoardSize.setText("Board size:");
		labelX.setText("X");
		labelMines.setText("Mines:");
		btnSave.setText("Save");
		btnCancel.setText("Cancel");

		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				xSize = (Integer) spinnerXsize.getValue();
				ySize = (Integer) spinnerYSize.getValue();
				mines = (Integer) spinnerMines.getValue();
				backToHomeScreen();
			}
		});

		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				backToHomeScreen();
			}
		});

		GroupLayout layout = new GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout
				.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(
						layout.createSequentialGroup()
								.addContainerGap()
								.addGroup(
										layout.createParallelGroup(
												GroupLayout.Alignment.LEADING)
												.addGroup(
														layout.createSequentialGroup()
																.addGroup(
																		layout.createParallelGroup(
																				GroupLayout.Alignment.LEADING)
																				.addGroup(
																						layout.createSequentialGroup()
																								.addComponent(
																										labelBoardSize)
																								.addPreferredGap(
																										LayoutStyle.ComponentPlacement.UNRELATED)
																								.addComponent(
																										spinnerXsize,
																										GroupLayout.PREFERRED_SIZE,
																										40,
																										GroupLayout.PREFERRED_SIZE))
																				.addGroup(
																						layout.createSequentialGroup()
																								.addComponent(
																										labelMines)
																								.addGap(18,
																										18,
																										18)
																								.addComponent(
																										spinnerMines,
																										GroupLayout.PREFERRED_SIZE,
																										43,
																										GroupLayout.PREFERRED_SIZE)))
																.addPreferredGap(
																		LayoutStyle.ComponentPlacement.RELATED)
																.addComponent(
																		labelX)
																.addPreferredGap(
																		LayoutStyle.ComponentPlacement.RELATED)
																.addComponent(
																		spinnerYSize,
																		GroupLayout.PREFERRED_SIZE,
																		40,
																		GroupLayout.PREFERRED_SIZE)
																.addGap(0,
																		0,
																		Short.MAX_VALUE))
												.addGroup(
														GroupLayout.Alignment.TRAILING,
														layout.createSequentialGroup()
																.addComponent(
																		btnSave)
																.addPreferredGap(
																		LayoutStyle.ComponentPlacement.RELATED,
																		GroupLayout.DEFAULT_SIZE,
																		Short.MAX_VALUE)
																.addComponent(
																		btnCancel)))
								.addContainerGap()));
		layout.setVerticalGroup(layout.createParallelGroup(
				GroupLayout.Alignment.LEADING).addGroup(
				layout.createSequentialGroup()
						.addContainerGap()
						.addGroup(
								layout.createParallelGroup(
										GroupLayout.Alignment.BASELINE)
										.addComponent(labelBoardSize)
										.addComponent(spinnerXsize,
												GroupLayout.PREFERRED_SIZE,
												GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(labelX)
										.addComponent(spinnerYSize,
												GroupLayout.PREFERRED_SIZE,
												GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE))
						.addGap(18, 18, 18)
						.addGroup(
								layout.createParallelGroup(
										GroupLayout.Alignment.BASELINE)
										.addComponent(labelMines)
										.addComponent(spinnerMines,
												GroupLayout.PREFERRED_SIZE,
												GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE))
						.addGap(18, 18, 18)
						.addGroup(
								layout.createParallelGroup(
										GroupLayout.Alignment.BASELINE)
										.addComponent(btnSave)
										.addComponent(btnCancel))
						.addContainerGap(GroupLayout.DEFAULT_SIZE,
								Short.MAX_VALUE)));

		pack();
	}

	public int getXsize() {
		return xSize;
	}

	public int getYsize() {
		return ySize;
	}

	public int getMinesCount() {
		return mines;
	}

	private void backToHomeScreen() {
		HomeScreen saper = new HomeScreen(xSize, ySize, mines);
		//HomeScreen saper = new HomeScreen();
		saper.setLocation(this.getLocationOnScreen());
		saper.setVisible(true);
		this.setVisible(false);
	}
	
}