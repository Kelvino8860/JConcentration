You set up the card game Concentration by placing pairs of cards face down in a
grid. The player turns up two cards at a time, exposing their values. If the cards
match, they are removed from the grid. If the cards do not match, they are turned
back over so their values are hidden again, and the player selects two more cards to
expose. Using the knowledge gained by the previously exposed cards, the player
attempts to remove all the pairs of cards from play. Create a Java version of this
game using a GridLayout that is four rows high and five columns wide. Randomly
assign two of the numbers 0 through 9 to each of 20 JPanels, and place each of the
20 JPanels in a cell of the grid. Initially, show only “backs” of cards by setting each
panel’s background to a solid color. When the user clicks a first card, change its
color and expose its value. After the user clicks a second card, change its color to
the same color as the first exposed card, expose the second card’s value, and keep
both cards exposed until the user’s mouse pointer exits the second card. If the two
exposed cards are different, hide the cards again. If the two turned cards match, then
“remove” the pair from play by setting their background colors to white. When the user
has matched all 20 cards into 10 pairs, display a congratulatory message. Save the game
as JConcentration.java