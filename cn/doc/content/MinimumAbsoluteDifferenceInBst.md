<p>给你一个二叉搜索树的根节点 <code>root</code> ，返回 <strong>树中任意两不同节点值之间的最小差值</strong> 。</p>

<p>差值是一个正数，其数值等于两值之差的绝对值。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p> 
<img alt="" src="https://assets.leetcode.com/uploads/2021/02/05/bst1.jpg" style="width: 292px; height: 301px;" /> 
<pre>
<strong>输入：</strong>root = [4,2,6,1,3]
<strong>输出：</strong>1
</pre>

<p><strong>示例 2：</strong></p> 
<img alt="" src="https://assets.leetcode.com/uploads/2021/02/05/bst2.jpg" style="width: 282px; height: 301px;" /> 
<pre>
<strong>输入：</strong>root = [1,0,48,null,null,12,49]
<strong>输出：</strong>1
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul> 
 <li>树中节点的数目范围是 <code>[2, 10<sup>4</sup>]</code></li> 
 <li><code>0 &lt;= Node.val &lt;= 10<sup>5</sup></code></li> 
</ul>

<p>&nbsp;</p>

<p><strong>注意：</strong>本题与 783 <a href="https://leetcode-cn.com/problems/minimum-distance-between-bst-nodes/">https://leetcode-cn.com/problems/minimum-distance-between-bst-nodes/</a> 相同</p>

<details><summary><strong>Related Topics</strong></summary>树 | 深度优先搜索 | 广度优先搜索 | 二叉搜索树 | 二叉树</details><br>

<div>👍 647, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/issues' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.online/algo/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.online/algo/' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：为满足广大读者的需求，网站上架 [速成目录](https://labuladong.online/algo/intro/quick-learning-plan/)，如有需要可以看下，谢谢大家的支持~**

<details><summary><strong>labuladong 思路</strong></summary>


<div id="labuladong_solution_zh">

## 基本思路

前文 [手把手刷二叉树总结篇](https://labuladong.online/algo/essential-technique/binary-tree-summary/) 说过二叉树的递归分为「遍历」和「分解问题」两种思维模式，这道题需要用到「遍历」的思维。

记住，看到一棵 BST，你就把它理解是一个有序数组就行了，只是遍历方式不同罢了。所以这道题的思路就很简单，用中序遍历遍历一遍 BST 的所有节点得到有序结果，然后在遍历过程中计算最小差值即可。

**详细题解**：
  - [【练习】二叉搜索树经典例题 I](https://labuladong.online/algo/problem-set/bst1/)

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
    int getMinimumDifference(TreeNode* root) {
        traverse(root);
        return res;
    }

    TreeNode* prev = nullptr;
    int res = INT_MAX;

    // 遍历函数
    void traverse(TreeNode* root) {
        if (root == nullptr) {
            return;
        }
        traverse(root->left);
        // 中序遍历位置
        if (prev != nullptr) {
            res = min(res, root->val - prev->val);
        }
        prev = root;
        traverse(root->right);
    }
};
```

</div></div>

<div data-tab-item="python" class="tab-item " data-tab-group="default"><div class="highlight">

```python
# 注意：python 代码由 chatGPT🤖 根据我的 java 代码翻译。
# 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

class Solution:
    def __init__(self):
        self.prev = None
        self.res = float('inf')

    def getMinimumDifference(self, root: TreeNode) -> int:
        self.traverse(root)
        return self.res

    # 遍历函数
    def traverse(self, root: TreeNode):
        if root is None:
            return
        self.traverse(root.left)
        # 中序遍历位置
        if self.prev is not None:
            self.res = min(self.res, root.val - self.prev.val)
        self.prev = root
        self.traverse(root.right)
```

</div></div>

<div data-tab-item="java" class="tab-item active" data-tab-group="default"><div class="highlight">

```java
class Solution {
    public int getMinimumDifference(TreeNode root) {
        traverse(root);
        return res;
    }

    TreeNode prev = null;
    int res = Integer.MAX_VALUE;

    // 遍历函数
    void traverse(TreeNode root) {
        if (root == null) {
            return;
        }
        traverse(root.left);
        // 中序遍历位置
        if (prev != null) {
            res = Math.min(res, root.val - prev.val);
        }
        prev = root;
        traverse(root.right);
    }
}
```

</div></div>

<div data-tab-item="go" class="tab-item " data-tab-group="default"><div class="highlight">

```go
// 注意：go 代码由 chatGPT🤖 根据我的 java 代码翻译。
// 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

func getMinimumDifference(root *TreeNode) int {
    var res int = math.MaxInt32
    var prev *TreeNode
    traverse(root, &prev, &res)
    return res
}

// 遍历函数
func traverse(root *TreeNode, prev **TreeNode, res *int) {
    if root == nil {
        return
    }
    traverse(root.Left, prev, res)
    // 中序遍历位置
    if *prev != nil {
        *res = min(*res, root.Val - (*prev).Val)
    }
    *prev = root
    traverse(root.Right, prev, res)
}

func min(a, b int) int {
    if a < b {
        return a
    }
    return b
}
```

</div></div>

<div data-tab-item="javascript" class="tab-item " data-tab-group="default"><div class="highlight">

```javascript
// 注意：javascript 代码由 chatGPT🤖 根据我的 java 代码翻译。
// 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

var getMinimumDifference = function(root) {
    let prev = null;
    let res = Number.MAX_VALUE;

    // 遍历函数
    var traverse = function(root) {
        if (root === null) {
            return;
        }
        traverse(root.left);
        // 中序遍历位置
        if (prev !== null) {
            res = Math.min(res, root.val - prev.val);
        }
        prev = root;
        traverse(root.right);
    };

    traverse(root);
    return res;
};
```

</div></div>
</div></div>

<hr /><details open hint-container details><summary style="font-size: medium"><strong>🥳🥳 算法可视化 🥳🥳</strong></summary><div id="data_minimum-absolute-difference-in-bst"  category="leetcode" ></div><div class="resizable aspect-ratio-container" style="height: 100%;">
<div id="iframe_minimum-absolute-difference-in-bst"></div></div>
</details><hr /><br />

</div>
</details>
</div>

