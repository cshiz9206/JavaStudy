package Arsenal;

import java.util.Random;

public class ItemCreator {
	Item[] items;
	
	public ItemCreator() {
		items = new Item[5];
		ItemFactory factory = new WeaponFactory();
		
		Random rd = new Random();
		for (int i = 0; i < 5; i++) {
			int rdn = rd.nextInt(3);
			// 추상 클래스 아이템 팩토리에서 정의된 프로세스 대로 item 생성, 배열에 저장
			items[i] = factory.newInstance(rdn);
			System.out.println(items[i].getName());
		}
		
		System.out.print("생성된 아이템은 ");
		for (int i = 0; i < 5; i++)
			System.out.print(items[i].getName() + ",");
		System.out.println(" 입니다.");
	}
}
