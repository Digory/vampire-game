# vampire-game
This is my solution to the final exercise in week 10 of the University of Helsinki's (free) object-oriented programming course. See here for more details: https://materiaalit.github.io/2013-oo-programming/part2/week-10/ 

The game outputs a text representation of the dungeon, displaying vampire locations, the player's location, and the torch battery level (i.e. the number of moves left), as well as coordinates of the locations. The player moves using the controls: w-a-s-d for up-left-down-right. The player can decide the size of the dungeon and the difficulty level, but the number of vampires and the torch battery level is decided by the program.

The player wins if they catch all the vampires before the torch battery runs out. If there are any left when it runs out then the player loses and is killed by the vampires.

The game could potentially be improved by having a 'boss' vampire which chases you around and only dies when you kill the rest of the vampires. I'll have to figure out how to do that.
