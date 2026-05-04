class Solution {
    public int removeElement(int[] nums, int val) {
        ArrayList<Integer> list = new ArrayList<>();

        int count = 0;

        for (int i: nums) {
            if (i != val) {
                System.out.println(i);
                count++;
                list.add(i);
            }
        }

        for (int i = 0; i < list.size(); i++) {
            nums[i] = list.get(i);
        } 

        return count;
    }
}