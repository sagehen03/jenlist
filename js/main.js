var $ = require('jquery');
var Backbone = require('backbone');
Backbone.$ = $;
var MasterList = require('views/master-list');
new MasterList();
//var Items = require('collections/master-list');
//var items = new Items();
//items.fetch({
//    success: function () {
//        var masterList = new MasterList({collection: items});
//        masterList.render();
//    }
//});


