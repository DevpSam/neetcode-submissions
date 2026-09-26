class Solution {
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public int partionalgo(int[] nums, int l, int r) {
        int pivotElement = nums[l];
        int i = l + 1;
        int j = r;

        while (i <= j) {
            if (nums[i] < pivotElement && nums[j] > pivotElement) {
                swap(nums, i, j);
                i++;
                j--;
            }
            if (i <= j && nums[i] >= pivotElement) {
                i++;
            }
            if (i <= j && nums[j] <= pivotElement) {
                j--;
            }
        }
        swap(nums, l, j);
        return j;
    }

    public int findKthLargest(int[] nums, int k) {
        int l = 0;
        int r = nums.length - 1;
        int targetIdx = k - 1; 
        
        while (l <= r) {
            int pivot = partionalgo(nums, l, r);
            if (pivot == targetIdx) {
                return nums[pivot];
            } else if (pivot > targetIdx) {
                r = pivot - 1;
            } else {
                l = pivot + 1;
            }
        }
        return -1;
    }
}