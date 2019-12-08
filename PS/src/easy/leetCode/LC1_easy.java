package easy.leetCode;

import java.util.HashMap;

public class LC1_easy {

	public static void main(String[] args, int i) {

	}

	public int[] twoSum(int[] array, int target) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < array.length; i++) {
			int dif = target - array[i];
			if (map.containsKey(array[i])) {
				int k[] = { map.get(array[i]), i };

				return k;
			} else {
				map.put(dif, i);
			}
		}
		return null;
	}
}
