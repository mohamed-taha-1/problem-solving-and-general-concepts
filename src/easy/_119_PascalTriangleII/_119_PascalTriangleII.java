package easy._119_PascalTriangleII;

import java.util.ArrayList;
import java.util.List;

public class _119_PascalTriangleII {

	public static List<Integer> getRow(int rowIndex) {
		List<Integer> list = new ArrayList<>();

		if (rowIndex < 0)
			return list;
		list.add(1);

		for (int i = 1; i <= rowIndex; i++) {
			List<Integer> newlist = new ArrayList<>();
			newlist.add(1);

			for (int j = 1; j < i; j++) {
				int sum = list.get(j - 1) + list.get(j);
				newlist.add(sum);

			}
			newlist.add(1);
			list=newlist;
		}

		return list;
	}

	public static void main(String[] args) {
		int rowIndex=9;
		
		System.out.println(  getRow(rowIndex) );

	}

}
