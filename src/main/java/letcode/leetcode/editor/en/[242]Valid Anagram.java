//Given two strings s and t, return true if t is an anagram of s, and false
//otherwise.
//
// An Anagram is a word or phrase formed by rearranging the letters of a
//different word or phrase, typically using all the original letters exactly once.
//
//
// Example 1:
// Input: s = "anagram", t = "nagaram"
//Output: true
// Example 2:
// Input: s = "rat", t = "car"
//Output: false
//
//
// Constraints:
//
//
// 1 <= s.length, t.length <= 5 * 10⁴
// s and t consist of lowercase English letters.
//
//
//
// Follow up: What if the inputs contain Unicode characters? How would you
//adapt your solution to such a case?
// Related Topics Hash Table String Sorting 👍 4945 👎 217

package letcode.leetcode.editor.en;

import java.util.HashMap;
import java.util.Map;

class ValidAnagram {
    public static void main(String[] args) {
        Solution solution = new ValidAnagram().new Solution();
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        Map<Character, Integer> charCountS = new HashMap<>();
        Map<Character, Integer> charCountT = new HashMap<>();
        for (int i=0 ; i < s.length(); i++) {
            char tmpS = s.charAt(i);
            charCountS.put(tmpS, 1 + charCountS.getOrDefault(tmpS, 0));

            char tmpT = t.charAt(i);
            charCountT.put(tmpT, 1 + charCountT.getOrDefault(tmpT, 0));
        }

        for (Map.Entry entry : charCountS.entrySet()) {
            if (!entry.getValue().equals(charCountT.getOrDefault(entry.getKey(), 0))) {
                return false;
            }
        }

        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
