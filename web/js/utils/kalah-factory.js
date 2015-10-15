var KalahFactory = (function () {

    /**
     * Builds a state object from game parameters
     * ready for rest transportation
     * @param pits
     * @param players
     * @param activePlayer
     * @param currentPit
     * @returns {{}}
     */
    this.buildStateObject = function (pits, players, activePlayer, currentPit) {
        var stateObject = {};
        var pitsState = [];
        var playersState = [];
        /**
         * Build Pits state object
         */
        pits.forEach(function (pit) {
            var currentPit = {};
            currentPit["id"] = pit.id;
            currentPit["stones"] = pit.stones.length;
            currentPit["is_kalah"] = pit.isKalah;
            currentPit["player_id"] = pit.player.id;
            currentPit["id"] = pit.id;
            pitsState.push(currentPit);
        });
        /**
         * Build Players state object
         */
        players.forEach(function (player) {
            playersState.push(player);
        });
        /**
         * Set other states
         */
        stateObject["pits"] = pitsState;
        stateObject["players"] = playersState;
        stateObject["active_player"] = activePlayer.id;
        stateObject["current_pit"] = currentPit.id;
        return stateObject;
    };

    return {
        buildStateObject: function(pits, players, activePlayer, currentPit) {
            return buildStateObject(pits, players, activePlayer, currentPit);
        }
    }
})();