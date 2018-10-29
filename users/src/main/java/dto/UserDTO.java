package dto;

import java.util.Date;

public class UserDTO {
	private String u_id;
	private String u_name;
	private String u_mail;
	private String u_nick;
	private Date u_day;
	
	public UserDTO() {
	}

	public String getU_id() {
		return u_id;
	}

	public void setU_id(String u_id) {
		this.u_id = u_id;
	}

	public String getU_name() {
		return u_name;
	}

	public void setU_name(String u_name) {
		this.u_name = u_name;
	}

	public String getU_mail() {
		return u_mail;
	}

	public void setU_mail(String u_mail) {
		this.u_mail = u_mail;
	}

	public String getU_nick() {
		return u_nick;
	}

	public void setU_nick(String u_nick) {
		this.u_nick = u_nick;
	}

	public Date getU_day() {
		return u_day;
	}

	public void setU_day(Date u_day) {
		this.u_day = u_day;
	}
	
	
	
}
