package controller;

import view.MainView;
import view.ReplaceView;

public class ReplaceController
{
	public void btnReplaceAll(MainView mainview,ReplaceView replaceview)
	{
		replaceview.getBtnReplaceAll().addActionListener(new java.awt.event.ActionListener(){
			public void actionPerformed(java.awt.event.ActionEvent e)
			{
				String txtArea = mainview.getTxtArea().getText();
				String findTxt = replaceview.getTxtFind().getText();
				String txtReplace = replaceview.getTxtReplace().getText();
				mainview.getTxtArea().setText(txtArea.replaceAll(findTxt,txtReplace)); 
			}
		});
	}
	public void btnReplace(MainView mainview,ReplaceView replaceview)
	{
		replaceview.getBtnReplace().addActionListener(new java.awt.event.ActionListener(){
			public void actionPerformed(java.awt.event.ActionEvent e)
			{
				String txtArea = mainview.getTxtArea().getText();
				String findTxt = replaceview.getTxtFind().getText();
				String txtReplace = replaceview.getTxtReplace().getText();
				mainview.getTxtArea().setText(txtArea.replaceFirst(findTxt,txtReplace));
			}
		});
	}
	public void btnCancel(ReplaceView replaceview)
	{
		replaceview.getBtnCancel().addActionListener(new java.awt.event.ActionListener(){
			public void actionPerformed(java.awt.event.ActionEvent e)
			{
				replaceview.setVisible(false);
			}
		});
	}
}