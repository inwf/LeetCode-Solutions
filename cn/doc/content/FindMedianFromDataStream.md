<p><strong>中位数</strong>是有序整数列表中的中间值。如果列表的大小是偶数，则没有中间值，中位数是两个中间值的平均值。</p>

<ul> 
 <li>例如 <code>arr = [2,3,4]</code>&nbsp;的中位数是 <code>3</code>&nbsp;。</li> 
 <li>例如&nbsp;<code>arr = [2,3]</code> 的中位数是 <code>(2 + 3) / 2 = 2.5</code> 。</li> 
</ul>

<p>实现 MedianFinder 类:</p>

<ul> 
 <li> <p><code>MedianFinder()</code> 初始化 <code>MedianFinder</code>&nbsp;对象。</p> </li> 
 <li> <p><code>void addNum(int num)</code> 将数据流中的整数 <code>num</code> 添加到数据结构中。</p> </li> 
 <li> <p><code>double findMedian()</code> 返回到目前为止所有元素的中位数。与实际答案相差&nbsp;<code>10<sup>-5</sup></code>&nbsp;以内的答案将被接受。</p> </li> 
</ul>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入</strong>
["MedianFinder", "addNum", "addNum", "findMedian", "addNum", "findMedian"]
[[], [1], [2], [], [3], []]
<strong>输出</strong>
[null, null, null, 1.5, null, 2.0]

<strong>解释</strong>
MedianFinder medianFinder = new MedianFinder();
medianFinder.addNum(1);    // arr = [1]
medianFinder.addNum(2);    // arr = [1, 2]
medianFinder.findMedian(); // 返回 1.5 ((1 + 2) / 2)
medianFinder.addNum(3);    // arr[1, 2, 3]
medianFinder.findMedian(); // return 2.0</pre>

<p><strong>提示:</strong></p>

<ul> 
 <li><code>-10<sup>5</sup>&nbsp;&lt;= num &lt;= 10<sup>5</sup></code></li> 
 <li>在调用 <code>findMedian</code>&nbsp;之前，数据结构中至少有一个元素</li> 
 <li>最多&nbsp;<code>5 * 10<sup>4</sup></code>&nbsp;次调用&nbsp;<code>addNum</code>&nbsp;和&nbsp;<code>findMedian</code></li> 
</ul>

<details><summary><strong>Related Topics</strong></summary>设计 | 双指针 | 数据流 | 排序 | 堆（优先队列）</details><br>

