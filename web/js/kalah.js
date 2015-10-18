var Kalah = (function () {

    var config;
    var houseNodes = [];
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
        initPits();
        console.log(houseNodes);
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
    function initPits() {
        var isKalahPit = false;
        var p2PitId = 0;
        for (var i = 1; i <= config.seedNumber + 1; i++) {
            //Create player houses
            isKalahPit = (i == config.seedNumber + 1);
            p2PitId = config.seedNumber + 1 + i;
            var p1Pit = createPit(i, player1, isKalahPit);
            var p2Pit = createPit(p2PitId, player2, isKalahPit);
            //Draws Stones to top and bottom houses
            if (!isKalahPit) {
                sowSeedsToHouse(p1Pit, i);
                sowSeedsToHouse(p2Pit, i * 2);
            }
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
    function createPit(houseIndex, player, isKalah) {
        var playerHouse = new House(houseIndex, player, isKalah);
        houses.push(playerHouse);
        /**
         * Add house mouse listener
         */
        playerHouse.addMouseListener(function (pit) {
            console.log(pit.id);
            currentHouse = pit;
            activePlayer = currentHouse.player;
            /**
             * Next Move
             */
            Rest.getNextGameState(KalahFactory.buildStateObject(houses, [player1, player2], activePlayer, currentHouse));
            /*deactivatePits(houses.topPits);
             activateHouses(houses.bottomPits);*/
        });
        return playerHouse;
    }

    //TODO - Check
    function activateHouses(player) {
        for (var key in pitPlacement) {
            var pit = pitPlacement[key];
            if (!pit.isKalah & !pit.isEmpty()) {
                pit.addEventListener();
            }
        }
    }

    /**
     * Add seeds to top and bottom house
     * @param house
     * @param seedGroupId
     */
    function sowSeedsToHouse(house, seedGroupId) {
        var currentSeed;
        for (var seedIndex = 0; seedIndex < config.houseNumber; seedIndex++) {
            var stoneId = seedGroupId * config.houseNumber + seedIndex;
            currentSeed = new Seed(stoneId);
            house.addSeed(currentSeed);
        }
        house.getDomElement().appendChild(Render.createSeedElement(stoneId));
    }

    return {
        start: function (_config) {
            config = _config;
            startGame();
        }
    }
})();