var Kalah = (function() {

    var config;
    var pits = {};
    var player1, player2;

    /**
     * Starts the game
     */
    function startGame() {
        createPlayers();
        initPits();
        console.log(pits);
    }

    /**
     * Creates Players
     */
    function createPlayers() {
        player1 = new Player(config.player1Name, 0);
        player1.isActive = true;
        player2 = new Player(config.player2Name, 1);
        Render.setActivePlayerLabel(player1.name);
    }

    /**
     * Initialize pits
     * Set to global var pits and add initial stones
     */
    function initPits() {
        //Add top pits
        pits["topPits"] = {};
        pits["bottomPits"] = {};
        for (var i = 1; i <= config.pitNumber; i++) {
            //Create player pits
            var p1Pit = createPit(i, player1, false, pits.topPits);
            var p2Pit = createPit(i, player2, false, pits.bottomPits);
            //Draws Stones to top and bottom pits
            drawStonesToPit(pits.topPits[p1Pit.getPitDomId()], i);
            drawStonesToPit(pits.bottomPits[p2Pit.getPitDomId()], i*2);
        }
        //Create Kalah Pits
        var kalahPitIndex = config.pitNumber + 1;
        createPit(kalahPitIndex, player1, true, pits.topPits);
        createPit(kalahPitIndex, player2, true, pits.bottomPits);
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
    function createPit(pitIndex, player, isKalah, pitPlacement) {
        var playerPit = new Pit(pitIndex, player, isKalah, function(pit) {
            console.log(pit.id);
            player2.isActive = true;
            player1.isActive = false;
            deactivatePits(pits.topPits);
            activatePits(pits.bottomPits);
        });
        pitPlacement[playerPit.getPitDomId()] = playerPit.getDomElement();
        return playerPit;
    }

    //TODO - Check FUnction
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
    function drawStonesToPit(pitPlacement, stoneGroupId) {
        var currentStone;
        for (var stoneIndex = 0; stoneIndex < config.stoneNumber; stoneIndex++) {
            var stoneId = stoneGroupId * config.stoneNumber + stoneIndex;
            currentStone = new Stone(stoneId);
            pitPlacement.appendChild(Render.createStone(stoneId));
        }
    }

    return {
        start: function(_config) {
            config = _config;
            startGame();
        }
    }
})();