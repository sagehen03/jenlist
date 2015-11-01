var $ = require('jquery');
var Backbone = require('backbone');
Backbone.$ = $;
var MasterList = require('../js/collections/master-list');
var ListCollection = require('../js/collections/target-lists');
var Item = require('../js/models/master-list-item');
var collection = new MasterList();
collection.add(new Item({name: 'potatoes'}));
collection.add(new Item({name: 'squash'}));
collection.add(new Item({name: 'onions'}));
collection.add(new Item({name: 'peppers'}));
collection.add(new Item({name: 'kale'}));
$( function (){
    var MlView = require('../js/views/master-list');
    var TargetListView = require('../js/views/master-list-selector');
    var tView = new TargetListView({collection: new ListCollection()});
    tView.render();

    var view = new MlView({collection: collection});
    view.render();
});


