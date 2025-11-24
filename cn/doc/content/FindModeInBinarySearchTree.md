<p>给你一个含重复值的二叉搜索树（BST）的根节点 <code>root</code> ，找出并返回 BST 中的所有 <a href="https://baike.baidu.com/item/%E4%BC%97%E6%95%B0/44796" target="_blank">众数</a>（即，出现频率最高的元素）。</p>

<p>如果树中有不止一个众数，可以按 <strong>任意顺序</strong> 返回。</p>

<p>假定 BST 满足如下定义：</p>

<ul> 
 <li>结点左子树中所含节点的值 <strong>小于等于</strong> 当前节点的值</li> 
 <li>结点右子树中所含节点的值 <strong>大于等于</strong> 当前节点的值</li> 
 <li>左子树和右子树都是二叉搜索树</li> 
</ul>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p> 
<img alt="" src="https://assets.leetcode.com/uploads/2021/03/11/mode-tree.jpg" style="width: 142px; height: 222px;" /> 
<pre>
<strong>输入：</strong>root = [1,null,2,2]
<strong>输出：</strong>[2]
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>root = [0]
<strong>输出：</strong>[0]
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul> 
 <li>树中节点的数目在范围 <code>[1, 10<sup>4</sup>]</code> 内</li> 
 <li><code>-10<sup>5</sup> &lt;= Node.val &lt;= 10<sup>5</sup></code></li> 
</ul>

<p>&nbsp;</p>

<p><strong>进阶：</strong>你可以不使用额外的空间吗？（假设由递归产生的隐式调用栈的开销不被计算在内）</p>

<details><summary><strong>Related Topics</strong></summary>树 | 深度优先搜索 | 二叉搜索树 | 二叉树</details><br>

