'use strict';
var env = require('../env');
var Backbone = require("backbone");
var _ = require('underscore');
var ListItem = require('../models/target-list-item');


var List = Backbone.Collection.extend({
    model: ListItem,

    url: env.API_BASE + '/shopping-list',

    initialize: function(models, options) {
        this.id = options.id;
    },

    batch: function(options) {
        // Prepare the models to go to the server.
        var shoppingListId = this.id;
        var items = this.map(function(model) {
            var item = model.pick(_.keys(model.defaults));
            item.shoppingListId = shoppingListId;
            return item;
        });

        var opts = _.extend({
            data: JSON.stringify(items),
            contentType: 'application/json',
            url: this.url
        }, options)
        this.sync('create', this, opts);
    }
});

module.exports = List;