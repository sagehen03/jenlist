var $ = require('jquery');
var Backbone = require('backbone');
Backbone.$ = $;
var MasterList = require('../js/collections/master-list');
var ListCollection = require('../js/collections/target-lists');
var Item = require('../js/models/master-list-item');

var TargetSelectorView = require('../js/views/master-list-selector');
var MlView = require('../js/views/master-list');
var TargetListView = require('../js/views/target-list');
var TargetListCollection = require('../js/collections/target-list');
var AddItemView = require('../js/views/add-item');
var Categories = require('../js/collections/categories');

$( function (){
    var listCollection = new ListCollection();
    var targetList = new TargetListView({collection: new TargetListCollection()});
    var tView = new TargetSelectorView({collection: listCollection});
    tView.render();
    var masterList = new MasterList();
    var view = new MlView({collection: masterList});
    var aiView = new AddItemView({collection: new Categories(), attributes: {masterListColl: masterList}});
});


