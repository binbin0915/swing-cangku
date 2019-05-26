package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import database.DbUtil;
import entity.Baocun;
import entity.Baoguanyuan;
import entity.Lingjian;

public class BaocunDao {
	/**
	 * �ɲֿ������ı���Աִ��������
	 * ��ĳ���ֿ�����һ�����
	 * @param bgy
	 */
	public int add(Baoguanyuan bgy,Lingjian lj,int number){
		Connection conn = DbUtil.getDbutil().getConnection();
		PreparedStatement pstmt =null;
		int temp=0;
		try {
			conn.setAutoCommit(false);
			String sql = "set @ck=(select cknum from baoguanyuan where baonum=?)";
			pstmt= conn.prepareStatement(sql);
			pstmt.setString(1, bgy.getBaonum());
			pstmt.executeUpdate();
			sql="insert into baocun values(?,@ck,?)";
			pstmt= conn.prepareStatement(sql);
			pstmt.setString(1, lj.getLjnum());
			pstmt.setInt(2, number);
			temp=pstmt.executeUpdate();
			conn.commit(); 
		} catch (SQLException e) {
			// TODO �Զ����ɵ� catch ��
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
		return temp;
	}
	/**
	 * �ɲֿⱣ��Աִ��������
	 * ����,���ٲֿ���ĳ�����������
	 * @param bgy
	 * @param lj
	 * @param number
	 */
	public int update(Baoguanyuan bgy,Lingjian lj,int number){
		Connection conn = DbUtil.getDbutil().getConnection();
		PreparedStatement pstmt =null;
		int temp=0;
		try {
			conn.setAutoCommit(false);
			String sql = "set @ck=(select cknum from baoguanyuan where baonum=?)";
			pstmt= conn.prepareStatement(sql);
			pstmt.setString(1, bgy.getBaonum());
			pstmt.executeUpdate();
			sql="update baocun set ljsl=ljsl+? where ljnum=? and cknum=@ck";
			pstmt= conn.prepareStatement(sql);
			pstmt.setInt(1, number);
			pstmt.setString(2, lj.getLjnum());
			temp=pstmt.executeUpdate();
			conn.commit(); 
		} catch (SQLException e) {
			// TODO �Զ����ɵ� catch ��
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
		return temp;
	}
	
	/**
	 * ��������ѯ���вֿ��ڵ��������
	 * @return
	 */
	public ArrayList<Baocun> findAll(){
		String sql="select * from baocun";
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		conn=DbUtil.getDbutil().getConnection();
		ArrayList<Baocun> list=new ArrayList<Baocun>();
		try {
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next()){
				Baocun temp=new Baocun();
				temp.setCknum(rs.getString("cknum"));
				temp.setLjnum(rs.getString("ljnum"));
				temp.setLjsl(rs.getInt("ljsl"));
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
	 * ��ѯĳ������Ա����Ĳֿ����������
	 * @return
	 */
	public ArrayList<Baocun> findAllByBGY(Baoguanyuan bgy){
		Connection conn = DbUtil.getDbutil().getConnection();
		PreparedStatement pstmt =null;
		ResultSet rs=null;
		ArrayList<Baocun> list=new ArrayList<Baocun>();
		try {
			conn.setAutoCommit(false);
			String sql = "set @ck=(select cknum from baoguanyuan where baonum=?)";
			pstmt= conn.prepareStatement(sql);
			pstmt.setString(1, bgy.getBaonum());
			pstmt.executeUpdate();
			sql="select * from baocun where cknum=@ck";
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next()){
				Baocun temp=new Baocun();
				temp.setCknum(rs.getString("cknum"));
				temp.setLjnum(rs.getString("ljnum"));
				temp.setLjsl(rs.getInt("ljsl"));
				list.add(temp);
			}
			conn.commit(); 
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
	 * ͨ�������ѯ�����ڸ����ֿ��е�����
	 * @param lj
	 * @return
	 */
	public ArrayList<Baocun> findAllByLJ(Lingjian lj){
		Connection conn = DbUtil.getDbutil().getConnection();
		PreparedStatement pstmt =null;
		ResultSet rs=null;
		ArrayList<Baocun> list=new ArrayList<Baocun>();
		try {
			conn.setAutoCommit(false);
			String sql="select * from baocun where ljnum=?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, lj.getLjnum());
			rs=pstmt.executeQuery();
			while(rs.next()){
				Baocun temp=new Baocun();
				temp.setCknum(rs.getString("cknum"));
				temp.setLjnum(rs.getString("ljnum"));
				temp.setLjsl(rs.getInt("ljsl"));
				list.add(temp);
			}
			conn.commit(); 
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
	 * ��ѯĳ��ĳ���ֿ����ض��������Ϣ
	 * @return
	 */
	public Baocun findI(Baoguanyuan bgy,Lingjian lj){
		Connection conn = DbUtil.getDbutil().getConnection();
		PreparedStatement pstmt =null;
		ResultSet rs=null;
		Baocun temp=null;
		try {
			conn.setAutoCommit(false);
			String sql = "set @ck=(select cknum from baoguanyuan where baonum=?)";
			pstmt= conn.prepareStatement(sql);
			pstmt.setString(1, bgy.getBaonum());
			pstmt.executeUpdate();
			sql="select * from baocun where cknum=@ck and ljnum=?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, lj.getLjnum());
			rs=pstmt.executeQuery();
			if(rs.next()){
				temp=new Baocun();
				temp.setCknum(rs.getString("cknum"));
				temp.setLjnum(rs.getString("ljnum"));
				temp.setLjsl(rs.getInt("ljsl"));
				
			}
			conn.commit(); 
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
	
		return temp;
	}
	
}
