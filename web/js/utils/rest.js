var Rest = (function() {

    /**
     * Next Move Function
     * @param gameConfig
     */
    function getNextGameState(stateObject, success, error) {
        var param = {};
        param["game_state"] = JSON.stringify(stateObject);
        Ajax.post(Constants.REST_URL, param,
            function(response) {
                if (success) success(response);
            },
            function(response) {
                if (error) error(response);
            }
        )
    }

    return {
        getNextGameState: function(stateObject, success, error) {
            getNextGameState(stateObject, success, error);
        }
    };
})();