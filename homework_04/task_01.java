package homework_04;

public class task_01 {
    public static void quickSort(int[] array, int low, int high) {
        if (array.length == 0 || low >= high)
            return;

            int middle = low + (high - low) / 2;
            int opora = array[middle];

            int i = low, j = high;
            while (i <= j) {
                while (array[i] < opora) {
                    i++;
                }
                while (array[j] > opora) {
                    j--;
                }
                if (i <= j) {
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                    i++;
                    j--;
                }
        }
            if (low < j)
            quickSort(array, low, j);
            if (high > i)
            quickSort(array, i, high);
        }
        public static void main(String args[]) {
            int[] sortArr = {12, 6, 4, 1, 15, 10};
            quickSort(sortArr, 0, sortArr.length - 1);
            for(int i = 0; i < sortArr.length; i++){
                System.out.print(sortArr[i] + "\n");
            }
        }
    }