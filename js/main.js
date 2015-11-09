var $ = require('jquery');
var Backbone = require('backbone');
Backbone.$ = $;
var MasterList = require('../js/collections/master-list');
var ListCollection = require('../js/collections/target-lists');
var Item = require('../js/models/master-list-item');
var collection = new MasterList();

var TargetSelectorView = require('../js/views/master-list-selector');
var MlView = require('../js/views/master-list');
var TargetListView = require('../js/views/target-list');
var TargetListCollection = require('../js/collections/target-list');

collection.add(new Item({name: 'potatoes'}));
collection.add(new Item({name: 'squash'}));
collection.add(new Item({name: 'onions'}));
collection.add(new Item({name: 'peppers'}));
collection.add(new Item({name: 'kale'}));
$( function (){
    var listCollection = new ListCollection();
    var targetList = new TargetListView({collection: new TargetListCollection()});
    var tView = new TargetSelectorView({collection: listCollection});
    tView.render();
    var view = new MlView({collection: collection});
    view.render();

});


