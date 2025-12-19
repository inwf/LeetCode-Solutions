<p>你这个学期必须选修 <code>numCourses</code> 门课程，记为&nbsp;<code>0</code>&nbsp;到&nbsp;<code>numCourses - 1</code> 。</p>

<p>在选修某些课程之前需要一些先修课程。 先修课程按数组&nbsp;<code>prerequisites</code> 给出，其中&nbsp;<code>prerequisites[i] = [a<sub>i</sub>, b<sub>i</sub>]</code> ，表示如果要学习课程&nbsp;<code>a<sub>i</sub></code> 则 <strong>必须</strong> 先学习课程&nbsp; <code>b<sub>i</sub></code><sub> </sub>。</p>

<ul> 
 <li>例如，先修课程对&nbsp;<code>[0, 1]</code> 表示：想要学习课程 <code>0</code> ，你需要先完成课程 <code>1</code> 。</li> 
</ul>

<p>请你判断是否可能完成所有课程的学习？如果可以，返回 <code>true</code> ；否则，返回 <code>false</code> 。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入：</strong>numCourses = 2, prerequisites = [[1,0]]
<strong>输出：</strong>true
<strong>解释：</strong>总共有 2 门课程。学习课程 1 之前，你需要完成课程 0 。这是可能的。</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>numCourses = 2, prerequisites = [[1,0],[0,1]]
<strong>输出：</strong>false
<strong>解释：</strong>总共有 2 门课程。学习课程 1 之前，你需要先完成​课程 0 ；并且学习课程 0 之前，你还应先完成课程 1 。这是不可能的。</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul> 
 <li><code>1 &lt;= numCourses &lt;= 2000</code></li> 
 <li><code>0 &lt;= prerequisites.length &lt;= 5000</code></li> 
 <li><code>prerequisites[i].length == 2</code></li> 
 <li><code>0 &lt;= a<sub>i</sub>, b<sub>i</sub> &lt; numCourses</code></li> 
 <li><code>prerequisites[i]</code> 中的所有课程对 <strong>互不相同</strong></li> 
</ul>

<details><summary><strong>Related Topics</strong></summary>深度优先搜索 | 广度优先搜索 | 图 | 拓扑排序</details><br>

