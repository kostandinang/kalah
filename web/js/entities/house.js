/**
 * Game House
 * @param id
 * @param player
 * @param isKalah
 * @constructor
 */
var House = function(id, player, isKalah) {
    this.id = id;
    this.seeds = 0;
    this.player = player;
    this.isKalah = isKalah;
};

House.prototype.getSeeds = function() {
    return this.seeds;
};

House.prototype.addSeed = function() {
    ++this.seeds;
};

House.prototype.emptySeeds = function() {
    this.seeds = 0;
};

House.prototype.setSeeds = function(seeds) {
    this.seeds = seeds;
    if (seeds == 0) {
        Utils.hideElement(this.getSeedElement());
    } else {
        Utils.showElement(this.getSeedElement());
    }
    this.getSeedIndicatorElement().innerHTML = seeds;
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

House.prototype.getSeedElement = function() {
    return this.getDomElement().firstElementChild;
};

House.prototype.getSeedIndicatorElement = function() {
    return this.getDomElement().lastElementChild;
};

House.prototype.addMouseListener = function(clickCallback) {
    var self = this;
    if (!this.isKalah) {
        this.getDomElement().addEventListener("click", function() {
            clickCallback(self);
        })
    }
};