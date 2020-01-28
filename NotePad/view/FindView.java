package view;

public class FindView extends javax.swing.JDialog
{
	private javax.swing.JRadioButton radioDown;
	private javax.swing.JRadioButton radioUp;
	private javax.swing.JButton btnCancel;
	private javax.swing.JButton btnFindNext;
	private javax.swing.JTextField txtFieldFind;
	private javax.swing.JLabel lDirection;
	private javax.swing.JLabel lFindWhat;
	private javax.swing.ButtonGroup radioGroup;
	
	/* Funtion Define */
	//Set Functions
	public void setFindNext()			{this.btnFindNext = btnFindNext;}
	public void setCancel()				{this.btnCancel = btnCancel;}
	public void setTxtFieldFind()		{this.txtFieldFind = txtFieldFind;}
	public void setRadioDown()			{this.radioDown = radioDown;}
	
	// Get Functions
	public javax.swing.JButton 		getFindNext()			{return btnFindNext;}
	public javax.swing.JButton 		getCancel()				{return btnCancel;}	
	public javax.swing.JTextField 	getTxtFieldFind()		{return txtFieldFind;}
	public javax.swing.JRadioButton getRadioDown()			{return radioDown;}
	
	public FindView()
	{
		initComponent();
	}
	
	private void initComponent()
	{
		setSize(270,200);
		setLocationRelativeTo(null);
		setTitle("Find Form");
		
		radioDown 	 	= new javax.swing.JRadioButton("Down");
		radioUp 	 	= new javax.swing.JRadioButton("Up");
		btnCancel 	 	= new javax.swing.JButton("Cancel");
		btnFindNext  	= new javax.swing.JButton("Find  To  Next");
		txtFieldFind 	= new javax.swing.JTextField();
		lFindWhat 	 	= new javax.swing.JLabel("Find What?");
		lDirection 	 	= new javax.swing.JLabel("Direction");
		radioGroup		= new javax.swing.ButtonGroup();
		
		radioGroup.add(radioUp);
		radioGroup.add(radioDown);
		radioDown.setSelected(true);
		
		setLayout(null);
		
		lFindWhat.setBounds		(20,20,70,30);
		txtFieldFind.setBounds	(90,20,150,30);
		btnFindNext.setBounds	(20,60,220,30);
		
		lDirection.setBounds(20,100,70,20);
		radioUp.setBounds	(20,120,50,30);
		radioDown.setBounds	(70,120,70,30);
		
		btnCancel.setBounds(140,115,100,30);
		
		add(lFindWhat);
		add(txtFieldFind);
		add(btnFindNext);
		add(lDirection);
		add(radioUp);
		add(radioDown);
		add(btnCancel);
	}
}