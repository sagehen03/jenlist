var $ = require('jquery');
var Backbone = require('backbone');
Backbone.$ = $;
var Collection = require('../js/collections/new-master-list');
var Item = require('../js/models/new-master-list-item');
var collection = new Collection();
collection.add(new Item({name: 'potatoes'}));
collection.add(new Item({name: 'squash'}));
collection.add(new Item({name: 'onions'}));
collection.add(new Item({name: 'peppers'}));
collection.add(new Item({name: 'kale'}));
$( function (){
    var MlView = require('../js/views/new-master-list');

    var view = new MlView({collection: collection});
    view.render();
});


