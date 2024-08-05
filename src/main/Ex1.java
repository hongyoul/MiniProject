package main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Ex1 {

	public static void main(String[] args) throws IOException {
		
		ShoppingList.OrderCommodity();
		
		Scanner scanner = new Scanner(System.in);
		
		while (true) {

		System.out.println("1. 상품 주문하기");
		System.out.println("2. 전체 주문 이력 보기");
		System.out.println("3. 고객별 주문 이력 보기");
		System.out.println("4. 특정날짜에 들어온 주문이력 보기");
		System.out.println("5. 끝내기");
		System.out.println("옵션을 선택하세요: ");

		int num = scanner.nextInt();
		scanner.nextLine();
		
			
		FileWriter fullHistoy = new FileWriter("order.txt", true);
		FileReader commodity =new FileReader("order.txt");
		
		
					
			if (num == 1) {	
				
				ShoppingList shoppingList = new ShoppingList();
				fullHistoy.write("주문번호: "+ shoppingList.orderNumB + ", ");
			
				
				System.out.print("고객명: ");
				String clienteleName = scanner.nextLine();
				fullHistoy.write("고객명: "+clienteleName+ ", ");


				System.out.print("제품명: ");
				String productName = scanner.nextLine();
				fullHistoy.write("제품명: "+productName+", ");

				
				System.out.print("제품의 수량: ");
				int productNumber = scanner.nextInt();
				fullHistoy.write("제품의 수량: "+productNumber+", ");
				
				
				System.out.print("제품의 가격: ");
				int productPrice = scanner.nextInt();
				fullHistoy.write("제품의 가격: "+productPrice+", ");
				
				// 현재시간 가져오기
				LocalDateTime curDateTime = LocalDateTime.now();
				// 날짜를 특정포맷으로 출력하기
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
				String formatDate = curDateTime.format(formatter);
				fullHistoy.write("주문일시 : "+formatDate+ "\n");
				System.out.println();
				
				fullHistoy.flush();
				fullHistoy.close();
				
			} else if (num == 2) {
				String FILE_NAME ="order.txt";
				FileReader fr = new FileReader(FILE_NAME);
				BufferedReader br = new BufferedReader(fr);

				while (true) {
					String line = br.readLine();
					if (line == null) {
						break;
					}
					System.out.println(line);
				}
				
			} else if (num == 3) {
				System.out.println("고객명을 작성해 주세요: ");

				String orderCommodity =scanner.nextLine();
				ShoppingList.OrderName(orderCommodity.trim());
				
			} else if (num == 4) {
				String FILE_NAME ="order.txt";
				FileReader fr = new FileReader(FILE_NAME);
				BufferedReader br = new BufferedReader(fr);
				
				System.out.println("날짜: " );
				String date = scanner.nextLine();
				
				while (true) {
					String line = br.readLine();
					
					if (line == null) {
						break;
					}else if (line.contains(date)) {
						System.out.println(line);
						}
					}
				
				} else if (num == 5) {
				System.out.println("프로그램을 종료 합니다...");
				break;
			} else {
				System.out.println("옵션을 잘못 선택하였습니다.");
			}
			 		
		}
	}
}

class ShoppingList {

	static int orderNumB = 0;
	
	public ShoppingList() {
		orderNumB++;
	}
	public static void OrderCommodity() throws IOException {
		FileReader fileReader = new FileReader("order.txt");
		BufferedReader bufferedReader = new BufferedReader(fileReader);
		
		int countNumber = 0;
		
		while (true) {
			String fr = bufferedReader.readLine(); 
			
			if (fr == null) {
				break;
			} 
			String[] cut = fr.split(", ");
			
			for (int i = 0; i < cut.length; i++) {
				String st = cut[i];
				
				if (st.startsWith("주문번호: ")) {
					String[] numCut = st.split(": ");
					countNumber = Integer.parseInt(numCut[1]);
				}
				
			}
		}
		orderNumB = countNumber;
		
	}		
	public static void OrderName(String name) throws IOException {
		FileReader fileReader = new FileReader("order.txt");
		BufferedReader bufferedReader = new BufferedReader(fileReader);
		
		int clienteleName = 0;
		int productNumber = 0;
		int productPrice = 0;
		
		while (true) {
			String fr = bufferedReader.readLine(); 
			
			if (fr == null) {
				break;
			}
			if (fr.contains(name)) {
				String[] CommodityName = fr.split(", ");
				
				for (int i = 0; i < CommodityName.length; i++) {
					String string = CommodityName[i];
				
					
					
					
 					
					
					if (string.startsWith("고객명: ")) {
					String[] string1 = string.split(": ");
					
					if (name.equals(string1[1])) {
						clienteleName++;
						}
					}
						
					
					if (string.startsWith("제품의 수량: ")) {
						String[] string2 = string.split(": ");
						
						int numberProd = Integer.parseInt(string2[1]);
						
						productNumber = numberProd;
					}
					
					
					if (string.startsWith("제품의 가격: ")) {
						String[] string3 = string.split(": ");
						
						// 수량*가격 선언
						
					int	price = Integer.parseInt(string3[1]);
					
					productPrice = productPrice + price * productNumber;
					
					}
				}
			}
		}
		System.out.println("전체 주문 건수: " + clienteleName);
		System.out.println("전체 주문 금액: " + productPrice);
	}
}


	