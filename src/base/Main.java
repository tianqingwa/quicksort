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
				--j;// ���ȴ�������ܱ�֤���i==jֹͣ��λ�õ�Ԫ����С�ڵ����������ģ���������һ��ʵ�ַ�ʽ�Ĵ��룩���������ʵ�ַ�ʽ����Ϊ���Ǽ�¼����ߵ����ֵ������������ڳ�һ�����������Էű�������С��ֵ
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
		nums[i] = x;// ���һ�������ҵ���������x��λ��
		qSort(nums, start, i - 1);
		qSort(nums, i + 1, end);

	}

}
