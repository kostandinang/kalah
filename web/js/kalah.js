var Kalah = (function() {

    var config;
    var pitsNodes = [];
    var pits = [];
    var player1, player2;
    var activePlayer;
    var currentPit;
    var winner = null;

    /**
     * Starts the game
     */
    function startGame() {
        createPlayers();
        initPits();
        console.log(pitsNodes);
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
     * Initialize pits
     * Set to global var pits and add initial stones
     */
    function initPits() {
        var isKalahPit = false;
        var p2PitId = 0;
        for (var i = 1; i <= config.pitNumber + 1; i++) {
            //Create player pits
            isKalahPit = (i == config.pitNumber + 1);
            p2PitId = config.pitNumber + 1 + i;
            var p1Pit = createPit(i, player1, isKalahPit);
            var p2Pit = createPit(p2PitId, player2, isKalahPit);
            //Draws Stones to top and bottom pits
            if (!isKalahPit) {
                addStonesToPit(p1Pit, i);
                addStonesToPit(p2Pit, i*2);
            }
        }
    }

    /**
     * Creates a new pit and places it top or
     * bottom based on player
     * @param pitIndex
     * @param playerx
     * @param isKalah
     * @param pitPlacement
     * @returns {Pit}
     */
    function createPit(pitIndex, player, isKalah) {
        var playerPit = new Pit(pitIndex, player, isKalah);
        pits.push(playerPit);
        /**
         * Add pit mouse listener
         */
        playerPit.addMouseListener(function(pit) {
            console.log(pit.id);
            currentPit = pit;
            activePlayer = currentPit.player;
            /**
             * Next Move
             */
            Rest.getNextGameState(KalahFactory.buildStateObject(pits, [player1, player2], activePlayer, currentPit));
            /*deactivatePits(pits.topPits);
             activatePits(pits.bottomPits);*/
        });
        return playerPit;
    }

    //TODO - Check
    function activatePits(player) {
        for (var key in pitPlacement) {
            var pit = pitPlacement[key];
            if (!pit.isKalah & !pit.isEmpty()) {
                pit.addEventListener();
            }
        }
    }

    /**
     * Add stones to top and bottom pit
     * @param topPit
     * @param bottomPit
     */
    function addStonesToPit(pit, stoneGroupId) {
        var currentStone;
        for (var stoneIndex = 0; stoneIndex < config.stoneNumber; stoneIndex++) {
            var stoneId = stoneGroupId * config.stoneNumber + stoneIndex;
            currentStone = new Stone(stoneId);
            pit.addStone(currentStone);
            pit.getDomElement().appendChild(Render.createStone(stoneId));
        }
    }

    return {
        start: function(_config) {
            config = _config;
            startGame();
        }
    }
})();