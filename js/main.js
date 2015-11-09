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

$( function (){
    var listCollection = new ListCollection();
    var targetList = new TargetListView({collection: new TargetListCollection()});
    var tView = new TargetSelectorView({collection: listCollection});
    tView.render();
    var view = new MlView({collection: new MasterList()});
});


