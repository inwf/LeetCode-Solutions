<p>给定二叉搜索树（BST）的根节点
 <meta charset="UTF-8" />&nbsp;<code>root</code>&nbsp;和要插入树中的值
 <meta charset="UTF-8" />&nbsp;<code>value</code>&nbsp;，将值插入二叉搜索树。 返回插入后二叉搜索树的根节点。 输入数据 <strong>保证</strong> ，新值和原始二叉搜索树中的任意节点值都不同。</p>

<p><strong>注意</strong>，可能存在多种有效的插入方式，只要树在插入后仍保持为二叉搜索树即可。 你可以返回 <strong>任意有效的结果</strong> 。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p> 
<img alt="" src="https://assets.leetcode.com/uploads/2020/10/05/insertbst.jpg" /> 
<pre>
<strong>输入：</strong>root = [4,2,7,1,3], val = 5
<strong>输出：</strong>[4,2,7,1,3,5]
<strong>解释：</strong>另一个满足题目要求可以通过的树是：
<img alt="" src="https://assets.leetcode.com/uploads/2020/10/05/bst.jpg" />
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>root = [40,20,60,10,30,50,70], val = 25
<strong>输出：</strong>[40,20,60,10,30,50,70,null,null,25]
</pre>

<p><strong>示例 3：</strong></p>

<pre>
<strong>输入：</strong>root = [4,2,7,1,3,null,null,null,null,null,null], val = 5
<strong>输出：</strong>[4,2,7,1,3,5]
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul> 
 <li>树中的节点数将在
  <meta charset="UTF-8" />&nbsp;<code>[0,&nbsp;10<sup>4</sup>]</code>的范围内。
  <meta charset="UTF-8" /></li> 
 <li><code>-10<sup>8</sup>&nbsp;&lt;= Node.val &lt;= 10<sup>8</sup></code></li> 
 <li>所有值&nbsp;
  <meta charset="UTF-8" /><code>Node.val</code>&nbsp;是&nbsp;<strong>独一无二</strong>&nbsp;的。</li> 
 <li><code>-10<sup>8</sup>&nbsp;&lt;= val &lt;= 10<sup>8</sup></code></li> 
 <li><strong>保证</strong>&nbsp;<code>val</code>&nbsp;在原始BST中不存在。</li> 
</ul>

<details><summary><strong>Related Topics</strong></summary>树 | 二叉搜索树 | 二叉树</details><br>

<div>👍 621, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/issues' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.online/algo/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.online/algo/' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：为满足广大读者的需求，网站上架 [速成目录](https://labuladong.online/algo/intro/quick-learning-plan/)，如有需要可以看下，谢谢大家的支持~**



<p><strong><a href="https://labuladong.online/algo/data-structure/bst-part2/" target="_blank">⭐️labuladong 题解</a></strong></p>
<details><summary><strong>labuladong 思路</strong></summary>


<div id="labuladong_solution_zh">

## 基本思路

如果要递归地插入或者删除二叉树节点，递归函数一定要有返回值，而且返回值要被正确的接收。

插入的过程可以分两部分：

1、寻找正确的插入位置，类似 [✔ ✨700. 二叉搜索树中的搜索](/problems/search-in-a-binary-search-tree/)。

2、把元素插进去，这就要把新节点以返回值的方式接到父节点上。

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

// 定义：在以 root 为根的 BST 中插入 val 节点，返回插入后的根节点
class Solution {
public:
    TreeNode* insertIntoBST(TreeNode* root, int val) {
        if (root == nullptr) {
            // 找到空位置插入新节点
            return new TreeNode(val);
        }

        // 去右子树找插入位置
        if (root->val < val) {
            root->right = insertIntoBST(root->right, val);
        }
        // 去左子树找插入位置
        if (root->val > val) {
            root->left = insertIntoBST(root->left, val);
        }
        // 返回 root，上层递归会接收返回值作为子节点
        return root;
    }
};
```

</div></div>

<div data-tab-item="python" class="tab-item " data-tab-group="default"><div class="highlight">

```python
# 注意：python 代码由 chatGPT🤖 根据我的 java 代码翻译。
# 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

# 定义：在以 root 为根的 BST 中插入 val 节点，返回插入后的根节点
class Solution:
    def insertIntoBST(self, root: TreeNode, val: int) -> TreeNode:
        if not root:
            # 找到空位置插入新节点
            return TreeNode(val)
        # 去右子树找插入位置
        if root.val < val:
            root.right = self.insertIntoBST(root.right, val)
        # 去左子树找插入位置
        if root.val > val:
            root.left = self.insertIntoBST(root.left, val)
        # 返回 root，上层递归会接收返回值作为子节点
        return root
```

</div></div>

<div data-tab-item="java" class="tab-item active" data-tab-group="default"><div class="highlight">

```java
class Solution {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        // 找到空位置插入新节点
        if (root == null) return new TreeNode(val);
        // if (root.val == val)
        // BST 中一般不会插入已存在元素
        if (root.val < val)
            root.right = insertIntoBST(root.right, val);
        if (root.val > val)
            root.left = insertIntoBST(root.left, val);
        return root;
    }
}
```

</div></div>

<div data-tab-item="go" class="tab-item " data-tab-group="default"><div class="highlight">

```go
// 注意：go 代码由 chatGPT🤖 根据我的 java 代码翻译。
// 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

// 定义：在以 root 为根的 BST 中插入 val 节点，返回插入后的根节点
func insertIntoBST(root *TreeNode, val int) *TreeNode {
    if root == nil {
        // 找到空位置插入新节点
        return &TreeNode{Val: val}
    }
    // 去右子树找插入位置
    if root.Val < val {
        root.Right = insertIntoBST(root.Right, val)
    }
    // 去左子树找插入位置
    if root.Val > val {
        root.Left = insertIntoBST(root.Left, val)
    }
    // 返回 root，上层递归会接收返回值作为子节点
    return root
}
```

</div></div>

<div data-tab-item="javascript" class="tab-item " data-tab-group="default"><div class="highlight">

```javascript
// 注意：javascript 代码由 chatGPT🤖 根据我的 java 代码翻译。
// 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

// 定义：在以 root 为根的 BST 中插入 val 节点，返回插入后的根节点
var insertIntoBST = function(root, val) {
    if (root === null) {
        // 找到空位置插入新节点
        return new TreeNode(val);
    }
    // 去右子树找插入位置
    if (root.val < val) {
        root.right = insertIntoBST(root.right, val);
    }
    // 去左子树找插入位置
    if (root.val > val) {
        root.left = insertIntoBST(root.left, val);
    }
    // 返回 root，上层递归会接收返回值作为子节点
    return root;
}
```

</div></div>
</div></div>

<hr /><details open hint-container details><summary style="font-size: medium"><strong>🌟🌟 算法可视化 🌟🌟</strong></summary><div id="data_insert-into-a-binary-search-tree"  category="leetcode" ></div><div class="resizable aspect-ratio-container" style="height: 100%;">
<div id="iframe_insert-into-a-binary-search-tree"></div></div>
</details><hr /><br />

</div>
</details>
</div>

