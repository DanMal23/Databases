package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "osdb")
public class OperSys {

	// mapping the fields to DB tables:
	@Id
	@Column(name = "osname")
	private String osname;

	@Column(name = "year")
	private int year;

	public OperSys() {
	}

	public OperSys(String osname, int year) {
		// super();
		this.osname = osname;
		this.year = year;
	}

	public String getOsname() {
		return osname;
	}

	public void setOsname(String osname) {
		this.osname = osname;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	@Override
	public String toString() {
		return "OperSys [osname=" + osname + ", year=" + year + "]";
	}

}
