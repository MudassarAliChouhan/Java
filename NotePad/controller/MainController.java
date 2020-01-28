package controller;

import view.MainView;

public class MainController
{
	public static void main(String []args)
	{
		MainView mainview = new MainView();
		mainview.setVisible(true);
		
		EditControl edit = new EditControl();
		edit.control(mainview);
		
		FileController file = new FileController();
		file.controller(mainview);
	}
}