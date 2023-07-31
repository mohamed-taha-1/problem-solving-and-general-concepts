package designPatterns.singleton;

public class Demo {
	
	public static void main(String[] args) {
		var orderManagService1 = OrderManagementService.getInstance();
		var orderManagService2 = OrderManagementService.getInstance();
		
//		var orderManagService3 = new OrderManagementService();
		
		System.out.println(orderManagService1 == orderManagService2); // true
		orderManagService1.placeOrder();
	}

}