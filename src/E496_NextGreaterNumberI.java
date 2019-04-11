import com.sun.deploy.panel.ITreeNode;

/**
 * You are given two arrays (without duplicates) nums1 and nums2 where
 * nums1’s elements are subset of nums2. Find all the next greater numbers
 * for nums1's elements in the corresponding places of nums2.
 *
 * The Next Greater Number of a number x in nums1 is the first greater number
 * to its right in nums2. If it does not exist, output -1 for this number.
 *
 * Example 1:
 * Input: nums1 = [4,1,2], nums2 = [1,3,4,2].
 * Output: [-1,3,-1]
 */
public class E496_NextGreaterNumberI {
    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int l1 = nums1.length, l2 = nums2.length;
        int[] res = new int[l1];
        for(int i  = 0; i < l1; i++){
            for(int j = 0; j < l2; j++){
                if(nums2[j] != nums1[i])  //locate the number in nums2
                    continue;
                else{
                    int k;
                    for(k = j + 1; k < l2; k++){
                        if(nums2[k] > nums1[i]) { //find the next greater one
                            res[i] = nums2[k];
                            break;
                        }
                    }
                    if(k == l2) //don't find the next greater one
                        res[i] = -1;
                    break;

                }
            }
        }
        return res;
    }

    public static void main(String[] args){
        int[] nums1 = {4, 1, 2};
        int[] nums2 = {1, 3, 4, 2};
        int[] res = nextGreaterElement(nums1, nums2);
        for(int num : res){
            System.out.print(num + "\t");
        }
    }
}
