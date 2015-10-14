var rest = (function() {

    /**
     * Next Move Function
     * @param gameConfig
     */
    function nextMove(gameConfig) {
        Ajax.post(Constants.URL, JSON.stringify(gameConfig),
            function() {
                console.log("Success");
            },
            function(e) {
                console.error("Error");
                alert(Constants.ERROR_MESSAGE + " " + e);
            }
        )
    }

    function buildBorderConfigurationObject (pits, players, nextMove) {
        var pitsConfig = [];
        //Pits
        pits.forEach(function(pit) {
            var pitConfig = {};
            pitConfig["id"] = pit.id;
            pitsConfig.push(pitConfig);
        });
    }

    return {
        nextMove: function(callback) {
            nextMove();
        }
    };
})();