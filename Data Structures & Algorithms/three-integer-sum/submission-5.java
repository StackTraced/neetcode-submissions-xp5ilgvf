class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        
        List<List<Integer>> result = new ArrayList<>();

        Arrays.sort(nums);

        // initialize
        int lp;
        int rp = nums.length;
        int sum = 0;

        for (int anchor = 0; anchor <= nums.length - 3; anchor++) {
            
            if (anchor > 0 && nums[anchor] == nums[anchor - 1]) {
                continue;
            }

            lp = anchor + 1;
            rp = nums.length - 1;

            // some loop
            while (lp < rp) { // Check if lp < rp
                sum = nums[anchor] + nums[lp] + nums[rp];

                if (sum == 0) {
                    result.add(Arrays.asList(nums[anchor], nums[lp++], nums[rp]));                
                    
                    // Prevent duplicates from occuring
                    while(lp < rp && nums[lp] == nums[lp - 1]) {
                        lp++;
                    }
                }

                if (sum > 0) {
                    rp--;
                }

                else if (sum < 0) {
                    lp++;
                }
            }
        }
        return result;
    }
}
