<p>给定两个字符串 <code>s</code> 和 <code>t</code> ，编写一个函数来判断 <code>t</code> 是否是 <code>s</code> 的 <span data-keyword="anagram">字母异位词</span>。</p>

<p>&nbsp;</p>

<p><strong>示例&nbsp;1:</strong></p>

<pre>
<strong>输入:</strong> s = "anagram", t = "nagaram"
<strong>输出:</strong> true
</pre>

<p><strong>示例 2:</strong></p>

<pre>
<strong>输入:</strong> s = "rat", t = "car"
<strong>输出: </strong>false</pre>

<p>&nbsp;</p>

<p><strong>提示:</strong></p>

<ul> 
 <li><code>1 &lt;= s.length, t.length &lt;= 5 * 10<sup>4</sup></code></li> 
 <li><code>s</code> 和 <code>t</code>&nbsp;仅包含小写字母</li> 
</ul>

<p>&nbsp;</p>

<p><strong>进阶:&nbsp;</strong>如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？</p>

<details><summary><strong>Related Topics</strong></summary>哈希表 | 字符串 | 排序</details><br>

<div>👍 1051, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/issues' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.online/algo/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.online/algo/' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：为满足广大读者的需求，网站上架 [速成目录](https://labuladong.online/algo/intro/quick-learning-plan/)，如有需要可以看下，谢谢大家的支持~**

<details><summary><strong>labuladong 思路</strong></summary>


<div id="labuladong_solution_zh">

## 基本思路

这题考察字符串的编码，如何找到一种编码方法，使得字母异位词的编码都相同？

一种直接的编码方式就是排序，异位词中字符排序后就会变成相同的字符串，不过排序的复杂度略高。

异位词中字符出现的次数肯定都是一样的，所以可以把 `s, t` 中的字符计数器作为编码，比较每个字符的出现次数即可判断 `s` 和 `t` 是否是异位词。

**详细题解**：
  - [【练习】哈希表更多习题](https://labuladong.online/algo/problem-set/hash-table/)

</div>





<div id="solution">

## 解法代码



<div class="tab-panel"><div class="tab-nav">
<button data-tab-item="cpp" class="tab-nav-button btn " data-tab-group="default" onclick="switchTab(this)">cpp🤖</button>

<button data-tab-item="python" class="tab-nav-button btn " data-tab-group="default" onclick="switchTab(this)">python🤖</button>

<button data-tab-item="java" class="tab-nav-button btn active" data-tab-group="default" onclick="switchTab(this)">java🟢</button>

<button data-tab-item="go" class="tab-nav-button btn " data-tab-group="default" onclick="switchTab(this)">go🤖</button>

<button data-tab-item="javascript" class="tab-nav-button btn " data-tab-group="default" onclick="switchTab(this)">javascript🤖</button>
</div><div class="tab-content">
<div data-tab-item="cpp" class="tab-item " data-tab-group="default"><div class="highlight">

```cpp
// 注意：cpp 代码由 chatGPT🤖 根据我的 java 代码翻译。
// 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

class Solution {
public:
    bool isAnagram(string s, string t) {
        vector<int> count1 = encode(s);
        vector<int> count2 = encode(t);
        // 确保两个字符串中所有字符出现的数量相同
        for (int i = 0; i < count1.size(); i++) {
            if (count1[i] != count2[i]) {
                return false;
            }
        }

        return true;
    }

    // 计算字符的出现次数
    vector<int> encode(string s) {
        vector<int> count(26, 0);
        for (char c : s) {
            int delta = c - 'a';
            count[delta]++;
        }
        return count;
    }
};
```

</div></div>

<div data-tab-item="python" class="tab-item " data-tab-group="default"><div class="highlight">

```python
# 注意：python 代码由 chatGPT🤖 根据我的 java 代码翻译。
# 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        count1 = self.encode(s)
        count2 = self.encode(t)
        # 确保两个字符串中所有字符出现的数量相同
        for i in range(len(count1)):
            if count1[i] != count2[i]:
                return False

        return True

    # 计算字符的出现次数
    def encode(self, s: str) -> list:
        count = [0] * 26
        for c in s:
            delta = ord(c) - ord('a')
            count[delta] += 1
        return count
```

</div></div>

<div data-tab-item="java" class="tab-item active" data-tab-group="default"><div class="highlight">

```java
class Solution {
    public boolean isAnagram(String s, String t) {
        int[] count1 = encode(s);
        int[] count2 = encode(t);
        // 确保两个字符串中所有字符出现的数量相同
        for (int i = 0; i < count1.length; i++) {
            if (count1[i] != count2[i]) {
                return false;
            }
        }

        return true;
    }

    // 计算字符的出现次数
    int[] encode(String s) {
        int[] count = new int[26];
        for (char c : s.toCharArray()) {
            int delta = c - 'a';
            count[delta]++;
        }
        return count;
    }
}
```

</div></div>

<div data-tab-item="go" class="tab-item " data-tab-group="default"><div class="highlight">

```go
// 注意：go 代码由 chatGPT🤖 根据我的 java 代码翻译。
// 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

func isAnagram(s string, t string) bool {
    count1 := encode(s)
    count2 := encode(t)
    // 确保两个字符串中所有字符出现的数量相同
    for i := 0; i < len(count1); i++ {
        if count1[i] != count2[i] {
            return false
        }
    }
    return true
}

// 计算字符的出现次数
func encode(s string) []int {
    count := make([]int, 26)
    for _, c := range s {
        delta := c - 'a'
        count[delta]++
    }
    return count
}
```

</div></div>

<div data-tab-item="javascript" class="tab-item " data-tab-group="default"><div class="highlight">

```javascript
// 注意：javascript 代码由 chatGPT🤖 根据我的 java 代码翻译。
// 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

var isAnagram = function(s, t) {
    let count1 = encode(s);
    let count2 = encode(t);
    // 确保两个字符串中所有字符出现的数量相同
    for (let i = 0; i < count1.length; i++) {
        if (count1[i] !== count2[i]) {
            return false;
        }
    }
    return true;
};

// 计算字符的出现次数
var encode = function(s) {
    let count = new Array(26).fill(0);
    for (let c of s) {
        let delta = c.charCodeAt(0) - 'a'.charCodeAt(0);
        count[delta]++;
    }
    return count;
};
```

</div></div>
</div></div>

<hr /><details open hint-container details><summary style="font-size: medium"><strong>👾👾 算法可视化 👾👾</strong></summary><div id="data_valid-anagram"  category="leetcode" ></div><div class="resizable aspect-ratio-container" style="height: 100%;">
<div id="iframe_valid-anagram"></div></div>
</details><hr /><br />

</div>
</details>
</div>

