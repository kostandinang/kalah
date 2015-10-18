var House = function(id, player, isKalah) {
    this.id = id;
    this.seeds = [];
    this.player = player;
    this.isKalah = isKalah;
    this.housePlacement;
};

House.prototype.addSeed = function(stone) {
    this.seeds.push(stone);
};

House.prototype.isKalah = function() {
    return this.isKalah;
};

House.prototype.isEmpty = function() {
    return this.seeds.length > 0;
};

House.prototype.getHouseDomId = function() {
    return Constants.HOUSE_ID_PREFIX + this.id;
};

House.prototype.getDomElement = function() {
    return Utils.byId(this.getHouseDomId());
};

House.prototype.addMouseListener = function(clickCallback) {
    var self = this;
    if (!this.isKalah) {
        this.getDomElement().addEventListener("click", function() {
            clickCallback(self);
        })
    }
};

House.prototype.removeMouseListener = function(clickCallback) {
    var self = this;
    if (!this.isKalah) {
        this.getDomElement().removeEventListener("click", function() {
            clickCallback(self);
        })
    }
};