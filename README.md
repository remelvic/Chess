<h1 align="Center">Semester Work (Chess)</h1>

## Topic

The theme of my semester work is **Chess**.
## Purpose

The purpose of my semester work is
* Write a full game "Chess"
* Deepen my knowledge of graphical user interface (_GUI_)
## Names of participants:
Remel Victor

<h1 align="Center">User Manual</h1>

## How to play

The rules of the game are the same as in regular chess. ~~You can play with both a computer and a human~~. Mouse control. 
>**How can move ?**
    First, right-click on the cell we want to go to. Then, by double-clicking the left mouse button, select the figure which we will go
<h1 align="Center">For the developer</h1>

## Classes used:
* **Board** (_Used to create a board.The color of the chessboard I use from chess.org. Also, I place the figures here and the game is held here._)
    * function `private void printLetters(){}` prints letters on the very first line of the board
    * function `private void printNumbers(){}` prints numbers at the end of each line
    * function `private void optionsToolbar(){}` Customize ToolBar with Save Game, Restore, New Game, Load Game buttons
    * function `public Board(){}` Board function adds squares, numbers and letters to the Window
    * function `private final void createImage(){}` Processing the image, from where we will take the figures
    * funciton `public final JComponent getWindow(){}` The getWindow function returns the whole window in which the game will be
* **Connect** (_I use to connect two players to each other_)
* **LoadGame** (_Load the game that is saved in a **.txt** file or in a **.png** format_)
* **Main** (_Launches the game. If the argument at index 0 is -1, then a new window will be launched. The argument at index 0 will be -1 only when the "Restore" button was clicked.The initial argument is 0_)
* **SaveGame** (_I use to save the game in **png** or **txt** format_)
* **Logic** (_In the Logic class, I choose where the figure will go and which figure will move._)
    * function `public static void errorMove(){}` If the player chooses the wrong move, an error window pops up
    * function `public void Logic(JButton[][] chessSquares, Image[][] chessImage,
                      int i, int j, int myX, int myY,int width, int height, String figureOpponent){}` The Logic function determines from which coordinates the figure comes and which figure it will be. 
        >**@param** ChessSquares (_an array of all buttons (squares)_)

        >**@param** chessImage (_an array of all pieces_)

        >**@param** i (_determines the size of the array in x_)

        >**@param** j (_determines the size of the array in y_)

        >**@param** myX (_X-coordinates where the figure is going_)

        >**@param** myY (_Y-coordinates where the figure is going_)

        >**@param** width (_of one square is used to move shapes in X_)

        >**@param** height (_of one square is used to move shapes in Y_)

        >**@param** figureOpponent (_contains the name of the square that we chose where we will go_)
        
        >**@param** textGame(_Will contain the whole game in pgn format_)
