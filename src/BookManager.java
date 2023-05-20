import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.ListResourceBundle;
import java.util.Scanner;



public class BookManager {
	static Scanner sc = new Scanner(System.in);
	
	
	public static void hienThiDanhSach(ArrayList<Book> arr) {
//		Collections.sort(arr, new Comparator<Book>() {
//			@Override
//			public int compare(Book o1, Book o2) {
//				return o1.getTheLoai().compareTo(o2.getTheLoai());
//			}
//		});
		ArrayList<Book> listBook = new ArrayList<Book>();
		listBook = (ArrayList<Book>) arr.clone();
		Collections.sort(listBook);
		System.out.format("%-10s%-50s%-40s%-45s%-10s\n", "Mã sách", "Tên sách", "Tác giả", "Thể loại", "Năm xuất bản");
		for(Book b: listBook) {
			b.hienThiDinhDang();
		}
	}
	public static void nhapSachMoi(ArrayList<Book> arr) {
		Book bok = new Book();
		System.out.println("Nhập mã sách: ");
		String maSachMoi = sc.nextLine();
		bok.setMaSach(maSachMoi);
		boolean kq  = arr.contains(bok);
		if(kq ==false) {
			System.out.println("Nhập tên sách: ");
			String tenSachMoi = sc.nextLine();
			System.out.println("Nhập thể loại sách: ");
			String theLoaiSachMoi = sc.nextLine();
			System.out.println("Nhập tên tác giả: ");
			String tenTacGiaMoi = sc.nextLine();
			System.out.println("Nhập năm xuất bản: ");
			int namXuatBanMoi = sc.nextInt();
			bok.setMaSach(maSachMoi);
			bok.setTenSach(tenSachMoi);
			bok.setTenTacGia(tenTacGiaMoi);
			bok.setTheLoai(theLoaiSachMoi);
			bok.setNamXuatBan(namXuatBanMoi);
			arr.add(bok);
		}
		else {
			System.out.println("Mã sách đã tồn tại: ");
			System.out.println("Yêu cầu nhập lại: ");
			nhapSachMoi(arr);
		}
	}

	public static void xoaSachTheoMa(ArrayList<Book> arr) {
		System.out.println("Nhập mã sách muốn xóa: ");
		String maSachXoa = sc.nextLine();
		Book bok = new Book();
		bok.setMaSach(maSachXoa);
		boolean kq  = arr.contains(bok);
		if(kq ==true) {
			arr.remove(bok);
		}
		else {
			System.out.println("Không tồn tại mã sách cần xóa: ");
			System.out.println("Yêu cầu nhập lại: ");
			xoaSachTheoMa(arr);
		}
	}
	public static void timTheoMaSach(ArrayList<Book> arr) {
		System.out.println("Nhập mã sách muốn tìm: ");
		String maSachTim = sc.nextLine();
		Book bok = new Book();
		bok.setMaSach(maSachTim);
		boolean kq  = arr.contains(bok);
		if(kq ==true) {
			System.out.println("Thông tin sách muốn tìm là: ");
			System.out.format("%-10s%-50s%-40s%-45s%-10s\n", "Mã sách", "Tên sách", "Tác giả", "Thể loại", "Năm xuất bản");
			for (Book x : arr) {
				if (x.getMaSach().equalsIgnoreCase(maSachTim)) {
					x.hienThiDinhDang();
					break;
				}
			}	
		}
		else {
			System.out.println("Không tồn tại mã sách muốn tìm: ");
		}
	}
	public static void timTheoTacGia(ArrayList<Book> arr) {
		System.out.println("Nhập tên tác giả muốn tìm: ");
		String tacGiaTim = sc.nextLine();
		boolean flag = false;
		for (Book x : arr) {
			if (x.getTenTacGia().equalsIgnoreCase(tacGiaTim)) {
				flag = true;
				break;
			}
		}
		if (flag) {
			System.out.println("Thông tin các cuốn sách được tác giả " + tacGiaTim+" viết là: ");
			System.out.format("%-10s%-50s%-40s%-45s%-10s\n", "Mã sách", "Tên sách", "Tác giả", "Thể loại", "Năm xuất bản");
			for (Book x : arr) {
				if (x.getTenTacGia().equalsIgnoreCase(tacGiaTim)) {
					x.hienThiDinhDang();
				}
			}
		} else {
			System.out.println("Không có sách của tác giả " +tacGiaTim);
		}
	}
	public static void timTheoTenSach(ArrayList<Book> arr) {
		System.out.println("Nhập tên sách muốn tìm: ");
		String tenSachTim = sc.nextLine();
		boolean flag = false;
		for (Book x : arr) {
			if (x.getTenSach().equalsIgnoreCase(tenSachTim)) {
				flag = true;
				break;
			}
		}
		if (flag) {
			System.out.println("Thông tin các cuốn sách có tên là " + tenSachTim);
			System.out.format("%-10s%-50s%-40s%-45s%-10s\n", "Mã sách", "Tên sách", "Tác giả", "Thể loại", "Năm xuất bản");
			for (Book x : arr) {
				if (x.getTenSach().equalsIgnoreCase(tenSachTim)) {
					x.hienThiDinhDang();
				}
			}
		} else {
			System.out.println("Không có sách nào tên là " +tenSachTim);
		}
	}
}
