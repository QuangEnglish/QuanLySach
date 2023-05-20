import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;


public class Main {
	public static String rootDir = "D://Java//JavaDevPro";
	public static void main(String[] args) {
		DataIO.rootDir = rootDir;
		ArrayList<Book> dataList = new ArrayList<>();
		DataIO.readData(dataList);

		while(true) {
			System.out.println("-------------------Menu-----------------");
			System.out.println("1.Hiển thị danh sách(xếp theo thể loại: ");
			System.out.println("2.Nhập thông tin cho các cuốn sách mới: ");
			System.out.println("3.Xóa một cuốn sách theo mã sách: ");
			System.out.println("4.Tra cứu thông tin cuốn sách dựa trên mã sách: ");
			System.out.println("5.Tìm kiếm sách dựa theo tên tác giả: ");
			System.out.println("6.Tìm kiếm sách dựa theo tên sách: ");
			System.out.println("0.Kết thúc và lưu chương trình! ");
			Scanner sc = new Scanner(System.in);
			try {
				System.out.println("Nhập lựa chọn: ");
				int luaChon = sc.nextInt();
				switch(luaChon) {
				case 1:
					System.out.println("======================Danh sách các sách là:=============================== ");	
					BookManager.hienThiDanhSach(dataList);
					break;
				case 2:
					System.out.println("Nhập thông tin cho cuốn sách: ");
					BookManager.nhapSachMoi(dataList);
					BookManager.hienThiDanhSach(dataList);
					
					break;
				case 3: 
					BookManager.xoaSachTheoMa(dataList);
					System.out.println("======================Danh sách sau khi xóa là: ===============================");
					BookManager.hienThiDanhSach(dataList);
					break;
				case 4:
					BookManager.timTheoMaSach(dataList);
					break;
				case 5:
					BookManager.timTheoTacGia(dataList);
					break;
				case 6:
					BookManager.timTheoTenSach(dataList);
					break;
				case 0:
					DataIO.saveData(dataList);
					System.exit(1);
					break;
				default :
					System.out.println("Bạn nhập sai. Yêu cầu nhập lại!");	
					break;
				}
			}catch(Exception e) {
				System.out.println("Yêu cầu nhập lại!");
			}
		}
	}
}
