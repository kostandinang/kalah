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
        initHouses();
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
            if (!isKalah) {
                sowSeedsToHouse(p1House);
                sowSeedsToHouse(p2House);
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
    function createHouse(houseIndex, player, isKalah) {
        var playerHouse = new House(houseIndex, player, isKalah);
        houses.push(playerHouse);
        /**
         * Add house mouse listener
         */
        playerHouse.addMouseListener(function (house) {
            console.log(house.id);
            currentHouse = house;
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
    function sowSeedsToHouse(house) {
        var houseDomElement;
        var seedIndicatorElement;
        houseDomElement = house.getDomElement();
        //Add seeds
        for (var i = 0; i < config.seedNumber; i++) {
            house.addSeed();
        }
        seedIndicatorElement = Render.createHouseSeedIndicator(houseDomElement, house.getSeeds());
        houseDomElement.appendChild(Render.createSeedElement());
        houseDomElement.appendChild(seedIndicatorElement);
    }

    return {
        start: function (_config) {
            config = _config;
            startGame();
        }
    }
})();