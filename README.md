# Interview Preparation Cheatsheet.

## Solving problem.
1. Read the question carefully. 
2. Ask any questions that are not clear.
3. Think about corner cases.
4. Start with bruteforce solution. Optimal solution comes from improving brute force.
5. Is your bruteforce time complexity too slow? If yes, is there any repetitive steps in your solution? If yes, think about a data structure that can remove that repetitive steps.
6. Improve your time complexity by sacrificing space.

## Array

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

## Techniques & Tips for Array.
1. Since String is an array of characters, most techniques will also apply to **String** problems.
2. Some problems needs combination of multiple techniques.

### Circular Array
* If there is a circular array, concat orignal array with itself to make the problem easier.
* Samething for string, if we are shifting character from one end to another.

### Sorting Array
* Does sorting the array make the problem easier? If yes sort it. Sorting costs O(nlogn)
* Are you searching something from an sorted array multiple times? If yes, use binary search. Binary search costs O(logn)

### Two Pointers.
* The two pointer technique is an algorithmic technique for solving problems by repeatedly moving two pointers through the data structure. It is a very efficient technique and can be used to solve a variety of problems.
* Both pointer starts at the same location and moves towards the same direction. (Sliding window) 
* Both pointer starts at the same location and moves towards opposite direction. (Expand around center)
* Both pointer starts from a different position and moves towards each other.

### Sliding Window. (Belongs to Two Pointer technique)
* Applies to subarray and substring problems.
* Two pointers starting from the begining and moves to the same direction. They will never cross each other.
* Time complexity is usually O(n). Each element is visited once or at most twice.
* Window size could be flexible or fixed.
* Sometimes you need to calculate the window size.
* Useful data structure for sliding window. HashMap -> Element - Position, Element -> Frequency. Queue minQue and maxQueue to keep track of min/max in the window.
``` java
// flexible window
int left = 0;
int right = 0;
// right pointer iterates over the array
while(right < arr.length) {
    Type r = arr[right];
    // condition updated
    /* 
        Ensure our sliding window is valid.
        Condition might have a different time complexity.
        Ideally O(1).
        Sometimes does not need a while loop
        it could be an if statement
        depends on the problem and optimization.
        Ex: left could jump to another index
        instead of incremented by 1.
    */
    while(condition != true) {
        Type l = arr[left];
        // update until condition is met
        left++;
    }
    // our window between [left, right] is valid
    right++;
}
// fixed window
while(right < arr.length) {
    Type r = arr[right];
    // condition updated
    if(right - left + 1== windowSize && condition) {
        // update answer
        Type l = arr[left];
        // update leftSide
        left++;
        // Ex: left could jump to another index
        // instead of incremented by 1.
    }
    // our window between [left, right] is valid
    right++;
}
```
### Traverse from Right to Left.
* Sometimes traversing from the right to left can make your code or the problem easier.

### Traverse the array more than once.
* Traverse the array more than once to make the problem easier by precalculating something first.

### Use some space to improve time complexity.
* HashMap, List, stack, queue.

### Array Problem examples.
    Two Sum
https://leetcode.com/problems/two-sum/

* Brute Force. Generate all possible pairs. Check if pairs sums to target. 
* Time Complexity O(n^2)
* Space Complecity O(1)
``` java
public int[] twoSum(int[] nums, int target) {
    int[] solution = new int[2];
    for(int i = 0; i < nums.length; i++) {
        for(int j = i + 1; j < nums.length; j++) {
            if(nums[i] + nums[j] == target) {
                solution[0] = i;
                solution[1] = j;
                break;
            }
        }
    }
    return solution;
}
```
* Sorting the array + Two pointer. Check Two Pointer bullet **#4** and Sorting Array Section.
* After sorting array we get an increasing array.
* Initialize left pointer to 0 and right pointer to array.length - 1
* Calculate sum array[left] + array[right].
1. If sum == target -> we found our solution.
2. else if sum < target -> our sum is not enough to reach target -> increase our sum by moving left pointer to right by 1.
3. else sum > target -> our sum is exceeded the target -> decrease our sum by moving right pointer to left by 1.
* Time Complexity O(nlogn + n) -> O(nlogn) because of sorting.
* Space Complexity O(1)

```java
public int[] twoSum(int[] nums, int target) {
    int[] solution = new int[2];
    Arrays.sort(nums);
    int left = 0;
    int right = nums.length - 1;
    while(left < right) {
        int sum = nums[left] + nums[right];
        if(sum == target) {
            solution[0] = left;
            solution[1] = right;
            break;
        } else if (sum < target) {
            left++;
        } else {
            right--;
        }
    }
    return solution;
}
```
* Using extra space.
* Note in bruteforce solution, we can improve the second for loop into a constant search by remembering the previously visited numbers.
* Using HashMap since the time complexity for HashMap look up is O(1)
* HashMap<Integer, Integer> we are mapping num to it's index
* For each number we need to check if (target - number) appeared before in out map. If yes we found the solution. If not put the current number to the map.
* Time Complexity O(n).
* Space Complexity O(n);
```java
public int[] twoSum(int[] nums, int target) {
    int[] solution = new int[2];
    HashMap<Integer> map = new HashMap<>();
    for(int i = 0; i < nums.length; i++) {
        int number = nums[i];
        int otherNumber = target - number;
        if(map.containsKey(otherNumber)) {
            solution[0] = map.get(otherNumber);
            solution[1] == i;
            break;
        }
        map.put(number, i);
    }
    return solution;
}
```
    Substrings of Size Three with Distinct Characters
https://leetcode.com/problems/substrings-of-size-three-with-distinct-characters/

* Brute Force. Generate All possible substring with size 3. For each substring check if there is no repeated character.
* Time Complexity O(n)
* Time Complexity O(1)
```java
public int countGoodSubstrings(String s) {
    int goodStrings = 0;
    for(int i = 0; i < s.length() - 2; i++) {
        String substring = s.substring(i, i + 3);
        if(isGood(substring)) {
            goodStrings++;
        }
    }
    return goodStrings;
}

public boolean isGood(String s) {
    return s.charAt(0) != s.charAt(1) && s.charAt(1) != s.charAt(2) && s.charAt(0) != s.charAt(2);
}
```
* Optimal Solution
* Two Pointer Technique + Sliding Window without gerating substring.
* After reading the problem it is asking for total number of goodSubstring with size 3 where there is no repeated character.
* Since the problem related to substring it is good idea to think about Sliding window.
* Time Complexity O(n)
* Time Complexity O(1)
* This solution is faster than brute force even though their time complexity is the same. because we are not generating any substring at all.
```java
public int countGoodSubstrings(String s) {
    int goodStrings = 0;
    int left = 0;
    int right = 0;
    while(right < s.length()) {
        if(right - left + 1 == 3) {
            if(s.charAt(left) != s.charAt(left + 1) && s.charAt(right) != s.charAt(left + 1) && s.charAt(left) != s.charAt(right)) {
                goodStrings++;
            }
            left++;
        }
        right++;
    }
    return goodStrings;
}
```





