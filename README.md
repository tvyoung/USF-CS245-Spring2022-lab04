Vicki Young
2022.02.24
CS 245-03 Lab04 multiSum

general information:
- running time: O(n)
- space: O(n * k)
- program accepts an input of integer n and will return an arraylist of arraylists which are unique combinations of factors to n
- program does not accept negative integers or integers >= 2^16
- program creates the first factor which will be either [1, n] or [n] if n = 0 or n  = 1
- running time of overall program has for loops which roughly depend on size of n to find factors
- k = number of factors in a unique factor combination of n 

multiSum() function:
- running time: O(1)
- space: O(n)
- declares and initializes arraylist of arraylists, the # of factor combinations which depend on the size of n

findFactors() function:
- running time: O(n)
- space: O(k)
- recursively calls itself for about k = number of factors in a unique combination of n
