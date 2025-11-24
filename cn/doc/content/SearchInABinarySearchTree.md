<p>给定二叉搜索树（BST）的根节点
 <meta charset="UTF-8" />&nbsp;<code>root</code>&nbsp;和一个整数值
 <meta charset="UTF-8" />&nbsp;<code>val</code>。</p>

<p>你需要在 BST 中找到节点值等于&nbsp;<code>val</code>&nbsp;的节点。 返回以该节点为根的子树。 如果节点不存在，则返回
 <meta charset="UTF-8" />&nbsp;<code>null</code>&nbsp;。</p>

<p>&nbsp;</p>

<p><strong>示例 1:</strong></p>

<p><img alt="" src="https://assets.leetcode.com/uploads/2021/01/12/tree1.jpg" style="height: 179px; width: 250px;" />
 <meta charset="UTF-8" /></p>

<pre>
<b>输入：</b>root = [4,2,7,1,3], val = 2
<b>输出：</b>[2,1,3]
</pre>

<p><strong>示例 2:</strong></p> 
<img alt="" src="https://assets.leetcode.com/uploads/2021/01/12/tree2.jpg" style="height: 179px; width: 250px;" /> 
<pre>
<b>输入：</b>root = [4,2,7,1,3], val = 5
<b>输出：</b>[]
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul> 
 <li>树中节点数在&nbsp;<code>[1, 5000]</code>&nbsp;范围内</li> 
 <li><code>1 &lt;= Node.val &lt;= 10<sup>7</sup></code></li> 
 <li><code>root</code>&nbsp;是二叉搜索树</li> 
 <li><code>1 &lt;= val &lt;= 10<sup>7</sup></code></li> 
</ul>

<details><summary><strong>Related Topics</strong></summary>树 | 二叉搜索树 | 二叉树</details><br>

<div>👍 515, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/issues' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.online/algo/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.online/algo/' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：为满足广大读者的需求，网站上架 [速成目录](https://labuladong.online/algo/intro/quick-learning-plan/)，如有需要可以看下，谢谢大家的支持~**



<p><strong><a href="https://labuladong.online/algo/data-structure/bst-part2/" target="_blank">⭐️labuladong 题解</a></strong></p>
<details><summary><strong>labuladong 思路</strong></summary>


<div id="labuladong_solution_zh">

## 基本思路

利用 BST 左小右大的特性，可以避免搜索整棵二叉树去寻找元素，从而提升效率。

**详细题解**：
  - [二叉搜索树心法（基操篇）](https://labuladong.online/algo/data-structure/bst-part2/)

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
    TreeNode* searchBST(TreeNode* root, int target) {
        if (root == nullptr) {
            return nullptr;
        }
        // 去左子树搜索
        if (root->val > target) {
            return searchBST(root->left, target);
        }
        // 去右子树搜索
        if (root->val < target) {
            return searchBST(root->right, target);
        }
        return root;
    }
};
```

</div></div>

<div data-tab-item="python" class="tab-item " data-tab-group="default"><div class="highlight">

```python
# 注意：python 代码由 chatGPT🤖 根据我的 java 代码翻译。
# 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

class Solution:
    def searchBST(self, root: TreeNode, target: int) -> TreeNode:
        if root is None:
            return None
        # 去左子树搜索
        if root.val > target:
            return self.searchBST(root.left, target)
        # 去右子树搜索
        if root.val < target:
            return self.searchBST(root.right, target)
        return root
```

</div></div>

<div data-tab-item="java" class="tab-item active" data-tab-group="default"><div class="highlight">

```java
class Solution {
    public TreeNode searchBST(TreeNode root, int target) {
        if (root == null) {
            return null;
        }
        // 去左子树搜索
        if (root.val > target) {
            return searchBST(root.left, target);
        }
        // 去右子树搜索
        if (root.val < target) {
            return searchBST(root.right, target);
        }
        return root;
    }
}
```

</div></div>

<div data-tab-item="go" class="tab-item " data-tab-group="default"><div class="highlight">

```go
// 注意：go 代码由 chatGPT🤖 根据我的 java 代码翻译。
// 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

func searchBST(root *TreeNode, target int) *TreeNode {
    if root == nil {
        return nil
    }
    // 去左子树搜索
    if root.Val > target {
        return searchBST(root.Left, target)
    }
    // 去右子树搜索
    if root.Val < target {
        return searchBST(root.Right, target)
    }
    return root
}
```

</div></div>

<div data-tab-item="javascript" class="tab-item " data-tab-group="default"><div class="highlight">

```javascript
// 注意：javascript 代码由 chatGPT🤖 根据我的 java 代码翻译。
// 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

var searchBST = function(root, target) {
    if (root === null) {
        return null;
    }
    // 去左子树搜索
    if (root.val > target) {
        return searchBST(root.left, target);
    }
    // 去右子树搜索
    if (root.val < target) {
        return searchBST(root.right, target);
    }
    return root;
};
```

</div></div>
</div></div>

<hr /><details open hint-container details><summary style="font-size: medium"><strong>🍭🍭 算法可视化 🍭🍭</strong></summary><div id="data_search-in-a-binary-search-tree"  category="leetcode" ></div><div class="resizable aspect-ratio-container" style="height: 100%;">
<div id="iframe_search-in-a-binary-search-tree"></div></div>
</details><hr /><br />

</div>
</details>
</div>

