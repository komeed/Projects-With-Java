# Word Hunt Solvers:
Either use word hunt solvers with trie or word hunt solver. (discrepancy mentioned later). <br />
Cheat for Game Pigeon Word Hunt. From the Word Hunt screen, input letters row major order (left to right, top to bottom). <br />
Being one of my last projects, this was the first one using java swing for ui instead of ASCII. upon entering input, swing will generate a new window that has the 4x4 matrix with red circle representing starting point and black line representing path. To go to next word found, press enter in terminal. <br />
The solver goes from most letters to least letters.

 - **Word Hunt Solver With Trie:** Used Trie Data Structure to streamline character storage and retrieval and to store the 4x4 matrix as a Trie itself to search and remove trie nodes instead of using visited arrays.
 - **Word Hunt Solver:** My own implementation for Word Hunt Solver. Used DFS and visited arrays (obviously slower & less efficient than Trie). Rather than finding all letter combinations possible, in each iteration I checked if the letters combined were found to start any word from my word list.
 #

# Letters Boxed Cheat:
Cheat for nytimes letter boxed. To use properly, input the letters in order of top left corner of top row to clockwise (no spaces). The "How Many Words" msg determines how many words necessary to solve it. Then, it outputs each word with a dash in the middle to show the order required to win. <br />
**WARNING**: since nytimes doesn't share its word list, some words given might be invalid in nytimes.
#

# Wordle:
Free Wordle Generator in Console. correct letters surrounded with 'g's, yellow letters surrounded with 'y's. No bugs.
#

# ASCII 2048:
2048 shown through terminal. Use wasd as input to move the board around. For instance, typing 'w' in terminal and pressing enter will move all the numbers up, 'd' being down, etc.
#

# ASCII Chess: 
2 player game of chess shown through terminal (ASCII) with p1 on bottom and p2 on top. use chess letter & number notation (a2a4) and type in terminal input. 
Unfortunately, the game is still a work in progress, so its functionalities for illegal move checking is in progress. Please only preform legal moves.
#

# ASCII Tetris:
Tetris game played in console. You will be shown a tetris block at the top and asked to input two numbers. First number = column for bottom left corner, second number = 90deg clockwise rotation. i.e., '51' will put the bottom left corner of piece in column 5 with 90deg rotation clockwise. As a result, there is no time limit for placing blocks. <br />
**WARNING**: due to the ascii style being forced to represent squares as |_|, chaining squares leads to |_|_|_|, which can be unclear in whether the middle square is filled or not.
#

# Connect 4:
ASCII connect 4. Two player, input is only 1 number corresponding to row. no bugs.
#

