package view;

public class MainView extends javax.swing.JFrame
{
	private java.io.File file = null;
	private String fileTxt = "";
	private boolean saved = true;
	private javax.swing.JMenuBar appBar;
	
	private javax.swing.JMenu editmenu;
	private javax.swing.JMenu filemenu;
	
	private javax.swing.JMenuItem editChangeFont;
	private javax.swing.JMenuItem editReplace;
	private javax.swing.JMenuItem editFind;
	private javax.swing.JMenuItem editSelectAll;
	private javax.swing.JMenuItem editPaste;
	private javax.swing.JMenuItem editCopy;
	private javax.swing.JMenuItem editCut;
	private javax.swing.JMenuItem editRedo;
	private javax.swing.JMenuItem editUndo;
	
	private javax.swing.JMenuItem fileExit;
	private javax.swing.JMenuItem fileSaveAs;
	private javax.swing.JMenuItem fileSave;
	private javax.swing.JMenuItem fileOpen;
	private javax.swing.JMenuItem fileNew;
	
	private javax.swing.JTextArea txtArea;
	private javax.swing.JScrollPane scrolPane;
	
	/* Funtion Define */
	//Set Functions
	public void setReplace()	{this.editReplace = editReplace;}
	public void setfind()		{this.editFind = editFind;}
	public void setCopy()		{this.editCopy = editCopy;}
	public void setCut()		{this.editCut = editCut;}
	public void setRedo()		{this.editRedo = editRedo;}
	public void setUndo()		{this.editUndo = editUndo;}
	public void setTxtArea()	{this.txtArea = txtArea;}
	public void setSelectAll()	{this.editSelectAll = editSelectAll;}
	
	public void setFile(java.io.File file)		{this.file = file;}
	public void setFileTxt(String fileTxt)		{this.fileTxt = fileTxt;}
	public void setFileSaved(boolean saved)		{this.saved = saved;}
	
	// Get Functions
	public javax.swing.JMenuItem getReplace()		{return editReplace;}
	public javax.swing.JMenuItem getFind()			{return editFind;}
	public javax.swing.JMenuItem getCopy()			{return editCopy;}
	public javax.swing.JMenuItem getCut()			{return editCut;}
	public javax.swing.JMenuItem getRedo()			{return editRedo;}
	public javax.swing.JMenuItem getUndo()			{return editUndo;}
	public javax.swing.JTextArea getTxtArea()		{return txtArea;}
	public javax.swing.JMenuItem getSelectAll()		{return editSelectAll;}
	public javax.swing.JMenuItem getChangeFont()	{return editChangeFont;}
	
	public javax.swing.JMenuItem getSaveAs()		{return fileSaveAs;}
	public javax.swing.JMenuItem getSave()			{return fileSave;}
	public javax.swing.JMenuItem getOpen()			{return fileOpen;}
	public javax.swing.JMenuItem getNew()			{return fileNew;}
	
	public java.io.File getFile()	{return file;}
	public String getFileTxt()		{return fileTxt;}
	public boolean getFileSaved()	{return saved;}
	
	public javax.swing.JMenuItem getExit(){return fileExit;}
	// Constructor
	public MainView()
	{
		super("Note Pad");
		//setLocationRelativeTo(null);
		setLocation(100,100);
		setSize(640,420);
		//setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		initComponents();
	}
	private void initComponents()
	{
		// init all The Component's
		appBar = new javax.swing.JMenuBar();
		
		editmenu = new javax.swing.JMenu(" Edit");
		filemenu = new javax.swing.JMenu(" File");
		
		editChangeFont 	= new javax.swing.JMenuItem(" Change Font Size ");
		editReplace 	= new javax.swing.JMenuItem(" Replace");
		editFind 		= new javax.swing.JMenuItem(" Find");
		editSelectAll 	= new javax.swing.JMenuItem(" Select-All");
		editPaste 		= new javax.swing.JMenuItem(" Paste");
		editCopy 		= new javax.swing.JMenuItem(" Copy");
		editCut 		= new javax.swing.JMenuItem(" Cut");
		editRedo 		= new javax.swing.JMenuItem(" Redo");
		editUndo 		= new javax.swing.JMenuItem(" Undo");
		
		fileExit 	= new javax.swing.JMenuItem(" Exit");
		fileSaveAs 	= new javax.swing.JMenuItem(" Save as");
		fileSave 	= new javax.swing.JMenuItem(" Save File ");
		fileOpen 	= new javax.swing.JMenuItem(" Open");
		fileNew 	= new javax.swing.JMenuItem(" New ...");
		
		txtArea 	= new javax.swing.JTextArea();
		scrolPane 	= new javax.swing.JScrollPane();
		txtArea.setColumns(2);
		txtArea.setRows(2);
		scrolPane.setViewportView(txtArea);
		
		// add
		editmenu.add(editUndo);
		editmenu.add(editRedo);
		editmenu.addSeparator(); //Separator
		editmenu.add(editCut);
		editmenu.add(editCopy);
		editmenu.add(editPaste);
		editmenu.add(editSelectAll);
		editmenu.addSeparator(); //Separator
		editmenu.add(editFind);
		editmenu.add(editReplace);
		editmenu.add(editChangeFont);
		
		filemenu.add(fileNew);
		filemenu.add(fileOpen);
		filemenu.addSeparator(); //Separator
		filemenu.add(fileSave);
		filemenu.add(fileSaveAs);
		filemenu.addSeparator(); //Separator
		filemenu.add(fileExit);
		
		add(scrolPane);
		
		appBar.add(filemenu);
		appBar.add(editmenu);
		
		setJMenuBar(appBar);
	}
}