# Interview Preparation Cheatsheet.

# Array

Arrays hold values of the same type at contigiuos memory location. Two important aspect about array.

1. Position / Index of an element.
2. The element itself.

### Simple initialization.

``` java
// Initialize array with the given size
int[] arr = new int[size];
// Initialize array with value
int[] arr = new int[] {1,2,3};
```
Default value when initialized.
| Type        | Default value |
| ----------- | ------------- |
| int         | 0             |
| char        | \u0000 (null) |
| double      | 0.0d          |
| boolean     | false         |
| Object      | null          |

## Advantages
* Accessing elements is fast as long as you have the **index / position** of the element.
* Consumes less memory compared to **dictionary**.

## Disadvantages
* The size of the array is **fixed**. If the array is **full**, a **new array** has to be **allocated** and **existing** values are **copied** to the new one.
* Insertion and deletion of an element in the **start** or **middle** of an array takes O(n) time. Due to elements needs to be **shifted** before or after the operation.

## Common Terms
1. **Subarray** - a range of contiguos values within an array.
* Example: Given array : [2, 3, 4, 5, 1]. [4, 5, 1] is a subarray while [3, 5, 1] is not.
2. **Subsequence** - a sequence that can be derived from the given sequence by deleting some or no elements without changing the order of the remaining elements.
* Example: given an array [2, 3, 6, 1, 5, 4], [3, 1, 5] is a subsequence but [3, 5, 1] is not a subsequence.

| Operation          | Big-O           | Notes                  |
| -------------------| --------------- | ---------------------- |
| Access             | O(1)            |                        |
| Linear Search      | O(n)            |                        |
| Binary Search      | O(logn)         | Array must be sorted.  |
| Insert Front/Mid   | O(n)            | Due to element shift.  |
| Insert End         | O(1)            | Special Case.          |
| Delete Front/Mid   | O(n)            | Due to element shift.  |
| Delete End         | O(1)            | Special Case.          |

## Clarification & Tips during the interviews.
* Does the array have duplicate values? Does it affect your solution? Does it make the question simpler or harder?
* Iterating over the array make sure not to go out of bounds.
* Becareful when combining or slicing the array. Usually it would take O(n) time.

## Corner Cases.
* Empty array.
* Array with 1 or 2 elements.
* Duplicated values in the array.

## Techniques.
Since String is an array of characters, most techniques will also apply to **String** problems.

### Sliding Window



