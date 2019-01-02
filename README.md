# Some data structures in java
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
#### ArrayPriorityQueue
Priority Queue implemented using an ArrayList.  
Lowest Priority is found by using selection sort on removal.  
Elements are stored in the order they are inserted in.

#### HeapPriorityQueue
Priority Queue implemented using a MinHeap.  
Elements are inserted by adding to the end and bubbling up.  
Elements are removed by removing the parent, switching the last element up and bubbling down.  
Elements are stored in the heaps ordering, not relevant to anything.  

#### LinkedPriorityQueue
Priority Queue implemented using a LinkedList.  
Insertion sort is used when inserting elements.  
Elements are stored in ascending order.  

#### Performance
| Worst Case | Add      | Contains | Peek | Remove   |
|------------|----------|----------|------|----------|
| ArrayPQ    | O(1)     | O(n)     | O(n) | O(n)     |
| LinkedPQ   | O(n)     | O(n)     | O(1) | O(1)     |
| HeapPQ     | O(log n) | O(n)     | O(1) | O(log n) |

#### Notes
* ArrayPQ sorts on peek/remove
* LinkedPQ sorts on insert

#### Conclusions
1. HeapPQ offers the best overall performance especially for large heaps.
2. HeapPQ should be used, unless quick access to some sort of order is neccessary.
3. ArrayPQ is only good when almost all operations are insertion or insertion order is required.
4. LinkedPQ is only good when almost all operations are peek or remove or ascending order is required.

## Comparison of Set implementations
#### ArraySet
Set is implemented using an ArrayList.  
Linear search used to check if element already exists.  
Low memory overhead, ideal for small sets.  
Order of insertion is retained.  

#### HashSet
Set is implemented using a HashTable.  
Item is hashed to check if it exists.  
Hash table has great performance even on high load factors.  
Elements do not remain in order.  

#### LinkedHashSet
Set is implemented using a HastTable, with a LinkedList to retain the order.  
Item is hashed to check if it exists.  
Hash table has great performance even on high load factors.  
Certain operations have reduced performance due to the LinkedList.  
Elements do remain in order.  

#### Performance
| Worst Case    | Add  | Contains | Remove |
|---------------|------|----------|--------|
| ArraySet      | O(n) | O(n)     | O(n)   |
| HashSet       | O(m) | O(m)     | O(m)   |
| LinkedHashSet | O(m) | O(m)     | O(n)   |

#### Notes
* O(m) is the time complexity for one bucket of a hash table.
* LinkedHashSet remove is penalised from updating the LinkedList.

#### Conclusions
1. HashSet offers the best performance, hence should be the first choice
2. LinkedHashSet should be used if retaining original order is neccessary
3. ArraySet is usually worse than LinkedHashSet due to worse performance
4. ArraySet can be ok for small Sets due to slightly lower memory overhead


## Comparison of Tree implementations
## Comparison of Graph implementations

Check out custom Javadoc CSS generator at :  
https://github.com/nisrulz/javadoc-themer
