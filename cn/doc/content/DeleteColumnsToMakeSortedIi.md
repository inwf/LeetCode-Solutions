<p>给定由 <code>n</code> 个字符串组成的数组 <code>strs</code>，其中每个字符串长度相等。</p>

<p>选取一个删除索引序列，对于 <code>strs</code> 中的每个字符串，删除对应每个索引处的字符。</p>

<p>比如，有 <code>strs = ["abcdef", "uvwxyz"]</code>，删除索引序列&nbsp;<code>{0, 2, 3}</code>，删除后 <code>strs</code> 为<code>["bef", "vyz"]</code>。</p>

<p>假设，我们选择了一组删除索引 <code>answer</code>，那么在执行删除操作之后，最终得到的数组的元素是按 <strong>字典序</strong>（<code>strs[0] &lt;= strs[1] &lt;= strs[2] ... &lt;= strs[n - 1]</code>）排列的，然后请你返回 <code>answer.length</code>&nbsp;的最小可能值。</p>

<p>&nbsp;</p>

<ol> 
</ol>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入：</strong>strs = ["ca","bb","ac"]
<strong>输出：</strong>1
<strong>解释： </strong>
删除第一列后，strs = ["a", "b", "c"]。
现在 strs 中元素是按字典排列的 (即，strs[0] &lt;= strs[1] &lt;= strs[2])。
我们至少需要进行 1 次删除，因为最初 strs 不是按字典序排列的，所以答案是 1。
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>strs = ["xc","yb","za"]
<strong>输出：</strong>0
<strong>解释：</strong>
strs 的列已经是按字典序排列了，所以我们不需要删除任何东西。
注意 strs 的行不需要按字典序排列。
也就是说，strs[0][0] &lt;= strs[0][1] &lt;= ... 不一定成立。
</pre>

<p><strong>示例 3：</strong></p>

<pre>
<strong>输入：</strong>strs = ["zyx","wvu","tsr"]
<strong>输出：</strong>3
<strong>解释：</strong>
我们必须删掉每一列。
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul> 
 <li><code>n == strs.length</code></li> 
 <li><code>1 &lt;= n &lt;= 100</code></li> 
 <li><code>1 &lt;= strs[i].length &lt;= 100</code></li> 
 <li><code>strs[i]</code> 由小写英文字母组成</li> 
</ul>

<details><summary><strong>Related Topics</strong></summary>贪心 | 数组 | 字符串</details><br>

<div>👍 113, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/issues' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.online/algo/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.online/algo/' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：为满足广大读者的需求，网站上架 [速成目录](https://labuladong.online/algo/intro/quick-learning-plan/)，如有需要可以看下，谢谢大家的支持~**

</div>

