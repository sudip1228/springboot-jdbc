package jdbc;

import java.sql.ResultSet;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class personjdbcdao  {
	@Autowired
	JdbcTemplate j;
	
	class personrowmapper implements RowMapper<person>
	{

		public person mapRow(ResultSet rs, int rowNum) throws SQLException {
			//here we are mapping manually.it is optional. we are using this mapping instead of new BeanPropertyRowMapper<person>(person.class))
			person p=new person();
			p.setId(rs.getInt("id"));//here setid is mapped to name "id".
			p.setName(rs.getString("name"));//here name setname mapped or means "name" .similarly,the following mapping is done with sql.
			p.setLocation(rs.getString("location"));
			p.setDate(rs.getTimestamp("birthdate"));
			
			return p;
		}
		
	}
	//select * from person
	/*
	public List<person> findall(){//shows all columns
		return j.query("select * from person", new BeanPropertyRowMapper<person>(person.class));//rowmappper helps to map to sql.
	}*/
	
	public List<person> findall(){//shows all columns
		return j.query("select * from person", new personrowmapper());//rowmappper helps to map to sql.
	}
		public person findbyid(int id){//shows rows with specific id.
			return j.queryForObject("select * from person where id=? ", new Object[] {id},new BeanPropertyRowMapper<person>(person.class));
		
	}
		
		public int insert(person p){//shows rows with specific id.
			return j.update(" insert into person (id,name,location,birthdate) "+ " values(?,?,?,?) ", new Object[] {p.getId(),p.getName(),p.getLocation(),new Timestamp(p.getDate().getTime())});
		
	}
		
		public int update(person p){//shows rows with specific id.
			return j.update(" update person"+ " set name=?,location=?,birthdate=?"+" where id=? ", new Object[] {p.getName(),p.getLocation(),new Timestamp(p.getDate().getTime()),p.getId()});
		
	}
		/*
		public  int deletebyid(int id){//shows rows with specific id.
			return j.update("delete  from person where id=?", new Object[] {id});
		
	}*/
		
	
}
