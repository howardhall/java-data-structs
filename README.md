# Some data structures in java
### RedBlackBinaryTree.java is incredibly broken.
## Comparison of List implementations
#### ArrayList
List implementation using a resizable array.  
Array will expand when there is no extra space.  
Expansion will incur a performance penalty, hence chosing the correct base size is a good idea.  

#### LinkedList
List implementation using Node objects which contain data and a pointer to the next item in the list.  
The LinkedList object keeps pointers to the head and tail of the list.  
Often has poor performance due to cache misses.  

#### Performance
| Worst Case | Add       | Get  | Contains | Remove |
|------------|-----------|------|----------|--------|
| ArrayList  | O(1)/O(n) | O(1) | O(n)     | O(n)   |
| LinkedList | O(1)/O(n) | O(n) | O(n)     | O(1)   |

#### Notes
* ArrayList add is O(1) unless expansion of internal array is neccessary.  
* LinkedList add is O(1) at start or end, O(n) otherwise.  
* ArrayList remove is O(n) as elements after the removed one must be shifted down 1 place.

#### Conclusions
1. ArrayList is recommended in most situations.
2. LinkedList can be good for short lists such as hash table buckets.

## Comparison of Map implementations
#### ArrayMap
Map implementation using an ArrayList of key-value pair.  
Elements remain in the order they were inserted in.  
Performance penalty when the ArrayList resizes.  

#### HashMap
Map implementation using a HashTable of key-value pair.  
Keys are hashed for fast searching.  
Elements do not remain in order.  

#### LinkedHashMap
Map implementation using a HashTable with a LinkedList for retaining order.  
No major penalty to insertion as inserting to tail of LinkedList is O(1).  
Remove operation slowed by LinkedList.  

#### Performance
| Worst Case    | Add  | Get  | Contains | Set  | Remove |
|---------------|------|------|----------|------|--------|
| ArrayMap      | O(1) | O(n) | O(n)     | O(n) | O(n)   |
| HashMap       | O(1) | O(m) | O(m)     | O(m) | O(m)   |
| LinkedHashMap | O(1) | O(m) | O(m)     | O(n) | O(n)   |

#### Notes
* O(m) is time complexity for one bucket of hash table.  
* LinkedHashMap set and remove are penalised from updating the LinkedList.  

#### Conclusions
1. HashMap offers the best performance, hence should be the first choice  
2. LinkedHashMap should be used if retaining original order is neccessary  
3. ArrayMap is usually worse than LinkedHashMap due to worse performance  
4. ArrayMap can be ok for small Maps due slightly lower memory overhead  

## Comparison of Priority Queue implementations
## Comparison of Set implementations
## Comparison of Tree implementations
## Comparison of Graph implementations
