var Render = (function() {

    /**
     * Creates a stone element node
     * @returns {Element}
     */
    function createSeedElement() {
        var stoneNode = document.createElement("div");
        stoneNode.setAttribute("class", Constants.SEED_CLASS);
        return stoneNode;
    }

    /**
     * Creates house dom element
     * @param id
     * @returns {Element}
     */
    function createHouseElement(id) {
        var houseNode = document.createElement("div");
        houseNode.setAttribute("id", Constants.HOUSE_ID_PREFIX + id);
        return houseNode;
    }

    /**
     * Creates a node which shows seed number for the house
     * @param houseNode
     * @param numberOfSeeds
     * @returns {Element}
     */
    function createHouseSeedIndicator(houseNode, numberOfSeeds) {
        var seedIndicatorNode = document.createElement("div");
        seedIndicatorNode.setAttribute("class", Constants.SEED_NUMBER);
        seedIndicatorNode.innerHTML = numberOfSeeds || 0;
        houseNode.appendChild(seedIndicatorNode);
        return seedIndicatorNode;
    }

    /**
     * Sets house attribute as active
     * @param houseNode
     */
    function setActiveHouse(houseNode) {
        if (houseNode) houseNode.setAttribute("active", "active");
    }

    /**
     * Removes house attribute as active
     * @param houseNode
     */
    function removeActiveHouse(houseNode) {
        if (houseNode) houseNode.removeAttribute("active");
    }

    /**
     * Checks if node has active attribute
     * @param houseNode
     * @returns {boolean}
     */
    function hasActiveAttribute(houseNode) {
        return (houseNode.getAttribute("active"));
    }

    /**
     * Sets Active Player Label
     * @param playerName
     */
    function setActivePlayerLabel(playerName) {
        Utils.byId(Constants.PLAYER_TURN_LABEL).innerHTML = playerName;
    }

    return {
        createHouseElement: function(id) {
            return createHouseElement(id);
        },
        createHouseSeedIndicator: function(houseNode, numberOfSeeds) {
            return createHouseSeedIndicator(houseNode, numberOfSeeds);
        },
        createSeedElement: function() {
            return createSeedElement();
        },
        setActivePlayerLabel: function(name) {
            setActivePlayerLabel(name);
        },
        setActiveHouse: function(houseNode) {
            setActiveHouse(houseNode);
        },
        removeActiveHouse: function(houseNode) {
            removeActiveHouse(houseNode);
        },
        hasActiveAttribute: function(houseNode) {
            return hasActiveAttribute(houseNode);
        }
    }
})();