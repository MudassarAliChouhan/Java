package controller;

import view.MainView;
import view.FindView;
import view.ReplaceView;
import view.FontView;
import javax.swing.undo.UndoManager;

public class EditControl
{

	public void control(MainView mainview)
	{
		UndoManager manager = new UndoManager();
        mainview.getTxtArea().getDocument().addUndoableEditListener(manager);
		
		canEdit(mainview);
		
		canUndoRedo(mainview,manager);
		canUndo(mainview,manager);
		canRedo(mainview,manager);
		
		selectAll(mainview);
		
		findController(mainview);
		replaceController(mainview);
		
		ChangeFontController(mainview);		
		
		exit(mainview);
	}
	private void canEdit(MainView mainview)
	{
		mainview.getTxtArea().addCaretListener(new javax.swing.event.CaretListener(){
			public void caretUpdate(javax.swing.event.CaretEvent c)
			{
				mainview.getFind().setEnabled(false);
				mainview.getReplace().setEnabled(false);
				mainview.getSelectAll().setEnabled(false);
				
				String curr = mainview.getTxtArea().getText();
				if(curr.length() != 0)
				{
					mainview.getFind().setEnabled(true);
					mainview.getReplace().setEnabled(true);
					mainview.getSelectAll().setEnabled(true);
				}
				if(mainview.getTxtArea().getSelectedText() != null)
				{
					mainview.getCut().setEnabled(true);
					mainview.getCopy().setEnabled(true);
				}else{
					mainview.getCut().setEnabled(false);
					mainview.getCopy().setEnabled(false);
				}
			}
		});

	}
	private void canUndoRedo(MainView view,UndoManager man)
	{
		view.getUndo().setEnabled(false);
		view.getRedo().setEnabled(false);
		view.getTxtArea().addCaretListener(new javax.swing.event.CaretListener(){
			public void caretUpdate(javax.swing.event.CaretEvent e)
			{
				if(man.canUndo()){
					view.getUndo().setEnabled(true);
				}else{
					view.getUndo().setEnabled(false);
				}
				if(man.canRedo()){
					view.getRedo().setEnabled(true);
				}else{
					view.getRedo().setEnabled(false);
				}

			}
		});
	}
	private void canUndo(MainView view,UndoManager man)
	{
		view.getUndo().addActionListener(new java.awt.event.ActionListener(){
			@Override
			public void actionPerformed(java.awt.event.ActionEvent e)
			{
				man.undo();
			}
		});
	}
	private void canRedo(MainView view,UndoManager man)
	{
		view.getRedo().addActionListener(new java.awt.event.ActionListener(){
			@Override
			public void actionPerformed(java.awt.event.ActionEvent e)
			{
				man.redo();
			}			
		});
	}
	
	private void exit(MainView mainview)
	{
		mainview.getExit().addActionListener(new java.awt.event.ActionListener(){
			public void actionPerformed(java.awt.event.ActionEvent e)
			{
				System.exit(0);
			}
		});
	}
	private void selectAll(MainView view)
	{
		view.getSelectAll().addActionListener(new java.awt.event.ActionListener(){
			public void actionPerformed(java.awt.event.ActionEvent e)
			{
				view.getTxtArea().selectAll();
			}
		});
	}
	private void findController(MainView mainview)
	{
		mainview.getFind().addActionListener(new java.awt.event.ActionListener(){
			public void actionPerformed(java.awt.event.ActionEvent e)
			{
				FindView find = new FindView();
				find.setVisible(true);
				find.getFindNext().setEnabled(false);
				
				FindController findController = new FindController();
				findController.checkEmptyFind(find);
				findController.find(mainview,find);
				findController.cancelFind(find);
				
			}
		});
	}
	private void replaceController(MainView view)
	{
		view.getReplace().addActionListener(new java.awt.event.ActionListener(){
			public void actionPerformed(java.awt.event.ActionEvent e)
			{
				ReplaceView replaceView = new ReplaceView();
				replaceView.setVisible(true);
				
				ReplaceController replaceController = new ReplaceController();
				replaceController.btnReplace(view,replaceView);
				replaceController.btnReplaceAll(view,replaceView);
				replaceController.btnCancel(replaceView);
			}
		});
	}
	private void ChangeFontController(MainView mainview)
	{
		mainview.getChangeFont().addActionListener(new java.awt.event.ActionListener(){
			public void actionPerformed(java.awt.event.ActionEvent e)
			{
				FontView fontview = new FontView();
				fontview.setVisible(true);
				
				FontController font = new FontController();
				font.controller(mainview,fontview);
				font.changeFamily(mainview,fontview);
				font.changeStyle(mainview,fontview);
				font.changeSize(mainview,fontview);
			}
		});
			
	}
}