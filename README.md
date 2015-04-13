Algorithms [![Build Status](https://travis-ci.org/piotrglazar/algorithm.svg?branch=master)](https://travis-ci.org/piotrglazar/algorithm) [![Coverage Status](https://coveralls.io/repos/piotrglazar/algorithm/badge.png?branch=master)](https://coveralls.io/r/piotrglazar/algorithm?branch=master)
----------

This project is a solution base for some of the algorithmic problems

Max subarray
------------
Given an int array (or list) find its maximum subarray. It is a consistent fragment with the maximum sum of elements.
For example:
given [4, 1, -3, -3, 3, -2, 6] the program should return 7.

Hero
----
A brave hero fights monsters. Each monster guards a chest with a health potion inside. Can he defeat all monsters?
Assuming that he has 5 HP at the beginning and three monsters:
3 1
4 8
8 3
The optimal fight order is: 2, 3, 1

Puzzle
------
There is a board 3 x n pieces. We try to cover that board with 2 x 1 puzzles. The program should calculate the
number of ways we can cover the board. Given the board 3 x 2 we can cover it in three ways.

Moonwalk
--------
Michael Jackson dances on the set of Billie Jean music video. He has prepared a sequence of moves:
- G (up)
- D (down)
- P (right)
- L (left)
We want to know whether or not he can reach a certain point on the floor. For example, can he reach a point (6, 3)
with a sequence of dance moves "GGPPD"? The answer is yes.
