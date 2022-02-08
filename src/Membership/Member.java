package Membership;

public class Member {
	private long id;
	private String name = "(none)";
	private int mileage;
	public Member(long id, String name, int mileage) {this.id = id; this.name = name; this.mileage = mileage;}
	public Member(long id, String name) {this.id = id; this.name = name;}
	public Member(long id, int mileage) {this.id = id; this.mileage = mileage;}
	public Member(long id) {this.id = id;}
	public long getId() {return id;}
	public void set(long id) {this.id = id;}
	public void set(String name) {this.name = name;}
	public void set(int mileage) {this.mileage = mileage;}
	public String toString() {return (id + "\t" + name + "\t" + mileage);}
}
