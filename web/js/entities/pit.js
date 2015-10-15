var Pit = function(id, player, isKalah) {
    this.id = id;
    this.stones = [];
    this.player = player;
    this.isKalah = isKalah;
    this.pitPlacement;
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
    return "pit-" + this.id;
};

Pit.prototype.getDomElement = function() {
    return Utils.byId(this.getPitDomId());
};

Pit.prototype.addMouseListener = function(clickCallback) {
    var self = this;
    if (!this.isKalah) {
        this.getDomElement().addEventListener("click", function() {
            clickCallback(self);
        })
    }
};

Pit.prototype.removeMouseListener = function(clickCallback) {
    var self = this;
    if (!this.isKalah) {
        this.getDomElement().removeEventListener("click", function() {
            clickCallback(self);
        })
    }
};