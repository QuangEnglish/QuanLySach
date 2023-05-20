import java.util.ArrayList;
import java.util.Scanner;


public class Book implements Comparable<Book>{
	private String maSach, tenSach, theLoai, tenTacGia;
	private int namXuatBan;
	
	public Book() {
	}

	public Book(String maSach, String tenSach, String tenTacGia, String theLoai, int namXB) {
		this.maSach = maSach;
		this.tenSach = tenSach;
		this.tenTacGia = tenTacGia;
		this.theLoai = theLoai;
		namXuatBan = namXB;
	}
	public String getMaSach() {
		return maSach;
	}

	public void setMaSach(String maSach) {
		this.maSach = maSach;
	}

	public String getTenSach() {
		return tenSach;
	}

	public void setTenSach(String tenSach) {
		this.tenSach = tenSach;
	}
	public String getTenTacGia() {
		return tenTacGia;
	}
	
	public void setTenTacGia(String tenTacGia) {
		this.tenTacGia = tenTacGia;
	}

	public String getTheLoai() {
		return theLoai;
	}

	public void setTheLoai(String theLoai) {
		this.theLoai = theLoai;
	}


	public int getNamXuatBan() {
		return namXuatBan;
	}

	public void setNamXuatBan(int namXuatBan) {
		this.namXuatBan = namXuatBan;
	}
	public void hienThiDinhDang() {
			if(this.tenSach.length() > 50 ) {
				System.out.format("%-10s%-50s%-40s%-45s%-10s\n", maSach ,tenSach.substring(0, tenSach.indexOf(" ", 40)) , tenTacGia,theLoai , namXuatBan);
				System.out.format("\t "+tenSach.substring(tenSach.indexOf(" ", 40), tenSach.length())+ "\n");
			} else {
				System.out.format("%-10s%-50s%-40s%-45s%-10s\n", maSach,  tenSach,tenTacGia, theLoai, namXuatBan);
			}
	}
	
	@Override
	public String toString() {
			return	this.maSach + ";" + this.tenSach + ";" + this.tenTacGia + ";" + this.theLoai + ";" + this.namXuatBan;
	}
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Book) {
		Book bok = (Book) obj;
		boolean kq = bok.getMaSach().equals(this.getMaSach());
		return kq;
	}
		return super.equals(obj);
	}
	@Override
	public int compareTo(Book o) {
		return this.theLoai.compareToIgnoreCase(o.theLoai);
	}
	
}

//if(this.tenSach.length() > 50 ) {
//	System.out.format("%-10s%-50s%-40s%-45s%-10s\n", maSach ,tenSach.substring(0, b.getTenSach().indexOf(" ", 40)) , b.getTenTacGia(), b.getTheLoai(), b.getNamXuatBan());
//	System.out.format("\t "+ b.getTenSach().substring(b.getTenSach().indexOf(" ", 40), b.getTenSach().length())+ "\n");
//} else {
//	System.out.format("%-10s%-50s%-40s%-45s%-10s\n", b.getMaSach(), b.getTenSach(), b.getTenTacGia(), b.getTheLoai(), b.getNamXuatBan());
//}