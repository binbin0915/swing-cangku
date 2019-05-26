package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import database.DbUtil;
import entity.Cangku;

public class CangkuDao {
	/**
	 * ���һ���µĲֿ�
	 * @param bgy
	 */
	public void add(Cangku ck){
		Connection conn=DbUtil.getDbutil().getConnection();
		String sql = "insert into cangku values(?,?)";
		PreparedStatement pstmt =null;
		try {
			pstmt= conn.prepareStatement(sql);
			pstmt.setString(1, ck.getCknum());
			pstmt.setString(2, ck.getCkname());
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
	public void deleteById(Cangku ck){
		String sql="delete from cangku where cknum=?";
		PreparedStatement pstmt=null;
		Connection conn=null;
		conn=DbUtil.getDbutil().getConnection();
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, ck.getCknum());
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
	public void deleteByName(Cangku ck){
		String sql="delete from cangku where ckname=?";
		PreparedStatement pstmt=null;
		Connection conn=null;
		conn=DbUtil.getDbutil().getConnection();
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, ck.getCkname());
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
	 * ��������ѯ���вֿ�
	 * @return
	 */
	public ArrayList<Cangku> findAll(){
		String sql="select * from cangku";
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		conn=DbUtil.getDbutil().getConnection();
		ArrayList<Cangku> list=new ArrayList<Cangku>();
		try {
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next()){
				Cangku temp=new Cangku();
				temp.setCknum(rs.getString("cknum"));
				temp.setCkname(rs.getString("ckname"));
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
	 * ͨ��id�Ҳֿ�
	 * @param bgy
	 * @return
	 */
	public Cangku findById(Cangku ck){
		String sql="select * from cangku where cknum=?";
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		conn=DbUtil.getDbutil().getConnection();
		Cangku t = null;
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1,ck.getCknum());
			rs=pstmt.executeQuery();
			t=new Cangku();
			if(rs.next()){
				t.setCknum(rs.getString("cknum"));
				t.setCkname(rs.getString("ckname"));
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
	 * ͨ�������Ҳֿ�
	 * @param bgy
	 * @return
	 */
	public Cangku findByName(Cangku ck){
		String sql="select * from cangku where ckname=?";
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		conn=DbUtil.getDbutil().getConnection();
		Cangku t = null;
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1,ck.getCkname());
			rs=pstmt.executeQuery();
			t=new Cangku();
			if(rs.next()){
				t.setCknum(rs.getString("cknum"));
				t.setCkname(rs.getString("ckname"));
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
