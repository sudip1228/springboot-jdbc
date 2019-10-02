package jdbc;

import java.util.Date;

public class person {

private int id;
private String name;
private String location;
private Date birthdate;

public person() {
	
}

public person(int id, String name, String location, Date birthdate) {
	super();
	this.id = id;
	this.name = name;
	this.location = location;
	this.birthdate = birthdate;
}

public person( String name, String location, Date birthdate) {//with hybernate there is no need of primary key as a argument.
	super();
	
	this.name = name;
	this.location = location;
	this.birthdate = birthdate;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getLocation() {
	return location;
}
public void setLocation(String location) {
	this.location = location;
}
public Date getDate() {
	return birthdate;
}
public void setDate(Date date) {
	this.birthdate = date;
}
@Override
public String toString() {
	return String.format( "\nperson [id=%s, name=%s, location=%s,birthdate=%s]",id,name,location,birthdate);
}



	
}
