package view;
import java.awt.*;

import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.util.*;

import javax.swing.table.*;

import dao.BGYDao;
import entity.Baoguanyuan;

class ShowBGY extends Frame
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	AbstractTableModel tm;		//����һ����AbstractTableModel����
	JTable table;				//����һ����JTable����
	JScrollPane scrollpane;		//����һ������������
	String titles[];			//��ά������
	Vector records;				//����һ����������

	public void init(){
		records = new Vector();	//ʵ��������
		tm = new AbstractTableModel(){
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;
			public int getColumnCount(){
				return titles.length;	//ȡ�ñ������
			}
			public int getRowCount(){
				return records.size();		//ȡ�ñ������
			}
			public Object getValueAt(int row,int column){
				if(!records.isEmpty())		//ȡ�õ�Ԫ���е�����ֵ
					return ((Vector)records.elementAt(row)).elementAt(column);
				else
					return null;
			}
			public String getColumnName(int column){
				return titles[column];	//���ñ������
			}
			public void setValueAt(Object value,int row,int column){
					//����ģ�Ͳ��ɱ༭���÷�������Ϊ��
			}
			public Class getColumnClass(int c){
				return getValueAt(0,c).getClass();	//ȡ��������������
			}
			public boolean isCellEditable(int row,int column){
				return false;//���õ�Ԫ�񲻿ɱ༭��Ϊȱʡʵ��
			}
		};
	}

	public void start() throws SQLException, ClassNotFoundException{
		titles = new String[]{"����Ա��","����Ա��","�������ֿ��"};
		BGYDao dao= new BGYDao();
		records.removeAllElements();//��ʼ����������
		Vector<String> vtemp ;
			ArrayList<Baoguanyuan> temp = dao.findAll();
			for(Baoguanyuan s:temp){
				vtemp= new Vector<String>();
				vtemp.add(s.getBaonum());
				vtemp.add(s.getBaoname());
				vtemp.add(s.getCknum());
				records.add(vtemp);
			}
		
		
		//���Ʊ�� 
		table=new JTable(tm);	//�����Լ�������ģ��
		table.setToolTipText("��ʾȫ����ѯ���");	//���ð�����ʾ
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);	//���ñ������ߴ�ģʽ
		table.setCellSelectionEnabled(false);	//���õ�Ԫ��ѡ��ʽ
		table.setShowVerticalLines(true);
		table.setShowHorizontalLines(true);
		scrollpane=new JScrollPane(table);		//�������Ϲ�����
		add( scrollpane );

		tm.fireTableStructureChanged();//���±��
	}
	public void doshow(){
		ShowBGY f = new ShowBGY();
		
		try{
			f.init();
			f.start();
		}catch( Exception e){ e.printStackTrace(); }
		f.setSize( 400,300);
		f.setTitle( "Show Database in JTable" );
		f.show();
	}
	
}