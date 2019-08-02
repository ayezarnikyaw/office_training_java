public class Student {
	private	String nrc;
	private	String name;
	private	String gender;
	private	String fatherName;
	private	String addr;
	private	String phone;
	
	public Student(String nrc,String name,String gender,String phone,String fn,String addr) {
		this.nrc=nrc;
		this.name=name;
		this.gender=gender;
		this.fatherName=fn;
		this.addr=addr;
		this.phone=phone;
	}
	public void setNrc(String rno)
	{
		this.nrc=rno;
	}
	public void setName(String name)
	{
		this.name=name;
	}
	public void setPh(String phno)
	{
		this.phone=phno;
	}
	public void setFather(String f)
	{
		this.fatherName=f;
	}
	public void setAddr(String addr) {
		this.addr=addr;		
	}
	public void setGender(String g) {
		this.gender=g;		
	}
	public String getNrc()
	{
		return nrc;
	}
	public String getName()
	{
		return name;
	}
	public String getPh()
	{
		return phone;
	}
	public String getFather()
	{
		return fatherName;
	}
	public String getAddr()
	{
		return addr;
	}
	public String getGender()
	{
		return gender;
	}
}
