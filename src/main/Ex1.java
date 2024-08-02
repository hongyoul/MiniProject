package main;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Ex1 {

	public static void main(String[] args) throws IOException {

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
		
			
			if (num == 1) {			
				System.out.println("고객명: ");
				String clienteleName = scanner.nextLine();
				fullHistoy.write(clienteleName);
				fullHistoy.flush();
				clienteleName += "\n";
				
				System.out.println("제품명: ");
				String productName = scanner.nextLine();
				
				System.out.println("제품의 수량: ");
				int productNumber = scanner.nextInt();
				
				System.out.println("제품의 가격: ");
				int productPrice = scanner.nextInt();
				
			} else if (num == 2) {
				
				
			} else if (num == 3) {
				
			} else if (num == 4) {
				
				continue;
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

	String clienteleName;
	String productName;
	int productNumber;
	int productPrice;

	public ShoppingList(String clienteleName, String productName, int productNumber, int productPrice) {
		super();
		this.clienteleName = clienteleName;
		this.productName = productName;
		this.productNumber = productNumber;
		this.productPrice = productPrice;
	}
}


