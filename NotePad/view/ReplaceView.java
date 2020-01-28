package view;

public class ReplaceView extends javax.swing.JDialog
{
	private javax.swing.JButton btnCancel;
	private javax.swing.JButton btnReplaceAll;
	private javax.swing.JButton btnReplace;
	private javax.swing.JTextField txtReplace;
	private javax.swing.JTextField txtFind;
	private javax.swing.JLabel lReplaceWith;
	private javax.swing.JLabel lFindWhat;
	
	/* Funtion Define */	
	// Get Functions
	public javax.swing.JButton 		getBtnCancel()			{return btnCancel;}
	public javax.swing.JButton 		getBtnReplace()			{return btnReplace;}
	public javax.swing.JButton 		getBtnReplaceAll()		{return btnReplaceAll;}
	public javax.swing.JTextField	getTxtReplace()			{return txtReplace;}
	public javax.swing.JTextField	getTxtFind()			{return txtFind;}
	
	public ReplaceView()
	{
		initComponent();
	}
	
	private void initComponent()
	{
		setSize(350,250);
		setLocationRelativeTo(null);
		setTitle("Repaceing Form");
		
		btnCancel 	 	= new javax.swing.JButton("Cancel");
		btnReplace  	= new javax.swing.JButton("Repace");
		btnReplaceAll  	= new javax.swing.JButton("Replace All");
		txtReplace		= new javax.swing.JTextField();
		txtFind 		= new javax.swing.JTextField();
		lFindWhat 	 	= new javax.swing.JLabel("Find What?");
		lReplaceWith 	= new javax.swing.JLabel("Replace With");
		
		
		setLayout(null);
		
		lFindWhat.setBounds		(20,20,100,30);
		txtFind.setBounds		(120,20,200,30);
		lReplaceWith.setBounds	(20,60,100,30);
		txtReplace.setBounds	(120,60,200,30);
		
		btnReplace.setBounds	(30,100,130,40);
		btnReplaceAll.setBounds	(180,100,130,40);
		btnCancel.setBounds		(20,150,300,30);
		
		add(lFindWhat);
		add(txtFind);
		add(lReplaceWith);
		add(txtReplace);
		
		add(btnReplace);
		add(btnReplaceAll);
		add(btnCancel);
		
	}
}