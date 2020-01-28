package view;

public class FontView extends javax.swing.JDialog
{
	private javax.swing.JButton btnOk;	
	private javax.swing.JButton btnCancel;	
	
	private javax.swing.JTextField txtFamily;
	private javax.swing.JTextField txtStyle;
	private javax.swing.JTextField txtSize;
	
	private javax.swing.JLabel lFamily;
	private javax.swing.JLabel lStyle;
	private javax.swing.JLabel lSize;
	
	private javax.swing.JList listFamily;
	private javax.swing.JList listStyle;
	private javax.swing.JList listSize;
	
	private javax.swing.JScrollPane scrollFamily;
	private javax.swing.JScrollPane scrollSize;
	
	private javax.swing.JLabel lReview;
	private javax.swing.JScrollPane scrollReview;
		
	public FontView()
	{
		setTitle("Change Fonting Form");
		setSize(390,430);
		setLocationRelativeTo(null);
		initComponent();
	}
	
	// get funtions
	public javax.swing.JButton 			getBtnOk()		{return btnOk;}
	public javax.swing.JList<String> 	getListFamily()	{return listFamily;}
	public javax.swing.JList<String> 	getListStyle()	{return listStyle;}
	public javax.swing.JList<String> 	getListSize()	{return listSize;}
	public javax.swing.JTextField 		getTxtFamily()	{return txtFamily;}
	public javax.swing.JTextField 		getTxtStyle()	{return txtStyle;}
	public javax.swing.JTextField 		getTxtSize()	{return txtSize;}
	public javax.swing.JLabel	 		getReview()		{return lReview;}
	
	private void initComponent()
	{
		listFamily 	 = new javax.swing.JList<>();
		listStyle 	 = new javax.swing.JList<>();
		listSize 	 = new javax.swing.JList<>();
		scrollFamily = new javax.swing.JScrollPane();
		scrollSize	 = new javax.swing.JScrollPane();
		
		txtFamily	 = new javax.swing.JTextField();
		txtStyle	 = new javax.swing.JTextField();
		txtSize	 	 = new javax.swing.JTextField();
		
		lFamily		 = new javax.swing.JLabel("Faimly");
		lStyle		 = new javax.swing.JLabel("Style");
		lSize		 = new javax.swing.JLabel("Size");
		
		lReview		 = new javax.swing.JLabel(" aAbBcCxXyYzZ");
		scrollReview = new javax.swing.JScrollPane();
		
		btnOk		 = new javax.swing.JButton("OK");
		
		setLayout(null);
		
		scrollFamily.setViewportView(listFamily);
		scrollSize.setViewportView(listSize);
		scrollReview.setViewportView(lReview);		
		
		lFamily.setBounds(20,20,150,20);
		lStyle.setBounds(190,20,100,20);
		lSize.setBounds(310,20,50,20);
		
		txtFamily.setBounds(20,50,150,30);
		txtStyle.setBounds(190,50,100,30);
		txtSize.setBounds(310,50,50,30);
		
		scrollFamily.setBounds(20,90,150,130);
		listStyle.setBounds(190,90,100,130);
		scrollSize.setBounds(310,90,50,130);
		
		scrollReview.setBounds(20,230,200,100);
		
		btnOk.setBounds(270,350,90,30);
		
		add(scrollFamily);
		add(listStyle);
		add(scrollSize);
		add(txtFamily);
		add(txtStyle);
		add(txtSize);
		add(lFamily);
		add(lStyle);
		add(lSize);
		add(scrollReview);
		add(btnOk);
	}
}