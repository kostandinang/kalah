var Render = (function() {

    /**
     * Creates a stone element node
     * @returns {Element}
     */
    function createStone(id) {
        var stoneNode = document.createElement("div");
        stoneNode.setAttribute("class", Constants.STONE_CLASS);
        stoneNode.setAttribute("id", Constants.STONE_ID_PREFIX + id);
        return stoneNode;
    }

    /**
     * Sets Active Player Label
     * @param playerName
     */
    function setActivePlayerLabel(playerName) {
        Utils.byId(Constants.PLAYER_TURN_LABEL).innerHTML = playerName;
    }

    return {
        createStone: function(id) {
            return createStone(id);
        },
        setActivePlayerLabel: function(name) {
            setActivePlayerLabel(name);
        }
    }
})();