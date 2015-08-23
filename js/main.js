var Backbone = require('backbone');
var List = require('collections/list-items');
var data = require('./../items.json');
var items = new List(data);
module.exports = items;
