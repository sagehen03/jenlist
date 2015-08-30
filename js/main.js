var $ = require('jquery');
var Backbone = require('backbone');
Backbone.$ = $;
var MasterList = require('./views/master-list');
var NewMasterListItem = require('./views/new-master-list-item');
var ml = new MasterList();
new NewMasterListItem({masterCollection: ml.collection});


