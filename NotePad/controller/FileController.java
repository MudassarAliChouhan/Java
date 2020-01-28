package controller;

import view.MainView;

public class FileController
{
	public void controller(MainView mainview)
	{
		javax.swing.JFileChooser chooser = new javax.swing.JFileChooser();
		setupFileChooser(chooser);
		
		newfile(mainview,chooser);
		savefile(mainview,chooser);
		saveAsFile(mainview,chooser);
		openFile(mainview,chooser);
		chkSave(mainview);
	}
	
	private void openFile(MainView mainview,javax.swing.JFileChooser chooser)
	{
		mainview.getOpen().addActionListener(new java.awt.event.ActionListener(){
			public void actionPerformed(java.awt.event.ActionEvent e)
			{
				if(mainview.getFileSaved())
				{
					java.io.File file = null;
					while(true)
					{
						chooser.showOpenDialog(mainview);
						file = chooser.getSelectedFile();
						if(file.exists())
							break;
						javax.swing.JOptionPane.showMessageDialog(mainview,"File Not Found","Open",javax.swing.JOptionPane.INFORMATION_MESSAGE);
					}
					mainview.setFile(file);				
					mainview.getTxtArea().setText("");
					mainview.setFileSaved(true);
					fileToTxtArea(mainview);
				}
				else
				{
					if(false == cheackSave(mainview,chooser))
						mainview.setFileSaved(true);
				}
				
			}			
		});
	}
	private void saveAsFile(MainView mainview,javax.swing.JFileChooser chooser)
	{
		mainview.getSaveAs().addActionListener(new java.awt.event.ActionListener(){
			public void actionPerformed(java.awt.event.ActionEvent e)
			{
				saveAs(mainview,chooser);
			}			
		});
	}
	private void savefile(MainView mainview,javax.swing.JFileChooser chooser)
	{
		mainview.getSave().addActionListener(new java.awt.event.ActionListener(){
			public void actionPerformed(java.awt.event.ActionEvent e)
			{
				if(mainview.getFile()==null)
					saveAs(mainview,chooser);
				if(!mainview.getFileSaved())
				{
					txtAreaToFile(mainview);
					mainview.setFileTxt(mainview.getTxtArea().getText());
					mainview.setFileSaved(true);
				}
					
			}
		});
	}
	private void chkSave(MainView mainview)
	{
		mainview.getTxtArea().addCaretListener(new javax.swing.event.CaretListener(){
			public void caretUpdate(javax.swing.event.CaretEvent e)
			{
				if(!mainview.getTxtArea().getText().equals(mainview.getFileTxt()))
					mainview.setFileSaved(false);
			}
		});
	}
	private void txtAreaToFile(MainView mainview)
	{		
		java.io.FileWriter fout = null;
		java.io.File file = mainview.getFile();
		try
		{
			fout = new java.io.FileWriter(file);
			fout.write(mainview.getTxtArea().getText());			
		}catch(java.io.IOException e){
			e.printStackTrace();
		}finally{
			try
			{
				fout.close();
			}catch(java.io.IOException e)
				{e.printStackTrace();}
		}
	}
	private void fileToTxtArea(MainView mainview)
	{
				try
				{
					java.io.FileInputStream fstream = new java.io.FileInputStream(mainview.getFile());
					java.io.BufferedReader buffer = new java.io.BufferedReader(new java.io.InputStreamReader(fstream));
					String str = "";
					while(str!=null)
					{
						
						str = buffer.readLine();
						if(str==null)
							break;
						mainview.getTxtArea().append(str + "\n");						
					}
					mainview.setFileTxt(mainview.getTxtArea().getText());
					mainview.setFileSaved(true);
				}catch(java.io.FileNotFoundException ioex){
					ioex.printStackTrace();
				}
				catch(java.io.IOException ioex){
					ioex.printStackTrace();
				}
	}
	private void saveAs(MainView mainview,javax.swing.JFileChooser chooser)
	{
		int opt;
		java.io.File file = null;
		String massage = "<html><div style = color:'red'>Do you want to Overright file</div></html>";
		while(true)
		{
			chooser.showSaveDialog(mainview);
			file = chooser.getSelectedFile();
			if(!file.exists())
				break;
			opt = javax.swing.JOptionPane.showConfirmDialog(mainview,massage,"SaveAs",javax.swing.JOptionPane.YES_NO_CANCEL_OPTION);
			if(opt == javax.swing.JOptionPane.YES_OPTION)
				break;
			if(opt == javax.swing.JOptionPane.CANCEL_OPTION)
				return;
		}
		mainview.setFile(file);
		txtAreaToFile(mainview);
	}
	private boolean	cheackSave(MainView mainview,javax.swing.JFileChooser chooser)
	{
		String massage = "<html><div style = color:'blue'>Do you want to save File</div></html>";
		int confirm = javax.swing.JOptionPane.showConfirmDialog(mainview,massage,"Confirm",javax.swing.JOptionPane.YES_NO_CANCEL_OPTION);
		if(confirm == javax.swing.JOptionPane.YES_OPTION)
		{
			if(mainview.getFile() == null)
				saveAs(mainview,chooser);
			else
				txtAreaToFile(mainview);
		}
		if(confirm == javax.swing.JOptionPane.CANCEL_OPTION)
			return true;
		if(confirm == javax.swing.JOptionPane.NO_OPTION)
			return true;
		return
			false;
	}
	private void newfile(MainView mainview,javax.swing.JFileChooser chooser)
	{
		mainview.getNew().addActionListener(new java.awt.event.ActionListener(){
			public void actionPerformed(java.awt.event.ActionEvent e)
			{
				if(cheackSave(mainview,chooser))
					return;
				mainview.getTxtArea().setText("");
				mainview.setFile(null);
			}
		});
	}
	private void setupFileChooser(javax.swing.JFileChooser chooser)
	{
		chooser.addChoosableFileFilter(new javax.swing.filechooser.FileFilter(){
			public boolean accept(java.io.File file)
			{
				if(file.isDirectory())
					return true;
				return file.getName().endsWith("*");
			}
			public String getDescription()
			{
				return "java source code";
			}
		});
		chooser.setCurrentDirectory(new java.io.File("."));
	}
}