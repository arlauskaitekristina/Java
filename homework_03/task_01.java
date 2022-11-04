package homework_03;
import java.util.Scanner;
public class task_01
{
	void swap(int arr[], int a, int b)
	{
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	
    }

	void sortInWave(int arr[], int n)
	{
		for(int i = 0; i < n-1; i+=2){
			//swap odd and even positions
			if(i > 0 && arr[i - 1] > arr[i])
			swap(arr, i, i-1);
			if(i < n-1 && arr[i + 1] > arr[i])
			swap(arr, i, i+1);
		}
	}

	public static void main(String args[])
	{
		task_01 ob = new task_01();
		int arr[] = {10, 90, 18, 2, 1, 5, 23, 49};
		int n = arr.length;
		ob.sortInWave(arr, n);
		for (int i : arr)
			System.out.print(i+" ");
	}
};

