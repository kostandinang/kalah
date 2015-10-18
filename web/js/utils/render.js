var Render = (function() {

    /**
     * Creates a stone element node
     * @returns {Element}
     */
    function createSeedElement(id) {
        var stoneNode = document.createElement("div");
        stoneNode.setAttribute("class", Constants.SEED_CLASS);
        stoneNode.setAttribute("id", Constants.SEED_ID_PREFIX + id);
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
        createSeedElement: function(id) {
            return createSeedElement(id);
        },
        setActivePlayerLabel: function(name) {
            setActivePlayerLabel(name);
        }
    }
})();