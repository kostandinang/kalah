var Pit = function(id, player, isKalah, nextMoveCallback, moveExitCallback) {
    this.id = id;
    this.stones = [];
    this.player = player;
    this.isKalah = isKalah;
    this.nextMove = player.isActive;
    this.pitPlacement;
    /**
     * Add pit Mouse Listener
     */
    if (this.nextMove && !this.isEmpty()) {
        this.addMouseListener(nextMoveCallback);
    } else {
        this.removeMouseListener(moveExitCallback)
    }
};

Pit.prototype.addStone = function(stone) {
    this.stones.push(stone);
};

Pit.prototype.isKalah = function() {
    return this.isKalah;
};

Pit.prototype.isEmpty = function() {
    return this.stones.length > 0;
};

Pit.prototype.getPitDomId = function() {
    var idPrefix = (this.player.number == 0) ? "tp" : "bp";
    return idPrefix + this.id;
};

Pit.prototype.getDomElement = function() {
    return Utils.byId(this.getPitDomId());
};

Pit.prototype.addMouseListener = function(clickCallback) {
    if (!this.isKalah) {
        this.getDomElement().addEventListener("click", function() {
            clickCallback(this);
        })
    }
};

Pit.prototype.removeMouseListener = function(clickCallback) {
    if (!this.isKalah) {
        this.getDomElement().removeEventListener("click", function() {
            clickCallback(this);
        })
    }
};