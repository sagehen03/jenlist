var Backbone = require("backbone");
var ListItem = require('models/list-item');
var List = Backbone.Collection.extend({
    model: ListItem
});
console.log("Foo");
module.exports = List;