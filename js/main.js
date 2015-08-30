var $ = require('jquery');
var Backbone = require('backbone');
Backbone.$ = $;
var MasterListView = require('./views/master-list');
var NewMasterListItem = require('./views/new-master-list-item');
var MasterListCollection = require('./collections/master-list');

// Create the shared collection.
var mlCollection = new MasterListCollection();

var masterListView = new MasterListView({
    collection: mlCollection
});
var addItemView = new NewMasterListItem({
    collection: mlCollection
});

$('#master-list').append(masterListView.el);
masterListView.render();

$('#add-item').append(addItemView.el);
addItemView.render();
