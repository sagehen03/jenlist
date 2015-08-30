'use strict';
var env = require('../env');
var Backbone = require("backbone");
var _ = require('underscore');
var ListItem = require('../models/list-item');

var List = Backbone.Collection.extend({
    model: ListItem,
    url: env.API_BASE + '/items',

    batch: function(options) {
        // Prepare the models to go to the server.
        var shoppingListId = this.id;
        var items = this.map(function(model) {
            var item = model.pick(_.keys(model.defaults));
            item.shoppingListId = shoppingListId;
            return item;
        })

        var opts = _.extend({
            data: items,
            url: this.url(),
            contentType: 'application/json'
        }, options)

        this.sync('create', this, opts);
    }
});

module.exports = List;