<div>👍 820, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/issues' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.online/algo/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.online/algo/' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：为满足广大读者的需求，网站上架 [速成目录](https://labuladong.online/algo/intro/quick-learning-plan/)，如有需要可以看下，谢谢大家的支持~**

<details><summary><strong>labuladong 思路</strong></summary>


<div id="labuladong_solution_zh">

## 基本思路

前文 [手把手刷二叉树总结篇](https://labuladong.online/algo/essential-technique/binary-tree-summary/) 说过二叉树的递归分为「遍历」和「分解问题」两种思维模式，这道题需要用到「遍历」的思维。

BST 的中序遍历有序，在中序遍历的位置做一些判断逻辑和操作有序数组差不多，很容易找出众数。

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

#include <vector>
using namespace std;

class Solution {
public:
    vector<int> mode;
    TreeNode* prev = nullptr;
    // 当前元素的重复次数
    int curCount = 0;
    // 全局的最长相同序列长度
    int maxCount = 0;

    vector<int> findMode(TreeNode* root) {
        // 执行中序遍历
        traverse(root);

        vector<int> res(mode.begin(), mode.end());
        return res;
    }

    void traverse(TreeNode* root) {
        if (root == nullptr) {
            return;
        }
        traverse(root->left);

        // 中序遍历位置
        if (prev == nullptr) {
            // 初始化
            curCount = 1;
            maxCount = 1;
            mode.push_back(root->val);
        } else {
            if (root->val == prev->val) {
                // root.val 重复的情况
                curCount++;
                if (curCount == maxCount) {
                    // root.val 是众数
                    mode.push_back(root->val);
                } else if (curCount > maxCount) {
                    // 更新众数
                    mode.clear();
                    maxCount = curCount;
                    mode.push_back(root->val);
                }
            } else {
                // root.val 不重复的情况
                curCount = 1;
                if (curCount == maxCount) {
                    mode.push_back(root->val);
                }
            }
        }
        // 别忘了更新 prev
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
        self.mode = []
        self.prev = None
        # 当前元素的重复次数
        self.curCount = 0
        # 全局的最长相同序列长度
        self.maxCount = 0

    def findMode(self, root):
        # 执行中序遍历
        self.traverse(root)

        return self.mode

    def traverse(self, root):
        if root is None:
            return
        self.traverse(root.left)

        # 中序遍历位置
        if self.prev is None:
            # 初始化
            self.curCount = 1
            self.maxCount = 1
            self.mode.append(root.val)
        else:
            if root.val == self.prev.val:
                # root.val 重复的情况
                self.curCount += 1
                if self.curCount == self.maxCount:
                    # root.val 是众数
                    self.mode.append(root.val)
                elif self.curCount > self.maxCount:
                    # 更新众数
                    self.mode = []
                    self.maxCount = self.curCount
                    self.mode.append(root.val)
            else:
                # root.val 不重复的情况
                self.curCount = 1
                if self.curCount == self.maxCount:
                    self.mode.append(root.val)

        # 别忘了更新 prev
        self.prev = root

        self.traverse(root.right)
```

</div></div>

<div data-tab-item="java" class="tab-item active" data-tab-group="default"><div class="highlight">

```java
class Solution {
    ArrayList<Integer> mode = new ArrayList<>();
    TreeNode prev = null;
    // 当前元素的重复次数
    int curCount = 0;
    // 全局的最长相同序列长度
    int maxCount = 0;

    public int[] findMode(TreeNode root) {
        // 执行中序遍历
        traverse(root);

        int[] res = new int[mode.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = mode.get(i);
        }
        return res;
    }

    void traverse(TreeNode root) {
        if (root == null) {
            return;
        }
        traverse(root.left);

        // 中序遍历位置
        if (prev == null) {
            // 初始化
            curCount = 1;
            maxCount = 1;
            mode.add(root.val);
        } else {
            if (root.val == prev.val) {
                // root.val 重复的情况
                curCount++;
                if (curCount == maxCount) {
                    // root.val 是众数
                    mode.add(root.val);
                } else if (curCount > maxCount) {
                    // 更新众数
                    mode.clear();
                    maxCount = curCount;
                    mode.add(root.val);
                }
            }

            if (root.val != prev.val) {
                // root.val 不重复的情况
                curCount = 1;
                if (curCount == maxCount) {
                    mode.add(root.val);
                }
            }
        }
        // 别忘了更新 prev
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

func findMode(root *TreeNode) []int {
    var mode []int
    var prev *TreeNode
    // 当前元素的重复次数
    var curCount int
    // 全局的最长相同序列长度
    var maxCount int

    // 执行中序遍历
    traverse(root, &prev, &curCount, &maxCount, &mode)

    return mode
}

func traverse(root *TreeNode, prev **TreeNode, curCount, maxCount *int, mode *[]int) {
    if root == nil {
        return
    }
    traverse(root.Left, prev, curCount, maxCount, mode)

    // 中序遍历位置
    if *prev == nil {
        // 初始化
        *curCount = 1
        *maxCount = 1
        *mode = append(*mode, root.Val)
    } else {
        if root.Val == (*prev).Val {
            // root.val 重复的情况
            *curCount++
            if *curCount == *maxCount {
                // root.val 是众数
                *mode = append(*mode, root.Val)
            } else if *curCount > *maxCount {
                // 更新众数
                *mode = []int{root.Val}
                *maxCount = *curCount
            }
        } else {
            // root.val 不重复的情况
            *curCount = 1
            if *curCount == *maxCount {
                *mode = append(*mode, root.Val)
            }
        }
    }
    // 别忘了更新 prev
    *prev = root

    traverse(root.Right, prev, curCount, maxCount, mode)
}
```

</div></div>

<div data-tab-item="javascript" class="tab-item " data-tab-group="default"><div class="highlight">

```javascript
// 注意：javascript 代码由 chatGPT🤖 根据我的 java 代码翻译。
// 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

var findMode = function(root) {
    let mode = [];
    let prev = null;
    // 当前元素的重复次数
    let curCount = 0;
    // 全局的最长相同序列长度
    let maxCount = 0;

    // 执行中序遍历
    const traverse = function(root) {
        if (root === null) {
            return;
        }
        traverse(root.left);

        // 中序遍历位置
        if (prev === null) {
            // 初始化
            curCount = 1;
            maxCount = 1;
            mode.push(root.val);
        } else {
            if (root.val === prev.val) {
                // root.val 重复的情况
                curCount++;
                if (curCount === maxCount) {
                    // root.val 是众数
                    mode.push(root.val);
                } else if (curCount > maxCount) {
                    // 更新众数
                    mode = [root.val];
                    maxCount = curCount;
                }
            }

            if (root.val !== prev.val) {
                // root.val 不重复的情况
                curCount = 1;
                if (curCount === maxCount) {
                    mode.push(root.val);
                }
            }
        }
        // 别忘了更新 prev
        prev = root;

        traverse(root.right);
    };

    traverse(root);

    return mode;
};
```

</div></div>
</div></div>

<hr /><details open hint-container details><summary style="font-size: medium"><strong>🍭🍭 算法可视化 🍭🍭</strong></summary><div id="data_find-mode-in-binary-search-tree"  category="leetcode" ></div><div class="resizable aspect-ratio-container" style="height: 100%;">
<div id="iframe_find-mode-in-binary-search-tree"></div></div>
</details><hr /><br />

</div>
</details>
</div>