<div>👍 1190, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/issues' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.online/algo/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.online/algo/' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：为满足广大读者的需求，网站上架 [速成目录](https://labuladong.online/algo/intro/quick-learning-plan/)，如有需要可以看下，谢谢大家的支持~**



<p><strong><a href="https://labuladong.online/algo/practice-in-action/find-median-from-data-stream/" target="_blank">⭐️labuladong 题解</a></strong></p>
<details><summary><strong>labuladong 思路</strong></summary>


<div id="labuladong_solution_zh">

## 基本思路

本题的核心思路是使用两个 [优先级队列](https://labuladong.online/algo/data-structure-basic/binary-heap-basic/)。

![](https://labuladong.online/algo/images/median/1.jpeg)


小的倒三角就是个大顶堆，梯形就是个小顶堆，中位数可以通过它们的堆顶元素算出来：

![](https://labuladong.online/algo/images/median/2.jpeg)

**详细题解**：
  - [拓展：两个二叉堆实现中位数算法](https://labuladong.online/algo/practice-in-action/find-median-from-data-stream/)
  - [【练习】优先级队列经典习题](https://labuladong.online/algo/problem-set/binary-heap/)

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

class MedianFinder {

private:
    // 大顶堆
    std::priority_queue<int, std::vector<int>, std::greater<>> large;
    // 小顶堆
    std::priority_queue<int, std::vector<int>, std::less<>> small;

public:
    double findMedian() {/**<extend up -100>![](https://labuladong.online/algo/images/median/2.jpeg) */
        // 如果元素不一样多，多的那个堆的堆顶元素就是中位数
        if (large.size() < small.size()) {
            return small.top();
        } else if (large.size() > small.size()) {
            return large.top();
        }
        // 如果元素一样多，两个堆堆顶元素的平均数是中位数
        return (double)(large.top() + small.top()) / 2.0;/**<extend up -100>![](https://labuladong.online/algo/images/median/1.jpeg) */
    }

    // 正确的代码实现
    void addNum(int num) {
        if (small.size() >= large.size()) {
            small.push(num);
            large.push(small.top());
            small.pop();
        } else {
            large.push(num);
            small.push(large.top());
            large.pop();
        }
    }
};
```

</div></div>

<div data-tab-item="python" class="tab-item " data-tab-group="default"><div class="highlight">

```python
# 注意：python 代码由 chatGPT🤖 根据我的 java 代码翻译。
# 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

import heapq

class MedianFinder:
    def __init__(self):
        # 小顶堆，保存较大的一半
        self.large = []
        # 大顶堆，保存较小的一半
        self.small = []

    def findMedian(self) -> float: # <extend up -100>![](https://labuladong.online/algo/images/median/2.jpeg) #
        if len(self.small) > len(self.large):
            return -self.small[0]
        elif len(self.large) > len(self.small):
            return self.large[0]
        else:
            return (-self.small[0] + self.large[0]) / 2 # <extend up -100>![](https://labuladong.online/algo/images/median/1.jpeg) #

    def addNum(self, num: int) -> None:
        # 添加到大顶堆
        heapq.heappush(self.small, -num)
        # 将大顶堆中的最大值移到小顶堆
        heapq.heappush(self.large, -heapq.heappop(self.small))

        # 如果小顶堆的元素多于大顶堆，则需要平衡它们
        if len(self.large) > len(self.small):
            heapq.heappush(self.small, -heapq.heappop(self.large))
```

</div></div>

<div data-tab-item="java" class="tab-item active" data-tab-group="default"><div class="highlight">

```java
class MedianFinder {
    private PriorityQueue<Integer> large;
    private PriorityQueue<Integer> small;

    public MedianFinder() {
        // 小顶堆
        large = new PriorityQueue<>();
        // 大顶堆
        small = new PriorityQueue<>((a, b) -> {
            return b - a;
        });
    }

    public double findMedian() {/**<extend up -100>![](https://labuladong.online/algo/images/median/2.jpeg) */
        // 如果元素不一样多，多的那个堆的堆顶元素就是中位数
        if (large.size() < small.size()) {
            return small.peek();
        } else if (large.size() > small.size()) {
            return large.peek();
        }
        // 如果元素一样多，两个堆堆顶元素的平均数是中位数
        return (large.peek() + small.peek()) / 2.0;/**<extend up -100>![](https://labuladong.online/algo/images/median/1.jpeg) */
    }

    public void addNum(int num) {
        if (small.size() >= large.size()) {
            small.offer(num);
            large.offer(small.poll());
        } else {
            large.offer(num);
            small.offer(large.poll());
        }
    }
}
```

</div></div>

<div data-tab-item="go" class="tab-item " data-tab-group="default"><div class="highlight">

```go
// 注意：go 代码由 chatGPT🤖 根据我的 java 代码翻译。
// 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

// 实现 priority_queue 的接口
type intMaxHeap []int

func (h intMaxHeap) Len() int {
    return len(h)
}

func (h intMaxHeap) Less(i, j int) bool {
    return h[i] > h[j]
}

func (h intMaxHeap) Swap(i, j int) {
    h[i], h[j] = h[j], h[i]
}

func (h *intMaxHeap) Push(x interface{}) {
    *h = append(*h, x.(int))
}

func (h *intMaxHeap) Pop() interface{} {
    n := len(*h)
    x := (*h)[n-1]
    *h = (*h)[:n-1]
    return x
}


type intMinHeap []int

func (h intMinHeap) Len() int {
    return len(h)
}

func (h intMinHeap) Less(i, j int) bool {
    return h[i] < h[j]
}

func (h intMinHeap) Swap(i, j int) {
    h[i], h[j] = h[j], h[i]
}

func (h *intMinHeap) Push(x interface{}) {
    *h = append(*h, x.(int))
}

func (h *intMinHeap) Pop() interface{} {
    n := len(*h)
    x := (*h)[n-1]
    *h = (*h)[:n-1]
    return x
}

type MedianFinder struct {
    large *intMinHeap
    small *intMaxHeap
}

func Constructor() MedianFinder {
    // 小顶堆
    large := &intMinHeap{}
    // 大顶堆
    small := &intMaxHeap{}
    return MedianFinder{large, small}
}

func (mf *MedianFinder) FindMedian() float64 {/**<extend up -100>![](https://labuladong.online/algo/images/median/2.jpeg) */
    // 如果元素不一样多，多的那个堆的堆顶元素就是中位数
    if mf.large.Len() < mf.small.Len() {
        return float64((*mf.small)[0])
    } else if mf.large.Len() > mf.small.Len() {
        return float64((*mf.large)[0])
    }
    // 如果元素一样多，两个堆堆顶元素的平均数是中位数
    return float64((*mf.large)[0]+(*mf.small)[0]) / 2.0/**<extend up -100>![](https://labuladong.online/algo/images/median/1.jpeg) */
}

func (mf *MedianFinder) AddNum(num int) {
    // 添加到大顶堆
    heap.Push(mf.small, num)
    // 将大顶堆中的最大值移到小顶堆
    heap.Push(mf.large, heap.Pop(mf.small))

    // 如果小顶堆的元素多于大顶堆，则需要平衡它们
    if mf.large.Len() > mf.small.Len() {
        heap.Push(mf.small, heap.Pop(mf.large))
    }
}
```

</div></div>

<div data-tab-item="javascript" class="tab-item " data-tab-group="default"><div class="highlight">

```javascript
// 注意：javascript 代码由 chatGPT🤖 根据我的 java 代码翻译。
// 本代码的正确性已通过力扣验证，如有疑问，可以对照 java 代码查看。

var MedianFinder = function() {
    // 小顶堆
    let large = new MinPriorityQueue();
    // 大顶堆
    let small = new MaxPriorityQueue();

    this.findMedian = function () {/**<extend up -100>![](https://labuladong.online/algo/images/median/2.jpeg) */
        // 如果元素不一样多，多的那个堆的堆顶元素就是中位数
        if (large.size() < small.size()) {
            return small.front().element;
        } else if (large.size() > small.size()) {
            return large.front().element;
        }
        // 如果元素一样多，两个堆堆顶元素的平均数是中位数
        return (large.front().element + small.front().element) / 2.0;/**<extend up -100>![](https://labuladong.online/algo/images/median/1.jpeg) */
    }

    this.addNum = function (num) {
        if (small.size() >= large.size()) {
            small.enqueue(num);
            large.enqueue(small.dequeue().element);
        } else {
            large.enqueue(num);
            small.enqueue(large.dequeue().element);
        }
    }
}
```

</div></div>
</div></div>

</div>
</details>
</div>

