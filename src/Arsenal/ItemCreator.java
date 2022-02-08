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
			// �߻� Ŭ���� ������ ���丮���� ���ǵ� ���μ��� ��� item ����, �迭�� ����
			items[i] = factory.newInstance(rdn);
			System.out.println(items[i].getName());
		}
		
		System.out.print("������ �������� ");
		for (int i = 0; i < 5; i++)
			System.out.print(items[i].getName() + ",");
		System.out.println(" �Դϴ�.");
	}
}