<div>👍 2268, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/issues' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.online/algo/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.online/algo/' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：为满足广大读者的需求，网站上架 [速成目录](https://labuladong.online/algo/intro/quick-learning-plan/)，如有需要可以看下，谢谢大家的支持~**



<p><strong><a href="https://labuladong.online/algo/data-structure/topological-sort/" target="_blank">⭐️labuladong 题解</a></strong></p>
<details><summary><strong>labuladong 思路</strong></summary>


<div id="labuladong_solution_zh">

## 基本思路

只要会遍历图结构，就可以判断环了。

利用布尔数组 `onPath`，如果遍历过程中发现下一个即将遍历的节点已经被标记为 true，说明遇到了环（可以联想贪吃蛇咬到自己的场景）。

我给出 DFS 遍历的解法，其实本题也可以用 BFS 算法解决，稍微有些技巧，可以看详细题解。

**详细题解**：
  - [环检测及拓扑排序算法](https://labuladong.online/algo/data-structure/topological-sort/)

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
#include <list>

class Solution {
    // 记录一次 traverse 递归经过的节点
    std::vector<bool> onPath;
    // 记录遍历过的节点，防止走回头路
    std::vector<bool> visited;
    // 记录图中是否有环
    bool hasCycle = false;

public:
    bool canFinish(int numCourses, std::vector<std::vector<int>>& prerequisites) {
        std::vector<std::list<int>> graph = buildGraph(numCourses, prerequisites);

        visited.resize(numCourses, false);
        onPath.resize(numCourses, false);

        for (int i = 0; i < numCourses; i++) {
            // 遍历图中的所有节点
            traverse(graph, i);
        }
        // 只要没有循环依赖可以完成所有课程
        return !hasCycle;
    }

    void traverse(const std::vector<std::list<int>>& graph, int s) {
        if (onPath[s]) {
            // 出现环
            hasCycle = true;/**<extend up -150>![](https://labuladong.online/algo/images/topological-sort/4.jpeg) */
        }

        if (visited[s] || hasCycle) {
            // 如果已经找到了环，也不用再遍历了
            return;
        }
        // 前序代码位置
        visited[s] = true;
        onPath[s] = true;
        for (int t : graph[s]) {
            traverse(graph, t);
        }
        // 后序代码位置
        onPath[s] = false;
    }

    std::vector<std::list<int>> buildGraph(int numCourses, std::vector<std::vector<int>>& prerequisites) {
        // 图中共有 numCourses 个节点
        std::vector<std::list<int>> graph(numCourses);
        for (const auto& edge : prerequisites) {
            int from = edge[1];
            int to = edge[0];
            // 修完课程 from 才能修课程 to
            // 在图中添加一条从 from 指向 to 的有向边
            graph[from].push_back(to);
        }
        return graph;
    }
};
```

</div></div>

<div data-tab-item="python" class="tab-item " data-tab-group="default"><div class="highlight">

```python
# 注意：python 代码由 chatGPT🤖 根据我的 java 代码翻译。
# 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

class Solution:
    # 记录一次 traverse 递归经过的节点
    def __init__(self):
        self.onPath = []
        # 记录遍历过的节点，防止走回头路
        self.visited = []
        # 记录图中是否有环
        self.hasCycle = False

    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        graph = self.buildGraph(numCourses, prerequisites)
        self.visited = [False] * numCourses
        self.onPath = [False] * numCourses

        for i in range(numCourses):
            # 遍历图中的所有节点
            self.traverse(graph, i)
        # 只要没有循环依赖可以完成所有课程
        return not self.hasCycle

    def traverse(self, graph: List[List[int]], s: int) -> None:
        if self.onPath[s]:
            # 出现环
            self.hasCycle = True # <extend up -150>![](https://labuladong.online/algo/images/topological-sort/4.jpeg) #
        
        if self.visited[s] or self.hasCycle:
            # 如果已经找到了环，也不用再遍历了
            return
        
        # 前序代码位置
        self.visited[s] = True
        self.onPath[s] = True
        for t in graph[s]:
            self.traverse(graph, t)
        
        # 后序代码位置
        self.onPath[s] = False

    def buildGraph(self, numCourses: int, prerequisites: List[List[int]]) -> List[List[int]]:
        # 图中共有 numCourses 个节点
        graph = [[] for _ in range(numCourses)]
        for edge in prerequisites:
            from_node = edge[1]
            to_node = edge[0]
            # 修完课程 from 才能修课程 to
            # 在图中添加一条从 from 指向 to 的有向边
            graph[from_node].append(to_node)
        return graph
```

</div></div>

<div data-tab-item="java" class="tab-item active" data-tab-group="default"><div class="highlight">

```java
class Solution {
    // 记录一次 traverse 递归经过的节点
    boolean[] onPath;
    // 记录遍历过的节点，防止走回头路
    boolean[] visited;
    // 记录图中是否有环
    boolean hasCycle = false;

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = buildGraph(numCourses, prerequisites);

        visited = new boolean[numCourses];
        onPath = new boolean[numCourses];

        for (int i = 0; i < numCourses; i++) {
            // 遍历图中的所有节点
            traverse(graph, i);
        }
        // 只要没有循环依赖可以完成所有课程
        return !hasCycle;
    }

    void traverse(List<Integer>[] graph, int s) {
        if (onPath[s]) {
            // 出现环
            hasCycle = true;/**<extend up -150>![](https://labuladong.online/algo/images/topological-sort/4.jpeg) */
        }

        if (visited[s] || hasCycle) {
            // 如果已经找到了环，也不用再遍历了
            return;
        }
        // 前序代码位置
        visited[s] = true;
        onPath[s] = true;
        for (int t : graph[s]) {
            traverse(graph, t);
        }
        // 后序代码位置
        onPath[s] = false;
    }

    List<Integer>[] buildGraph(int numCourses, int[][] prerequisites) {
        // 图中共有 numCourses 个节点
        List<Integer>[] graph = new LinkedList[numCourses];
        for (int i = 0; i < numCourses; i++) {
            graph[i] = new LinkedList<>();
        }
        for (int[] edge : prerequisites) {
            int from = edge[1];
            int to = edge[0];
            // 修完课程 from 才能修课程 to
            // 在图中添加一条从 from 指向 to 的有向边
            graph[from].add(to);
        }
        return graph;
    }
}
```

</div></div>

<div data-tab-item="go" class="tab-item " data-tab-group="default"><div class="highlight">

```go
// 注意：go 代码由 chatGPT🤖 根据我的 java 代码翻译。
// 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

func canFinish(numCourses int, prerequisites [][]int) bool {
    graph := buildGraph(numCourses, prerequisites)

    // 记录一次 traverse 递归经过的节点
    onPath := make([]bool, numCourses)
    // 记录遍历过的节点，防止走回头路
    visited := make([]bool, numCourses)
    // 记录图中是否有环
    hasCycle := false

    for i := 0; i < numCourses; i++ {
        // 遍历图中的所有节点
        traverse(graph, i, visited, onPath, &hasCycle)
    }
    // 只要没有循环依赖可以完成所有课程
    return !hasCycle
}

func traverse(graph [][]int, s int, visited, onPath []bool, hasCycle *bool) {
    if onPath[s] {
        // 出现环
        *hasCycle = true
        return
    }

    if visited[s] || *hasCycle {
        // 如果已经找到了环，也不用再遍历了
        return
    }
    // 前序代码位置
    visited[s] = true
    onPath[s] = true
    for _, t := range graph[s] {
        traverse(graph, t, visited, onPath, hasCycle)
    }
    // 后序代码位置
    onPath[s] = false
}

func buildGraph(numCourses int, prerequisites [][]int) [][]int {
    // 图中共有 numCourses 个节点
    graph := make([][]int, numCourses)
    for i := 0; i < numCourses; i++ {
        graph[i] = []int{}
    }
    for _, edge := range prerequisites {
        from := edge[1]
        to := edge[0]
        // 修完课程 from 才能修课程 to
        // 在图中添加一条从 from 指向 to 的有向边
        graph[from] = append(graph[from], to)
    }
    return graph
}
```

</div></div>

<div data-tab-item="javascript" class="tab-item " data-tab-group="default"><div class="highlight">

```javascript
// 注意：javascript 代码由 chatGPT🤖 根据我的 java 代码翻译。
// 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

var canFinish = function(numCourses, prerequisites) {
    // 记录一次 traverse 递归经过的节点
    let onPath = new Array(numCourses).fill(false);
    // 记录遍历过的节点，防止走回头路
    let visited = new Array(numCourses).fill(false);
    // 记录图中是否有环
    let hasCycle = false;

    let graph = buildGraph(numCourses, prerequisites);

    for (let i = 0; i < numCourses; i++) {
        // 遍历图中的所有节点
        traverse(graph, i);
    }
    // 只要没有循环依赖可以完成所有课程
    return !hasCycle;

    function traverse(graph, s) {
        if (onPath[s]) {
            // 出现环
            hasCycle = true;
        }

        if (visited[s] || hasCycle) {
            // 如果已经找到了环，也不用再遍历了
            return;
        }
        // 前序代码位置
        visited[s] = true;
        onPath[s] = true;
        for (let t of graph[s]) {
            traverse(graph, t);
        }
        // 后序代码位置
        onPath[s] = false;
    }

    function buildGraph(numCourses, prerequisites) {
        // 图中共有 numCourses 个节点
        let graph = new Array(numCourses).fill(0).map(() => []);
        for (let edge of prerequisites) {
            let from = edge[1];
            let to = edge[0];
            // 修完课程 from 才能修课程 to
            // 在图中添加一条从 from 指向 to 的有向边
            graph[from].push(to);
        }
        return graph;
    }
};
```

</div></div>
</div></div>

<hr /><details open hint-container details><summary style="font-size: medium"><strong>🌈🌈 算法可视化 🌈🌈</strong></summary><div id="data_course-schedule"  category="leetcode" ></div><div class="resizable aspect-ratio-container" style="height: 100%;">
<div id="iframe_course-schedule"></div></div>
</details><hr /><br />

</div>
</details>
</div>



