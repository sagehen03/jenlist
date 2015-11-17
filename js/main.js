var $ = require('jquery');
var Backbone = require('backbone');
Backbone.$ = $;
var MasterList = require('../js/collections/master-list');
var ListCollection = require('../js/collections/shopping-lists');

var TargetSelectorView = require('../js/views/shopping-list-selector');
var MlView = require('../js/views/master-list');
var TargetListView = require('../js/views/shopping-list');
var ShoppingListCollection = require('../js/collections/shopping-list');
var AddItemView = require('../js/views/add-item');
var Categories = require('../js/collections/categories');

$( function (){
    var listCollection = new ListCollection();
    var targetList = new TargetListView({collection: new ShoppingListCollection()});
    var tView = new TargetSelectorView({collection: listCollection});
    tView.render();
    var masterList = new MasterList();
    var view = new MlView({collection: masterList});
    var aiView = new AddItemView({collection: new Categories(), attributes: {masterListColl: masterList}});
});


