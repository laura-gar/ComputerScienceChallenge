# Computer Science Challenge

## Challenge Details
As an algorithm engineer, you need to implement a path detection algorithm for automated
harvesting. You have under your command a fleet of coffee-harvesting robots that will go
uphill from the robot station to the coffee plantation, which is allocated on the side of a
mountain, as is typical in Colombia, to collect ripe coffee berries. An algorithm has processed
remote sensing data and determined which trees are ready to be harvested, with the following
conventions:
1. If the tree is ready for harvest: A positive integer, increasing with elevation respect to
   the robot station.
2. If the tree is not ready for harvest: An integer negative one.

## Solution 
Recursive approach
1. Select one cell to start. 
2. Find all paths begin with this cell.  
3. Save paths and mark cell as visited.
4. Select another cell that hasn't been visited and repeat steps 2 and 3.
5. After visiting all cells, review all paths found and select the longest and steepest path. 