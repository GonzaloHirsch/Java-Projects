package Two_Sum;

public class Solution {
    public int[] twoSum(int[] nums, int target) {
        // Solution array
        int[] sol = new int[2];
        int[] indexes = new int[nums.length];
        for (int i = 0; i < nums.length; i++){
            indexes[i] = i;
        }
        // Sort the array
        this.heapsort(nums, indexes);
        // Obtain solution
        int left = 0;
        int right = nums.length - 1;
        int sum = nums[left] + nums[right];
        while (sum != target){
            if (sum > target){
                right--;
            } else {
                left++;
            }
            sum = nums[left] + nums[right];
        }
        sol[0] = indexes[left];
        sol[1] = indexes[right];
        return sol;
    }

    public void heapsort(int[] arr, int[] indexes){
        int n = arr.length;
        // Build the heap
        for (int i = n / 2 - 1; i >= 0; i--){
            this.heapify(arr, indexes, n, i);
        }
        // Sort the heap
        for (int i = n - 1; i > 0; i--){
            int aux = arr[0];
            arr[0] = arr[i];
            arr[i] = aux;
            aux = indexes[0];
            indexes[0] = indexes[i];
            indexes[i] = aux;
            this.heapify(arr, indexes, i, 0);
        }
    }

    // arr is the heap, n is the heap size, i is the parent node
    public void heapify(int[] arr, int[] indexes, int n, int i){
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < n && arr[left] > arr[largest]){
            largest = left;
        }
        if (right < n && arr[right] > arr[largest]){
            largest = right;
        }
        if (largest > i){
            int aux = arr[i];
            arr[i] = arr[largest];
            arr[largest] = aux;
            aux = indexes[i];
            indexes[i] = indexes[largest];
            indexes[largest] = aux;
            heapify(arr, indexes, n, largest);
        }
    }
}