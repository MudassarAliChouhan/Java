package controller;

import view.FindView;
import view.MainView;

public class FindController
{
	public void checkEmptyFind(FindView find)
	{
		find.getTxtFieldFind().addCaretListener(new javax.swing.event.CaretListener(){
			public void caretUpdate(javax.swing.event.CaretEvent e)
			{
				if(find.getTxtFieldFind().getText().trim().isEmpty())
					find.getFindNext().setEnabled(false);
				else 
					find.getFindNext().setEnabled(true);
			}
		});
	}
	public void find(MainView mainview,FindView findview)
	{
		findview.getFindNext().addActionListener(new java.awt.event.ActionListener(){
			public void actionPerformed(java.awt.event.ActionEvent e)
			{
				String txtFind = findview.getTxtFieldFind().getText();
				int indexCurr;
				int indexSearched = -1;
				if(findview.getRadioDown().isSelected())
				{
					indexCurr = mainview.getTxtArea().getSelectionEnd();
					indexSearched = mainview.getTxtArea().getText().indexOf(txtFind,indexCurr);
				}
				else
				{
					try{
						indexCurr = mainview.getTxtArea().getSelectionStart();
						String checkStr = mainview.getTxtArea().getText(0,indexCurr);
						indexSearched = checkStr.lastIndexOf(txtFind);
					}catch(javax.swing.text.BadLocationException ex){
						ex.printStackTrace();
					}
				}
				if(indexSearched != -1)
				{
					mainview.getTxtArea().setSelectionStart(indexSearched);
					mainview.getTxtArea().setSelectionEnd(indexSearched+txtFind.length());
				}
				else
					javax.swing.JOptionPane.showMessageDialog(findview,"\""+txtFind+"\""+" Not Found"," Result!!",0);
			}
		});
	}
	public void cancelFind(FindView find)
	{
		find.getCancel().addActionListener(new java.awt.event.ActionListener(){
			public void actionPerformed(java.awt.event.ActionEvent e)
			{
				find.setVisible(false);
			}
		});
	}
}