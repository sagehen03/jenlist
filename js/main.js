var $ = require('jquery');
var Backbone = require('backbone');
Backbone.$ = $;
var List = require('collections/list-items');
console.log("Getting ready to fetch again!!");
var l = new List();
l.fetch({success: function(){
    console.log(l.last().toJSON()); // => 2 (collection have been populated)
}});


