# vampire-game
This is my solution to the final exercise in week 10 of the University of Helsinki's (free) object-oriented programming course. See here for more details: https://materiaalit.github.io/2013-oo-programming/part2/week-10/ 

The game outputs a text representation of the dungeon, displaying vampire locations, the player's location, and the torch battery level (i.e. the number of moves left), as well as coordinates of the locations. The player moves using the controls: w-a-s-d for up-left-down-right. The player can decide the size of the dungeon and the difficulty level, but the number of vampires and the torch battery level is decided by the program.

The player wins if they catch all the vampires before the torch battery runs out. If there are any left when it runs out then the player loses and is killed by the vampires.

The below shows what the output looks like. The current number of moves left (15) is shown, the coordinates of the player and the vampires are next, and then the dungeon map.

15

@ 0 0
v 2 2
v 3 6
v 1 4
v 6 1
v 1 2

@--------
------v---
-vv------
---------
-v-------
---------
---v-----
---------
---------
