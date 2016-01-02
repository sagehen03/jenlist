var $ = require('jquery');
var Backbone = require('backbone');
global.jQuery = $;
require('bootstrap');
Backbone.$ = $;
var MasterList = require('../js/collections/master-list');
var ListCollection = require('../js/collections/shopping-lists');

var ShoppingListSelectorView = require('../js/views/shopping-list-selector');
var MlView = require('../js/views/master-list');
var ShoppingListView = require('../js/views/shopping-list');
var ShoppingListCollection = require('../js/collections/shopping-list');
var AddItemView = require('../js/views/add-item');
var MasterListControls = require('../js/views/master-list-controls');
var FilterView = require('../js/views/filter-master-list');
var Categories = require('../js/collections/categories');

$( function (){
    if (!String.prototype.startsWith) {
        String.prototype.startsWith = function(searchString, position) {
            position = position || 0;
            return this.indexOf(searchString, position) === position;
        };
    }
    var listCollection = new ListCollection();
    new ShoppingListView({collection: new ShoppingListCollection()});
    var tView = new ShoppingListSelectorView({collection: listCollection});
    var masterList = new MasterList();
    var view = new MlView({collection: masterList});
    new MasterListControls();
    new FilterView();
    var aiView = new AddItemView({collection: new Categories(), attributes: {masterListColl: masterList}});
});


