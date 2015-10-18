var Kalah = (function () {

    var config;
    var houses = [];
    var player1, player2;
    var activePlayer;
    var currentHouse;
    var winner = null;

    /**
     * Starts the game
     */
    function startGame() {
        createPlayers();
        initHouses();
    }

    /**
     * Creates Players
     */
    function createPlayers() {
        player1 = new Player(config.player1Name, 0);
        player2 = new Player(config.player2Name, 1);
        activePlayer = player1;
        Render.setActivePlayerLabel(activePlayer.name);
    }

    /**
     * Initialize houses
     * Set to global var houses and add initial seeds
     */
    function initHouses() {
        var isKalah = false;
        var p2HouseId = 0;
        for (var i = 1; i <= config.houseNumber + 1; i++) {
            //Create player houses
            isKalah = (i == config.houseNumber + 1);
            p2HouseId = config.houseNumber + 1 + i;
            var p1House = createHouse(i, player1, isKalah);
            var p2House = createHouse(p2HouseId, player2, isKalah);
            //Draws Stones to top and bottom houses
            sowInitialSeedsToHouse(p1House, isKalah);
            sowInitialSeedsToHouse(p2House, isKalah);
        }
    }

    /**
     * Creates a new house and places it top or
     * bottom based on player
     * @param houseIndex
     * @param playerx
     * @param isKalah
     * @returns {House}
     */
    function createHouse(houseIndex, player, isKalah) {
        var playerHouse = new House(houseIndex, player, isKalah);
        houses.push(playerHouse);
        /**
         * Activate houses for current Plyer
         */
        if (player == activePlayer) {
            Render.setActiveHouse(playerHouse.getDomElement());
        }
        /**
         * Add house mouse listener
         */
        playerHouse.addMouseListener(function (house) {
            if (isHouseActive(house)) {
                currentHouse = house;
                activePlayer = currentHouse.player;
                /**
                 * Get Next Game State
                 */
                var gameState = KalahFactory.buildGameRequestObject(houses, [player1, player2], activePlayer, currentHouse);
                Rest.getNextGameState(
                    gameState,
                    function(response) {
                        updateGameState(response);
                    }
                );
            }
        });
        return playerHouse;
    }

    /**
     * Add seeds to top and bottom house
     * @param house
     * @param seedGroupId
     */
    function sowInitialSeedsToHouse(house, isKalah) {
        var houseDomElement;
        var seedIndicatorElement;
        houseDomElement = house.getDomElement();
        if (!isKalah) {
            //Add seeds
            for (var i = 0; i < config.seedNumber; i++) {
                house.addSeed();
            }
            seedIndicatorElement = Render.createHouseSeedIndicator(houseDomElement, house.getSeeds());
            houseDomElement.appendChild(Render.createSeedElement());
        } else {
            seedIndicatorElement = Render.createHouseSeedIndicator(houseDomElement, 0);
        }
        houseDomElement.appendChild(seedIndicatorElement);
    }

    /**
     * Sows seed to house
     * @param house
     * @param seeds
     */
    function sowSeedsToHouse(house, seeds) {
        house.setSeeds(seeds);
    }

    /**
     * Updates game state, houses, players, checks for winners and messages
     * @param gameResponse
     */
    function updateGameState(gameResponse) {
        gameResponse = JSON.parse(gameResponse);
        var gameResponse = KalahFactory.buildGameResponseObject(gameResponse);
        console.log(gameResponse);
    }

    /**
     * Updates current Player based on player id
     * @param playerId
     * @returns {*}
     */
    function setCurrentPlayer(playerId) {
        return (playerId == 0) ? player1 : player2;
    }

    /**
     * Checks if house is active
     * @param house
     * @returns {*}
     */
    function isHouseActive(house) {
        return Render.hasActiveAttribute(house.getDomElement());
    }

    return {
        start: function (_config) {
            config = _config;
            startGame();
        }
    }
})();