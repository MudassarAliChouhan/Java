package controller;

import view.MainView;
import view.FontView;
import java.awt.GraphicsEnvironment;

public class FontController
{
	public void controller(MainView mainview,FontView fontview)
	{
		setupFontView(fontview);
		setupFont(mainview,fontview);
		btnOk(mainview,fontview);
	}
	public void changeFamily(MainView mainview,FontView fontview)
	{
		fontview.getListFamily().addListSelectionListener(new javax.swing.event.ListSelectionListener(){
			public void valueChanged(javax.swing.event.ListSelectionEvent e)
			{
				fontview.getTxtFamily().setText(fontview.getListFamily().getSelectedValue());
				
				String family = fontview.getListFamily().getSelectedValue();
				int style = fontview.getListStyle().getSelectedIndex();
				int size = Integer.parseInt(fontview.getTxtSize().getText());
				
				mainview.getTxtArea().setFont(new java.awt.Font(family,style,size));
				fontview.getReview().setFont(new java.awt.Font(family,style,size));
			}
		});
	}
	public void changeStyle(MainView mainview,FontView fontview)
	{
		fontview.getListStyle().addListSelectionListener(new javax.swing.event.ListSelectionListener(){
			public void valueChanged(javax.swing.event.ListSelectionEvent e)
			{
				fontview.getTxtStyle().setText(fontview.getListStyle().getSelectedValue());
				
				String family = fontview.getListFamily().getSelectedValue();
				int style = fontview.getListStyle().getSelectedIndex();
				int size = Integer.parseInt(fontview.getTxtSize().getText());
				
				mainview.getTxtArea().setFont(new java.awt.Font(family,style,size));
				fontview.getReview().setFont(new java.awt.Font(family,style,size));
			}
		});
	}
	public void changeSize(MainView mainview,FontView fontview)
	{
		fontview.getListSize().addListSelectionListener(new javax.swing.event.ListSelectionListener(){
			public void valueChanged(javax.swing.event.ListSelectionEvent e)
			{
				fontview.getTxtSize().setText(fontview.getListSize().getSelectedValue());
				
				String family = fontview.getListFamily().getSelectedValue();
				int style = fontview.getListStyle().getSelectedIndex();
				int size = Integer.parseInt(fontview.getTxtSize().getText());
				
				mainview.getTxtArea().setFont(new java.awt.Font(family,style,size));
				fontview.getReview().setFont(new java.awt.Font(family,style,size));
			}
		});
	}
	private void setupFontView(FontView fontview)
	{
		String []family = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
		fontview.getListFamily().setListData(family);
		
		String []styles = {"Regular","Bold","Italic","Bold Italic"};
		fontview.getListStyle().setListData(styles);
		
		String []font = {"8","9","10","11","12","14","16","18","20","22","24","36","40","72"};
		fontview.getListSize().setListData(font);
	}
	private void setupFont(MainView mainview,FontView fontview)
	{
		String family = mainview.getTxtArea().getFont().getFamily();
		int style = mainview.getTxtArea().getFont().getStyle();
		int size = mainview.getTxtArea().getFont().getSize();
		mainview.getTxtArea().setFont(new java.awt.Font(family,style,size));
		
		fontview.getListFamily().setSelectedValue(family,true);
		fontview.getListStyle().setSelectedIndex(style);
		fontview.getListSize().setSelectedValue(Integer.toString(size),true);
		
		fontview.getTxtFamily().setText(family);
		fontview.getTxtStyle().setText(fontview.getListStyle().getSelectedValue());
		fontview.getTxtSize().setText(Integer.toString(size));
	}
	private void btnOk(MainView mainview,FontView fontview)
	{
		fontview.getBtnOk().addActionListener(new java.awt.event.ActionListener(){
			public void actionPerformed(java.awt.event.ActionEvent e)
			{
				String family = fontview.getListFamily().getSelectedValue();
				int style = fontview.getListStyle().getSelectedIndex();
				int size = Integer.parseInt(fontview.getTxtSize().getText());
				
				mainview.getTxtArea().setFont(new java.awt.Font(family,style,size));
				
				fontview.setVisible(false);
			}
		});
	}
}