/**
 * Response structure from server
 * @param houses
 * @param currentPlayer
 * @param winner
 * @param message
 * @constructor
 */
var GameResponse = function(houses, currentPlayer, winner, message) {
    this.houses = houses;
    this.currentPlayer = currentPlayer;
    this.winner = winner;
    this.message = message;
};