<p>给你一个整数数组 <code>nums</code> ，数组中共有 <code>n</code> 个整数。<strong>132 模式的子序列</strong> 由三个整数 <code>nums[i]</code>、<code>nums[j]</code> 和 <code>nums[k]</code> 组成，并同时满足：<code>i &lt; j &lt; k</code> 和 <code>nums[i] &lt; nums[k] &lt; nums[j]</code> 。</p>

<p>如果 <code>nums</code> 中存在 <strong>132 模式的子序列</strong> ，返回 <code>true</code> ；否则，返回 <code>false</code> 。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入：</strong>nums = [1,2,3,4]
<strong>输出：</strong>false
<strong>解释：</strong>序列中不存在 132 模式的子序列。
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>nums = [3,1,4,2]
<strong>输出：</strong>true
<strong>解释：</strong>序列中有 1 个 132 模式的子序列： [1, 4, 2] 。
</pre>

<p><strong>示例 3：</strong></p>

<pre>
<strong>输入：</strong>nums = [-1,3,2,0]
<strong>输出：</strong>true
<strong>解释：</strong>序列中有 3 个 132 模式的的子序列：[-1, 3, 2]、[-1, 3, 0] 和 [-1, 2, 0] 。
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul> 
 <li><code>n == nums.length</code></li> 
 <li><code>1 &lt;= n &lt;= 2 * 10<sup>5</sup></code></li> 
 <li><code>-10<sup>9</sup> &lt;= nums[i] &lt;= 10<sup>9</sup></code></li> 
</ul>

<details><summary><strong>Related Topics</strong></summary>栈 | 数组 | 二分查找 | 有序集合 | 单调栈</details><br>

<div>👍 916, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/issues' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.online/algo/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.online/algo/' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：为满足广大读者的需求，网站上架 [速成目录](https://labuladong.online/algo/intro/quick-learning-plan/)，如有需要可以看下，谢谢大家的支持~**

</div>