* **Timer** (_I use the timer to calculate the time between the players' moves_)
    ### Used classes in a separate folder:
    * **BishopBlack** (_The BishopBlack class executes the black Bishop figure_)
        * function `public void BishopBlack(JButton[][] chessSquares, Image[][]chessImage,
                            int myX, int myY, int xLast, int yLast, int i, int j,
                            int height, int width, String figureOpponent){}` The BishopBlack function selects how the shape will go and moves it. If the selected move is placed on a black piece, an error window will appear.
            > **@param** ChessSquares (_an array of all buttons (squares)_)

            > **@param** chessImage (_an array of all pieces_)

            > **@param** myX (_X-coordinates where the figure is going_)

            > **@param** myY (_Y-coordinates where the figure is going_)

            > **@param** XLast (_X coordinates from where the shape is coming from_)

            > **@param** Ylast (_Y coordinates from where the shape is coming from_)

            > **@param** i (_determines the size of the array in x_)

            > **@param** j (_determines the size of the array in y_)

            > **@param** height (_of one square is used to move shapes in Y_)

            > **@param** width (_of one square is used to move shapes in X_)

            > **@param** figureOpponent (_contains the name of the square that we chose where we will go_)
    * **BishopWhite** (_The BishopWhite class executes the white Bishop figure_)
        * function `public void BishopWhite(JButton[][] chessSquares, Image[][]chessImage,
                            int myX, int myY, int xLast, int yLast, int i, int j,
                            int height, int width, String figureOpponent){}` The BishopWhite function selects how the shape will go and moves it. If the selected move is placed on a white piece, an error window will appear.
            > **@param** ChessSquares (_an array of all buttons (squares)_)

            > **@param** chessImage (_an array of all pieces_)

            > **@param** myX (_X-coordinates where the figure is going_)

            > **@param** myY (_Y-coordinates where the figure is going_)

            > **@param** XLast (_X coordinates from where the shape is coming from_)

            > **@param** Ylast (_Y coordinates from where the shape is coming from_)

            > **@param** i (_determines the size of the array in x_)

            > **@param** j (_determines the size of the array in y_)

            > **@param** height (_of one square is used to move shapes in Y_)

            > **@param** width (_of one square is used to move shapes in X_)

            > **@param** figureOpponent (_contains the name of the square that we chose where we will go_)
    * **KingBlack** (_The KingBlack class executes the black King figure_)
        * function `public void KingBlack(function public void BishopBlack(JButton[][] chessSquares, Image[][]chessImage,
                            int myX, int myY, int xLast, int yLast, int i, int j,
                            int height, int width, String figureOpponent)){}` The KingBlack function selects how the shape will go and moves it.If the selected move is placed on a black piece, an error window will appear.
            > **@param** ChessSquares (_an array of all buttons (squares)_)

            > **@param** chessImage (_an array of all pieces_)

            > **@param** myX (_X-coordinates where the figure is going_)

            > **@param** myY (_Y-coordinates where the figure is going_)

            > **@param** XLast (_X coordinates from where the shape is coming from_)

            > **@param** Ylast (_Y coordinates from where the shape is coming from_)

            > **@param** i (_determines the size of the array in x_)

            > **@param** j (_determines the size of the array in y_)

            > **@param** height (_of one square is used to move shapes in Y_)

            > **@param** width (_of one square is used to move shapes in X_)

            > **@param** figureOpponent (_contains the name of the square that we chose where we will go_)
    * **KingWhite** (_The KingWhite class executes the white King figure_)
        * function `public void KingWhite(JButton[][] chessSquares, Image[][]chessImage,
                            int myX, int myY, int xLast, int yLast, int i, int j,
                            int height, int width, String figureOpponent){}` The KingWhite function selects how the shape will go and moves it.If the selected move is placed on a white piece, an error window will appear.
            > **@param** ChessSquares (_an array of all buttons (squares)_)

            > **@param** chessImage (_an array of all pieces_)

            > **@param** myX (_X-coordinates where the figure is going_)

            > **@param** myY (_Y-coordinates where the figure is going_)

            > **@param** XLast (_X coordinates from where the shape is coming from_)

            > **@param** Ylast (_Y coordinates from where the shape is coming from_)

            > **@param** i (_determines the size of the array in x_)

            > **@param** j (_determines the size of the array in y_)

            > **@param** height (_of one square is used to move shapes in Y_)

            > **@param** width (_of one square is used to move shapes in X_)

            > **@param** figureOpponent (_contains the name of the square that we chose where we will go_)
    * **KnightBlack** (_The KnightBlack class executes the black Knight figure_)
        * function `public void KnightBlack(JButton[][] chessSquares, Image[][]chessImage,
                            int myX, int myY, int xLast, int yLast, int i, int j,
                            int height, int width, String figureOpponent){}` The KnightBlack function selects how the shape will go and moves it.If the selected move is placed on a black piece, an error window will appear.
            > **@param** ChessSquares (_an array of all buttons (squares)_)

            > **@param** chessImage (_an array of all pieces_)

            > **@param** myX (_X-coordinates where the figure is going_)

            > **@param** myY (_Y-coordinates where the figure is going_)

            > **@param** XLast (_X coordinates from where the shape is coming from_)

            > **@param** Ylast (_Y coordinates from where the shape is coming from_)

            > **@param** i (_determines the size of the array in x_)

            > **@param** j (_determines the size of the array in y_)

            > **@param** height (_of one square is used to move shapes in Y_)

            > **@param** width (_of one square is used to move shapes in X_)

            > **@param** figureOpponent (_contains the name of the square that we chose where we will go_)
    * **KnightWhite** (_The KnightWhite class executes the white Knight figure_)
        * function `public void KnightWhite(JButton[][] chessSquares, Image[][]chessImage,
                            int myX, int myY, int xLast, int yLast, int i, int j,
                            int height, int width, String figureOpponent){}` The KnightWhite function selects how the shape will go and moves it.If the selected move is placed on a white piece, an error window will appear.
            > **@param** ChessSquares (_an array of all buttons (squares)_)

            > **@param** chessImage (_an array of all pieces_)

            > **@param** myX (_X-coordinates where the figure is going_)

            > **@param** myY (_Y-coordinates where the figure is going_)

            > **@param** XLast (_X coordinates from where the shape is coming from_)

            > **@param** Ylast (_Y coordinates from where the shape is coming from_)

            > **@param** i (_determines the size of the array in x_)

            > **@param** j (_determines the size of the array in y_)

            > **@param** height (_of one square is used to move shapes in Y_)

            > **@param** width (_of one square is used to move shapes in X_)

            > **@param** figureOpponent (_contains the name of the square that we chose where we will go_)
    * **PawnBlack** (_The PawnBlack class executes the black pawn figure_)
        * function `public void PawnBlack(JButton[][] chessSquares, Image[][]chessImage,
                            int myX, int myY, int xLast, int yLast, int i, int j,
                            int height, int width, String figureOpponent){}` The PawnBlack function selects how the shape will go and moves it.If the selected move is placed on a black piece, an error window will appear.
            > **@param** ChessSquares (_an array of all buttons (squares)_)

            > **@param** chessImage (_an array of all pieces_)

            > **@param** myX (_X-coordinates where the figure is going_)

            > **@param** myY (_Y-coordinates where the figure is going_)

            > **@param** XLast (_X coordinates from where the shape is coming from_)

            > **@param** Ylast (_Y coordinates from where the shape is coming from_)

            > **@param** i (_determines the size of the array in x_)

            > **@param** j (_determines the size of the array in y_)

            > **@param** height (_of one square is used to move shapes in Y_)

            > **@param** width (_of one square is used to move shapes in X_)

            > **@param** figureOpponent (_contains the name of the square that we chose where we will go_)
    * **PawnWhite** (_The PawnWhite class executes the white pawn figure_)
        * function `public void PawnWhite(JButton[][] chessSquares, Image[][]chessImage,
                            int myX, int myY, int xLast, int yLast, int i, int j,
                            int height, int width, String figureOpponent){}` The PawnWhite function selects how the shape will go and moves it. If the selected move is placed on a white piece, an error window will appear.
            > **@param** ChessSquares (_an array of all buttons (squares)_)

            > **@param** chessImage (_an array of all pieces_)

            > **@param** myX (_X-coordinates where the figure is going_)

            > **@param** myY (_Y-coordinates where the figure is going_)

            > **@param** XLast (_X coordinates from where the shape is coming from_)

            > **@param** Ylast (_Y coordinates from where the shape is coming from_)

            > **@param** i (_determines the size of the array in x_)

            > **@param** j (_determines the size of the array in y_)

            > **@param** height (_of one square is used to move shapes in Y_)

            > **@param** width (_of one square is used to move shapes in X_)

            > **@param** figureOpponent (_contains the name of the square that we chose where we will go_)
    * **QueenBlack** (_The QueenBlack class executes the black queen figure_)
        * function `public void QueenBlack(JButton[][] chessSquares, Image[][]chessImage,
                            int myX, int myY, int xLast, int yLast, int i, int j,
                            int height, int width, String figureOpponent){}` The QueenBlack function selects how the shape will go and moves it. If the selected move is placed on a black piece, an error window will appear.
            > **@param** ChessSquares (_an array of all buttons (squares)_)

            > **@param** chessImage (_an array of all pieces_)

            > **@param** myX (_X-coordinates where the figure is going_)

            > **@param** myY (_Y-coordinates where the figure is going_)

            > **@param** XLast (_X coordinates from where the shape is coming from_)

            > **@param** Ylast (_Y coordinates from where the shape is coming from_)

            > **@param** i (_determines the size of the array in x_)

            > **@param** j (_determines the size of the array in y_)

            > **@param** height (_of one square is used to move shapes in Y_)

            > **@param** width (_of one square is used to move shapes in X_)

            > **@param** figureOpponent (_contains the name of the square that we chose where we will go_) 
    * **QueenWhite** (_The QueenWhite class executes the white queen figure_)
        * function `public void QueenWhite(JButton[][] chessSquares, Image[][]chessImage,
                            int myX, int myY, int xLast, int yLast, int i, int j,
                            int height, int width, String figureOpponent){}` The QueenWhite function selects how the shape will go and moves it. If the selected move is placed on a black piece, an error window will appear.
            > **@param** ChessSquares (_an array of all buttons (squares)_)

            > **@param** chessImage (_an array of all pieces_)

            > **@param** myX (_X-coordinates where the figure is going_)

            > **@param** myY (_Y-coordinates where the figure is going_)

            > **@param** XLast (_X coordinates from where the shape is coming from_)

            > **@param** Ylast (_Y coordinates from where the shape is coming from_)

            > **@param** i (_determines the size of the array in x_)

            > **@param** j (_determines the size of the array in y_)

            > **@param** height (_of one square is used to move shapes in Y_)

            > **@param** width (_of one square is used to move shapes in X_)

            > **@param** figureOpponent (_contains the name of the square that we chose where we will go_)
    * **RookBlack** (_The RookBlack class executes the black rook figure_)
        * function `public void RookBlack(JButton[][] chessSquares, Image[][]chessImage,
                            int myX, int myY, int xLast, int yLast, int i, int j,
                            int height, int width, String figureOpponent){}` The RookBlack function selects how the shape will go and moves it. If the selected move is placed on a white piece, an error window will appear.
            > **@param** ChessSquares (_an array of all buttons (squares)_)

            > **@param** chessImage (_an array of all pieces_)

            > **@param** myX (_X-coordinates where the figure is going_)

            > **@param** myY (_Y-coordinates where the figure is going_)

            > **@param** XLast (_X coordinates from where the shape is coming from_)

            > **@param** Ylast (_Y coordinates from where the shape is coming from_)

            > **@param** i (_determines the size of the array in x_)

            > **@param** j (_determines the size of the array in y_)

            > **@param** height (_of one square is used to move shapes in Y_)

            > **@param** width (_of one square is used to move shapes in X_)

            > **@param** figureOpponent (_contains the name of the square that we chose where we will go_)
    * **RookWhite** (_The RookWhite class executes the white rook figure_)
        * function `public void RookWhite(JButton[][] chessSquares, Image[][]chessImage,
                            int myX, int myY, int xLast, int yLast, int i, int j,
                            int height, int width, String figureOpponent){}` The RookWhite function selects how the shape will go and moves it. If the selected move is placed on a black piece, an error window will appear.
            > **@param** ChessSquares (_an array of all buttons (squares)_)

            > **@param** chessImage (_an array of all pieces_)

            > **@param** myX (_X-coordinates where the figure is going_)

            > **@param** myY (_Y-coordinates where the figure is going_)

            > **@param** XLast (_X coordinates from where the shape is coming from_)

            > **@param** Ylast (_Y coordinates from where the shape is coming from_)

            > **@param** i (_determines the size of the array in x_)

            > **@param** j (_determines the size of the array in y_)

            > **@param** height (_of one square is used to move shapes in Y_)

            > **@param** width (_of one square is used to move shapes in X_)

            > **@param** figureOpponent (_contains the name of the square that we chose where we will go_)
* **Move**(_I use the Move class to define the square that the shape will go to. Select the square by pressing the right mouse button_)
    * function `public void move(JButton[][] chessSquares, Image[][] chessImage, int length){}` The Move function determines the square the figure will move to. I also find out the size of the square and its name and transfer all this to the Logic class
        >**@param** chessSquares(_an array of all buttons (squares)_)

        >**@param** chessImage(_an array of all pieces_)

        >**@param** length(_determines the size of the array_)

        >**@param** textGame(_Will contain the whole game in pgn format_)
* **NewGame**(_The NewGame class arranges the figures when the New game key is pressed which is located in the ToolBar_)
    * function `public final void newGame(JLabel message, JButton[][] chessSquares,
                             Image[][] chessImage, int[] ROW){}` The NewGame function places pieces on the chessboard. Figures takes from the Row array
        > **@param** message (_Changes the message in the ToolBar_)

        > **@param** chessSquares (_an array of all buttons (squares)_)

        > **@param** chessImage (_an array of all pieces_)

        > **@param** ROW (_The array with which I choose which shapes to put on the board_)
* **Restore**(_The Restore class Reopens the board and removes the old figures from the board_)
    * function `public final void restoreGame(JLabel message, ActionEvent e)` The restoreGame function has an argument of -1, thus the code in the Main class starts the second window
        >**@param** message (_Changes the message in the ToolBar_) 
        >**@param** e (_empty_)
## ~~Interfaces used~~:
* **~~Figure~~**
    ~~* `SquaresCoordinates` SquaresCoordinates are the same for all figures. Returns the currently occupied square~~
    ~~* `SquaresCoordinates[] way(SquaresCoordinates source, SquaresCoordinates dest)` The _source_ parameter is figure coordinates, the _dest_ parameter is coordinates of possible steps of the figure. Returns a list of possible steps~~
    ~~* `default String icon()` Returns the name of the figure and from which class we call it~~
    ~~* `Figure copy(SquaresCoordinates dest)` The _dest_ parameter is the new coordinates. Return creates a new instance of an object with the value dest~~

## ~~Enums used~~:
* ~~**SquaresCoordinates**~~
    * ~~enum `SquaresCoordinates` Adjusts coordinates~~

