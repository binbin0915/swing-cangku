package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import database.DbUtil;
import entity.Baoguanyuan;
import entity.Cangku;

public class BGYDao {
	/**
	 * ���һ���µı���Ա
	 * @param bgy
	 */
	public void add(Baoguanyuan bgy){
		Connection conn=DbUtil.getDbutil().getConnection();
		String sql = "insert into baoguanyuan values(?,?,?)";
		PreparedStatement pstmt =null;
		try {
			pstmt= conn.prepareStatement(sql);
			pstmt.setString(1, bgy.getBaonum());
			pstmt.setString(2, bgy.getBaoname());
			pstmt.setString(3, bgy.getCknum());
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
	public void deleteById(Baoguanyuan bgy){
		String sql="delete from baoguanyuan where baonum=?";
		PreparedStatement pstmt=null;
		Connection conn=null;
		conn=DbUtil.getDbutil().getConnection();
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, bgy.getBaonum());
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
	 * ��������ѯ���б���Ա
	 * @return
	 */
	public ArrayList<Baoguanyuan> findAll(){
		String sql="select * from baoguanyuan";
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		conn=DbUtil.getDbutil().getConnection();
		ArrayList<Baoguanyuan> list=new ArrayList<Baoguanyuan>();
		try {
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next()){
				Baoguanyuan temp=new Baoguanyuan();
				temp.setBaonum(rs.getString("baonum"));
				temp.setBaoname(rs.getString("baoname"));
				temp.setCknum(rs.getString("cknum"));
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
	 * ͨ��id�ұ���Ա
	 * @param bgy
	 * @return
	 */
	public Baoguanyuan findById(Baoguanyuan bgy){
		String sql="select * from baoguanyuan where baonum=?";
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		conn=DbUtil.getDbutil().getConnection();
		Baoguanyuan t = null;
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, bgy.getBaonum());
			rs=pstmt.executeQuery();
			t=new Baoguanyuan();
			if(rs.next()){
				t.setBaoname(rs.getString("baoname"));
				t.setBaonum(rs.getString("baonum"));
				t.setCknum(rs.getString("cknum"));
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
	 * ͨ���ֿ�id�ұ���Ա
	 * @param bgy
	 * @return
	 */
	public ArrayList<Baoguanyuan> findById(Cangku ck){
		String sql="select * from baoguanyuan where cknum=?";
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		conn=DbUtil.getDbutil().getConnection();
		ArrayList<Baoguanyuan> list=new ArrayList<Baoguanyuan>();
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, ck.getCknum());
			rs=pstmt.executeQuery();
			while(rs.next()){
				Baoguanyuan t=new Baoguanyuan();
				t.setBaoname(rs.getString("baoname"));
				t.setBaonum(rs.getString("baonum"));
				t.setCknum(rs.getString("cknum"));
				list.add(t);
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
	
}
