# Chess AI Project
## Documents 
[Agent definition document](https://docs.google.com/document/d/1KTfTqp9OfzO11Uu8zZHY91P2_iA9BP6XXEqV7WZMFqA/edit?usp=sharing) <br />

[Simple Agent Document](https://docs.google.com/document/d/1HFow4WrWSdqmH6UTLfXDb4flktN6dIYXJNHY2sGrCs0/edit?usp=sharing) <br />

[Advanced AI Research and Application Plan](https://docs.google.com/document/d/1EwDlS-KUv8nsHqu7N7JtdMXoOBwyBQOg_kmFt-z1QQk/edit) <br />

[Experimentation data and results](https://docs.google.com/document/d/1TaL72y3nENyOFzorxQN5g4t9O91049h3OqdaaSnXIDk/edit?usp=sharing) <br />


## Agent Information

Internal Agents: \
Meta agent that can plug different agents together <br />
Simple rules-based reflex agent <br />
Opening move agent <br />
Search-based by depth agent <br />

Simple AI agent code location: \
src\main\java\ithaca\teamfour\player…

How a human can act as an agent: \
Make sure to have a human player in the main where the ChessGame line is, it should look like this, but you can replace the MetaAgent with whatever secondary agent you want to play against 
```
ChessGame game = new ChessGame(new Board(),  new HumanPlayer(), new MetaAgent(player1));
```
Then run the ChessMain and enter coordinates of a move you want to do on your turn

The sensor and actuator interfaces are located in the codebase: \
src\main\java\ithaca\teamfour\player\ChessGame.java

## How to guide
Write a class that implements our ChessPlayer Interface. 
To add a piece to the meta agent, write it so that it can try and generate a move in the users own way and if it cannot it returns null so then it would be passed on to another part of the meta agent <br />
Wirte a class that implements ChessPlayer and need to write a chooseMove function that returns a valid move for their side of the board. <br />
Need to import it in the ChessMain.java file. If using the meta agent may also need to update the arraylist that initializes meta agent <br />


## Testing
Manual testing and running against other agents  [linked here](https://docs.google.com/document/d/1TaL72y3nENyOFzorxQN5g4t9O91049h3OqdaaSnXIDk/edit?usp=sharing)
Non-functional: SearchBasedAdvanceAgent: the evaluation function of the agent didn't seem to improve the agent's gameplay so it was left out
## Environment Set Up
Credit for chess environment:   
https://github.com/bhlangonijr/chesslib

