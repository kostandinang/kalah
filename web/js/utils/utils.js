/**
 * Utilizing functions
 * @type {{byId, hideElement, showElement}}
 */
var Utils = (function() {

    function byId(id) {
        return document.getElementById(id);
    }

    function hideElement(el) {
        if (el) el.style.display = "none";
    }

    function showElement(el) {
        if (el) el.style.display = "block";
    }

    return {
        byId: function(id) {
            return byId(id);
        },
        hideElement: function(el) {
            hideElement(el);
        },
        showElement: function(el) {
            showElement(el);
        }
    }
})();