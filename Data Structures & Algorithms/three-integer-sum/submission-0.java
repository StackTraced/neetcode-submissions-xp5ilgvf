class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        // Check if the list is even big enough
        if (nums.length < 3 ){
            return new ArrayList();
        }

        // Making it a 2Sum problem
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();

        // This is our anchor
        for (int x = 0; x <= nums.length - 3; x++) {
        
            // Want to skip dups for x
            if (x > 0 && (nums[x] == nums[x - 1])) {
                continue;
            }

            // Grab the sum her
            int lp = x + 1;
            int rp = nums.length - 1;            

            while(lp < rp) {
                // Check if the sum is zero
                int sum = nums[x] + nums[lp] + nums [rp];

                if (sum == 0) {
                    // We add to the list
                    result.add(Arrays.asList(nums[x], nums[lp], nums[rp]));

                    // Then we check for dups
                    while(lp < rp && (nums[lp] == nums[lp + 1])) {
                        lp++;
                    }

                    while(lp < rp && (nums[rp] == nums[rp - 1])) {
                        rp--;
                    }
                    lp++;
                    rp--;

                }
                else if(sum < 0) {
                    lp++;
                } else {
                    rp--;
                }
            }
        }

        return result;
    }
}