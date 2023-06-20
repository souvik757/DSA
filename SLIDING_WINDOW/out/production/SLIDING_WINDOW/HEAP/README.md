# Heap

````
 Heap is CBT , that comes with a heap priority order
 - > In MaxHeap  , root.val >= child.val  
 - > In MinHeap  , root.val <= child.val
 💡 Heap is what PriorityQueue is and how it is implemented in the backend ?
 ````
# CBT
````
 -> i.   must have 0 , 1 , 2 child only .
 -> ii.  insertion will be in left to right order for each level .
 -> iii. each level must be full. except the last one .
                  1
                /   \
      ✔       2     3 
              / \   / 
             4   5 6
            
                 1
                / \
      ❌       2   3
              / \   \
             4   5   6 
````
# Contents

- ### [MaxHeap](https://github.com/souvik757/DSA/blob/master/SLIDING_WINDOW/HEAP/MaxHeap.java)
- ### [MinHeap](https://github.com/souvik757/DSA/blob/master/SLIDING_WINDOW/HEAP/MinHeap.java)
- ### [GenericHeap](https://github.com/souvik757/DSA/blob/master/SLIDING_WINDOW/HEAP/GenericHeap.java)
- ### [HeapSort](https://github.com/souvik757/DSA/blob/master/SLIDING_WINDOW/HEAP/HeapSort.java)
