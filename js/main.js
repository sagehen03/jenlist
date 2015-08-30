var $ = require('jquery');
var Backbone = require('backbone');
Backbone.$ = $;
var MasterList = require('./views/master-list');
var NewMasterListItem = require('./views/new-master-list-item');


var masterListView = new MasterList();
var addItemView = new NewMasterListItem({masterCollection: masterListView.collection});

masterListView.render();
addItemView.render();

