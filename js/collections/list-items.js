'use strict';
var env = require('../env');
var Backbone = require("backbone");
var _ = require('underscore');
var ListItem = require('../models/list-item');

var List = Backbone.Collection.extend({
    model: ListItem,
    url: env.API_BASE + '/items',

    initialize: function(){
        this.on('request', this.beginSync);
        this.on('sync', this.finishSync);
    },

    finishSync: function(){
        console.log("After sync");
    },

    beginSync: function(){
        console.log("Before sync");
    }
});

module.exports = List;