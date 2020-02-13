import java.util.Arrays;

public class MergeSort {
    public void merge(int[]nums, int[]left, int[]right){

        int i = 0, j = 0, k = 0;

        while(i < left.length && j < right.length){
            if(left[i] < right[j])
                nums[k++] = left[i++];

            else nums[k++] = right[j++];
        }
        while(i<left.length)//copy over remaining elements from left partition
            nums[k++] = left[i++];

        while(j< right.length)//copy over remaining elements from right partition
            nums[k++] = right[j++];
    }

    public void sort(int[]nums, int len){

        if(len < 2)
            return;
        int mid = len/2;
        int [] l = new int[mid];//create left partition
        int [] r = new int[len - mid];//create right partition

        for(int i = 0; i < mid; i++)
            l[i] = nums[i];

        for(int j = mid; j< len; j++)
            r[j - mid] = nums[j];

        sort(l,mid);
        sort(r,len - mid);
        merge(nums,l,r);//merge the two sorted partitions
    }
    public static void main(String[]args){
        int [] k2 = new int[]{3,4,5,1,0,-4,6,7,10,8};
        new MergeSort().sort(k2,k2.length);
        System.out.println(Arrays.toString(k2));
    }
}
