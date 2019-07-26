package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Controler.FindNewsListServlet;
import Model.NewsList;
import Util.DbUtil;

public class NewsListDao {
    
    //��ѯ�����ϵĹ�˾�����б�
	public ArrayList<NewsList> FindNewsList(Connection con,String Company_name) throws SQLException{
        
		//����һ���ַ���������󴢴����ű���
		ArrayList<NewsList> resultNewsList= new ArrayList<NewsList>();
        String sqlFind="select * from news_list where company_name='"+Company_name+"'";
        PreparedStatement ps=con.prepareStatement(sqlFind);//
       // ps.setString(1, Company_name);
        ResultSet rs=ps.executeQuery();
        int i = 0;
        while(rs.next()){
        	NewsList new_list = new NewsList(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getInt(5));
        	resultNewsList.add(new_list);
        	
        	
        }
        return resultNewsList;
    }
    
}