var Utils = (function() {

    /**
     * Gets element by Id
     * @param id
     * @returns {Element}
     */
    function byId(id) {
        return document.getElementById(id);
    }

    return {
        byId: function(id) {
            return byId(id);
        }
    }
})();