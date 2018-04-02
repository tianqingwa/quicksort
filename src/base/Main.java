package base;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int[] nums = new int[n];
		for (int i = 0; i < n; ++i) {
			nums[i] = scanner.nextInt();
		}
		qSort(nums, 0, nums.length - 1);

		for (int i = 0; i < n; ++i) {
			System.out.print(nums[i] + " ");
		}
	}

	public static void qSort(int[] nums, int start, int end) {
		if (start >= end) {
			return;
		}
		int x = nums[start];
		int i = start;
		int j = end;
		while (i < j) {
			while (i < j && nums[j] >= x) {
				--j;// （先从左边找能保证最后i==j停止的位置的元素是小于等于枢轴量的，这是另外一种实现方式的代码）这里的这种实现方式是因为我们记录了左边的这个值，所以是左边腾出一个空来，可以放比枢轴量小的值
			}
			if (i < j) {
				nums[i] = nums[j];
				++i;
			}
			while (i < j && nums[i] <= x) {
				++i;
			}
			if (i < j) {
				nums[j] = nums[i];
				++j;
			}
		}
		// nums[start]=nums[i];
		nums[i] = x;// 完成一趟排序，找到了枢轴量x的位置
		qSort(nums, start, i - 1);
		qSort(nums, i + 1, end);

	}

}
