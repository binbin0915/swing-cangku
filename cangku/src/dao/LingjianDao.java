package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import database.DbUtil;
import entity.Lingjian;

public class LingjianDao {
	/**
	 * ���һ���µ����
	 * @param bgy
	 */
	public void add(Lingjian lj){
		Connection conn=DbUtil.getDbutil().getConnection();
		String sql = "insert into lingjian values(?,?)";
		PreparedStatement pstmt =null;
		try {
			pstmt= conn.prepareStatement(sql);
			pstmt.setString(1, lj.getLjnum());
			pstmt.setString(2, lj.getLjname());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			if(pstmt!=null){
				try {
					pstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(conn!=null){
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	/**
	 * ͨ��idɾ��
	 * @param bgy
	 */
	public void deleteById(Lingjian lj){
		String sql="delete from lingjian where ljnum=?";
		PreparedStatement pstmt=null;
		Connection conn=null;
		conn=DbUtil.getDbutil().getConnection();
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, lj.getLjnum());
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally{
			if(pstmt!=null){
				try {
					pstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(conn!=null){
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	/**
	 * ͨ������ɾ��
	 * @param bgy
	 */
	public void deleteByName(Lingjian lj){
		String sql="delete from lingjian where ljname=?";
		PreparedStatement pstmt=null;
		Connection conn=null;
		conn=DbUtil.getDbutil().getConnection();
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, lj.getLjname());
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally{
			if(pstmt!=null){
				try {
					pstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(conn!=null){
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	/**
	 * ��������ѯ�������
	 * @return
	 */
	public ArrayList<Lingjian> findAll(){
		String sql="select * from lingjian";
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		conn=DbUtil.getDbutil().getConnection();
		ArrayList<Lingjian> list=new ArrayList<Lingjian>();
		try {
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next()){
				Lingjian temp=new Lingjian();
				temp.setLjnum(rs.getString("ljnum"));
				temp.setLjname(rs.getString("ljname"));
				list.add(temp);
			}
		} catch (SQLException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		finally{
			if(rs!=null){
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO �Զ����ɵ� catch ��
					e.printStackTrace();
				}
			}
			if(pstmt!=null){
				try {
					pstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(conn!=null){
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return list;
	}
	/**
	 * ͨ��id�����
	 * @param bgy
	 * @return
	 */
	public Lingjian findById(Lingjian lj){
		String sql="select * from lingjian where ljnum=?";
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		conn=DbUtil.getDbutil().getConnection();
		Lingjian t = null;
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1,lj.getLjnum());
			rs=pstmt.executeQuery();
			t=new Lingjian();
			if(rs.next()){
				t.setLjnum(rs.getString("ljnum"));
				t.setLjname(rs.getString("ljname"));
			}
		} catch (SQLException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		finally{
			if(rs!=null){
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO �Զ����ɵ� catch ��
					e.printStackTrace();
				}
			}
			if(pstmt!=null){
				try {
					pstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(conn!=null){
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return t;
	}
	/**
	 * ͨ�����������
	 * @param bgy
	 * @return
	 */
	public Lingjian findByName(Lingjian lj){
		String sql="select * from lingjian where ljname=?";
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		conn=DbUtil.getDbutil().getConnection();
		Lingjian t = null;
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1,lj.getLjname());
			rs=pstmt.executeQuery();
			t=new Lingjian();
			if(rs.next()){
				t.setLjnum(rs.getString("ljnum"));
				t.setLjname(rs.getString("ljname"));
			}
		} catch (SQLException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		finally{
			if(rs!=null){
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO �Զ����ɵ� catch ��
					e.printStackTrace();
				}
			}
			if(pstmt!=null){
				try {
					pstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(conn!=null){
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return t;
	}
	
}
