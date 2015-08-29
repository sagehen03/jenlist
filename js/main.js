var $ = require('jquery');
var Backbone = require('backbone');
Backbone.$ = $;
var MasterList = require('views/master-list');
//var MasterListItem = require('models/master-list-item');
var ml = new MasterList();
//var newItem = new MasterListItem({name:"razor blades"});
//newItem
ml.collection.create({name:"razor blades"}, {wait:true});
//var Items = require('collections/master-list');
//var items = new Items();
//items.fetch({
//    success: function () {
//        var masterList = new MasterList({collection: items});
//        masterList.render();
//    }
//});


