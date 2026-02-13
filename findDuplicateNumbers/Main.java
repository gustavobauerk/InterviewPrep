import java.util.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        int[] nums = new int[]{3, 4, 4, 5, 5};
        System.out.println(findNumbers(nums));
    }

    public static List<Integer> findNumbers(int[] nums) {
        List<Integer> duplicateNumbers = new ArrayList<>();
        for(int i = 0; i < nums.length; i++){
            if(nums[i] != nums[nums[i]-1]){
                swap(i, nums[i]-1, nums);
            }else {
                i++;
            }
        }

        for(int i = 0; i < nums.length; i++){
            if(nums[i] != i+1){
                duplicateNumbers.add(nums[i]);
            }
        }
        return duplicateNumbers;
    }

    private static void swap(int i, int j, int[] nums){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}

