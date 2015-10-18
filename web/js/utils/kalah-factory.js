var KalahFactory = (function () {

    /**
     * Builds a state object from game parameters
     * ready for rest transportation
     * @param houses
     * @param players
     * @param activePlayer
     * @param currentHouse
     * @returns {{}}
     */
    this.buildStateObject = function (houses, players, activePlayer, currentHouse) {
        var stateObject = {};
        var houseState = [];
        var playersState = [];
        /**
         * Build Houses state object
         */
        houses.forEach(function (house) {
            var currentHouse = {};
            currentHouse["id"] = house.id;
            currentHouse["seeds"] = house.getSeeds();
            currentHouse["is_kalah"] = house.isKalah;
            currentHouse["player_id"] = house.player.id;
            houseState.push(currentHouse);
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
        stateObject["houses"] = houseState;
        stateObject["players"] = playersState;
        stateObject["active_player"] = activePlayer.id;
        stateObject["current_house"] = currentHouse.id;
        return stateObject;
    };

    return {
        buildStateObject: function(houses, players, activePlayer, currentHouse) {
            return buildStateObject(houses, players, activePlayer, currentHouse);
        }
    }
})();