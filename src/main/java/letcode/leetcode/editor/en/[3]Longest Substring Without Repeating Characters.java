//Given a string s, find the length of the longest substring without repeating c
//haracters.
//
//
// Example 1:
//
//
//Input: s = "abcabcbb"
//Output: 3
//Explanation: The answer is "abc", with the length of 3.
//
//
// Example 2:
//
//
//Input: s = "bbbbb"
//Output: 1
//Explanation: The answer is "b", with the length of 1.
//
//
// Example 3:
//
//
//Input: s = "pwwkew"
//Output: 3
//Explanation: The answer is "wke", with the length of 3.
//Notice that the answer must be a substring, "pwke" is a subsequence and not a
//substring.
//
//
// Example 4:
//
//
//Input: s = ""
//Output: 0
//
//
//
// Constraints:
//
//
// 0 <= s.length <= 5 * 104
// s consists of English letters, digits, symbols and spaces.
//
// Related Topics Hash Table Two Pointers String Sliding Window

package letcode.leetcode.editor.en;
class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        Solution solution = new LongestSubstringWithoutRepeatingCharacters().new Solution();

        String s = "gogsdsdfa";
        System.out.println(solution.lengthOfLongestSubstring(s));
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int ans = 0;
        int[] index = new int[128];

        for (int start = 0, end = 0; end < n; end++) {
            char alpha = s.charAt(end);
            start = Math.max(index[alpha], start);
            ans = Math.max(ans, end - start + 1);
            index[alpha] = end + 1;
        }

        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
