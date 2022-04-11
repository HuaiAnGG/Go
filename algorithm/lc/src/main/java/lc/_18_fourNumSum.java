package wiki.laona.lc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author laona
 * @description https://leetcode-cn.com/problems/4sum/
 * @date 2021-11-18 17:04
 **/
public class _18_fourNumSum {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[]{1,0,-1,0,-2,2};
        List<List<Integer>> result = solution.fourSum(nums, 0);
        System.out.println(result);
    }

    static class Solution {
        public List<List<Integer>> fourSum(int[] nums, int target) {
            List<List<Integer>> result = new ArrayList<>();
            List<Integer> temp = new ArrayList<>();
            if (nums.length == 0 || nums.length < 4) {
                return result;
            }
            Arrays.sort(nums);
            // System.out.println("nums = " + Arrays.toString(nums));
            if ( nums[0] > target ){
                return result;
            }
            int start = 0;
            int end = 0;
            if (nums.length == 4) {
                long sum = nums[start] + nums[start+1] + nums[start+2] + nums[start+3];
                if (sum == target) {
                    temp = new ArrayList<>();
                    temp.add(nums[start]);
                    temp.add(nums[start + 1]);
                    temp.add(nums[start + 2]);
                    temp.add(nums[start + 3]);
                    result.add(temp);
                    return result;
                }
                return result;
            }
            int len = nums.length;
            for (int i = 0; i < nums.length; i++) {
                start = i;
                end = start + 3;
                if (end + 1 > nums.length) {
                    // return result;
                    break;
                }
                if (end + 1 == nums.length) {
                    long sum = nums[start] + nums[start+1] + nums[start+2] + nums[start+3];
                    if (sum == target) {
                        temp = new ArrayList<>();
                        temp.add(nums[start]);
                        temp.add(nums[start + 1]);
                        temp.add(nums[start + 2]);
                        temp.add(nums[start + 3]);
                        result.add(temp);
                    }
                    // return result;
                    break;
                }
                long sum = nums[start] + nums[start+1] + nums[start+2] + nums[start+3];
                if (sum == target) {
                    temp = new ArrayList<>();
                    temp.add(nums[start]);
                    temp.add(nums[start + 1]);
                    temp.add(nums[start + 2]);
                    temp.add(nums[start + 3]);
                    result.add(temp);
                }
            }
            return result;
        }
    }
}

