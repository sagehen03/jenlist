var $ = require('jquery');
var Backbone = require('backbone');
Backbone.$ = $;
var MasterListCollection = require('./collections/master-list');
var ListsCollection = require('./collections/lists');

var MasterListView = require('./views/master-list');
var NewMasterListItem = require('./views/new-master-list-item');
var ManageView = require('./views/manage');
var ListsView = require('./views/lists');

// Create the shared collection.
var mlCollection = new MasterListCollection();

var masterListView = new MasterListView({
    collection: mlCollection
});

var listsView = new ListsView({
    collection: new ListsCollection()
});

var manageView = new ManageView({
    collection: mlCollection
})


$('#master-list').append(masterListView.el);
masterListView.render();

$('#manage-items').append(manageView.el);
manageView.render();

 $('#lists').append(listsView.el);
 listsView.render();
