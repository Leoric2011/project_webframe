package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Model.News;

public class NewsDao {
	
	//��������id����ѯ����Ӧ��news����
	public News getNews(Connection con,String news_id) throws SQLException{
		
	        String sqlFind="select * from news_content where new_id = "+news_id;
	        PreparedStatement ps=con.prepareStatement(sqlFind);//
	        ResultSet rs=ps.executeQuery();
	        if(rs.next()){
	        	
	        	News news = new News();
	        	news.setCompany_name(rs.getString("company_name"));
	        	news.setNew_content(rs.getString("new_content"));
	        	news.setNew_date(rs.getString("new_date"));
	        	news.setNew_title(rs.getString("new_title"));
	        	
	        	return  news;
	        	
	        }else{
	        	return null;
	        }
		
	}

}
